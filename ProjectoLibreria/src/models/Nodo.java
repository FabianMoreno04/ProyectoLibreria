package models;

public class Nodo {
    Libro libro;
    int altura;
    Nodo izquierda;
    Nodo derecha;

    Nodo(Libro libro) {
        this.libro = libro;
        this.altura = 1;
    }
}
