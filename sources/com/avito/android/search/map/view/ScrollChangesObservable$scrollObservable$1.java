package com.avito.android.search.map.view;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.floating_views.RecyclerViewScrollHandler;
import com.avito.android.floating_views.ScrollHandler;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.functions.Cancellable;
public final class ScrollChangesObservable$scrollObservable$1<T> implements ObservableOnSubscribe<Boolean> {
    public final /* synthetic */ ScrollChangesObservable a;
    public final /* synthetic */ LinearLayoutManager b;
    public final /* synthetic */ RecyclerView c;

    public static final class a implements Cancellable {
        public final /* synthetic */ ScrollChangesObservable$scrollObservable$1 a;
        public final /* synthetic */ RecyclerViewScrollHandler b;

        public a(ScrollChangesObservable$scrollObservable$1 scrollChangesObservable$scrollObservable$1, RecyclerViewScrollHandler recyclerViewScrollHandler) {
            this.a = scrollChangesObservable$scrollObservable$1;
            this.b = recyclerViewScrollHandler;
        }

        @Override // io.reactivex.rxjava3.functions.Cancellable
        public final void cancel() {
            this.a.c.removeOnScrollListener(this.b);
        }
    }

    public ScrollChangesObservable$scrollObservable$1(ScrollChangesObservable scrollChangesObservable, LinearLayoutManager linearLayoutManager, RecyclerView recyclerView) {
        this.a = scrollChangesObservable;
        this.b = linearLayoutManager;
        this.c = recyclerView;
    }

    @Override // io.reactivex.rxjava3.core.ObservableOnSubscribe
    public final void subscribe(ObservableEmitter<Boolean> observableEmitter) {
        RecyclerViewScrollHandler recyclerViewScrollHandler = new RecyclerViewScrollHandler(new ScrollHandler.Listener(this, observableEmitter) { // from class: com.avito.android.search.map.view.ScrollChangesObservable$scrollObservable$1$handler$1
            public final /* synthetic */ ScrollChangesObservable$scrollObservable$1 a;
            public final /* synthetic */ ObservableEmitter b;

            {
                this.a = r1;
                this.b = r2;
            }

            @Override // com.avito.android.floating_views.ScrollHandler.Listener
            public void onVisibleItemChanged(int i, int i2, int i3, int i4) {
                if (!((Boolean) this.a.a.a.invoke()).booleanValue() && i3 + i >= i4) {
                    this.b.onNext(Boolean.TRUE);
                } else if (i2 < i) {
                    this.b.onNext(Boolean.FALSE);
                } else if (i2 > i) {
                    this.b.onNext(Boolean.TRUE);
                }
            }
        }, this.b);
        observableEmitter.setCancellable(new a(this, recyclerViewScrollHandler));
        this.c.addOnScrollListener(recyclerViewScrollHandler);
    }
}
