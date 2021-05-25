package com.avito.android.advert_core.advert_badge_bar;

import com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertBadgeBarPresenterImpl_Factory implements Factory<AdvertBadgeBarPresenterImpl> {
    public final Provider<AdvertDetailsAnalyticsInteractor> a;

    public AdvertBadgeBarPresenterImpl_Factory(Provider<AdvertDetailsAnalyticsInteractor> provider) {
        this.a = provider;
    }

    public static AdvertBadgeBarPresenterImpl_Factory create(Provider<AdvertDetailsAnalyticsInteractor> provider) {
        return new AdvertBadgeBarPresenterImpl_Factory(provider);
    }

    public static AdvertBadgeBarPresenterImpl newInstance(AdvertDetailsAnalyticsInteractor advertDetailsAnalyticsInteractor) {
        return new AdvertBadgeBarPresenterImpl(advertDetailsAnalyticsInteractor);
    }

    @Override // javax.inject.Provider
    public AdvertBadgeBarPresenterImpl get() {
        return newInstance(this.a.get());
    }
}
