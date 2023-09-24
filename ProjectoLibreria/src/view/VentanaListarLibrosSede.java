package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import controller.BibliotecaController;
import models.Libro;
import models.Sede;

public class VentanaListarLibrosSede extends JFrame{

	public VentanaListarLibrosSede(BibliotecaController controller) {
    	
        JFrame ventanaResultados = new JFrame();
        ventanaResultados.setSize(400, 300);
        
        setTitle("Listar Libros");
        setSize(400, 300); 
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
        Color buttonPanelColor = new Color(200,200,200);

        JPanel panel = new JPanel();
        panel.setBackground(buttonPanelColor);
        JTextArea textArea = new JTextArea(10, 30);
        JScrollPane scrollPane = new JScrollPane(textArea);

        JLabel labelSede = new JLabel("Sede:");
        JComboBox<Sede> sedeComboBox = new JComboBox<>(controller.crearListaSedes().toArray(new Sede[0]));
        sedeComboBox.setBackground(Color.YELLOW);
        
        JButton listarButton = new JButton("Listar Libros");
        listarButton.setBackground(Color.YELLOW);
        // Agregar elementos al panel
        panel.setLayout(new FlowLayout());
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(listarButton, BorderLayout.SOUTH);
        panel.add(labelSede, BorderLayout.NORTH);
        panel.add(sedeComboBox, BorderLayout.NORTH);

        // Agregar el panel a la ventana
        add(panel);
        listarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	String seleccionSede = sedeComboBox.getSelectedItem().toString();
                List<Libro> todosLosLibros = controller.obtenerLibrosEnSede(seleccionSede);
                // Construye el texto a mostrar en el área de texto
                StringBuilder listaLibrosText = new StringBuilder();
                for (Libro libro : todosLosLibros) {
                    listaLibrosText.append("Título: ").append(libro.getTitulo()).append("\n");
                    listaLibrosText.append("ISBN: ").append(libro.getIsbn()).append("\n");
                    listaLibrosText.append("Autor: ").append(libro.getAutor().getNombre()).append(" ").append(libro.getAutor().getApellido()).append("\n");
                    listaLibrosText.append("Editorial: ").append(libro.getEditorial()).append("\n");
                    listaLibrosText.append("Volumen: ").append(libro.getVolumen()).append("\n");
                    listaLibrosText.append("Cantidad disponible: ").append(libro.getCantidadDisponible()).append("\n");
                    listaLibrosText.append("-------------------------\n");
                }
                textArea.setText(listaLibrosText.toString());
            }
        });
    } 

}
