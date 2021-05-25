package com.jakewharton.rxbinding3.widget;

import android.widget.Adapter;
import androidx.annotation.CheckResult;
import com.jakewharton.rxbinding3.InitialValueObservable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 4, mv = {1, 4, 0})
public final class RxAdapter {
    @CheckResult
    @NotNull
    public static final <T extends Adapter> InitialValueObservable<T> dataChanges(@NotNull T t) {
        Intrinsics.checkParameterIsNotNull(t, "$this$dataChanges");
        return new AdapterDataChangeObservable(t);
    }
}
