package rocks.zipcode.io.quiz4.generics;

import java.util.*;

/**
 * @author leon on 11/12/2018.
 */
public class GenericUtils {

    public static <_ extends Comparable> List<List<_>> findAllSubSet(Set<_> originalSet) {
        List<List<_>> result = new ArrayList<>();
        if (originalSet.isEmpty()) {
            result.add(new ArrayList<>());
            return result;
        }
        List<_> list = new ArrayList<_>(originalSet);
        _ head = list.get(0);
        Set<_> rest = new HashSet<_>(list.subList(1, list.size()));
        for (List<_> set : findAllSubSet(rest)) {
            List<_> newSet = new ArrayList<>();
            newSet.addAll(set);
            newSet.add(head);
            newSet.sort(_::compareTo);
            result.add(newSet);
            result.add(set);
        }
        return result;
    }

    public static <_ extends Comparable> Iterable<? extends Iterable<_>> powerSet(Set<_> originalSet) {
        List<List<_>> list = new ArrayList<>();
        list = findAllSubSet(originalSet);
        //subsetsHelper(list, new ArrayList<_>(), new ArrayList<>(originalSet), 0);
        list.sort(GenericUtils::compareTo);
        int size = list.size();
        for (int i = 1; i < size; i++) {
            List<_> temp = list.get(i);
            if(temp.size() >1 &&temp.size()!=originalSet.size()) {
                List<_> revList = new ArrayList<>(temp);
                Collections.reverse(revList);
                list.add(revList);
            }
        }
        list.sort(GenericUtils::compareTo);
        return list;
    }

    public static <_ extends Comparable> int compareTo(List<_>a, List<_> b){
            if(b.isEmpty()) return -1;
            if(a.isEmpty()) return 1;
            return a.toString().compareTo(b.toString());
    }

    public static <_ extends Comparable> Iterable<? extends Iterable<_>> powerSet(_... originalSet) {
        return powerSet(new TreeSet<>(Arrays.asList(originalSet)));
    }
}

