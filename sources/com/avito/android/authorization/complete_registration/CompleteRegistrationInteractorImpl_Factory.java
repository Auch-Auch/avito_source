package com.avito.android.authorization.complete_registration;

import com.avito.android.account.AccountUpdateInteractor;
import com.avito.android.account.LoginSuggestStorage;
import com.avito.android.analytics.Analytics;
import com.avito.android.preferences.TokenStorage;
import com.avito.android.remote.ProfileApi;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class CompleteRegistrationInteractorImpl_Factory implements Factory<CompleteRegistrationInteractorImpl> {
    public final Provider<String> a;
    public final Provider<ProfileApi> b;
    public final Provider<AccountUpdateInteractor> c;
    public final Provider<TypedErrorThrowableConverter> d;
    public final Provider<TokenStorage> e;
    public final Provider<LoginSuggestStorage> f;
    public final Provider<Analytics> g;
    public final Provider<SchedulersFactory> h;

    public CompleteRegistrationInteractorImpl_Factory(Provider<String> provider, Provider<ProfileApi> provider2, Provider<AccountUpdateInteractor> provider3, Provider<TypedErrorThrowableConverter> provider4, Provider<TokenStorage> provider5, Provider<LoginSuggestStorage> provider6, Provider<Analytics> provider7, Provider<SchedulersFactory> provider8) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
        this.h = provider8;
    }

    public static CompleteRegistrationInteractorImpl_Factory create(Provider<String> provider, Provider<ProfileApi> provider2, Provider<AccountUpdateInteractor> provider3, Provider<TypedErrorThrowableConverter> provider4, Provider<TokenStorage> provider5, Provider<LoginSuggestStorage> provider6, Provider<Analytics> provider7, Provider<SchedulersFactory> provider8) {
        return new CompleteRegistrationInteractorImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    public static CompleteRegistrationInteractorImpl newInstance(String str, ProfileApi profileApi, AccountUpdateInteractor accountUpdateInteractor, TypedErrorThrowableConverter typedErrorThrowableConverter, TokenStorage tokenStorage, LoginSuggestStorage loginSuggestStorage, Analytics analytics, SchedulersFactory schedulersFactory) {
        return new CompleteRegistrationInteractorImpl(str, profileApi, accountUpdateInteractor, typedErrorThrowableConverter, tokenStorage, loginSuggestStorage, analytics, schedulersFactory);
    }

    @Override // javax.inject.Provider
    public CompleteRegistrationInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get());
    }
}
