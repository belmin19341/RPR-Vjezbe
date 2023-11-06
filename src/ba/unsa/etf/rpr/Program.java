package ba.unsa.etf.rpr;

import com.sun.security.jgss.GSSUtil;

import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.Set;

public class Program {
    public static Scanner scanner = new Scanner(System.in);
    public static Imenik imenik = new Imenik();

    public static void main(String[] args) throws Izuzetak {
        popuniPodatke();
        while(true){
            System.out.println("Unesite zeljenu komandu: dodaj, dajBroj, dajIme, naSlovo, izGrada, izGradaBrojevi, imenik, izlaz");
            String unos = scanner.nextLine();
            switch (unos){
                case "dodaj":
                    System.out.println("Unesite ime: ");
                    try {
                        String ime = scanner.nextLine();
                        TelefonskiBroj br = unesiBrojTelefona();
                        imenik.dodaj(ime, br);
                    }
                    catch(Izuzetak i){
                        System.out.println(i.toString());
                    }
                    break;
                case "dajBroj":
                    System.out.println("Unesite ime ciji broj zelite: ");
                    String imee = scanner.nextLine();
                    String rez = imenik.dajBroj(imee);
                    if(rez!=null) System.out.println(rez);
                    else System.out.println("Nema tog broja u imeniku!");
                    break;
                case "dajIme":
                    try {
                        TelefonskiBroj br1 = unesiBrojTelefona();
                        String ime3 = imenik.dajIme(br1);
                        if (ime3 != null) System.out.println("Vlasnik broja " + br1 + " je " + ime3);
                    }
                    catch(Izuzetak i){
                        System.out.println(i.toString());
                    }
                    break;
                case "naSlovo":
                    System.out.println("Unesite prvo slovo trazenog imena: ");
                    String slovo = scanner.nextLine();
                    String rezultat = imenik.naSlovo(slovo.charAt(0));
                    System.out.println(rezultat);
                    break;
                case "izGrada":
                    System.out.println("Unesite grad: ");
                    String novigrad = scanner.nextLine();
                    try{
                        Grad g = Grad.valueOf(novigrad);
                        Set<String> rezz = imenik.izGrada(g);
                        System.out.println(rezz);
                    }
                    catch(Exception e){
                        System.out.println("Pogresan grad!");
                    }
                    break;
                case "izGradaBrojevi":
                    System.out.println("Unesite grad: ");
                    String gr = scanner.nextLine();
                    try{
                        Grad gg=Grad.valueOf(gr);
                        Set<TelefonskiBroj> rezzz = imenik.izGradaBrojevi(gg);
                        for(TelefonskiBroj t : rezzz){
                            System.out.println(t.ispisi());
                        }
                    }
                    catch(Exception e){
                        System.out.println("Pogresan grad!");
                    }
                    break;
                case "imenik":
                    System.out.println(imenik.toString());;
                    break;
                case "izlaz":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Pogresna komanda");
            }

        }
    }
    private static TelefonskiBroj unesiBrojTelefona() throws Izuzetak {
        System.out.println("Unesi tip broja: fiksni, mobilni ili medunarodni");
        String tip = scanner.nextLine();
        switch (tip){
            case "fiksni":
                System.out.println("Unesite pozivni: ");
                String pozivni = scanner.nextLine();
                System.out.println("Unesite broj: ");
                String broj = scanner.nextLine();
                return new FiksniBroj(Grad.izPozivnog(pozivni), broj);

            case "mobilni":
                System.out.println("Unesite mrezu: ");
                int mreza = scanner.nextInt();
                System.out.println("Unesite broj: ");
                String broj1 = scanner.nextLine();
                return new MobilniBroj(mreza,broj1);

            case "medunarodni":
                System.out.println("Unesite pozivni broj drzave (npr +387)");
                String pbd = scanner.nextLine();
                System.out.println("Unesite broj: ");
                String br = scanner.nextLine();
                return new MedunarodniBroj(pbd,br);
        }
        return null;
    }

    private static void popuniPodatke() throws Izuzetak {
        imenik.dodaj("Belmin", new FiksniBroj(Grad.ZENICA, "456-789"));
        imenik.dodaj("Tarik", new FiksniBroj(Grad.SARAJEVO, "496-721"));
        imenik.dodaj("Nina", new MobilniBroj(62,"784-321"));
        imenik.dodaj("Alma", new MedunarodniBroj("+49","457896321"));
    }
}
