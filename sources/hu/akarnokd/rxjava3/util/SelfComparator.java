package hu.akarnokd.rxjava3.util;

import java.util.Comparator;
public enum SelfComparator implements Comparator<Comparable> {
    INSTANCE;

    public static <T extends Comparable<? super T>> Comparator<T> instance() {
        return INSTANCE;
    }

    public int compare(Comparable comparable, Comparable comparable2) {
        return comparable.compareTo(comparable2);
    }
}
