package x6.d.a.n;

import a2.b.a.a.a;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public final class e<A> {
    @NotNull
    public final Object a;
    public final A b;

    public e(@NotNull Object obj, A a3) {
        Intrinsics.checkParameterIsNotNull(obj, "scopeId");
        this.a = obj;
        this.b = a3;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return Intrinsics.areEqual(this.a, eVar.a) && Intrinsics.areEqual(this.b, eVar.b);
    }

    public int hashCode() {
        Object obj = this.a;
        int i = 0;
        int hashCode = (obj != null ? obj.hashCode() : 0) * 31;
        A a3 = this.b;
        if (a3 != null) {
            i = a3.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("ScopeKey(scopeId=");
        L.append(this.a);
        L.append(", arg=");
        return a.r(L, this.b, ")");
    }
}
