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
        Iterator<Vagone> iterator = vagoni.iterator(); // iteratore per scorrere la lista
        while (iterator.hasNext()) { // finché ci sono elementi
            Vagone vagone = iterator.next(); // prende l'elemento corrente
            if (vagone.getCodice().equals(codice)) { // se è quello che cerchiamo
                iterator.remove(); // lo rimuove
                if (vagone instanceof VagonePasseggeri) { // e aggiorna i contatori
                    contatoreVagoniPasseggeri--; // se è un vagone passeggeri
                } else if (vagone instanceof VagoneMerci) { // se è un vagone merci
                    contatoreVagoniMerci--; // se è un vagone merci
                }
                return vagone; // e lo restituisce
            }
        }
        return null; // se non lo trova restituisce null
    }
    

    public double pesoComplessivo() {
        double pesoTotale = 0; // peso totale del treno
        for (Vagone vagone : vagoni) { // scorre tutti i vagoni
            if (!(vagone instanceof Motrice)) { // se non è una motrice
                pesoTotale += vagone.pesoTotale(); // aggiunge il peso del vagone al peso totale
            } // altrimenti non fa nulla
        } 
        return pesoTotale;
    }

    //la classe dovrà prevedere un metodo che restituisca il peso complessivo del treno esclusa/e la/e motrice/i.

    public ArrayList<Vagone> getVagoni() {
        return vagoni; // restituisce la lista dei vagoni
    }
    //toString
    public String toString() {
        StringBuilder sb = new StringBuilder(); // StringBuilder per costruire la stringa da restituire.
        for (Vagone vagone : vagoni) { // scorre tutti i vagoni
            sb.append(vagone.toString()).append("\n"); // aggiunge la stringa del vagone alla stringa da restituire
        }
        sb.append("Numero di vagoni Passeggeri: ").append(contatoreVagoniPasseggeri).append("\n"); // aggiunge il numero di vagoni passeggeri
        sb.append("Numero di vagoni Merci: ").append(contatoreVagoniMerci).append("\n"); // aggiunge il numero di vagoni merci
        return sb.toString(); // restituisce la stringa
    }

    public int getNumeroVagoni() { 
        return vagoni.size();
    }

    public boolean verificaCodice(String codice) {
        for (Vagone vagone : vagoni) { // scorre tutti i vagoni
            if (vagone.getCodice().equals(codice)) { // se trova un vagone con lo stesso codice
                return true; // restituisce true
            }
        }
        return false; // se non trova nulla restituisce false
    }

    public String getVagone(String codice) {
        for (Vagone vagone : vagoni) { // scorre tutti i vagoni
            if (vagone.getCodice().equals(codice)) { // se trova un vagone con lo stesso codice
                return "Il peso complessivo del vagone (senza motrice) "+codice+" è "+pesoComplessivo(); // restituisce il peso complessivo del vagone   
            }
        }
        return null; // se non trova nulla restituisce null
    }
}
