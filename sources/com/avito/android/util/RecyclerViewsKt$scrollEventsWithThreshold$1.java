package com.avito.android.util;

import androidx.recyclerview.widget.RecyclerView;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Cancellable;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public final class RecyclerViewsKt$scrollEventsWithThreshold$1<T> implements ObservableOnSubscribe<ScrollEventWithThreshold> {
    public final /* synthetic */ RecyclerView a;
    public final /* synthetic */ int b;

    public static final class a implements Cancellable {
        public final /* synthetic */ RecyclerViewsKt$scrollEventsWithThreshold$1 a;
        public final /* synthetic */ RecyclerViewsKt$scrollEventsWithThreshold$1$scrollListener$1 b;

        public a(RecyclerViewsKt$scrollEventsWithThreshold$1 recyclerViewsKt$scrollEventsWithThreshold$1, RecyclerViewsKt$scrollEventsWithThreshold$1$scrollListener$1 recyclerViewsKt$scrollEventsWithThreshold$1$scrollListener$1) {
            this.a = recyclerViewsKt$scrollEventsWithThreshold$1;
            this.b = recyclerViewsKt$scrollEventsWithThreshold$1$scrollListener$1;
        }

        @Override // io.reactivex.functions.Cancellable
        public final void cancel() {
            this.a.a.removeOnScrollListener(this.b);
        }
    }

    public RecyclerViewsKt$scrollEventsWithThreshold$1(RecyclerView recyclerView, int i) {
        this.a = recyclerView;
        this.b = i;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(@NotNull ObservableEmitter<ScrollEventWithThreshold> observableEmitter) {
        Intrinsics.checkNotNullParameter(observableEmitter, "emitter");
        RecyclerViewsKt$scrollEventsWithThreshold$1$scrollListener$1 recyclerViewsKt$scrollEventsWithThreshold$1$scrollListener$1 = new RecyclerViewsKt$scrollEventsWithThreshold$1$scrollListener$1(this, observableEmitter);
        this.a.addOnScrollListener(recyclerViewsKt$scrollEventsWithThreshold$1$scrollListener$1);
        observableEmitter.setCancellable(new a(this, recyclerViewsKt$scrollEventsWithThreshold$1$scrollListener$1));
    }
}
