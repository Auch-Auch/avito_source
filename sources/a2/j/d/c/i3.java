package a2.j.d.c;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.Ordering;
import java.io.Serializable;
import java.util.Iterator;
@GwtCompatible(serializable = true)
public final class i3 extends Ordering<Comparable> implements Serializable {
    public static final i3 a = new i3();
    private static final long serialVersionUID = 0;

    private Object readResolve() {
        return a;
    }

    /* renamed from: b */
    public <E extends Comparable> E max(E e, E e2, E e3, E... eArr) {
        return (E) ((Comparable) s2.c.min(e, e2, e3, eArr));
    }

    /* renamed from: c */
    public <E extends Comparable> E max(Iterable<E> iterable) {
        return (E) ((Comparable) s2.c.min(iterable));
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public int compare(Object obj, Object obj2) {
        Comparable comparable = (Comparable) obj;
        Comparable comparable2 = (Comparable) obj2;
        Preconditions.checkNotNull(comparable);
        if (comparable == comparable2) {
            return 0;
        }
        return comparable2.compareTo(comparable);
    }

    @Override // com.google.common.collect.Ordering
    public Object min(Object obj, Object obj2) {
        return (Comparable) s2.c.max((Comparable) obj, (Comparable) obj2);
    }

    @Override // com.google.common.collect.Ordering
    public <S extends Comparable> Ordering<S> reverse() {
        return Ordering.natural();
    }

    @Override // java.lang.Object
    public String toString() {
        return "Ordering.natural().reverse()";
    }

    @Override // com.google.common.collect.Ordering
    public Object max(Object obj, Object obj2) {
        return (Comparable) s2.c.min((Comparable) obj, (Comparable) obj2);
    }

    @Override // com.google.common.collect.Ordering
    public Object min(Object obj, Object obj2, Object obj3, Object[] objArr) {
        return (Comparable) s2.c.max((Comparable) obj, (Comparable) obj2, (Comparable) obj3, (Comparable[]) objArr);
    }

    @Override // com.google.common.collect.Ordering
    public Object max(Iterator it) {
        return (Comparable) s2.c.min(it);
    }

    @Override // com.google.common.collect.Ordering
    public Object min(Iterator it) {
        return (Comparable) s2.c.max(it);
    }

    @Override // com.google.common.collect.Ordering
    public Object min(Iterable iterable) {
        return (Comparable) s2.c.max(iterable);
    }
}
