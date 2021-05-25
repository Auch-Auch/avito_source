package com.avito.android.notification_center.landing.recommends.item.review;

import com.jakewharton.rxrelay2.Relay;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class NotificationCenterLandingRecommendsReviewItemPresenterImpl_Factory implements Factory<NotificationCenterLandingRecommendsReviewItemPresenterImpl> {
    public final Provider<Relay<Integer>> a;

    public NotificationCenterLandingRecommendsReviewItemPresenterImpl_Factory(Provider<Relay<Integer>> provider) {
        this.a = provider;
    }

    public static NotificationCenterLandingRecommendsReviewItemPresenterImpl_Factory create(Provider<Relay<Integer>> provider) {
        return new NotificationCenterLandingRecommendsReviewItemPresenterImpl_Factory(provider);
    }

    public static NotificationCenterLandingRecommendsReviewItemPresenterImpl newInstance(Relay<Integer> relay) {
        return new NotificationCenterLandingRecommendsReviewItemPresenterImpl(relay);
    }

    @Override // javax.inject.Provider
    public NotificationCenterLandingRecommendsReviewItemPresenterImpl get() {
        return newInstance(this.a.get());
    }
}
