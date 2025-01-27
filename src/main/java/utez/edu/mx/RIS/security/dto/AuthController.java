package utez.edu.mx.RIS.security.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import utez.edu.mx.RIS.Radiologo.model.Radiologo;
import utez.edu.mx.RIS.Radiologo.model.RadiologoRepository;
import utez.edu.mx.RIS.security.JwtUtil;
import utez.edu.mx.RIS.security.UserDetailsServiceImpl;
import utez.edu.mx.RIS.utils.Message;
import utez.edu.mx.RIS.utils.TypesResponse;

@RestController
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserDetailsServiceImpl userDetailsService;
    private final JwtUtil jwtUtil;
    private final RadiologoRepository radiologoRepository;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager, UserDetailsServiceImpl userDetailsService, JwtUtil jwtUtil, RadiologoRepository radiologoRepository) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtUtil = jwtUtil;
        this.radiologoRepository = radiologoRepository;
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody AuthRequest authRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getCorreoElectronico(), authRequest.getContrasena()));
        } catch (BadCredentialsException e) {
            return new ResponseEntity<>(new Message("Correo electrónico o contraseña incorrectos. Intentalo de nuevo", TypesResponse.ERROR), HttpStatus.BAD_REQUEST);
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getCorreoElectronico());
        final String jwt = jwtUtil.generateToken(userDetails);

        Radiologo usuario = radiologoRepository.findByCorreo(authRequest.getCorreoElectronico())
                .orElseThrow(() -> new Exception("Usuario no encontrado"));

        long expirationTime = jwtUtil.getExpirationTime();
        AuthResponse authResponse = new AuthResponse(jwt, usuario.getId(), usuario.getCorreo(), expirationTime);

        return new ResponseEntity<>(new Message(authResponse,"Sesión iniciada correctamente. Bienvenido", TypesResponse.SUCCESS), HttpStatus.OK);
    }
}