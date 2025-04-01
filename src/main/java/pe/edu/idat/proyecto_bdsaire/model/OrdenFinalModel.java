package pe.edu.idat.proyecto_bdsaire.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "ordenfinal")
public class OrdenFinalModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ordenfinalid;

    @ManyToOne
    @JoinColumn(name = "clienteid")
    private ClienteModel cliente;

    private LocalDateTime fecha;
    private String estado;
    private Double total;

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

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
