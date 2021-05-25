package com.avito.android.shop.detailed;

import com.avito.android.FavoriteSellersRepository;
import com.avito.android.notification_manager_provider.NotificationManagerProvider;
import com.avito.android.remote.FavoriteSellersApi;
import com.avito.android.remote.SearchApi;
import com.avito.android.remote.model.SearchParamsConverter;
import com.avito.android.serp.InlineFiltersInteractor;
import com.avito.android.shop.remote.ShopsApi;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ShopDetailedInteractorImpl_Factory implements Factory<ShopDetailedInteractorImpl> {
    public final Provider<String> a;
    public final Provider<String> b;
    public final Provider<String> c;
    public final Provider<ShopsApi> d;
    public final Provider<SearchApi> e;
    public final Provider<FavoriteSellersApi> f;
    public final Provider<SchedulersFactory3> g;
    public final Provider<NotificationManagerProvider> h;
    public final Provider<InlineFiltersInteractor> i;
    public final Provider<SearchParamsConverter> j;
    public final Provider<FavoriteSellersRepository> k;
    public final Provider<Kundle> l;

    public ShopDetailedInteractorImpl_Factory(Provider<String> provider, Provider<String> provider2, Provider<String> provider3, Provider<ShopsApi> provider4, Provider<SearchApi> provider5, Provider<FavoriteSellersApi> provider6, Provider<SchedulersFactory3> provider7, Provider<NotificationManagerProvider> provider8, Provider<InlineFiltersInteractor> provider9, Provider<SearchParamsConverter> provider10, Provider<FavoriteSellersRepository> provider11, Provider<Kundle> provider12) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
        this.h = provider8;
        this.i = provider9;
        this.j = provider10;
        this.k = provider11;
        this.l = provider12;
    }

    public static ShopDetailedInteractorImpl_Factory create(Provider<String> provider, Provider<String> provider2, Provider<String> provider3, Provider<ShopsApi> provider4, Provider<SearchApi> provider5, Provider<FavoriteSellersApi> provider6, Provider<SchedulersFactory3> provider7, Provider<NotificationManagerProvider> provider8, Provider<InlineFiltersInteractor> provider9, Provider<SearchParamsConverter> provider10, Provider<FavoriteSellersRepository> provider11, Provider<Kundle> provider12) {
        return new ShopDetailedInteractorImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12);
    }

    public static ShopDetailedInteractorImpl newInstance(String str, String str2, String str3, ShopsApi shopsApi, SearchApi searchApi, FavoriteSellersApi favoriteSellersApi, SchedulersFactory3 schedulersFactory3, NotificationManagerProvider notificationManagerProvider, InlineFiltersInteractor inlineFiltersInteractor, SearchParamsConverter searchParamsConverter, FavoriteSellersRepository favoriteSellersRepository, Kundle kundle) {
        return new ShopDetailedInteractorImpl(str, str2, str3, shopsApi, searchApi, favoriteSellersApi, schedulersFactory3, notificationManagerProvider, inlineFiltersInteractor, searchParamsConverter, favoriteSellersRepository, kundle);
    }

    @Override // javax.inject.Provider
    public ShopDetailedInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get(), this.i.get(), this.j.get(), this.k.get(), this.l.get());
    }
}
