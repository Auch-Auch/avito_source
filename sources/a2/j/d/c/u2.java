package a2.j.d.c;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Ordering;
import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@GwtCompatible(serializable = true)
public final class u2<T> extends Ordering<T> implements Serializable {
    private static final long serialVersionUID = 0;
    public final Ordering<? super T> a;

    public u2(Ordering<? super T> ordering) {
        this.a = ordering;
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public int compare(@NullableDecl T t, @NullableDecl T t2) {
        if (t == t2) {
            return 0;
        }
        if (t == null) {
            return 1;
        }
        if (t2 == null) {
            return -1;
        }
        return this.a.compare(t, t2);
    }

    @Override // java.util.Comparator, java.lang.Object
    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof u2) {
            return this.a.equals(((u2) obj).a);
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return this.a.hashCode() ^ -921210296;
    }

    @Override // com.google.common.collect.Ordering
    public <S extends T> Ordering<S> nullsFirst() {
        return this.a.nullsFirst();
    }

    @Override // com.google.common.collect.Ordering
    public <S extends T> Ordering<S> nullsLast() {
        return this;
    }

    @Override // com.google.common.collect.Ordering
    public <S extends T> Ordering<S> reverse() {
        return this.a.reverse().nullsFirst();
    }

    @Override // java.lang.Object
    public String toString() {
        return this.a + ".nullsLast()";
    }
}
