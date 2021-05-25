package a2.j.d.c;

import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import java.util.Iterator;
public class m0 extends Multisets.h<E> {
    public final /* synthetic */ n0 a;

    public m0(n0 n0Var) {
        this.a = n0Var;
    }

    @Override // com.google.common.collect.Multisets.h
    public Multiset<E> d() {
        return this.a;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
    public Iterator<Multiset.Entry<E>> iterator() {
        return this.a.entryIterator();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.a.d().entrySet().size();
    }
}
