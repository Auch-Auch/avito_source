package com.avito.android.user_advert.soa_with_price;

import android.content.res.Resources;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SoaWithPriceResourceProviderImpl_Factory implements Factory<SoaWithPriceResourceProviderImpl> {
    public final Provider<Resources> a;

    public SoaWithPriceResourceProviderImpl_Factory(Provider<Resources> provider) {
        this.a = provider;
    }

    public static SoaWithPriceResourceProviderImpl_Factory create(Provider<Resources> provider) {
        return new SoaWithPriceResourceProviderImpl_Factory(provider);
    }

    public static SoaWithPriceResourceProviderImpl newInstance(Resources resources) {
        return new SoaWithPriceResourceProviderImpl(resources);
    }

    @Override // javax.inject.Provider
    public SoaWithPriceResourceProviderImpl get() {
        return newInstance(this.a.get());
    }
}
