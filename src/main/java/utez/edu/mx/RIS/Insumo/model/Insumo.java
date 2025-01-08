package utez.edu.mx.RIS.Insumo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "insumos")
public class Insumo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    String nombre;
    String descripcion;
    int cantidad;
    double precio;


}
