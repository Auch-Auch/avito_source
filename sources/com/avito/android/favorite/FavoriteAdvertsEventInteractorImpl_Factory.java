package com.avito.android.favorite;

import com.avito.android.account.AccountStateProvider;
import com.avito.android.analytics.Analytics;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class FavoriteAdvertsEventInteractorImpl_Factory implements Factory<FavoriteAdvertsEventInteractorImpl> {
    public final Provider<AccountStateProvider> a;
    public final Provider<Analytics> b;

    public FavoriteAdvertsEventInteractorImpl_Factory(Provider<AccountStateProvider> provider, Provider<Analytics> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static FavoriteAdvertsEventInteractorImpl_Factory create(Provider<AccountStateProvider> provider, Provider<Analytics> provider2) {
        return new FavoriteAdvertsEventInteractorImpl_Factory(provider, provider2);
    }

    public static FavoriteAdvertsEventInteractorImpl newInstance(AccountStateProvider accountStateProvider, Analytics analytics) {
        return new FavoriteAdvertsEventInteractorImpl(accountStateProvider, analytics);
    }

    @Override // javax.inject.Provider
    public FavoriteAdvertsEventInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
