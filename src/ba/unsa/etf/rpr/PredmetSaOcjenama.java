package ba.unsa.etf.rpr;
import java.util.ArrayList;
import java.util.List;

public class PredmetSaOcjenama extends Predmet implements MozeOcijeniti {
    private List<Ocjena> ocjene = new ArrayList<>();

    public PredmetSaOcjenama(String naziv, String opis) {
        super(naziv, opis);
    }

    @Override
    public Ocjena ocijeni(int x, LicneInformacije osoba) {
        Ocjena novaOcjena = new Ocjena(osoba, x);
        ocjene.add(novaOcjena);
        return novaOcjena;
    }

    public List<Ocjena> getOcjene() {
        return ocjene;
    }


}
