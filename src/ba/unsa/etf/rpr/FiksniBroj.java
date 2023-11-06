package ba.unsa.etf.rpr;

import java.util.*;

public class FiksniBroj extends TelefonskiBroj {
    private Grad grad;
    private String broj;

    FiksniBroj(Grad grad ,String broj) throws Izuzetak {
        if(grad == null) throw new Izuzetak("Neispravan pozivni broj za fiksni telefon!");
        this.grad=grad;
        this.broj=broj;
    }
    public Grad getGrad(){
        return grad;
    }

    @Override
    public String ispisi(){
        return grad.getPozivniBroj()+"/"+broj;
    }

    @Override
    public int hashCode(){
        return Objects.hash(grad,broj);
    }
}

