package ba.unsa.etf.rpr;

import java.util.List;
import java.util.ArrayList;

public class Banka {
    private long brojRacuna;
    private List<Korisnik> korisnici;
    private List<Uposlenik> uposlenici;

    public Banka(){
        this.brojRacuna=0;
        this.korisnici=new ArrayList<>();
        this.uposlenici=new ArrayList<>();
    }

    public long getBrojRacuna() {
        return brojRacuna;
    }

    public void setBrojRacuna(long brojRacuna) {
        this.brojRacuna = brojRacuna;
    }

    public List<Korisnik> getKorisnici() {
        return korisnici;
    }

    public void setKorisnici(List<Korisnik> korisnici) {
        this.korisnici = korisnici;
    }

    public List<Uposlenik> getUposlenici() {
        return uposlenici;
    }

    public void setUposlenici(List<Uposlenik> uposlenici) {
        this.uposlenici = uposlenici;
    }

    public Korisnik kreirajNovogKorisnika(String ime, String prezime){
        Korisnik novi=new Korisnik(ime,prezime);
        korisnici.add(novi);
        return novi;
    }

    public Uposlenik kreirajNovogUposlenika(String ime, String prezime){
        Uposlenik novi=new Uposlenik(ime,prezime);
        uposlenici.add(novi);
        return novi;
    }

    public Racun kreirajRacunZaKorisnika(Korisnik k1){
        long noviBrojRacuna = brojRacuna++;
        Racun novi= new Racun(getBrojRacuna(),k1);
        return novi;
    }


}
