package com.avito.android.location_picker;

import com.avito.android.location.find.DefaultLocationInteractor;
import com.avito.android.location_picker.analytics.LocationPickerAnalyticsInteractor;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class LocationPickerActivity_MembersInjector implements MembersInjector<LocationPickerActivity> {
    public final Provider<LocationPickerBinder> a;
    public final Provider<LocationPickerAnalyticsInteractor> b;
    public final Provider<DefaultLocationInteractor> c;

    public LocationPickerActivity_MembersInjector(Provider<LocationPickerBinder> provider, Provider<LocationPickerAnalyticsInteractor> provider2, Provider<DefaultLocationInteractor> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static MembersInjector<LocationPickerActivity> create(Provider<LocationPickerBinder> provider, Provider<LocationPickerAnalyticsInteractor> provider2, Provider<DefaultLocationInteractor> provider3) {
        return new LocationPickerActivity_MembersInjector(provider, provider2, provider3);
    }

    @InjectedFieldSignature("com.avito.android.location_picker.LocationPickerActivity.analyticsInteractor")
    public static void injectAnalyticsInteractor(LocationPickerActivity locationPickerActivity, LocationPickerAnalyticsInteractor locationPickerAnalyticsInteractor) {
        locationPickerActivity.analyticsInteractor = locationPickerAnalyticsInteractor;
    }

    @InjectedFieldSignature("com.avito.android.location_picker.LocationPickerActivity.binder")
    public static void injectBinder(LocationPickerActivity locationPickerActivity, LocationPickerBinder locationPickerBinder) {
        locationPickerActivity.binder = locationPickerBinder;
    }

    @InjectedFieldSignature("com.avito.android.location_picker.LocationPickerActivity.defaultLocationInteractor")
    public static void injectDefaultLocationInteractor(LocationPickerActivity locationPickerActivity, DefaultLocationInteractor defaultLocationInteractor) {
        locationPickerActivity.defaultLocationInteractor = defaultLocationInteractor;
    }

    public void injectMembers(LocationPickerActivity locationPickerActivity) {
        injectBinder(locationPickerActivity, this.a.get());
        injectAnalyticsInteractor(locationPickerActivity, this.b.get());
        injectDefaultLocationInteractor(locationPickerActivity, this.c.get());
    }
}
