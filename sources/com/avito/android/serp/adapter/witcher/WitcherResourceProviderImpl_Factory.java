package com.avito.android.serp.adapter.witcher;

import android.content.res.Resources;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class WitcherResourceProviderImpl_Factory implements Factory<WitcherResourceProviderImpl> {
    public final Provider<Resources> a;

    public WitcherResourceProviderImpl_Factory(Provider<Resources> provider) {
        this.a = provider;
    }

    public static WitcherResourceProviderImpl_Factory create(Provider<Resources> provider) {
        return new WitcherResourceProviderImpl_Factory(provider);
    }

    public static WitcherResourceProviderImpl newInstance(Resources resources) {
        return new WitcherResourceProviderImpl(resources);
    }

    @Override // javax.inject.Provider
    public WitcherResourceProviderImpl get() {
        return newInstance(this.a.get());
    }
}
