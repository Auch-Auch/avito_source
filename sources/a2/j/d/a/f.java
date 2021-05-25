package a2.j.d.a;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Equivalence;
import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@Beta
@GwtCompatible
public final class f<F, T> extends Equivalence<F> implements Serializable {
    private static final long serialVersionUID = 0;
    public final Function<F, ? extends T> a;
    public final Equivalence<T> b;

    public f(Function<F, ? extends T> function, Equivalence<T> equivalence) {
        this.a = (Function) Preconditions.checkNotNull(function);
        this.b = (Equivalence) Preconditions.checkNotNull(equivalence);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.common.base.Equivalence<T> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.base.Equivalence
    public boolean doEquivalent(F f, F f2) {
        return this.b.equivalent(this.a.apply(f), this.a.apply(f2));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.common.base.Equivalence<T> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.base.Equivalence
    public int doHash(F f) {
        return this.b.hash(this.a.apply(f));
    }

    @Override // java.lang.Object
    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        if (!this.a.equals(fVar.a) || !this.b.equals(fVar.b)) {
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
