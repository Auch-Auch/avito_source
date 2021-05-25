package com.avito.android.advert.item.delivery;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertDetailsDeliveryActionsBlueprint_Factory implements Factory<AdvertDetailsDeliveryActionsBlueprint> {
    public final Provider<AdvertDetailsDeliveryActionsPresenter> a;

    public AdvertDetailsDeliveryActionsBlueprint_Factory(Provider<AdvertDetailsDeliveryActionsPresenter> provider) {
        this.a = provider;
    }

    public static AdvertDetailsDeliveryActionsBlueprint_Factory create(Provider<AdvertDetailsDeliveryActionsPresenter> provider) {
        return new AdvertDetailsDeliveryActionsBlueprint_Factory(provider);
    }

    public static AdvertDetailsDeliveryActionsBlueprint newInstance(AdvertDetailsDeliveryActionsPresenter advertDetailsDeliveryActionsPresenter) {
        return new AdvertDetailsDeliveryActionsBlueprint(advertDetailsDeliveryActionsPresenter);
    }

    @Override // javax.inject.Provider
    public AdvertDetailsDeliveryActionsBlueprint get() {
        return newInstance(this.a.get());
    }
}
