package com.avito.android.notification_center.landing.recommends.item.title;

import com.jakewharton.rxrelay2.Relay;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class NotificationCenterLandingRecommendsTitleItemPresenterImpl_Factory implements Factory<NotificationCenterLandingRecommendsTitleItemPresenterImpl> {
    public final Provider<Relay<Integer>> a;

    public NotificationCenterLandingRecommendsTitleItemPresenterImpl_Factory(Provider<Relay<Integer>> provider) {
        this.a = provider;
    }

    public static NotificationCenterLandingRecommendsTitleItemPresenterImpl_Factory create(Provider<Relay<Integer>> provider) {
        return new NotificationCenterLandingRecommendsTitleItemPresenterImpl_Factory(provider);
    }

    public static NotificationCenterLandingRecommendsTitleItemPresenterImpl newInstance(Relay<Integer> relay) {
        return new NotificationCenterLandingRecommendsTitleItemPresenterImpl(relay);
    }

    @Override // javax.inject.Provider
    public NotificationCenterLandingRecommendsTitleItemPresenterImpl get() {
        return newInstance(this.a.get());
    }
}
