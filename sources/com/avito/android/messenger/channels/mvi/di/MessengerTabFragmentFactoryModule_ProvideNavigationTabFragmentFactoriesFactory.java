package com.avito.android.messenger.channels.mvi.di;

import com.avito.android.bottom_navigation.NavigationTabFragmentFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Set;
public final class MessengerTabFragmentFactoryModule_ProvideNavigationTabFragmentFactoriesFactory implements Factory<Set<NavigationTabFragmentFactory>> {

    public static final class a {
        public static final MessengerTabFragmentFactoryModule_ProvideNavigationTabFragmentFactoriesFactory a = new MessengerTabFragmentFactoryModule_ProvideNavigationTabFragmentFactoriesFactory();
    }

    public static MessengerTabFragmentFactoryModule_ProvideNavigationTabFragmentFactoriesFactory create() {
        return a.a;
    }

    public static Set<NavigationTabFragmentFactory> provideNavigationTabFragmentFactories() {
        return (Set) Preconditions.checkNotNullFromProvides(MessengerTabFragmentFactoryModule.provideNavigationTabFragmentFactories());
    }

    @Override // javax.inject.Provider
    public Set<NavigationTabFragmentFactory> get() {
        return provideNavigationTabFragmentFactories();
    }
}
