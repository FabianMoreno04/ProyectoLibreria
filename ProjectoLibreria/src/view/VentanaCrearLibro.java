package view;

import javax.swing.*;
import controller.BibliotecaController;
import models.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaCrearLibro extends JFrame {

    public VentanaCrearLibro(BibliotecaController controller) {
     
        setTitle("Crear Libro");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
        Color buttonPanelColor = new Color(200,200,200);
        
        JPanel panel = new JPanel(); 
        panel.setLayout(new GridLayout(8, 2)); 
        panel.setBackground(buttonPanelColor);
        
        JLabel labelTitulo = new JLabel("Título:");
        JTextField textFieldTitulo = new JTextField(20);

        JLabel labelISBN = new JLabel("ISBN:");
        JTextField textFieldISBN = new JTextField(20);

        JLabel labelAutor = new JLabel("Autor:");
        JTextField textFieldAutor = new JTextField(20);

        JLabel labelEditorial = new JLabel("Editorial:");
        JTextField textFieldEditorial = new JTextField(20);

        JLabel labelVolumen = new JLabel("Volumen:");
        JTextField textFieldVolumen = new JTextField(20);
        
        JLabel labelCantCopia = new JLabel("Cantidad de copias:");
        JTextField textFieldCantCopia = new JTextField(20);
        
        JLabel labelSede = new JLabel("Sede:");
        JComboBox<Sede> sedeComboBox = new JComboBox<>(controller.crearListaSedes().toArray(new Sede[0]));
        sedeComboBox.setBackground(Color.YELLOW);
        
        JButton guardarButton = new JButton("Guardar");
        guardarButton.setBackground(Color.YELLOW);
  

       
        panel.add(labelTitulo);
        panel.add(textFieldTitulo);
        panel.add(labelISBN);
        panel.add(textFieldISBN);
        panel.add(labelAutor);
        panel.add(textFieldAutor);
        panel.add(labelEditorial);
        panel.add(textFieldEditorial);
        panel.add(labelVolumen);
        panel.add(textFieldVolumen);
        panel.add(labelCantCopia);
        panel.add(textFieldCantCopia);
        panel.add(labelSede);
        panel.add(sedeComboBox);
        panel.add(new JLabel()); 
        panel.add(guardarButton);
        

    
        add(panel);

        
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	String titulo = textFieldTitulo.getText();
                String isbn = textFieldISBN.getText();
                String autor = textFieldAutor.getText();
                String editorial = textFieldEditorial.getText();
                String volumen = textFieldVolumen.getText();
                String cantCopias= textFieldCantCopia.getText();
                
                Autor autorLibro = new Autor(autor, "", ""); 
             
                
                if (titulo.isEmpty() || isbn.isEmpty() || autor.isEmpty() || editorial.isEmpty() || volumen.isEmpty()|| cantCopias.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Es necesario completar todos los campos. No debe haber ninguno vacío.");
                    return; 
                }
                String seleccionSede = sedeComboBox.getSelectedItem().toString();
                Libro nuevoLibro = new Libro(titulo, isbn, volumen, editorial, autorLibro,cantCopias,seleccionSede);
                
                
                controller.agregarLibro(nuevoLibro, seleccionSede);
                JOptionPane.showMessageDialog(null, "Libro guardado: " + titulo);

                dispose();
            }
        });
    }
  
}






