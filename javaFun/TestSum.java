// public class TestSum{
//     public static void main(String[] args) {
//         long start = System.currentTimeMillis();
//         Integer sum = 0;
//         for (int i = 0; i < Integer.MAX_VALUE; i++) {
//             sum += i;
//         }
//         System.out.println("Sum: " + sum);
//         long end = System.currentTimeMillis();
//         double total = (double) (end - start) / 1000;
//         System.out.println("Time of execution: " + total + " seconds");
//     }
    
//     } 

    
// java TestSum
// Sum: 1073741825
// Time of execution: 6.712 seconds
public class TestSum{
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int sum = 0;
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        System.out.println("Sum: " + sum);
        long end = System.currentTimeMillis();
        double total = (double) (end - start) / 1000;
        System.out.println("Time of execution: " + total + " seconds");
    }
    
    } 

    // java TestSum
// Sum: 1073741825
// Time of execution: 0.78 seconds
