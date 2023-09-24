package controller;
import javax.swing.*;

import models.Biblioteca;
import models.Campus;
import models.Libro;
import models.Sede;
import view.PanelPantallaPrincipal;
import view.VentanaBuscarLibro;
import view.VentanaCrearLibro;
import view.VentanaEliminarLibro;
import view.VentanaListarLibros;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class BibliotecaController {
    private Biblioteca biblioteca;

    public BibliotecaController() {
        biblioteca = new Biblioteca();
    }

    public void mostrarPantallaPrincipal() {
        PanelPantallaPrincipal panelPantallaPrincipal = new PanelPantallaPrincipal();
        panelPantallaPrincipal.mostrarPantallaPrincipal();
    }


    public void mostrarVentanaBuscarLibro() {
        VentanaBuscarLibro ventanaBuscarLibro = new VentanaBuscarLibro(this);
        ventanaBuscarLibro.setVisible(true);
    }

  
    public List<Libro> buscarLibro(String codigoISBN, String sedeConsulta) {
        if (sedeConsulta.isEmpty()) {
            return biblioteca.buscarLibro(codigoISBN);
        } else {
            return biblioteca.buscarLibro(sedeConsulta, codigoISBN);
        }
    }


    public void mostrarVentanaCrearLibro() {
        VentanaCrearLibro ventanaCrearLibro = new VentanaCrearLibro(this);
        ventanaCrearLibro.setVisible(true);
    }

  
    public void agregarLibro(Libro libro, String sede) {
        biblioteca.agregarLibro(sede, libro);
    }

    
    public void mostrarVentanaEliminarLibro() {
        VentanaEliminarLibro ventanaEliminarLibro = new VentanaEliminarLibro(this);
        ventanaEliminarLibro.setVisible(true);
    }

    
    public void eliminarLibro(String isbn, String sede) {
        biblioteca.eliminarLibro(sede, isbn);
    }

    
    public void mostrarVentanaListarLibros() {
        VentanaListarLibros ventanaListarLibros = new VentanaListarLibros(this);
        ventanaListarLibros.setVisible(true);
    }

    
    public List<Libro> obtenerTodosLosLibros() {
        return biblioteca.listarTodosLosLibros();
    }
    public List<Libro> obtenerLibrosEnSede(String sede) {
        return biblioteca.listarLibrosEnSede(sede);
    }
    
    public List<Sede> crearListaSedes() {
        List<Sede> sedes = new ArrayList<>();

        // Crear instancias de Sede y agregar campus
        Sede sedeTunja = new Sede("Tunja");
        sedeTunja.agregarCampus(new Campus("Facultad de Medicina"));
        sedeTunja.agregarCampus(new Campus("Edificio Central - FESAD"));
        sedeTunja.agregarCampus(new Campus("Facultad de Estudios a Distancia"));

        Sede sedeDuitama = new Sede("Duitama");
        sedeDuitama.agregarCampus(new Campus("Centro Regional"));

        sedes.add(sedeTunja);
        sedes.add(sedeDuitama);

        return sedes;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BibliotecaController controlador = new BibliotecaController();
            controlador.mostrarPantallaPrincipal();
        });
    }
}


