public class SortArray {
    public static void main(String[] args) {
        int[] nums = {0,1,2,0,1,2};
        //solution1(nums);
        int [] input2 = {0,1,1,0,1,2,1,2,0,0,0,1};
        //solution1(input2);
        System.out.println("----------------");
        solution2(nums);
        solution2(input2);

    }
    public static void solution1(int[] nums){
        int[] count = new int[3];
        for (int i=0; i<nums.length; i++){
            count[nums[i]]++;
        }
        int j=0;
        for (int i=0; i< count.length; i++){
            while(count[i]>0){
                nums[j] = i;
                j++;
                count[i]--;
            }
        }
        for (int i=0; i< nums.length; i++){
            System.out.print(nums[i] + " ");
        }
        System.out.println("");
    }
    public static void solution2(int[] nums){
        /*
        This is called Dutch national flag problem
         */
        int low=0, mid=0, high=nums.length-1;
        while (mid <= high){
            if(nums[mid]==0){
                int tmp = nums[mid];
                nums[mid] = nums[low];
                nums[low]=tmp;
                low++;
                mid++;
            } else if(nums[mid]==1){
                mid++;
            } else {
                int tmp = nums[mid];
                nums[mid] = nums[high];
                nums[high]=tmp;
                high--;
            }
        }
        for (int i=0; i< nums.length; i++){
            System.out.print(nums[i] + " ");
        }
        System.out.println("");
    }
}
