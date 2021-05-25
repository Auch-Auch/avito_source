package com.avito.android.developments_catalog.items.avitoOffers;

import com.avito.android.developments_catalog.DevelopmentsCatalogPresenter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AvitoOffersPresenterImpl_Factory implements Factory<AvitoOffersPresenterImpl> {
    public final Provider<DevelopmentsCatalogPresenter> a;

    public AvitoOffersPresenterImpl_Factory(Provider<DevelopmentsCatalogPresenter> provider) {
        this.a = provider;
    }

    public static AvitoOffersPresenterImpl_Factory create(Provider<DevelopmentsCatalogPresenter> provider) {
        return new AvitoOffersPresenterImpl_Factory(provider);
    }

    public static AvitoOffersPresenterImpl newInstance(DevelopmentsCatalogPresenter developmentsCatalogPresenter) {
        return new AvitoOffersPresenterImpl(developmentsCatalogPresenter);
    }

    @Override // javax.inject.Provider
    public AvitoOffersPresenterImpl get() {
        return newInstance(this.a.get());
    }
}
