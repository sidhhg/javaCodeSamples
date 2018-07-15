package com.sidhhg.problems.hard.dynamicprogramming;

import java.util.HashMap;
import java.util.Objects;
import org.apache.commons.lang3.StringUtils;

/**
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 *
 * <pre>
 *     Example 1: Input: "(()"
 *                Output: 2
 *                Explanation: The longest valid parentheses substring is "()"
 *     Example 2: Input: "()(()"
 *                Output: 4
 *                Explanation: The longest valid parentheses substring is "()x()". Although they're not consecutive but the longest valid are two pairs of ()
 * </pre>
 */
public class LongestValidParenthesesNonSeq {
    private static HashMap<String, Integer> scores = new HashMap<>();
    private static HashMap<String, Integer> closeParantheses = new HashMap<>();

    private static void lvp(String p, Integer pos) {
        if(p == null || p.equals("") || Objects.isNull(pos) || pos < 0 || p.length() == 1)
            return;

        String sStr = (pos+1)<=p.length()?p.substring(pos+1):"";
        String cStr = Character.toString(p.charAt(pos));

        String nStr = cStr + sStr;

        Integer sSCore = scores.getOrDefault(sStr, 0);
        Integer sCloseParantheses = closeParantheses.getOrDefault(sStr, 0);

        if(StringUtils.equals(cStr, "(")) {
            if (sCloseParantheses > 0) {
                scores.put(nStr, sSCore + 2);
                closeParantheses.put(nStr, sCloseParantheses - 1);
            }
            else {
                scores.put(nStr, sSCore);
                closeParantheses.put(nStr, sCloseParantheses);
            }
        } else {
            closeParantheses.put(nStr, sCloseParantheses + 1);
            scores.put(nStr, sSCore);
        }

        lvp(p, pos - 1);
    }

    public static void main(String args[]) {
        String aa = "()(()";
        lvp(aa, aa.length() - 1 );
        System.out.println(scores.getOrDefault(aa, 0));
    }
}
