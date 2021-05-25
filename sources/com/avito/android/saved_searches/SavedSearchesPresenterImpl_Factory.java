package com.avito.android.saved_searches;

import com.avito.android.account.AccountStateProvider;
import com.avito.android.analytics.Analytics;
import com.avito.android.search.subscriptions.SubscribeSearchInteractor;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SavedSearchesPresenterImpl_Factory implements Factory<SavedSearchesPresenterImpl> {
    public final Provider<SubscribeSearchInteractor> a;
    public final Provider<SchedulersFactory3> b;
    public final Provider<AccountStateProvider> c;
    public final Provider<Analytics> d;
    public final Provider<Kundle> e;

    public SavedSearchesPresenterImpl_Factory(Provider<SubscribeSearchInteractor> provider, Provider<SchedulersFactory3> provider2, Provider<AccountStateProvider> provider3, Provider<Analytics> provider4, Provider<Kundle> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static SavedSearchesPresenterImpl_Factory create(Provider<SubscribeSearchInteractor> provider, Provider<SchedulersFactory3> provider2, Provider<AccountStateProvider> provider3, Provider<Analytics> provider4, Provider<Kundle> provider5) {
        return new SavedSearchesPresenterImpl_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static SavedSearchesPresenterImpl newInstance(SubscribeSearchInteractor subscribeSearchInteractor, SchedulersFactory3 schedulersFactory3, AccountStateProvider accountStateProvider, Analytics analytics, Kundle kundle) {
        return new SavedSearchesPresenterImpl(subscribeSearchInteractor, schedulersFactory3, accountStateProvider, analytics, kundle);
    }

    @Override // javax.inject.Provider
    public SavedSearchesPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
