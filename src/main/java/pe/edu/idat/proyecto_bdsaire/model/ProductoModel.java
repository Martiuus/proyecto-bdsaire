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

    public Integer getProductoid() {
        return productoid;
    }

    public void setProductoid(Integer productoid) {
        this.productoid = productoid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public CategoriaModel getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaModel categoria) {
        this.categoria = categoria;
    }

    public ProveedorModel getProveedor() {
        return proveedor;
    }

    public void setProveedor(ProveedorModel proveedor) {
        this.proveedor = proveedor;
    }

    public UbicacionModel getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(UbicacionModel ubicacion) {
        this.ubicacion = ubicacion;
    }
}
