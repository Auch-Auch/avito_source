package com.avito.android.advert.item.auto_catalog;

import com.avito.android.advert.AdvertDetailsResourcesProvider;
import com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertDetailsAutoCatalogPresenterImpl_Factory implements Factory<AdvertDetailsAutoCatalogPresenterImpl> {
    public final Provider<AdvertDetailsAnalyticsInteractor> a;
    public final Provider<AdvertDetailsResourcesProvider> b;

    public AdvertDetailsAutoCatalogPresenterImpl_Factory(Provider<AdvertDetailsAnalyticsInteractor> provider, Provider<AdvertDetailsResourcesProvider> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static AdvertDetailsAutoCatalogPresenterImpl_Factory create(Provider<AdvertDetailsAnalyticsInteractor> provider, Provider<AdvertDetailsResourcesProvider> provider2) {
        return new AdvertDetailsAutoCatalogPresenterImpl_Factory(provider, provider2);
    }

    public static AdvertDetailsAutoCatalogPresenterImpl newInstance(AdvertDetailsAnalyticsInteractor advertDetailsAnalyticsInteractor, AdvertDetailsResourcesProvider advertDetailsResourcesProvider) {
        return new AdvertDetailsAutoCatalogPresenterImpl(advertDetailsAnalyticsInteractor, advertDetailsResourcesProvider);
    }

    @Override // javax.inject.Provider
    public AdvertDetailsAutoCatalogPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
