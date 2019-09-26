import java.util.HashSet;
import java.util.Set;

/**
 * There are N prisoners standing in a circle, waiting to be executed. The executions are carried out starting with
 * the kth person, and removing every successive kth person going clockwise until there is no one left.
 *
 * Given N and k, write an algorithm to determine where a prisoner should stand in order to be the last survivor.
 */
public class DailyCoding225 {
    public static void main(String[] args) {
        System.out.println(lastStanding(5, 2) == 3);

    }
    public static int lastStanding(int N, int k) {
        //Josephus problem
        if(N == 1) {
           return N;
        }
        //since we skipped k-1 people, we have to add them back so that the index is proper
        // since module returns from 0 to N-1, add 1 to get the right index
        return (lastStanding(N-1, k) + k-1)%N + 1;
    }
}
