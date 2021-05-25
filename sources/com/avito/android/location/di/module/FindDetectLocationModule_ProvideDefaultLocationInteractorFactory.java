package com.avito.android.location.di.module;

import com.avito.android.geo.GeoStorage;
import com.avito.android.location.find.DefaultLocationInteractor;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class FindDetectLocationModule_ProvideDefaultLocationInteractorFactory implements Factory<DefaultLocationInteractor> {
    public final Provider<GeoStorage> a;

    public FindDetectLocationModule_ProvideDefaultLocationInteractorFactory(Provider<GeoStorage> provider) {
        this.a = provider;
    }

    public static FindDetectLocationModule_ProvideDefaultLocationInteractorFactory create(Provider<GeoStorage> provider) {
        return new FindDetectLocationModule_ProvideDefaultLocationInteractorFactory(provider);
    }

    public static DefaultLocationInteractor provideDefaultLocationInteractor(GeoStorage geoStorage) {
        return (DefaultLocationInteractor) Preconditions.checkNotNullFromProvides(FindDetectLocationModule.provideDefaultLocationInteractor(geoStorage));
    }

    @Override // javax.inject.Provider
    public DefaultLocationInteractor get() {
        return provideDefaultLocationInteractor(this.a.get());
    }
}
