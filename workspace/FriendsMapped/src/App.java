import java.util.LinkedHashMap;
import java.util.Scanner;

public class App {
    public static void printFriends(LinkedHashMap<String, String> friends){
        for (String name : friends.keySet()){
            System.out.printf("\n%s", name);
        }
    }
    public static void main(String[] args) throws Exception {
       LinkedHashMap<String, String> friends = new LinkedHashMap<String, String>();
       friends.put("Ray", "815-8360-5528");
       friends.put("Karen", "218-723-8431");
       friends.put("Conor", "324-573-9843");
       printFriends(friends);
       String findName = "Conor";
       if (friends.containsKey(findName)){
            System.out.println("Phone Number = " + friends.get(findName));
       } else { 
            System.out.println("Does not exist!");
       }
    }
}
