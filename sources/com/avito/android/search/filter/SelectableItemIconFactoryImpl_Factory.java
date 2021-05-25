package com.avito.android.search.filter;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class SelectableItemIconFactoryImpl_Factory implements Factory<SelectableItemIconFactoryImpl> {
    public final Provider<SelectableItemIconFactoryResourceProvider> a;

    public SelectableItemIconFactoryImpl_Factory(Provider<SelectableItemIconFactoryResourceProvider> provider) {
        this.a = provider;
    }

    public static SelectableItemIconFactoryImpl_Factory create(Provider<SelectableItemIconFactoryResourceProvider> provider) {
        return new SelectableItemIconFactoryImpl_Factory(provider);
    }

    public static SelectableItemIconFactoryImpl newInstance(SelectableItemIconFactoryResourceProvider selectableItemIconFactoryResourceProvider) {
        return new SelectableItemIconFactoryImpl(selectableItemIconFactoryResourceProvider);
    }

    @Override // javax.inject.Provider
    public SelectableItemIconFactoryImpl get() {
        return newInstance(this.a.get());
    }
}
