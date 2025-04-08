package pe.edu.idat.proyecto_bdsaire.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "entradas")
public class EntradasModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer entradaid;

    @ManyToOne
    @JoinColumn(name = "productoid", nullable = false)
    private ProductoModel producto;

    @ManyToOne
    @JoinColumn(name = "proveedorid", nullable = false)
    private ProveedorModel proveedor;

    private Integer cantidad;
    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "usuarioid", nullable = false)
    private UsuarioModel usuario;

    public Integer getEntradaid() {
        return entradaid;
    }

    public void setEntradaid(Integer entradaid) {
        this.entradaid = entradaid;
    }

    public ProductoModel getProducto() {
        return producto;
    }

    public void setProducto(ProductoModel producto) {
        this.producto = producto;
    }

    public ProveedorModel getProveedor() {
        return proveedor;
    }

    public void setProveedor(ProveedorModel proveedor) {
        this.proveedor = proveedor;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public UsuarioModel getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioModel usuario) {
        this.usuario = usuario;
    }
}
