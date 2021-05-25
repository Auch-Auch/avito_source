package com.jakewharton.rxbinding4.appcompat;

import a2.k.b.a.g;
import a2.k.b.a.h;
import android.view.MenuItem;
import androidx.annotation.CheckResult;
import androidx.appcompat.widget.Toolbar;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 4, mv = {1, 4, 0})
public final class RxToolbar {
    @CheckResult
    @NotNull
    public static final Observable<MenuItem> itemClicks(@NotNull Toolbar toolbar) {
        Intrinsics.checkParameterIsNotNull(toolbar, "$this$itemClicks");
        return new g(toolbar);
    }

    @CheckResult
    @NotNull
    public static final Observable<Unit> navigationClicks(@NotNull Toolbar toolbar) {
        Intrinsics.checkParameterIsNotNull(toolbar, "$this$navigationClicks");
        return new h(toolbar);
    }
}
