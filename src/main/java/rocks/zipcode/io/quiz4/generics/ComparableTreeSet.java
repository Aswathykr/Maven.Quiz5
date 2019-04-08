package rocks.zipcode.io.quiz4.generics;

import java.util.TreeSet;

/**
 * @author leon on 11/12/2018.
 */
public class    ComparableTreeSet<Element> extends TreeSet<Element> implements Comparable {

    public ComparableTreeSet(Element... arr) {
        super();
        for(Element ele : arr) {
            this.add(ele);
        }
    }


    public ComparableTreeSet() {
    }

    public int compareTo(ComparableTreeSet<Element> o) {

        return this.size() - o.size();
    }

    @Override
    public int compareTo(Object o) {
        if(! (o instanceof ComparableTreeSet))
            return -1;
        ComparableTreeSet<Element> secondSet = (ComparableTreeSet)o;
        return this.size() - secondSet.size();
    }
}
