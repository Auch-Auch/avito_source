package com.avito.android.user_adverts.items_search;

import com.avito.android.user_adverts.remote.UserAdvertsApi;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ProfileItemsSearchInteractorImpl_Factory implements Factory<ProfileItemsSearchInteractorImpl> {
    public final Provider<UserAdvertsApi> a;
    public final Provider<SchedulersFactory> b;

    public ProfileItemsSearchInteractorImpl_Factory(Provider<UserAdvertsApi> provider, Provider<SchedulersFactory> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static ProfileItemsSearchInteractorImpl_Factory create(Provider<UserAdvertsApi> provider, Provider<SchedulersFactory> provider2) {
        return new ProfileItemsSearchInteractorImpl_Factory(provider, provider2);
    }

    public static ProfileItemsSearchInteractorImpl newInstance(UserAdvertsApi userAdvertsApi, SchedulersFactory schedulersFactory) {
        return new ProfileItemsSearchInteractorImpl(userAdvertsApi, schedulersFactory);
    }

    @Override // javax.inject.Provider
    public ProfileItemsSearchInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
