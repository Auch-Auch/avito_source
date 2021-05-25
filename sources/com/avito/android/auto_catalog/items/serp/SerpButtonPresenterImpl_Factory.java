package com.avito.android.auto_catalog.items.serp;

import com.avito.android.auto_catalog.AutoCatalogPresenter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SerpButtonPresenterImpl_Factory implements Factory<SerpButtonPresenterImpl> {
    public final Provider<AutoCatalogPresenter> a;

    public SerpButtonPresenterImpl_Factory(Provider<AutoCatalogPresenter> provider) {
        this.a = provider;
    }

    public static SerpButtonPresenterImpl_Factory create(Provider<AutoCatalogPresenter> provider) {
        return new SerpButtonPresenterImpl_Factory(provider);
    }

    public static SerpButtonPresenterImpl newInstance(AutoCatalogPresenter autoCatalogPresenter) {
        return new SerpButtonPresenterImpl(autoCatalogPresenter);
    }

    @Override // javax.inject.Provider
    public SerpButtonPresenterImpl get() {
        return newInstance(this.a.get());
    }
}
