package com.avito.android.user_favorites.di;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class UserFavoritesModule_ProvideFragmentManagerFactory implements Factory<FragmentManager> {
    public final Provider<Fragment> a;

    public UserFavoritesModule_ProvideFragmentManagerFactory(Provider<Fragment> provider) {
        this.a = provider;
    }

    public static UserFavoritesModule_ProvideFragmentManagerFactory create(Provider<Fragment> provider) {
        return new UserFavoritesModule_ProvideFragmentManagerFactory(provider);
    }

    public static FragmentManager provideFragmentManager(Fragment fragment) {
        return (FragmentManager) Preconditions.checkNotNullFromProvides(UserFavoritesModule.provideFragmentManager(fragment));
    }

    @Override // javax.inject.Provider
    public FragmentManager get() {
        return provideFragmentManager(this.a.get());
    }
}
