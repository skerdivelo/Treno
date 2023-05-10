import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Main {
    public static void main(String[] args) {
        Treno t = new Treno();
        JFrame frame = new JFrame("Treno");
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
        ImageIcon image = new ImageIcon("image.png");
        JLabel imageLabel = new JLabel(image);
        
        panel.add(imageLabel);

        frame.add(panel, BorderLayout.CENTER);
        JLabel label2 = new JLabel("Progetto realizzato da: Skerdi Velo, Kevin Tafa, Davide Rossini Treni S.p.A.");
        frame.add(label2, BorderLayout.SOUTH);       
        frame.setVisible(true);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codice = JOptionPane.showInputDialog("Inserisci codice");
                if (codice == null) {
                    return; // interrompe l'esecuzione del metodo se l'utente ha cliccato su "Cancel"
                }
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
                if(codice == null){
                    return;
                }
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
                    frame2.getContentPane().setBackground(Color.DARK_GRAY);
                    frame2.setSize(500, 700);
                    frame2.setLocationRelativeTo(null);
                    frame2.setLayout(new BorderLayout());
                    JLabel label3 = new JLabel("Treno");
                    label3.setForeground(Color.WHITE);
                    //align label3 to the center
                    label3.setHorizontalAlignment(JLabel.CENTER);
                    label3.setFont(new Font("Arial", Font.PLAIN, 30));
                    frame2.add(label3, BorderLayout.NORTH);
                    JPanel panelPasseggeri = new JPanel();
                    panelPasseggeri.setLayout(new BoxLayout(panelPasseggeri, BoxLayout.Y_AXIS));
                    panelPasseggeri.setBackground(Color.WHITE);
                    panelPasseggeri.setAlignmentX(Component.CENTER_ALIGNMENT); //centra il testo
                    JPanel panelMerci = new JPanel();
                    panelMerci.setLayout(new BoxLayout(panelMerci, BoxLayout.Y_AXIS));
                    panelMerci.setBackground(Color.WHITE);
                    for (Vagone vagone : t.getVagoni()) {
                        if (vagone instanceof VagonePasseggeri) {
                            JLabel label = new JLabel(vagone.toString());
                            label.setFont(new Font("Arial", Font.PLAIN, 20));
                            panelPasseggeri.add(label);
                            //align label to the center
                            label.setHorizontalAlignment(JLabel.CENTER);
                            panelPasseggeri.add(Box.createVerticalStrut(10)); //aggiunge una riga di spazio di 10 pixel
                        } else if (vagone instanceof VagoneMerci) {
                            JLabel label = new JLabel(vagone.toString());
                            label.setFont(new Font("Arial", Font.PLAIN, 20));
                            panelMerci.add(label);
                            //align label to the center
                            label.setHorizontalAlignment(JLabel.CENTER);
                            panelMerci.add(Box.createVerticalStrut(10)); //aggiunge una riga di spazio di 10 pixel
                        }
                    }

                    JScrollPane scrollPanePasseggeri = new JScrollPane(panelPasseggeri);
                    scrollPanePasseggeri.setPreferredSize(new Dimension(500, 350));
                    JScrollPane scrollPaneMerci = new JScrollPane(panelMerci);
                    scrollPaneMerci.setPreferredSize(new Dimension(500, 350));
                    JTabbedPane tabbedPane = new JTabbedPane();
                    tabbedPane.addTab("Vagoni Passeggeri", scrollPanePasseggeri);
                    tabbedPane.addTab("Vagoni Merci", scrollPaneMerci);
                    frame2.add(tabbedPane, BorderLayout.CENTER);
                    JLabel label5 = new JLabel("Progetto realizzato da: Skerdi Velo, Kevin Tafa, Davide Rossini Treni S.p.A.");
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
                    if(codice == null){
                        return;
                    }
                    Vagone v = t.rimuoviVagone(codice);
                    if(v == null){
                        JOptionPane.showMessageDialog(null, "Vagone non trovato");
                    }else{
                        JOptionPane.showMessageDialog(null, "Vagone rimosso");
                    }
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
