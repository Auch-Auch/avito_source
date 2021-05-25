package n6.c.a;

import a2.b.a.a.a;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
public final class m8<P1, P2, R> implements u8<Function2<? super P1, ? super P2, ? extends R>, R> {
    public final P1 a;
    public final P2 b;

    public m8(P1 p1, P2 p2) {
        this.a = p1;
        this.b = p2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m8)) {
            return false;
        }
        m8 m8Var = (m8) obj;
        return Intrinsics.areEqual(this.a, m8Var.a) && Intrinsics.areEqual(this.b, m8Var.b);
    }

    public int hashCode() {
        P1 p1 = this.a;
        int i = 0;
        int hashCode = (p1 != null ? p1.hashCode() : 0) * 31;
        P2 p2 = this.b;
        if (p2 != null) {
            i = p2.hashCode();
        }
        return hashCode + i;
    }

    @Override // n6.c.a.u8
    public Object invoke(Object obj) {
        Function2 function2 = (Function2) obj;
        Intrinsics.checkParameterIsNotNull(function2, "f");
        return function2.invoke(this.a, this.b);
    }

    public String toString() {
        StringBuilder L = a.L("MemoizeKey2(p1=");
        L.append((Object) this.a);
        L.append(", p2=");
        return a.r(L, this.b, ")");
    }
}
