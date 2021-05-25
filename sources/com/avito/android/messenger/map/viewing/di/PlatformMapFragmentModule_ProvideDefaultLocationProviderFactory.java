package com.avito.android.messenger.map.viewing.di;

import com.avito.android.location.find.DefaultLocationInteractor;
import com.avito.android.location.find.DefaultLocationProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PlatformMapFragmentModule_ProvideDefaultLocationProviderFactory implements Factory<DefaultLocationProvider> {
    public final Provider<DefaultLocationInteractor> a;

    public PlatformMapFragmentModule_ProvideDefaultLocationProviderFactory(Provider<DefaultLocationInteractor> provider) {
        this.a = provider;
    }

    public static PlatformMapFragmentModule_ProvideDefaultLocationProviderFactory create(Provider<DefaultLocationInteractor> provider) {
        return new PlatformMapFragmentModule_ProvideDefaultLocationProviderFactory(provider);
    }

    public static DefaultLocationProvider provideDefaultLocationProvider(DefaultLocationInteractor defaultLocationInteractor) {
        return (DefaultLocationProvider) Preconditions.checkNotNullFromProvides(PlatformMapFragmentModule.provideDefaultLocationProvider(defaultLocationInteractor));
    }

    @Override // javax.inject.Provider
    public DefaultLocationProvider get() {
        return provideDefaultLocationProvider(this.a.get());
    }
}
