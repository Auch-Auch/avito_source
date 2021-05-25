package n6.c.a;

import a2.b.a.a.a;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;
public final class q8<P1, P2, P3, P4, P5, P6, R> implements u8<Function6<? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? extends R>, R> {
    public final P1 a;
    public final P2 b;
    public final P3 c;
    public final P4 d;
    public final P5 e;
    public final P6 f;

    public q8(P1 p1, P2 p2, P3 p3, P4 p4, P5 p5, P6 p62) {
        this.a = p1;
        this.b = p2;
        this.c = p3;
        this.d = p4;
        this.e = p5;
        this.f = p62;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof q8)) {
            return false;
        }
        q8 q8Var = (q8) obj;
        return Intrinsics.areEqual(this.a, q8Var.a) && Intrinsics.areEqual(this.b, q8Var.b) && Intrinsics.areEqual(this.c, q8Var.c) && Intrinsics.areEqual(this.d, q8Var.d) && Intrinsics.areEqual(this.e, q8Var.e) && Intrinsics.areEqual(this.f, q8Var.f);
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
        int hashCode5 = (hashCode4 + (p5 != null ? p5.hashCode() : 0)) * 31;
        P6 p62 = this.f;
        if (p62 != null) {
            i = p62.hashCode();
        }
        return hashCode5 + i;
    }

    @Override // n6.c.a.u8
    public Object invoke(Object obj) {
        Function6 function6 = (Function6) obj;
        Intrinsics.checkParameterIsNotNull(function6, "f");
        return function6.invoke(this.a, this.b, this.c, this.d, this.e, this.f);
    }

    public String toString() {
        StringBuilder L = a.L("MemoizeKey6(p1=");
        L.append((Object) this.a);
        L.append(", p2=");
        L.append((Object) this.b);
        L.append(", p3=");
        L.append((Object) this.c);
        L.append(", p4=");
        L.append((Object) this.d);
        L.append(", p5=");
        L.append((Object) this.e);
        L.append(", p6=");
        return a.r(L, this.f, ")");
    }
}
