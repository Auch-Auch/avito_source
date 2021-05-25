package com.jakewharton.rxbinding3.view;

import a2.k.a.d.a;
import a2.k.a.d.b;
import android.view.MenuItem;
import androidx.annotation.CheckResult;
import com.jakewharton.rxbinding3.internal.AlwaysTrue;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 4, mv = {1, 4, 0})
public final class RxMenuItem {
    @NotNull
    @CheckResult
    @JvmOverloads
    public static final Observable<MenuItemActionViewEvent> actionViewEvents(@NotNull MenuItem menuItem) {
        return actionViewEvents$default(menuItem, null, 1, null);
    }

    @NotNull
    @CheckResult
    @JvmOverloads
    public static final Observable<MenuItemActionViewEvent> actionViewEvents(@NotNull MenuItem menuItem, @NotNull Function1<? super MenuItemActionViewEvent, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(menuItem, "$this$actionViewEvents");
        Intrinsics.checkParameterIsNotNull(function1, "handled");
        return new a(menuItem, function1);
    }

    public static /* synthetic */ Observable actionViewEvents$default(MenuItem menuItem, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = AlwaysTrue.INSTANCE;
        }
        return actionViewEvents(menuItem, function1);
    }

    @NotNull
    @CheckResult
    @JvmOverloads
    public static final Observable<Unit> clicks(@NotNull MenuItem menuItem) {
        return clicks$default(menuItem, null, 1, null);
    }

    @NotNull
    @CheckResult
    @JvmOverloads
    public static final Observable<Unit> clicks(@NotNull MenuItem menuItem, @NotNull Function1<? super MenuItem, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(menuItem, "$this$clicks");
        Intrinsics.checkParameterIsNotNull(function1, "handled");
        return new b(menuItem, function1);
    }

    public static /* synthetic */ Observable clicks$default(MenuItem menuItem, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = AlwaysTrue.INSTANCE;
        }
        return clicks(menuItem, function1);
    }
}
