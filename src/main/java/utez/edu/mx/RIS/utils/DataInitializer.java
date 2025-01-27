package utez.edu.mx.RIS.utils;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import utez.edu.mx.RIS.Radiologo.model.Radiologo;
import utez.edu.mx.RIS.Radiologo.model.RadiologoRepository;
import utez.edu.mx.RIS.rol.model.Rol;
import utez.edu.mx.RIS.rol.model.RolRepository;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initDatabase(RadiologoRepository radiologoRepository, RolRepository rolRepository, PasswordEncoder passwordEncoder) {
        return args -> {

            Optional<Rol> optionalRol = rolRepository.findByRol("RADIOLOGO");
            if (!optionalRol.isPresent()) {
                Rol rolAdministrador = new Rol("RADIOLOGO");
                rolRepository.saveAndFlush(rolAdministrador);

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

                Optional<Radiologo> optionalUsuario = radiologoRepository.findByCorreo("20233tn077@utez.edu.mx");
                if (!optionalUsuario.isPresent()) {
                    Radiologo usuarioAdministrador = new Radiologo();
                    usuarioAdministrador.setNombre("Diego Ricardo");
                    usuarioAdministrador.setCorreo("20233tn077@utez.edu.mx");
                    usuarioAdministrador.setTelefono("7772991476");
                    usuarioAdministrador.setContrasena(passwordEncoder.encode("20233tn077"));
                    usuarioAdministrador.setHoraInicio(LocalTime.parse("11:49:02", formatter));
                    usuarioAdministrador.setHoraFin(LocalTime.parse("11:49:02", formatter));
                    usuarioAdministrador.setStatus(true);
                    usuarioAdministrador.getRoles().add(rolAdministrador);
                    radiologoRepository.saveAndFlush(usuarioAdministrador);
                }

                optionalUsuario = radiologoRepository.findByCorreo("20233tn092@utez.edu.mx");
                if (!optionalUsuario.isPresent()) {
                    Radiologo usuarioAdministrador = new Radiologo();
                    usuarioAdministrador.setNombre("Viridiana");
                    usuarioAdministrador.setCorreo("20233tn092@utez.edu.mx");
                    usuarioAdministrador.setTelefono("7773306808");
                    usuarioAdministrador.setContrasena(passwordEncoder.encode("20233tn092"));
                    usuarioAdministrador.setHoraInicio(LocalTime.parse("11:49:02", formatter));
                    usuarioAdministrador.setHoraFin(LocalTime.parse("11:49:02", formatter));
                    usuarioAdministrador.setStatus(true);
                    usuarioAdministrador.getRoles().add(rolAdministrador);
                    radiologoRepository.saveAndFlush(usuarioAdministrador);
                }

                optionalUsuario = radiologoRepository.findByCorreo("20233tn099@utez.edu.mx");
                if (!optionalUsuario.isPresent()) {
                    Radiologo usuarioAdministrador = new Radiologo();
                    usuarioAdministrador.setNombre("Fernanda Gabriela");
                    usuarioAdministrador.setCorreo("20233tn099@utez.edu.mx");
                    usuarioAdministrador.setTelefono("7772273687");
                    usuarioAdministrador.setContrasena(passwordEncoder.encode("20233tn099"));
                    usuarioAdministrador.setHoraInicio(LocalTime.parse("11:49:02", formatter));
                    usuarioAdministrador.setHoraFin(LocalTime.parse("11:49:02", formatter));
                    usuarioAdministrador.setStatus(true);
                    usuarioAdministrador.getRoles().add(rolAdministrador);
                    radiologoRepository.saveAndFlush(usuarioAdministrador);
                }
            }

            optionalRol = rolRepository.findByRol("USUARIO");
            if (!optionalRol.isPresent()) {
                Rol rolUsuario = new Rol("USUARIO");
                rolRepository.saveAndFlush(rolUsuario);

                Optional<Radiologo> optionalUsuario = radiologoRepository.findByCorreo("usuario@utez.edu.mx");
                if (!optionalUsuario.isPresent()) {
                    Radiologo usuarioAdministrador = new Radiologo();
                    usuarioAdministrador.setNombre("Nombre usuario");
                    usuarioAdministrador.setCorreo("usuario@utez.edu.mx");
                    usuarioAdministrador.setTelefono("0123456789");
                    usuarioAdministrador.setContrasena(passwordEncoder.encode("passwordUsuario"));
                    usuarioAdministrador.setHoraInicio(null);
                    usuarioAdministrador.setHoraFin(null);
                    usuarioAdministrador.setStatus(true);
                    usuarioAdministrador.getRoles().add(rolUsuario);
                    radiologoRepository.saveAndFlush(usuarioAdministrador);
                }
            }
        };
    }
}
