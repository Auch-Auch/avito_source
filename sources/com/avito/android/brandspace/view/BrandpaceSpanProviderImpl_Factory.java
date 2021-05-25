package com.avito.android.brandspace.view;

import com.avito.android.brandspace.presenter.BrandspaceResourcesProvider;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class BrandpaceSpanProviderImpl_Factory implements Factory<BrandpaceSpanProviderImpl> {
    public final Provider<BrandspaceResourcesProvider> a;

    public BrandpaceSpanProviderImpl_Factory(Provider<BrandspaceResourcesProvider> provider) {
        this.a = provider;
    }

    public static BrandpaceSpanProviderImpl_Factory create(Provider<BrandspaceResourcesProvider> provider) {
        return new BrandpaceSpanProviderImpl_Factory(provider);
    }

    public static BrandpaceSpanProviderImpl newInstance(BrandspaceResourcesProvider brandspaceResourcesProvider) {
        return new BrandpaceSpanProviderImpl(brandspaceResourcesProvider);
    }

    @Override // javax.inject.Provider
    public BrandpaceSpanProviderImpl get() {
        return newInstance(this.a.get());
    }
}
