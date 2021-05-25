package com.avito.android.advert_core.short_term_rent;

import android.content.res.Resources;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertStrBlockViewResourceProviderImpl_Factory implements Factory<AdvertStrBlockViewResourceProviderImpl> {
    public final Provider<Resources> a;

    public AdvertStrBlockViewResourceProviderImpl_Factory(Provider<Resources> provider) {
        this.a = provider;
    }

    public static AdvertStrBlockViewResourceProviderImpl_Factory create(Provider<Resources> provider) {
        return new AdvertStrBlockViewResourceProviderImpl_Factory(provider);
    }

    public static AdvertStrBlockViewResourceProviderImpl newInstance(Resources resources) {
        return new AdvertStrBlockViewResourceProviderImpl(resources);
    }

    @Override // javax.inject.Provider
    public AdvertStrBlockViewResourceProviderImpl get() {
        return newInstance(this.a.get());
    }
}
