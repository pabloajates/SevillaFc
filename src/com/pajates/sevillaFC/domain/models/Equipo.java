package com.pajates.sevillaFC.domain.models;

public class Equipo {

    private Integer id;
    private String nombre;
    private String categoria;
    private int jugadores;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getJugador() {
        return jugadores;
    }

    public void setJugador(int jugadores) {
        this.jugadores = jugadores;
    }
}
