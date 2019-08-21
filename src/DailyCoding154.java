import java.util.Comparator;
import java.util.PriorityQueue;

class Entry{
    int num;
    int token;

    public Entry(int num, int token){
        this.num = num;
        this.token = token;
    }
}

class Stack {
    private PriorityQueue<Entry> maxHeap;
    public int counter;
    public Stack(){
        maxHeap = new PriorityQueue<>((o1, o2) -> {
                if(o1.token < o2.token){
                    return 1;
                } else if(o1.token > o2.token){
                    return -1;
                } else {
                    return 0;
                }
        });
        counter=0;
    }
    public void push(int x){
        maxHeap.add(new Entry(x, counter));
        counter++;
    }
    public int pop(){
        if (maxHeap.size()==0){
            System.out.print("Nothing on the stack");
            return -1;
        }
        return maxHeap.poll().num;
    }

}
public class DailyCoding154 {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.push(4);
        stack.push(5);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

}
