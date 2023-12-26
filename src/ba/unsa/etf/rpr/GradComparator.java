package ba.unsa.etf.rpr;

import java.util.Comparator;

public class GradComparator implements Comparator<Grad> {
    @Override
    public int compare(Grad grad1, Grad grad2) {
        // Uporedite gradove na osnovu broja stanovnika u opadajućem redosledu
        return Integer.compare(grad2.getBroj_stanovnika(), grad1.getBroj_stanovnika());
    }
}

