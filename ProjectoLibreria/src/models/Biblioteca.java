package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Biblioteca {
    private Map<String, ArbolAVL> sedeLibrosMap;

    public Biblioteca() {
        this.sedeLibrosMap = new HashMap<>();
    }

    // Agregar un libro a la biblioteca
    public void agregarLibro(String sede, Libro libro) {
        if (!sedeLibrosMap.containsKey(sede)) {
            sedeLibrosMap.put(sede, new ArbolAVL());
        }
        ArbolAVL arbolSede = sedeLibrosMap.get(sede);
        arbolSede.insertar(libro);
    }

    // Eliminar un libro de la biblioteca por ISBN y sede
    public void eliminarLibro(String sede, String isbn) {
        if (sedeLibrosMap.containsKey(sede)) {
            ArbolAVL arbolSede = sedeLibrosMap.get(sede);
            arbolSede.eliminarPorISBN(isbn);
        }
    }
 // Buscar un libro por nombre o ISBN en todas las sedes
    public List<Libro> buscarLibro(String consulta) {
        List<Libro> resultados = new ArrayList<>();
        for (ArbolAVL arbolSede : sedeLibrosMap.values()) {
            resultados.addAll(arbolSede.buscarPorNombreOISBN(consulta));
        }
        return resultados;
    }

    // Buscar un libro por nombre o ISBN y sede
    public List<Libro> buscarLibro(String sede, String codeISBN) {
        List<Libro> resultados = new ArrayList<>();
        if (sedeLibrosMap.containsKey(sede)) {
            ArbolAVL arbolSede = sedeLibrosMap.get(sede);
            resultados = arbolSede.buscarPorNombreOISBN(codeISBN);
        }
        return resultados;
    }

    // Listar todos los libros en todas las sedes
    public List<Libro> listarTodosLosLibros() {
        List<Libro> todosLosLibros = new ArrayList<>();
        for (ArbolAVL arbol : sedeLibrosMap.values()) {
            todosLosLibros.addAll(arbol.obtenerTodosLosLibros());
        }
        return todosLosLibros;
    }

    // Listar todos los libros en una sede específica
    public List<Libro> listarLibrosEnSede(String sede) {
        List<Libro> librosEnSede = new ArrayList<>();
        if (sedeLibrosMap.containsKey(sede)) {
            ArbolAVL arbolSede = sedeLibrosMap.get(sede);
            librosEnSede = arbolSede.obtenerTodosLosLibros();
        }
        return librosEnSede;
    }
}

