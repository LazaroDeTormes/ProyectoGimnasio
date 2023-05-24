package com.example.proyectogimnasio.pojos;

public class EjerEstir {

    protected int id;
    protected String nombre;
    protected String descripcion;
    protected String grupo;
    protected String imagen;

    public EjerEstir(int id, String nombre, String descripcion, String grupo, String imagen) {
        this.id = id;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "EjerEstir{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", grupo='" + grupo + '\'' +
                ", imagen='" + imagen + '\'' +
                '}';
    }
}
