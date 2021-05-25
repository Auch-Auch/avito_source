package com.avito.android.user_adverts.di;

import com.avito.android.bottom_navigation.NavigationTabFragmentFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Set;
public final class UserAdvertsTabFragmentFactoryModule_ProvideUserAdvertsNavigationTabFragmentFactoriesFactory implements Factory<Set<NavigationTabFragmentFactory>> {

    public static final class a {
        public static final UserAdvertsTabFragmentFactoryModule_ProvideUserAdvertsNavigationTabFragmentFactoriesFactory a = new UserAdvertsTabFragmentFactoryModule_ProvideUserAdvertsNavigationTabFragmentFactoriesFactory();
    }

    public static UserAdvertsTabFragmentFactoryModule_ProvideUserAdvertsNavigationTabFragmentFactoriesFactory create() {
        return a.a;
    }

    public static Set<NavigationTabFragmentFactory> provideUserAdvertsNavigationTabFragmentFactories() {
        return (Set) Preconditions.checkNotNullFromProvides(UserAdvertsTabFragmentFactoryModule.provideUserAdvertsNavigationTabFragmentFactories());
    }

    @Override // javax.inject.Provider
    public Set<NavigationTabFragmentFactory> get() {
        return provideUserAdvertsNavigationTabFragmentFactories();
    }
}
