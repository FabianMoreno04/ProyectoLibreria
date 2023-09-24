package models;

public class Libro {
    private String titulo;
    private String isbn;
    private String volumen;
    private String editorial;
    private Autor autor;
    private String sede;
    private String cantidadDisponible;

    public Libro(String titulo, String isbn, String volumen, String editorial, Autor autor,String cantidadDisponible, String seleccionSede) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.volumen = volumen;
        this.editorial = editorial;
        this.autor = autor;
        this.sede = seleccionSede;
        this.cantidadDisponible = cantidadDisponible; 
    }

    // Getters y setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getVolumen() {
        return volumen;
    }

    public void setVolumen(String volumen) {
        this.volumen = volumen;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    public String getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(String cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }
}

