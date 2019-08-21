public class GeometricProgression {
    public static void main(String[] args) {
        int[] input1 = {1,3,9,27};
        int[] input2 = {1,3,5,7};
        System.out.println(isGP(input1));
        System.out.println(isGP(input2));
    }
    public static boolean isGP(int[] nums){
        int r = nums[1]/nums[0];
        for (int i=2; i<nums.length-1; i++){
            if(nums[i]/nums[i-1]!=r){
                return false;
            }
        }
        return true;
    }
}
