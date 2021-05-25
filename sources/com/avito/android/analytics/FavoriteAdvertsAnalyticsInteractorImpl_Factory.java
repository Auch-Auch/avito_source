package com.avito.android.analytics;

import com.avito.android.account.AccountStateProvider;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class FavoriteAdvertsAnalyticsInteractorImpl_Factory implements Factory<FavoriteAdvertsAnalyticsInteractorImpl> {
    public final Provider<Analytics> a;
    public final Provider<AccountStateProvider> b;

    public FavoriteAdvertsAnalyticsInteractorImpl_Factory(Provider<Analytics> provider, Provider<AccountStateProvider> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static FavoriteAdvertsAnalyticsInteractorImpl_Factory create(Provider<Analytics> provider, Provider<AccountStateProvider> provider2) {
        return new FavoriteAdvertsAnalyticsInteractorImpl_Factory(provider, provider2);
    }

    public static FavoriteAdvertsAnalyticsInteractorImpl newInstance(Analytics analytics, AccountStateProvider accountStateProvider) {
        return new FavoriteAdvertsAnalyticsInteractorImpl(analytics, accountStateProvider);
    }

    @Override // javax.inject.Provider
    public FavoriteAdvertsAnalyticsInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
