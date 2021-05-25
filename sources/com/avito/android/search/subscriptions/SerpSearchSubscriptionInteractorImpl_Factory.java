package com.avito.android.search.subscriptions;

import com.avito.android.Features;
import com.avito.android.db.SearchSubscriptionDao;
import com.avito.android.subscriptions.remote.SubscriptionsApi;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SerpSearchSubscriptionInteractorImpl_Factory implements Factory<SerpSearchSubscriptionInteractorImpl> {
    public final Provider<SearchSubscriptionDao> a;
    public final Provider<SubscriptionsApi> b;
    public final Provider<SchedulersFactory3> c;
    public final Provider<SearchSubscriptionConsumer> d;
    public final Provider<Features> e;

    public SerpSearchSubscriptionInteractorImpl_Factory(Provider<SearchSubscriptionDao> provider, Provider<SubscriptionsApi> provider2, Provider<SchedulersFactory3> provider3, Provider<SearchSubscriptionConsumer> provider4, Provider<Features> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static SerpSearchSubscriptionInteractorImpl_Factory create(Provider<SearchSubscriptionDao> provider, Provider<SubscriptionsApi> provider2, Provider<SchedulersFactory3> provider3, Provider<SearchSubscriptionConsumer> provider4, Provider<Features> provider5) {
        return new SerpSearchSubscriptionInteractorImpl_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static SerpSearchSubscriptionInteractorImpl newInstance(SearchSubscriptionDao searchSubscriptionDao, SubscriptionsApi subscriptionsApi, SchedulersFactory3 schedulersFactory3, SearchSubscriptionConsumer searchSubscriptionConsumer, Features features) {
        return new SerpSearchSubscriptionInteractorImpl(searchSubscriptionDao, subscriptionsApi, schedulersFactory3, searchSubscriptionConsumer, features);
    }

    @Override // javax.inject.Provider
    public SerpSearchSubscriptionInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
