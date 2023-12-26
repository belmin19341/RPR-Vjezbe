package ba.unsa.etf.rpr;

public class Drzava {
    private int id, glavni_grad;
    private String naziv;

    public Drzava(int id, String naziv,  int glavni_grad) {
        this.id = id;
        this.glavni_grad = glavni_grad;
        this.naziv = naziv;
    }

    public Drzava() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGlavni_grad() {
        return glavni_grad;
    }

    public void setGlavni_grad(int glavni_grad) {
        this.glavni_grad = glavni_grad;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
}
