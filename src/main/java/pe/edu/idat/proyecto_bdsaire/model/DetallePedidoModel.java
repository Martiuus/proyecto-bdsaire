package pe.edu.idat.proyecto_bdsaire.model;

import jakarta.persistence.*;

@Entity
@Table(name = "detallepedido")
public class DetallePedidoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer detallepedidoid;

    @ManyToOne
    @JoinColumn(name = "ordenfinalid")
    private OrdenFinalModel ordenfinal;

    @ManyToOne
    @JoinColumn(name = "productoid")
    private ProductoModel producto;

    private Integer cantidad;
    private Double precio;

    @Column(nullable = false)
    private Double subtotal;

    public Integer getDetallepedidoid() {
        return detallepedidoid;
    }

    public void setDetallepedidoid(Integer detallepedidoid) {
        this.detallepedidoid = detallepedidoid;
    }

    public OrdenFinalModel getOrdenfinal() {
        return ordenfinal;
    }

    public void setOrdenfinal(OrdenFinalModel ordenfinal) {
        this.ordenfinal = ordenfinal;
    }

    public ProductoModel getProducto() {
        return producto;
    }

    public void setProducto(ProductoModel producto) {
        this.producto = producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }
}