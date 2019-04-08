package rocks.zipcode.io.quiz4.fundamentals;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author leon on 11/12/2018.
 */
public class StringEvaluator {
    public static String[] getAllSubstrings(String string) {
        Set<String> substrings = new HashSet<>();
        for (int i = 0; i < string.length(); i++) {
            for (int j = i; j < string.length(); j++) {
                substrings.add(string.substring(i, j+1));
            }
        }
        return substrings.toArray(new String[substrings.size()]);
    }

    public static String[] getCommonSubstrings(String string1, String string2) {
        List<String> firstList = Arrays.asList(getAllSubstrings(string1));
        List<String> secondList = Arrays.asList(getAllSubstrings(string2));

        Set<String> commonSet = new HashSet<>(firstList);
        commonSet.retainAll(secondList);
        return commonSet.toArray(new String[commonSet.size()]);
    }

    public static String getLargestCommonSubstring(String string1, String string2) {
        List<String> commonList = Arrays.asList(getCommonSubstrings(string1,string2));
        return commonList.stream()
                .reduce((str1,str2)-> str1.length() > str2.length() ? str1 : str2).get();
    }
}
