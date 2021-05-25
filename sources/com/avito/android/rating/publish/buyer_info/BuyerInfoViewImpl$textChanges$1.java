package com.avito.android.rating.publish.buyer_info;

import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.functions.Cancellable;
public final class BuyerInfoViewImpl$textChanges$1<T> implements ObservableOnSubscribe<String> {
    public final /* synthetic */ BuyerInfoViewImpl a;

    public static final class a implements Cancellable {
        public final /* synthetic */ BuyerInfoViewImpl$textChanges$1 a;
        public final /* synthetic */ BuyerInfoViewImpl$textChanges$1$watcher$1 b;

        public a(BuyerInfoViewImpl$textChanges$1 buyerInfoViewImpl$textChanges$1, BuyerInfoViewImpl$textChanges$1$watcher$1 buyerInfoViewImpl$textChanges$1$watcher$1) {
            this.a = buyerInfoViewImpl$textChanges$1;
            this.b = buyerInfoViewImpl$textChanges$1$watcher$1;
        }

        @Override // io.reactivex.rxjava3.functions.Cancellable
        public final void cancel() {
            this.a.a.b.removeTextChangedListener(this.b);
        }
    }

    public BuyerInfoViewImpl$textChanges$1(BuyerInfoViewImpl buyerInfoViewImpl) {
        this.a = buyerInfoViewImpl;
    }

    @Override // io.reactivex.rxjava3.core.ObservableOnSubscribe
    public final void subscribe(ObservableEmitter<String> observableEmitter) {
        BuyerInfoViewImpl$textChanges$1$watcher$1 buyerInfoViewImpl$textChanges$1$watcher$1 = new BuyerInfoViewImpl$textChanges$1$watcher$1(observableEmitter);
        this.a.b.addTextChangedListener(buyerInfoViewImpl$textChanges$1$watcher$1);
        observableEmitter.setCancellable(new a(this, buyerInfoViewImpl$textChanges$1$watcher$1));
    }
}
