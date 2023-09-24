package view;

import javax.swing.*;

import controller.BibliotecaController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;
import view.*;


public class PanelPantallaPrincipal {
	
	public void mostrarPantallaPrincipal() {
		  // Crear el marco principal
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 700); // Tamaño de la ventana
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(new Color(255, 204, 153));// Usar un BorderLayout para organizar los componentes
       
        // Crear un JLabel para el título y agregarlo en la parte superior (NORTH)
        JLabel titleLabel = new JLabel("LIBRERIA UPTC", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        frame.add(titleLabel, BorderLayout.NORTH);
        
     // Establecer el color de fondo del panel de botones con RGB (200, 200, 200)
        Color buttonPanelColor = new Color(255, 204, 154);
        
     // Crear un panel para la parte izquierda con información
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BorderLayout());
        leftPanel.setBackground(buttonPanelColor);
        leftPanel.setPreferredSize(new Dimension(200, 0));

        // Agregar información al panel izquierdo usando un JLabel
        JLabel infoLabel = new JLabel("informacion aqui");
        infoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        leftPanel.add(infoLabel, BorderLayout.CENTER);
        
        // Crear un panel para la parte derecha con 4 botones
        JPanel rightPanel = new JPanel(new GridLayout(4, 1, 10, 10));
        rightPanel.setPreferredSize(new Dimension(200, 0));
        rightPanel.setBackground(buttonPanelColor);
       
        JButton button1 = new JButton("Crear Libro");
        JButton button2 = new JButton("Eliminar Libro");
        JButton button3 = new JButton("Buscar Libro");
        JButton button4 = new JButton("Listar Libros");
        
        button1.setBackground(Color.YELLOW);
        button2.setBackground(Color.YELLOW);
        button3.setBackground(Color.YELLOW);
        button4.setBackground(Color.YELLOW);
        
        rightPanel.add(button1);
        rightPanel.add(button2);
        rightPanel.add(button3);
        rightPanel.add(button4);
        BibliotecaController controller = new BibliotecaController();
        button1.addActionListener(new ActionListener() {
        	
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(() -> {
                	
                	// Crear una instancia de VentanaCrearLibro pasando el objeto arbolLibros como parámetro
                	VentanaCrearLibro ventanaCrearLibro = new VentanaCrearLibro(controller);
                	ventanaCrearLibro.setVisible(true);
                   
                });
            }
        });

     // Agregar ActionListener al botón "Crear Libro"
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(() -> {
                    VentanaCrearLibro ventanaCrearLibro = new VentanaCrearLibro(controller);
                    ventanaCrearLibro.setVisible(true);
                });
            }
        });

        // Agregar ActionListener al botón "Eliminar Libro"
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(() -> {
                    VentanaEliminarLibro ventanaEliminarLibro = new VentanaEliminarLibro(controller);
                    ventanaEliminarLibro.setVisible(true);
                });
            }
        });

        // Agregar ActionListener al botón "Buscar Libro"
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(() -> {
                    VentanaBuscarLibro ventanaBuscarLibro = new VentanaBuscarLibro(controller);
                    ventanaBuscarLibro.setVisible(true);
                });
            }
        });

        // Agregar ActionListener al botón "Listar Libros"
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(() -> {
                    VentanaListarLibros ventanaListarLibros = new VentanaListarLibros(controller);
                    ventanaListarLibros.setVisible(true);
                });
            }
        });


        // Crear un panel en el centro para la imagen
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS)); // BoxLayout vertical
        centerPanel.setBackground(new Color(200,200,200));
        JLabel imageLabel = new JLabel();
        // Cargar la imagen (debe estar en el mismo directorio que este archivo)
        ImageIcon imageIcon = new ImageIcon("data/libreria.jpg");
        imageLabel.setIcon(imageIcon);

        // Alinea la imagen verticalmente al centro
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        centerPanel.add(Box.createVerticalGlue()); // Espaciado arriba de la imagen
        centerPanel.add(imageLabel);
        centerPanel.add(Box.createVerticalGlue()); // Espaciado debajo de la imagen

        // Agregar los paneles al marco principal
        frame.add(leftPanel, BorderLayout.WEST);
        frame.add(rightPanel, BorderLayout.EAST);
        frame.add(centerPanel, BorderLayout.CENTER);

        // Mostrar la ventana
        frame.setVisible(true);
    }
}




