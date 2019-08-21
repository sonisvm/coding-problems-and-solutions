import java.util.ArrayList;
import java.util.List;

/**
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 *
 * IP addresses must follow the format A.B.C.D, where A, B, C, and D are numbers between 0 and 255.
 * Zero-prefixed numbers, such as 01 and 065, are not allowed, except for 0 itself.
 *
 * For example, given "2542540123", you should return ['254.25.40.123', '254.254.0.123'].
 */
public class DailyCoding213 {
    public static void main(String[] args) {
        printResult(restoreIpAddress("2542540123"));
    }

    public static void printResult(List<String> res) {
        for (String s : res) {
            System.out.print(s + ", ");
        }
        System.out.println("");
    }

    public static List<String> restoreIpAddress(String str) {
        if(str.length() == 0) {
            return new ArrayList<String>();
        }
        List<String> res = new ArrayList<>();
        restoreIpAddressHelper(str, 0, res, new StringBuilder(), 0);
        return res;
    }

    public static void restoreIpAddressHelper(String str, int index, List<String> res, StringBuilder strBdr, int part) {
        if (part > 4) { //shouldn't have more than 4 parts
            return;
        }
        if (index >= str.length() && part == 4) {
            strBdr.deleteCharAt(strBdr.length()-1); // delete the last '.'
            res.add(new String(strBdr));
            return;
        }
        for (int i=3; i>0; i--) {
            if (index+i > str.length()) {
                continue;
            }
            String sub = str.substring(index, index+i);
            if (isValidIP(sub)) {
                int len = strBdr.length();
                strBdr.append(sub).append(".");
                restoreIpAddressHelper(str, index+i, res, strBdr, part+1);
                strBdr.delete(len, strBdr.length()); //delete whatever was added
            }
        }
    }
    public static boolean isValidIP(String str) {
        if (str.length()>1 && str.charAt(0) == '0') {
            return false;
        }
        int num = Integer.parseInt(str);
        if (num >= 0 && num <=255) {
            return true;
        }
        return false;
    }
}
