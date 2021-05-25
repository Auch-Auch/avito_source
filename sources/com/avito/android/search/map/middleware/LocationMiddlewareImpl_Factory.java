package com.avito.android.search.map.middleware;

import android.app.Activity;
import com.avito.android.location.find.FindLocationPresenter;
import com.avito.android.permissions.LocationPermissionProvider;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class LocationMiddlewareImpl_Factory implements Factory<LocationMiddlewareImpl> {
    public final Provider<LocationPermissionProvider> a;
    public final Provider<FindLocationPresenter> b;
    public final Provider<Activity> c;

    public LocationMiddlewareImpl_Factory(Provider<LocationPermissionProvider> provider, Provider<FindLocationPresenter> provider2, Provider<Activity> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static LocationMiddlewareImpl_Factory create(Provider<LocationPermissionProvider> provider, Provider<FindLocationPresenter> provider2, Provider<Activity> provider3) {
        return new LocationMiddlewareImpl_Factory(provider, provider2, provider3);
    }

    public static LocationMiddlewareImpl newInstance(LocationPermissionProvider locationPermissionProvider, FindLocationPresenter findLocationPresenter, Activity activity) {
        return new LocationMiddlewareImpl(locationPermissionProvider, findLocationPresenter, activity);
    }

    @Override // javax.inject.Provider
    public LocationMiddlewareImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
