package com.jakewharton.rxbinding3.widget;

import a2.k.a.f.l;
import a2.k.a.f.o;
import android.widget.RadioGroup;
import androidx.annotation.CheckResult;
import com.jakewharton.rxbinding3.InitialValueObservable;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 4, mv = {1, 4, 0})
public final class RxRadioGroup {
    @CheckResult
    @NotNull
    public static final Consumer<? super Integer> checked(@NotNull RadioGroup radioGroup) {
        Intrinsics.checkParameterIsNotNull(radioGroup, "$this$checked");
        return new o(radioGroup);
    }

    @CheckResult
    @NotNull
    public static final InitialValueObservable<Integer> checkedChanges(@NotNull RadioGroup radioGroup) {
        Intrinsics.checkParameterIsNotNull(radioGroup, "$this$checkedChanges");
        return new l(radioGroup);
    }
}
