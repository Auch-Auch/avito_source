package com.avito.android.geo;

import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class GeoService_MembersInjector implements MembersInjector<GeoService> {
    public final Provider<GeoPositionModel> a;

    public GeoService_MembersInjector(Provider<GeoPositionModel> provider) {
        this.a = provider;
    }

    public static MembersInjector<GeoService> create(Provider<GeoPositionModel> provider) {
        return new GeoService_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.avito.android.geo.GeoService.geoPositionModel")
    public static void injectGeoPositionModel(GeoService geoService, GeoPositionModel geoPositionModel) {
        geoService.b = geoPositionModel;
    }

    public void injectMembers(GeoService geoService) {
        injectGeoPositionModel(geoService, this.a.get());
    }
}
