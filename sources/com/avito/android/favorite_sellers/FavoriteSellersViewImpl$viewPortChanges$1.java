package com.avito.android.favorite_sellers;

import io.reactivex.rxjava3.core.FlowableEmitter;
import io.reactivex.rxjava3.core.FlowableOnSubscribe;
import io.reactivex.rxjava3.functions.Cancellable;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableCreate;
public final class FavoriteSellersViewImpl$viewPortChanges$1<T> implements FlowableOnSubscribe<ViewPortState> {
    public final /* synthetic */ FavoriteSellersViewImpl a;

    public static final class a implements Cancellable {
        public final /* synthetic */ FavoriteSellersViewImpl$viewPortChanges$1 a;
        public final /* synthetic */ FavoriteSellersViewImpl$viewPortChanges$1$listener$1 b;

        public a(FavoriteSellersViewImpl$viewPortChanges$1 favoriteSellersViewImpl$viewPortChanges$1, FavoriteSellersViewImpl$viewPortChanges$1$listener$1 favoriteSellersViewImpl$viewPortChanges$1$listener$1) {
            this.a = favoriteSellersViewImpl$viewPortChanges$1;
            this.b = favoriteSellersViewImpl$viewPortChanges$1$listener$1;
        }

        @Override // io.reactivex.rxjava3.functions.Cancellable
        public final void cancel() {
            this.a.a.e.removeOnScrollListener(this.b);
        }
    }

    public FavoriteSellersViewImpl$viewPortChanges$1(FavoriteSellersViewImpl favoriteSellersViewImpl) {
        this.a = favoriteSellersViewImpl;
    }

    @Override // io.reactivex.rxjava3.core.FlowableOnSubscribe
    public final void subscribe(FlowableEmitter<ViewPortState> flowableEmitter) {
        FavoriteSellersViewImpl$viewPortChanges$1$listener$1 favoriteSellersViewImpl$viewPortChanges$1$listener$1 = new FavoriteSellersViewImpl$viewPortChanges$1$listener$1(flowableEmitter);
        this.a.e.addOnScrollListener(favoriteSellersViewImpl$viewPortChanges$1$listener$1);
        ((FlowableCreate.a) flowableEmitter).setCancellable(new a(this, favoriteSellersViewImpl$viewPortChanges$1$listener$1));
    }
}
