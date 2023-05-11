public class Motrice extends Vagone {

    public Motrice(String codice, double pesoVuoto, String aziendaCostruttrice, int annoCostruzione) {
        super(codice, pesoVuoto, aziendaCostruttrice, annoCostruzione);
    }
    @Override
    public double pesoTotale() {
        return pesoVuoto;
    }
}