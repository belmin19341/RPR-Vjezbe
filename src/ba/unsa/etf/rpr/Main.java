package ba.unsa.etf.rpr;

import java.sql.*;
import java.util.Scanner;
import java.util.SortedMap;

public class Main {
    private static GeografijaDAO dao;
    private static Scanner ulaz;

    public static void main(String[] args) throws SQLException {
        dao = GeografijaDAO.getInstance();
        ulaz = new Scanner(System.in);

        int opcija = 0;

        do {
            System.out.println("\n");
            System.out.println("Unesite opciju: \n1.Ispis gradova\n2.Izmjena grada\n3.Dodavanje grada\n4.Dodavanje drzave\n5.Pretraga drzave\n" +
                    "6.Ispisi Drzave\n7.Izbrisi drzavu\n8.Glavni grad\n0.Kraj");
            opcija = ulaz.nextInt();
            if (ulaz.hasNextLine()) ulaz.nextLine(); // Prazni bafer nakon unosa opcije
            switch (opcija) {
                case 1:
                    ispisiGradove();
                    break;
                case 2:
                    izmijeniGrad();
                    break;
                case 3:
                    dodajGrad1();
                    break;
                case 4:
                    dodajDrzavu();
                    break;
                case 5:
                    nadjiDrzavu();
                    break;
                case 6:
                    ispisiDrzave();
                    break;
                case 7:
                    izbrisiDrzavu();
                    break;
                case 8:
                    glavniGrad();
                case 0:
                    break;
                default:
                    System.out.println("Nepoznata opcija!");
            }
        } while (opcija != 0);

        GeografijaDAO.removeInstance();
    }

    private static void glavniGrad() {
        System.out.println("Unesite ime drzave ciji glavni grad zelite: ");
        String ime = ulaz.nextLine();
        Grad g=new Grad();
        g=dao.glavniGrad(ime);
        if(g==null) System.out.println("Ne postoji trazena drzava!");
        else System.out.println("Glavni grad drzave "+ime+" je "+g.getNaziv());
    }

    private static void nadjiDrzavu() {
        System.out.println("Unesite ime drzave koju zelite pronaci: ");
        String ime = ulaz.nextLine();
        Drzava d = new Drzava();
        d=dao.nadjiDrzavu(ime);
        if(d==null) System.out.println("Drzava sa tim imenom ne postoji u tabeli!");
        else System.out.println("Podaci nadjene drzave su: "+d.getId()+" "+d.getNaziv()+" "+d.getGlavni_grad());
    }

    private static void izbrisiDrzavu() {
        System.out.println("Unesite ime drzave koju zelite obrisati: ");
        String dr = ulaz.nextLine();
        dao.obrisiDrzavu(dr);
    }

    private static void dodajDrzavu() throws SQLException {
        System.out.println("Unesite ime drzave: ");
        String naziv = ulaz.nextLine();
        System.out.println("Unesite indeks glavnog grada te drzave (0 ako ga nema u tabeli): ");
        int ind = ulaz.nextInt();
        Drzava d = new Drzava(0, naziv,ind);
        dao.dodajDrzavu(d);
        if (ulaz.hasNextLine()) ulaz.nextLine();
    }

    private static void dodajGrad1() throws SQLException {
        System.out.println("Unesite ime grada: ");
        String naziv = ulaz.nextLine();
        System.out.println("Unesite broj stanovnika grada: ");
        int brst = ulaz.nextInt();
        if (ulaz.hasNextLine()) ulaz.nextLine();
        System.out.println("Unesite indeks drzave u kojoj se nalazi(0 ako je nema u tabeli): ");
        int dr=ulaz.nextInt();
        Grad g = new Grad(0, naziv, brst, dr);
        dao.dodajGrad(g);
        if (ulaz.hasNextLine()) ulaz.nextLine();
    }

    private static void izmijeniGrad() {

        System.out.println("Unesite id grada kojeg zelite izmijeniti: ");
        int id = ulaz.nextInt();
        if (ulaz.hasNextLine()) ulaz.nextLine();
        System.out.println("Unesite novi naslov: ");
        String naziv = ulaz.nextLine();
        System.out.println("Unesite novi broj stanovnika: ");
        int brst = ulaz.nextInt();
        if (ulaz.hasNextLine()) ulaz.nextLine(); // Prazni bafer nakon unosa broja stanovnika
        System.out.println("Unesite indeks drzave u kojoj se nalazi: ");
        int dr=ulaz.nextInt();
        Grad g = new Grad(id, naziv, brst, dr);
        dao.izmijeniGrad(g);
        if (ulaz.hasNextLine()) ulaz.nextLine();
    }

    private static void ispisiGradove() {
        Drzava d = new Drzava();
        for (Grad g : dao.gradovi()) {
            d=dao.nadjiDrzavuPoGradu(g);
            System.out.println("ID: "+g.getId()+"   Naziv: "+g.getNaziv()+"("+d.getNaziv()+")"+"   Broj stanovnika: "+g.getBroj_stanovnika()+"    Indeks drzave: "+g.getDrzava());
        }
    }

    private static void ispisiDrzave() {
        for (Drzava d : dao.drzave()) {
            System.out.println("ID: "+d.getId()+"     Naziv: "+d.getNaziv()+"    Indeks glavnog grada: "+d.getGlavni_grad());
        }
    }

}

