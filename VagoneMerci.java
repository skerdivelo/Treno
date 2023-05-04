public class VagoneMerci extends Vagone {
    private double volumeCarico;
    private double pesoMaxCarico;
    private double pesoEffettivoCarico;
    public VagoneMerci(String codice, double pesoVuoto, String aziendaCostruttrice, int annoCostruzione,
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
        return " VagoneMerci: Il volume del Carico è: " + volumeCarico + "\nIl peso massimo del Carico è:" + pesoMaxCarico + "\nIl peso effettivo del Carico è: " + pesoEffettivoCarico + "\nIl codice=" + codice + "\nIl peso Vuoto=" + pesoVuoto + "\nL'azienda Costruttrice=" + aziendaCostruttrice + "\nL'anno di Costruzione=" + annoCostruzione+"\n-----------------------------------\n";
    }
}
