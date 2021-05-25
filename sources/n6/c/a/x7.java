package n6.c.a;

import a2.b.a.a.a;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
public final class x7<R> implements u8<Function0<? extends R>, R> {
    public final byte a;

    public x7(byte b) {
        this.a = b;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof x7) {
                if (this.a == ((x7) obj).a) {
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.a;
    }

    @Override // n6.c.a.u8
    public Object invoke(Object obj) {
        Function0 function0 = (Function0) obj;
        Intrinsics.checkParameterIsNotNull(function0, "f");
        return function0.invoke();
    }

    public String toString() {
        return a.j(a.L("MemoizeKey0(p1="), this.a, ")");
    }
}
