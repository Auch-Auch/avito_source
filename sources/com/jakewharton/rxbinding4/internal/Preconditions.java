package com.jakewharton.rxbinding4.internal;

import a2.b.a.a.a;
import android.os.Looper;
import androidx.annotation.RestrictTo;
import io.reactivex.rxjava3.core.Observer;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import s6.a.e.c.b;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u001b\u0010\u0003\u001a\u00020\u00022\n\u0010\u0001\u001a\u0006\u0012\u0002\b\u00030\u0000H\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lio/reactivex/rxjava3/core/Observer;", "observer", "", "checkMainThread", "(Lio/reactivex/rxjava3/core/Observer;)Z", "rxbinding_release"}, k = 2, mv = {1, 4, 0})
@JvmName(name = "Preconditions")
public final class Preconditions {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final boolean checkMainThread(@NotNull Observer<?> observer) {
        Intrinsics.checkParameterIsNotNull(observer, "observer");
        if (!(!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()))) {
            return true;
        }
        observer.onSubscribe(b.a());
        StringBuilder L = a.L("Expected to be called on the main thread but was ");
        Thread currentThread = Thread.currentThread();
        Intrinsics.checkExpressionValueIsNotNull(currentThread, "Thread.currentThread()");
        L.append(currentThread.getName());
        observer.onError(new IllegalStateException(L.toString()));
        return false;
    }
}
