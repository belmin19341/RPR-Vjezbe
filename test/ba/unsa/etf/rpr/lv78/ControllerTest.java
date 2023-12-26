package ba.unsa.etf.rpr.lv78;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(ApplicationExtension.class)
class ControllerTest {
    @Start
    public void start(Stage stage) throws Exception {
        Parent mainNode = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource("/fxml/korisnici.fxml")));
        stage.setScene(new Scene(mainNode));
        stage.show();
        stage.toFront();
    }

    @Test
    public void prviTest(FxRobot robot) {
        TextField fldIme =
                robot.lookup("#fldIme").queryAs(TextField.class);
        robot.clickOn("#dodajClick");
        robot.clickOn("#fldIme");

        robot.write("prviTest");

        assertEquals("prviTest", fldIme.getText());
    }

    @Test
    public void drugiTest(FxRobot robot) {
        TextField fldIme =
                robot.lookup("#fldIme").queryAs(TextField.class);
        robot.clickOn("#dodajClick");
        robot.clickOn("#fldIme");
        assertEquals("", fldIme.getText());
    }
    @Test
    public void treciTest(FxRobot robot) {
        robot.clickOn(".list-cell");
        TextField fldIme = robot.lookup("#fldIme").queryAs(TextField.class);
        assertEquals("Belmin",fldIme.getText());
    }

    @Test
    public void cetvrtiTest(FxRobot robot){
        ListView lista =
                robot.lookup("#listKorisnici").queryAs(ListView.class);
        robot.clickOn(".list-cell");
        TextField fldIme = robot.lookup("#fldIme").queryAs(TextField.class);
        TextField fldPrezime = robot.lookup("#fldPrezime").queryAs(TextField.class);
        assertEquals("Belmin Durmo",lista.getItems().get(0).toString());
    }

    @Test
    public void petiTest(FxRobot robot){
        TextField fldIme =
                robot.lookup("#fldIme").queryAs(TextField.class);
        TextField fldPrezime =
                robot.lookup("#fldPrezime").queryAs(TextField.class);
        robot.clickOn("#dodajClick");
        robot.clickOn("#fldIme");
        robot.write("imee");
        robot.clickOn("#fldPrezime");
        robot.write("prezimee");

        assertEquals("imee", fldIme.getText());
        assertEquals("prezimee", fldPrezime.getText());
    }

}