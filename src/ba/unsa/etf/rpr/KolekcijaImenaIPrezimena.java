package ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.util.List;

public class KolekcijaImenaIPrezimena {
    private List<String> imena;
    private List<String> prezimena;

    public KolekcijaImenaIPrezimena(List<String> imena, List<String> prezimena) {
        this.imena = imena;
        this.prezimena = prezimena;
    }

    public int getIndexNajduzegPara() {
        int najduziIndex = -1;
        int najduzaDuzina = 0;

        for (int i = 0; i < imena.size(); i++) {
            String imePrezime = imena.get(i) + prezimena.get(i);
            if (imePrezime.length() > najduzaDuzina) {
                najduzaDuzina = imePrezime.length();
                najduziIndex = i;
            }
        }

        return najduziIndex;
    }

    public String getImeiPrezime(int i) {
        return imena.get(i) + " " + prezimena.get(i);
    }
}
