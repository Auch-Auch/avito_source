package com.avito.android.user_favorites.di;

import android.content.Context;
import androidx.fragment.app.Fragment;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class UserFavoritesModule_ProvideContextFactory implements Factory<Context> {
    public final Provider<Fragment> a;

    public UserFavoritesModule_ProvideContextFactory(Provider<Fragment> provider) {
        this.a = provider;
    }

    public static UserFavoritesModule_ProvideContextFactory create(Provider<Fragment> provider) {
        return new UserFavoritesModule_ProvideContextFactory(provider);
    }

    public static Context provideContext(Fragment fragment) {
        return (Context) Preconditions.checkNotNullFromProvides(UserFavoritesModule.provideContext(fragment));
    }

    @Override // javax.inject.Provider
    public Context get() {
        return provideContext(this.a.get());
    }
}
