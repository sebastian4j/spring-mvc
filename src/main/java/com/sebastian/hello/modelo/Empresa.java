package com.sebastian.hello.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Table(name = "empresas")
@Entity
public class Empresa {
    @Id
    private long rut;
    private String nombre;

    public long getRut() {
        return rut;
    }

    public void setRut(long rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }
    private String alias;

    @Override
    public String toString() {
        return "Empresa{" + "rut=" + rut + ", nombre=" + nombre + ", alias=" + alias + '}';
    }
    
    
}
