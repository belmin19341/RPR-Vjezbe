package ba.unsa.etf.rpr;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.Mockito;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

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

    @Test
    public void testMockExternal() {
        Imenik i = mock(Imenik.class);
        Mockito.when(i.dajBroj("Belmin")).thenReturn("Nema nista");

        String t=i.dajBroj("Belmin");
        assertEquals(t,"Nema nista");
    }

    @Test
    public void testMockInternal() throws Izuzetak {
        Map<String, TelefonskiBroj> mapa = mock(Map.class);
        Mockito.when(mapa.get("Amar")).thenReturn(new FiksniBroj(Grad.SARAJEVO, "123-123"));

        String br=imenik.dajBroj("Amar");
        assertNotEquals(br, "036/123-123");
        assertEquals(br,"033/123-123");
    }
}