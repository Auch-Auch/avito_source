package a2.j.d.f;

import java.util.AbstractSet;
import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
public class h0 extends AbstractSet<K> {
    public final /* synthetic */ i0 a;

    public h0(i0 i0Var) {
        this.a = i0Var;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@NullableDecl Object obj) {
        return this.a.b(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
    public Iterator iterator() {
        return new g0(this, this.a.a.entrySet().iterator());
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.a.a.size();
    }
}
