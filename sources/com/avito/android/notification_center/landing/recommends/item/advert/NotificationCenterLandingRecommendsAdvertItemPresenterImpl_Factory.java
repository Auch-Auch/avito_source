package com.avito.android.notification_center.landing.recommends.item.advert;

import com.avito.android.serp.adapter.FavorableItem;
import com.jakewharton.rxrelay2.Relay;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class NotificationCenterLandingRecommendsAdvertItemPresenterImpl_Factory implements Factory<NotificationCenterLandingRecommendsAdvertItemPresenterImpl> {
    public final Provider<Relay<Integer>> a;
    public final Provider<Relay<FavorableItem>> b;

    public NotificationCenterLandingRecommendsAdvertItemPresenterImpl_Factory(Provider<Relay<Integer>> provider, Provider<Relay<FavorableItem>> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static NotificationCenterLandingRecommendsAdvertItemPresenterImpl_Factory create(Provider<Relay<Integer>> provider, Provider<Relay<FavorableItem>> provider2) {
        return new NotificationCenterLandingRecommendsAdvertItemPresenterImpl_Factory(provider, provider2);
    }

    public static NotificationCenterLandingRecommendsAdvertItemPresenterImpl newInstance(Relay<Integer> relay, Relay<FavorableItem> relay2) {
        return new NotificationCenterLandingRecommendsAdvertItemPresenterImpl(relay, relay2);
    }

    @Override // javax.inject.Provider
    public NotificationCenterLandingRecommendsAdvertItemPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
