package com.avito.android.auto_catalog.items;

import android.content.res.Resources;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AutoCatalogResourceProviderImpl_Factory implements Factory<AutoCatalogResourceProviderImpl> {
    public final Provider<Resources> a;

    public AutoCatalogResourceProviderImpl_Factory(Provider<Resources> provider) {
        this.a = provider;
    }

    public static AutoCatalogResourceProviderImpl_Factory create(Provider<Resources> provider) {
        return new AutoCatalogResourceProviderImpl_Factory(provider);
    }

    public static AutoCatalogResourceProviderImpl newInstance(Resources resources) {
        return new AutoCatalogResourceProviderImpl(resources);
    }

    @Override // javax.inject.Provider
    public AutoCatalogResourceProviderImpl get() {
        return newInstance(this.a.get());
    }
}
