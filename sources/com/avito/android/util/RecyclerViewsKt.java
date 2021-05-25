package com.avito.android.util;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0004\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0003\u001a=\u0010\f\u001a\u00020\u000b*\u00020\u00002\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\u0014\u0010\n\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0004\b\f\u0010\r\u001a\u001f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0007¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Landroidx/recyclerview/widget/RecyclerView;", "", "invalidateItemDecorationsSafely", "(Landroidx/recyclerview/widget/RecyclerView;)V", "clearItemDecorations", "Landroid/view/View;", "focused", "", "direction", "Lkotlin/Function1;", "action", "Ljava/lang/Runnable;", "onFocusedViewSafely", "(Landroidx/recyclerview/widget/RecyclerView;Landroid/view/View;ILkotlin/jvm/functions/Function1;)Ljava/lang/Runnable;", "thresholdPixels", "Lio/reactivex/Observable;", "Lcom/avito/android/util/ScrollEventWithThreshold;", "scrollEventsWithThreshold", "(Landroidx/recyclerview/widget/RecyclerView;I)Lio/reactivex/Observable;", "android_release"}, k = 2, mv = {1, 4, 2})
public final class RecyclerViewsKt {
    public static final void clearItemDecorations(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "$this$clearItemDecorations");
        int itemDecorationCount = recyclerView.getItemDecorationCount();
        if (itemDecorationCount > 0) {
            for (int i = itemDecorationCount - 1; i >= 0; i--) {
                recyclerView.removeItemDecorationAt(i);
            }
        }
    }

    public static final void invalidateItemDecorationsSafely(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "$this$invalidateItemDecorationsSafely");
        if (!recyclerView.isComputingLayout()) {
            recyclerView.invalidateItemDecorations();
        }
    }

    @NotNull
    public static final Runnable onFocusedViewSafely(@NotNull RecyclerView recyclerView, @Nullable View view, int i, @NotNull Function1<? super View, Unit> function1) {
        Intrinsics.checkNotNullParameter(recyclerView, "$this$onFocusedViewSafely");
        Intrinsics.checkNotNullParameter(function1, "action");
        RecyclerViewsKt$onFocusedViewSafely$$inlined$postDelayed$1 recyclerViewsKt$onFocusedViewSafely$$inlined$postDelayed$1 = new Runnable(recyclerView, view, i, function1) { // from class: com.avito.android.util.RecyclerViewsKt$onFocusedViewSafely$$inlined$postDelayed$1
            public final /* synthetic */ RecyclerView a;
            public final /* synthetic */ View b;
            public final /* synthetic */ int c;
            public final /* synthetic */ Function1 d;

            {
                this.a = r1;
                this.b = r2;
                this.c = r3;
                this.d = r4;
            }

            @Override // java.lang.Runnable
            public final void run() {
                try {
                    this.d.invoke(this.a.focusSearch(this.b, this.c));
                } catch (NullPointerException e) {
                    Logs.error("PaymentGenericFormView_recycler_NPE", e);
                }
            }
        };
        recyclerView.postDelayed(recyclerViewsKt$onFocusedViewSafely$$inlined$postDelayed$1, 100);
        return recyclerViewsKt$onFocusedViewSafely$$inlined$postDelayed$1;
    }

    public static /* synthetic */ Runnable onFocusedViewSafely$default(RecyclerView recyclerView, View view, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            view = null;
        }
        if ((i2 & 2) != 0) {
            i = 2;
        }
        return onFocusedViewSafely(recyclerView, view, i, function1);
    }

    @NotNull
    public static final Observable<ScrollEventWithThreshold> scrollEventsWithThreshold(@NotNull RecyclerView recyclerView, int i) {
        Intrinsics.checkNotNullParameter(recyclerView, "$this$scrollEventsWithThreshold");
        Observable<ScrollEventWithThreshold> create = Observable.create(new RecyclerViewsKt$scrollEventsWithThreshold$1(recyclerView, i));
        Intrinsics.checkNotNullExpressionValue(create, "Observable.create { emit…r(scrollListener) }\n    }");
        return create;
    }
}
