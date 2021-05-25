package com.avito.android.advert.item.similars;

import android.content.res.Resources;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertSimilarPresenterResourceProviderImpl_Factory implements Factory<AdvertSimilarPresenterResourceProviderImpl> {
    public final Provider<Resources> a;

    public AdvertSimilarPresenterResourceProviderImpl_Factory(Provider<Resources> provider) {
        this.a = provider;
    }

    public static AdvertSimilarPresenterResourceProviderImpl_Factory create(Provider<Resources> provider) {
        return new AdvertSimilarPresenterResourceProviderImpl_Factory(provider);
    }

    public static AdvertSimilarPresenterResourceProviderImpl newInstance(Resources resources) {
        return new AdvertSimilarPresenterResourceProviderImpl(resources);
    }

    @Override // javax.inject.Provider
    public AdvertSimilarPresenterResourceProviderImpl get() {
        return newInstance(this.a.get());
    }
}
