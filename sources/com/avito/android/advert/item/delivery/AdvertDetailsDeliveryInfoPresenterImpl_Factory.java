package com.avito.android.advert.item.delivery;

import com.avito.android.advert_core.delivery.AdvertDeliveryBlockViewModel;
import com.avito.android.remote.model.AdvertDeliveryC2C;
import com.jakewharton.rxrelay3.PublishRelay;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertDetailsDeliveryInfoPresenterImpl_Factory implements Factory<AdvertDetailsDeliveryInfoPresenterImpl> {
    public final Provider<AdvertDeliveryBlockViewModel> a;
    public final Provider<PublishRelay<AdvertDeliveryC2C>> b;

    public AdvertDetailsDeliveryInfoPresenterImpl_Factory(Provider<AdvertDeliveryBlockViewModel> provider, Provider<PublishRelay<AdvertDeliveryC2C>> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static AdvertDetailsDeliveryInfoPresenterImpl_Factory create(Provider<AdvertDeliveryBlockViewModel> provider, Provider<PublishRelay<AdvertDeliveryC2C>> provider2) {
        return new AdvertDetailsDeliveryInfoPresenterImpl_Factory(provider, provider2);
    }

    public static AdvertDetailsDeliveryInfoPresenterImpl newInstance(AdvertDeliveryBlockViewModel advertDeliveryBlockViewModel, PublishRelay<AdvertDeliveryC2C> publishRelay) {
        return new AdvertDetailsDeliveryInfoPresenterImpl(advertDeliveryBlockViewModel, publishRelay);
    }

    @Override // javax.inject.Provider
    public AdvertDetailsDeliveryInfoPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
