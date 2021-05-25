package com.avito.android.rating.utils;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.floating_views.RecyclerViewScrollHandler;
import com.avito.android.floating_views.ScrollHandler;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.functions.Cancellable;
import kotlin.jvm.functions.Function0;
public final class FloatingViewsKt$floatingViewsChanges$2<T> implements ObservableOnSubscribe<Boolean> {
    public final /* synthetic */ RecyclerView a;
    public final /* synthetic */ Function0 b;

    public static final class a implements Cancellable {
        public final /* synthetic */ FloatingViewsKt$floatingViewsChanges$2 a;
        public final /* synthetic */ RecyclerViewScrollHandler b;

        public a(FloatingViewsKt$floatingViewsChanges$2 floatingViewsKt$floatingViewsChanges$2, RecyclerViewScrollHandler recyclerViewScrollHandler) {
            this.a = floatingViewsKt$floatingViewsChanges$2;
            this.b = recyclerViewScrollHandler;
        }

        @Override // io.reactivex.rxjava3.functions.Cancellable
        public final void cancel() {
            this.a.a.removeOnScrollListener(this.b);
        }
    }

    public FloatingViewsKt$floatingViewsChanges$2(RecyclerView recyclerView, Function0 function0) {
        this.a = recyclerView;
        this.b = function0;
    }

    @Override // io.reactivex.rxjava3.core.ObservableOnSubscribe
    public final void subscribe(ObservableEmitter<Boolean> observableEmitter) {
        RecyclerView.LayoutManager layoutManager = this.a.getLayoutManager();
        if (!(layoutManager instanceof LinearLayoutManager)) {
            layoutManager = null;
        }
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
        if (linearLayoutManager != null) {
            RecyclerViewScrollHandler recyclerViewScrollHandler = new RecyclerViewScrollHandler(new ScrollHandler.Listener(this, observableEmitter) { // from class: com.avito.android.rating.utils.FloatingViewsKt$floatingViewsChanges$2$scrollHandler$1
                public final /* synthetic */ FloatingViewsKt$floatingViewsChanges$2 a;
                public final /* synthetic */ ObservableEmitter b;

                {
                    this.a = r1;
                    this.b = r2;
                }

                @Override // com.avito.android.floating_views.ScrollHandler.Listener
                public void onVisibleItemChanged(int i, int i2, int i3, int i4) {
                    if (!((Boolean) this.a.b.invoke()).booleanValue() && i3 + i >= i4) {
                        this.b.onNext(Boolean.TRUE);
                    } else if (i2 < i) {
                        this.b.onNext(Boolean.FALSE);
                    } else if (i2 > i) {
                        this.b.onNext(Boolean.TRUE);
                    }
                }
            }, linearLayoutManager);
            this.a.addOnScrollListener(recyclerViewScrollHandler);
            observableEmitter.setCancellable(new a(this, recyclerViewScrollHandler));
            return;
        }
        throw new IllegalStateException("Need to use LinearLayoutManager for this RecyclerView");
    }
}
