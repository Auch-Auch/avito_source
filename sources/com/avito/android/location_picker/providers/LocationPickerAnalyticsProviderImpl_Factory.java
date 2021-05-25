package com.avito.android.location_picker.providers;

import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.publish.PublishAnalyticsDataProvider;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class LocationPickerAnalyticsProviderImpl_Factory implements Factory<LocationPickerAnalyticsProviderImpl> {
    public final Provider<Analytics> a;
    public final Provider<PublishAnalyticsDataProvider> b;

    public LocationPickerAnalyticsProviderImpl_Factory(Provider<Analytics> provider, Provider<PublishAnalyticsDataProvider> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static LocationPickerAnalyticsProviderImpl_Factory create(Provider<Analytics> provider, Provider<PublishAnalyticsDataProvider> provider2) {
        return new LocationPickerAnalyticsProviderImpl_Factory(provider, provider2);
    }

    public static LocationPickerAnalyticsProviderImpl newInstance(Analytics analytics, PublishAnalyticsDataProvider publishAnalyticsDataProvider) {
        return new LocationPickerAnalyticsProviderImpl(analytics, publishAnalyticsDataProvider);
    }

    @Override // javax.inject.Provider
    public LocationPickerAnalyticsProviderImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
