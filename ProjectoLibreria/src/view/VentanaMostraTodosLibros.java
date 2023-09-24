package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import controller.BibliotecaController;
import models.Libro;

public class VentanaMostraTodosLibros extends JFrame{

	public VentanaMostraTodosLibros(BibliotecaController controller) {
		// Crea una ventana para mostrar los resultados de la búsqueda
        JFrame ventanaResultados = new JFrame();
        ventanaResultados.setSize(400, 300);
        
        setTitle("Listar Libros");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Color buttonPanelColor = new Color(200,200,200);

        // Crear los elementos de la ventana
        JPanel panel = new JPanel();
        panel.setBackground(buttonPanelColor);
        JTextArea textArea = new JTextArea(10, 30);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBackground(Color.YELLOW);
        JButton listarButton = new JButton("Listar Libros");
        listarButton.setBackground(Color.YELLOW);

        // Agregar elementos al panel
        panel.setLayout(new FlowLayout());
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(listarButton, BorderLayout.SOUTH);

        // Agregar el panel a la ventana
        add(panel);
        listarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Llama al controlador para obtener la lista de todos los libros
                List<Libro> todosLosLibros = controller.obtenerTodosLosLibros();
                // Construye el texto a mostrar en el área de texto
                StringBuilder listaLibrosText = new StringBuilder();
                for (Libro libro : todosLosLibros) {
                	listaLibrosText.append("----SEDE:  ").append(libro.getSede()).append("----\n");
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
