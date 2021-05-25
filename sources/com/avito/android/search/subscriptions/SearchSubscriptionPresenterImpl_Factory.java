package com.avito.android.search.subscriptions;

import android.os.Bundle;
import com.avito.android.account.AccountStorageInteractor;
import com.avito.android.analytics.Analytics;
import com.avito.android.saved_searches.SavedSearchesPresenter;
import com.avito.android.tracker.SearchSubscriptionsTracker;
import com.avito.android.util.Formatter;
import com.avito.android.util.SchedulersFactory3;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SearchSubscriptionPresenterImpl_Factory implements Factory<SearchSubscriptionPresenterImpl> {
    public final Provider<Bundle> a;
    public final Provider<Analytics> b;
    public final Provider<Formatter<Throwable>> c;
    public final Provider<SearchSubscriptionInteractor> d;
    public final Provider<SearchSubscriptionServiceInteractor> e;
    public final Provider<SearchSubscriptionObservable> f;
    public final Provider<AccountStorageInteractor> g;
    public final Provider<SchedulersFactory3> h;
    public final Provider<AdapterPresenter> i;
    public final Provider<SearchSubscriptionsTracker> j;
    public final Provider<SavedSearchesPresenter> k;

    public SearchSubscriptionPresenterImpl_Factory(Provider<Bundle> provider, Provider<Analytics> provider2, Provider<Formatter<Throwable>> provider3, Provider<SearchSubscriptionInteractor> provider4, Provider<SearchSubscriptionServiceInteractor> provider5, Provider<SearchSubscriptionObservable> provider6, Provider<AccountStorageInteractor> provider7, Provider<SchedulersFactory3> provider8, Provider<AdapterPresenter> provider9, Provider<SearchSubscriptionsTracker> provider10, Provider<SavedSearchesPresenter> provider11) {
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

    public static SearchSubscriptionPresenterImpl_Factory create(Provider<Bundle> provider, Provider<Analytics> provider2, Provider<Formatter<Throwable>> provider3, Provider<SearchSubscriptionInteractor> provider4, Provider<SearchSubscriptionServiceInteractor> provider5, Provider<SearchSubscriptionObservable> provider6, Provider<AccountStorageInteractor> provider7, Provider<SchedulersFactory3> provider8, Provider<AdapterPresenter> provider9, Provider<SearchSubscriptionsTracker> provider10, Provider<SavedSearchesPresenter> provider11) {
        return new SearchSubscriptionPresenterImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11);
    }

    public static SearchSubscriptionPresenterImpl newInstance(Bundle bundle, Analytics analytics, Formatter<Throwable> formatter, SearchSubscriptionInteractor searchSubscriptionInteractor, SearchSubscriptionServiceInteractor searchSubscriptionServiceInteractor, SearchSubscriptionObservable searchSubscriptionObservable, AccountStorageInteractor accountStorageInteractor, SchedulersFactory3 schedulersFactory3, AdapterPresenter adapterPresenter, SearchSubscriptionsTracker searchSubscriptionsTracker, SavedSearchesPresenter savedSearchesPresenter) {
        return new SearchSubscriptionPresenterImpl(bundle, analytics, formatter, searchSubscriptionInteractor, searchSubscriptionServiceInteractor, searchSubscriptionObservable, accountStorageInteractor, schedulersFactory3, adapterPresenter, searchSubscriptionsTracker, savedSearchesPresenter);
    }

    @Override // javax.inject.Provider
    public SearchSubscriptionPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get(), this.i.get(), this.j.get(), this.k.get());
    }
}
