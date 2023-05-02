public class VagonePasseggero extends Vagone {
    private String classe;
    private int postiDisponibili;
    private int postiOccupati;

    public VagonePasseggero(String codice, double pesoVuoto, String aziendaCostruttrice, int annoCostruzione,
                            String classe, int postiDisponibili, int postiOccupati) {
        super(codice, pesoVuoto, aziendaCostruttrice, annoCostruzione);
        this.classe = classe;
        this.postiDisponibili = postiDisponibili;
        this.postiOccupati = postiOccupati;
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
    
    //toString
    @Override
    public String toString() {
        return "VagonePasseggero [classe=" + classe + ", postiDisponibili=" + postiDisponibili + ", postiOccupati="
                + postiOccupati + ", codice=" + codice + ", pesoVuoto=" + pesoVuoto + ", aziendaCostruttrice="
                + aziendaCostruttrice + ", annoCostruzione=" + annoCostruzione + "]";
    }
}
