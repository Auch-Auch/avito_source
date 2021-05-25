package com.avito.android.user_advert.advert.service;

import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.user_advert_api.remote.UserAdvertApi;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class UserAdvertInteractorImpl_Factory implements Factory<UserAdvertInteractorImpl> {
    public final Provider<UserAdvertApi> a;
    public final Provider<Features> b;
    public final Provider<Analytics> c;

    public UserAdvertInteractorImpl_Factory(Provider<UserAdvertApi> provider, Provider<Features> provider2, Provider<Analytics> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static UserAdvertInteractorImpl_Factory create(Provider<UserAdvertApi> provider, Provider<Features> provider2, Provider<Analytics> provider3) {
        return new UserAdvertInteractorImpl_Factory(provider, provider2, provider3);
    }

    public static UserAdvertInteractorImpl newInstance(UserAdvertApi userAdvertApi, Features features, Analytics analytics) {
        return new UserAdvertInteractorImpl(userAdvertApi, features, analytics);
    }

    @Override // javax.inject.Provider
    public UserAdvertInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
