/*per i vagoni merci si devono memorizzare:
• volume di carico;
• peso massimo di carico;
• peso effettivo di carico. */
public class VagoneMerce extends Vagone {
    private double volumeCarico;
    private double pesoMaxCarico;
    private double pesoEffettivoCarico;
    public VagoneMerce(String codice, double pesoVuoto, String aziendaCostruttrice, int annoCostruzione,
        double volumeCarico, double pesoMaxCarico, double pesoEffettivoCarico) {
        super(codice, pesoVuoto, aziendaCostruttrice, annoCostruzione);
        this.volumeCarico = volumeCarico;
        this.pesoMaxCarico = pesoMaxCarico;
        this.pesoEffettivoCarico = pesoEffettivoCarico;
    }
    @Override
    public double pesoTotale() {
        return pesoVuoto + pesoEffettivoCarico;
    }

    // Getters e setters
    public double getVolumeCarico() {
        return volumeCarico;
    }

    public void setVolumeCarico(double volumeCarico) {
        this.volumeCarico = volumeCarico;
    }

    public double getPesoMaxCarico() {
        return pesoMaxCarico;
    }

    public void setPesoMaxCarico(double pesoMaxCarico) {
        this.pesoMaxCarico = pesoMaxCarico;
    }

    public double getPesoEffettivoCarico() {
        return pesoEffettivoCarico;
    }

    public void setPesoEffettivoCarico(double pesoEffettivoCarico) {
        this.pesoEffettivoCarico = pesoEffettivoCarico;
    }
    
    //toString
    @Override
    public String toString() {
        return "VagoneMerce [volumeCarico=" + volumeCarico + ", pesoMaxCarico=" + pesoMaxCarico
                + ", pesoEffettivoCarico=" + pesoEffettivoCarico + ", codice=" + codice + ", pesoVuoto=" + pesoVuoto
                + ", aziendaCostruttrice=" + aziendaCostruttrice + ", annoCostruzione=" + annoCostruzione + "]";
    }
}
