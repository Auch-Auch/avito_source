package com.jakewharton.rxbinding4.recyclerview;

import androidx.annotation.CheckResult;
import androidx.recyclerview.widget.RecyclerView;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 4, mv = {1, 4, 0})
public final class RxRecyclerView {
    @CheckResult
    @NotNull
    public static final Observable<RecyclerViewChildAttachStateChangeEvent> childAttachStateChangeEvents(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkParameterIsNotNull(recyclerView, "$this$childAttachStateChangeEvents");
        return new RecyclerViewChildAttachStateChangeEventObservable(recyclerView);
    }

    @CheckResult
    @NotNull
    public static final Observable<RecyclerViewFlingEvent> flingEvents(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkParameterIsNotNull(recyclerView, "$this$flingEvents");
        return new RecyclerViewFlingEventObservable(recyclerView);
    }

    @CheckResult
    @NotNull
    public static final Observable<RecyclerViewScrollEvent> scrollEvents(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkParameterIsNotNull(recyclerView, "$this$scrollEvents");
        return new RecyclerViewScrollEventObservable(recyclerView);
    }

    @CheckResult
    @NotNull
    public static final Observable<Integer> scrollStateChanges(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkParameterIsNotNull(recyclerView, "$this$scrollStateChanges");
        return new RecyclerViewScrollStateChangeObservable(recyclerView);
    }
}
