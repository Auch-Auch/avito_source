package com.avito.android.advert.item;

import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.functions.Cancellable;
public final class AdvertDetailsViewImpl$scrollStateChanges$1<T> implements ObservableOnSubscribe<Integer> {
    public final /* synthetic */ AdvertDetailsViewImpl a;

    public static final class a implements Cancellable {
        public final /* synthetic */ AdvertDetailsViewImpl$scrollStateChanges$1 a;
        public final /* synthetic */ AdvertDetailsViewImpl$scrollStateChanges$1$listener$1 b;

        public a(AdvertDetailsViewImpl$scrollStateChanges$1 advertDetailsViewImpl$scrollStateChanges$1, AdvertDetailsViewImpl$scrollStateChanges$1$listener$1 advertDetailsViewImpl$scrollStateChanges$1$listener$1) {
            this.a = advertDetailsViewImpl$scrollStateChanges$1;
            this.b = advertDetailsViewImpl$scrollStateChanges$1$listener$1;
        }

        @Override // io.reactivex.rxjava3.functions.Cancellable
        public final void cancel() {
            this.a.a.e.removeOnScrollListener(this.b);
        }
    }

    public AdvertDetailsViewImpl$scrollStateChanges$1(AdvertDetailsViewImpl advertDetailsViewImpl) {
        this.a = advertDetailsViewImpl;
    }

    @Override // io.reactivex.rxjava3.core.ObservableOnSubscribe
    public final void subscribe(ObservableEmitter<Integer> observableEmitter) {
        AdvertDetailsViewImpl$scrollStateChanges$1$listener$1 advertDetailsViewImpl$scrollStateChanges$1$listener$1 = new AdvertDetailsViewImpl$scrollStateChanges$1$listener$1(observableEmitter);
        this.a.e.addOnScrollListener(advertDetailsViewImpl$scrollStateChanges$1$listener$1);
        observableEmitter.setCancellable(new a(this, advertDetailsViewImpl$scrollStateChanges$1$listener$1));
    }
}
