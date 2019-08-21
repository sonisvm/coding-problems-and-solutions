public class DailyCoding147 {
    public static void main(String[] args) {
        int[] input1 = {3,5,1,6,4,2};
        sort(input1);
        print(input1);
    }

    public static void print(int[] arr){
        for (int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void sort(int[] arr){
        for (int i=arr.length-1; i>0; i--){
            int index = indexOfLargest(arr, 0, i);
            reverse(arr, index, i);
        }
    }

    public static int indexOfLargest(int[] arr, int i, int j){
        int max = Integer.MIN_VALUE, maxIndex=-1;
        for(int l=i; l<=j; l++){
            if (max < arr[l]){
                max = arr[l];
                maxIndex = l;
            }
        }
        return maxIndex;
    }

    public static void reverse(int[] arr, int i, int j){
        while(i<j){
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            i++;
            j--;
        }
    }
}
