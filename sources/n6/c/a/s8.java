package n6.c.a;

import a2.b.a.a.a;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.internal.Intrinsics;
public final class s8<P1, P2, P3, P4, P5, P6, P7, P8, R> implements u8<Function8<? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super P7, ? super P8, ? extends R>, R> {
    public final P1 a;
    public final P2 b;
    public final P3 c;
    public final P4 d;
    public final P5 e;
    public final P6 f;
    public final P7 g;
    public final P8 h;

    public s8(P1 p1, P2 p2, P3 p3, P4 p4, P5 p5, P6 p62, P7 p7, P8 p8) {
        this.a = p1;
        this.b = p2;
        this.c = p3;
        this.d = p4;
        this.e = p5;
        this.f = p62;
        this.g = p7;
        this.h = p8;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s8)) {
            return false;
        }
        s8 s8Var = (s8) obj;
        return Intrinsics.areEqual(this.a, s8Var.a) && Intrinsics.areEqual(this.b, s8Var.b) && Intrinsics.areEqual(this.c, s8Var.c) && Intrinsics.areEqual(this.d, s8Var.d) && Intrinsics.areEqual(this.e, s8Var.e) && Intrinsics.areEqual(this.f, s8Var.f) && Intrinsics.areEqual(this.g, s8Var.g) && Intrinsics.areEqual(this.h, s8Var.h);
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
        int hashCode6 = (hashCode5 + (p62 != null ? p62.hashCode() : 0)) * 31;
        P7 p7 = this.g;
        int hashCode7 = (hashCode6 + (p7 != null ? p7.hashCode() : 0)) * 31;
        P8 p8 = this.h;
        if (p8 != null) {
            i = p8.hashCode();
        }
        return hashCode7 + i;
    }

    @Override // n6.c.a.u8
    public Object invoke(Object obj) {
        Function8 function8 = (Function8) obj;
        Intrinsics.checkParameterIsNotNull(function8, "f");
        return function8.invoke(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h);
    }

    public String toString() {
        StringBuilder L = a.L("MemoizeKey8(p1=");
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
        return a.r(L, this.h, ")");
    }
}
