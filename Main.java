import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Main {
    public static void main(String[] args) {
        Treno t = new Treno();
        JFrame frame = new JFrame("Treno");
        try {
            UIManager.setLookAndFeel("com.apple.laf.AquaLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 700);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        JLabel label = new JLabel("Benvenuto nella gestione dei treni");
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Arial", Font.PLAIN, 30));
        frame.add(label, BorderLayout.NORTH);
        JLabel label1 = new JLabel("Scegli il tipo di vagone da aggiungere");
        label1.setFont(new Font("Arial", Font.PLAIN, 20));
        label1.setForeground(Color.WHITE);
        panel.add(label);
        panel.add(label1);
        panel.setBackground(Color.DARK_GRAY);
        JButton button1 = new JButton("Vagone Passeggeri");
        JButton button2 = new JButton("Vagone Merci");
        JButton button3 = new JButton("Stampa Treno");
        button1.setPreferredSize(new Dimension(200, 50));
        button2.setPreferredSize(new Dimension(200, 50));
        button3.setPreferredSize(new Dimension(200, 50));
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        //add image Thomas.jpg to the same panel as the buttons
        ImageIcon image = new ImageIcon("image.png");
        JLabel imageLabel = new JLabel(image);
        //make the angles of the image a little bit round do not use createLineBorder
        
        panel.add(imageLabel);

        frame.add(panel, BorderLayout.CENTER);
        JLabel label2 = new JLabel("Progetto realizzato da: Skerdi Velo, Kevin, Davide Rossini Treni S.p.A.");
/*         frame.add(label2, BorderLayout.SOUTH);
 */        
        frame.setVisible(true);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String codice = JOptionPane.showInputDialog("Inserisci codice");
                double pesoVuoto = Double.parseDouble(JOptionPane.showInputDialog("Inserisci peso vuoto"));
                String aziendaCostruttrice = JOptionPane.showInputDialog("Inserisci azienda costruttrice");
                int annoCostruzione = Integer.parseInt(JOptionPane.showInputDialog("Inserisci anno costruzione"));
                String classe = JOptionPane.showInputDialog("Inserisci classe");
                int postiDisponibili = Integer.parseInt(JOptionPane.showInputDialog("Inserisci posti disponibili"));
                int postiOccupati = Integer.parseInt(JOptionPane.showInputDialog("Inserisci posti occupati"));
                Vagone v = new VagonePasseggeri(codice, pesoVuoto, aziendaCostruttrice, annoCostruzione, classe,
                        postiDisponibili, postiOccupati);
                t.aggiungiVagone(v);
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codice = JOptionPane.showInputDialog("Inserisci codice");
                double pesoVuoto = Double.parseDouble(JOptionPane.showInputDialog("Inserisci peso vuoto"));
                String aziendaCostruttrice = JOptionPane.showInputDialog("Inserisci azienda costruttrice");
                int annoCostruzione = Integer.parseInt(JOptionPane.showInputDialog("Inserisci anno costruzione"));
                int lunghezza = Integer.parseInt(JOptionPane.showInputDialog("Inserisci lunghezza"));
                int numeroAssi = Integer.parseInt(JOptionPane.showInputDialog("Inserisci numero assi"));
                int numeroContainer = Integer.parseInt(JOptionPane.showInputDialog("Inserisci numero container"));
                Vagone v2 = new VagoneMerci(codice, pesoVuoto, aziendaCostruttrice, annoCostruzione, lunghezza,
                        numeroAssi, numeroContainer);
                t.aggiungiVagone(v2);
            }
        });
        frame.add(label2, BorderLayout.SOUTH);
        JLabel label3 = new JLabel();
        label3.setLocation(0, -20);
        label3.setSize(500, 700);
        label3.setFont(new Font("Arial", Font.PLAIN, 20));
        label3.setForeground(Color.BLACK);
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label2.setText("");
                label3.setText(t.toString());
                //vai a capo quando raggiungi il limite del frame
                label3.setText("<html>" + label3.getText() + "</html>");
                //aumenta l'height del frame ogni volta che va a capo
                frame.setSize(500, 700 + label3.getPreferredSize().height);
                frame.add(label3, BorderLayout.SOUTH);
                frame.setVisible(true);
            }
        });
        frame.setVisible(true);
    }
}
