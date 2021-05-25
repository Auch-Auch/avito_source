package com.avito.android.advert.closed;

import android.content.res.Resources;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ClosedAdvertResourcesProviderImpl_Factory implements Factory<ClosedAdvertResourcesProviderImpl> {
    public final Provider<Resources> a;

    public ClosedAdvertResourcesProviderImpl_Factory(Provider<Resources> provider) {
        this.a = provider;
    }

    public static ClosedAdvertResourcesProviderImpl_Factory create(Provider<Resources> provider) {
        return new ClosedAdvertResourcesProviderImpl_Factory(provider);
    }

    public static ClosedAdvertResourcesProviderImpl newInstance(Resources resources) {
        return new ClosedAdvertResourcesProviderImpl(resources);
    }

    @Override // javax.inject.Provider
    public ClosedAdvertResourcesProviderImpl get() {
        return newInstance(this.a.get());
    }
}
