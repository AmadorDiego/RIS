package utez.edu.mx.RIS.rol.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import utez.edu.mx.RIS.Radiologo.model.Radiologo;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "rol")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String rol;

    @JsonIgnore
    @ManyToMany(mappedBy = "roles")
    private Set<Radiologo> usuarios = new HashSet<>();

    public Rol() {}

    public Rol(String rol) {
        this.rol = rol;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Set<Radiologo> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Set<Radiologo> usuarios) {
        this.usuarios = usuarios;
    }
}
