package com.avito.android.user_favorites;

import android.content.res.Resources;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class UserFavoritesResourceProviderImpl_Factory implements Factory<UserFavoritesResourceProviderImpl> {
    public final Provider<Resources> a;

    public UserFavoritesResourceProviderImpl_Factory(Provider<Resources> provider) {
        this.a = provider;
    }

    public static UserFavoritesResourceProviderImpl_Factory create(Provider<Resources> provider) {
        return new UserFavoritesResourceProviderImpl_Factory(provider);
    }

    public static UserFavoritesResourceProviderImpl newInstance(Resources resources) {
        return new UserFavoritesResourceProviderImpl(resources);
    }

    @Override // javax.inject.Provider
    public UserFavoritesResourceProviderImpl get() {
        return newInstance(this.a.get());
    }
}
