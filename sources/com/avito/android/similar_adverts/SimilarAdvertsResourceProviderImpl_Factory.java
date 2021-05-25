package com.avito.android.similar_adverts;

import android.content.res.Resources;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SimilarAdvertsResourceProviderImpl_Factory implements Factory<SimilarAdvertsResourceProviderImpl> {
    public final Provider<Resources> a;

    public SimilarAdvertsResourceProviderImpl_Factory(Provider<Resources> provider) {
        this.a = provider;
    }

    public static SimilarAdvertsResourceProviderImpl_Factory create(Provider<Resources> provider) {
        return new SimilarAdvertsResourceProviderImpl_Factory(provider);
    }

    public static SimilarAdvertsResourceProviderImpl newInstance(Resources resources) {
        return new SimilarAdvertsResourceProviderImpl(resources);
    }

    @Override // javax.inject.Provider
    public SimilarAdvertsResourceProviderImpl get() {
        return newInstance(this.a.get());
    }
}
