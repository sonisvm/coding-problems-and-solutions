import java.util.HashMap;

/**
 * Given a number in Roman numeral format, convert it to decimal.
 *
 * {
 *     'M': 1000,
 *     'D': 500,
 *     'C': 100,
 *     'L': 50,
 *     'X': 10,
 *     'V': 5,
 *     'I': 1
 * }
 *
 * In addition, note that the Roman numeral system uses subtractive notation for numbers such as IV and XL.
 *
 * For the input XIV, for instance, you should return 14.
 */
public class DailyCoding216 {
    public static void main(String[] args) {
        System.out.println(convertRomanToNumeral("XIV") == 14);
        System.out.println(convertRomanToNumeral("LVIII") == 58);
    }
    public static int convertRomanToNumeral(String roman) {
        HashMap<Character, Integer> values = new HashMap();
        values.put('I', 1);
        values.put('V', 5);
        values.put('X', 10);
        values.put('L', 50);
        values.put('C', 100);
        values.put('D', 500);
        values.put('M', 1000);

        int sum =0;
        for(int i=0; i<roman.length(); i++){
            char c = roman.charAt(i);
            if(i<roman.length()-1){
                if(values.get(roman.charAt(i+1))> values.get(c)){
                    sum += -values.get(c);
                } else {
                    sum += values.get(c);
                }
            } else {
                sum += values.get(c);
            }
        }
        return sum;
    }
}
