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


    public abstract double pesoTotale();

    
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
}
