package org.junit.runner.manipulation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.junit.runner.Description;
public class Sorter extends Ordering implements Comparator<Description> {
    public static final Sorter NULL = new Sorter(new a());
    public final Comparator<Description> a;

    public static class a implements Comparator<Description> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(Description description, Description description2) {
            return 0;
        }
    }

    public Sorter(Comparator<Description> comparator) {
        this.a = comparator;
    }

    @Override // org.junit.runner.manipulation.Ordering
    public boolean a() {
        return false;
    }

    @Override // org.junit.runner.manipulation.Ordering
    public void apply(Object obj) {
        if (obj instanceof Sortable) {
            ((Sortable) obj).sort(this);
        }
    }

    @Override // org.junit.runner.manipulation.Ordering
    public final List<Description> orderItems(Collection<Description> collection) {
        ArrayList arrayList = new ArrayList(collection);
        Collections.sort(arrayList, this);
        return arrayList;
    }

    public int compare(Description description, Description description2) {
        return this.a.compare(description, description2);
    }
}
