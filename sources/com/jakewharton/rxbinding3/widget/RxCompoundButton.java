package com.jakewharton.rxbinding3.widget;

import a2.k.a.f.i;
import android.widget.CompoundButton;
import androidx.annotation.CheckResult;
import com.jakewharton.rxbinding3.InitialValueObservable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 4, mv = {1, 4, 0})
public final class RxCompoundButton {
    @CheckResult
    @NotNull
    public static final InitialValueObservable<Boolean> checkedChanges(@NotNull CompoundButton compoundButton) {
        Intrinsics.checkParameterIsNotNull(compoundButton, "$this$checkedChanges");
        return new i(compoundButton);
    }
}
