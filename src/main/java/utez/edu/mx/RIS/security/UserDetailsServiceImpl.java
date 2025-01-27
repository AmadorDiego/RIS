package utez.edu.mx.RIS.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import utez.edu.mx.RIS.Radiologo.model.Radiologo;
import utez.edu.mx.RIS.Radiologo.model.RadiologoRepository;

import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final RadiologoRepository radiologoRepository;

    @Autowired
    public UserDetailsServiceImpl(RadiologoRepository radiologoRepository) {
        this.radiologoRepository = radiologoRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String correoElectronico) throws UsernameNotFoundException {
        Radiologo usuario = radiologoRepository.findByCorreo(correoElectronico)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + correoElectronico));

        return new org.springframework.security.core.userdetails.User(
                usuario.getCorreo(),
                usuario.getContrasena(),
                usuario.getRoles().stream()
                        .map(rol -> new SimpleGrantedAuthority(rol.getRol()))
                        .collect(Collectors.toList())
        );
    }
}
