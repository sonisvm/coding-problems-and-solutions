import java.util.ArrayList;
import java.util.List;

/**
 * We say a number is sparse if there are no adjacent ones in its binary representation. For example, 21 (10101) is
 * sparse, but 22 (10110) is not. For a given input N, find the smallest sparse number greater than or equal to N.
 */
public class DailyCoding217 {
    public static void main(String[] args) {
        System.out.println(nextSparseNumber(6) == 8);
        System.out.println(nextSparseNumber(4) == 4);
        System.out.println(nextSparseNumber(38) == 40);
        System.out.println(nextSparseNumber(44) == 64);

        System.out.println(nextSparseNumberEfficient(6) == 8);
        System.out.println(nextSparseNumberEfficient(4) == 4);
        System.out.println(nextSparseNumberEfficient(38) == 40);
        System.out.println(nextSparseNumberEfficient(44) == 64);
    }
    public static int nextSparseNumberEfficient(int n) {
        List<Integer> binaries = new ArrayList<>();
        while (n!=0) {
            binaries.add(n & 1);
            n = n >> 1;
        }


        int last_finalized = 0;

        //traverse from least significant digit
        for (int i=0; i<binaries.size()-1; i++) {
            if (binaries.get(i) == 1 && binaries.get(i+1)==1) {
                for (int j = last_finalized; j <= i+1; j++) { //set everything from second digit to last to 0
                    binaries.set(j, 0);
                }
                //if there is a third digit
                if (i+2 < binaries.size()) {
                    binaries.set(i+2, 1); //turn the third digit to 1
                    last_finalized = i+2;
                } else {
                    binaries.add(1);
                    last_finalized = binaries.size()-1;
                }

                i = last_finalized - 1;
            }
        }

        int num = 0;
        for (int i=0; i<binaries.size(); i++) {
            num += binaries.get(i) * Math.pow(2, i);
        }
        return num;
    }
    public static int nextSparseNumber(int n) {
        //takes O(nlogn) since the next sparse number would be at most O(n) numbers away
        while (true) {
            if (isSparse(n)) {
                return n;
            }
            n++;
        }
    }
    public static boolean isSparse(int n) {
        //takes O(log n)
        int prev = 0;
        while (n!=0) {
            if ((n & 1) == 1 && prev == 1) {
                return false;
            } else {
                prev = (n&1) == 1 ? 1 : 0;
            }
            n = n >> 1;
        }
        return true;
    }

}
