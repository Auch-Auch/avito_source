package com.jakewharton.rxbinding4.widget;

import a2.k.b.f.b;
import a2.k.b.f.c;
import a2.k.b.f.d;
import a2.k.b.f.e;
import a2.k.b.f.f;
import a2.k.b.f.g;
import android.widget.Adapter;
import android.widget.AdapterView;
import androidx.annotation.CheckResult;
import com.jakewharton.rxbinding4.InitialValueObservable;
import com.jakewharton.rxbinding4.internal.AlwaysTrue;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 4, mv = {1, 4, 0})
public final class RxAdapterView {
    @CheckResult
    @NotNull
    public static final <T extends Adapter> Observable<AdapterViewItemClickEvent> itemClickEvents(@NotNull AdapterView<T> adapterView) {
        Intrinsics.checkParameterIsNotNull(adapterView, "$this$itemClickEvents");
        return new b(adapterView);
    }

    @CheckResult
    @NotNull
    public static final <T extends Adapter> Observable<Integer> itemClicks(@NotNull AdapterView<T> adapterView) {
        Intrinsics.checkParameterIsNotNull(adapterView, "$this$itemClicks");
        return new c(adapterView);
    }

    @NotNull
    @CheckResult
    @JvmOverloads
    public static final <T extends Adapter> Observable<AdapterViewItemLongClickEvent> itemLongClickEvents(@NotNull AdapterView<T> adapterView) {
        return itemLongClickEvents$default(adapterView, null, 1, null);
    }

    @NotNull
    @CheckResult
    @JvmOverloads
    public static final <T extends Adapter> Observable<AdapterViewItemLongClickEvent> itemLongClickEvents(@NotNull AdapterView<T> adapterView, @NotNull Function1<? super AdapterViewItemLongClickEvent, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(adapterView, "$this$itemLongClickEvents");
        Intrinsics.checkParameterIsNotNull(function1, "handled");
        return new d(adapterView, function1);
    }

    public static /* synthetic */ Observable itemLongClickEvents$default(AdapterView adapterView, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = AlwaysTrue.INSTANCE;
        }
        return itemLongClickEvents(adapterView, function1);
    }

    @NotNull
    @CheckResult
    @JvmOverloads
    public static final <T extends Adapter> Observable<Integer> itemLongClicks(@NotNull AdapterView<T> adapterView) {
        return itemLongClicks$default(adapterView, null, 1, null);
    }

    @NotNull
    @CheckResult
    @JvmOverloads
    public static final <T extends Adapter> Observable<Integer> itemLongClicks(@NotNull AdapterView<T> adapterView, @NotNull Function0<Boolean> function0) {
        Intrinsics.checkParameterIsNotNull(adapterView, "$this$itemLongClicks");
        Intrinsics.checkParameterIsNotNull(function0, "handled");
        return new e(adapterView, function0);
    }

    public static /* synthetic */ Observable itemLongClicks$default(AdapterView adapterView, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = AlwaysTrue.INSTANCE;
        }
        return itemLongClicks(adapterView, function0);
    }

    @CheckResult
    @NotNull
    public static final <T extends Adapter> InitialValueObservable<Integer> itemSelections(@NotNull AdapterView<T> adapterView) {
        Intrinsics.checkParameterIsNotNull(adapterView, "$this$itemSelections");
        return new f(adapterView);
    }

    @CheckResult
    @NotNull
    public static final <T extends Adapter> InitialValueObservable<AdapterViewSelectionEvent> selectionEvents(@NotNull AdapterView<T> adapterView) {
        Intrinsics.checkParameterIsNotNull(adapterView, "$this$selectionEvents");
        return new g(adapterView);
    }
}
