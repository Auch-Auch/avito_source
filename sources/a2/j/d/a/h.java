package a2.j.d.a;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Equivalence;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@GwtCompatible(serializable = true)
public final class h<T> extends Equivalence<Iterable<T>> implements Serializable {
    private static final long serialVersionUID = 1;
    public final Equivalence<? super T> a;

    public h(Equivalence<? super T> equivalence) {
        this.a = (Equivalence) Preconditions.checkNotNull(equivalence);
    }

    @Override // com.google.common.base.Equivalence
    public boolean doEquivalent(Object obj, Object obj2) {
        Iterator<T> it = ((Iterable) obj).iterator();
        Iterator<T> it2 = ((Iterable) obj2).iterator();
        while (it.hasNext() && it2.hasNext()) {
            if (!this.a.equivalent(it.next(), it2.next())) {
                return false;
            }
        }
        if (it.hasNext() || it2.hasNext()) {
            return false;
        }
        return true;
    }

    @Override // com.google.common.base.Equivalence
    public int doHash(Object obj) {
        int i = 78721;
        for (T t : (Iterable) obj) {
            i = (i * 24943) + this.a.hash(t);
        }
        return i;
    }

    @Override // java.lang.Object
    public boolean equals(@NullableDecl Object obj) {
        if (obj instanceof h) {
            return this.a.equals(((h) obj).a);
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return this.a.hashCode() ^ 1185147655;
    }

    @Override // java.lang.Object
    public String toString() {
        return this.a + ".pairwise()";
    }
}
