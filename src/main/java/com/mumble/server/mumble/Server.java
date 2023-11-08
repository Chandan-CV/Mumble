package com.mumble.server.mumble;

import java.net.InetAddress;
import java.net.UnknownHostException;
import spark.Spark;

public class Server extends Thread {
    public Server() {
    }

    public static String getHostAddress() {
        String hostAddress = "";

        try {
            InetAddress ip = InetAddress.getLocalHost();
            hostAddress = hostAddress + ip;
        } catch (UnknownHostException var2) {
            System.out.println("Error fetching the local address");
        }

        String[] var10000 = hostAddress.split("/");
        return "http://" + var10000[1] + ":4567/";
    }

    public static String getJsonString() {
        return "[{\"title\":\"The Shawshank Redemption\",\"description\":\"Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.\"},{\"title\":\"The Godfather\",\"description\":\"The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.\"},{\"title\":\"The Dark Knight\",\"description\":\"When the menace known as The Joker emerges, Batman must confront his own demons to stop him.\"},{\"title\":\"Pulp Fiction\",\"description\":\"The lives of two mob hitmen, a boxer, a gangster and his wife, and a pair of diner bandits intertwine in four tales of violence and redemption.\"},{\"title\":\"The Matrix\",\"description\":\"A computer programmer discovers that reality as he knows it is a simulation created by machines to subjugate humanity.\"},{\"title\":\"Forrest Gump\",\"description\":\"The presidencies of Kennedy and Johnson, the events of Vietnam, Watergate, and other history unfold through the perspective of an Alabama man with an IQ of 75.\"},{\"title\":\"The Lord of the Rings: The Fellowship of the Ring\",\"description\":\"A meek Hobbit from the Shire and eight companions set out on a journey to destroy the powerful One Ring and save Middle-earth from the Dark Lord Sauron.\"},{\"title\":\"Inception\",\"description\":\"A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a C.E.O.\"},{\"title\":\"Schindler's List\",\"description\":\"In German-occupied Poland during World War II, Oskar Schindler gradually becomes concerned for his Jewish workforce after witnessing their persecution by the Nazis.\"},{\"title\":\"The Silence of the Lambs\",\"description\":\"A young F.B.I. cadet must receive the help of an incarcerated and manipulative cannibal killer to help catch another serial killer, a madman who skins his victims.\"}]";
    }

    public void run() {
        System.out.println("Starting the server");
        Spark.staticFileLocation("/public");
        CorsFilter.apply();
        Spark.get("/", (req, res) -> {
            res.redirect("/index.html");
            return null;
        });
        Spark.get("/getmovies", (req, res) -> {
            res.type("application/json");
            return DB.movies;
        });
        Spark.post("/sendresult", (request, response) -> {
            DB.resultString += request.body();
            return null;
        });
    }

    public void stopServer() {
        System.out.println("Starting the server");
        Spark.stop();
    }
}
