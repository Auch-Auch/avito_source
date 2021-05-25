package a2.j.d.c;

import com.google.common.collect.LinkedListMultimap;
import java.util.AbstractSequentialList;
import java.util.ListIterator;
import java.util.Map;
public class x1 extends AbstractSequentialList<Map.Entry<K, V>> {
    public final /* synthetic */ LinkedListMultimap a;

    public x1(LinkedListMultimap linkedListMultimap) {
        this.a = linkedListMultimap;
    }

    @Override // java.util.AbstractSequentialList, java.util.List, java.util.AbstractList
    public ListIterator<Map.Entry<K, V>> listIterator(int i) {
        return new LinkedListMultimap.f(i);
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    public int size() {
        return this.a.i;
    }
}
