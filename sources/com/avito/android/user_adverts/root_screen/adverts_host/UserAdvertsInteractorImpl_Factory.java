package com.avito.android.user_adverts.root_screen.adverts_host;

import com.avito.android.user_adverts.remote.UserAdvertsApi;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class UserAdvertsInteractorImpl_Factory implements Factory<UserAdvertsInteractorImpl> {
    public final Provider<UserAdvertsApi> a;
    public final Provider<SchedulersFactory> b;

    public UserAdvertsInteractorImpl_Factory(Provider<UserAdvertsApi> provider, Provider<SchedulersFactory> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static UserAdvertsInteractorImpl_Factory create(Provider<UserAdvertsApi> provider, Provider<SchedulersFactory> provider2) {
        return new UserAdvertsInteractorImpl_Factory(provider, provider2);
    }

    public static UserAdvertsInteractorImpl newInstance(UserAdvertsApi userAdvertsApi, SchedulersFactory schedulersFactory) {
        return new UserAdvertsInteractorImpl(userAdvertsApi, schedulersFactory);
    }

    @Override // javax.inject.Provider
    public UserAdvertsInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
