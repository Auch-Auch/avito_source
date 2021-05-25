package n6.c.a;

import a2.b.a.a.a;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.internal.Intrinsics;
public final class r8<P1, P2, P3, P4, P5, P6, P7, R> implements u8<Function7<? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super P7, ? extends R>, R> {
    public final P1 a;
    public final P2 b;
    public final P3 c;
    public final P4 d;
    public final P5 e;
    public final P6 f;
    public final P7 g;

    public r8(P1 p1, P2 p2, P3 p3, P4 p4, P5 p5, P6 p62, P7 p7) {
        this.a = p1;
        this.b = p2;
        this.c = p3;
        this.d = p4;
        this.e = p5;
        this.f = p62;
        this.g = p7;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof r8)) {
            return false;
        }
        r8 r8Var = (r8) obj;
        return Intrinsics.areEqual(this.a, r8Var.a) && Intrinsics.areEqual(this.b, r8Var.b) && Intrinsics.areEqual(this.c, r8Var.c) && Intrinsics.areEqual(this.d, r8Var.d) && Intrinsics.areEqual(this.e, r8Var.e) && Intrinsics.areEqual(this.f, r8Var.f) && Intrinsics.areEqual(this.g, r8Var.g);
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
        if (p7 != null) {
            i = p7.hashCode();
        }
        return hashCode6 + i;
    }

    @Override // n6.c.a.u8
    public Object invoke(Object obj) {
        Function7 function7 = (Function7) obj;
        Intrinsics.checkParameterIsNotNull(function7, "f");
        return function7.invoke(this.a, this.b, this.c, this.d, this.e, this.f, this.g);
    }

    public String toString() {
        StringBuilder L = a.L("MemoizeKey7(p1=");
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
        return a.r(L, this.g, ")");
    }
}
