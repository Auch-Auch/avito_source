package n6.c.a;

import a2.b.a.a.a;
import kotlin.jvm.functions.Function15;
import kotlin.jvm.internal.Intrinsics;
public final class d8<P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, R> implements u8<Function15<? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super P7, ? super P8, ? super P9, ? super P10, ? super P11, ? super P12, ? super P13, ? super P14, ? super P15, ? extends R>, R> {
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
    public final P12 l;
    public final P13 m;
    public final P14 n;
    public final P15 o;

    public d8(P1 p1, P2 p2, P3 p3, P4 p4, P5 p5, P6 p62, P7 p7, P8 p8, P9 p9, P10 p10, P11 p11, P12 p12, P13 p13, P14 p14, P15 p15) {
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
        this.l = p12;
        this.m = p13;
        this.n = p14;
        this.o = p15;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d8)) {
            return false;
        }
        d8 d8Var = (d8) obj;
        return Intrinsics.areEqual(this.a, d8Var.a) && Intrinsics.areEqual(this.b, d8Var.b) && Intrinsics.areEqual(this.c, d8Var.c) && Intrinsics.areEqual(this.d, d8Var.d) && Intrinsics.areEqual(this.e, d8Var.e) && Intrinsics.areEqual(this.f, d8Var.f) && Intrinsics.areEqual(this.g, d8Var.g) && Intrinsics.areEqual(this.h, d8Var.h) && Intrinsics.areEqual(this.i, d8Var.i) && Intrinsics.areEqual(this.j, d8Var.j) && Intrinsics.areEqual(this.k, d8Var.k) && Intrinsics.areEqual(this.l, d8Var.l) && Intrinsics.areEqual(this.m, d8Var.m) && Intrinsics.areEqual(this.n, d8Var.n) && Intrinsics.areEqual(this.o, d8Var.o);
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
        int hashCode11 = (hashCode10 + (p11 != null ? p11.hashCode() : 0)) * 31;
        P12 p12 = this.l;
        int hashCode12 = (hashCode11 + (p12 != null ? p12.hashCode() : 0)) * 31;
        P13 p13 = this.m;
        int hashCode13 = (hashCode12 + (p13 != null ? p13.hashCode() : 0)) * 31;
        P14 p14 = this.n;
        int hashCode14 = (hashCode13 + (p14 != null ? p14.hashCode() : 0)) * 31;
        P15 p15 = this.o;
        if (p15 != null) {
            i2 = p15.hashCode();
        }
        return hashCode14 + i2;
    }

    @Override // n6.c.a.u8
    public Object invoke(Object obj) {
        Function15 function15 = (Function15) obj;
        Intrinsics.checkParameterIsNotNull(function15, "f");
        return function15.invoke(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o);
    }

    public String toString() {
        StringBuilder L = a.L("MemoizeKey15(p1=");
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
        L.append((Object) this.k);
        L.append(", p12=");
        L.append((Object) this.l);
        L.append(", p13=");
        L.append((Object) this.m);
        L.append(", p14=");
        L.append((Object) this.n);
        L.append(", p15=");
        return a.r(L, this.o, ")");
    }
}
