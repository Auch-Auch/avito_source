package a2.j.d.c;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.Ordering;
import java.io.Serializable;
import java.util.Comparator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@GwtCompatible(serializable = true)
public final class f0<T> extends Ordering<T> implements Serializable {
    private static final long serialVersionUID = 0;
    public final Comparator<T> a;

    public f0(Comparator<T> comparator) {
        this.a = (Comparator) Preconditions.checkNotNull(comparator);
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public int compare(T t, T t2) {
        return this.a.compare(t, t2);
    }

    @Override // java.util.Comparator, java.lang.Object
    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f0) {
            return this.a.equals(((f0) obj).a);
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return this.a.hashCode();
    }

    @Override // java.lang.Object
    public String toString() {
        return this.a.toString();
    }
}
