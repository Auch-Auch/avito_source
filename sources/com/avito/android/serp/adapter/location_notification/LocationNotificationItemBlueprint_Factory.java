package com.avito.android.serp.adapter.location_notification;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class LocationNotificationItemBlueprint_Factory implements Factory<LocationNotificationItemBlueprint> {
    public final Provider<LocationNotificationItemPresenter> a;

    public LocationNotificationItemBlueprint_Factory(Provider<LocationNotificationItemPresenter> provider) {
        this.a = provider;
    }

    public static LocationNotificationItemBlueprint_Factory create(Provider<LocationNotificationItemPresenter> provider) {
        return new LocationNotificationItemBlueprint_Factory(provider);
    }

    public static LocationNotificationItemBlueprint newInstance(LocationNotificationItemPresenter locationNotificationItemPresenter) {
        return new LocationNotificationItemBlueprint(locationNotificationItemPresenter);
    }

    @Override // javax.inject.Provider
    public LocationNotificationItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
