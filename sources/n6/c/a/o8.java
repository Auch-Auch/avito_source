package n6.c.a;

import a2.b.a.a.a;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
public final class o8<P1, P2, P3, P4, R> implements u8<Function4<? super P1, ? super P2, ? super P3, ? super P4, ? extends R>, R> {
    public final P1 a;
    public final P2 b;
    public final P3 c;
    public final P4 d;

    public o8(P1 p1, P2 p2, P3 p3, P4 p4) {
        this.a = p1;
        this.b = p2;
        this.c = p3;
        this.d = p4;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o8)) {
            return false;
        }
        o8 o8Var = (o8) obj;
        return Intrinsics.areEqual(this.a, o8Var.a) && Intrinsics.areEqual(this.b, o8Var.b) && Intrinsics.areEqual(this.c, o8Var.c) && Intrinsics.areEqual(this.d, o8Var.d);
    }

    public int hashCode() {
        P1 p1 = this.a;
        int i = 0;
        int hashCode = (p1 != null ? p1.hashCode() : 0) * 31;
        P2 p2 = this.b;
        int hashCode2 = (hashCode + (p2 != null ? p2.hashCode() : 0)) * 31;
        P3 p3 = this.c;
        int hashCode3 = (hashCode2 + (p3 != null ? p3.hashCode() : 0)) * 31;
        P4 p4 = this.d;
        if (p4 != null) {
            i = p4.hashCode();
        }
        return hashCode3 + i;
    }

    @Override // n6.c.a.u8
    public Object invoke(Object obj) {
        Function4 function4 = (Function4) obj;
        Intrinsics.checkParameterIsNotNull(function4, "f");
        return function4.invoke(this.a, this.b, this.c, this.d);
    }

    public String toString() {
        StringBuilder L = a.L("MemoizeKey4(p1=");
        L.append((Object) this.a);
        L.append(", p2=");
        L.append((Object) this.b);
        L.append(", p3=");
        L.append((Object) this.c);
        L.append(", p4=");
        return a.r(L, this.d, ")");
    }
}
