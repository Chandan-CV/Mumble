
package com.mumble.server.mumble;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private Button serverButton;

    public HelloController() {
    }

    @FXML
    protected void onHelloButtonClick() {
        if (Main.getServerStatus()) {
            Main.stopServer();
            this.serverButton.setText("start server");
        } else {
            Main.startServer();
            this.serverButton.setText("stop server");
        }

    }

    @FXML
    protected void getStatusButtonClicked() {
        System.out.println(Main.getServerStatus());
        System.out.println(Main.getServer());
        System.out.println(Server.getHostAddress());
    }

    @FXML
    protected void GetResultButtonClicked(){
        System.out.println(DB.resultString);
        System.out.println(DB.calculateResults());
    }
}
