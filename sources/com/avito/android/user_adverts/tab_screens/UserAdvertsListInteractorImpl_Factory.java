package com.avito.android.user_adverts.tab_screens;

import android.os.Bundle;
import com.avito.android.Features;
import com.avito.android.user_adverts.remote.UserAdvertsApi;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class UserAdvertsListInteractorImpl_Factory implements Factory<UserAdvertsListInteractorImpl> {
    public final Provider<UserAdvertsApi> a;
    public final Provider<SchedulersFactory> b;
    public final Provider<Boolean> c;
    public final Provider<Features> d;
    public final Provider<Bundle> e;

    public UserAdvertsListInteractorImpl_Factory(Provider<UserAdvertsApi> provider, Provider<SchedulersFactory> provider2, Provider<Boolean> provider3, Provider<Features> provider4, Provider<Bundle> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static UserAdvertsListInteractorImpl_Factory create(Provider<UserAdvertsApi> provider, Provider<SchedulersFactory> provider2, Provider<Boolean> provider3, Provider<Features> provider4, Provider<Bundle> provider5) {
        return new UserAdvertsListInteractorImpl_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static UserAdvertsListInteractorImpl newInstance(UserAdvertsApi userAdvertsApi, SchedulersFactory schedulersFactory, boolean z, Features features, Bundle bundle) {
        return new UserAdvertsListInteractorImpl(userAdvertsApi, schedulersFactory, z, features, bundle);
    }

    @Override // javax.inject.Provider
    public UserAdvertsListInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get().booleanValue(), this.d.get(), this.e.get());
    }
}
