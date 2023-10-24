package ba.unsa.etf.rpr;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Unesite broj n: ");
        int n=scanner.nextInt();

        for(int i=1; i<n; i++){
            if(Djeljiv(i)) System.out.println(i);
        }
    }

    public static boolean Djeljiv(int n){
        int suma=SumaCifara(n);
        return n%suma==0;
    }

    public static int SumaCifara(int n){
        int s=0;
        while(n>0){
            s+=(n%10);
            n/=10;
        }
        return s;

    }


}
