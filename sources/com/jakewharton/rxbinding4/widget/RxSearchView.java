package com.jakewharton.rxbinding4.widget;

import a2.k.b.f.p;
import a2.k.b.f.q;
import a2.k.b.f.r;
import android.widget.SearchView;
import androidx.annotation.CheckResult;
import com.jakewharton.rxbinding4.InitialValueObservable;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 4, mv = {1, 4, 0})
public final class RxSearchView {
    @CheckResult
    @NotNull
    public static final Consumer<? super CharSequence> query(@NotNull SearchView searchView, boolean z) {
        Intrinsics.checkParameterIsNotNull(searchView, "$this$query");
        return new p(searchView, z);
    }

    @CheckResult
    @NotNull
    public static final InitialValueObservable<SearchViewQueryTextEvent> queryTextChangeEvents(@NotNull SearchView searchView) {
        Intrinsics.checkParameterIsNotNull(searchView, "$this$queryTextChangeEvents");
        return new q(searchView);
    }

    @CheckResult
    @NotNull
    public static final InitialValueObservable<CharSequence> queryTextChanges(@NotNull SearchView searchView) {
        Intrinsics.checkParameterIsNotNull(searchView, "$this$queryTextChanges");
        return new r(searchView);
    }
}
