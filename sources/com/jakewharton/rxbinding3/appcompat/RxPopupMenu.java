package com.jakewharton.rxbinding3.appcompat;

import a2.k.a.a.b;
import a2.k.a.a.c;
import android.view.MenuItem;
import androidx.annotation.CheckResult;
import androidx.appcompat.widget.PopupMenu;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 4, mv = {1, 4, 0})
public final class RxPopupMenu {
    @CheckResult
    @NotNull
    public static final Observable<Unit> dismisses(@NotNull PopupMenu popupMenu) {
        Intrinsics.checkParameterIsNotNull(popupMenu, "$this$dismisses");
        return new b(popupMenu);
    }

    @CheckResult
    @NotNull
    public static final Observable<MenuItem> itemClicks(@NotNull PopupMenu popupMenu) {
        Intrinsics.checkParameterIsNotNull(popupMenu, "$this$itemClicks");
        return new c(popupMenu);
    }
}
