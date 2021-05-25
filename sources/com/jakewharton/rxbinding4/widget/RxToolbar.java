package com.jakewharton.rxbinding4.widget;

import a2.k.b.f.a0;
import android.view.MenuItem;
import android.widget.Toolbar;
import androidx.annotation.CheckResult;
import androidx.annotation.RequiresApi;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 4, mv = {1, 4, 0})
public final class RxToolbar {
    @NotNull
    @CheckResult
    @RequiresApi(21)
    public static final Observable<MenuItem> itemClicks(@NotNull Toolbar toolbar) {
        Intrinsics.checkParameterIsNotNull(toolbar, "$this$itemClicks");
        return new a0(toolbar);
    }

    @NotNull
    @CheckResult
    @RequiresApi(21)
    public static final Observable<Unit> navigationClicks(@NotNull Toolbar toolbar) {
        Intrinsics.checkParameterIsNotNull(toolbar, "$this$navigationClicks");
        return new ToolbarNavigationClickObservable(toolbar);
    }
}
