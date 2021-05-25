package org.kodein.di.bindings;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\b\u0018\u0000*\n\b\u0000\u0010\u0002 \u0001*\u00020\u00012\u00020\u0001B\u001f\u0012\u0006\u0010\b\u001a\u00028\u0000\u0012\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0005¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00028\u0000HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J2\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\b\u001a\u00028\u00002\u0010\b\u0002\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R!\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0007R\u0019\u0010\b\u001a\u00028\u00008\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004¨\u0006\u001e"}, d2 = {"Lorg/kodein/di/bindings/Reference;", "", "T", "component1", "()Ljava/lang/Object;", "Lkotlin/Function0;", "component2", "()Lkotlin/jvm/functions/Function0;", "current", "next", "copy", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Lorg/kodein/di/bindings/Reference;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Lkotlin/jvm/functions/Function0;", "getNext", AuthSource.SEND_ABUSE, "Ljava/lang/Object;", "getCurrent", "<init>", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)V", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
public final class Reference<T> {
    @NotNull
    public final T a;
    @NotNull
    public final Function0<T> b;

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.functions.Function0<? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    public Reference(@NotNull T t, @NotNull Function0<? extends T> function0) {
        Intrinsics.checkParameterIsNotNull(t, "current");
        Intrinsics.checkParameterIsNotNull(function0, "next");
        this.a = t;
        this.b = function0;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: org.kodein.di.bindings.Reference */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Reference copy$default(Reference reference, Object obj, Function0 function0, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = reference.a;
        }
        if ((i & 2) != 0) {
            function0 = reference.b;
        }
        return reference.copy(obj, function0);
    }

    @NotNull
    public final T component1() {
        return this.a;
    }

    @NotNull
    public final Function0<T> component2() {
        return this.b;
    }

    @NotNull
    public final Reference<T> copy(@NotNull T t, @NotNull Function0<? extends T> function0) {
        Intrinsics.checkParameterIsNotNull(t, "current");
        Intrinsics.checkParameterIsNotNull(function0, "next");
        return new Reference<>(t, function0);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Reference)) {
            return false;
        }
        Reference reference = (Reference) obj;
        return Intrinsics.areEqual(this.a, reference.a) && Intrinsics.areEqual(this.b, reference.b);
    }

    @NotNull
    public final T getCurrent() {
        return this.a;
    }

    @NotNull
    public final Function0<T> getNext() {
        return this.b;
    }

    public int hashCode() {
        T t = this.a;
        int i = 0;
        int hashCode = (t != null ? t.hashCode() : 0) * 31;
        Function0<T> function0 = this.b;
        if (function0 != null) {
            i = function0.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("Reference(current=");
        L.append((Object) this.a);
        L.append(", next=");
        L.append(this.b);
        L.append(")");
        return L.toString();
    }
}
