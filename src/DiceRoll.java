/**
 * A six-sided dice is a small cube with a different number of pips. Each face(side) ranging from 1 to 6.
 * On any two opposite side of the cube, the number of pips adds up to 7; that is, there are three pairs of opposite
 * sides: 1 and 6, 2 and 5, and 3 and 4.
 * There are N dice lying on a table, each showing the pips on its top face. In one move, you can take one dice and
 * rotate it to an adjacent face.
 * For example, you can rotate a dice that shows 1 to show 2, 3, 4 or 5. However, it cannot show 6 in a single move,
 * because the faces with one pip and six pips visible are opposite sides rather than adjacent.
 * You want to show the same number of pips on the top face of all N dice. Given that each of the dice can be moved
 * multiple times, count the minimum number of moves needed to get equal faces.
 *
 * Write a function:
 * that, given an array A consisting of N integers describing the number of pips (from 1 to 6) shown on each dice’s
 * top face, returns the minimum number of moves necessary for each dice show the same number of pips.
 */
public class DiceRoll {
    public static void main(String[] args) {
        System.out.println(minRolls(new int[]{1,2,3})==2);
        System.out.println(minRolls(new int[]{1,1,6})==2);
        System.out.println(minRolls(new int[]{1,6,2,3})==3);
    }
    public static int minRolls(int[] dices) {
        //since we know that the final number of pips would be one of 1-6, we need to find the number of rolls required
        //to reach each of these outcomes and then find the minimum among that
        int[] count = new int[7];
        for (int d : dices) {
            count[d]++;
        }
        int min = Integer.MAX_VALUE;
        for (int i=1; i<7; i++) {
            int num = 0;
            for (int j=1; j<7; j++) {
                if (j == 7-i) {
                    num += 2*count[j]; //coz we have to flip twice
                } else if(j != i) {
                    num += count[j];
                }
            }
            min = Math.min(min, num);
        }
        return min;
    }
}

