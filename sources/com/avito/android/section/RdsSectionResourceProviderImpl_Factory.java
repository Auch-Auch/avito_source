package com.avito.android.section;

import android.content.res.Resources;
import com.avito.android.serp.adapter.LayoutTypeProvider;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class RdsSectionResourceProviderImpl_Factory implements Factory<RdsSectionResourceProviderImpl> {
    public final Provider<Resources> a;
    public final Provider<LayoutTypeProvider> b;

    public RdsSectionResourceProviderImpl_Factory(Provider<Resources> provider, Provider<LayoutTypeProvider> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static RdsSectionResourceProviderImpl_Factory create(Provider<Resources> provider, Provider<LayoutTypeProvider> provider2) {
        return new RdsSectionResourceProviderImpl_Factory(provider, provider2);
    }

    public static RdsSectionResourceProviderImpl newInstance(Resources resources, LayoutTypeProvider layoutTypeProvider) {
        return new RdsSectionResourceProviderImpl(resources, layoutTypeProvider);
    }

    @Override // javax.inject.Provider
    public RdsSectionResourceProviderImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
