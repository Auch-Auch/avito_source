package com.jakewharton.rxbinding4.widget;

import a2.k.b.f.a;
import android.widget.AbsListView;
import androidx.annotation.CheckResult;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 4, mv = {1, 4, 0})
public final class RxAbsListView {
    @CheckResult
    @NotNull
    public static final Observable<AbsListViewScrollEvent> scrollEvents(@NotNull AbsListView absListView) {
        Intrinsics.checkParameterIsNotNull(absListView, "$this$scrollEvents");
        return new a(absListView);
    }
}
