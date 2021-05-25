package kotlin.reflect.jvm.internal.impl.utils;

import a2.b.a.a.a;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public final class NumberWithRadix {
    @NotNull
    public final String a;
    public final int b;

    public NumberWithRadix(@NotNull String str, int i) {
        Intrinsics.checkNotNullParameter(str, "number");
        this.a = str;
        this.b = i;
    }

    @NotNull
    public final String component1() {
        return this.a;
    }

    public final int component2() {
        return this.b;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NumberWithRadix)) {
            return false;
        }
        NumberWithRadix numberWithRadix = (NumberWithRadix) obj;
        return Intrinsics.areEqual(this.a, numberWithRadix.a) && this.b == numberWithRadix.b;
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("NumberWithRadix(number=");
        L.append(this.a);
        L.append(", radix=");
        return a.i(L, this.b, ')');
    }
}
