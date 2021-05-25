package a2.j.d.c;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Ordering;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@GwtCompatible(serializable = true)
public final class v1<T> extends Ordering<Iterable<T>> implements Serializable {
    private static final long serialVersionUID = 0;
    public final Comparator<? super T> a;

    public v1(Comparator<? super T> comparator) {
        this.a = comparator;
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public int compare(Object obj, Object obj2) {
        Iterator<T> it = ((Iterable) obj2).iterator();
        for (T t : (Iterable) obj) {
            if (!it.hasNext()) {
                return 1;
            }
            int compare = this.a.compare(t, it.next());
            if (compare != 0) {
                return compare;
            }
        }
        return it.hasNext() ? -1 : 0;
    }

    @Override // java.util.Comparator, java.lang.Object
    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof v1) {
            return this.a.equals(((v1) obj).a);
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return this.a.hashCode() ^ 2075626741;
    }

    @Override // java.lang.Object
    public String toString() {
        return this.a + ".lexicographical()";
    }
}
