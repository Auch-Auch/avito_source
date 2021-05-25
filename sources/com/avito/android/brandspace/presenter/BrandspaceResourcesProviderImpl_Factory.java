package com.avito.android.brandspace.presenter;

import android.content.res.Resources;
import com.avito.android.remote.CallAdapterFactoryResourceProvider;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class BrandspaceResourcesProviderImpl_Factory implements Factory<BrandspaceResourcesProviderImpl> {
    public final Provider<Resources> a;
    public final Provider<CallAdapterFactoryResourceProvider> b;

    public BrandspaceResourcesProviderImpl_Factory(Provider<Resources> provider, Provider<CallAdapterFactoryResourceProvider> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static BrandspaceResourcesProviderImpl_Factory create(Provider<Resources> provider, Provider<CallAdapterFactoryResourceProvider> provider2) {
        return new BrandspaceResourcesProviderImpl_Factory(provider, provider2);
    }

    public static BrandspaceResourcesProviderImpl newInstance(Resources resources, CallAdapterFactoryResourceProvider callAdapterFactoryResourceProvider) {
        return new BrandspaceResourcesProviderImpl(resources, callAdapterFactoryResourceProvider);
    }

    @Override // javax.inject.Provider
    public BrandspaceResourcesProviderImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
