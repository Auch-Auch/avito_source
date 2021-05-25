package com.avito.android.advert_core.car_market_price.badge;

import com.avito.android.analytics.Analytics;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertDetailsImvBadgePresenterImpl_Factory implements Factory<AdvertDetailsImvBadgePresenterImpl> {
    public final Provider<String> a;
    public final Provider<Analytics> b;

    public AdvertDetailsImvBadgePresenterImpl_Factory(Provider<String> provider, Provider<Analytics> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static AdvertDetailsImvBadgePresenterImpl_Factory create(Provider<String> provider, Provider<Analytics> provider2) {
        return new AdvertDetailsImvBadgePresenterImpl_Factory(provider, provider2);
    }

    public static AdvertDetailsImvBadgePresenterImpl newInstance(String str, Analytics analytics) {
        return new AdvertDetailsImvBadgePresenterImpl(str, analytics);
    }

    @Override // javax.inject.Provider
    public AdvertDetailsImvBadgePresenterImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
