package com.jakewharton.rxbinding3.core;

import a2.k.a.b.a;
import androidx.annotation.CheckResult;
import androidx.core.widget.NestedScrollView;
import com.jakewharton.rxbinding3.view.ViewScrollChangeEvent;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 4, mv = {1, 4, 0})
public final class RxNestedScrollView {
    @CheckResult
    @NotNull
    public static final Observable<ViewScrollChangeEvent> scrollChangeEvents(@NotNull NestedScrollView nestedScrollView) {
        Intrinsics.checkParameterIsNotNull(nestedScrollView, "$this$scrollChangeEvents");
        return new a(nestedScrollView);
    }
}
