package utez.edu.mx.RIS.Radiologo.model;

import ch.qos.logback.core.util.Loader;
import jakarta.persistence.*;


import java.time.LocalTime;

@Entity
@Table(name= "radiologos")
public class Radiologo {
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

    public Radiologo(Long id, String nombre, String correo, String contrasena, String telefono, LocalTime horaInicio, LocalTime horaFin, boolean status) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.contrasena = contrasena;
        this.telefono = telefono;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.status = status;
    }

    public Radiologo() {
    }

    public Radiologo(String nombre, String correo, String contrasena, String telefono, LocalTime horaInicio, LocalTime horaFin, boolean status) {
        this.nombre = nombre;
        this.correo = correo;
        this.contrasena = contrasena;
        this.telefono = telefono;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.status = status;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
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
}
