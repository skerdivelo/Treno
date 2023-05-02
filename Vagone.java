/*Si intendono gestire mediante un programma
Java i vagoni che compongono un treno. Per ogni vagone si hanno alcuni attributi fondamentali:
• codice;
• peso a vuoto;
•azienda costruttrice;
• anno di costruzione.
Per i vagoni passeggeri si devono inoltre memorizzare 
.classe;
• numero di posti disponibili;
• numero di posti occupati:
mentre per i vagoni merci si devono memorizzare:
• volume di carico;
• peso massimo di carico;
• peso effettivo di carico.
Per la composizione di un treno è fondamentale la gestione del peso dei vagoni, che nel caso dei carri merci è di immediata determinazione, mentre per le carrozze passeggeri deve essere stimato considerando un peso medio per occupante di 65 kg (valore che potrebbe essere necessario modificare).
Dopo aver disegnato il diagramma UML delle
Classi della soluzione proposta e averlo implementato in linguaggio Java, codificare una classe java Treno con uno o più metodi per l'aggiunta di vagoni: la classe dovrà prevedere un metodo che restituisca il peso complessivo del treno esclusa e la/e motrice/i.
*/
//abstract class Vagone

public abstract class Vagone {
    protected String codice;
    protected double pesoVuoto;
    protected String aziendaCostruttrice;
    protected int annoCostruzione;

    public Vagone(String codice, double pesoVuoto, String aziendaCostruttrice, int annoCostruzione) {
        this.codice = codice;
        this.pesoVuoto = pesoVuoto;
        this.aziendaCostruttrice = aziendaCostruttrice;
        this.annoCostruzione = annoCostruzione;
    }

    // Metodo astratto da implementare nelle sottoclassi
    public abstract double pesoTotale();

    // Getters e setters
    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public double getPesoVuoto() {
        return pesoVuoto;
    }

    public void setPesoVuoto(double pesoVuoto) {
        this.pesoVuoto = pesoVuoto;
    }

    public String getAziendaCostruttrice() {
        return aziendaCostruttrice;
    }

    public void setAziendaCostruttrice(String aziendaCostruttrice) {
        this.aziendaCostruttrice = aziendaCostruttrice;
    }

    public int getAnnoCostruzione() {
        return annoCostruzione;
    }

    public void setAnnoCostruzione(int annoCostruzione) {
        this.annoCostruzione = annoCostruzione;
    }
    
    //toString
    @Override
    public String toString() {
        return "Vagone [annoCostruzione=" + annoCostruzione + ", aziendaCostruttrice=" + aziendaCostruttrice
                + ", codice=" + codice + ", pesoVuoto=" + pesoVuoto + "]";
    }
}
