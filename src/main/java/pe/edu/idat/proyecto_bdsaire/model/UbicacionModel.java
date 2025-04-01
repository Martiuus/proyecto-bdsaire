package pe.edu.idat.proyecto_bdsaire.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ubicacion")
public class UbicacionModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ubicacionid;
    private String nombre;
    private String descripcion;
    private String direccion;

    public Integer getUbicacionid() {
        return ubicacionid;
    }

    public void setUbicacionid(Integer ubicacionid) {
        this.ubicacionid = ubicacionid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
