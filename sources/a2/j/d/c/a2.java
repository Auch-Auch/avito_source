package a2.j.d.c;

import com.google.common.collect.Lists;
import java.util.List;
import java.util.ListIterator;
public final class a2 extends Lists.a<E> {
    public a2(List list) {
        super(list);
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<E> listIterator(int i) {
        return this.a.listIterator(i);
    }
}
