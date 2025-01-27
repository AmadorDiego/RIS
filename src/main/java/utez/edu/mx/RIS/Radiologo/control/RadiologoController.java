package utez.edu.mx.RIS.Radiologo.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import utez.edu.mx.RIS.Radiologo.model.RadiologoDto;

@RestController
@RequestMapping("/usuarios")
public class RadiologoController {

        private final RadiologoService radiologoService;

        @Autowired
        public RadiologoController(RadiologoService usuarioService) {
            this.radiologoService = usuarioService;
        }

        @PostMapping("/registrar")
        public ResponseEntity<Object> registrarUsuario(@Validated(RadiologoDto.Registrar.class) @RequestBody RadiologoDto usuarioDto) {
            return radiologoService.save(usuarioDto);
        }

        @PostMapping("/registrarse")
        public ResponseEntity<Object> registrarse(@Validated (RadiologoDto.Registrar.class) @RequestBody RadiologoDto usuarioDto) {
            return radiologoService.save(usuarioDto);
        }

        @GetMapping("/consultar")
        public ResponseEntity<Object> consultarUsuarios() {
            return radiologoService.findAll();
        }

        @GetMapping("/consultarRadiologo")
        public ResponseEntity<Object> consultarRadiologo() {
            return radiologoService.findRadiologo();
        }
        @GetMapping("/consultarActivos")
        public ResponseEntity<Object> consultarUsuariosActivos() {
            return radiologoService.findAllEnabled();
        }

        @PutMapping("/modificarUsuario")
        public ResponseEntity<Object> modificarUsuario(@Validated(RadiologoDto.Modificar.class) @RequestBody RadiologoDto usuarioDto) {
            return radiologoService.update(usuarioDto);
        }

        @PutMapping("/cambiarStatus")
        public ResponseEntity<Object> cambiarStatus(@Validated(RadiologoDto.CambiarStatus.class) @RequestBody RadiologoDto usuarioDto){
            return radiologoService.changeStatus(usuarioDto);
        }






        @PostMapping("/verificarToken")
        public ResponseEntity<Object> verificarToken(@Validated({RadiologoDto.VerificarToken.class}) @RequestBody RadiologoDto usuarioDto){
            return radiologoService.verificarToken(usuarioDto);
        }

}
