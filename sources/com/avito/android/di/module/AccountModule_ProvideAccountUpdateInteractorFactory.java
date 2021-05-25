package com.avito.android.di.module;

import com.avito.android.Features;
import com.avito.android.account.AccountStorageInteractor;
import com.avito.android.account.AccountUpdateInteractor;
import com.avito.android.account.MutableLastLoggedEmailStorage;
import com.avito.android.account.SessionChangeTracker;
import com.avito.android.account.plugin.AuthorizationPlugin;
import com.avito.android.analytics.Analytics;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Set;
import javax.inject.Provider;
public final class AccountModule_ProvideAccountUpdateInteractorFactory implements Factory<AccountUpdateInteractor> {
    public final Provider<Analytics> a;
    public final Provider<AccountStorageInteractor> b;
    public final Provider<SessionChangeTracker> c;
    public final Provider<Set<AuthorizationPlugin>> d;
    public final Provider<MutableLastLoggedEmailStorage> e;
    public final Provider<Features> f;

    public AccountModule_ProvideAccountUpdateInteractorFactory(Provider<Analytics> provider, Provider<AccountStorageInteractor> provider2, Provider<SessionChangeTracker> provider3, Provider<Set<AuthorizationPlugin>> provider4, Provider<MutableLastLoggedEmailStorage> provider5, Provider<Features> provider6) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
    }

    public static AccountModule_ProvideAccountUpdateInteractorFactory create(Provider<Analytics> provider, Provider<AccountStorageInteractor> provider2, Provider<SessionChangeTracker> provider3, Provider<Set<AuthorizationPlugin>> provider4, Provider<MutableLastLoggedEmailStorage> provider5, Provider<Features> provider6) {
        return new AccountModule_ProvideAccountUpdateInteractorFactory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static AccountUpdateInteractor provideAccountUpdateInteractor(Analytics analytics, AccountStorageInteractor accountStorageInteractor, SessionChangeTracker sessionChangeTracker, Lazy<Set<AuthorizationPlugin>> lazy, MutableLastLoggedEmailStorage mutableLastLoggedEmailStorage, Features features) {
        return (AccountUpdateInteractor) Preconditions.checkNotNullFromProvides(AccountModule.provideAccountUpdateInteractor(analytics, accountStorageInteractor, sessionChangeTracker, lazy, mutableLastLoggedEmailStorage, features));
    }

    @Override // javax.inject.Provider
    public AccountUpdateInteractor get() {
        return provideAccountUpdateInteractor(this.a.get(), this.b.get(), this.c.get(), DoubleCheck.lazy(this.d), this.e.get(), this.f.get());
    }
}
