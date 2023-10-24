package ba.unsa.etf.rpr;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int prvi, drugi;
        Scanner ulaz = new Scanner(System.in);
        System.out.println("Unesite prvi broj: ");
        prvi = ulaz.nextInt();
        System.out.println("Unesite drugi broj: ");
        drugi = ulaz.nextInt();
        System.out.println("Prvi broj je: " + prvi + ", a drugi je: " + drugi + ".");
    }
}

