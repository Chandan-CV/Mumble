
package com.mumble.server.mumble;

import java.util.HashMap;
import spark.Filter;
import spark.Request;
import spark.Response;
import spark.Spark;

public final class CorsFilter {
    private static final HashMap<String, String> corsHeaders = new HashMap();

    public CorsFilter() {
    }

    public static void apply() {
        Filter filter = new Filter() {
            public void handle(Request request, Response response) throws Exception {
                CorsFilter.corsHeaders.forEach((key, value) -> {
                    response.header(key, value);
                });
            }
        };
        Spark.after(filter);
    }

    static {
        corsHeaders.put("Access-Control-Allow-Methods", "GET,PUT,POST,DELETE,OPTIONS");
        corsHeaders.put("Access-Control-Allow-Origin", "*");
        corsHeaders.put("Access-Control-Allow-Headers", "Content-Type,Authorization,X-Requested-With,Content-Length,Accept,Origin,");
        corsHeaders.put("Access-Control-Allow-Credentials", "true");
    }
}