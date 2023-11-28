package ba.unsa.etf.rpr;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        // Primjeri korištenja klasa
        InformacijeOStudentu student = new InformacijeOStudentu("John", "Doe", "2", "123456");
        InformacijeONastavniku nastavnik = new InformacijeONastavniku("Prof", "X", "PhD");
        Predmet predmet = new Predmet("Java Programming", "Introduction to Java programming language");

        // KolekcijaPoruka
        List<Predstavljiv> listaObjekata = new ArrayList<>();
        listaObjekata.add((Predstavljiv) student);
        listaObjekata.add((Predstavljiv) nastavnik);
        listaObjekata.add((Predstavljiv) predmet);

        KolekcijaPoruka kolekcijaPoruka = new KolekcijaPoruka(listaObjekata);
        List<String> poruke = kolekcijaPoruka.getPoruke();
        for (String poruka : poruke) {
            System.out.println(poruka);
        }

        /*// Zadatak 2
        PredmetSaOcjenama predmetSaOcjenama = new PredmetSaOcjenama("Matematika", "Osnove matematike");
        InformacijeONastavnikuSaOcjenama nastavnikSaOcenama = new InformacijeONastavnikuSaOcjenama("Profesor", "Y", "PhD");

        // Ocjenjivanje predmeta
        Ocjena ocjenaZaPredmet = predmetSaOcjenama.ocijeni(9);
        System.out.println("Ocjena za predmet " + predmetSaOcjenama.getNaziv() + ": " + ocjenaZaPredmet.getOcjena());

        // Ocjenjivanje nastavnika
        Ocjena ocjenaZaNastavnika = nastavnikSaOcenama.ocijeni(8);
        System.out.println("Ocjena za nastavnika " + nastavnikSaOcenama.getIme() + " " +
                nastavnikSaOcenama.getPrezime() + ": " + ocjenaZaNastavnika.getOcjena());
    }*/
    }

}
