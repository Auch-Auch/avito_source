package a2.j.d.c;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.Ordering;
import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
@GwtCompatible(serializable = true)
public final class s2 extends Ordering<Comparable> implements Serializable {
    public static final s2 c = new s2();
    private static final long serialVersionUID = 0;
    @MonotonicNonNullDecl
    public transient Ordering<Comparable> a;
    @MonotonicNonNullDecl
    public transient Ordering<Comparable> b;

    private Object readResolve() {
        return c;
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public int compare(Object obj, Object obj2) {
        Comparable comparable = (Comparable) obj;
        Comparable comparable2 = (Comparable) obj2;
        Preconditions.checkNotNull(comparable);
        Preconditions.checkNotNull(comparable2);
        return comparable.compareTo(comparable2);
    }

    @Override // com.google.common.collect.Ordering
    public <S extends Comparable> Ordering<S> nullsFirst() {
        Ordering<S> ordering = (Ordering<S>) this.a;
        if (ordering != null) {
            return ordering;
        }
        Ordering<S> nullsFirst = super.nullsFirst();
        this.a = nullsFirst;
        return nullsFirst;
    }

    @Override // com.google.common.collect.Ordering
    public <S extends Comparable> Ordering<S> nullsLast() {
        Ordering<S> ordering = (Ordering<S>) this.b;
        if (ordering != null) {
            return ordering;
        }
        Ordering<S> nullsLast = super.nullsLast();
        this.b = nullsLast;
        return nullsLast;
    }

    @Override // com.google.common.collect.Ordering
    public <S extends Comparable> Ordering<S> reverse() {
        return i3.a;
    }

    @Override // java.lang.Object
    public String toString() {
        return "Ordering.natural()";
    }
}
