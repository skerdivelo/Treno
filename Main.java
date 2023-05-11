import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Main {
    public static void main(String[] args) {
        Treno t = new Treno();
        JFrame frame = new JFrame("Treno");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 700);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout()); //imposta il layout del frame come BorderLayout (NORTH, SOUTH, EAST, WEST, CENTER)
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout()); //imposta il layout del pannello come FlowLayout (da sinistra a destra)
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
                if (codice == null || codice.equals("")) {
                    return; // interrompe l'esecuzione del metodo se l'utente ha cliccato su "Cancel" o ha lasciato il campo vuoto
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
                if(codice == null || codice.equals("")){ //controlla se l'utente ha cliccato su "Cancel" o ha lasciato il campo vuoto
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
                if (t.getNumeroVagoni() == 0) { //controlla se il treno è vuoto
                    JOptionPane.showMessageDialog(null, "Il treno è vuoto");
                } else {
                    JFrame frame2 = new JFrame("Treno");
                    frame2.setResizable(false); //imposta la dimensione fissa
                    frame2.getContentPane().setBackground(Color.DARK_GRAY); //imposta il colore di sfondo
                    frame2.setSize(500, 700); //imposta la dimensione del frame
                    frame2.setLocationRelativeTo(null); //centra il frame
                    frame2.setLayout(new BorderLayout()); //imposta il layout
                    JLabel label3 = new JLabel("Treno"); //crea un nuovo label
                    label3.setForeground(Color.WHITE); //cambia il colore del testo
                    label3.setHorizontalAlignment(JLabel.CENTER); //centra il testo
                    label3.setFont(new Font("Arial", Font.PLAIN, 30)); //cammbia il font
                    frame2.add(label3, BorderLayout.NORTH); //aggiunge il label al frame
                    JPanel panelPasseggeri = new JPanel(); //crea un nuovo pannello
                    panelPasseggeri.setLayout(new BoxLayout(panelPasseggeri, BoxLayout.Y_AXIS)); //imposta il layout
                    panelPasseggeri.setBackground(Color.WHITE); //imposta il colore di sfondo
                    panelPasseggeri.setAlignmentX(Component.CENTER_ALIGNMENT); //centra il testo
                    JPanel panelMerci = new JPanel(); //crea un nuovo pannello
                    panelMerci.setLayout(new BoxLayout(panelMerci, BoxLayout.Y_AXIS)); //imposta il layout
                    panelMerci.setBackground(Color.WHITE); //imposta il colore di sfondo
                    for (Vagone vagone : t.getVagoni()) { //per ogni vagone nel treno
                        if (vagone instanceof VagonePasseggeri) { //se il vagone è un vagone passeggeri
                            JLabel label = new JLabel(vagone.toString()); //crea un testo con il toString del vagone
                            label.setFont(new Font("Arial", Font.PLAIN, 20)); //imposta il font
                            panelPasseggeri.add(label); //aggiunge il testo al pannello
                            label.setHorizontalAlignment(JLabel.CENTER); //centra il testo
                            panelPasseggeri.add(Box.createVerticalStrut(10)); //aggiunge una riga di spazio di 10 pixel
                        } else if (vagone instanceof VagoneMerci) { //se il vagone è un vagone merci
                            JLabel label = new JLabel(vagone.toString()); //crea un testo con il toString del vagone
                            label.setFont(new Font("Arial", Font.PLAIN, 20)); //imposta il font
                            panelMerci.add(label);  //aggiunge il testo al pannello
                            label.setHorizontalAlignment(JLabel.CENTER); //centra il testo
                            panelMerci.add(Box.createVerticalStrut(10)); //aggiunge una riga di spazio di 10 pixel
                        }
                    }

                    JScrollPane scrollPanePasseggeri = new JScrollPane(panelPasseggeri); //aggiunge la barra di scorrimento
                    scrollPanePasseggeri.setPreferredSize(new Dimension(500, 350)); //dimensione della barra di scorrimento
                    JScrollPane scrollPaneMerci = new JScrollPane(panelMerci); //aggiunge la barra di scorrimento
                    scrollPaneMerci.setPreferredSize(new Dimension(500, 350)); //dimensione della barra di scorrimento
                    JTabbedPane tabbedPane = new JTabbedPane(); //crea una scheda per ogni tipo di vagone (passeggeri e merci)
                    tabbedPane.addTab("Vagoni Passeggeri", scrollPanePasseggeri); //aggiunge la barra di scorrimento alla scheda
                    tabbedPane.addTab("Vagoni Merci", scrollPaneMerci); //aggiunge la barra di scorrimento alla scheda
                    frame2.add(tabbedPane, BorderLayout.CENTER); //aggiunge la scheda al frame
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
                //print a message dialog saying "Grazie per aver utilizzato il nostro programma" and add a timer of 5 seconds to close the program. Then add image quaglia.jpg and make it smaller
                JOptionPane.showMessageDialog(null, "Grazie per aver utilizzato il nostro programma");
                Timer timer = new Timer(3000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.exit(0);
                    }
                });
                timer.start();
                JFrame frame2 = new JFrame("Quaglia");
                frame2.setResizable(false);
                frame2.setSize(500, 500);
                frame2.setLocationRelativeTo(null);
                frame2.setLayout(new BorderLayout());
                JLabel label = new JLabel(new ImageIcon("quaglia.jpg"));
                frame2.add(label, BorderLayout.CENTER);
                frame2.setVisible(true);
            }
        });
        frame.setVisible(true);
    }
}
