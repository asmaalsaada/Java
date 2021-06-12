import java.util.Arrays;
import java.util.ArrayList;

public class BasicFun {
	// public static void oneTo255(){
	// 	for (int i = 0; i<=255;i++){
    //         System.out.println(i);
	// 	}
	// }
	// public static void oddOneTo255(){
	// 	for (int i = 0; i<=255;i++){
    //         if (i%2!=0){
    //             System.out.println(i);
    //         }
    //     }
	// public static void sum(){
	// 	for (int i = 0; i<=255;i++){
	// 	String curStr = ", The current sum is :";
	// 	String newNum = "New number is : ";
	// 	int sum = i+i;
	// 	System.out.println(newNum + i + curStr + sum);
	// }
	// public static void IterateArray(int [] x){
	// 	// for(int i = 0; i<x.length;i++){
    //     //     System.out.println(x[i] + " ");
    //     // }
	// 	System.out.println(Arrays.toString(x));
	// }
	// public static void findMax(int [] x){
	// 	int max = x[0];
	// 	for(int i = 0; i<x.length;i++){
	// 		if (x[i]>max){
    //             max = x[i];
	// 		}
	// }System.out.println(max);
	// }
	// public static void findAvg(int[] x){
	// 	int sum = 0;
    //     for(int i = 0; i<x.length;i++){
    //         sum +=x[i];
    //         } 
	// 		int avg = sum/x.length;
    //         System.out.println(avg);
    //     }
	// public static void oddArray(){
	// 	ArrayList<Integer> y = new ArrayList<Integer>();
    //     for (int i = 0; i<=255;i++) {
    //         if (i%2!=0){
    //             y.add(i);
    //         }
    //     } System.out.println(y) ;
	// }
	// public static void greaterThanY(int[] array, int y){
	// 	int counter = 0;
    //     for (int i=0;i<array.length;i++){
    //         if (array[i]>y){
    //             counter ++;
    //         }
    //     }System.out.println(counter);
	// }
	// public static void squareTheValues(int[]  arr){
	// ArrayList<Object> squared =new ArrayList<Object>();
    // for (int i=0; i<arr.length;i++){
    //     squared.add(arr[i]*arr[i]);
    //     } System.out.println(squared);
	// }
	// public static void maxMinAvg(int[] arr){
    //     int max = arr[0];
    //     int min = arr[0];
    //     int sum = 0; 
    //     int avg = sum/arr.length;
    //     String maximum = "maximum value is :";
    //     String minimum = "minimum value is :";
    //     String average = "Average value is : ";
    //     for(int i=0;i<arr.length;i++){
    //         if (max < arr[i]){
    //             max = arr[i];
    //         }
    //         if (min > arr[i]){
    //             min = arr[i];
    //         }
    //         sum = arr[i]+arr[i]; 
    //     }
    //     System.out.println(maximum + max); 
    //     System.out.println(minimum + min);
    //     System.out.println(average + avg);
	// }
	// public static void eliminateNegatives(int[] arr){
	// 	ArrayList<Object> n =new ArrayList<Object>();
    //     for (int i=0; i<arr.length;i++){
    //         if (arr[i]<0){
    //             n.add(0);
	// 		}else {
	// 			n.add(arr[i]);
	// 		}
    //         }System.out.println(n);
	// }
	public static void shitValue(int[] arr){
		ArrayList<Integer> e =new ArrayList<Integer>();
        for (int i=1; i<arr.length;i++){
			e.add(arr[i]);
		}
		e.add(0);
		System.out.println(e);
	}
}
