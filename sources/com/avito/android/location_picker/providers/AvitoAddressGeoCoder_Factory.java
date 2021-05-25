package com.avito.android.location_picker.providers;

import com.avito.android.remote.LocationApi;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AvitoAddressGeoCoder_Factory implements Factory<AvitoAddressGeoCoder> {
    public final Provider<LocationApi> a;

    public AvitoAddressGeoCoder_Factory(Provider<LocationApi> provider) {
        this.a = provider;
    }

    public static AvitoAddressGeoCoder_Factory create(Provider<LocationApi> provider) {
        return new AvitoAddressGeoCoder_Factory(provider);
    }

    public static AvitoAddressGeoCoder newInstance(LocationApi locationApi) {
        return new AvitoAddressGeoCoder(locationApi);
    }

    @Override // javax.inject.Provider
    public AvitoAddressGeoCoder get() {
        return newInstance(this.a.get());
    }
}
