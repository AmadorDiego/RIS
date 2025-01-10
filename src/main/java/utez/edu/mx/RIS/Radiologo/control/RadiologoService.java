package utez.edu.mx.RIS.Radiologo.control;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utez.edu.mx.RIS.Radiologo.model.Radiologo;
import utez.edu.mx.RIS.Radiologo.model.RadiologoDto;
import utez.edu.mx.RIS.Radiologo.model.RadiologoRepository;
import utez.edu.mx.RIS.utils.Message;
import utez.edu.mx.RIS.utils.TypesResponse;

import java.sql.SQLException;
import java.util.Optional;

@Service
@Transactional
public class RadiologoService {
    private final static Logger logger = LoggerFactory.getLogger(RadiologoService.class);

    private final RadiologoRepository radiologoRepository;

    @Autowired
    public RadiologoService(RadiologoRepository radiologoRepository) {
        this.radiologoRepository = radiologoRepository;
    }

    @Transactional(readOnly = true)
    public ResponseEntity<Object> findAll(){
        return new ResponseEntity<>(new Message(radiologoRepository.findAll(),"Listado de radiologos encontrados", TypesResponse.SUCCESS), HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    public ResponseEntity<Object> findAllEnabled() {
        return new ResponseEntity<>(new Message(radiologoRepository.findAllByStatus(true), "Listado de estados de residencia activos", TypesResponse.SUCCESS), HttpStatus.OK);
    }

    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<Object> save(RadiologoDto dto) {
        dto.setNombre(dto.getNombre());
        if(dto.getNombre().length()>30){
            return new ResponseEntity<>(new Message("El nombre no puede contener mas de 30 caracteres", TypesResponse.WARNING), HttpStatus.BAD_REQUEST);
        }
        dto.setCorreo(dto.getCorreo());
        if(dto.getCorreo().length()>70){
            return new ResponseEntity<>(new Message("El correo no puede contener mas de 70 caracteres", TypesResponse.WARNING), HttpStatus.BAD_REQUEST);
        }
        dto.setContrasena(dto.getContrasena());
        if(dto.getCorreo().length()>10){
            return new ResponseEntity<>(new Message("La contraseña no puede contener mas de 10 caracteres", TypesResponse.WARNING), HttpStatus.BAD_REQUEST);
        }
        dto.setTelefono(dto.getTelefono());
        if(dto.getCorreo().length()>10){
            return new ResponseEntity<>(new Message("El telefono no puede contener mas de 10 caracteres", TypesResponse.WARNING), HttpStatus.BAD_REQUEST);
        }
        Radiologo radiologo = new Radiologo(dto.getNombre(), dto.getCorreo(), dto.getContrasena(), dto.getTelefono(), dto.getHoraInicio(), dto.getHoraFin(), true);
        radiologo = radiologoRepository.saveAndFlush(radiologo);
        if (radiologo == null) {
            logger.error("Error al guardar el radiologo");
            return new ResponseEntity<>(new Message("No se registró el radiologo", TypesResponse.ERROR), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(new Message(radiologo, "Se registró el radiologo", TypesResponse.SUCCESS), HttpStatus.OK);
    }

    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<Object> update(RadiologoDto dto) {
        Optional<Radiologo> optional = radiologoRepository.findById(dto.getId());
        if (!optional.isPresent()) {
            return new ResponseEntity<>(new Message("No se encontró el radiologo", TypesResponse.WARNING), HttpStatus.NOT_FOUND);
        }
        dto.setNombre(dto.getNombre());
        if(dto.getNombre().length()>30){
            return new ResponseEntity<>(new Message("El nombre no puede contener mas de 30 caracteres", TypesResponse.WARNING), HttpStatus.BAD_REQUEST);
        }
        dto.setCorreo(dto.getCorreo());
        if(dto.getCorreo().length()>70){
            return new ResponseEntity<>(new Message("El correo no puede contener mas de 70 caracteres", TypesResponse.WARNING), HttpStatus.BAD_REQUEST);
        }
        dto.setContrasena(dto.getContrasena());
        if(dto.getCorreo().length()>10){
            return new ResponseEntity<>(new Message("La contraseña no puede contener mas de 10 caracteres", TypesResponse.WARNING), HttpStatus.BAD_REQUEST);
        }
        dto.setTelefono(dto.getTelefono());
        if(dto.getCorreo().length()>10){
            return new ResponseEntity<>(new Message("El telefono no puede contener mas de 10 caracteres", TypesResponse.WARNING), HttpStatus.BAD_REQUEST);
        }
        Radiologo radiologo = new Radiologo(dto.getNombre(), dto.getCorreo(), dto.getContrasena(), dto.getTelefono(), dto.getHoraInicio(), dto.getHoraFin(), true);
        radiologo = radiologoRepository.saveAndFlush(radiologo);
        if (radiologo == null) {
            logger.error("Error al guardar el radiologo");
            return new ResponseEntity<>(new Message("No se registró el radiologo", TypesResponse.ERROR), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(new Message(radiologo, "Se registró el radiologo", TypesResponse.SUCCESS), HttpStatus.OK);
    }

    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<Object> changeStatus(RadiologoDto dto) {
        Optional<Radiologo> optional = radiologoRepository.findById(dto.getId());
        if (!optional.isPresent()) {
            return new ResponseEntity<>(new Message("No se encontró el radiologo", TypesResponse.WARNING), HttpStatus.NOT_FOUND);
        }
        Radiologo radiologo = optional.get();
        radiologo.setStatus(!radiologo.isStatus());
        radiologo = radiologoRepository.saveAndFlush(radiologo);
        if (radiologo == null) {
            logger.error("No se pudo modificar el Status del radiologo");
            return new ResponseEntity<>(new Message("No se modificó el status del radiologo", TypesResponse.ERROR), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(new Message(radiologo, "Se modificó el status radiologo", TypesResponse.SUCCESS), HttpStatus.OK);
    }

}
