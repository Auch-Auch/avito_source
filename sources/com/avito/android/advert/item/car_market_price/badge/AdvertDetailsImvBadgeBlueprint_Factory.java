package com.avito.android.advert.item.car_market_price.badge;

import com.avito.android.advert_core.car_market_price.badge.AdvertDetailsImvBadgePresenter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertDetailsImvBadgeBlueprint_Factory implements Factory<AdvertDetailsImvBadgeBlueprint> {
    public final Provider<AdvertDetailsImvBadgePresenter> a;

    public AdvertDetailsImvBadgeBlueprint_Factory(Provider<AdvertDetailsImvBadgePresenter> provider) {
        this.a = provider;
    }

    public static AdvertDetailsImvBadgeBlueprint_Factory create(Provider<AdvertDetailsImvBadgePresenter> provider) {
        return new AdvertDetailsImvBadgeBlueprint_Factory(provider);
    }

    public static AdvertDetailsImvBadgeBlueprint newInstance(AdvertDetailsImvBadgePresenter advertDetailsImvBadgePresenter) {
        return new AdvertDetailsImvBadgeBlueprint(advertDetailsImvBadgePresenter);
    }

    @Override // javax.inject.Provider
    public AdvertDetailsImvBadgeBlueprint get() {
        return newInstance(this.a.get());
    }
}
