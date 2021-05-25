package a2.j.d.c;

import com.google.common.base.Preconditions;
import com.google.common.collect.LinkedListMultimap;
import java.util.AbstractSequentialList;
import java.util.ListIterator;
import java.util.Map;
public class y1 extends AbstractSequentialList<V> {
    public final /* synthetic */ LinkedListMultimap a;

    public class a extends c5<Map.Entry<K, V>, V> {
        public final /* synthetic */ LinkedListMultimap.f b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(y1 y1Var, ListIterator listIterator, LinkedListMultimap.f fVar) {
            super(listIterator);
            this.b = fVar;
        }

        @Override // a2.j.d.c.b5
        public Object a(Object obj) {
            return ((Map.Entry) obj).getValue();
        }

        @Override // a2.j.d.c.c5, java.util.ListIterator
        public void set(V v) {
            LinkedListMultimap.f fVar = this.b;
            Preconditions.checkState(fVar.c != null);
            fVar.c.b = v;
        }
    }

    public y1(LinkedListMultimap linkedListMultimap) {
        this.a = linkedListMultimap;
    }

    @Override // java.util.AbstractSequentialList, java.util.List, java.util.AbstractList
    public ListIterator<V> listIterator(int i) {
        LinkedListMultimap.f fVar = new LinkedListMultimap.f(i);
        return new a(this, fVar, fVar);
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    public int size() {
        return this.a.i;
    }
}
