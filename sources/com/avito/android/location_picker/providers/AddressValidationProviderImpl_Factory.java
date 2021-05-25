package com.avito.android.location_picker.providers;

import com.avito.android.remote.LocationApi;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AddressValidationProviderImpl_Factory implements Factory<AddressValidationProviderImpl> {
    public final Provider<LocationApi> a;

    public AddressValidationProviderImpl_Factory(Provider<LocationApi> provider) {
        this.a = provider;
    }

    public static AddressValidationProviderImpl_Factory create(Provider<LocationApi> provider) {
        return new AddressValidationProviderImpl_Factory(provider);
    }

    public static AddressValidationProviderImpl newInstance(LocationApi locationApi) {
        return new AddressValidationProviderImpl(locationApi);
    }

    @Override // javax.inject.Provider
    public AddressValidationProviderImpl get() {
        return newInstance(this.a.get());
    }
}
