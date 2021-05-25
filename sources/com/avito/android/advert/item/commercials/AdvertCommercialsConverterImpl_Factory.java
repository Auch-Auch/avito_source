package com.avito.android.advert.item.commercials;

import com.avito.android.serp.adapter.SerpCommercialBannerConverter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertCommercialsConverterImpl_Factory implements Factory<AdvertCommercialsConverterImpl> {
    public final Provider<SerpCommercialBannerConverter> a;

    public AdvertCommercialsConverterImpl_Factory(Provider<SerpCommercialBannerConverter> provider) {
        this.a = provider;
    }

    public static AdvertCommercialsConverterImpl_Factory create(Provider<SerpCommercialBannerConverter> provider) {
        return new AdvertCommercialsConverterImpl_Factory(provider);
    }

    public static AdvertCommercialsConverterImpl newInstance(SerpCommercialBannerConverter serpCommercialBannerConverter) {
        return new AdvertCommercialsConverterImpl(serpCommercialBannerConverter);
    }

    @Override // javax.inject.Provider
    public AdvertCommercialsConverterImpl get() {
        return newInstance(this.a.get());
    }
}
