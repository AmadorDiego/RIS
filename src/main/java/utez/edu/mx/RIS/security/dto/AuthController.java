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
import utez.edu.mx.GDV.Usuarios.Model.Usuario;
import utez.edu.mx.GDV.Usuarios.Model.UsuarioRepository;
import utez.edu.mx.GDV.security.JwtUtil;
import utez.edu.mx.GDV.security.UserDetailsServiceImpl;
import utez.edu.mx.GDV.utils.Message;
import utez.edu.mx.GDV.utils.TypesResponse;

@RestController
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserDetailsServiceImpl userDetailsService;
    private final JwtUtil jwtUtil;
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager, UserDetailsServiceImpl userDetailsService, JwtUtil jwtUtil, UsuarioRepository usuarioRepository) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtUtil = jwtUtil;
        this.usuarioRepository = usuarioRepository;
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

        Usuario usuario = usuarioRepository.findByCorreoElectronico(authRequest.getCorreoElectronico())
                .orElseThrow(() -> new Exception("Usuario no encontrado"));

        long expirationTime = jwtUtil.getExpirationTime();
        AuthResponse authResponse = new AuthResponse(jwt, usuario.getId(), usuario.getCorreoElectronico(), expirationTime);

        return new ResponseEntity<>(new Message(authResponse,"Sesión iniciada correctamente. Bienvenido", TypesResponse.SUCCESS), HttpStatus.OK);
    }
}