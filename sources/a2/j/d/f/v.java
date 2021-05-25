package a2.j.d.f;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
public final class v<E> extends AbstractSet<E> {
    public final Map<?, E> a;
    public final Object b;

    public v(Map<?, E> map, Object obj) {
        this.a = (Map) Preconditions.checkNotNull(map);
        this.b = Preconditions.checkNotNull(obj);
    }

    @NullableDecl
    public final E a() {
        return this.a.get(this.b);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@NullableDecl Object obj) {
        E a3 = a();
        return a3 != null && a3.equals(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
    public Iterator iterator() {
        E a3 = a();
        if (a3 == null) {
            return ImmutableSet.of().mo99iterator();
        }
        return Iterators.singletonIterator(a3);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return a() == null ? 0 : 1;
    }
}
