package n6.c.a;

import a2.b.a.a.a;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
public final class i8<P1, R> implements u8<Function1<? super P1, ? extends R>, R> {
    public final P1 a;

    public i8(P1 p1) {
        this.a = p1;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof i8) && Intrinsics.areEqual(this.a, ((i8) obj).a);
        }
        return true;
    }

    public int hashCode() {
        P1 p1 = this.a;
        if (p1 != null) {
            return p1.hashCode();
        }
        return 0;
    }

    @Override // n6.c.a.u8
    public Object invoke(Object obj) {
        Function1 function1 = (Function1) obj;
        Intrinsics.checkParameterIsNotNull(function1, "f");
        return function1.invoke(this.a);
    }

    public String toString() {
        return a.r(a.L("MemoizeKey1(p1="), this.a, ")");
    }
}
