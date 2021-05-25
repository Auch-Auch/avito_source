package com.avito.android.favorite_sellers;

import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.functions.Cancellable;
public final class FavoriteSellersViewImpl$scrollStateChanges$1<T> implements ObservableOnSubscribe<Integer> {
    public final /* synthetic */ FavoriteSellersViewImpl a;

    public static final class a implements Cancellable {
        public final /* synthetic */ FavoriteSellersViewImpl$scrollStateChanges$1 a;
        public final /* synthetic */ FavoriteSellersViewImpl$scrollStateChanges$1$listener$1 b;

        public a(FavoriteSellersViewImpl$scrollStateChanges$1 favoriteSellersViewImpl$scrollStateChanges$1, FavoriteSellersViewImpl$scrollStateChanges$1$listener$1 favoriteSellersViewImpl$scrollStateChanges$1$listener$1) {
            this.a = favoriteSellersViewImpl$scrollStateChanges$1;
            this.b = favoriteSellersViewImpl$scrollStateChanges$1$listener$1;
        }

        @Override // io.reactivex.rxjava3.functions.Cancellable
        public final void cancel() {
            this.a.a.e.removeOnScrollListener(this.b);
        }
    }

    public FavoriteSellersViewImpl$scrollStateChanges$1(FavoriteSellersViewImpl favoriteSellersViewImpl) {
        this.a = favoriteSellersViewImpl;
    }

    @Override // io.reactivex.rxjava3.core.ObservableOnSubscribe
    public final void subscribe(ObservableEmitter<Integer> observableEmitter) {
        FavoriteSellersViewImpl$scrollStateChanges$1$listener$1 favoriteSellersViewImpl$scrollStateChanges$1$listener$1 = new FavoriteSellersViewImpl$scrollStateChanges$1$listener$1(observableEmitter);
        this.a.e.addOnScrollListener(favoriteSellersViewImpl$scrollStateChanges$1$listener$1);
        observableEmitter.setCancellable(new a(this, favoriteSellersViewImpl$scrollStateChanges$1$listener$1));
    }
}
