package com.avito.android.search.subscriptions;

import android.content.Context;
import com.avito.android.search.subscriptions.sync.SearchSubscriptionSyncRunner;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SearchSubscriptionServiceInteractorImpl_Factory implements Factory<SearchSubscriptionServiceInteractorImpl> {
    public final Provider<Context> a;
    public final Provider<SearchSubscriptionSyncRunner> b;

    public SearchSubscriptionServiceInteractorImpl_Factory(Provider<Context> provider, Provider<SearchSubscriptionSyncRunner> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static SearchSubscriptionServiceInteractorImpl_Factory create(Provider<Context> provider, Provider<SearchSubscriptionSyncRunner> provider2) {
        return new SearchSubscriptionServiceInteractorImpl_Factory(provider, provider2);
    }

    public static SearchSubscriptionServiceInteractorImpl newInstance(Context context, SearchSubscriptionSyncRunner searchSubscriptionSyncRunner) {
        return new SearchSubscriptionServiceInteractorImpl(context, searchSubscriptionSyncRunner);
    }

    @Override // javax.inject.Provider
    public SearchSubscriptionServiceInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
