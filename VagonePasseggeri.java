public class VagonePasseggeri extends Vagone {
    private String classe;
    private int postiDisponibili;
    private int postiOccupati;
    private static int contaVgoni = 0;

    public VagonePasseggeri(String codice, double pesoVuoto, String aziendaCostruttrice, int annoCostruzione,
                            String classe, int postiDisponibili, int postiOccupati) {
        super(codice, pesoVuoto, aziendaCostruttrice, annoCostruzione);
        this.classe = classe;
        this.postiDisponibili = postiDisponibili;
        this.postiOccupati = postiOccupati;
        contaVgoni++;
    }

    @Override
    public double pesoTotale() {
        double pesoOccupanti = postiOccupati * 65.0;
        return pesoVuoto + pesoOccupanti;
    }

    

    // Getters e setters
    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public int getPostiDisponibili() {
        return postiDisponibili;
    }

    public void setPostiDisponibili(int postiDisponibili) {
        this.postiDisponibili = postiDisponibili;
    }

    public int getPostiOccupati() {
        return postiOccupati;
    }

    public void setPostiOccupati(int postiOccupati) {
        this.postiOccupati = postiOccupati;
    }
    
    @Override
    public String toString() {
        return "<html>"+contaVgoni+")Codice: " + codice + "<br>" +
            "Posti disponibili: " + postiDisponibili + "<br>" +
            "Posti occupati: " + postiOccupati + "<br>" +
            "Classe: " + classe + "<br>" +
            "Peso vuoto: " + pesoVuoto + "<br>" +
            "Azienda costruttrice: " + aziendaCostruttrice + "<br>" +
            "Anno di costruzione: " + annoCostruzione + "<br>" + "</html>";
    }
}
