package ba.unsa.etf.rpr;

public class Pobjednik {
    private String ime, prezime;
    private int brojZnakova;
    private KolekcijaImena kolekcijaimena;

    Pobjednik(Object kolim){
        String pobjednik = "";
        if(kolim instanceof KolekcijaImena)
        pobjednik = ((KolekcijaImena) kolim).getNajduzeIme();

        else if(kolim instanceof KolekcijaImenaIPrezimena){
            String ime =""; String prezime ="";
            int indeks = ((KolekcijaImenaIPrezimena) kolim).getIndexNajduzegPara();
            pobjednik = ((KolekcijaImenaIPrezimena) kolim).getImeiPrezime(indeks);
        }

        String[] iip = pobjednik.split(" ");
        this.ime=iip[0];
        this.prezime=iip[1];
        this.brojZnakova=pobjednik.length();
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public int getBrojZnakova() {
        return brojZnakova;
    }

    public void setBrojZnakova(int brojZnakova) {
        this.brojZnakova = brojZnakova;
    }

    public KolekcijaImena getKolekcijaimena() {
        return kolekcijaimena;
    }

    public void setKolekcijaimena(KolekcijaImena kolekcijaimena) {
        this.kolekcijaimena = kolekcijaimena;
    }
}


