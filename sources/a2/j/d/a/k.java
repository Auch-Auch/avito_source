package a2.j.d.a;

import a2.b.a.a.a;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import java.util.Collections;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@GwtCompatible
public final class k<T> extends Optional<T> {
    private static final long serialVersionUID = 0;
    public final T a;

    public k(T t) {
        this.a = t;
    }

    @Override // com.google.common.base.Optional
    public Set<T> asSet() {
        return Collections.singleton(this.a);
    }

    @Override // com.google.common.base.Optional, java.lang.Object
    public boolean equals(@NullableDecl Object obj) {
        if (obj instanceof k) {
            return this.a.equals(((k) obj).a);
        }
        return false;
    }

    @Override // com.google.common.base.Optional
    public T get() {
        return this.a;
    }

    @Override // com.google.common.base.Optional, java.lang.Object
    public int hashCode() {
        return this.a.hashCode() + 1502476572;
    }

    @Override // com.google.common.base.Optional
    public boolean isPresent() {
        return true;
    }

    @Override // com.google.common.base.Optional
    public T or(T t) {
        Preconditions.checkNotNull(t, "use Optional.orNull() instead of Optional.or(null)");
        return this.a;
    }

    @Override // com.google.common.base.Optional
    public T orNull() {
        return this.a;
    }

    @Override // com.google.common.base.Optional, java.lang.Object
    public String toString() {
        return a.r(a.L("Optional.of("), this.a, ")");
    }

    @Override // com.google.common.base.Optional
    public <V> Optional<V> transform(Function<? super T, V> function) {
        return new k(Preconditions.checkNotNull(function.apply(this.a), "the Function passed to Optional.transform() must not return null."));
    }

    @Override // com.google.common.base.Optional
    public Optional<T> or(Optional<? extends T> optional) {
        Preconditions.checkNotNull(optional);
        return this;
    }

    @Override // com.google.common.base.Optional
    public T or(Supplier<? extends T> supplier) {
        Preconditions.checkNotNull(supplier);
        return this.a;
    }
}
