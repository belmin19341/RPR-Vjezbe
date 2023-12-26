package ba.unsa.etf.rpr.lv78;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KorisniciModelTest {
    @Test
    void getTrenutniKorisnik() {
        KorisniciModel model = new KorisniciModel();
        model.napuni();
        model.setTrenutniKorisnik(model.getKorisnici().get(0));
        assertEquals("Belmin", model.getTrenutniKorisnik().getIme());
    }

    @Test
    void trenutniKorisnikProperty() {
        KorisniciModel model = new KorisniciModel();
        assertEquals(null, model.getTrenutniKorisnik());
    }

    @Test
    void dodaj() {
        KorisniciModel model = new KorisniciModel();
        model.dodajNovogKorisnika();
        model.dodajNovogKorisnika();
        assertEquals(2, model.getKorisnici().size());
    }

    @Test
    void napuni() {
        KorisniciModel model = new KorisniciModel();
        model.napuni();
        assertEquals(false, model.getKorisnici().isEmpty());
    }
}