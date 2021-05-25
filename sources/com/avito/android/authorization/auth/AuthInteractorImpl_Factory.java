package com.avito.android.authorization.auth;

import com.avito.android.Features;
import com.avito.android.account.AccountInteractor;
import com.avito.android.account.LoginSuggestStorage;
import com.avito.android.analytics.Analytics;
import com.avito.android.authorization.smart_lock.SmartLockLoader;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AuthInteractorImpl_Factory implements Factory<AuthInteractorImpl> {
    public final Provider<AccountInteractor> a;
    public final Provider<LoginSuggestStorage> b;
    public final Provider<SmartLockLoader> c;
    public final Provider<SchedulersFactory3> d;
    public final Provider<Features> e;
    public final Provider<Analytics> f;

    public AuthInteractorImpl_Factory(Provider<AccountInteractor> provider, Provider<LoginSuggestStorage> provider2, Provider<SmartLockLoader> provider3, Provider<SchedulersFactory3> provider4, Provider<Features> provider5, Provider<Analytics> provider6) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
    }

    public static AuthInteractorImpl_Factory create(Provider<AccountInteractor> provider, Provider<LoginSuggestStorage> provider2, Provider<SmartLockLoader> provider3, Provider<SchedulersFactory3> provider4, Provider<Features> provider5, Provider<Analytics> provider6) {
        return new AuthInteractorImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static AuthInteractorImpl newInstance(AccountInteractor accountInteractor, LoginSuggestStorage loginSuggestStorage, SmartLockLoader smartLockLoader, SchedulersFactory3 schedulersFactory3, Features features, Analytics analytics) {
        return new AuthInteractorImpl(accountInteractor, loginSuggestStorage, smartLockLoader, schedulersFactory3, features, analytics);
    }

    @Override // javax.inject.Provider
    public AuthInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get());
    }
}
