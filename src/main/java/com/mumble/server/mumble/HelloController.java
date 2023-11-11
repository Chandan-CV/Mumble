package com.mumble.server.mumble;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
public class HelloController {
    @FXML
    private Label welcomeText;

    Button btnScene1;

    @FXML
    protected void onHelloButtonClick(ActionEvent event) throws IOException{
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("genre.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node)  event.getSource()) .getScene() .getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();

    }
    @FXML
    protected void forurl(ActionEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("server.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }
    @FXML
    protected void generateQRcode(ActionEvent event) throws IOException {

        //put chandu's url along with the console thingy

        }


    }




