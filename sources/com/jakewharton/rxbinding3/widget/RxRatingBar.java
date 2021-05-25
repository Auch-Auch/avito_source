package com.jakewharton.rxbinding3.widget;

import a2.k.a.f.m;
import a2.k.a.f.n;
import android.widget.RatingBar;
import androidx.annotation.CheckResult;
import com.jakewharton.rxbinding3.InitialValueObservable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 4, mv = {1, 4, 0})
public final class RxRatingBar {
    @CheckResult
    @NotNull
    public static final InitialValueObservable<RatingBarChangeEvent> ratingChangeEvents(@NotNull RatingBar ratingBar) {
        Intrinsics.checkParameterIsNotNull(ratingBar, "$this$ratingChangeEvents");
        return new m(ratingBar);
    }

    @CheckResult
    @NotNull
    public static final InitialValueObservable<Float> ratingChanges(@NotNull RatingBar ratingBar) {
        Intrinsics.checkParameterIsNotNull(ratingBar, "$this$ratingChanges");
        return new n(ratingBar);
    }
}
