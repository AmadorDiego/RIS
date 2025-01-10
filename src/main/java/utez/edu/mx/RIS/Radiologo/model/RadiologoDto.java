package utez.edu.mx.RIS.Radiologo.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalTime;

public class RadiologoDto {
    @NotNull(groups ={ Modificar.class, CambiarStatus.class}, message = "Es necesario el id")
    private Long id;
    @NotBlank(groups = {Registrar.class,Modificar.class}, message = "Es necesario el nombre")
    private String nombre;
    @NotBlank(groups = {Registrar.class,Modificar.class}, message = "Es necesario el correo electronico")
    private String correo;
    @NotBlank(groups = {Registrar.class,Modificar.class}, message = "Es necesario la contraseña")
    private String contrasena;
    @NotBlank(groups = {Registrar.class,Modificar.class}, message = "Es necesario el telefono")
    private String telefono;
    @NotNull(groups = {Registrar.class, Modificar.class}, message = "Es necesario la hora de entrada")
    private LocalTime horaInicio;
    @NotNull(groups = {Registrar.class, Modificar.class}, message = "Es necesario la hora de salida")
    private LocalTime horaFin;

    public RadiologoDto() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }

    public interface Registrar{}
    public interface Modificar{}
    public interface CambiarStatus{}
}
