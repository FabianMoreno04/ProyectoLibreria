package models;

import java.util.ArrayList;
import java.util.List;

public class ArbolAVL {
    private Nodo raiz;

    public ArbolAVL() {
        this.raiz = null;
    }

    private int altura(Nodo nodo) {
        if (nodo == null)
            return 0;
        return nodo.altura;
    }

    private int maximo(int a, int b) {
        return Math.max(a, b);
    }

    private Nodo rotacionDerecha(Nodo y) {
        Nodo x = y.izquierda;
        Nodo temp = x.derecha;

        x.derecha = y;
        y.izquierda = temp;

        y.altura = maximo(altura(y.izquierda), altura(y.derecha)) + 1;
        x.altura = maximo(altura(x.izquierda), altura(x.derecha)) + 1;

        return x;
    }

    private Nodo rotacionIzquierda(Nodo x) {
        Nodo y = x.derecha;
        Nodo temp = y.izquierda;

        y.izquierda = x;
        x.derecha = temp;

        x.altura = maximo(altura(x.izquierda), altura(x.derecha)) + 1;
        y.altura = maximo(altura(y.izquierda), altura(y.derecha)) + 1;

        return y;
    }

    private int factorEquilibrio(Nodo nodo) {
        if (nodo == null)
            return 0;
        return altura(nodo.izquierda) - altura(nodo.derecha);
    }

    private Nodo insertar(Nodo nodo, Libro libro) {
        if (nodo == null)
            return new Nodo(libro);

        if (libro.getIsbn().compareTo(nodo.libro.getIsbn()) < 0)
            nodo.izquierda = insertar(nodo.izquierda, libro);
        else if (libro.getIsbn().compareTo(nodo.libro.getIsbn()) > 0)
            nodo.derecha = insertar(nodo.derecha, libro);
        else
            return nodo;

        nodo.altura = 1 + maximo(altura(nodo.izquierda), altura(nodo.derecha));

        int equilibrio = factorEquilibrio(nodo);

        if (equilibrio > 1 && libro.getIsbn().compareTo(nodo.izquierda.libro.getIsbn()) < 0)
            return rotacionDerecha(nodo);

        if (equilibrio < -1 && libro.getIsbn().compareTo(nodo.derecha.libro.getIsbn()) > 0)
            return rotacionIzquierda(nodo);

        if (equilibrio > 1 && libro.getIsbn().compareTo(nodo.izquierda.libro.getIsbn()) > 0) {
            nodo.izquierda = rotacionIzquierda(nodo.izquierda);
            return rotacionDerecha(nodo);
        }

        if (equilibrio < -1 && libro.getIsbn().compareTo(nodo.derecha.libro.getIsbn()) < 0) {
            nodo.derecha = rotacionDerecha(nodo.derecha);
            return rotacionIzquierda(nodo);
        }

        return nodo;
    }

    public void insertar(Libro libro) {
        raiz = insertar(raiz, libro);
    }

    // Método para eliminar un libro por ISBN
    public void eliminarPorISBN(String isbn) {
        raiz = eliminarPorISBN(raiz, isbn);
    }

    private Nodo eliminarPorISBN(Nodo nodo, String isbn) {
        if (nodo == null)
            return nodo;

        if (isbn.compareTo(nodo.libro.getIsbn()) < 0)
            nodo.izquierda = eliminarPorISBN(nodo.izquierda, isbn);
        else if (isbn.compareTo(nodo.libro.getIsbn()) > 0)
            nodo.derecha = eliminarPorISBN(nodo.derecha, isbn);
        else {
            if (nodo.izquierda == null || nodo.derecha == null) {
                Nodo temp = null;
                if (nodo.izquierda == null)
                    temp = nodo.derecha;
                else
                    temp = nodo.izquierda;

                if (temp == null) {
                    temp = nodo;
                    nodo = null;
                } else
                    nodo = temp;
            } else {
                Nodo temp = obtenerMinimo(nodo.derecha);
                nodo.libro = temp.libro;
                nodo.derecha = eliminarPorISBN(nodo.derecha, temp.libro.getIsbn());
            }
        }

        if (nodo == null)
            return nodo;

        nodo.altura = 1 + maximo(altura(nodo.izquierda), altura(nodo.derecha));

        int equilibrio = factorEquilibrio(nodo);

        // Casos de rotación
        if (equilibrio > 1 && factorEquilibrio(nodo.izquierda) >= 0)
            return rotacionDerecha(nodo);

        if (equilibrio > 1 && factorEquilibrio(nodo.izquierda) < 0) {
            nodo.izquierda = rotacionIzquierda(nodo.izquierda);
            return rotacionDerecha(nodo);
        }

        if (equilibrio < -1 && factorEquilibrio(nodo.derecha) <= 0)
            return rotacionIzquierda(nodo);

        if (equilibrio < -1 && factorEquilibrio(nodo.derecha) > 0) {
            nodo.derecha = rotacionDerecha(nodo.derecha);
            return rotacionIzquierda(nodo);
        }

        return nodo;
    }

    private Nodo obtenerMinimo(Nodo nodo) {
        Nodo actual = nodo;
        while (actual.izquierda != null)
            actual = actual.izquierda;
        return actual;
    }

    // Método para buscar un libro por nombre o ISBN
    public List<Libro> buscarPorNombreOISBN(String consulta) {
        List<Libro> resultados = new ArrayList<>();
        buscarPorNombreOISBN(raiz, consulta, resultados);
        return resultados;
    }

    private void buscarPorNombreOISBN(Nodo nodo, String consulta, List<Libro> resultados) {
        if (nodo == null)
            return;

        if (nodo.libro.getTitulo().toLowerCase().contains(consulta.toLowerCase()) ||
            nodo.libro.getIsbn().toLowerCase().contains(consulta.toLowerCase())) {
            resultados.add(nodo.libro);
        }

        if (nodo.izquierda != null && consulta.compareTo(nodo.libro.getIsbn()) < 0)
            buscarPorNombreOISBN(nodo.izquierda, consulta, resultados);
        else if (nodo.derecha != null && consulta.compareTo(nodo.libro.getIsbn()) > 0)
            buscarPorNombreOISBN(nodo.derecha, consulta, resultados);
    }

    // Método para obtener todos los libros del árbol
    public List<Libro> obtenerTodosLosLibros() {
        List<Libro> todosLosLibros = new ArrayList<>();
        obtenerTodosLosLibros(raiz, todosLosLibros);
        return todosLosLibros;
    }

    private void obtenerTodosLosLibros(Nodo nodo, List<Libro> todosLosLibros) {
        if (nodo != null) {
            obtenerTodosLosLibros(nodo.izquierda, todosLosLibros);
            todosLosLibros.add(nodo.libro);
            obtenerTodosLosLibros(nodo.derecha, todosLosLibros);
        }
    }
}

