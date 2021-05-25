package com.jakewharton.rxbinding4.widget;

import a2.k.b.f.j;
import a2.k.b.f.k;
import android.view.MenuItem;
import android.widget.PopupMenu;
import androidx.annotation.CheckResult;
import io.reactivex.rxjava3.core.Observable;
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
        return new j(popupMenu);
    }

    @CheckResult
    @NotNull
    public static final Observable<MenuItem> itemClicks(@NotNull PopupMenu popupMenu) {
        Intrinsics.checkParameterIsNotNull(popupMenu, "$this$itemClicks");
        return new k(popupMenu);
    }
}
