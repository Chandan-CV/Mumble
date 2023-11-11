
package com.mumble.server.mumble;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.awt.Desktop;
public class ServerControllers {
    @FXML
    private Label welcomeText;
    @FXML
    private Button serverButton;

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
        System.out.println("https://api.qrserver.com/v1/create-qr-code/?size=150x150&data="+Server.getHostAddress());
        System.out.println(Server.getHostAddress());
    }

    @FXML
    protected  void GetQRButtonClicked(ActionEvent event) throws IOException {
        Runtime rt = Runtime.getRuntime();
        String url = "https://api.qrserver.com/v1/create-qr-code/?size=600x600&data="+Server.getHostAddress();
        String[] browsers = { "firefox", "mozilla" };

        StringBuffer cmd = new StringBuffer();
        for (int i = 0; i < browsers.length; i++)
            if(i == 0)
                cmd.append(String.format(    "%s \"%s\"", browsers[i], url));
            else
                cmd.append(String.format(" || %s \"%s\"", browsers[i], url));
        // If the first didn't work, try the next browser and so on

        rt.exec(new String[] { "sh", "-c", cmd.toString() });
    }


    @FXML
    protected void GetResultButtonClicked(){
        System.out.println(DB.resultString);
        String result = DB.getMovieArray().get(DB.calculateResults()).toString();
        System.out.println(result);
        JSONObject res = (JSONObject) JSONValue.parse(result);
        welcomeText.setText(res.get("title").toString());

    }
}