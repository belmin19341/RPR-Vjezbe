package ba.unsa.etf.rpr;
import java.util.ArrayList;
import java.util.List;

public class KolekcijaImena {
    private List<String> iip; //iip = imena i prezimena!

    KolekcijaImena(List<String> iip){
        this.iip=iip;
    }

    public String getNajduzeIme(){
        String najduzeIme="";
        for(String s : iip){
            if(s.length()>najduzeIme.length())
                najduzeIme=s;
        }
        return najduzeIme;
    }

}
