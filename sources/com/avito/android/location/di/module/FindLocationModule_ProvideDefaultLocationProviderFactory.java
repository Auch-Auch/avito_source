package com.avito.android.location.di.module;

import com.avito.android.location.find.DefaultLocationInteractor;
import com.avito.android.location.find.DefaultLocationProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class FindLocationModule_ProvideDefaultLocationProviderFactory implements Factory<DefaultLocationProvider> {
    public final Provider<DefaultLocationInteractor> a;

    public FindLocationModule_ProvideDefaultLocationProviderFactory(Provider<DefaultLocationInteractor> provider) {
        this.a = provider;
    }

    public static FindLocationModule_ProvideDefaultLocationProviderFactory create(Provider<DefaultLocationInteractor> provider) {
        return new FindLocationModule_ProvideDefaultLocationProviderFactory(provider);
    }

    public static DefaultLocationProvider provideDefaultLocationProvider(DefaultLocationInteractor defaultLocationInteractor) {
        return (DefaultLocationProvider) Preconditions.checkNotNullFromProvides(FindLocationModule.provideDefaultLocationProvider(defaultLocationInteractor));
    }

    @Override // javax.inject.Provider
    public DefaultLocationProvider get() {
        return provideDefaultLocationProvider(this.a.get());
    }
}
