import java.util.ArrayList;

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
    @Override
    public String toString() {
        String s = "";
        //use the substring to remove the square brackets from the string and create an output like this: "Il treno è composto da: " + vagoni + " Il peso complessivo è: " + pesoComplessivo() + " kg"
        for (Vagone vagone : vagoni) {
            s += vagone.toString() + "\n";
        }
        return "Il treno è composto da: " + s.substring(1, s.length() - 1) + "\nIl peso complessivo è: " + pesoComplessivo() + " kg\n-----------------------------------\n";
    }
}
