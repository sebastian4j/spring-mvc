package com.sebastian.hello.modelo;

public class Saludo {
    private String saludo;

    public String getSaludo() {
        return saludo;
    }

    public void setSaludo(String saludo) {
        this.saludo = saludo;
    }
    
    public Saludo(final String s) {
        saludo = s;
    }
}
