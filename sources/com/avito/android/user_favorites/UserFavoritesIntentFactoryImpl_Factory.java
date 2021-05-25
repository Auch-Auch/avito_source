package com.avito.android.user_favorites;

import com.avito.android.CoreActivityIntentFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class UserFavoritesIntentFactoryImpl_Factory implements Factory<UserFavoritesIntentFactoryImpl> {
    public final Provider<CoreActivityIntentFactory> a;

    public UserFavoritesIntentFactoryImpl_Factory(Provider<CoreActivityIntentFactory> provider) {
        this.a = provider;
    }

    public static UserFavoritesIntentFactoryImpl_Factory create(Provider<CoreActivityIntentFactory> provider) {
        return new UserFavoritesIntentFactoryImpl_Factory(provider);
    }

    public static UserFavoritesIntentFactoryImpl newInstance(CoreActivityIntentFactory coreActivityIntentFactory) {
        return new UserFavoritesIntentFactoryImpl(coreActivityIntentFactory);
    }

    @Override // javax.inject.Provider
    public UserFavoritesIntentFactoryImpl get() {
        return newInstance(this.a.get());
    }
}
