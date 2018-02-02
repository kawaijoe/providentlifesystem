package aooad.assignment.providentlifesystem.collection;

import java.util.Iterator;

@FunctionalInterface
public interface Collection<T> {

    Iterator<T> createIterator();

}
