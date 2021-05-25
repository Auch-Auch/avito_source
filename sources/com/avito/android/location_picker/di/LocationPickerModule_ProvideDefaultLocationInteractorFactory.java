package com.avito.android.location_picker.di;

import com.avito.android.geo.GeoStorage;
import com.avito.android.location.find.DefaultLocationInteractor;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class LocationPickerModule_ProvideDefaultLocationInteractorFactory implements Factory<DefaultLocationInteractor> {
    public final Provider<GeoStorage> a;

    public LocationPickerModule_ProvideDefaultLocationInteractorFactory(Provider<GeoStorage> provider) {
        this.a = provider;
    }

    public static LocationPickerModule_ProvideDefaultLocationInteractorFactory create(Provider<GeoStorage> provider) {
        return new LocationPickerModule_ProvideDefaultLocationInteractorFactory(provider);
    }

    public static DefaultLocationInteractor provideDefaultLocationInteractor(GeoStorage geoStorage) {
        return (DefaultLocationInteractor) Preconditions.checkNotNullFromProvides(LocationPickerModule.INSTANCE.provideDefaultLocationInteractor(geoStorage));
    }

    @Override // javax.inject.Provider
    public DefaultLocationInteractor get() {
        return provideDefaultLocationInteractor(this.a.get());
    }
}
