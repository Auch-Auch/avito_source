package com.avito.android.messenger.map.sharing.di;

import com.avito.android.location.find.DefaultLocationInteractor;
import com.avito.android.location.find.DefaultLocationProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class SharingMapFragmentModule_ProvideDefaultLocationProviderFactory implements Factory<DefaultLocationProvider> {
    public final Provider<DefaultLocationInteractor> a;

    public SharingMapFragmentModule_ProvideDefaultLocationProviderFactory(Provider<DefaultLocationInteractor> provider) {
        this.a = provider;
    }

    public static SharingMapFragmentModule_ProvideDefaultLocationProviderFactory create(Provider<DefaultLocationInteractor> provider) {
        return new SharingMapFragmentModule_ProvideDefaultLocationProviderFactory(provider);
    }

    public static DefaultLocationProvider provideDefaultLocationProvider(DefaultLocationInteractor defaultLocationInteractor) {
        return (DefaultLocationProvider) Preconditions.checkNotNullFromProvides(SharingMapFragmentModule.provideDefaultLocationProvider(defaultLocationInteractor));
    }

    @Override // javax.inject.Provider
    public DefaultLocationProvider get() {
        return provideDefaultLocationProvider(this.a.get());
    }
}
