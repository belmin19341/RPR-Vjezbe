package ba.unsa.etf.rpr;

public class Osoba {
    private String ime, prezime;

    public Osoba(String ime1, String prezime1){
        this.ime=ime1;
        this.prezime=prezime1;
    }

    @Override
    public String toString() {
        return "Osoba{" +
                "ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                '}';
    }

    public static void main(String[] args) {
	// write your code here
    }
}
