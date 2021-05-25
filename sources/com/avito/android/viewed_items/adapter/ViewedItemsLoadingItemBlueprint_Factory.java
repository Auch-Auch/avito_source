package com.avito.android.viewed_items.adapter;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class ViewedItemsLoadingItemBlueprint_Factory implements Factory<ViewedItemsLoadingItemBlueprint> {
    public final Provider<ViewedItemsLoadingItemsPresenterImpl> a;

    public ViewedItemsLoadingItemBlueprint_Factory(Provider<ViewedItemsLoadingItemsPresenterImpl> provider) {
        this.a = provider;
    }

    public static ViewedItemsLoadingItemBlueprint_Factory create(Provider<ViewedItemsLoadingItemsPresenterImpl> provider) {
        return new ViewedItemsLoadingItemBlueprint_Factory(provider);
    }

    public static ViewedItemsLoadingItemBlueprint newInstance(ViewedItemsLoadingItemsPresenterImpl viewedItemsLoadingItemsPresenterImpl) {
        return new ViewedItemsLoadingItemBlueprint(viewedItemsLoadingItemsPresenterImpl);
    }

    @Override // javax.inject.Provider
    public ViewedItemsLoadingItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
