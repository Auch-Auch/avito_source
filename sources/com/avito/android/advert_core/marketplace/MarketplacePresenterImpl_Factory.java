package com.avito.android.advert_core.marketplace;

import com.avito.android.advert_core.advert.CartInteractor;
import com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor;
import com.avito.android.advert_core.contactbar.AdvertContactsPresenter;
import com.avito.android.cart_fab.CartFabViewModel;
import com.avito.android.util.SchedulersFactory3;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class MarketplacePresenterImpl_Factory implements Factory<MarketplacePresenterImpl> {
    public final Provider<AdvertContactsPresenter> a;
    public final Provider<CartInteractor> b;
    public final Provider<SchedulersFactory3> c;
    public final Provider<MarketplaceResourceProvider> d;
    public final Provider<CartFabViewModel> e;
    public final Provider<AdvertDetailsAnalyticsInteractor> f;

    public MarketplacePresenterImpl_Factory(Provider<AdvertContactsPresenter> provider, Provider<CartInteractor> provider2, Provider<SchedulersFactory3> provider3, Provider<MarketplaceResourceProvider> provider4, Provider<CartFabViewModel> provider5, Provider<AdvertDetailsAnalyticsInteractor> provider6) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
    }

    public static MarketplacePresenterImpl_Factory create(Provider<AdvertContactsPresenter> provider, Provider<CartInteractor> provider2, Provider<SchedulersFactory3> provider3, Provider<MarketplaceResourceProvider> provider4, Provider<CartFabViewModel> provider5, Provider<AdvertDetailsAnalyticsInteractor> provider6) {
        return new MarketplacePresenterImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static MarketplacePresenterImpl newInstance(Lazy<AdvertContactsPresenter> lazy, CartInteractor cartInteractor, SchedulersFactory3 schedulersFactory3, MarketplaceResourceProvider marketplaceResourceProvider, CartFabViewModel cartFabViewModel, AdvertDetailsAnalyticsInteractor advertDetailsAnalyticsInteractor) {
        return new MarketplacePresenterImpl(lazy, cartInteractor, schedulersFactory3, marketplaceResourceProvider, cartFabViewModel, advertDetailsAnalyticsInteractor);
    }

    @Override // javax.inject.Provider
    public MarketplacePresenterImpl get() {
        return newInstance(DoubleCheck.lazy(this.a), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get());
    }
}
