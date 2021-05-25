package com.avito.android.profile_phones;

import com.avito.android.bottom_navigation.DataTabFragmentFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Set;
public final class PhonesTabFragmentFactoryModule_ProvidePhonesTabFragmentFactoriesFactory implements Factory<Set<DataTabFragmentFactory>> {

    public static final class a {
        public static final PhonesTabFragmentFactoryModule_ProvidePhonesTabFragmentFactoriesFactory a = new PhonesTabFragmentFactoryModule_ProvidePhonesTabFragmentFactoriesFactory();
    }

    public static PhonesTabFragmentFactoryModule_ProvidePhonesTabFragmentFactoriesFactory create() {
        return a.a;
    }

    public static Set<DataTabFragmentFactory> providePhonesTabFragmentFactories() {
        return (Set) Preconditions.checkNotNullFromProvides(PhonesTabFragmentFactoryModule.providePhonesTabFragmentFactories());
    }

    @Override // javax.inject.Provider
    public Set<DataTabFragmentFactory> get() {
        return providePhonesTabFragmentFactories();
    }
}
