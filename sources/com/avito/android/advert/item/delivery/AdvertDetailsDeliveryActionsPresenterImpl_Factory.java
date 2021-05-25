package com.avito.android.advert.item.delivery;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertDetailsDeliveryActionsPresenterImpl_Factory implements Factory<AdvertDetailsDeliveryActionsPresenterImpl> {
    public final Provider<AdvertDeliveryPresenter> a;

    public AdvertDetailsDeliveryActionsPresenterImpl_Factory(Provider<AdvertDeliveryPresenter> provider) {
        this.a = provider;
    }

    public static AdvertDetailsDeliveryActionsPresenterImpl_Factory create(Provider<AdvertDeliveryPresenter> provider) {
        return new AdvertDetailsDeliveryActionsPresenterImpl_Factory(provider);
    }

    public static AdvertDetailsDeliveryActionsPresenterImpl newInstance(AdvertDeliveryPresenter advertDeliveryPresenter) {
        return new AdvertDetailsDeliveryActionsPresenterImpl(advertDeliveryPresenter);
    }

    @Override // javax.inject.Provider
    public AdvertDetailsDeliveryActionsPresenterImpl get() {
        return newInstance(this.a.get());
    }
}
