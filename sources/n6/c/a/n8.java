package n6.c.a;

import a2.b.a.a.a;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
public final class n8<P1, P2, P3, R> implements u8<Function3<? super P1, ? super P2, ? super P3, ? extends R>, R> {
    public final P1 a;
    public final P2 b;
    public final P3 c;

    public n8(P1 p1, P2 p2, P3 p3) {
        this.a = p1;
        this.b = p2;
        this.c = p3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n8)) {
            return false;
        }
        n8 n8Var = (n8) obj;
        return Intrinsics.areEqual(this.a, n8Var.a) && Intrinsics.areEqual(this.b, n8Var.b) && Intrinsics.areEqual(this.c, n8Var.c);
    }

    public int hashCode() {
        P1 p1 = this.a;
        int i = 0;
        int hashCode = (p1 != null ? p1.hashCode() : 0) * 31;
        P2 p2 = this.b;
        int hashCode2 = (hashCode + (p2 != null ? p2.hashCode() : 0)) * 31;
        P3 p3 = this.c;
        if (p3 != null) {
            i = p3.hashCode();
        }
        return hashCode2 + i;
    }

    @Override // n6.c.a.u8
    public Object invoke(Object obj) {
        Function3 function3 = (Function3) obj;
        Intrinsics.checkParameterIsNotNull(function3, "f");
        return function3.invoke(this.a, this.b, this.c);
    }

    public String toString() {
        StringBuilder L = a.L("MemoizeKey3(p1=");
        L.append((Object) this.a);
        L.append(", p2=");
        L.append((Object) this.b);
        L.append(", p3=");
        return a.r(L, this.c, ")");
    }
}
