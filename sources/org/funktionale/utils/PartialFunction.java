package org.funktionale.utils;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u0000*\u0006\b\u0001\u0010\u0002 \u00012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003B/\u0012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u0003\u0012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0005\u001a\u00028\u00012\u0006\u0010\u0004\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00028\u0000¢\u0006\u0004\b\b\u0010\tR\"\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\"\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000b¨\u0006\u0011"}, d2 = {"Lorg/funktionale/utils/PartialFunction;", "P1", "R", "Lkotlin/Function1;", "p1", "invoke", "(Ljava/lang/Object;)Ljava/lang/Object;", "", "isDefinedAt", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Lkotlin/jvm/functions/Function1;", "f", AuthSource.SEND_ABUSE, "definetAt", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "funktionale-utils"}, k = 1, mv = {1, 4, 0})
public final class PartialFunction<P1, R> implements Function1<P1, R> {
    public final Function1<P1, Boolean> a;
    public final Function1<P1, R> b;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.jvm.functions.Function1<? super P1, java.lang.Boolean> */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.functions.Function1<? super P1, ? extends R> */
    /* JADX WARN: Multi-variable type inference failed */
    public PartialFunction(@NotNull Function1<? super P1, Boolean> function1, @NotNull Function1<? super P1, ? extends R> function12) {
        Intrinsics.checkParameterIsNotNull(function1, "definetAt");
        Intrinsics.checkParameterIsNotNull(function12, "f");
        this.a = function1;
        this.b = function12;
    }

    @Override // kotlin.jvm.functions.Function1
    public R invoke(P1 p1) {
        if (this.a.invoke(p1).booleanValue()) {
            return this.b.invoke(p1);
        }
        throw new IllegalArgumentException("Value: (" + ((Object) p1) + ") isn't supported by this function");
    }

    public final boolean isDefinedAt(P1 p1) {
        return this.a.invoke(p1).booleanValue();
    }
}
