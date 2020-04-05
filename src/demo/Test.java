package demo;

public class Test {
    public static void main(String[] args) {
        int[] arr={1,3,2};
        for(int i=arr.length-2;i>=0;i--){
            if(arr[i]>arr[i+1]){
                i--;
            }
        }
    }
}
