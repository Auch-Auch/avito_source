package com.avito.android.location.di.module;

import com.avito.android.location.find.DefaultLocationInteractor;
import com.avito.android.location.find.DefaultLocationProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class FindDetectLocationModule_ProvideDefaultLocationProviderFactory implements Factory<DefaultLocationProvider> {
    public final Provider<DefaultLocationInteractor> a;

    public FindDetectLocationModule_ProvideDefaultLocationProviderFactory(Provider<DefaultLocationInteractor> provider) {
        this.a = provider;
    }

    public static FindDetectLocationModule_ProvideDefaultLocationProviderFactory create(Provider<DefaultLocationInteractor> provider) {
        return new FindDetectLocationModule_ProvideDefaultLocationProviderFactory(provider);
    }

    public static DefaultLocationProvider provideDefaultLocationProvider(DefaultLocationInteractor defaultLocationInteractor) {
        return (DefaultLocationProvider) Preconditions.checkNotNullFromProvides(FindDetectLocationModule.provideDefaultLocationProvider(defaultLocationInteractor));
    }

    @Override // javax.inject.Provider
    public DefaultLocationProvider get() {
        return provideDefaultLocationProvider(this.a.get());
    }
}
