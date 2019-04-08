package rocks.zipcode.io.quiz4.objectorientation;

import rocks.zipcode.io.quiz4.fundamentals.PalindromeEvaluator;

/**
 * @author leon on 18/12/2018.
 */
public class PalindromeObject {

    String palindrome;
    public PalindromeObject(String input) {
        this.palindrome = input;
    }

    public String[] getAllPalindromes(){
        return PalindromeEvaluator.getAllPalindromes(palindrome);
    }

    public Boolean isPalindrome(){
        return PalindromeEvaluator.isPalindrome(palindrome);
    }

    public String reverseString(){
        return PalindromeEvaluator.reverseString(palindrome);
    }
}
