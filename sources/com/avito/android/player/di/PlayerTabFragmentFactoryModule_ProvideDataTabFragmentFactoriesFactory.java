package com.avito.android.player.di;

import com.avito.android.bottom_navigation.DataTabFragmentFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Set;
public final class PlayerTabFragmentFactoryModule_ProvideDataTabFragmentFactoriesFactory implements Factory<Set<DataTabFragmentFactory>> {

    public static final class a {
        public static final PlayerTabFragmentFactoryModule_ProvideDataTabFragmentFactoriesFactory a = new PlayerTabFragmentFactoryModule_ProvideDataTabFragmentFactoriesFactory();
    }

    public static PlayerTabFragmentFactoryModule_ProvideDataTabFragmentFactoriesFactory create() {
        return a.a;
    }

    public static Set<DataTabFragmentFactory> provideDataTabFragmentFactories() {
        return (Set) Preconditions.checkNotNullFromProvides(PlayerTabFragmentFactoryModule.provideDataTabFragmentFactories());
    }

    @Override // javax.inject.Provider
    public Set<DataTabFragmentFactory> get() {
        return provideDataTabFragmentFactories();
    }
}
