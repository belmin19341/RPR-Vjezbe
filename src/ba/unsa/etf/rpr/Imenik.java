package ba.unsa.etf.rpr;
import java.util.*;

public class Imenik {
    private Map<String, TelefonskiBroj> imenik;

    Imenik() {
        imenik = new HashMap<String, TelefonskiBroj>();
    }

    public void dodaj(String ime, TelefonskiBroj broj) {
        imenik.put(ime, broj);
    }

    public String dajBroj(String ime) {
        if (imenik.containsKey(ime)) return imenik.get(ime).ispisi();
        return null;
    }

    public String dajIme(TelefonskiBroj broj) {
        for (Map.Entry<String, TelefonskiBroj> entry : imenik.entrySet()) {
            if (broj.ispisi().equals(entry.getValue().ispisi())) return entry.getKey();
        }
        return null;
    }

    public String naSlovo(char s) {
        StringBuilder rezultat = new StringBuilder();
        for (Map.Entry<String, TelefonskiBroj> entry : imenik.entrySet()) {
            String ime = entry.getKey();
            if (Character.toLowerCase(ime.charAt(0)) == Character.toLowerCase(s)) { // entry.getKey().stratsWith(String.valueOf(s))
                rezultat.append(ime).append(" - ").append(entry.getValue().ispisi()).append("\n");
            }
        }
        return rezultat.toString();
    }

    public Set<String> izGrada(Grad g) {
        Set<String> novi = new TreeSet<String>();
        for (Map.Entry<String, TelefonskiBroj> entry : imenik.entrySet()) {
            if (entry.getValue() instanceof FiksniBroj) {
                if (g.equals(((FiksniBroj) entry.getValue()).getGrad())) novi.add(entry.getKey());
            }
        }
        return novi;

    }

    /**
     * @param g
     * @return
     */
    public Set<TelefonskiBroj> izGradaBrojevi(Grad g) {
        Set<TelefonskiBroj> novi = new TreeSet<TelefonskiBroj>(new Comparator<TelefonskiBroj>() {
            @Override
            public int compare(TelefonskiBroj o1, TelefonskiBroj o2) {
                return o1.ispisi().compareTo(o2.ispisi());
            }
        });
        for (Map.Entry<String, TelefonskiBroj> entry : imenik.entrySet()) {
            if (entry.getValue() instanceof FiksniBroj) {
                FiksniBroj fb = (FiksniBroj) entry.getValue();
                if (fb.getGrad() == g) novi.add(fb);
            }

        }
        return novi;
    }

    @Override
    public String toString() {
        StringBuilder rezultat = new StringBuilder();
        for (Map.Entry<String, TelefonskiBroj> entry : imenik.entrySet()) {
            String ime = entry.getKey();
                rezultat.append(ime).append(" - ").append(entry.getValue().ispisi()).append("\n");

        }
        return rezultat.toString();
    }
}

