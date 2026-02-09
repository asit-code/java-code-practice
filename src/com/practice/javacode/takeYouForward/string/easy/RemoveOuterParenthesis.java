package com.practice.javacode.takeYouForward.string.easy;

/*Given a string S of valid parentheses “(“ and “)”, the task is to print the string obtained by removing the outermost parentheses of every primitive substring from S.
 * A valid parentheses substring S is primitive if it is non-empty, and cannot be split into two or more non-empty substrings which are also a valid parentheses.
 * Input: S = “((()())(())(()(())))”
   Output:      (()())(())(()(()))
*/
public class RemoveOuterParenthesis {
    public static void main(String[] args) {
        String s = "(()())(())()";
        String s2 = "((()())(())(()(())))";
        removeBySingleCount(s);
        removeByCountPair(s2);
    }

    private static void removeBySingleCount(String s) {
        int count = 0;
        String res = "";
        for (int c = 0; c < s.length(); c++) {
            if (s.charAt(c) == '(' && count++ > 0) //To ignore 1st (, count > 0
                res += s.charAt(c);

            if (s.charAt(c) == ')' && count-- > 1) //To ignore last ), count > 1
                res += s.charAt(c);
        }
        System.out.println("Input is: " + s + "\nResult is: " + res);
    }

    private static void removeByCountPair(String s) {
        String res = "";
        int open = 0;
        int close = 0;
        int start = 0;
        for (int c = 0; c < s.length(); c++) {
            if (s.charAt(c) == '(')
                open++;
            if (s.charAt(c) == ')')
                close++;

            if (open == close) {
                res += s.substring(start + 1, c);
                start = c + 1;
            }
        }
        System.out.println("Input is: " + s + "\nResult is: " + res);
    }
}

// TODO: Print the string obtained after removal of outermost parentheses
