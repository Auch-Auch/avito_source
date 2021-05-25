package com.avito.android.tariff.fees_methods.recycler;

import android.content.res.Resources;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class PaddingDecoration_Factory implements Factory<PaddingDecoration> {
    public final Provider<Resources> a;
    public final Provider<FeeMethodsViewTypeProvider> b;

    public PaddingDecoration_Factory(Provider<Resources> provider, Provider<FeeMethodsViewTypeProvider> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static PaddingDecoration_Factory create(Provider<Resources> provider, Provider<FeeMethodsViewTypeProvider> provider2) {
        return new PaddingDecoration_Factory(provider, provider2);
    }

    public static PaddingDecoration newInstance(Resources resources, FeeMethodsViewTypeProvider feeMethodsViewTypeProvider) {
        return new PaddingDecoration(resources, feeMethodsViewTypeProvider);
    }

    @Override // javax.inject.Provider
    public PaddingDecoration get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
