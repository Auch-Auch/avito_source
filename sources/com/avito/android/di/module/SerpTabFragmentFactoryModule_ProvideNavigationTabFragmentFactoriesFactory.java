package com.avito.android.di.module;

import com.avito.android.bottom_navigation.NavigationTabFragmentFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Set;
public final class SerpTabFragmentFactoryModule_ProvideNavigationTabFragmentFactoriesFactory implements Factory<Set<NavigationTabFragmentFactory>> {

    public static final class a {
        public static final SerpTabFragmentFactoryModule_ProvideNavigationTabFragmentFactoriesFactory a = new SerpTabFragmentFactoryModule_ProvideNavigationTabFragmentFactoriesFactory();
    }

    public static SerpTabFragmentFactoryModule_ProvideNavigationTabFragmentFactoriesFactory create() {
        return a.a;
    }

    public static Set<NavigationTabFragmentFactory> provideNavigationTabFragmentFactories() {
        return (Set) Preconditions.checkNotNullFromProvides(SerpTabFragmentFactoryModule.provideNavigationTabFragmentFactories());
    }

    @Override // javax.inject.Provider
    public Set<NavigationTabFragmentFactory> get() {
        return provideNavigationTabFragmentFactories();
    }
}
