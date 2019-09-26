import java.util.LinkedList;

/**
 * Subtract two numbers represented as linked lists
 */

public class SubtractTwoNumbers {
    public static void main(String[] args) {
        LinkedList<Integer> l1 = new LinkedList<>();
        l1.addFirst(0);
        l1.addFirst(0);
        l1.addFirst(1);

        LinkedList<Integer> l2 = new LinkedList<>();
        l2.addFirst(1);
        l2.addFirst(0);
        l2.addFirst(0);

        LinkedList<Integer> result = subtract(l2, l1);

        for (int i : result) {
            System.out.print(i + "->");
        }

    }
    public static LinkedList<Integer> subtract(LinkedList<Integer> l1, LinkedList<Integer> l2) {
        if(l1.size() < l2.size()) {
            padZeros(l1, l2.size()-l1.size());
        } else {
            padZeros(l2, l1.size()-l2.size());
        }
        boolean isL1Larger = false;
        for (int i=0; i<l1.size(); i++) {
            if(l1.get(i) == l2.get(i)) {
                continue;
            } else if (l1.get(i) > l2.get(i)){
                isL1Larger = true;
                break;
            } else {
                break;
            }
        }
        LinkedList<Integer> result = new LinkedList<>();
        if (isL1Larger) {
            subtractHelper(l1, l2, result, 0);
        } else {
            subtractHelper(l2, l1, result, 0);
        }

        //remove leading zeros if any
        while(!result.isEmpty() && result.get(0)==0) {
            result.removeFirst();
        }
        if (result.isEmpty()) {
            result.addFirst(0);
        }

        return result;
    }
    public static void padZeros(LinkedList<Integer> l, int n) {
        while(n!=0){
            l.addFirst(0);
            n--;
        }
    }
    public static int subtractHelper(LinkedList<Integer> l1, LinkedList<Integer> l2,
                                                     LinkedList<Integer> result, int index) {
        if(index == l1.size()) {
            return 0;
        }

        int borrow = subtractHelper(l1, l2, result, index+1);

        int a = l1.get(index), b = l2.get(index);
        boolean borrowedFromZero = false;
        if(borrow == -1){
            a = a-1;
        }

        if(a >= b) {
            result.addFirst(a-b);
            borrow = 0;
        } else {
            result.addFirst(a+10-b );
            borrow = -1;
        }
        return borrow;
    }
}
