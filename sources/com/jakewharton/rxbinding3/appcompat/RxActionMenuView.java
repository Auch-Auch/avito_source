package com.jakewharton.rxbinding3.appcompat;

import a2.k.a.a.a;
import android.view.MenuItem;
import androidx.annotation.CheckResult;
import androidx.appcompat.widget.ActionMenuView;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 4, mv = {1, 4, 0})
public final class RxActionMenuView {
    @CheckResult
    @NotNull
    public static final Observable<MenuItem> itemClicks(@NotNull ActionMenuView actionMenuView) {
        Intrinsics.checkParameterIsNotNull(actionMenuView, "$this$itemClicks");
        return new a(actionMenuView);
    }
}
