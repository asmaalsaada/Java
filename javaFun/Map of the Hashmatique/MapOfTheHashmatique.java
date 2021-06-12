import java.util.HashMap;
import java.util.Set;
public class MapOfTheHashmatique{
    public static void main(String[] args) {
    HashMap<String, String> trackList = new HashMap<String, String>();
    trackList.put("Song1", "Title1");
    trackList.put("Song2", "Title2");
    trackList.put("Song3", "Title3");
    trackList.put("Song4", "Title4");
    Set<String> lyrics = trackList.keySet();
    trackList.remove("Song4");
    for(String key : lyrics) {
        System.out.println(key);
        System.out.println(trackList.get(key));    
    }
}
}