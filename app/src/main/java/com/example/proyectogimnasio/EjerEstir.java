package com.example.proyectogimnasio;

public class EjerEstir {

    protected String nombre;
    protected String descripcion;
    protected String grupo;
    protected String imagen;

    public EjerEstir(String nombre, String descripcion, String grupo, String imagen) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.grupo = grupo;
        this.imagen = imagen;
    }

    public EjerEstir(String nombre, String descripcion, String grupo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.grupo = grupo;
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

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
