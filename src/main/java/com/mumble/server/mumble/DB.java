
package com.mumble.server.mumble;
import org.json.simple.JSONArray;
import org.json.simple.JSONValue;


public class DB {
    static String resultString ="";
    static String movies = "[{\"id\":0,\"title\":\"The Shawshank Redemption\",\"description\":\"Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.\"},{\"id\":1,\"title\":\"The Godfather\",\"description\":\"The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.\"},{\"id\":2,\"title\":\"The Dark Knight\",\"description\":\"When the menace known as The Joker emerges, Batman must confront his own demons to stop him.\"},{\"id\":3,\"title\":\"Pulp Fiction\",\"description\":\"The lives of two mob hitmen, a boxer, a gangster and his wife, and a pair of diner bandits intertwine in four tales of violence and redemption.\"},{\"id\":4,\"title\":\"The Matrix\",\"description\":\"A computer programmer discovers that reality as he knows it is a simulation created by machines to subjugate humanity.\"},{\"id\":5,\"title\":\"Forrest Gump\",\"description\":\"The presidencies of Kennedy and Johnson, the events of Vietnam, Watergate, and other history unfold through the perspective of an Alabama man with an IQ of 75.\"},{\"id\":6,\"title\":\"The Lord of the Rings: The Fellowship of the Ring\",\"description\":\"A meek Hobbit from the Shire and eight companions set out on a journey to destroy the powerful One Ring and save Middle-earth from the Dark Lord Sauron.\"},{\"id\":7,\"title\":\"Inception\",\"description\":\"A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a C.E.O.\"},{\"id\":8,\"title\":\"Schindler's List\",\"description\":\"In German-occupied Poland during World War II, Oskar Schindler gradually becomes concerned for his Jewish workforce after witnessing their persecution by the Nazis.\"},{\"id\":9,\"title\":\"The Silence of the Lambs\",\"description\":\"A young F.B.I. cadet must receive the help of an incarcerated and manipulative cannibal killer to help catch another serial killer, a madman who skins his victims.\"}]";
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