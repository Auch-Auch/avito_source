package com.avito.android.viewed_items.adapter;

import com.avito.android.favorites.adapter.advert.FavoriteAdvertItemPresenter;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ViewedItemsListPresenter_Factory implements Factory<ViewedItemsListPresenter> {
    public final Provider<FavoriteAdvertItemPresenter.Listener> a;

    public ViewedItemsListPresenter_Factory(Provider<FavoriteAdvertItemPresenter.Listener> provider) {
        this.a = provider;
    }

    public static ViewedItemsListPresenter_Factory create(Provider<FavoriteAdvertItemPresenter.Listener> provider) {
        return new ViewedItemsListPresenter_Factory(provider);
    }

    public static ViewedItemsListPresenter newInstance(Lazy<FavoriteAdvertItemPresenter.Listener> lazy) {
        return new ViewedItemsListPresenter(lazy);
    }

    @Override // javax.inject.Provider
    public ViewedItemsListPresenter get() {
        return newInstance(DoubleCheck.lazy(this.a));
    }
}
