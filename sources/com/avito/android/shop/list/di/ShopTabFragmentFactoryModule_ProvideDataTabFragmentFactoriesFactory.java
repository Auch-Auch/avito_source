package com.avito.android.shop.list.di;

import com.avito.android.ab_tests.configs.UserAdvertsTabTestGroup;
import com.avito.android.bottom_navigation.DataTabFragmentFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Set;
import javax.inject.Provider;
public final class ShopTabFragmentFactoryModule_ProvideDataTabFragmentFactoriesFactory implements Factory<Set<DataTabFragmentFactory>> {
    public final Provider<UserAdvertsTabTestGroup> a;

    public ShopTabFragmentFactoryModule_ProvideDataTabFragmentFactoriesFactory(Provider<UserAdvertsTabTestGroup> provider) {
        this.a = provider;
    }

    public static ShopTabFragmentFactoryModule_ProvideDataTabFragmentFactoriesFactory create(Provider<UserAdvertsTabTestGroup> provider) {
        return new ShopTabFragmentFactoryModule_ProvideDataTabFragmentFactoriesFactory(provider);
    }

    public static Set<DataTabFragmentFactory> provideDataTabFragmentFactories(UserAdvertsTabTestGroup userAdvertsTabTestGroup) {
        return (Set) Preconditions.checkNotNullFromProvides(ShopTabFragmentFactoryModule.provideDataTabFragmentFactories(userAdvertsTabTestGroup));
    }

    @Override // javax.inject.Provider
    public Set<DataTabFragmentFactory> get() {
        return provideDataTabFragmentFactories(this.a.get());
    }
}
