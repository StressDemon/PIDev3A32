package edu.pidev3a32.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class InfoPersonneController {

    @FXML
    private TextField nomProfile;

    @FXML
    private TextField prenomProfile;

    public void setNomProfile(String nomProfile) {
        this.nomProfile.setText(nomProfile);
    }

    public void setPrenomProfile(String prenomProfile) {
        this.prenomProfile.setText(prenomProfile);
    }
}
