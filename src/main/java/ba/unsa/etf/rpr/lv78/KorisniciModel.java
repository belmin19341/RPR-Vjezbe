package ba.unsa.etf.rpr.lv78;

import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class KorisniciModel {
    private ObservableList<Korisnik> korisnici = FXCollections.observableArrayList();
    private SimpleObjectProperty<Korisnik> trenutniKorisnik = new SimpleObjectProperty<>();

    public void napuni(){
        korisnici.add(new Korisnik("Belmin","Durmo","bdurmo@etf.ba","bdurmo","bd1234"));
        korisnici.add(new Korisnik("AAAA","BBBB","AAABBB@etf.ba","aaabbb","ab1234"));
        korisnici.add(new Korisnik("CCCC","DDDD","cccddd@etf.ba","cccddd","cd1234"));
        trenutniKorisnik.set(null);
    }

    public ObservableList<Korisnik> getKorisnici() {
        return korisnici;
    }

    public void setKorisnici(ObservableList<Korisnik> korisnici) {
        this.korisnici = korisnici;
    }

    public Korisnik getTrenutniKorisnik() {
        return trenutniKorisnik.get();
    }

    public SimpleObjectProperty<Korisnik> trenutniKorisnikProperty() {
        return trenutniKorisnik;
    }

    public void setTrenutniKorisnik(Korisnik trenutniKorisnik) {
        this.trenutniKorisnik.set(trenutniKorisnik);
    }
    public void dodajNovogKorisnika() {
        Korisnik noviKorisnik = new Korisnik("", "", "", "", "");
        korisnici.add(noviKorisnik);
        trenutniKorisnik.set(noviKorisnik);
    }
}
