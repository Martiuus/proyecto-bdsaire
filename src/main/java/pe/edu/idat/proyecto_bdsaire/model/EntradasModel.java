package pe.edu.idat.proyecto_bdsaire.model;


import java.time.LocalDateTime;

import jakarta.persistence.*;

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
    private LocalDateTime fecha;

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

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public UsuarioModel getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioModel usuario) {
        this.usuario = usuario;
    }
}
