package pe.edu.idat.proyecto_bdsaire.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;

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

    @Column(nullable = false)
    private LocalDateTime fecha;

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

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
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
