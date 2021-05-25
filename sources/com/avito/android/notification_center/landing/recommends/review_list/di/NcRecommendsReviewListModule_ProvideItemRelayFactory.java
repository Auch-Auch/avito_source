package com.avito.android.notification_center.landing.recommends.review_list.di;

import com.jakewharton.rxrelay2.Relay;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class NcRecommendsReviewListModule_ProvideItemRelayFactory implements Factory<Relay<Integer>> {

    public static final class a {
        public static final NcRecommendsReviewListModule_ProvideItemRelayFactory a = new NcRecommendsReviewListModule_ProvideItemRelayFactory();
    }

    public static NcRecommendsReviewListModule_ProvideItemRelayFactory create() {
        return a.a;
    }

    public static Relay<Integer> provideItemRelay() {
        return (Relay) Preconditions.checkNotNullFromProvides(NcRecommendsReviewListModule.provideItemRelay());
    }

    @Override // javax.inject.Provider
    public Relay<Integer> get() {
        return provideItemRelay();
    }
}
