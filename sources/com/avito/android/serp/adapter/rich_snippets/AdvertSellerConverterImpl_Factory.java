package com.avito.android.serp.adapter.rich_snippets;

import com.avito.android.Features;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertSellerConverterImpl_Factory implements Factory<AdvertSellerConverterImpl> {
    public final Provider<Features> a;

    public AdvertSellerConverterImpl_Factory(Provider<Features> provider) {
        this.a = provider;
    }

    public static AdvertSellerConverterImpl_Factory create(Provider<Features> provider) {
        return new AdvertSellerConverterImpl_Factory(provider);
    }

    public static AdvertSellerConverterImpl newInstance(Features features) {
        return new AdvertSellerConverterImpl(features);
    }

    @Override // javax.inject.Provider
    public AdvertSellerConverterImpl get() {
        return newInstance(this.a.get());
    }
}
