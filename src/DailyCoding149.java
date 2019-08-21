public class DailyCoding149 {
    public static void main(String[] args) {
        int[] input = {1,2,3,4,5};

        int[] cumSum = preCalculate(input);

        System.out.println("Sum 1 to 3 = " + sum(3,3, cumSum, input));
    }
    public static int[] preCalculate(int[] input){
        int[] cumSum = new int[input.length];
        cumSum[0] = input[0];
        for (int i=1; i<input.length; i++){
            cumSum[i] = cumSum[i-1] + input[i];
        }
        return cumSum;
    }
    public static int sum(int i, int j, int[] cumSum, int[] input){
        return cumSum[j] - input[j] - cumSum[i] + input[i];
    }
}
