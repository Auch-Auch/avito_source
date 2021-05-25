package com.avito.android.advert.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import ru.sravni.android.bankproduct.network.di.SravniNetworkConfiguration;
public final class SravniConfigurationModule_SravniConfigurationFactory implements Factory<SravniNetworkConfiguration> {

    public static final class a {
        public static final SravniConfigurationModule_SravniConfigurationFactory a = new SravniConfigurationModule_SravniConfigurationFactory();
    }

    public static SravniConfigurationModule_SravniConfigurationFactory create() {
        return a.a;
    }

    public static SravniNetworkConfiguration sravniConfiguration() {
        return (SravniNetworkConfiguration) Preconditions.checkNotNullFromProvides(SravniConfigurationModule.INSTANCE.sravniConfiguration());
    }

    @Override // javax.inject.Provider
    public SravniNetworkConfiguration get() {
        return sravniConfiguration();
    }
}
