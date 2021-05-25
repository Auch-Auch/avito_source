package com.avito.android.user_favorites.di;

import android.content.res.Resources;
import androidx.fragment.app.Fragment;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class UserFavoritesModule_ProvideResourceFactory implements Factory<Resources> {
    public final Provider<Fragment> a;

    public UserFavoritesModule_ProvideResourceFactory(Provider<Fragment> provider) {
        this.a = provider;
    }

    public static UserFavoritesModule_ProvideResourceFactory create(Provider<Fragment> provider) {
        return new UserFavoritesModule_ProvideResourceFactory(provider);
    }

    public static Resources provideResource(Fragment fragment) {
        return (Resources) Preconditions.checkNotNullFromProvides(UserFavoritesModule.provideResource(fragment));
    }

    @Override // javax.inject.Provider
    public Resources get() {
        return provideResource(this.a.get());
    }
}
