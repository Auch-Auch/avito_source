package com.avito.android.messenger.map.sharing.di;

import com.avito.android.geo.GeoStorage;
import com.avito.android.location.find.DefaultLocationInteractor;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class SharingMapFragmentModule_ProvideDefaultLocationInteractorFactory implements Factory<DefaultLocationInteractor> {
    public final Provider<GeoStorage> a;

    public SharingMapFragmentModule_ProvideDefaultLocationInteractorFactory(Provider<GeoStorage> provider) {
        this.a = provider;
    }

    public static SharingMapFragmentModule_ProvideDefaultLocationInteractorFactory create(Provider<GeoStorage> provider) {
        return new SharingMapFragmentModule_ProvideDefaultLocationInteractorFactory(provider);
    }

    public static DefaultLocationInteractor provideDefaultLocationInteractor(GeoStorage geoStorage) {
        return (DefaultLocationInteractor) Preconditions.checkNotNullFromProvides(SharingMapFragmentModule.provideDefaultLocationInteractor(geoStorage));
    }

    @Override // javax.inject.Provider
    public DefaultLocationInteractor get() {
        return provideDefaultLocationInteractor(this.a.get());
    }
}
