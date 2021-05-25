package a2.j.d.f;

import com.google.common.base.Preconditions;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
public abstract class l0<E> extends AbstractSet<E> {
    public final Map<E, ?> a;
    public final Object b;

    public l0(Map<E, ?> map, Object obj) {
        this.a = (Map) Preconditions.checkNotNull(map);
        this.b = Preconditions.checkNotNull(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@NullableDecl Object obj) {
        return this.b.equals(this.a.get(obj));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
    public Iterator iterator() {
        return new k0(this, this.a.entrySet().iterator());
    }
}
