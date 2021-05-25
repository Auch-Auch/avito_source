package com.avito.android.publish.di;

import com.avito.android.ab_tests.AbTestsConfigProvider;
import com.avito.android.bottom_navigation.DataTabFragmentFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Set;
import javax.inject.Provider;
public final class PublishTabFragmentFactoryModule_ProvideDataTabFragmentFactoriesFactory implements Factory<Set<DataTabFragmentFactory>> {
    public final Provider<AbTestsConfigProvider> a;

    public PublishTabFragmentFactoryModule_ProvideDataTabFragmentFactoriesFactory(Provider<AbTestsConfigProvider> provider) {
        this.a = provider;
    }

    public static PublishTabFragmentFactoryModule_ProvideDataTabFragmentFactoriesFactory create(Provider<AbTestsConfigProvider> provider) {
        return new PublishTabFragmentFactoryModule_ProvideDataTabFragmentFactoriesFactory(provider);
    }

    public static Set<DataTabFragmentFactory> provideDataTabFragmentFactories(AbTestsConfigProvider abTestsConfigProvider) {
        return (Set) Preconditions.checkNotNullFromProvides(PublishTabFragmentFactoryModule.provideDataTabFragmentFactories(abTestsConfigProvider));
    }

    @Override // javax.inject.Provider
    public Set<DataTabFragmentFactory> get() {
        return provideDataTabFragmentFactories(this.a.get());
    }
}
