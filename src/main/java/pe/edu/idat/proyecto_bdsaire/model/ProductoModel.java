package pe.edu.idat.proyecto_bdsaire.model;

import jakarta.persistence.*;

@Entity
@Table(name = "producto")
public class ProductoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productoid;

    private String nombre;
    private String descripcion;

    @Column(nullable = false)
    private Double precio;

    private Integer cantidad;

    @ManyToOne
    @JoinColumn(name = "categoriaid")
    private CategoriaModel categoria;

    @ManyToOne
    @JoinColumn(name = "proveedorid")
    private ProveedorModel proveedor;

    @ManyToOne
    @JoinColumn(name = "ubicacionid")
    private UbicacionModel ubicacion;
}
