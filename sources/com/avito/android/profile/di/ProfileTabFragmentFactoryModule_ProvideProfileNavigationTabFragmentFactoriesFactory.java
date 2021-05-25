package com.avito.android.profile.di;

import com.avito.android.bottom_navigation.NavigationTabFragmentFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Set;
public final class ProfileTabFragmentFactoryModule_ProvideProfileNavigationTabFragmentFactoriesFactory implements Factory<Set<NavigationTabFragmentFactory>> {

    public static final class a {
        public static final ProfileTabFragmentFactoryModule_ProvideProfileNavigationTabFragmentFactoriesFactory a = new ProfileTabFragmentFactoryModule_ProvideProfileNavigationTabFragmentFactoriesFactory();
    }

    public static ProfileTabFragmentFactoryModule_ProvideProfileNavigationTabFragmentFactoriesFactory create() {
        return a.a;
    }

    public static Set<NavigationTabFragmentFactory> provideProfileNavigationTabFragmentFactories() {
        return (Set) Preconditions.checkNotNullFromProvides(ProfileTabFragmentFactoryModule.provideProfileNavigationTabFragmentFactories());
    }

    @Override // javax.inject.Provider
    public Set<NavigationTabFragmentFactory> get() {
        return provideProfileNavigationTabFragmentFactories();
    }
}
