import java.util.List;
import java.util.Map;

/**
 * Utility functions
 */
public class Utility {
    public static void print(List<Integer> list) {
        for (int n : list) {
            System.out.print(n + ", ");
        }
        System.out.println("");
    }
    public static void printStr(List<String> list) {
        for (String n : list) {
            System.out.print(n + ", ");
        }
        System.out.println("");
    }
    public static void print(int[] nums) {
        for (int n : nums) {
            System.out.print(n + ", ");
        }
        System.out.println("");
    }
    public static void print(Map<Integer, Integer> map){
        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
}
