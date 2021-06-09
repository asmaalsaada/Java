public class Casting {
    public static void main(String[] args) {
        byte b = 127;
        int i = 130;
        
        System.out.println(b); //  error: incompatible types: possible lossy conversion from int to byte b = i;

    }
} 