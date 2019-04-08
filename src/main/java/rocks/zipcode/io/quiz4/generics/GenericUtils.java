package rocks.zipcode.io.quiz4.generics;

import java.util.*;

/**
 * @author leon on 11/12/2018.
 */
public class GenericUtils {
    public static <_ extends Comparable> Iterable<? extends Iterable<_>> powerSet(Set<_> originalSet) {
        ArrayList<_> set = new ArrayList<>(originalSet);
        Collections.sort(set);

        ArrayList<TreeSet<_>> resultSet = new ArrayList<>();
        Set<TreeSet<_>> newresultSet = new LinkedHashSet<>();
        int n = set.size();

        long pow_set_size =
                (long)Math.pow(2, n);
        int counter, j;
        resultSet.add(new TreeSet<>(originalSet));
        for(counter = 0; counter <
                pow_set_size; counter++)
        {
            TreeSet<_> temp = new TreeSet<>();
            for(j = 0; j < n; j++)
            {
                int n1 = (counter & (1 << j));
                if( n1 > 0)
                    temp.add(set.get(j));
            }
            if(temp.size() != 0 && temp.size() != set.size())
            resultSet.add(temp);
        }
        resultSet.add(new TreeSet<>());

        return resultSet;
    }

//    public static <_ extends Comparable> Set<Set<_>> powerSet(Set<_> originalSet) {
//        Set<Set<_>> sets = new LinkedHashSet<>();
//        if (originalSet.isEmpty()) {
//            sets.add(new HashSet<_>());
//            return sets;
//        }
//        List<_> list = new ArrayList<_>(originalSet);
//        _ head = list.get(0);
//        Set<_> rest = new HashSet<_>(list.subList(1, list.size()));
//        for (Set<_> set : powerSet(rest)) {
//            Set<_> newSet = new TreeSet<>();
//            newSet.addAll(set);
//            newSet.add(head);
//            sets.add(newSet);
//            sets.add(set);
//        }
//        return sets;
//    }

//    public static <_ extends Comparable> Iterable<? extends Iterable<_>> powerSet(Set<_> originalSet) {
//        return getSubsets(new ArrayList<_>(originalSet), 0);
//    }
//
//    static<_> ArrayList<ArrayList<_>> getSubsets(ArrayList<_> set, int index){
//        ArrayList<ArrayList<_>> allsubsets;
//        if(set.size() == index){
//            allsubsets = new ArrayList<ArrayList<_>>();
//            allsubsets.add(new ArrayList<_>()); // the empty set
//        }else{
//            allsubsets = getSubsets(set, index+1);
//            _ item = set.get(index);
//
//            ArrayList<ArrayList<_>> moresubsets = new ArrayList<ArrayList<_>>();
//
//            for(ArrayList<_> subset: allsubsets){
//                ArrayList<_> newsubset = new ArrayList<_>();
//
//                newsubset.addAll(subset);
//                newsubset.add(item);
//                moresubsets.add(newsubset);
//
//            }
//
//            moresubsets.addAll(moresubsets);
//
//        }
//
//        return allsubsets;
//    }

    public static <_ extends Comparable> Iterable<? extends Iterable<_>> powerSet(_... originalSet) {
        return powerSet(new TreeSet<>(Arrays.asList(originalSet)));
    }
}

