package pe.edu.idat.proyecto_bdsaire.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "ordenfinal")
public class OrdenFinalModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ordenfinalid;

    @ManyToOne
    @JoinColumn(name = "clienteid")
    private ClienteModel cliente;

    private LocalDate fecha;

    @Enumerated(EnumType.STRING)
    private EstadoOrden estado;

    private Double total;

    @OneToMany(mappedBy = "ordenfinal", cascade = CascadeType.ALL)
    private List<DetallePedidoModel> detalles;

    public Integer getOrdenfinalid() {
        return ordenfinalid;
    }

    public void setOrdenfinalid(Integer ordenfinalid) {
        this.ordenfinalid = ordenfinalid;
    }

    public ClienteModel getCliente() {
        return cliente;
    }

    public void setCliente(ClienteModel cliente) {
        this.cliente = cliente;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public EstadoOrden getEstado() {
        return estado;
    }

    public void setEstado(EstadoOrden estado) {
        this.estado = estado;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public List<DetallePedidoModel> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetallePedidoModel> detalles) {
        this.detalles = detalles;
    }
}