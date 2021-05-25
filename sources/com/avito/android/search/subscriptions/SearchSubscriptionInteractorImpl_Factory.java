package com.avito.android.search.subscriptions;

import com.avito.android.db.SearchSubscriptionDao;
import com.avito.android.subscriptions.remote.SubscriptionsApi;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SearchSubscriptionInteractorImpl_Factory implements Factory<SearchSubscriptionInteractorImpl> {
    public final Provider<SubscriptionsApi> a;
    public final Provider<SearchSubscriptionDao> b;
    public final Provider<SearchSubscriptionConsumer> c;
    public final Provider<SchedulersFactory3> d;

    public SearchSubscriptionInteractorImpl_Factory(Provider<SubscriptionsApi> provider, Provider<SearchSubscriptionDao> provider2, Provider<SearchSubscriptionConsumer> provider3, Provider<SchedulersFactory3> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static SearchSubscriptionInteractorImpl_Factory create(Provider<SubscriptionsApi> provider, Provider<SearchSubscriptionDao> provider2, Provider<SearchSubscriptionConsumer> provider3, Provider<SchedulersFactory3> provider4) {
        return new SearchSubscriptionInteractorImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static SearchSubscriptionInteractorImpl newInstance(SubscriptionsApi subscriptionsApi, SearchSubscriptionDao searchSubscriptionDao, SearchSubscriptionConsumer searchSubscriptionConsumer, SchedulersFactory3 schedulersFactory3) {
        return new SearchSubscriptionInteractorImpl(subscriptionsApi, searchSubscriptionDao, searchSubscriptionConsumer, schedulersFactory3);
    }

    @Override // javax.inject.Provider
    public SearchSubscriptionInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
