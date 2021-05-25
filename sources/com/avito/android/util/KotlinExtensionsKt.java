package com.avito.android.util;

import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u001a>\u0010\u0007\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00028\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\b\u0005H\bø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a9\u0010\t\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00028\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00000\u0003H\bø\u0001\u0000¢\u0006\u0004\b\t\u0010\b\u001a>\u0010\n\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00028\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\u0002\b\u0005H\bø\u0001\u0000¢\u0006\u0004\b\n\u0010\b\"\u001e\u0010\r\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00028\u00008Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f\u0002\u0007\n\u0005\b20\u0001¨\u0006\u000e"}, d2 = {"T", "", "condition", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "action", "applyIf", "(Ljava/lang/Object;ZLkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "letIf", "runIf", "getExhaustive", "(Ljava/lang/Object;)Ljava/lang/Object;", "exhaustive", VKApiConst.LANG}, k = 2, mv = {1, 4, 2})
public final class KotlinExtensionsKt {
    public static final <T> T applyIf(T t, boolean z, @NotNull Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "action");
        if (z) {
            function1.invoke(t);
        }
        return t;
    }

    public static final <T> T getExhaustive(T t) {
        return t;
    }

    public static final <T> T letIf(T t, boolean z, @NotNull Function1<? super T, ? extends T> function1) {
        Intrinsics.checkNotNullParameter(function1, "action");
        return z ? (T) function1.invoke(t) : t;
    }

    public static final <T> T runIf(T t, boolean z, @NotNull Function1<? super T, ? extends T> function1) {
        Intrinsics.checkNotNullParameter(function1, "action");
        return z ? (T) function1.invoke(t) : t;
    }
}
