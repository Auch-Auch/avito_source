package com.avito.android.viewed_items.adapter;

import dagger.internal.Factory;
public final class ViewedItemsLoadingItemsPresenterImpl_Factory implements Factory<ViewedItemsLoadingItemsPresenterImpl> {

    public static final class a {
        public static final ViewedItemsLoadingItemsPresenterImpl_Factory a = new ViewedItemsLoadingItemsPresenterImpl_Factory();
    }

    public static ViewedItemsLoadingItemsPresenterImpl_Factory create() {
        return a.a;
    }

    public static ViewedItemsLoadingItemsPresenterImpl newInstance() {
        return new ViewedItemsLoadingItemsPresenterImpl();
    }

    @Override // javax.inject.Provider
    public ViewedItemsLoadingItemsPresenterImpl get() {
        return newInstance();
    }
}
