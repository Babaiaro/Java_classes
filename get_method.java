package jun.map;
import java.util.HashMap;

public class get_method {
    public static void main(String[] args) {
        HashMap<String, Integer> ages = new HashMap<String, Integer>();
        ages.put("Bob", 21);
        ages.put("Sara", 22); 

        int a = ages.get("Bob");
        int b = ages.get("Sara");

        System.out.println(a, b);
    }
    
}
