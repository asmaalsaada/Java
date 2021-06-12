public class GreaterThanY{
    public static void main(String[] args){
        int counter = 0;
        int y =2;
        int []array = {1,3,5,7};
        for (int i=0;i<array.length;i++){
            if (array[i]>y){
                counter ++;
            }
        }System.out.println(counter);
    }
}
