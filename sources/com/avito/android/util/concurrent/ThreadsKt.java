package com.avito.android.util.concurrent;

import a2.b.a.a.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0004\"\u0014\u0010\u0003\u001a\u00020\u00008Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b\u0001\u0010\u0002¨\u0006\u0004"}, d2 = {"", "getCurThreadNameInBrackets", "()Ljava/lang/String;", "curThreadNameInBrackets", "android_release"}, k = 2, mv = {1, 4, 2})
public final class ThreadsKt {
    @NotNull
    public static final String getCurThreadNameInBrackets() {
        StringBuilder I = a.I('[');
        Thread currentThread = Thread.currentThread();
        Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
        I.append(currentThread.getName());
        I.append(']');
        return I.toString();
    }
}
