public class ArithmeticProgression {
    public static void main(String[] args) {
        int[] input1 = {1,3,5,7,9};
        int[] input2 = {1,3,4,5,7};
        System.out.println(isAP(input1));
        System.out.println(isAP(input2));
    }
    public static boolean isAP(int[] nums) {
        int diff = (nums[nums.length - 1] - nums[0]) / (nums.length - 1);
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] - nums[i - 1] != diff) {
                return false;
            }
        }
        return true;
    }
}
