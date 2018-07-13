package com.sidhhg.arrays;

import java.util.Objects;

/**
 * Sample code to reverse words in the char array.
 * Use in-place reversal.
 *
 * Running time complexity:
 *    Iterates over the array twice. Performs the character
 *    reversal and takes O(n) and then does the word reversal
 *    in one iteration. Takes O(n) again.
 *    Total O(n) + O(n) ~ O(n)
 * Space time complexity: O(1)
 */
public class ReverseWordsInPlace {

    private char[] inputArr;

    public ReverseWordsInPlace(char[] inputArr) {
        this.inputArr = inputArr;
    }

    /**
     * Reverses the words. By default uses space as the
     * delimiter.
     */
    public void reverseWords() {
        reverseCharacters(0, inputArr.length - 1);
        int leftPos = 0, rightPos = 0;
        for (int i=0; i<inputArr.length; i++) {
            if(inputArr[i] != ' ' )
                continue;
           rightPos = i-1;
           reverseCharacters(leftPos, rightPos);
           leftPos = i + 1;
        }
    }

    /**
     * Reverses character of the array. If the array is null
     * then returns null;
     *
     * @param leftPos <code>Integer</code>
     * @param rightPos <code>Integer</code>
     */
    private void reverseCharacters(Integer leftPos, Integer rightPos) {
        if(leftPos >= rightPos || leftPos < 0 || rightPos < 0 || Objects.isNull(inputArr) || inputArr.length == 0)
            return;

        for (int ii = leftPos; ii <= rightPos; ii++) {
            char tempC = inputArr[ii];
            inputArr[ii] = inputArr[rightPos];
            inputArr[rightPos] = tempC;
            rightPos--;
        }
    }

    public static void main(String args[]) {
        // Basic input char array
        char[] inputArr = {'a', 'b', 'c', ' ', 'd', 'e', ' ', 'f', 'g'};
        ReverseWordsInPlace obj = new ReverseWordsInPlace(inputArr);
        obj.reverseWords();
        System.out.println( inputArr );
    }
}
