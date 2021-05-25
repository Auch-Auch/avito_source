package u6.a;

import a2.b.a.a.a;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancelHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public final class g {
    @JvmField
    @Nullable
    public final Object a;
    @JvmField
    @Nullable
    public final CancelHandler b;
    @JvmField
    @Nullable
    public final Function1<Throwable, Unit> c;
    @JvmField
    @Nullable
    public final Object d;
    @JvmField
    @Nullable
    public final Throwable e;

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.functions.Function1<? super java.lang.Throwable, kotlin.Unit> */
    /* JADX WARN: Multi-variable type inference failed */
    public g(@Nullable Object obj, @Nullable CancelHandler cancelHandler, @Nullable Function1<? super Throwable, Unit> function1, @Nullable Object obj2, @Nullable Throwable th) {
        this.a = obj;
        this.b = cancelHandler;
        this.c = function1;
        this.d = obj2;
        this.e = th;
    }

    public static g a(g gVar, Object obj, CancelHandler cancelHandler, Function1 function1, Object obj2, Throwable th, int i) {
        Object obj3 = null;
        Object obj4 = (i & 1) != 0 ? gVar.a : null;
        if ((i & 2) != 0) {
            cancelHandler = gVar.b;
        }
        Function1<Throwable, Unit> function12 = (i & 4) != 0 ? gVar.c : null;
        if ((i & 8) != 0) {
            obj3 = gVar.d;
        }
        if ((i & 16) != 0) {
            th = gVar.e;
        }
        Objects.requireNonNull(gVar);
        return new g(obj4, cancelHandler, function12, obj3, th);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return Intrinsics.areEqual(this.a, gVar.a) && Intrinsics.areEqual(this.b, gVar.b) && Intrinsics.areEqual(this.c, gVar.c) && Intrinsics.areEqual(this.d, gVar.d) && Intrinsics.areEqual(this.e, gVar.e);
    }

    public int hashCode() {
        Object obj = this.a;
        int i = 0;
        int hashCode = (obj != null ? obj.hashCode() : 0) * 31;
        CancelHandler cancelHandler = this.b;
        int hashCode2 = (hashCode + (cancelHandler != null ? cancelHandler.hashCode() : 0)) * 31;
        Function1<Throwable, Unit> function1 = this.c;
        int hashCode3 = (hashCode2 + (function1 != null ? function1.hashCode() : 0)) * 31;
        Object obj2 = this.d;
        int hashCode4 = (hashCode3 + (obj2 != null ? obj2.hashCode() : 0)) * 31;
        Throwable th = this.e;
        if (th != null) {
            i = th.hashCode();
        }
        return hashCode4 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("CompletedContinuation(result=");
        L.append(this.a);
        L.append(", cancelHandler=");
        L.append(this.b);
        L.append(", onCancellation=");
        L.append(this.c);
        L.append(", idempotentResume=");
        L.append(this.d);
        L.append(", cancelCause=");
        L.append(this.e);
        L.append(")");
        return L.toString();
    }

    public g(Object obj, CancelHandler cancelHandler, Function1 function1, Object obj2, Throwable th, int i) {
        cancelHandler = (i & 2) != 0 ? null : cancelHandler;
        function1 = (i & 4) != 0 ? null : function1;
        obj2 = (i & 8) != 0 ? null : obj2;
        th = (i & 16) != 0 ? null : th;
        this.a = obj;
        this.b = cancelHandler;
        this.c = function1;
        this.d = obj2;
        this.e = th;
    }
}
