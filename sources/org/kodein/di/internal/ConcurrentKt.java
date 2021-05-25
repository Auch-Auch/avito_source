package org.kodein.di.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\\\u0010\t\u001a\u00028\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\u0004\b\u0001\u0010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00002\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u00042\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004H\b¢\u0006\u0004\b\t\u0010\n\u001a\\\u0010\u000b\u001a\u00028\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\u0004\b\u0001\u0010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00002\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00010\u00042\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006H\b¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"", "T", "R", "lock", "Lkotlin/Function0;", "predicate", "Lkotlin/Function1;", "ifNotNull", "ifNull", "synchronizedIfNull", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "synchronizedIfNotNull", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "kodein-di-core"}, k = 2, mv = {1, 4, 0})
public final class ConcurrentKt {
    public static final <T, R> R synchronizedIfNotNull(@Nullable Object obj, @NotNull Function0<? extends T> function0, @NotNull Function0<? extends R> function02, @NotNull Function1<? super T, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(function0, "predicate");
        Intrinsics.checkParameterIsNotNull(function02, "ifNull");
        Intrinsics.checkParameterIsNotNull(function1, "ifNotNull");
        if (function0.invoke() == null) {
            return (R) function02.invoke();
        }
        if (obj == null) {
            Object obj2 = (Object) function0.invoke();
            if (obj2 != 0) {
                return (R) function1.invoke(obj2);
            }
        } else {
            synchronized (obj) {
                try {
                    Object obj3 = (Object) function0.invoke();
                    if (obj3 != 0) {
                        R r = (R) function1.invoke(obj3);
                        InlineMarker.finallyStart(2);
                        InlineMarker.finallyEnd(2);
                        return r;
                    }
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                } catch (Throwable th) {
                    InlineMarker.finallyStart(1);
                    InlineMarker.finallyEnd(1);
                    throw th;
                }
            }
            InlineMarker.finallyEnd(1);
        }
        return (R) function02.invoke();
    }

    public static final <T, R> R synchronizedIfNull(@Nullable Object obj, @NotNull Function0<? extends T> function0, @NotNull Function1<? super T, ? extends R> function1, @NotNull Function0<? extends R> function02) {
        Object obj2;
        Object invoke;
        Intrinsics.checkParameterIsNotNull(function0, "predicate");
        Intrinsics.checkParameterIsNotNull(function1, "ifNotNull");
        Intrinsics.checkParameterIsNotNull(function02, "ifNull");
        Object obj3 = (Object) function0.invoke();
        if (obj3 != 0) {
            return (R) function1.invoke(obj3);
        }
        if (obj == null) {
            obj2 = function0.invoke();
            if (obj2 == null) {
                return (R) function02.invoke();
            }
        } else {
            synchronized (obj) {
                try {
                    invoke = function0.invoke();
                    if (invoke != null) {
                        InlineMarker.finallyStart(1);
                    } else {
                        R r = (R) function02.invoke();
                        InlineMarker.finallyStart(2);
                        InlineMarker.finallyEnd(2);
                        return r;
                    }
                } catch (Throwable th) {
                    InlineMarker.finallyStart(1);
                    InlineMarker.finallyEnd(1);
                    throw th;
                }
            }
            InlineMarker.finallyEnd(1);
            obj2 = invoke;
        }
        return (R) function1.invoke(obj2);
    }
}
