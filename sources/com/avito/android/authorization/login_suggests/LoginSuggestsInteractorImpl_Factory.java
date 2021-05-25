package com.avito.android.authorization.login_suggests;

import com.avito.android.account.LoginSuggestStorage;
import com.avito.android.remote.ProfileApi;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class LoginSuggestsInteractorImpl_Factory implements Factory<LoginSuggestsInteractorImpl> {
    public final Provider<ProfileApi> a;
    public final Provider<SchedulersFactory> b;
    public final Provider<LoginSuggestStorage> c;

    public LoginSuggestsInteractorImpl_Factory(Provider<ProfileApi> provider, Provider<SchedulersFactory> provider2, Provider<LoginSuggestStorage> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static LoginSuggestsInteractorImpl_Factory create(Provider<ProfileApi> provider, Provider<SchedulersFactory> provider2, Provider<LoginSuggestStorage> provider3) {
        return new LoginSuggestsInteractorImpl_Factory(provider, provider2, provider3);
    }

    public static LoginSuggestsInteractorImpl newInstance(ProfileApi profileApi, SchedulersFactory schedulersFactory, LoginSuggestStorage loginSuggestStorage) {
        return new LoginSuggestsInteractorImpl(profileApi, schedulersFactory, loginSuggestStorage);
    }

    @Override // javax.inject.Provider
    public LoginSuggestsInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
