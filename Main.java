import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Main {
    public static void main(String[] args) {
        Treno t = new Treno();
        JFrame frame = new JFrame("Treno");
        /* try {
            UIManager.setLookAndFeel("com.apple.laf.AquaLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        } */
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
        JButton button4 = new JButton("Rimuovi Vagone");
        JButton button5 = new JButton("Esci");
        button1.setPreferredSize(new Dimension(200, 50));
        button2.setPreferredSize(new Dimension(200, 50));
        button3.setPreferredSize(new Dimension(200, 50));
        button4.setPreferredSize(new Dimension(200, 50));
        button5.setPreferredSize(new Dimension(200, 50));
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);
        panel.add(button5);
        //add error message if the user tries to print an empty train
        //add image Thomas.jpg to the same panel as the buttons
        ImageIcon image = new ImageIcon("image.png");
        JLabel imageLabel = new JLabel(image);
        //make the angles of the image a little bit round do not use createLineBorder
        
        panel.add(imageLabel);

        frame.add(panel, BorderLayout.CENTER);
        JLabel label2 = new JLabel("Progetto realizzato da: Skerdi Velo, Kevin Tafa, Davide Rossini Treni S.p.A.");
        frame.add(label2, BorderLayout.SOUTH);       
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

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //check if the train is empty and display an alert
                if (t.getNumeroVagoni() == 0) {
                    JOptionPane.showMessageDialog(null, "Il treno è vuoto");
                } else {
                    JFrame frame2 = new JFrame("Treno");
                    //frame2 background color dark gray
                    frame2.getContentPane().setBackground(Color.DARK_GRAY);
                    //frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame2.setSize(500, 700);
                    frame2.setLocationRelativeTo(null);
                    frame2.setLayout(new BorderLayout());
                    JPanel panel2 = new JPanel();
                    panel2.setLayout(new FlowLayout());
                    JLabel label3 = new JLabel("Treno");
                    label3.setFont(new Font("Arial", Font.PLAIN, 30));
                    frame2.add(label3, BorderLayout.CENTER);
                    JLabel label4 = new JLabel();
                    label4.setFont(new Font("Arial", Font.PLAIN, 20));
                    t.toString(label4);
                    label4.setPreferredSize(new Dimension(500, 700));
                    label4.setForeground(Color.WHITE);
                    //align the text north
                    label4.setVerticalAlignment(JLabel.NORTH);
                    frame2.add(label4, BorderLayout.CENTER);
                    // Check if the train is void and display an alert
                    JLabel label5 = new JLabel("Progetto realizzato da: Skerdi Velo, Kevin Tafa, Davide Rossini Treni S.p.A.");
                    //colore bianco label5
                    label5.setForeground(Color.WHITE);
                    frame2.add(label5, BorderLayout.SOUTH);
                    frame2.setVisible(true);
                }
            }
        });
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(t.getNumeroVagoni() == 0){
                    JOptionPane.showMessageDialog(null, "Il treno è vuoto");
                }else{
                    String codice = JOptionPane.showInputDialog("Inserisci codice");
                    t.rimuoviVagone(codice);
                }
            }
        });
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        frame.setVisible(true);
    }
}
