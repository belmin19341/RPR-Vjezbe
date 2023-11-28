package ba.unsa.etf.rpr;

public class Ocjena extends LicneInformacije{
    private LicneInformacije osoba;
    private int ocjena;

    Ocjena(LicneInformacije osoba, int ocjena){
        super(osoba.getIme(), osoba.getPrezime());
        this.ocjena=ocjena;
    }

    public void setOcjena(int ocjena) {
        if(ocjena>0 && ocjena<10)
        this.ocjena = ocjena;

        else this.ocjena = 0;
    }

    public int getOcjena() {
        return this.ocjena;
    }
}
