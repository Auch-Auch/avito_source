package com.avito.android.advert.item.delivery;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertDetailsDeliveryInfoBlueprint_Factory implements Factory<AdvertDetailsDeliveryInfoBlueprint> {
    public final Provider<AdvertDetailsDeliveryInfoPresenter> a;

    public AdvertDetailsDeliveryInfoBlueprint_Factory(Provider<AdvertDetailsDeliveryInfoPresenter> provider) {
        this.a = provider;
    }

    public static AdvertDetailsDeliveryInfoBlueprint_Factory create(Provider<AdvertDetailsDeliveryInfoPresenter> provider) {
        return new AdvertDetailsDeliveryInfoBlueprint_Factory(provider);
    }

    public static AdvertDetailsDeliveryInfoBlueprint newInstance(AdvertDetailsDeliveryInfoPresenter advertDetailsDeliveryInfoPresenter) {
        return new AdvertDetailsDeliveryInfoBlueprint(advertDetailsDeliveryInfoPresenter);
    }

    @Override // javax.inject.Provider
    public AdvertDetailsDeliveryInfoBlueprint get() {
        return newInstance(this.a.get());
    }
}
