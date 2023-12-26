package ba.unsa.etf.rpr.lv78;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Controller {
    public TextField fldIme;
    public TextField fldPrezime;
    public TextField fldEmail;
    public TextField fldKorisnickoIme;
    public PasswordField fldLozinka;
    public ListView<Korisnik> listKorisnici;


    private KorisniciModel model = new KorisniciModel();

    public Controller() {
        model.napuni();
    }

    @FXML
    public void initialize() {
        listKorisnici.setItems(model.getKorisnici());

        listKorisnici.getSelectionModel().selectedItemProperty().addListener((obs,
                                                                              oldKorisnik, newKorisnik) -> {
            model.setTrenutniKorisnik(newKorisnik);
             listKorisnici.refresh();

             if(oldKorisnik!=null) {

                 fldIme.textProperty().unbindBidirectional(oldKorisnik.imeProperty());
                 fldPrezime.textProperty().unbindBidirectional(oldKorisnik.prezimeProperty());
                 fldEmail.textProperty().unbindBidirectional(oldKorisnik.emailProperty());
                 fldKorisnickoIme.textProperty().unbindBidirectional(oldKorisnik.korisnickoImeProperty());
                 fldLozinka.textProperty().unbindBidirectional(oldKorisnik.lozinkaProperty());
             }
             if(newKorisnik ==null){
                 fldIme.setText("");
                 fldPrezime.setText("");
                 fldEmail.setText("");
                 fldKorisnickoIme.setText("");
                 fldLozinka.setText("");

             }
             else {

                 fldIme.textProperty().bindBidirectional(model.getTrenutniKorisnik().imeProperty());
                 fldPrezime.textProperty().bindBidirectional(model.getTrenutniKorisnik().prezimeProperty());
                 fldEmail.textProperty().bindBidirectional(model.getTrenutniKorisnik().emailProperty());
                 fldKorisnickoIme.textProperty().bindBidirectional(model.getTrenutniKorisnik().korisnickoImeProperty());
                 fldLozinka.textProperty().bindBidirectional(model.getTrenutniKorisnik().lozinkaProperty());
             }

        });


    }

    public void krajClicked(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void dodajKorisnika(ActionEvent actionEvent) {
        model.dodajNovogKorisnika();
        listKorisnici.getSelectionModel().selectLast();
    }
}