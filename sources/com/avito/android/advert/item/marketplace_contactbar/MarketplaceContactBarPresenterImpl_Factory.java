package com.avito.android.advert.item.marketplace_contactbar;

import com.avito.android.advert.item.marketplace_contactbar.MarketplaceContactBarPresenter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class MarketplaceContactBarPresenterImpl_Factory implements Factory<MarketplaceContactBarPresenterImpl> {
    public final Provider<MarketplaceContactBarPresenter.Listener> a;

    public MarketplaceContactBarPresenterImpl_Factory(Provider<MarketplaceContactBarPresenter.Listener> provider) {
        this.a = provider;
    }

    public static MarketplaceContactBarPresenterImpl_Factory create(Provider<MarketplaceContactBarPresenter.Listener> provider) {
        return new MarketplaceContactBarPresenterImpl_Factory(provider);
    }

    public static MarketplaceContactBarPresenterImpl newInstance(MarketplaceContactBarPresenter.Listener listener) {
        return new MarketplaceContactBarPresenterImpl(listener);
    }

    @Override // javax.inject.Provider
    public MarketplaceContactBarPresenterImpl get() {
        return newInstance(this.a.get());
    }
}
