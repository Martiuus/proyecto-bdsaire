package pe.edu.idat.proyecto_bdsaire.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "salida")
public class SalidaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer salidaid;

    @ManyToOne
    @JoinColumn(name = "productoid", nullable = false)
    private ProductoModel producto;

    private Integer cantidad;
    private LocalDate fecha;

    @Enumerated(EnumType.STRING)
    private Motivo motivo;

    @ManyToOne
    @JoinColumn(name = "usuarioid", nullable = false)
    private UsuarioModel usuario;

    public Integer getSalidaid() {
        return salidaid;
    }

    public void setSalidaid(Integer salidaid) {
        this.salidaid = salidaid;
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

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Motivo getMotivo() {
        return motivo;
    }

    public void setMotivo(Motivo motivo) {
        this.motivo = motivo;
    }

    public UsuarioModel getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioModel usuario) {
        this.usuario = usuario;
    }
}
