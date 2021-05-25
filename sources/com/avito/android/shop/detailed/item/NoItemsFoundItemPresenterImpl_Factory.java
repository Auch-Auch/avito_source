package com.avito.android.shop.detailed.item;

import com.avito.android.shop.detailed.NoItemsFoundHeightProvider;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class NoItemsFoundItemPresenterImpl_Factory implements Factory<NoItemsFoundItemPresenterImpl> {
    public final Provider<NoItemsFoundHeightProvider> a;

    public NoItemsFoundItemPresenterImpl_Factory(Provider<NoItemsFoundHeightProvider> provider) {
        this.a = provider;
    }

    public static NoItemsFoundItemPresenterImpl_Factory create(Provider<NoItemsFoundHeightProvider> provider) {
        return new NoItemsFoundItemPresenterImpl_Factory(provider);
    }

    public static NoItemsFoundItemPresenterImpl newInstance(NoItemsFoundHeightProvider noItemsFoundHeightProvider) {
        return new NoItemsFoundItemPresenterImpl(noItemsFoundHeightProvider);
    }

    @Override // javax.inject.Provider
    public NoItemsFoundItemPresenterImpl get() {
        return newInstance(this.a.get());
    }
}
