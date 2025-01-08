package utez.edu.mx.RIS.utils;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import utez.edu.mx.GDV.Usuarios.Model.Usuario;
import utez.edu.mx.GDV.Usuarios.Model.UsuarioRepository;
import utez.edu.mx.GDV.role.model.Rol;
import utez.edu.mx.GDV.role.model.RolRepository;

import java.util.Optional;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initDatabase(UsuarioRepository usuarioRepository, RolRepository rolRepository, PasswordEncoder passwordEncoder) {
        return args -> {

            Optional<Rol> optionalRol = rolRepository.findByRol("ADMINISTRADOR");
            if (!optionalRol.isPresent()) {
                Rol rolAdministrador = new Rol("ADMINISTRADOR");
                rolRepository.saveAndFlush(rolAdministrador);

                Optional<Usuario> optionalUsuario = usuarioRepository.findByCorreoElectronico("20233tn077@utez.edu.mx");
                if (!optionalUsuario.isPresent()) {
                    Usuario usuarioAdministrador = new Usuario();
                    usuarioAdministrador.setNombre("Diego Ricardo");
                    usuarioAdministrador.setApellidos("Amador Casillas");
                    usuarioAdministrador.setCorreoElectronico("20233tn077@utez.edu.mx");
                    usuarioAdministrador.setTelefono("7772991476");
                    usuarioAdministrador.setContrasena(passwordEncoder.encode("20233tn077"));
                    usuarioAdministrador.setToken(null);
                    usuarioAdministrador.setStatus(true);
                    usuarioAdministrador.getRoles().add(rolAdministrador);
                    usuarioRepository.saveAndFlush(usuarioAdministrador);
                }

                optionalUsuario = usuarioRepository.findByCorreoElectronico("20233tn092@utez.edu.mx");
                if (!optionalUsuario.isPresent()) {
                    Usuario usuarioAdministrador = new Usuario();
                    usuarioAdministrador.setNombre("Viridiana");
                    usuarioAdministrador.setApellidos("Portilla Palestina");
                    usuarioAdministrador.setCorreoElectronico("20233tn092@utez.edu.mx");
                    usuarioAdministrador.setTelefono("7773306808");
                    usuarioAdministrador.setContrasena(passwordEncoder.encode("20233tn092"));
                    usuarioAdministrador.setToken(null);
                    usuarioAdministrador.setStatus(true);
                    usuarioAdministrador.getRoles().add(rolAdministrador);
                    usuarioRepository.saveAndFlush(usuarioAdministrador);
                }

                optionalUsuario = usuarioRepository.findByCorreoElectronico("20233tn099@utez.edu.mx");
                if (!optionalUsuario.isPresent()) {
                    Usuario usuarioAdministrador = new Usuario();
                    usuarioAdministrador.setNombre("Fernanda Gabriela");
                    usuarioAdministrador.setApellidos("García Segura");
                    usuarioAdministrador.setCorreoElectronico("20233tn099@utez.edu.mx");
                    usuarioAdministrador.setTelefono("7772273687");
                    usuarioAdministrador.setContrasena(passwordEncoder.encode("20233tn099"));
                    usuarioAdministrador.setToken(null);
                    usuarioAdministrador.setStatus(true);
                    usuarioAdministrador.getRoles().add(rolAdministrador);
                    usuarioRepository.saveAndFlush(usuarioAdministrador);
                }

                optionalUsuario = usuarioRepository.findByCorreoElectronico("20233tn068@utez.edu.mx");
                if (!optionalUsuario.isPresent()) {
                    Usuario usuarioAdministrador = new Usuario();
                    usuarioAdministrador.setNombre("Elias Manuel");
                    usuarioAdministrador.setApellidos("Marquez Bailon");
                    usuarioAdministrador.setCorreoElectronico("20233tn068@utez.edu.mx");
                    usuarioAdministrador.setTelefono("7772167599");
                    usuarioAdministrador.setContrasena(passwordEncoder.encode("20233tn068"));
                    usuarioAdministrador.setToken(null);
                    usuarioAdministrador.setStatus(true);
                    usuarioAdministrador.getRoles().add(rolAdministrador);
                    usuarioRepository.saveAndFlush(usuarioAdministrador);
                }

                optionalUsuario = usuarioRepository.findByCorreoElectronico("20223tn028@utez.edu.mx");
                if (!optionalUsuario.isPresent()) {
                    Usuario usuarioAdministrador = new Usuario();
                    usuarioAdministrador.setNombre("Emiliano Santiago");
                    usuarioAdministrador.setApellidos("Rodriguez Castañeda");
                    usuarioAdministrador.setCorreoElectronico("20223tn028@utez.edu.mx");
                    usuarioAdministrador.setTelefono("7771952315");
                    usuarioAdministrador.setContrasena(passwordEncoder.encode("20223tn028"));
                    usuarioAdministrador.setToken(null);
                    usuarioAdministrador.setStatus(true);
                    usuarioAdministrador.getRoles().add(rolAdministrador);
                    usuarioRepository.saveAndFlush(usuarioAdministrador);
                }

                optionalUsuario = usuarioRepository.findByCorreoElectronico("20233tn074@utez.edu.mx");
                if (!optionalUsuario.isPresent()) {
                    Usuario usuarioAdministrador = new Usuario();
                    usuarioAdministrador.setNombre("Andrea Alejandrina");
                    usuarioAdministrador.setApellidos("Ramirez Ocampo");
                    usuarioAdministrador.setCorreoElectronico("20233tn074@utez.edu.mx");
                    usuarioAdministrador.setTelefono("7774289237");
                    usuarioAdministrador.setContrasena(passwordEncoder.encode("20233tn074"));
                    usuarioAdministrador.setToken(null);
                    usuarioAdministrador.setStatus(true);
                    usuarioAdministrador.getRoles().add(rolAdministrador);
                    usuarioRepository.saveAndFlush(usuarioAdministrador);
                }
            }

            optionalRol = rolRepository.findByRol("USUARIO");
            if (!optionalRol.isPresent()) {
                Rol rolAdministrador = new Rol("USUARIO");
                rolRepository.saveAndFlush(rolAdministrador);

                Optional<Usuario> optionalUsuario = usuarioRepository.findByCorreoElectronico("usuario@utez.edu.mx");
                if (!optionalUsuario.isPresent()) {
                    Usuario usuarioAdministrador = new Usuario();
                    usuarioAdministrador.setNombre("Nombre usuario");
                    usuarioAdministrador.setApellidos("Apellidos usuario");
                    usuarioAdministrador.setCorreoElectronico("usuario@utez.edu.mx");
                    usuarioAdministrador.setTelefono("0123456789");
                    usuarioAdministrador.setContrasena(passwordEncoder.encode("passwordUsuario"));
                    usuarioAdministrador.setToken(null);
                    usuarioAdministrador.setStatus(true);
                    usuarioAdministrador.getRoles().add(rolAdministrador);
                    usuarioRepository.saveAndFlush(usuarioAdministrador);
                }
            }
        };
    }
}
