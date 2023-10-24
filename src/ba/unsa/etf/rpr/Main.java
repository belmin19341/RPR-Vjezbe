package ba.unsa.etf.rpr;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static double racunajSinus(double broj){
        return Math.sin(broj);
    }

    public static long racunajFaktorijel(int broj) {
        if (broj == 0) {
            return 1;
        }
        long faktorijel = 1;
        for (int i = 1; i <= broj; i++) {
            faktorijel *= i;
        }
        return faktorijel;
    }

    public static void main(String[] args) {

        if(args.length!=1){
            System.out.println("Unesite jedan broj kao argument: ");
            return;
        }
        try {
            double broj = Double.parseDouble(args[0]);
            double sinus = racunajSinus(broj);
            System.out.println("Sinus od " + broj + " je: " + sinus);

            int broj2 = (int) broj;
            long factorial = racunajFaktorijel(broj2);
            System.out.println("Faktorijel od " + broj2 + " je: " + factorial);
        }
        catch(NumberFormatException e){
            System.out.println("Ne valja broj");
        }
    }
}

