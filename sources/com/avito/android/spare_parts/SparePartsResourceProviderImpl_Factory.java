package com.avito.android.spare_parts;

import android.content.res.Resources;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SparePartsResourceProviderImpl_Factory implements Factory<SparePartsResourceProviderImpl> {
    public final Provider<Resources> a;

    public SparePartsResourceProviderImpl_Factory(Provider<Resources> provider) {
        this.a = provider;
    }

    public static SparePartsResourceProviderImpl_Factory create(Provider<Resources> provider) {
        return new SparePartsResourceProviderImpl_Factory(provider);
    }

    public static SparePartsResourceProviderImpl newInstance(Resources resources) {
        return new SparePartsResourceProviderImpl(resources);
    }

    @Override // javax.inject.Provider
    public SparePartsResourceProviderImpl get() {
        return newInstance(this.a.get());
    }
}
