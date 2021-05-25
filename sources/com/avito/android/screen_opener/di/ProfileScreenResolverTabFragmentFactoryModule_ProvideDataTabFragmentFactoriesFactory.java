package com.avito.android.screen_opener.di;

import com.avito.android.bottom_navigation.DataTabFragmentFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Set;
public final class ProfileScreenResolverTabFragmentFactoryModule_ProvideDataTabFragmentFactoriesFactory implements Factory<Set<DataTabFragmentFactory>> {

    public static final class a {
        public static final ProfileScreenResolverTabFragmentFactoryModule_ProvideDataTabFragmentFactoriesFactory a = new ProfileScreenResolverTabFragmentFactoryModule_ProvideDataTabFragmentFactoriesFactory();
    }

    public static ProfileScreenResolverTabFragmentFactoryModule_ProvideDataTabFragmentFactoriesFactory create() {
        return a.a;
    }

    public static Set<DataTabFragmentFactory> provideDataTabFragmentFactories() {
        return (Set) Preconditions.checkNotNullFromProvides(ProfileScreenResolverTabFragmentFactoryModule.provideDataTabFragmentFactories());
    }

    @Override // javax.inject.Provider
    public Set<DataTabFragmentFactory> get() {
        return provideDataTabFragmentFactories();
    }
}
