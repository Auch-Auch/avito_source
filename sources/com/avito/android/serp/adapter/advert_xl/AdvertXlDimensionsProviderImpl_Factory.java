package com.avito.android.serp.adapter.advert_xl;

import android.content.res.Resources;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertXlDimensionsProviderImpl_Factory implements Factory<AdvertXlDimensionsProviderImpl> {
    public final Provider<Resources> a;

    public AdvertXlDimensionsProviderImpl_Factory(Provider<Resources> provider) {
        this.a = provider;
    }

    public static AdvertXlDimensionsProviderImpl_Factory create(Provider<Resources> provider) {
        return new AdvertXlDimensionsProviderImpl_Factory(provider);
    }

    public static AdvertXlDimensionsProviderImpl newInstance(Resources resources) {
        return new AdvertXlDimensionsProviderImpl(resources);
    }

    @Override // javax.inject.Provider
    public AdvertXlDimensionsProviderImpl get() {
        return newInstance(this.a.get());
    }
}
