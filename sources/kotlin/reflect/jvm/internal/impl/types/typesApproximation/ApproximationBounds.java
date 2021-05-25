package kotlin.reflect.jvm.internal.impl.types.typesApproximation;

import a2.b.a.a.a;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public final class ApproximationBounds<T> {
    public final T a;
    public final T b;

    public ApproximationBounds(T t, T t2) {
        this.a = t;
        this.b = t2;
    }

    public final T component1() {
        return this.a;
    }

    public final T component2() {
        return this.b;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ApproximationBounds)) {
            return false;
        }
        ApproximationBounds approximationBounds = (ApproximationBounds) obj;
        return Intrinsics.areEqual(this.a, approximationBounds.a) && Intrinsics.areEqual(this.b, approximationBounds.b);
    }

    public final T getLower() {
        return this.a;
    }

    public final T getUpper() {
        return this.b;
    }

    public int hashCode() {
        T t = this.a;
        int i = 0;
        int hashCode = (t == null ? 0 : t.hashCode()) * 31;
        T t2 = this.b;
        if (t2 != null) {
            i = t2.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("ApproximationBounds(lower=");
        L.append((Object) this.a);
        L.append(", upper=");
        return a.q(L, this.b, ')');
    }
}
