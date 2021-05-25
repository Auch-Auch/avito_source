package com.avito.android.favorite_sellers.adapter.recommendation;

import android.os.Parcelable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.functions.Cancellable;
public final class RecommendationItemViewImpl$scrollStateUpdates$1<T> implements ObservableOnSubscribe<Parcelable> {
    public final /* synthetic */ RecommendationItemViewImpl a;

    public static final class a implements Cancellable {
        public final /* synthetic */ RecommendationItemViewImpl$scrollStateUpdates$1 a;
        public final /* synthetic */ RecommendationItemViewImpl$scrollStateUpdates$1$listener$1 b;

        public a(RecommendationItemViewImpl$scrollStateUpdates$1 recommendationItemViewImpl$scrollStateUpdates$1, RecommendationItemViewImpl$scrollStateUpdates$1$listener$1 recommendationItemViewImpl$scrollStateUpdates$1$listener$1) {
            this.a = recommendationItemViewImpl$scrollStateUpdates$1;
            this.b = recommendationItemViewImpl$scrollStateUpdates$1$listener$1;
        }

        @Override // io.reactivex.rxjava3.functions.Cancellable
        public final void cancel() {
            this.a.a.t.removeOnScrollListener(this.b);
        }
    }

    public RecommendationItemViewImpl$scrollStateUpdates$1(RecommendationItemViewImpl recommendationItemViewImpl) {
        this.a = recommendationItemViewImpl;
    }

    @Override // io.reactivex.rxjava3.core.ObservableOnSubscribe
    public final void subscribe(ObservableEmitter<Parcelable> observableEmitter) {
        RecommendationItemViewImpl$scrollStateUpdates$1$listener$1 recommendationItemViewImpl$scrollStateUpdates$1$listener$1 = new RecommendationItemViewImpl$scrollStateUpdates$1$listener$1(observableEmitter);
        this.a.t.addOnScrollListener(recommendationItemViewImpl$scrollStateUpdates$1$listener$1);
        observableEmitter.setCancellable(new a(this, recommendationItemViewImpl$scrollStateUpdates$1$listener$1));
    }
}
