package ba.unsa.etf.rpr;

public enum Grad {
    SARAJEVO("033"),
    TUZLA("035"),
    ZENICA("032"),
    BRCKO("049"),
    MOSTAR("036"),
    GORAZDE("038"),
    TRAVNIK("030"),
    ODZAK("031"),
    LIVNO("034"),
    BIHAC("037"),
    POSUSJE("039"),
    MRKONJIC_GRAD("050"),
    BANJA_LUKA("051"),
    PRIJEDOR("052"),
    DOBOJ("053"),
    SAMAC("054"),
    BIJELJINA("055"),
    ZVORNIK("056"),
    PALE("057"),
    FOCA("058"),
    TREBINJE("059");

    private final String pozivniBroj;

    Grad(String pozivniBroj){
        this.pozivniBroj=pozivniBroj;
    }
    public String getPozivniBroj(){
        return pozivniBroj;
    }

    public static Grad izPozivnog(String pozivni){
        for(Grad neki : Grad.values()){
            if(neki.getPozivniBroj().equals(pozivni))
                return neki;
        }
        return null;
    }

}
