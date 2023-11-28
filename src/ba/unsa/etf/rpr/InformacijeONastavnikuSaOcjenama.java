package ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.util.List;

public class InformacijeONastavnikuSaOcjenama extends InformacijeONastavniku implements MozeOcijeniti{
    private List<Ocjena> ocjene = new ArrayList<>();

    public InformacijeONastavnikuSaOcjenama(String ime, String prezime, String titula) {
        super(ime, prezime, titula);
    }

    @Override
    public Ocjena ocijeni(int x, LicneInformacije osoba) {
        Ocjena novaOcjena = new Ocjena(osoba,x);  // Osoba koja ocjenjuje nije specificirana
        ocjene.add(novaOcjena);
        return novaOcjena;
    }

    public List<Ocjena> getOcjene() {
        return ocjene;
    }
}
