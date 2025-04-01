package pe.edu.idat.proyecto_bdsaire.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "pedido")
public class PedidoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pedidoid;

    @ManyToOne
    @JoinColumn(name = "ordenfinalid")
    private OrdenFinalModel ordenfinal;

    @ManyToOne
    @JoinColumn(name = "clienteid")
    private ClienteModel cliente;

    private LocalDateTime fecha;

    public Integer getPedidoid() {
        return pedidoid;
    }

    public void setPedidoid(Integer pedidoid) {
        this.pedidoid = pedidoid;
    }

    public OrdenFinalModel getOrdenfinal() {
        return ordenfinal;
    }

    public void setOrdenfinal(OrdenFinalModel ordenfinal) {
        this.ordenfinal = ordenfinal;
    }

    public ClienteModel getCliente() {
        return cliente;
    }

    public void setCliente(ClienteModel cliente) {
        this.cliente = cliente;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
}
