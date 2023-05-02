import java.util.ArrayList;

public class Treno {
private ArrayList<Vagone> vagoni = new ArrayList<>();

public void aggiungiVagone(Vagone vagone) {
    vagoni.add(vagone);
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
}
