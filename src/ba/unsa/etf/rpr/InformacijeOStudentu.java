package ba.unsa.etf.rpr;

public class InformacijeOStudentu extends LicneInformacije{
    private String godinaStudija,brojIndexa;

    InformacijeOStudentu(String ime, String prezime, String godSt, String bri){
        super(ime,prezime);
        this.godinaStudija=godSt;
        this.brojIndexa=bri;
    }

    public String getGodinaStudija() {
        return godinaStudija;
    }

    public void setGodinaStudija(String godinaStudija) {
        this.godinaStudija = godinaStudija;
    }

    public String getBrojIndexa() {
        return brojIndexa;
    }

    public void setBrojIndexa(String brojIndexa) {
        this.brojIndexa = brojIndexa;
    }
}
