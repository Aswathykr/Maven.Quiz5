package rocks.zipcode.io.quiz4.fundamentals;

import java.util.HashSet;
import java.util.Set;

/**
 * @author leon on 18/12/2018.
 */
public class PalindromeEvaluator {
    public static String[] getAllPalindromes(String string) {
        Set<String> palindromes = new HashSet<>();
        for (int i = 0; i < string.length(); i++) {
            for (int j = i+1; j < string.length(); j++) {
                String subStr = string.substring(i, j);
                if(isPalindrome(subStr)){
                    palindromes.add(subStr);
                }
            }
        }
        if(isPalindrome(string)){
            palindromes.add(string);
        }
        return palindromes.toArray(new String[palindromes.size()]);
    }

    public static Boolean isPalindrome(String string) {
        int halfLength =  string.length()/2;
        String firstHalf = string.substring(0, halfLength);
        return firstHalf.equals(reverseString(string.substring(string.length() - halfLength)));
    }

    public static String reverseString(String string) {
        StringBuilder builder = new StringBuilder(string);
        builder.reverse();
        return builder.toString();
    }
}
