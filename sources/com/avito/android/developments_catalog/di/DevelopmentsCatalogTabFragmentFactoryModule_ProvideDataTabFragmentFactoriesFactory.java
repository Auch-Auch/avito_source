package com.avito.android.developments_catalog.di;

import com.avito.android.bottom_navigation.DataTabFragmentFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Set;
public final class DevelopmentsCatalogTabFragmentFactoryModule_ProvideDataTabFragmentFactoriesFactory implements Factory<Set<DataTabFragmentFactory>> {

    public static final class a {
        public static final DevelopmentsCatalogTabFragmentFactoryModule_ProvideDataTabFragmentFactoriesFactory a = new DevelopmentsCatalogTabFragmentFactoryModule_ProvideDataTabFragmentFactoriesFactory();
    }

    public static DevelopmentsCatalogTabFragmentFactoryModule_ProvideDataTabFragmentFactoriesFactory create() {
        return a.a;
    }

    public static Set<DataTabFragmentFactory> provideDataTabFragmentFactories() {
        return (Set) Preconditions.checkNotNullFromProvides(DevelopmentsCatalogTabFragmentFactoryModule.provideDataTabFragmentFactories());
    }

    @Override // javax.inject.Provider
    public Set<DataTabFragmentFactory> get() {
        return provideDataTabFragmentFactories();
    }
}
