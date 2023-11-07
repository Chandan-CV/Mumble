package com.mumble.server.mumble;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.Arrays;

public class HelloController {

    @FXML
    private Label welcomeText;
    @FXML
    private Button serverButton;

    @FXML
    protected void onHelloButtonClick() {
        if(Main.getServerStatus()){
            Main.stopServer();
            serverButton.setText("start server");
        }else{
            Main.startServer();
            serverButton.setText("stop server");
        }

    }

    @FXML
    protected void getStatusButtonClicked(){
        System.out.println(Main.getServerStatus());
        System.out.println(Main.getServer());
        System.out.println(Server.getHostAddress());
//        try{
//            System.out.println(Arrays.toString(Server.getQRCodeImage(Server.getHostAddress(), 200, 200)));
//        }catch(Exception e){
//        }
    }
}