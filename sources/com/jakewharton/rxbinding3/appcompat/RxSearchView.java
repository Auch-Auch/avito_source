package com.jakewharton.rxbinding3.appcompat;

import a2.k.a.a.d;
import a2.k.a.a.e;
import a2.k.a.a.f;
import androidx.annotation.CheckResult;
import androidx.appcompat.widget.SearchView;
import com.jakewharton.rxbinding3.InitialValueObservable;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 4, mv = {1, 4, 0})
public final class RxSearchView {
    @CheckResult
    @NotNull
    public static final Consumer<? super CharSequence> query(@NotNull SearchView searchView, boolean z) {
        Intrinsics.checkParameterIsNotNull(searchView, "$this$query");
        return new d(searchView, z);
    }

    @CheckResult
    @NotNull
    public static final InitialValueObservable<SearchViewQueryTextEvent> queryTextChangeEvents(@NotNull SearchView searchView) {
        Intrinsics.checkParameterIsNotNull(searchView, "$this$queryTextChangeEvents");
        return new e(searchView);
    }

    @CheckResult
    @NotNull
    public static final InitialValueObservable<CharSequence> queryTextChanges(@NotNull SearchView searchView) {
        Intrinsics.checkParameterIsNotNull(searchView, "$this$queryTextChanges");
        return new f(searchView);
    }
}
