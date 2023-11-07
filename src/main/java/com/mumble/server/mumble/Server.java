package com.mumble.server.mumble;
import spark.Spark;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

import static spark.Spark.*;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

//import com.google.zxing.BarcodeFormat;
//import com.google.zxing.WriterException;
//import com.google.zxing.client.j2se.MatrixToImageConfig;
//import com.google.zxing.client.j2se.MatrixToImageWriter;
//import com.google.zxing.common.BitMatrix;
//import com.google.zxing.qrcode.QRCodeWriter;

public class Server extends Thread {

    public static String getHostAddress()  {
        String hostAddress ="";
        try{
            InetAddress ip = InetAddress.getLocalHost();
            hostAddress+=ip;
        }catch (UnknownHostException e){
            System.out.println("Error fetching the local address");
        }
        return "http://"+hostAddress.split("/")[1]+":4567/";

    }



//    public static byte[] getQRCodeImage(String text, int width, int height) throws WriterException, IOException {
//        QRCodeWriter qrCodeWriter = new QRCodeWriter();
//        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);
//
//        ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
//        MatrixToImageConfig con = new MatrixToImageConfig( 0xFF000002 , 0xFFFFC041 ) ;
//
//        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream,con);
//        byte[] pngData = pngOutputStream.toByteArray();
//        return pngData;
//    }
//


   @Override
    public void run(){
        System.out.println("Starting the server");
        staticFileLocation("/public");
        get("/", (req, res) -> {res.redirect("/index.html");return  null;});
    }

    public  void stopServer(){
        System.out.println("Starting the server");
        Spark.stop();
    }
}
