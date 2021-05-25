package com.avito.android.user_subscribers;

import com.avito.android.remote.FavoriteSellersApi;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class UserSubscribersInteractorImpl_Factory implements Factory<UserSubscribersInteractorImpl> {
    public final Provider<FavoriteSellersApi> a;
    public final Provider<SchedulersFactory> b;
    public final Provider<UserSubscribersConverter> c;

    public UserSubscribersInteractorImpl_Factory(Provider<FavoriteSellersApi> provider, Provider<SchedulersFactory> provider2, Provider<UserSubscribersConverter> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static UserSubscribersInteractorImpl_Factory create(Provider<FavoriteSellersApi> provider, Provider<SchedulersFactory> provider2, Provider<UserSubscribersConverter> provider3) {
        return new UserSubscribersInteractorImpl_Factory(provider, provider2, provider3);
    }

    public static UserSubscribersInteractorImpl newInstance(FavoriteSellersApi favoriteSellersApi, SchedulersFactory schedulersFactory, UserSubscribersConverter userSubscribersConverter) {
        return new UserSubscribersInteractorImpl(favoriteSellersApi, schedulersFactory, userSubscribersConverter);
    }

    @Override // javax.inject.Provider
    public UserSubscribersInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
