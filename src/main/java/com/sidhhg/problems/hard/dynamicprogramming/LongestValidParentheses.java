package com.sidhhg.problems.hard.dynamicprogramming;

import java.util.*;

/**
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 * A valid parantheses: for every '(' there exists ')' such that '(' occurs before ')'. Consecutive pairs must not have them together
 * For example: ())() does has ')' between two consecutive paranthesis. However, (()())() has all the parenthesis has consecutive.
 *
 * <pre>
 *     Example 1: Input: "(()"
 *                Output: 2
 *                Explanation: The longest valid parentheses substring is "()"
 *     Example 2: Input: ")()(()))()()("
 *                Output: 6
 *                Explanation: The longest valid parentheses substring is "()(())".
 * </pre>
 *
 * Running time complexity:  O(n) - we iterate over the list once.
 * Space complexity: O(n) - we are using stack to store the data.
 */
public class LongestValidParentheses {

    /**
     * Finds the sequence of longest valid paranthesis.
     * @param substr <code>String</code>
     * @return <code>Integer</code>
     */
    private static int lvpSequential(String substr) {
        int n = substr.length();

        Stack<Integer> stk = new Stack<>();
        stk.push(-1);

        int result = 0;
        for (int i=0; i<n; i++) {
            if (substr.charAt(i) == '(')
                stk.push(i);
            else  {
                stk.pop();

                if (!stk.empty())
                    result = Math.max(result, i - stk.peek());

                else stk.push(i);
            }
        }
        return result;
    }

    public static void main(String args[]) {

        String[] arr = { ")()(()))()()(", ")()())()()(", "()(()", ")(","()(()","(()", ")()())", "(", "((", "", "))"};

        for(String inputArr: arr) {
            System.out.println("[input] ==> " + inputArr + " ==> " + lvpSequential(inputArr));
        }
    }
}
