
// Goldman Sachs Question13 - https://practice.geeksforgeeks.org/problems/decode-the-string2444/1

import java.util.*;
public class Que13 {
    public static void main(String[] args) {
        String str = "3[b2[ca]]";

        System.out.println(decodedString(str));

    }

    static String decodedString(String s) {
        String res = "";
        Stack<Integer> countStack = new Stack<>();
        Stack<String> resStack = new Stack<>();
        int idx = 0;

        while (idx < s.length()) {
            if (Character.isDigit(s.charAt(idx))) {
                int count = 0;
                while (Character.isDigit(s.charAt(idx))) {
                    count = 10 * count + (s.charAt(idx) - '0');
                    idx++;
                }
                countStack.push(count);
            } 
            else if (s.charAt(idx) == '[') {
                resStack.push(res);
                res = "";
                idx++;
            } 
            else if (s.charAt(idx) == ']') {
                StringBuilder temp = new StringBuilder(resStack.pop());
                int repeatTimes = countStack.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    temp.append(res);
                }
                
                res = temp.toString();
                idx++;
            } else {
                res += s.charAt(idx++);
            }
        }
        return res;
    }
}
