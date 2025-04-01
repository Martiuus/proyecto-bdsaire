package pe.edu.idat.proyecto_bdsaire.model;

import jakarta.persistence.*;

@Entity
@Table(name = "detallepedido")
public class DetallePedidoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer detallepedidoid;

    @ManyToOne
    @JoinColumn(name = "pedidoid")
    private PedidoModel pedido;

    @ManyToOne
    @JoinColumn(name = "productoid")
    private ProductoModel producto;

    private Integer cantidad;
    private Double precio;

    @Column(columnDefinition = "DECIMAL(10,2) GENERATED ALWAYS AS (cantidad * precio) STORED")
    private Double subtotal;

    public Integer getDetallepedidoid() {
        return detallepedidoid;
    }

    public void setDetallepedidoid(Integer detallepedidoid) {
        this.detallepedidoid = detallepedidoid;
    }

    public PedidoModel getPedido() {
        return pedido;
    }

    public void setPedido(PedidoModel pedido) {
        this.pedido = pedido;
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
