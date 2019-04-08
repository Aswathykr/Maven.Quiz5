package rocks.zipcode.io.quiz4.generics;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.List;

/**
 * @author leon on 11/12/2018.
 */
public class MyStack<SomeType>  implements Iterable{
    List<SomeType> stack;
    public MyStack() {
        stack = new ArrayList<>();
    }

    public Boolean isEmpty() {
        return stack.size() == 0;
    }

    public void push(SomeType i) {
        stack.add(i);
    }

    public SomeType peek() {
        SomeType popValue = null;
        if(! stack.isEmpty()) {
            popValue = stack.get(stack.size() - 1);
        }
        return popValue;
    }

    public SomeType pop() {
        SomeType popValue = null;
        if(! stack.isEmpty()){
            popValue = stack.get(stack.size() - 1);
            stack.remove(popValue);
        }
        else{
            throw new EmptyStackException();
        }
        return popValue;
    }

    @Override
    public Iterator iterator() {
        return stack.iterator();
    }
}
