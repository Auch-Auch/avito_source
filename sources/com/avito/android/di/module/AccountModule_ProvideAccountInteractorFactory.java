package com.avito.android.di.module;

import com.avito.android.Features;
import com.avito.android.account.AccountInteractor;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.account.AccountUpdateInteractor;
import com.avito.android.account.LoginSuggestStorage;
import com.avito.android.analytics.Analytics;
import com.avito.android.preferences.TokenStorage;
import com.avito.android.remote.ProfileApi;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class AccountModule_ProvideAccountInteractorFactory implements Factory<AccountInteractor> {
    public final Provider<ProfileApi> a;
    public final Provider<TokenStorage> b;
    public final Provider<LoginSuggestStorage> c;
    public final Provider<Features> d;
    public final Provider<SchedulersFactory3> e;
    public final Provider<AccountUpdateInteractor> f;
    public final Provider<AccountStateProvider> g;
    public final Provider<TypedErrorThrowableConverter> h;
    public final Provider<Analytics> i;
    public final Provider<BuildInfo> j;

    public AccountModule_ProvideAccountInteractorFactory(Provider<ProfileApi> provider, Provider<TokenStorage> provider2, Provider<LoginSuggestStorage> provider3, Provider<Features> provider4, Provider<SchedulersFactory3> provider5, Provider<AccountUpdateInteractor> provider6, Provider<AccountStateProvider> provider7, Provider<TypedErrorThrowableConverter> provider8, Provider<Analytics> provider9, Provider<BuildInfo> provider10) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
        this.h = provider8;
        this.i = provider9;
        this.j = provider10;
    }

    public static AccountModule_ProvideAccountInteractorFactory create(Provider<ProfileApi> provider, Provider<TokenStorage> provider2, Provider<LoginSuggestStorage> provider3, Provider<Features> provider4, Provider<SchedulersFactory3> provider5, Provider<AccountUpdateInteractor> provider6, Provider<AccountStateProvider> provider7, Provider<TypedErrorThrowableConverter> provider8, Provider<Analytics> provider9, Provider<BuildInfo> provider10) {
        return new AccountModule_ProvideAccountInteractorFactory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10);
    }

    public static AccountInteractor provideAccountInteractor(ProfileApi profileApi, TokenStorage tokenStorage, LoginSuggestStorage loginSuggestStorage, Features features, SchedulersFactory3 schedulersFactory3, AccountUpdateInteractor accountUpdateInteractor, AccountStateProvider accountStateProvider, TypedErrorThrowableConverter typedErrorThrowableConverter, Analytics analytics, BuildInfo buildInfo) {
        return (AccountInteractor) Preconditions.checkNotNullFromProvides(AccountModule.provideAccountInteractor(profileApi, tokenStorage, loginSuggestStorage, features, schedulersFactory3, accountUpdateInteractor, accountStateProvider, typedErrorThrowableConverter, analytics, buildInfo));
    }

    @Override // javax.inject.Provider
    public AccountInteractor get() {
        return provideAccountInteractor(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get(), this.i.get(), this.j.get());
    }
}
