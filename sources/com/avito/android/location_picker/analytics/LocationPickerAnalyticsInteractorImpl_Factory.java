package com.avito.android.location_picker.analytics;

import com.avito.android.analytics.Analytics;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class LocationPickerAnalyticsInteractorImpl_Factory implements Factory<LocationPickerAnalyticsInteractorImpl> {
    public final Provider<Analytics> a;

    public LocationPickerAnalyticsInteractorImpl_Factory(Provider<Analytics> provider) {
        this.a = provider;
    }

    public static LocationPickerAnalyticsInteractorImpl_Factory create(Provider<Analytics> provider) {
        return new LocationPickerAnalyticsInteractorImpl_Factory(provider);
    }

    public static LocationPickerAnalyticsInteractorImpl newInstance(Analytics analytics) {
        return new LocationPickerAnalyticsInteractorImpl(analytics);
    }

    @Override // javax.inject.Provider
    public LocationPickerAnalyticsInteractorImpl get() {
        return newInstance(this.a.get());
    }
}
