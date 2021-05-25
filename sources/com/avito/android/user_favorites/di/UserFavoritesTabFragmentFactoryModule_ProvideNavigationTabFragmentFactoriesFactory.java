package com.avito.android.user_favorites.di;

import com.avito.android.bottom_navigation.NavigationTabFragmentFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Set;
public final class UserFavoritesTabFragmentFactoryModule_ProvideNavigationTabFragmentFactoriesFactory implements Factory<Set<NavigationTabFragmentFactory>> {

    public static final class a {
        public static final UserFavoritesTabFragmentFactoryModule_ProvideNavigationTabFragmentFactoriesFactory a = new UserFavoritesTabFragmentFactoryModule_ProvideNavigationTabFragmentFactoriesFactory();
    }

    public static UserFavoritesTabFragmentFactoryModule_ProvideNavigationTabFragmentFactoriesFactory create() {
        return a.a;
    }

    public static Set<NavigationTabFragmentFactory> provideNavigationTabFragmentFactories() {
        return (Set) Preconditions.checkNotNullFromProvides(UserFavoritesTabFragmentFactoryModule.provideNavigationTabFragmentFactories());
    }

    @Override // javax.inject.Provider
    public Set<NavigationTabFragmentFactory> get() {
        return provideNavigationTabFragmentFactories();
    }
}
