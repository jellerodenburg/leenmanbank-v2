package com.example.intellijprojectleenmanbankjavafx;

import com.example.intellijprojectleenmanbankjavafx.database.DBAccess;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Launcher extends Application {

    public static final DBAccess dbAccess = new DBAccess("pinmachineDB", "pinmachineUser", "Pinautomaatgebruiker1");

    public static void main(String[] args) {
        dbAccess.openConnection();
        launch();
        dbAccess.closeConnection();
    }

    // Na het openen van de pinterminal toont het ondernemersscherm de tekst: "Voer hier het bedrag in.."
    @Override
    public void start(Stage clientStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Launcher.class.getResource("PinautomaatWinkelierScherm.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        clientStage.setTitle("Voer hier het bedrag in..");
        clientStage.setScene(scene);
        clientStage.show();
    }

    // Na het openen van de pinterminal toont het klantscherm de tekst: "voer hieronder uw betaalpas in.."

    public void startCustomer(Stage customerStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Launcher.class.getResource("PinautomaatKlantScherm.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        customerStage.setTitle("voer hieronder uw betaalpas in..");
        customerStage.setScene(scene);
        customerStage.show();
    }


}
