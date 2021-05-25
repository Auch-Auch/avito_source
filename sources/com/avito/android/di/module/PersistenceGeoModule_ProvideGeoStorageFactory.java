package com.avito.android.di.module;

import android.app.Application;
import com.avito.android.geo.GeoStorage;
import com.avito.android.util.preferences.PreferenceFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PersistenceGeoModule_ProvideGeoStorageFactory implements Factory<GeoStorage> {
    public final PersistenceGeoModule a;
    public final Provider<PreferenceFactory> b;
    public final Provider<Application> c;

    public PersistenceGeoModule_ProvideGeoStorageFactory(PersistenceGeoModule persistenceGeoModule, Provider<PreferenceFactory> provider, Provider<Application> provider2) {
        this.a = persistenceGeoModule;
        this.b = provider;
        this.c = provider2;
    }

    public static PersistenceGeoModule_ProvideGeoStorageFactory create(PersistenceGeoModule persistenceGeoModule, Provider<PreferenceFactory> provider, Provider<Application> provider2) {
        return new PersistenceGeoModule_ProvideGeoStorageFactory(persistenceGeoModule, provider, provider2);
    }

    public static GeoStorage provideGeoStorage(PersistenceGeoModule persistenceGeoModule, PreferenceFactory preferenceFactory, Application application) {
        return (GeoStorage) Preconditions.checkNotNullFromProvides(persistenceGeoModule.provideGeoStorage(preferenceFactory, application));
    }

    @Override // javax.inject.Provider
    public GeoStorage get() {
        return provideGeoStorage(this.a, this.b.get(), this.c.get());
    }
}
