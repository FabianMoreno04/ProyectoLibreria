package view;
import javax.swing.*;

import controller.BibliotecaController;
import models.Libro;
import models.Sede;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class VentanaBuscarLibro extends JFrame {

    public VentanaBuscarLibro(BibliotecaController controller) {
 
        setTitle("Buscar Libro");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setBackground(new Color(255, 204, 153));
        Color buttonPanelColor = new Color(200,200,200);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));
        panel.setBackground(buttonPanelColor); 
        
        JLabel label = new JLabel("Ingrese el Titulo o codigo ISBN :");
        JTextField textField = new JTextField(20);
        
        JLabel labelSede = new JLabel("Sede:");
        JComboBox<Sede> sedeComboBox = new JComboBox<>(controller.crearListaSedes().toArray(new Sede[0]));
        sedeComboBox.setBackground(Color.YELLOW);
        
        
        JButton buscarButton = new JButton("Buscar");
        buscarButton.setBackground(Color.YELLOW);
        

        panel.setLayout(new FlowLayout());
        panel.add(label);
        panel.add(textField);
        panel.add(labelSede);
        panel.add(sedeComboBox);
        panel.add(buscarButton);

        add(panel);

        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            
                String nameoISBN = textField.getText();
                if (nameoISBN.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Es necesario completar todos los campos. No debe haber ninguno vacío.");
                    return; 
                }
                String seleccionSede = sedeComboBox.getSelectedItem().toString();
                List<Libro> resultados = controller.buscarLibro(nameoISBN, seleccionSede);
                mostrarResultados(resultados);
                dispose();
            }
        });
    }

    private void mostrarResultados(List<Libro> resultados) {
      
        JFrame ventanaResultados = new JFrame();
        ventanaResultados.setSize(400, 300);
        ventanaResultados.setLocationRelativeTo(null);
    
        JPanel panelResultados = new JPanel();
        panelResultados.setLayout(new BorderLayout());
        JTextArea textArea = new JTextArea(10, 30);
        textArea.setBackground(new Color(200,200,200));
        
        JLabel titleLabel = new JLabel("Resultados de la Búsqueda", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        panelResultados.add(titleLabel, BorderLayout.NORTH);

        
        StringBuilder resultadoText = new StringBuilder();
        for (Libro libro : resultados) {
            resultadoText.append("Título: ").append(libro.getTitulo()).append("\n");
            resultadoText.append("ISBN: ").append(libro.getIsbn()).append("\n");
            resultadoText.append("Autor: ").append(libro.getAutor().getNombre()).append(" ").append(libro.getAutor().getApellido()).append("\n");
            resultadoText.append("Editorial: ").append(libro.getEditorial()).append("\n");
            resultadoText.append("Volumen: ").append(libro.getVolumen()).append("\n");
            resultadoText.append("Cantidad disponible: ").append(libro.getCantidadDisponible()).append("\n");
            resultadoText.append("-------------------------\n");
        }
        textArea.setText(resultadoText.toString());

        JScrollPane scrollPane = new JScrollPane(textArea);
        panelResultados.add(scrollPane, BorderLayout.CENTER);

        ventanaResultados.add(panelResultados);
        ventanaResultados.setVisible(true);
    }
}

