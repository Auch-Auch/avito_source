package com.avito.android.auto_catalog.items.serp;

import com.avito.android.auto_catalog.AutoCatalogPresenter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SerpSecondaryButtonPresenterImpl_Factory implements Factory<SerpSecondaryButtonPresenterImpl> {
    public final Provider<AutoCatalogPresenter> a;

    public SerpSecondaryButtonPresenterImpl_Factory(Provider<AutoCatalogPresenter> provider) {
        this.a = provider;
    }

    public static SerpSecondaryButtonPresenterImpl_Factory create(Provider<AutoCatalogPresenter> provider) {
        return new SerpSecondaryButtonPresenterImpl_Factory(provider);
    }

    public static SerpSecondaryButtonPresenterImpl newInstance(AutoCatalogPresenter autoCatalogPresenter) {
        return new SerpSecondaryButtonPresenterImpl(autoCatalogPresenter);
    }

    @Override // javax.inject.Provider
    public SerpSecondaryButtonPresenterImpl get() {
        return newInstance(this.a.get());
    }
}
