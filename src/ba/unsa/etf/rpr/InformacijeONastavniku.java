package ba.unsa.etf.rpr;
import java.util.ArrayList;
import java.util.List;

public class InformacijeONastavniku extends LicneInformacije{
    private String titula;
    private List<Ocjena> ocjene;

    public InformacijeONastavniku(String ime, String prezime, String titula) {
        super(ime, prezime);
        this.titula = titula;
    }

    public String getTitula() {
        return titula;
    }

    public void setTitula(String titula) {
        this.titula = titula;
    }
}
