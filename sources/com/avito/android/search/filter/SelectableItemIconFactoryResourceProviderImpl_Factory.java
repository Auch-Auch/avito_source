package com.avito.android.search.filter;

import android.content.res.Resources;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SelectableItemIconFactoryResourceProviderImpl_Factory implements Factory<SelectableItemIconFactoryResourceProviderImpl> {
    public final Provider<Resources> a;

    public SelectableItemIconFactoryResourceProviderImpl_Factory(Provider<Resources> provider) {
        this.a = provider;
    }

    public static SelectableItemIconFactoryResourceProviderImpl_Factory create(Provider<Resources> provider) {
        return new SelectableItemIconFactoryResourceProviderImpl_Factory(provider);
    }

    public static SelectableItemIconFactoryResourceProviderImpl newInstance(Resources resources) {
        return new SelectableItemIconFactoryResourceProviderImpl(resources);
    }

    @Override // javax.inject.Provider
    public SelectableItemIconFactoryResourceProviderImpl get() {
        return newInstance(this.a.get());
    }
}
