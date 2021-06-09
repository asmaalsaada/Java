public class FizzBuzz{
    static String fizzBuzz(int number){ 
		if (number%3==0 && number%5==0) {
		    return "FizzBuzz";
		}else if ( number%5==0) {
			return "Buzz";
		}else if( number%3==0) {
			return "Fizz";
		}else {
			return "number";
		}
    }
    public static void main(String[] args) {
        System.out.println(fizzBuzz(15));
}
}