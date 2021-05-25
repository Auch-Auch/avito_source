package com.avito.android.user_adverts.di;

import com.avito.android.bottom_navigation.NavigationTabFragmentFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Set;
public final class UserAdvertsTabFragmentFactoryModule_ProvideProfileNavigationTabFragmentFactoriesFactory implements Factory<Set<NavigationTabFragmentFactory>> {

    public static final class a {
        public static final UserAdvertsTabFragmentFactoryModule_ProvideProfileNavigationTabFragmentFactoriesFactory a = new UserAdvertsTabFragmentFactoryModule_ProvideProfileNavigationTabFragmentFactoriesFactory();
    }

    public static UserAdvertsTabFragmentFactoryModule_ProvideProfileNavigationTabFragmentFactoriesFactory create() {
        return a.a;
    }

    public static Set<NavigationTabFragmentFactory> provideProfileNavigationTabFragmentFactories() {
        return (Set) Preconditions.checkNotNullFromProvides(UserAdvertsTabFragmentFactoryModule.provideProfileNavigationTabFragmentFactories());
    }

    @Override // javax.inject.Provider
    public Set<NavigationTabFragmentFactory> get() {
        return provideProfileNavigationTabFragmentFactories();
    }
}
