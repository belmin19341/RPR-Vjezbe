package ba.unsa.etf.rpr;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

public class ImenikTest {
    private static Imenik imenik = new Imenik();

    @BeforeAll
    public static void postaviPocetnePodatke() throws Izuzetak {
        imenik.dodaj("Amar", new FiksniBroj(Grad.SARAJEVO,"123-123"));
        imenik.dodaj("Amer", new FiksniBroj(Grad.ZENICA,"123-124"));
        imenik.dodaj("Ahmed", new MedunarodniBroj("+381","123123124"));
        imenik.dodaj("Belmin", new MobilniBroj(62,"123-125"));
    }

    @Test
    void dajBroj() {
        String broj = imenik.dajBroj("Belmin");
        assertEquals(broj, "062/123-125");
    }

    @Test
    void dajBrojPogresan() {
        String broj = imenik.dajBroj("Hamza");
        assertNull(broj);
    }

    @Test
    void dajIme() {
        String ime = imenik.dajIme(new MobilniBroj(62,"123-125"));
        assertEquals(ime,"Belmin");
    }

    @Test
    void dajFiksniIzuzetak() {
        assertThrows(Izuzetak.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                new FiksniBroj(null, "225-883");
            }
        });
    }


}