package com.avito.android.search.subscriptions;

import com.avito.android.db.SearchSubscriptionDao;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.remote.model.SearchParamsConverter;
import com.avito.android.subscriptions.remote.SubscriptionsApi;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SubscribeSearchInteractorImpl_Factory implements Factory<SubscribeSearchInteractorImpl> {
    public final Provider<SubscriptionsApi> a;
    public final Provider<SearchSubscriptionDao> b;
    public final Provider<SearchParamsConverter> c;
    public final Provider<TypedErrorThrowableConverter> d;
    public final Provider<SchedulersFactory3> e;

    public SubscribeSearchInteractorImpl_Factory(Provider<SubscriptionsApi> provider, Provider<SearchSubscriptionDao> provider2, Provider<SearchParamsConverter> provider3, Provider<TypedErrorThrowableConverter> provider4, Provider<SchedulersFactory3> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static SubscribeSearchInteractorImpl_Factory create(Provider<SubscriptionsApi> provider, Provider<SearchSubscriptionDao> provider2, Provider<SearchParamsConverter> provider3, Provider<TypedErrorThrowableConverter> provider4, Provider<SchedulersFactory3> provider5) {
        return new SubscribeSearchInteractorImpl_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static SubscribeSearchInteractorImpl newInstance(SubscriptionsApi subscriptionsApi, SearchSubscriptionDao searchSubscriptionDao, SearchParamsConverter searchParamsConverter, TypedErrorThrowableConverter typedErrorThrowableConverter, SchedulersFactory3 schedulersFactory3) {
        return new SubscribeSearchInteractorImpl(subscriptionsApi, searchSubscriptionDao, searchParamsConverter, typedErrorThrowableConverter, schedulersFactory3);
    }

    @Override // javax.inject.Provider
    public SubscribeSearchInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
