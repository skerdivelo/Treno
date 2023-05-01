//faccio caricamento dati con javaswing
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

/**
 * Main
 */
public class Main {
    public static void main(String[] args) {
        Treno t = new Treno();
        //make it beautiful and align it to the center
        JFrame frame = new JFrame("Treno");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        //add the label
        JLabel label = new JLabel("Inserisci i dati del vagone");
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        frame.add(label, c);
        //add the textfield
        JTextField textfield = new JTextField();
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 2;
        frame.add(textfield, c);
        //add the button
        JButton button = new JButton("Aggiungi");
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 2;
        frame.add(button, c);
        //add the list
        DefaultListModel<String> listModel = new DefaultListModel<>();
        JList<String> list = new JList<>(listModel);
        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 2;
        frame.add(list, c);
        //add the label
        JLabel label2 = new JLabel("Peso complessivo");
        c.gridx = 0;
        c.gridy = 4;
        c.gridwidth = 2;
        frame.add(label2, c);
        //add the textfield
        JTextField textfield2 = new JTextField();
        c.gridx = 0;
        c.gridy = 5;
        c.gridwidth = 2;
        frame.add(textfield2, c);
        //add the button
        JButton button2 = new JButton("Calcola");
        c.gridx = 0;
        c.gridy = 6;
        c.gridwidth = 2;
        frame.add(button2, c);
        frame.setVisible(true);
    }
}