package com.avito.android.serp.adapter.location_notification;

import com.jakewharton.rxrelay3.Relay;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class LocationNotificationItemPresenterImpl_Factory implements Factory<LocationNotificationItemPresenterImpl> {
    public final Provider<Relay<LocationNotificationActionData>> a;
    public final Provider<Relay<LocationNotificationActionData>> b;

    public LocationNotificationItemPresenterImpl_Factory(Provider<Relay<LocationNotificationActionData>> provider, Provider<Relay<LocationNotificationActionData>> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static LocationNotificationItemPresenterImpl_Factory create(Provider<Relay<LocationNotificationActionData>> provider, Provider<Relay<LocationNotificationActionData>> provider2) {
        return new LocationNotificationItemPresenterImpl_Factory(provider, provider2);
    }

    public static LocationNotificationItemPresenterImpl newInstance(Relay<LocationNotificationActionData> relay, Relay<LocationNotificationActionData> relay2) {
        return new LocationNotificationItemPresenterImpl(relay, relay2);
    }

    @Override // javax.inject.Provider
    public LocationNotificationItemPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
