import java.util.ArrayList;
import java.util.Iterator;

public class Treno {
    private ArrayList<Vagone> vagoni = new ArrayList<>();
    private int contatoreVagoniPasseggeri = 0;
    private int contatoreVagoniMerci = 0;

    public void aggiungiVagone(Vagone vagone) {
        vagoni.add(vagone);
        if (vagone instanceof VagonePasseggeri) {
            contatoreVagoniPasseggeri++;
        } else if (vagone instanceof VagoneMerci) {
            contatoreVagoniMerci++;
        }
    }

    public Vagone rimuoviVagone(String codice) {
        //the removed vagone is returned
        Iterator<Vagone> iterator = vagoni.iterator();
        while (iterator.hasNext()) {
            Vagone vagone = iterator.next();
            if (vagone.getCodice().equals(codice)) {
                iterator.remove();
                if (vagone instanceof VagonePasseggeri) {
                    contatoreVagoniPasseggeri--;
                } else if (vagone instanceof VagoneMerci) {
                    contatoreVagoniMerci--;
                }
                return vagone;
            }
        }
        return null;
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

    public ArrayList<Vagone> getVagoni() {
        return vagoni;
    }
    //toString
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Vagone vagone : vagoni) {
            sb.append(vagone.toString()).append("\n");
        }
        sb.append("Numero di vagoni Passeggeri: ").append(contatoreVagoniPasseggeri).append("\n");
        sb.append("Numero di vagoni Merci: ").append(contatoreVagoniMerci).append("\n");
        return sb.toString();
    }

    public int getNumeroVagoni() {
        return vagoni.size();
    }
}
