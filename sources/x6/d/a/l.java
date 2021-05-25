package x6.d.a;

import a2.b.a.a.a;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.kodein.di.TypeToken;
import org.kodein.di.Typed;
public final class l<A> implements Typed<A> {
    public final A a;
    @NotNull
    public final TypeToken<A> b;

    public l(A a3, @NotNull TypeToken<A> typeToken) {
        Intrinsics.checkParameterIsNotNull(typeToken, "type");
        this.a = a3;
        this.b = typeToken;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        return Intrinsics.areEqual(this.a, lVar.a) && Intrinsics.areEqual(this.b, lVar.b);
    }

    @Override // org.kodein.di.Typed
    @NotNull
    public TypeToken<A> getType() {
        return this.b;
    }

    @Override // org.kodein.di.Typed
    public A getValue() {
        return this.a;
    }

    public int hashCode() {
        A a3 = this.a;
        int i = 0;
        int hashCode = (a3 != null ? a3.hashCode() : 0) * 31;
        TypeToken<A> typeToken = this.b;
        if (typeToken != null) {
            i = typeToken.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("TypedImpl(value=");
        L.append((Object) this.a);
        L.append(", type=");
        L.append(this.b);
        L.append(")");
        return L.toString();
    }
}
