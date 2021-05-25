package org.junit.runner.manipulation;

import java.util.Comparator;
import org.junit.runner.Description;
import org.junit.runner.manipulation.Ordering;
public final class Alphanumeric extends Sorter implements Ordering.Factory {
    public static final Comparator<Description> b = new a();

    public static class a implements Comparator<Description> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public int compare(Description description, Description description2) {
            return description.getDisplayName().compareTo(description2.getDisplayName());
        }
    }

    public Alphanumeric() {
        super(b);
    }

    @Override // org.junit.runner.manipulation.Ordering.Factory
    public Ordering create(Ordering.Context context) {
        return this;
    }
}
