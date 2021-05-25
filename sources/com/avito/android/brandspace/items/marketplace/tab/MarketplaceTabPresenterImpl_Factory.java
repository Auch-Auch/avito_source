package com.avito.android.brandspace.items.marketplace.tab;

import com.avito.android.brandspace.presenter.BrandspacePresenter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class MarketplaceTabPresenterImpl_Factory implements Factory<MarketplaceTabPresenterImpl> {
    public final Provider<BrandspacePresenter> a;

    public MarketplaceTabPresenterImpl_Factory(Provider<BrandspacePresenter> provider) {
        this.a = provider;
    }

    public static MarketplaceTabPresenterImpl_Factory create(Provider<BrandspacePresenter> provider) {
        return new MarketplaceTabPresenterImpl_Factory(provider);
    }

    public static MarketplaceTabPresenterImpl newInstance(BrandspacePresenter brandspacePresenter) {
        return new MarketplaceTabPresenterImpl(brandspacePresenter);
    }

    @Override // javax.inject.Provider
    public MarketplaceTabPresenterImpl get() {
        return newInstance(this.a.get());
    }
}
