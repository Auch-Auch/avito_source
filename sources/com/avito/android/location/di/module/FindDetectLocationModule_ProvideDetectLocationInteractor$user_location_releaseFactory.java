package com.avito.android.location.di.module;

import com.avito.android.geo.GeoStorage;
import com.avito.android.location.find.DetectLocationInteractor;
import com.avito.android.location.find.util.DetectLocationHelper;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class FindDetectLocationModule_ProvideDetectLocationInteractor$user_location_releaseFactory implements Factory<DetectLocationInteractor> {
    public final Provider<DetectLocationHelper> a;
    public final Provider<SchedulersFactory> b;
    public final Provider<GeoStorage> c;

    public FindDetectLocationModule_ProvideDetectLocationInteractor$user_location_releaseFactory(Provider<DetectLocationHelper> provider, Provider<SchedulersFactory> provider2, Provider<GeoStorage> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static FindDetectLocationModule_ProvideDetectLocationInteractor$user_location_releaseFactory create(Provider<DetectLocationHelper> provider, Provider<SchedulersFactory> provider2, Provider<GeoStorage> provider3) {
        return new FindDetectLocationModule_ProvideDetectLocationInteractor$user_location_releaseFactory(provider, provider2, provider3);
    }

    public static DetectLocationInteractor provideDetectLocationInteractor$user_location_release(DetectLocationHelper detectLocationHelper, SchedulersFactory schedulersFactory, GeoStorage geoStorage) {
        return (DetectLocationInteractor) Preconditions.checkNotNullFromProvides(FindDetectLocationModule.provideDetectLocationInteractor$user_location_release(detectLocationHelper, schedulersFactory, geoStorage));
    }

    @Override // javax.inject.Provider
    public DetectLocationInteractor get() {
        return provideDetectLocationInteractor$user_location_release(this.a.get(), this.b.get(), this.c.get());
    }
}
