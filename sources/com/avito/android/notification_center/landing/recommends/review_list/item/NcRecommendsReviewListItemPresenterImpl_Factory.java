package com.avito.android.notification_center.landing.recommends.review_list.item;

import com.jakewharton.rxrelay2.Relay;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class NcRecommendsReviewListItemPresenterImpl_Factory implements Factory<NcRecommendsReviewListItemPresenterImpl> {
    public final Provider<Relay<Integer>> a;

    public NcRecommendsReviewListItemPresenterImpl_Factory(Provider<Relay<Integer>> provider) {
        this.a = provider;
    }

    public static NcRecommendsReviewListItemPresenterImpl_Factory create(Provider<Relay<Integer>> provider) {
        return new NcRecommendsReviewListItemPresenterImpl_Factory(provider);
    }

    public static NcRecommendsReviewListItemPresenterImpl newInstance(Relay<Integer> relay) {
        return new NcRecommendsReviewListItemPresenterImpl(relay);
    }

    @Override // javax.inject.Provider
    public NcRecommendsReviewListItemPresenterImpl get() {
        return newInstance(this.a.get());
    }
}
