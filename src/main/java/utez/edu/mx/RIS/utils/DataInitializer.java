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

            Optional<Rol> optionalRol = rolRepository.findByRol("ADMINISTRADOR");
            if (!optionalRol.isPresent()) {
                Rol rolAdministrador = new Rol("ADMINISTRADOR");
                rolRepository.saveAndFlush(rolAdministrador);

                Optional<Radiologo> optionalUsuario = radiologoRepository.findByCorreo("20233tn077@utez.edu.mx");
                if (!optionalUsuario.isPresent()) {
                    /*
                    @Id
                    @GeneratedValue(strategy = GenerationType.IDENTITY)
                    private Long id;
                    @Column(name = "nombre", columnDefinition = "VARCHAR(30)")
                    private String nombre;
                    @Column(name = "correo", columnDefinition = "VARCHAR(70)")
                    private String correo;
                    @Column(name = "contrasena", columnDefinition = "VARCHAR(10)")
                    private String contrasena;
                    @Column(name = "telefono", columnDefinition = "VARCHAR(10)")
                    private String telefono;
                    @Column(name = "horaInicio", columnDefinition = "TIME")
                    private LocalTime horaInicio;
                    @Column(name = "horaFin", columnDefinition = "TIME")
                    private LocalTime horaFin;
                    @Column(name = "status", columnDefinition = "BOOL DEFAULT TRUE")
                    private boolean status;

    */
                    Radiologo usuarioAdministrador = new Radiologo();
                    usuarioAdministrador.setNombre("Diego Ricardo");
                    usuarioAdministrador.setCorreo("20233tn077@utez.edu.mx");
                    usuarioAdministrador.setTelefono("7772991476");
                    usuarioAdministrador.setContrasena(passwordEncoder.encode("20233tn077"));
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
                    usuarioAdministrador.setHoraInicio(LocalTime.parse("11:49:02", formatter));
                    usuarioAdministrador.setHoraFin(LocalTime.parse("11:49:02", formatter));
                    usuarioAdministrador.setStatus(true);
                    usuarioAdministrador.getRoles().add(rolAdministrador);
                    usuarioRepository.saveAndFlush(usuarioAdministrador);
                }

                optionalUsuario = usuarioRepository.findByCorreoElectronico("20233tn092@utez.edu.mx");
                if (!optionalUsuario.isPresent()) {
                    Radiologo usuarioAdministrador = new Radiologo();
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
