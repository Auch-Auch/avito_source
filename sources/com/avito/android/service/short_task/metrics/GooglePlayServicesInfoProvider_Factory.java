package com.avito.android.service.short_task.metrics;

import com.avito.android.util.GooglePlayServicesInfo;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class GooglePlayServicesInfoProvider_Factory implements Factory<GooglePlayServicesInfoProvider> {
    public final Provider<GooglePlayServicesInfo> a;

    public GooglePlayServicesInfoProvider_Factory(Provider<GooglePlayServicesInfo> provider) {
        this.a = provider;
    }

    public static GooglePlayServicesInfoProvider_Factory create(Provider<GooglePlayServicesInfo> provider) {
        return new GooglePlayServicesInfoProvider_Factory(provider);
    }

    public static GooglePlayServicesInfoProvider newInstance(GooglePlayServicesInfo googlePlayServicesInfo) {
        return new GooglePlayServicesInfoProvider(googlePlayServicesInfo);
    }

    @Override // javax.inject.Provider
    public GooglePlayServicesInfoProvider get() {
        return newInstance(this.a.get());
    }
}
