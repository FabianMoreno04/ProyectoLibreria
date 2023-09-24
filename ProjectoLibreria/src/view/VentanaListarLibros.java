package view;

import javax.swing.*;

import controller.BibliotecaController;
import models.Libro;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class VentanaListarLibros extends JFrame {

    public VentanaListarLibros(BibliotecaController controller) {
    	setTitle("Lista de Libros");
    	setSize(300, 150);
    	setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Color buttonPanelColor = new Color(200,200,200);
         

        // Crear un panel para los botones
        JPanel panel = new JPanel();
        panel.setBackground(buttonPanelColor);
        panel.setLayout(new GridLayout(2, 1, 10, 10)); // 2 filas, 1 columna, espaciado entre componentes

        // Crear el botón para listar todos los libros
        JButton btnListarTodos = new JButton("Listar Todos los Libros");
        btnListarTodos.setBackground(Color.YELLOW);
        btnListarTodos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	SwingUtilities.invokeLater(() -> {
            		VentanaMostraTodosLibros mosTodosLibros = new VentanaMostraTodosLibros(controller);
            		mosTodosLibros.setVisible(true);
                    
                });
            }
        });

        // Crear el botón para listar libros por sede
        JButton btnListarPorSede = new JButton("Listar Libros por Sede");
        btnListarPorSede.setBackground(Color.YELLOW);
        btnListarPorSede.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	SwingUtilities.invokeLater(() -> {
            		VentanaListarLibrosSede isbn = new VentanaListarLibrosSede(controller);
            		isbn.setVisible(true);
                    
                });
            }
        });
        panel.setLayout(new FlowLayout());
        panel.add(btnListarTodos);
        panel.add(btnListarPorSede);

        // Agregar el panel a la ventana
        getContentPane().add(panel, BorderLayout.CENTER);
    } 
    
    
}




