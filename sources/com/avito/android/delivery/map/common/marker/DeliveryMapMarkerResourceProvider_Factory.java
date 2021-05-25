package com.avito.android.delivery.map.common.marker;

import dagger.internal.Factory;
public final class DeliveryMapMarkerResourceProvider_Factory implements Factory<DeliveryMapMarkerResourceProvider> {

    public static final class a {
        public static final DeliveryMapMarkerResourceProvider_Factory a = new DeliveryMapMarkerResourceProvider_Factory();
    }

    public static DeliveryMapMarkerResourceProvider_Factory create() {
        return a.a;
    }

    public static DeliveryMapMarkerResourceProvider newInstance() {
        return new DeliveryMapMarkerResourceProvider();
    }

    @Override // javax.inject.Provider
    public DeliveryMapMarkerResourceProvider get() {
        return newInstance();
    }
}
