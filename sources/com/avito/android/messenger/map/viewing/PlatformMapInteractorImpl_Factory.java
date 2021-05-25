package com.avito.android.messenger.map.viewing;

import com.avito.android.remote.model.messenger.geo.GeoMarker;
import com.avito.android.remote.model.messenger.geo.MarkersRequest;
import dagger.internal.Factory;
import javax.inject.Provider;
import ru.avito.messenger.MessengerClient;
import ru.avito.messenger.api.AvitoMessengerApi;
public final class PlatformMapInteractorImpl_Factory implements Factory<PlatformMapInteractorImpl> {
    public final Provider<GeoMarker[]> a;
    public final Provider<MessengerClient<AvitoMessengerApi>> b;
    public final Provider<MarkersRequest> c;

    public PlatformMapInteractorImpl_Factory(Provider<GeoMarker[]> provider, Provider<MessengerClient<AvitoMessengerApi>> provider2, Provider<MarkersRequest> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static PlatformMapInteractorImpl_Factory create(Provider<GeoMarker[]> provider, Provider<MessengerClient<AvitoMessengerApi>> provider2, Provider<MarkersRequest> provider3) {
        return new PlatformMapInteractorImpl_Factory(provider, provider2, provider3);
    }

    public static PlatformMapInteractorImpl newInstance(GeoMarker[] geoMarkerArr, MessengerClient<AvitoMessengerApi> messengerClient, MarkersRequest markersRequest) {
        return new PlatformMapInteractorImpl(geoMarkerArr, messengerClient, markersRequest);
    }

    @Override // javax.inject.Provider
    public PlatformMapInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
