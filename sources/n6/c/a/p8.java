package n6.c.a;

import a2.b.a.a.a;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
public final class p8<P1, P2, P3, P4, P5, R> implements u8<Function5<? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? extends R>, R> {
    public final P1 a;
    public final P2 b;
    public final P3 c;
    public final P4 d;
    public final P5 e;

    public p8(P1 p1, P2 p2, P3 p3, P4 p4, P5 p5) {
        this.a = p1;
        this.b = p2;
        this.c = p3;
        this.d = p4;
        this.e = p5;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p8)) {
            return false;
        }
        p8 p8Var = (p8) obj;
        return Intrinsics.areEqual(this.a, p8Var.a) && Intrinsics.areEqual(this.b, p8Var.b) && Intrinsics.areEqual(this.c, p8Var.c) && Intrinsics.areEqual(this.d, p8Var.d) && Intrinsics.areEqual(this.e, p8Var.e);
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
        int hashCode4 = (hashCode3 + (p4 != null ? p4.hashCode() : 0)) * 31;
        P5 p5 = this.e;
        if (p5 != null) {
            i = p5.hashCode();
        }
        return hashCode4 + i;
    }

    @Override // n6.c.a.u8
    public Object invoke(Object obj) {
        Function5 function5 = (Function5) obj;
        Intrinsics.checkParameterIsNotNull(function5, "f");
        return function5.invoke(this.a, this.b, this.c, this.d, this.e);
    }

    public String toString() {
        StringBuilder L = a.L("MemoizeKey5(p1=");
        L.append((Object) this.a);
        L.append(", p2=");
        L.append((Object) this.b);
        L.append(", p3=");
        L.append((Object) this.c);
        L.append(", p4=");
        L.append((Object) this.d);
        L.append(", p5=");
        return a.r(L, this.e, ")");
    }
}
