package com.avito.android.delivery.map.common;

import com.avito.android.delivery.map.common.marker.MarkerLabelManager;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class DeliveryMapViewPresenterFactory_Factory implements Factory<DeliveryMapViewPresenterFactory> {
    public final Provider<DeliveryLocationInteractor> a;
    public final Provider<SchedulersFactory3> b;
    public final Provider<DeliveryMapResourceProvider> c;
    public final Provider<MarkerLabelManager> d;

    public DeliveryMapViewPresenterFactory_Factory(Provider<DeliveryLocationInteractor> provider, Provider<SchedulersFactory3> provider2, Provider<DeliveryMapResourceProvider> provider3, Provider<MarkerLabelManager> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static DeliveryMapViewPresenterFactory_Factory create(Provider<DeliveryLocationInteractor> provider, Provider<SchedulersFactory3> provider2, Provider<DeliveryMapResourceProvider> provider3, Provider<MarkerLabelManager> provider4) {
        return new DeliveryMapViewPresenterFactory_Factory(provider, provider2, provider3, provider4);
    }

    public static DeliveryMapViewPresenterFactory newInstance(DeliveryLocationInteractor deliveryLocationInteractor, SchedulersFactory3 schedulersFactory3, DeliveryMapResourceProvider deliveryMapResourceProvider, MarkerLabelManager markerLabelManager) {
        return new DeliveryMapViewPresenterFactory(deliveryLocationInteractor, schedulersFactory3, deliveryMapResourceProvider, markerLabelManager);
    }

    @Override // javax.inject.Provider
    public DeliveryMapViewPresenterFactory get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
