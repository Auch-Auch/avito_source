package com.avito.android.brandspace.items.marketplace.snippet;

import com.avito.android.brandspace.interactor.BrandspaceAnalyticsInteractor;
import com.avito.android.brandspace.presenter.BrandspacePresenter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class MarketplaceSnippetPresenterImpl_Factory implements Factory<MarketplaceSnippetPresenterImpl> {
    public final Provider<BrandspacePresenter> a;
    public final Provider<BrandspaceAnalyticsInteractor> b;

    public MarketplaceSnippetPresenterImpl_Factory(Provider<BrandspacePresenter> provider, Provider<BrandspaceAnalyticsInteractor> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static MarketplaceSnippetPresenterImpl_Factory create(Provider<BrandspacePresenter> provider, Provider<BrandspaceAnalyticsInteractor> provider2) {
        return new MarketplaceSnippetPresenterImpl_Factory(provider, provider2);
    }

    public static MarketplaceSnippetPresenterImpl newInstance(BrandspacePresenter brandspacePresenter, BrandspaceAnalyticsInteractor brandspaceAnalyticsInteractor) {
        return new MarketplaceSnippetPresenterImpl(brandspacePresenter, brandspaceAnalyticsInteractor);
    }

    @Override // javax.inject.Provider
    public MarketplaceSnippetPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
