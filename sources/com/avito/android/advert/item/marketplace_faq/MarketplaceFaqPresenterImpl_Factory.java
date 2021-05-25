package com.avito.android.advert.item.marketplace_faq;

import com.avito.android.advert.item.marketplace_faq.MarketplaceFaqPresenter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class MarketplaceFaqPresenterImpl_Factory implements Factory<MarketplaceFaqPresenterImpl> {
    public final Provider<MarketplaceFaqPresenter.Listener> a;

    public MarketplaceFaqPresenterImpl_Factory(Provider<MarketplaceFaqPresenter.Listener> provider) {
        this.a = provider;
    }

    public static MarketplaceFaqPresenterImpl_Factory create(Provider<MarketplaceFaqPresenter.Listener> provider) {
        return new MarketplaceFaqPresenterImpl_Factory(provider);
    }

    public static MarketplaceFaqPresenterImpl newInstance(MarketplaceFaqPresenter.Listener listener) {
        return new MarketplaceFaqPresenterImpl(listener);
    }

    @Override // javax.inject.Provider
    public MarketplaceFaqPresenterImpl get() {
        return newInstance(this.a.get());
    }
}
