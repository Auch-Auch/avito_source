package a2.j.d.c;

import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.common.collect.SortedMultiset;
import java.util.Iterator;
public class n extends n0<E> {
    public final /* synthetic */ o d;

    public n(o oVar) {
        this.d = oVar;
    }

    @Override // a2.j.d.c.n0
    public SortedMultiset<E> d() {
        return this.d;
    }

    @Override // a2.j.d.c.n0
    public Iterator<Multiset.Entry<E>> entryIterator() {
        return this.d.e();
    }

    @Override // a2.j.d.c.n0, com.google.common.collect.ForwardingCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return Multisets.d(this.d.mo11descendingMultiset());
    }
}
