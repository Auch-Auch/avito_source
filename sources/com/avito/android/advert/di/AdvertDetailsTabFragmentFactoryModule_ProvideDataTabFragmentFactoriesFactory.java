package com.avito.android.advert.di;

import com.avito.android.bottom_navigation.DataTabFragmentFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Set;
public final class AdvertDetailsTabFragmentFactoryModule_ProvideDataTabFragmentFactoriesFactory implements Factory<Set<DataTabFragmentFactory>> {

    public static final class a {
        public static final AdvertDetailsTabFragmentFactoryModule_ProvideDataTabFragmentFactoriesFactory a = new AdvertDetailsTabFragmentFactoryModule_ProvideDataTabFragmentFactoriesFactory();
    }

    public static AdvertDetailsTabFragmentFactoryModule_ProvideDataTabFragmentFactoriesFactory create() {
        return a.a;
    }

    public static Set<DataTabFragmentFactory> provideDataTabFragmentFactories() {
        return (Set) Preconditions.checkNotNullFromProvides(AdvertDetailsTabFragmentFactoryModule.provideDataTabFragmentFactories());
    }

    @Override // javax.inject.Provider
    public Set<DataTabFragmentFactory> get() {
        return provideDataTabFragmentFactories();
    }
}
