package com.avito.android.viewed_items;

import com.avito.android.analytics.provider.TreeStateIdGenerator;
import com.avito.android.favorite.FavoriteAdvertsEventInteractor;
import com.avito.android.favorite.FavoriteAdvertsInteractor;
import com.avito.android.preferences.UserFavoritesStorage;
import com.avito.android.util.SchedulersFactory3;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ViewedItemsPresenterImpl_Factory implements Factory<ViewedItemsPresenterImpl> {
    public final Provider<ViewedItemsInteractor> a;
    public final Provider<ViewedItemsCountInteractor> b;
    public final Provider<AdapterPresenter> c;
    public final Provider<UserFavoritesStorage> d;
    public final Provider<SchedulersFactory3> e;
    public final Provider<FavoriteAdvertsInteractor> f;
    public final Provider<FavoriteAdvertsEventInteractor> g;
    public final Provider<TreeStateIdGenerator> h;

    public ViewedItemsPresenterImpl_Factory(Provider<ViewedItemsInteractor> provider, Provider<ViewedItemsCountInteractor> provider2, Provider<AdapterPresenter> provider3, Provider<UserFavoritesStorage> provider4, Provider<SchedulersFactory3> provider5, Provider<FavoriteAdvertsInteractor> provider6, Provider<FavoriteAdvertsEventInteractor> provider7, Provider<TreeStateIdGenerator> provider8) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
        this.h = provider8;
    }

    public static ViewedItemsPresenterImpl_Factory create(Provider<ViewedItemsInteractor> provider, Provider<ViewedItemsCountInteractor> provider2, Provider<AdapterPresenter> provider3, Provider<UserFavoritesStorage> provider4, Provider<SchedulersFactory3> provider5, Provider<FavoriteAdvertsInteractor> provider6, Provider<FavoriteAdvertsEventInteractor> provider7, Provider<TreeStateIdGenerator> provider8) {
        return new ViewedItemsPresenterImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    public static ViewedItemsPresenterImpl newInstance(ViewedItemsInteractor viewedItemsInteractor, ViewedItemsCountInteractor viewedItemsCountInteractor, AdapterPresenter adapterPresenter, UserFavoritesStorage userFavoritesStorage, SchedulersFactory3 schedulersFactory3, FavoriteAdvertsInteractor favoriteAdvertsInteractor, FavoriteAdvertsEventInteractor favoriteAdvertsEventInteractor, TreeStateIdGenerator treeStateIdGenerator) {
        return new ViewedItemsPresenterImpl(viewedItemsInteractor, viewedItemsCountInteractor, adapterPresenter, userFavoritesStorage, schedulersFactory3, favoriteAdvertsInteractor, favoriteAdvertsEventInteractor, treeStateIdGenerator);
    }

    @Override // javax.inject.Provider
    public ViewedItemsPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get());
    }
}
