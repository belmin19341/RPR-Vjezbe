package ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// treba unijeti brojeve, koje cemo npr smjestiti u niz
        List<Double> listaBrojeva= new ArrayList<>();
        Scanner ulaz = new Scanner(System.in);
        boolean a=true;
        while(a){
            System.out.println("Unesite neki realan broj, ili stop za kraj (za sve drugo unos ce biti ponovljen): ");
            String linija = ulaz.nextLine(); //citamo kompletnu liniju ulaza kao string!!
            if(linija.equalsIgnoreCase("stop")) break; // poredimo uneseni string sa stringom stop zanemarujuci velika/mala slova
            try{
                double broj = Double.parseDouble(linija);
                listaBrojeva.add(broj);
            }
            catch(NumberFormatException e){
                System.out.println("Neispravan broj, pokusajte ponovo!");
            }

        }
        if(listaBrojeva.isEmpty()) System.out.println("Niste unijeli nijedan broj!");
        else{
            double min = dajMin(listaBrojeva);
            double max= dajMax(listaBrojeva);
            double mean = dajMedijanu(listaBrojeva);
            double dev= dajStandardnuDevijaciju(listaBrojeva);

            System.out.println("Najmanji clan je :" + min);
            System.out.println("Najveci clan je :" + max);
            System.out.println("Medijana je :" + mean);
            System.out.println("Standardna devijacija je :" + dev);
        }
    }

    public static double dajMin(List<Double> lista){
        double najmanji = lista.get(0);
        for(double broj:lista){
            if(broj<najmanji) najmanji=broj;
        }
        return najmanji;
    }

    public static double dajMax(List<Double> lista){
        double najveci = lista.get(0);
        for(double broj:lista){
            if(broj>najveci) najveci=broj;
        }
        return najveci;
    }

    public static double dajMedijanu(List<Double> lista){
        double suma=0;
        for(int i=0; i<lista.size(); i++) suma+=lista.get(i);
        return suma/lista.size();
    }
    public static double dajStandardnuDevijaciju(List<Double> lista){
        double mean=dajMedijanu(lista);
        double sumaKvadrata=0;
        for(int i=0; i<lista.size(); i++) sumaKvadrata+=Math.pow(lista.get(i)-mean,2);
        return Math.sqrt(sumaKvadrata/(lista.size()-1));

    }

}
