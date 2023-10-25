package ba.unsa.etf.rpr;

public class Korisnik extends Osoba{
    private Racun racun;

    public Korisnik(String ime1, String prezime1){
        super(ime1,prezime1);
    }

    public void dodajRacun(Racun racun1){
        this.racun=racun1;
    }

    public Racun getRacun() {
        return racun;
    }

    public void setRacun(Racun racun) {
        this.racun = racun;
    }
}
