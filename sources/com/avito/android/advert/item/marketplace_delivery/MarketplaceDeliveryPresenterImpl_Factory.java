package com.avito.android.advert.item.marketplace_delivery;

import com.avito.android.advert.item.marketplace_delivery.MarketplaceDeliveryPresenter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class MarketplaceDeliveryPresenterImpl_Factory implements Factory<MarketplaceDeliveryPresenterImpl> {
    public final Provider<MarketplaceDeliveryPresenter.Listener> a;
    public final Provider<MarketplaceDeliveryStorage> b;

    public MarketplaceDeliveryPresenterImpl_Factory(Provider<MarketplaceDeliveryPresenter.Listener> provider, Provider<MarketplaceDeliveryStorage> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static MarketplaceDeliveryPresenterImpl_Factory create(Provider<MarketplaceDeliveryPresenter.Listener> provider, Provider<MarketplaceDeliveryStorage> provider2) {
        return new MarketplaceDeliveryPresenterImpl_Factory(provider, provider2);
    }

    public static MarketplaceDeliveryPresenterImpl newInstance(MarketplaceDeliveryPresenter.Listener listener, MarketplaceDeliveryStorage marketplaceDeliveryStorage) {
        return new MarketplaceDeliveryPresenterImpl(listener, marketplaceDeliveryStorage);
    }

    @Override // javax.inject.Provider
    public MarketplaceDeliveryPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
