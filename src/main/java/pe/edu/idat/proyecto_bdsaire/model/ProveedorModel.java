package pe.edu.idat.proyecto_bdsaire.model;

import jakarta.persistence.*;

@Entity
@Table(name = "proveedor")
public class ProveedorModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer proveedorid;
    private String nombre;
    private String telefono;
    private String email;

    public Integer getProveedorid() {
        return proveedorid;
    }

    public void setProveedorid(Integer proveedorid) {
        this.proveedorid = proveedorid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
