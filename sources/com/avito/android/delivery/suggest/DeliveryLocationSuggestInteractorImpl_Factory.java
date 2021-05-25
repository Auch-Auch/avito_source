package com.avito.android.delivery.suggest;

import com.avito.android.location_picker.providers.AddressGeoCoder;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class DeliveryLocationSuggestInteractorImpl_Factory implements Factory<DeliveryLocationSuggestInteractorImpl> {
    public final Provider<AddressGeoCoder> a;
    public final Provider<SchedulersFactory3> b;

    public DeliveryLocationSuggestInteractorImpl_Factory(Provider<AddressGeoCoder> provider, Provider<SchedulersFactory3> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static DeliveryLocationSuggestInteractorImpl_Factory create(Provider<AddressGeoCoder> provider, Provider<SchedulersFactory3> provider2) {
        return new DeliveryLocationSuggestInteractorImpl_Factory(provider, provider2);
    }

    public static DeliveryLocationSuggestInteractorImpl newInstance(AddressGeoCoder addressGeoCoder, SchedulersFactory3 schedulersFactory3) {
        return new DeliveryLocationSuggestInteractorImpl(addressGeoCoder, schedulersFactory3);
    }

    @Override // javax.inject.Provider
    public DeliveryLocationSuggestInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
