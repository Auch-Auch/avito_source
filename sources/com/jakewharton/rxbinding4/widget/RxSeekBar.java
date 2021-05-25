package com.jakewharton.rxbinding4.widget;

import a2.k.b.f.s;
import a2.k.b.f.t;
import android.widget.SeekBar;
import androidx.annotation.CheckResult;
import com.jakewharton.rxbinding4.InitialValueObservable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 4, mv = {1, 4, 0})
public final class RxSeekBar {
    @CheckResult
    @NotNull
    public static final InitialValueObservable<SeekBarChangeEvent> changeEvents(@NotNull SeekBar seekBar) {
        Intrinsics.checkParameterIsNotNull(seekBar, "$this$changeEvents");
        return new s(seekBar);
    }

    @CheckResult
    @NotNull
    public static final InitialValueObservable<Integer> changes(@NotNull SeekBar seekBar) {
        Intrinsics.checkParameterIsNotNull(seekBar, "$this$changes");
        return new t(seekBar, null);
    }

    @CheckResult
    @NotNull
    public static final InitialValueObservable<Integer> systemChanges(@NotNull SeekBar seekBar) {
        Intrinsics.checkParameterIsNotNull(seekBar, "$this$systemChanges");
        return new t(seekBar, Boolean.FALSE);
    }

    @CheckResult
    @NotNull
    public static final InitialValueObservable<Integer> userChanges(@NotNull SeekBar seekBar) {
        Intrinsics.checkParameterIsNotNull(seekBar, "$this$userChanges");
        return new t(seekBar, Boolean.TRUE);
    }
}
