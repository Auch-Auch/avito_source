package com.avito.android.search.filter;

import android.content.res.Resources;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class FiltersResourceProviderImpl_Factory implements Factory<FiltersResourceProviderImpl> {
    public final Provider<Resources> a;

    public FiltersResourceProviderImpl_Factory(Provider<Resources> provider) {
        this.a = provider;
    }

    public static FiltersResourceProviderImpl_Factory create(Provider<Resources> provider) {
        return new FiltersResourceProviderImpl_Factory(provider);
    }

    public static FiltersResourceProviderImpl newInstance(Resources resources) {
        return new FiltersResourceProviderImpl(resources);
    }

    @Override // javax.inject.Provider
    public FiltersResourceProviderImpl get() {
        return newInstance(this.a.get());
    }
}
