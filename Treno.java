import java.util.ArrayList;

import javax.swing.JLabel;

public class Treno {
private ArrayList<Vagone> vagoni = new ArrayList<>();

public void aggiungiVagone(Vagone vagone) {
    vagoni.add(vagone);
}

//rimuovo il cagone dato il codice string
public void rimuoviVagone(String codice) {
    for (Vagone vagone : vagoni) {
        if (vagone.getCodice().equals(codice)) {
            vagoni.remove(vagone);
            break;
        }
    }
}

    public double pesoComplessivo() {
        double pesoTotale = 0;
        for (Vagone vagone : vagoni) {
            if (!(vagone instanceof Motrice)) {
                pesoTotale += vagone.pesoTotale();
            }
        }
        return pesoTotale;
    }

    //toString
    public String toString(JLabel label) {
        for(Vagone vagone : vagoni) {
            label.setText("<html>" + label.getText() + vagone.toString() + "<br></html>");
        }
        return label.getText();
    }

    public int getNumeroVagoni() {
        return vagoni.size();
    }
}
