public class TestNull{
    public static void main(String[] args) {
        Integer a = 10;
        int b = 10;
        a=null;
        b=null;
    }
}

//  javac TestNull.java
// TestNull.java:6: error: incompatible types: <null> cannot be converted to int
// b=null;
//   ^
// 1 error
