package com.avito.android.shop.detailed;

import android.content.res.Resources;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class NoItemsFoundHeightProviderImpl_Factory implements Factory<NoItemsFoundHeightProviderImpl> {
    public final Provider<Resources> a;

    public NoItemsFoundHeightProviderImpl_Factory(Provider<Resources> provider) {
        this.a = provider;
    }

    public static NoItemsFoundHeightProviderImpl_Factory create(Provider<Resources> provider) {
        return new NoItemsFoundHeightProviderImpl_Factory(provider);
    }

    public static NoItemsFoundHeightProviderImpl newInstance(Resources resources) {
        return new NoItemsFoundHeightProviderImpl(resources);
    }

    @Override // javax.inject.Provider
    public NoItemsFoundHeightProviderImpl get() {
        return newInstance(this.a.get());
    }
}
