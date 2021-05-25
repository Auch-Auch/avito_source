package com.avito.android.advert_core.marketplace;

import android.content.res.Resources;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class MarketplaceResourceProviderImpl_Factory implements Factory<MarketplaceResourceProviderImpl> {
    public final Provider<Resources> a;

    public MarketplaceResourceProviderImpl_Factory(Provider<Resources> provider) {
        this.a = provider;
    }

    public static MarketplaceResourceProviderImpl_Factory create(Provider<Resources> provider) {
        return new MarketplaceResourceProviderImpl_Factory(provider);
    }

    public static MarketplaceResourceProviderImpl newInstance(Resources resources) {
        return new MarketplaceResourceProviderImpl(resources);
    }

    @Override // javax.inject.Provider
    public MarketplaceResourceProviderImpl get() {
        return newInstance(this.a.get());
    }
}
