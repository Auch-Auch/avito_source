package a2.j.d.c;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Ordering;
import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@GwtCompatible(serializable = true)
public final class v<F, T> extends Ordering<F> implements Serializable {
    private static final long serialVersionUID = 0;
    public final Function<F, ? extends T> a;
    public final Ordering<T> b;

    public v(Function<F, ? extends T> function, Ordering<T> ordering) {
        this.a = (Function) Preconditions.checkNotNull(function);
        this.b = (Ordering) Preconditions.checkNotNull(ordering);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.common.collect.Ordering<T> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public int compare(F f, F f2) {
        return this.b.compare(this.a.apply(f), this.a.apply(f2));
    }

    @Override // java.util.Comparator, java.lang.Object
    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof v)) {
            return false;
        }
        v vVar = (v) obj;
        if (!this.a.equals(vVar.a) || !this.b.equals(vVar.b)) {
            return false;
        }
        return true;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return Objects.hashCode(this.a, this.b);
    }

    @Override // java.lang.Object
    public String toString() {
        return this.b + ".onResultOf(" + this.a + ")";
    }
}
