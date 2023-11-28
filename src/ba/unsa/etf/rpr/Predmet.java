package ba.unsa.etf.rpr;
import java.util.ArrayList;
import java.util.List;

public class Predmet {
    private String naziv, opis;
    private List<Ocjena> ocjene;


    Predmet(String naziv, String opis){
        this.naziv=naziv;
        this.opis=opis;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }
}
