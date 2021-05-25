package com.avito.android.profile.di;

import com.avito.android.bottom_navigation.DataTabFragmentFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Set;
public final class ProfileTabFragmentFactoryModule_ProvideDataTabFragmentFactoriesFactory implements Factory<Set<DataTabFragmentFactory>> {

    public static final class a {
        public static final ProfileTabFragmentFactoryModule_ProvideDataTabFragmentFactoriesFactory a = new ProfileTabFragmentFactoryModule_ProvideDataTabFragmentFactoriesFactory();
    }

    public static ProfileTabFragmentFactoryModule_ProvideDataTabFragmentFactoriesFactory create() {
        return a.a;
    }

    public static Set<DataTabFragmentFactory> provideDataTabFragmentFactories() {
        return (Set) Preconditions.checkNotNullFromProvides(ProfileTabFragmentFactoryModule.provideDataTabFragmentFactories());
    }

    @Override // javax.inject.Provider
    public Set<DataTabFragmentFactory> get() {
        return provideDataTabFragmentFactories();
    }
}
