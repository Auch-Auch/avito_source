package com.avito.android.auto_catalog;

import com.avito.android.auto_catalog.analytics.AutoCatalogAnalyticsInteractor;
import com.avito.android.auto_catalog.items.AutoCatalogResourceProvider;
import com.avito.android.favorite.FavoriteAdvertsPresenter;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AutoCatalogPresenterImpl_Factory implements Factory<AutoCatalogPresenterImpl> {
    public final Provider<AutoCatalogInteractor> a;
    public final Provider<AutoCatalogAnalyticsInteractor> b;
    public final Provider<FavoriteAdvertsPresenter> c;
    public final Provider<SchedulersFactory> d;
    public final Provider<AutoCatalogResourceProvider> e;

    public AutoCatalogPresenterImpl_Factory(Provider<AutoCatalogInteractor> provider, Provider<AutoCatalogAnalyticsInteractor> provider2, Provider<FavoriteAdvertsPresenter> provider3, Provider<SchedulersFactory> provider4, Provider<AutoCatalogResourceProvider> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static AutoCatalogPresenterImpl_Factory create(Provider<AutoCatalogInteractor> provider, Provider<AutoCatalogAnalyticsInteractor> provider2, Provider<FavoriteAdvertsPresenter> provider3, Provider<SchedulersFactory> provider4, Provider<AutoCatalogResourceProvider> provider5) {
        return new AutoCatalogPresenterImpl_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static AutoCatalogPresenterImpl newInstance(AutoCatalogInteractor autoCatalogInteractor, AutoCatalogAnalyticsInteractor autoCatalogAnalyticsInteractor, FavoriteAdvertsPresenter favoriteAdvertsPresenter, SchedulersFactory schedulersFactory, AutoCatalogResourceProvider autoCatalogResourceProvider) {
        return new AutoCatalogPresenterImpl(autoCatalogInteractor, autoCatalogAnalyticsInteractor, favoriteAdvertsPresenter, schedulersFactory, autoCatalogResourceProvider);
    }

    @Override // javax.inject.Provider
    public AutoCatalogPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
