package com.avito.android.advert.item.marketplace_info;

import com.avito.android.advert.item.marketplace_info.MarketplaceInfoPresenter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class MarketplaceInfoPresenterImpl_Factory implements Factory<MarketplaceInfoPresenterImpl> {
    public final Provider<MarketplaceInfoPresenter.Listener> a;

    public MarketplaceInfoPresenterImpl_Factory(Provider<MarketplaceInfoPresenter.Listener> provider) {
        this.a = provider;
    }

    public static MarketplaceInfoPresenterImpl_Factory create(Provider<MarketplaceInfoPresenter.Listener> provider) {
        return new MarketplaceInfoPresenterImpl_Factory(provider);
    }

    public static MarketplaceInfoPresenterImpl newInstance(MarketplaceInfoPresenter.Listener listener) {
        return new MarketplaceInfoPresenterImpl(listener);
    }

    @Override // javax.inject.Provider
    public MarketplaceInfoPresenterImpl get() {
        return newInstance(this.a.get());
    }
}
