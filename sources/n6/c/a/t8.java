package n6.c.a;

import a2.b.a.a.a;
import kotlin.jvm.functions.Function9;
import kotlin.jvm.internal.Intrinsics;
public final class t8<P1, P2, P3, P4, P5, P6, P7, P8, P9, R> implements u8<Function9<? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super P7, ? super P8, ? super P9, ? extends R>, R> {
    public final P1 a;
    public final P2 b;
    public final P3 c;
    public final P4 d;
    public final P5 e;
    public final P6 f;
    public final P7 g;
    public final P8 h;
    public final P9 i;

    public t8(P1 p1, P2 p2, P3 p3, P4 p4, P5 p5, P6 p62, P7 p7, P8 p8, P9 p9) {
        this.a = p1;
        this.b = p2;
        this.c = p3;
        this.d = p4;
        this.e = p5;
        this.f = p62;
        this.g = p7;
        this.h = p8;
        this.i = p9;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof t8)) {
            return false;
        }
        t8 t8Var = (t8) obj;
        return Intrinsics.areEqual(this.a, t8Var.a) && Intrinsics.areEqual(this.b, t8Var.b) && Intrinsics.areEqual(this.c, t8Var.c) && Intrinsics.areEqual(this.d, t8Var.d) && Intrinsics.areEqual(this.e, t8Var.e) && Intrinsics.areEqual(this.f, t8Var.f) && Intrinsics.areEqual(this.g, t8Var.g) && Intrinsics.areEqual(this.h, t8Var.h) && Intrinsics.areEqual(this.i, t8Var.i);
    }

    public int hashCode() {
        P1 p1 = this.a;
        int i2 = 0;
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
        int hashCode6 = (hashCode5 + (p62 != null ? p62.hashCode() : 0)) * 31;
        P7 p7 = this.g;
        int hashCode7 = (hashCode6 + (p7 != null ? p7.hashCode() : 0)) * 31;
        P8 p8 = this.h;
        int hashCode8 = (hashCode7 + (p8 != null ? p8.hashCode() : 0)) * 31;
        P9 p9 = this.i;
        if (p9 != null) {
            i2 = p9.hashCode();
        }
        return hashCode8 + i2;
    }

    @Override // n6.c.a.u8
    public Object invoke(Object obj) {
        Function9 function9 = (Function9) obj;
        Intrinsics.checkParameterIsNotNull(function9, "f");
        return function9.invoke(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i);
    }

    public String toString() {
        StringBuilder L = a.L("MemoizeKey9(p1=");
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
        L.append((Object) this.f);
        L.append(", p7=");
        L.append((Object) this.g);
        L.append(", p8=");
        L.append((Object) this.h);
        L.append(", p9=");
        return a.r(L, this.i, ")");
    }
}
