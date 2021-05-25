package com.avito.android.order.di.module;

import com.avito.android.bottom_navigation.DataTabFragmentFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Set;
public final class OrderTabFragmentFactoryModule_ProvideDataTabFragmentFactoriesFactory implements Factory<Set<DataTabFragmentFactory>> {

    public static final class a {
        public static final OrderTabFragmentFactoryModule_ProvideDataTabFragmentFactoriesFactory a = new OrderTabFragmentFactoryModule_ProvideDataTabFragmentFactoriesFactory();
    }

    public static OrderTabFragmentFactoryModule_ProvideDataTabFragmentFactoriesFactory create() {
        return a.a;
    }

    public static Set<DataTabFragmentFactory> provideDataTabFragmentFactories() {
        return (Set) Preconditions.checkNotNullFromProvides(OrderTabFragmentFactoryModule.INSTANCE.provideDataTabFragmentFactories());
    }

    @Override // javax.inject.Provider
    public Set<DataTabFragmentFactory> get() {
        return provideDataTabFragmentFactories();
    }
}
