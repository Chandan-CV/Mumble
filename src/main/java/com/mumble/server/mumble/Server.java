package com.mumble.server.mumble;
import static spark.Spark.*;

public class Server {
    public static void main(String[] args) {
        get("/hello", (req, res) -> "This is sooo fucking cool!");
    }
}
