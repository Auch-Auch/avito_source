package com.avito.android.di;

import com.avito.android.Features;
import com.avito.android.account.AccountStorageInteractor;
import com.avito.android.account.AccountUpdateInteractor;
import com.avito.android.analytics.Analytics;
import com.avito.android.session_refresh.SessionRefresher;
import com.google.gson.Gson;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class SessionRefresherModule_ProvideSessionRefresherFactory implements Factory<SessionRefresher> {
    public final Provider<AccountStorageInteractor> a;
    public final Provider<AccountUpdateInteractor> b;
    public final Provider<Gson> c;
    public final Provider<Analytics> d;
    public final Provider<Features> e;

    public SessionRefresherModule_ProvideSessionRefresherFactory(Provider<AccountStorageInteractor> provider, Provider<AccountUpdateInteractor> provider2, Provider<Gson> provider3, Provider<Analytics> provider4, Provider<Features> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static SessionRefresherModule_ProvideSessionRefresherFactory create(Provider<AccountStorageInteractor> provider, Provider<AccountUpdateInteractor> provider2, Provider<Gson> provider3, Provider<Analytics> provider4, Provider<Features> provider5) {
        return new SessionRefresherModule_ProvideSessionRefresherFactory(provider, provider2, provider3, provider4, provider5);
    }

    public static SessionRefresher provideSessionRefresher(AccountStorageInteractor accountStorageInteractor, AccountUpdateInteractor accountUpdateInteractor, Gson gson, Analytics analytics, Features features) {
        return (SessionRefresher) Preconditions.checkNotNullFromProvides(SessionRefresherModule.INSTANCE.provideSessionRefresher(accountStorageInteractor, accountUpdateInteractor, gson, analytics, features));
    }

    @Override // javax.inject.Provider
    public SessionRefresher get() {
        return provideSessionRefresher(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
