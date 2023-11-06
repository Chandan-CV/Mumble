package com.mumble.server.mumble;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    private static Server server;
    private static boolean isRunning =false;
    static void startServer(){
        server = new Server();
        server.start();
        isRunning = true;

    }
   static void stopServer(){

        server.stopServer();
        isRunning = false;
    }
    static boolean getServerStatus(){
        return isRunning;
    }

    static Thread getServer(){
        return server;
    }
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}