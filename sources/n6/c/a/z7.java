package n6.c.a;

import a2.b.a.a.a;
import kotlin.jvm.functions.Function11;
import kotlin.jvm.internal.Intrinsics;
public final class z7<P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, R> implements u8<Function11<? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super P7, ? super P8, ? super P9, ? super P10, ? super P11, ? extends R>, R> {
    public final P1 a;
    public final P2 b;
    public final P3 c;
    public final P4 d;
    public final P5 e;
    public final P6 f;
    public final P7 g;
    public final P8 h;
    public final P9 i;
    public final P10 j;
    public final P11 k;

    public z7(P1 p1, P2 p2, P3 p3, P4 p4, P5 p5, P6 p62, P7 p7, P8 p8, P9 p9, P10 p10, P11 p11) {
        this.a = p1;
        this.b = p2;
        this.c = p3;
        this.d = p4;
        this.e = p5;
        this.f = p62;
        this.g = p7;
        this.h = p8;
        this.i = p9;
        this.j = p10;
        this.k = p11;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof z7)) {
            return false;
        }
        z7 z7Var = (z7) obj;
        return Intrinsics.areEqual(this.a, z7Var.a) && Intrinsics.areEqual(this.b, z7Var.b) && Intrinsics.areEqual(this.c, z7Var.c) && Intrinsics.areEqual(this.d, z7Var.d) && Intrinsics.areEqual(this.e, z7Var.e) && Intrinsics.areEqual(this.f, z7Var.f) && Intrinsics.areEqual(this.g, z7Var.g) && Intrinsics.areEqual(this.h, z7Var.h) && Intrinsics.areEqual(this.i, z7Var.i) && Intrinsics.areEqual(this.j, z7Var.j) && Intrinsics.areEqual(this.k, z7Var.k);
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
        int hashCode9 = (hashCode8 + (p9 != null ? p9.hashCode() : 0)) * 31;
        P10 p10 = this.j;
        int hashCode10 = (hashCode9 + (p10 != null ? p10.hashCode() : 0)) * 31;
        P11 p11 = this.k;
        if (p11 != null) {
            i2 = p11.hashCode();
        }
        return hashCode10 + i2;
    }

    @Override // n6.c.a.u8
    public Object invoke(Object obj) {
        Function11 function11 = (Function11) obj;
        Intrinsics.checkParameterIsNotNull(function11, "f");
        return function11.invoke(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k);
    }

    public String toString() {
        StringBuilder L = a.L("MemoizeKey11(p1=");
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
        L.append((Object) this.i);
        L.append(", p10=");
        L.append((Object) this.j);
        L.append(", p11=");
        return a.r(L, this.k, ")");
    }
}
