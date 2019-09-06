/**
 * You run an e-commerce website and want to record the last N order ids in a log. Implement a data structure
 * to accomplish this, with the following API:
 *
 * record(order_id): adds the order_id to the log
 * get_last(i): gets the ith last element from the log. i is guaranteed to be smaller than or equal to N.
 */
class LogDataStructure {
    private int[] circularBuffer;
    private int N;
    private int index;
    public LogDataStructure(int N) {
        this.N = N;
        this.circularBuffer = new int[N];
        this.index = 0;
    }
    public void record(int order_id) {
        circularBuffer[index] = order_id;
        index = (index + 1) % N;
    }
    public int get_last(int i) {
        int idx = (index - i + N) % N;
        return circularBuffer[idx];
    }
}
public class DailyCoding16 {
    public static void main(String[] args) {
        LogDataStructure log = new LogDataStructure(3);
        log.record(1);
        log.record(2);
        System.out.println("Last: " + log.get_last(2)); // 1
        log.record(3);
        log.record(4);
        System.out.println("Last: " + log.get_last(2)); // 3
    }
}
