package com.avito.android.user_favorites;

import com.avito.android.Features;
import com.avito.android.ab_tests.groups.ViewedItemsTabTestGroup;
import com.avito.android.ab_tests.models.SingleManuallyExposedAbTestGroup;
import com.avito.android.account.AccountStorageInteractor;
import com.avito.android.common.CounterInteractor;
import com.avito.android.db.SearchSubscriptionDao;
import com.avito.android.preferences.UserFavoritesStorage;
import com.avito.android.search.subscriptions.SearchSubscriptionObservable;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.viewed_items.ViewedItemsCountInteractor;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class UserFavoritesInteractorImpl_Factory implements Factory<UserFavoritesInteractorImpl> {
    public final Provider<AccountStorageInteractor> a;
    public final Provider<UserFavoritesResourceProvider> b;
    public final Provider<SchedulersFactory3> c;
    public final Provider<SearchSubscriptionDao> d;
    public final Provider<CounterInteractor> e;
    public final Provider<CounterInteractor> f;
    public final Provider<SearchSubscriptionObservable> g;
    public final Provider<SingleManuallyExposedAbTestGroup<ViewedItemsTabTestGroup>> h;
    public final Provider<ViewedItemsCountInteractor> i;
    public final Provider<UserFavoritesStorage> j;
    public final Provider<Features> k;

    public UserFavoritesInteractorImpl_Factory(Provider<AccountStorageInteractor> provider, Provider<UserFavoritesResourceProvider> provider2, Provider<SchedulersFactory3> provider3, Provider<SearchSubscriptionDao> provider4, Provider<CounterInteractor> provider5, Provider<CounterInteractor> provider6, Provider<SearchSubscriptionObservable> provider7, Provider<SingleManuallyExposedAbTestGroup<ViewedItemsTabTestGroup>> provider8, Provider<ViewedItemsCountInteractor> provider9, Provider<UserFavoritesStorage> provider10, Provider<Features> provider11) {
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
    }

    public static UserFavoritesInteractorImpl_Factory create(Provider<AccountStorageInteractor> provider, Provider<UserFavoritesResourceProvider> provider2, Provider<SchedulersFactory3> provider3, Provider<SearchSubscriptionDao> provider4, Provider<CounterInteractor> provider5, Provider<CounterInteractor> provider6, Provider<SearchSubscriptionObservable> provider7, Provider<SingleManuallyExposedAbTestGroup<ViewedItemsTabTestGroup>> provider8, Provider<ViewedItemsCountInteractor> provider9, Provider<UserFavoritesStorage> provider10, Provider<Features> provider11) {
        return new UserFavoritesInteractorImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11);
    }

    public static UserFavoritesInteractorImpl newInstance(AccountStorageInteractor accountStorageInteractor, UserFavoritesResourceProvider userFavoritesResourceProvider, SchedulersFactory3 schedulersFactory3, SearchSubscriptionDao searchSubscriptionDao, CounterInteractor counterInteractor, CounterInteractor counterInteractor2, SearchSubscriptionObservable searchSubscriptionObservable, SingleManuallyExposedAbTestGroup<ViewedItemsTabTestGroup> singleManuallyExposedAbTestGroup, ViewedItemsCountInteractor viewedItemsCountInteractor, UserFavoritesStorage userFavoritesStorage, Features features) {
        return new UserFavoritesInteractorImpl(accountStorageInteractor, userFavoritesResourceProvider, schedulersFactory3, searchSubscriptionDao, counterInteractor, counterInteractor2, searchSubscriptionObservable, singleManuallyExposedAbTestGroup, viewedItemsCountInteractor, userFavoritesStorage, features);
    }

    @Override // javax.inject.Provider
    public UserFavoritesInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get(), this.i.get(), this.j.get(), this.k.get());
    }
}
