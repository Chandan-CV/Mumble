
package com.mumble.server.mumble;
import org.json.simple.JSONArray;
import org.json.simple.JSONValue;


public class DB {
    static String resultString ="";
    static String movies = "[{\"id\":0,\"title\":\"Superbad\",\"description\":\"Two high school friends try to make the most of their last days before college.\",\"poster\":\"https://example.com/superbad-poster.jpg\",\"genre\":\"Teen Comedy\"},{\"id\":1,\"title\":\"The Hangover\",\"description\":\"A bachelor party in Las Vegas turns into a wild, unforgettable adventure.\",\"poster\":\"https://example.com/hangover-poster.jpg\",\"genre\":\"Adult Comedy\"},{\"id\":2,\"title\":\"Anchorman: The Legend of Ron Burgundy\",\"description\":\"The misadventures of a 1970s news anchor and his team at a San Diego television station.\",\"poster\":\"https://example.com/anchorman-poster.jpg\",\"genre\":\"Satirical Comedy\"},{\"id\":3,\"title\":\"Bridesmaids\",\"description\":\"A woman's life unravels as she competes with her best friend's other bridesmaids.\",\"poster\":\"https://example.com/bridesmaids-poster.jpg\",\"genre\":\"Romantic Comedy\"},{\"id\":4,\"title\":\"Dumb and Dumber\",\"description\":\"Two incredibly stupid friends embark on a cross-country trip to return a briefcase.\",\"poster\":\"https://example.com/dumbanddumber-poster.jpg\",\"genre\":\"Slapstick Comedy\"},{\"id\":5,\"title\":\"The Grand Budapest Hotel\",\"description\":\"The misadventures of a hotel concierge and his protege at a luxurious European hotel.\",\"poster\":\"https://example.com/grandbudapesthotel-poster.jpg\",\"genre\":\"Quirky Comedy\"},{\"id\":6,\"title\":\"Ferris Bueller's Day Off\",\"description\":\"A high school student plays hooky and embarks on a wild adventure in Chicago.\",\"poster\":\"https://example.com/ferrisbueller-poster.jpg\",\"genre\":\"Teen Comedy\"},{\"id\":7,\"title\":\"Groundhog Day\",\"description\":\"A weatherman relives the same day over and over again in a small town.\",\"poster\":\"https://example.com/groundhogday-poster.jpg\",\"genre\":\"Fantasy Comedy\"},{\"id\":8,\"title\":\"Napoleon Dynamite\",\"description\":\"The quirky adventures of an awkward high school student in a small Idaho town.\",\"poster\":\"https://example.com/napoleondynamite-poster.jpg\",\"genre\":\"Indie Comedy\"},{\"id\":9,\"title\":\"The Princess Bride\",\"description\":\"A classic fairy tale adventure with romance, humor, and memorable characters.\",\"poster\":\"https://example.com/princessbride-poster.jpg\",\"genre\":\"Fantasy Comedy\"}]";
    public static JSONArray getMovieArray() {
        JSONArray obj=(JSONArray) JSONValue.parse(DB.movies);
        return obj;
    }

    public static int calculateResults(){
        String s = DB.resultString;
        JSONArray mov= getMovieArray();
        int largest =0;
        int largestIndex =0;
        for(int i=0; i< s.length();i++){
            int count =0;
            for (int j=0; j< s.length();j++){
                     if(s.charAt(i) == s.charAt(j)){
                         count++;
                     }
            }
            if(count>=largest){
                largest = count;
                largestIndex =s.charAt(i) -'0';
            }
        }
        System.out.println(largestIndex);
        System.out.println(mov.get(largestIndex));
        return (largestIndex);
    }
}