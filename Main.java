//faccio caricamento dati con javaswing
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Main
 */
public class Main {
    public static void main(String[] args) {
        Treno t = new Treno();
        //Vagone v = new VagonePasseggeri(null, 0, null, 0, null, 0, 0);
        //Vagone v2 = new VagoneMerci(" ", 0, " ", 0, 0, 0, 0);
        //GUI that acts as a menu, that has 3 buttons, 2 buttons to choose the type of wagon, and 1 button to print the train, The input should be a dialog box, the window should be placed center and the buttons should be placed in the middle center of the window.
        JFrame frame = new JFrame("Treno");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        //put a title Benvenuto nella gestione dei treni
        JLabel label = new JLabel("Benvenuto nella gestione dei treni");
        //change the color of the font to white
        label.setForeground(Color.WHITE);
        //increase the font size of the title
        label.setFont(new Font("Arial", Font.PLAIN, 30));
        //Move the title to the top of the window
        frame.add(label, BorderLayout.NORTH);
        //put a label: "Scegli il tipo di vagone da aggiungere"
        JLabel label1 = new JLabel("Scegli il tipo di vagone da aggiungere");
        label1.setFont(new Font("Arial", Font.PLAIN, 20));
        //change the color of the font to white
        label1.setForeground(Color.WHITE);
        //move the label to the center of the window
        panel.add(label);
        panel.add(label1);
        //change background color to light black
        panel.setBackground(Color.DARK_GRAY);
        JButton button1 = new JButton("Vagone Passeggeri");
        JButton button2 = new JButton("Vagone Merci");
        JButton button3 = new JButton("Stampa Treno");
        //change the width of the buttons
        button1.setPreferredSize(new Dimension(200, 50));
        button2.setPreferredSize(new Dimension(200, 50));
        button3.setPreferredSize(new Dimension(200, 50));
        //move the buttons to the center of the window
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        frame.add(panel, BorderLayout.CENTER);
        //on the bottom of the window, put a label: "Progetto realizzato da: Skerdi Velo, Tafa Kevin, Davoz Gamer Treni S.p.A."
        JLabel label2 = new JLabel("Progetto realizzato da: Skerdi Velo, Tafa Kevin, Davoz Gamer Treni S.p.A.");
        frame.add(label2, BorderLayout.SOUTH);

        frame.setVisible(true);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //JOptionPane.showMessageDialog(null, "Vagone passeggeri");
                //JOptionPane.showMessageDialog(null, "Inserisci codice");
                String codice = JOptionPane.showInputDialog("Inserisci codice");
                //JOptionPane.showMessageDialog(null, "Inserisci peso vuoto");
                double pesoVuoto = Double.parseDouble(JOptionPane.showInputDialog("Inserisci peso vuoto"));
                //JOptionPane.showMessageDialog(null, "Inserisci azienda costruttrice");
                String aziendaCostruttrice = JOptionPane.showInputDialog("Inserisci azienda costruttrice");
                //JOptionPane.showMessageDialog(null, "Inserisci anno costruzione");
                int annoCostruzione = Integer.parseInt(JOptionPane.showInputDialog("Inserisci anno costruzione"));
                //JOptionPane.showMessageDialog(null, "Inserisci classe");
                String classe = JOptionPane.showInputDialog("Inserisci classe");
                //JOptionPane.showMessageDialog(null, "Inserisci posti disponibili");
                int postiDisponibili = Integer.parseInt(JOptionPane.showInputDialog("Inserisci posti disponibili"));
                //JOptionPane.showMessageDialog(null, "Inserisci posti occupati");
                int postiOccupati = Integer.parseInt(JOptionPane.showInputDialog("Inserisci posti occupati"));
                Vagone v = new VagonePasseggeri(codice, pesoVuoto, aziendaCostruttrice, annoCostruzione, classe,
                        postiDisponibili, postiOccupati);
                t.aggiungiVagone(v);
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //JOptionPane.showMessageDialog(null, "Vagone merci");
                //JOptionPane.showMessageDialog(null, "Inserisci codice");
                String codice = JOptionPane.showInputDialog("Inserisci codice");
                //JOptionPane.showMessageDialog(null, "Inserisci peso vuoto");
                double pesoVuoto = Double.parseDouble(JOptionPane.showInputDialog("Inserisci peso vuoto"));
                //JOptionPane.showMessageDialog(null, "Inserisci azienda costruttrice");
                String aziendaCostruttrice = JOptionPane.showInputDialog("Inserisci azienda costruttrice");
                //JOptionPane.showMessageDialog(null, "Inserisci anno costruzione");
                int annoCostruzione = Integer.parseInt(JOptionPane.showInputDialog("Inserisci anno costruzione"));
                //JOptionPane.showMessageDialog(null, "Inserisci lunghezza");
                int lunghezza = Integer.parseInt(JOptionPane.showInputDialog("Inserisci lunghezza"));
                //JOptionPane.showMessageDialog(null, "Inserisci numero assi");
                int numeroAssi = Integer.parseInt(JOptionPane.showInputDialog("Inserisci numero assi"));
                //JOptionPane.showMessageDialog(null, "Inserisci numero container");
                int numeroContainer = Integer.parseInt(JOptionPane.showInputDialog("Inserisci numero container"));
                Vagone v2 = new VagoneMerci(codice, pesoVuoto, aziendaCostruttrice, annoCostruzione, lunghezza,
                        numeroAssi, numeroContainer);
                t.aggiungiVagone(v2);
            }
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //JOptionPane.showMessageDialog(null, "Stampa treno");
                JOptionPane.showMessageDialog(null, t.toString());
            }
        });
        //set visible
        frame.setVisible(true);
    }
}
