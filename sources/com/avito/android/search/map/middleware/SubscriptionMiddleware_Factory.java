package com.avito.android.search.map.middleware;

import com.avito.android.analytics.Analytics;
import com.avito.android.search.map.interactor.SerpCacheInteractor;
import com.avito.android.serp.SerpSnippetInteractor;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SubscriptionMiddleware_Factory implements Factory<SubscriptionMiddleware> {
    public final Provider<Analytics> a;
    public final Provider<SerpSnippetInteractor> b;
    public final Provider<SerpCacheInteractor> c;

    public SubscriptionMiddleware_Factory(Provider<Analytics> provider, Provider<SerpSnippetInteractor> provider2, Provider<SerpCacheInteractor> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static SubscriptionMiddleware_Factory create(Provider<Analytics> provider, Provider<SerpSnippetInteractor> provider2, Provider<SerpCacheInteractor> provider3) {
        return new SubscriptionMiddleware_Factory(provider, provider2, provider3);
    }

    public static SubscriptionMiddleware newInstance(Analytics analytics, SerpSnippetInteractor serpSnippetInteractor, SerpCacheInteractor serpCacheInteractor) {
        return new SubscriptionMiddleware(analytics, serpSnippetInteractor, serpCacheInteractor);
    }

    @Override // javax.inject.Provider
    public SubscriptionMiddleware get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
