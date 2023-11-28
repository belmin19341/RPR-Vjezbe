package ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.util.List;

public class KolekcijaPoruka {
    private List<String> poruke;

    public KolekcijaPoruka(List<?> listaObjekata) {
        this.poruke = new ArrayList<>();
        for (Object obj : listaObjekata) {
            if (obj instanceof LicneInformacije || obj instanceof InformacijeOStudentu ||
                    obj instanceof InformacijeONastavniku || obj instanceof Predmet) {
                poruke.add(((Predstavljiv) obj).predstavi());
            }
        }
    }

    public List<String> getPoruke() {
        return poruke;
    }
}
