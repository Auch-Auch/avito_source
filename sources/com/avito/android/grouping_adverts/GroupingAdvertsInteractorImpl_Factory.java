package com.avito.android.grouping_adverts;

import com.avito.android.favorites.FavoriteAdvertItemConverter;
import com.avito.android.favorites.remote.FavoritesApi;
import com.avito.android.remote.SearchApi;
import com.avito.android.remote.model.SearchParamsConverter;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class GroupingAdvertsInteractorImpl_Factory implements Factory<GroupingAdvertsInteractorImpl> {
    public final Provider<SearchApi> a;
    public final Provider<FavoritesApi> b;
    public final Provider<SchedulersFactory3> c;
    public final Provider<SearchParamsConverter> d;
    public final Provider<FavoriteAdvertItemConverter> e;

    public GroupingAdvertsInteractorImpl_Factory(Provider<SearchApi> provider, Provider<FavoritesApi> provider2, Provider<SchedulersFactory3> provider3, Provider<SearchParamsConverter> provider4, Provider<FavoriteAdvertItemConverter> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static GroupingAdvertsInteractorImpl_Factory create(Provider<SearchApi> provider, Provider<FavoritesApi> provider2, Provider<SchedulersFactory3> provider3, Provider<SearchParamsConverter> provider4, Provider<FavoriteAdvertItemConverter> provider5) {
        return new GroupingAdvertsInteractorImpl_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static GroupingAdvertsInteractorImpl newInstance(SearchApi searchApi, FavoritesApi favoritesApi, SchedulersFactory3 schedulersFactory3, SearchParamsConverter searchParamsConverter, FavoriteAdvertItemConverter favoriteAdvertItemConverter) {
        return new GroupingAdvertsInteractorImpl(searchApi, favoritesApi, schedulersFactory3, searchParamsConverter, favoriteAdvertItemConverter);
    }

    @Override // javax.inject.Provider
    public GroupingAdvertsInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
