package com.jakewharton.rxbinding4.swiperefreshlayout;

import a2.k.b.c.a;
import androidx.annotation.CheckResult;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 4, mv = {1, 4, 0})
public final class RxSwipeRefreshLayout {
    @CheckResult
    @NotNull
    public static final Observable<Unit> refreshes(@NotNull SwipeRefreshLayout swipeRefreshLayout) {
        Intrinsics.checkParameterIsNotNull(swipeRefreshLayout, "$this$refreshes");
        return new a(swipeRefreshLayout);
    }
}
