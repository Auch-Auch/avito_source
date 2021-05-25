package com.avito.android.basket.checkout;

import android.content.res.Resources;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ResourceProviderImpl_Factory implements Factory<ResourceProviderImpl> {
    public final Provider<Resources> a;

    public ResourceProviderImpl_Factory(Provider<Resources> provider) {
        this.a = provider;
    }

    public static ResourceProviderImpl_Factory create(Provider<Resources> provider) {
        return new ResourceProviderImpl_Factory(provider);
    }

    public static ResourceProviderImpl newInstance(Resources resources) {
        return new ResourceProviderImpl(resources);
    }

    @Override // javax.inject.Provider
    public ResourceProviderImpl get() {
        return newInstance(this.a.get());
    }
}
