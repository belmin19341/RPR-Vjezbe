package ba.unsa.etf.rpr;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class GeografijaDAO {
    private Connection conn;
    private PreparedStatement ps,  noviIdUpitGrad, noviIdUpitDrzava, dodajGradUpit, dodajDrzavuUpit, izmijeniGradUpit, nadjiDrzavuUpit,
            brisiGradoveUpit, obrisiDrzavuUpit,ps1, glavniGradUpit, drzavaPoGraduUpit;

    private static GeografijaDAO instance = null;

    private GeografijaDAO() throws SQLException {
        String url = "jdbc:sqlite:" + System.getProperty("user.home") + "/.bazaapp1/baza.db";
        conn = DriverManager.getConnection(url);
        try{
            ps = conn.prepareStatement("SELECT * from grad");
            ps1=conn.prepareStatement("SELECT * FROM drzava");
        }
        catch(SQLException e){
            kreirajBazu();
            ps = conn.prepareStatement("SELECT * from grad");
            ps1=conn.prepareStatement("SELECT * FROM drzava");

        }

        noviIdUpitGrad = conn.prepareStatement("SELECT MAX(id)+1 FROM grad");
        noviIdUpitDrzava = conn.prepareStatement("SELECT MAX(id)+1 FROM drzava");
        dodajGradUpit = conn.prepareStatement("INSERT INTO grad VALUES(?,?,?,?)");
        dodajDrzavuUpit = conn.prepareStatement("INSERT INTO drzava VALUES(?,?,?)");
        izmijeniGradUpit = conn.prepareStatement("UPDATE grad SET naziv=?, broj_stanovnika=?, drzava=? WHERE id=?");
        nadjiDrzavuUpit = conn.prepareStatement("SELECT * FROM drzava WHERE naziv=?");
        brisiGradoveUpit = conn.prepareStatement("DELETE FROM grad WHERE drzava=?");
        obrisiDrzavuUpit = conn.prepareStatement("DELETE FROM drzava WHERE naziv= ?");
        glavniGradUpit = conn.prepareStatement("SELECT * FROM  grad WHERE id=?");
        drzavaPoGraduUpit = conn.prepareStatement("SELECT * FROM drzava WHERE id=?");

    }

    private void kreirajBazu() {
        Scanner ulaz = null;
        try {
            ulaz = new Scanner(new FileInputStream("baza.db.sql"));
            String sqlUpit = "";
            while (ulaz.hasNext()) {
                sqlUpit += ulaz.nextLine();
                if ( sqlUpit.length() > 1 && sqlUpit.charAt( sqlUpit.length()-1 ) == ';') {
                    try {
                        Statement stmt = conn.createStatement();
                        stmt.execute(sqlUpit);
                        sqlUpit = "";
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
            ulaz.close();
        } catch (FileNotFoundException e) {
            System.out.println("Ne postoji SQL datoteka... nastavljam sa praznom bazom");
        }
    }

    public static GeografijaDAO getInstance() throws SQLException {
        if(instance==null) instance = new GeografijaDAO();
        return instance;
    }

    public static void removeInstance() throws SQLException {
        if(instance==null) return;
        instance.conn.close();
        instance=null;
    }

    public ArrayList<Grad> gradovi(){
        ArrayList<Grad> rezultat = new ArrayList<>();

        try{
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Grad g = new Grad(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
                rezultat.add(g);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Collections.sort(rezultat,new GradComparator());
    return rezultat;
    }

    public ArrayList<Drzava> drzave(){
        ArrayList<Drzava> rezultat = new ArrayList<>();

        try{
            ResultSet rs = ps1.executeQuery();
            while(rs.next()){
                Drzava d = new Drzava(rs.getInt(1), rs.getString(2), rs.getInt(3));
                rezultat.add(d);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rezultat;
    }


    public void dodajGrad(Grad grad) throws SQLException {
        ResultSet rs = noviIdUpitGrad.executeQuery();
        if(rs.next()) grad.setId(rs.getInt(1));
        else grad.setId(1);

        dodajGradUpit.setInt(1,grad.getId());
        dodajGradUpit.setString(2,grad.getNaziv());
        dodajGradUpit.setInt(3,grad.getBroj_stanovnika());
        dodajGradUpit.setInt(4,grad.getDrzava());
        dodajGradUpit.execute();

    }

    public void dodajDrzavu(Drzava drzava) throws SQLException {
        ResultSet rs = noviIdUpitDrzava.executeQuery();
        if(rs.next()) drzava.setId(rs.getInt(1));
        else drzava.setId(1);

        dodajDrzavuUpit.setInt(1,drzava.getId());
        dodajDrzavuUpit.setString(2,drzava.getNaziv());
        dodajDrzavuUpit.setInt(3,drzava.getGlavni_grad());
        dodajDrzavuUpit.execute();

    }

    public void izmijeniGrad(Grad grad){
        try {
            izmijeniGradUpit.setString(1,grad.getNaziv());
            izmijeniGradUpit.setInt(2,grad.getBroj_stanovnika());
            izmijeniGradUpit.setInt(3,grad.getDrzava());
            izmijeniGradUpit.setInt(4,grad.getId());
            izmijeniGradUpit.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public Drzava nadjiDrzavu(String drzava){
        try {
            nadjiDrzavuUpit.setString(1,drzava);
            ResultSet rs = nadjiDrzavuUpit.executeQuery();
            if(rs.next())
                return new Drzava(rs.getInt(1),rs.getString(2), rs.getInt(3));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void obrisiDrzavu(String drzava){
        Drzava d = nadjiDrzavu(drzava);

        try {
            brisiGradoveUpit.setInt(1,d.getId());
            obrisiDrzavuUpit.setString(1,drzava);
            brisiGradoveUpit.execute();
            obrisiDrzavuUpit.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Grad glavniGrad(String drzava){
        Drzava d = nadjiDrzavu(drzava);
        Grad g = new Grad();
        try{
            glavniGradUpit.setInt(1,d.getGlavni_grad());
            ResultSet rs = glavniGradUpit.executeQuery();
            if(rs.next())
            g = new Grad(rs.getInt(1),rs.getString(2),rs.getInt(3), rs.getInt(4));
            else g=null;

        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return g;
    }

    public Drzava nadjiDrzavuPoGradu(Grad g){
        Drzava d = new Drzava();
        try{
            drzavaPoGraduUpit.setInt(1,g.getDrzava());
            ResultSet rs = drzavaPoGraduUpit.executeQuery();
            if(rs.next())
            d=new Drzava(rs.getInt(1),rs.getString(2),rs.getInt(3));
            else d=null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return d;
    }

}


