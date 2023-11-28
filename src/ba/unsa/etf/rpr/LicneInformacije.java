package ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.util.List;

abstract class LicneInformacije {

    private String ime;
    private String prezime;

    LicneInformacije(String ime, String prezime){
        this.ime = ime;
        this.prezime = prezime;
    }

    public String getIme() {
        return ime;
    }
    public void setIme(String ime) {
        this.ime = ime;
    }
    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public static void main(String[] args) {
        // Primjeri korištenja klasa
        InformacijeOStudentu student = new InformacijeOStudentu("John", "Doe", "2", "123456");
        InformacijeONastavniku nastavnik = new InformacijeONastavniku("Prof", "X", "PhD");
        Predmet predmet = new Predmet("Java Programming", "Introduction to Java programming language");

        // Zadatak 2
        PredmetSaOcjenama predmetSaOcjenama = new PredmetSaOcjenama("Matematika", "Osnove matematike");
        InformacijeONastavnikuSaOcjenama nastavnikSaOcenama = new InformacijeONastavnikuSaOcjenama("Profesor", "Y", "PhD");

        // Ocjenjivanje predmeta
        Ocjena ocjenaZaPredmet = predmetSaOcjenama.ocijeni(9, new InformacijeOStudentu("Amar", "Hodzic","2","18352"));
        System.out.println("Ocjena za predmet " + predmetSaOcjenama.getNaziv() + ": " + ocjenaZaPredmet.getOcjena());

        // Ocjenjivanje nastavnika
        Ocjena ocjenaZaNastavnika = nastavnikSaOcenama.ocijeni(8, new InformacijeONastavniku("Belmin", "Durmo", "dr"));
        System.out.println("Ocjena za nastavnika " + nastavnikSaOcenama.getIme() + " " +
                nastavnikSaOcenama.getPrezime() + ": " + ocjenaZaNastavnika.getOcjena());
    }
    


}