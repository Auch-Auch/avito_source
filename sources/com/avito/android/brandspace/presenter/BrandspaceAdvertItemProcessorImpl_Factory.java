package com.avito.android.brandspace.presenter;

import com.avito.android.IdProvider;
import com.avito.android.serp.adapter.SerpAdvertConverter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class BrandspaceAdvertItemProcessorImpl_Factory implements Factory<BrandspaceAdvertItemProcessorImpl> {
    public final Provider<IdProvider> a;
    public final Provider<SerpAdvertConverter> b;

    public BrandspaceAdvertItemProcessorImpl_Factory(Provider<IdProvider> provider, Provider<SerpAdvertConverter> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static BrandspaceAdvertItemProcessorImpl_Factory create(Provider<IdProvider> provider, Provider<SerpAdvertConverter> provider2) {
        return new BrandspaceAdvertItemProcessorImpl_Factory(provider, provider2);
    }

    public static BrandspaceAdvertItemProcessorImpl newInstance(IdProvider idProvider, SerpAdvertConverter serpAdvertConverter) {
        return new BrandspaceAdvertItemProcessorImpl(idProvider, serpAdvertConverter);
    }

    @Override // javax.inject.Provider
    public BrandspaceAdvertItemProcessorImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
