package edu.pidev3a32.controllers;

import edu.pidev3a32.entities.Personne;
import edu.pidev3a32.services.PersonneService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.SQLException;

public class AjouterPersonneController {

    @FXML
    private TextField nomTextField;

    @FXML
    private TextField prenomTextField;

    @FXML
    void ajouterPersonne(ActionEvent event) {
        PersonneService personneservice = new PersonneService();
        Personne personne = new Personne(nomTextField.getText(), prenomTextField.getText());
        try {
            personneservice.addEntity(personne);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Personne ajouter");
            alert.setContentText("success weeeee");
            alert.show();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/InfoPersonne.fxml"));
            try {
                Parent parent = loader.load();
                InfoPersonneController infoPersonneController = loader.getController();
                infoPersonneController.setNomProfile(nomTextField.getText());
                infoPersonneController.setPrenomProfile(prenomTextField.getText());
                nomTextField.getScene().setRoot(parent);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Booooooooooo");
            alert.setContentText(e.getMessage());
            alert.show();
        }
    }

}
