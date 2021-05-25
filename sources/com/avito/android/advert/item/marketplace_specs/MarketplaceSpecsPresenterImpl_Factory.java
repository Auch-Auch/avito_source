package com.avito.android.advert.item.marketplace_specs;

import com.avito.android.advert.item.marketplace_specs.MarketplaceSpecsPresenter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class MarketplaceSpecsPresenterImpl_Factory implements Factory<MarketplaceSpecsPresenterImpl> {
    public final Provider<MarketplaceSpecsPresenter.Listener> a;

    public MarketplaceSpecsPresenterImpl_Factory(Provider<MarketplaceSpecsPresenter.Listener> provider) {
        this.a = provider;
    }

    public static MarketplaceSpecsPresenterImpl_Factory create(Provider<MarketplaceSpecsPresenter.Listener> provider) {
        return new MarketplaceSpecsPresenterImpl_Factory(provider);
    }

    public static MarketplaceSpecsPresenterImpl newInstance(MarketplaceSpecsPresenter.Listener listener) {
        return new MarketplaceSpecsPresenterImpl(listener);
    }

    @Override // javax.inject.Provider
    public MarketplaceSpecsPresenterImpl get() {
        return newInstance(this.a.get());
    }
}
