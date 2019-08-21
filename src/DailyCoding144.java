public class DailyCoding144 {
    public static void main(String[] args) {
        int[] input1 = {4,1,3,5,6};
        System.out.println("Test1 : "+ findNearestLargerNumber(input1, 0));

        int[] input2 = {};
        System.out.println("Test2 : "+ findNearestLargerNumber(input2, 4));

        int[] input3 = {1,5,2,2,4,3};
        System.out.println("Test3 : "+ findNearestLargerNumber(input3, 4));

    }
    public static Integer findNearestLargerNumber(int[] input, int index){
        if (input.length == 0){
            return null;
        }
        int[] nearestLargerLeft = new int[input.length];
        int[] nearestLargerRight = new int[input.length];

        /* First pass: Find the nearest larger number to the left */
        for (int i=0; i < input.length; i++){
            if(i==0){
                nearestLargerLeft[i] = -1;
            } else {
                int prev = i-1;
                while (prev!=-1 && prev >= 0){
                    if(input[prev] > input[i]){
                        nearestLargerLeft[i] = prev;
                        break;
                    } else {
                        prev = nearestLargerLeft[prev];
                    }
                }
                if(prev < 0){
                    // if prev ever -1, the current number has no larger number to the left
                    nearestLargerLeft[i] = -1;
                }
            }
        }

        /* Second pass: Find the nearest larger number to the right. If the distance to that number is smaller than the
           one obtained previously, update the array*/
        nearestLargerRight[input.length-1] = -1;
        for (int i=input.length-2; i>=0; i-- ){
            int next = i+1;
            while(next!=-1){
                //System.out.println("Here2");
                if(input[next] > input[i]){
                    nearestLargerRight[i] = next;
                    break;
                } else {
                    next = nearestLargerRight[next];
                }
            }
            if(next==-1){
                nearestLargerRight[i] = -1;
            }
        }
        Integer result = null;

        if(nearestLargerLeft[index]!=-1 && nearestLargerRight[index] !=-1){
            result =  Math.abs(nearestLargerLeft[index] - index) < Math.abs(nearestLargerRight[index] - index) ?
                    nearestLargerLeft[index] : nearestLargerRight[index];
        } else if(nearestLargerLeft[index]==-1 && nearestLargerRight[index]==-1){

        } else if(nearestLargerLeft[index]==-1){
            result = nearestLargerRight[index];
        } else {
            result = nearestLargerLeft[index];
        }

        return  result;
    }
}
