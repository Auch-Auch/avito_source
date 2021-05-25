package com.avito.android.item_map.view;

import android.content.res.Resources;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ItemMapResourcesProviderImpl_Factory implements Factory<ItemMapResourcesProviderImpl> {
    public final Provider<Resources> a;

    public ItemMapResourcesProviderImpl_Factory(Provider<Resources> provider) {
        this.a = provider;
    }

    public static ItemMapResourcesProviderImpl_Factory create(Provider<Resources> provider) {
        return new ItemMapResourcesProviderImpl_Factory(provider);
    }

    public static ItemMapResourcesProviderImpl newInstance(Resources resources) {
        return new ItemMapResourcesProviderImpl(resources);
    }

    @Override // javax.inject.Provider
    public ItemMapResourcesProviderImpl get() {
        return newInstance(this.a.get());
    }
}
