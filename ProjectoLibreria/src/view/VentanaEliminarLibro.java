package view;

import javax.swing.*;

import controller.BibliotecaController;
import models.Sede;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaEliminarLibro extends JFrame {

    public VentanaEliminarLibro(BibliotecaController controller) {
        
        setTitle("Eliminar Libro");
        setSize(400, 200); 
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
        Color buttonPanelColor = new Color(200,200,200);
        
        JPanel panel = new JPanel();
        panel.setBackground(buttonPanelColor);
        
        JLabel label = new JLabel("Ingrese el ISBN del libro a eliminar:");
        JTextField textField = new JTextField(20);
        
        JLabel labelSede = new JLabel("Sede:");
        JComboBox<Sede> sedeComboBox = new JComboBox<>(controller.crearListaSedes().toArray(new Sede[0]));
        sedeComboBox.setBackground(Color.YELLOW);
        
        JButton eliminarButton = new JButton("Eliminar");
        eliminarButton.setBackground(Color.YELLOW);
        
        panel.setLayout(new FlowLayout());
        panel.add(label);
        panel.add(textField);
        panel.add(labelSede);
        panel.add(sedeComboBox);
        panel.add(eliminarButton);

        add(panel);

        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	 // Obtener el ISBN del libro a eliminar
                String isbnEliminar = textField.getText();
                if (isbnEliminar.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Es necesario completar todos los campos. No debe haber ninguno vacío.");
                    return; 
                }
                String seleccionSede = sedeComboBox.getSelectedItem().toString();
                controller.eliminarLibro(isbnEliminar, seleccionSede);
  
                JOptionPane.showMessageDialog(null, "Libro eliminado con ISBN: " + isbnEliminar);
                dispose();
            }
        });
    }
}

