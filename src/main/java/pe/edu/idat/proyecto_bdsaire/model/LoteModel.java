package pe.edu.idat.proyecto_bdsaire.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "lote")
public class LoteModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer loteid;

    @ManyToOne
    @JoinColumn(name = "productoid", nullable = false)
    private ProductoModel producto;

    private Integer cantidad;
    private LocalDateTime fechaingreso;
    private LocalDateTime fechavencimiento;

    public Integer getLoteid() {
        return loteid;
    }

    public void setLoteid(Integer loteid) {
        this.loteid = loteid;
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

    public LocalDateTime getFechaingreso() {
        return fechaingreso;
    }

    public void setFechaingreso(LocalDateTime fechaingreso) {
        this.fechaingreso = fechaingreso;
    }

    public LocalDateTime getFechavencimiento() {
        return fechavencimiento;
    }

    public void setFechavencimiento(LocalDateTime fechavencimiento) {
        this.fechavencimiento = fechavencimiento;
    }
}
