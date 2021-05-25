package com.avito.android.publish.di;

import com.avito.android.ab_tests.AbTestsConfigProvider;
import com.avito.android.bottom_navigation.NavigationTabFragmentFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Set;
import javax.inject.Provider;
public final class PublishTabFragmentFactoryModule_ProvideNavigationTabFragmentFactoriesFactory implements Factory<Set<NavigationTabFragmentFactory>> {
    public final Provider<AbTestsConfigProvider> a;

    public PublishTabFragmentFactoryModule_ProvideNavigationTabFragmentFactoriesFactory(Provider<AbTestsConfigProvider> provider) {
        this.a = provider;
    }

    public static PublishTabFragmentFactoryModule_ProvideNavigationTabFragmentFactoriesFactory create(Provider<AbTestsConfigProvider> provider) {
        return new PublishTabFragmentFactoryModule_ProvideNavigationTabFragmentFactoriesFactory(provider);
    }

    public static Set<NavigationTabFragmentFactory> provideNavigationTabFragmentFactories(AbTestsConfigProvider abTestsConfigProvider) {
        return (Set) Preconditions.checkNotNullFromProvides(PublishTabFragmentFactoryModule.provideNavigationTabFragmentFactories(abTestsConfigProvider));
    }

    @Override // javax.inject.Provider
    public Set<NavigationTabFragmentFactory> get() {
        return provideNavigationTabFragmentFactories(this.a.get());
    }
}
