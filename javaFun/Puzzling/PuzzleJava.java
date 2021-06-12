import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
public class  PuzzleJava {
    public Integer[] getArray(){
        ArrayList<Integer> u = new ArrayList<Integer>(); 
        int[] arr = {3,5,1,2,7,9,8,13,25,32};
        int sum = 0;
        for (int i=0; i<arr.length;i++){
            sum+=arr[i];
            if(arr[i]>10){
                u.add(arr[i]);
            }
        }
        System.out.println(sum);
        Integer[] a=new Integer[u.size()];
        a= u.toArray(a);
        return a;
    }
    public String[] getName(){
        ArrayList<String> u = new ArrayList<String>();
        String[] names = {"Nancy", "Jinichi", "Fujibayashi", "Momochi", "Ishikawa"};
        for (int i=0; i<names.length;i++){
            if (names[i].length()>5){
                u.add(names[i]);
            }
        }
        System.out.println(u);
        return names;
    }
    public String[] getAlpha(){
    // ArrayList<String> u = new ArrayList<String>();
    String[] alphabetical  = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
    List<String> p = Arrays.asList(alphabetical );
    Collections.shuffle(p);
    System.out.println("\nShuffled List : \n" + p);
    System.out.println(alphabetical [alphabetical .length-1]);
    System.out.println(alphabetical[0]);
    if (alphabetical[0]== "A"|| alphabetical[0]== "U"||alphabetical[0]== "E" || alphabetical[0]== "I"|| alphabetical[0]== "O"){
        System.out.println("It's a vowel!");
    }
    return alphabetical ;
}
// Generate and return an array with 10 random numbers between 55-100.
    // public Integer[] getRandom(){
    //     Random r = new Random();
    //     Integer[] arr =new Integer[10];
    //     for (int i=0; i<arr.length;i++){
    //         arr[i]=r.nextInt(100-55)+55;
    //         System.out.println(arr[i]);
        
    //     }return arr;
    // }
    public Integer[] getRandom_2(){
        Random r = new Random();
        Integer[] arr =new Integer[10];
        for (int i=0; i<arr.length;i++){
            arr[i]=r.nextInt(100-55)+55;
            System.out.println(arr[i]);
        
        }
        List<Integer> o = Arrays.asList(arr);
        Collections.sort(o);
        System.out.println(o);
        return arr;
    }
    public void getString(){
    String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    StringBuilder sb = new StringBuilder();
    Random random = new Random();
    int length = 5;
    for(int i = 0; i < length; i++) {
    int index = random.nextInt(alphabet.length());
    char randomChar = alphabet.charAt(index);
    sb.append(randomChar);
    }
    String randomString = sb.toString();
    System.out.println("Random String is: " + randomString);
}
public void getString_2(){
    String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String[] rnString= new String[10];
    StringBuilder sb = new StringBuilder();
    Random random = new Random();
    int length = 5;
    for (int j=0; j<rnString.length;j++){
        sb.delete(0,5);
    for(int i = 0; i < length; i++) {
    int index = random.nextInt(alphabet.length());
    char randomChar = alphabet.charAt(index);
    sb.append(randomChar);
    }
    rnString[j]=sb.toString();
}
    List<String> rnList = Arrays.asList(rnString);
    String randomString = sb.toString();
    System.out.println("Random String is: " + randomString);
    System.out.println(rnList);
}
}