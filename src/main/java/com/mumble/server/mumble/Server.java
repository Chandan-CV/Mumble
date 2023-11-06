package com.mumble.server.mumble;
import spark.Spark;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

import static spark.Spark.*;

public class Server extends Thread {

    public static String getHostAddress()  {
        String hostAddress ="";
        try{
            InetAddress ip = InetAddress.getLocalHost();
            hostAddress+=ip;
        }catch (UnknownHostException e){
            System.out.println("Error fetching the local address");
        }
        return "http://"+hostAddress.substring(hostAddress.length()-11)+":4567/";
    }


   @Override
    public void run(){
        System.out.println("Starting the server");
        get("/", (req, res) -> "This is sooo fucking cool!");
    }

    public  void stopServer(){
        System.out.println("Starting the server");
        Spark.stop();
    }
}
