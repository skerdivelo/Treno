import java.util.ArrayList;

public class Treno {
private ArrayList<Vagone> vagoni = new ArrayList<>();

// Aggiunge un vagone al treno
public void aggiungiVagone(Vagone vagone) {
    vagoni.add(vagone);
}

// Restituisce il peso complessivo del treno, esclusa la motrice
    public double pesoComplessivo() {
        double pesoTotale = 0;
        for (Vagone vagone : vagoni) {
            if (!(vagone instanceof Motrice)) {
                pesoTotale += vagone.pesoTotale();
            }
        }
        return pesoTotale;
    }
}