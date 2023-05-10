public class VagoneMerci extends Vagone {
    private double volumeCarico;
    private double pesoMaxCarico;
    private double pesoEffettivoCarico;
    private static int contaVagoni = 0;

    public VagoneMerci(String codice, double pesoVuoto, String aziendaCostruttrice, int annoCostruzione,
        double volumeCarico, double pesoMaxCarico, double pesoEffettivoCarico) {
        super(codice, pesoVuoto, aziendaCostruttrice, annoCostruzione);
        this.volumeCarico = volumeCarico;
        this.pesoMaxCarico = pesoMaxCarico;
        this.pesoEffettivoCarico = pesoEffettivoCarico;
        contaVagoni++;
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

    @Override
    public String toString() {
        return "<html>"+contaVagoni+"Codice: " + codice + "<br>" +
            "Peso vuoto: " + pesoVuoto + "<br>" +
            "Azienda costruttrice: " + aziendaCostruttrice + "<br>" +
            "Anno di costruzione: " + annoCostruzione + "<br>" +
            "Volume di carico: " + volumeCarico + "</html>";
    }
}
