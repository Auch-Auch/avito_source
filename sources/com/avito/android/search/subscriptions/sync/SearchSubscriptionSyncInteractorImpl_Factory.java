package com.avito.android.search.subscriptions.sync;

import com.avito.android.account.AccountStorageInteractor;
import com.avito.android.db.SearchSubscriptionDao;
import com.avito.android.search.subscriptions.SearchSubscriptionConsumer;
import com.avito.android.subscriptions.remote.SubscriptionsApi;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SearchSubscriptionSyncInteractorImpl_Factory implements Factory<SearchSubscriptionSyncInteractorImpl> {
    public final Provider<SubscriptionsApi> a;
    public final Provider<SearchSubscriptionConsumer> b;
    public final Provider<SearchSubscriptionDao> c;
    public final Provider<AccountStorageInteractor> d;

    public SearchSubscriptionSyncInteractorImpl_Factory(Provider<SubscriptionsApi> provider, Provider<SearchSubscriptionConsumer> provider2, Provider<SearchSubscriptionDao> provider3, Provider<AccountStorageInteractor> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static SearchSubscriptionSyncInteractorImpl_Factory create(Provider<SubscriptionsApi> provider, Provider<SearchSubscriptionConsumer> provider2, Provider<SearchSubscriptionDao> provider3, Provider<AccountStorageInteractor> provider4) {
        return new SearchSubscriptionSyncInteractorImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static SearchSubscriptionSyncInteractorImpl newInstance(SubscriptionsApi subscriptionsApi, SearchSubscriptionConsumer searchSubscriptionConsumer, SearchSubscriptionDao searchSubscriptionDao, AccountStorageInteractor accountStorageInteractor) {
        return new SearchSubscriptionSyncInteractorImpl(subscriptionsApi, searchSubscriptionConsumer, searchSubscriptionDao, accountStorageInteractor);
    }

    @Override // javax.inject.Provider
    public SearchSubscriptionSyncInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
