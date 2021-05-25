package com.avito.android.remote.parse.adapter;

import android.app.Application;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SearchDeviceResourcesProvider_Factory implements Factory<SearchDeviceResourcesProvider> {
    public final Provider<Application> a;

    public SearchDeviceResourcesProvider_Factory(Provider<Application> provider) {
        this.a = provider;
    }

    public static SearchDeviceResourcesProvider_Factory create(Provider<Application> provider) {
        return new SearchDeviceResourcesProvider_Factory(provider);
    }

    public static SearchDeviceResourcesProvider newInstance(Application application) {
        return new SearchDeviceResourcesProvider(application);
    }

    @Override // javax.inject.Provider
    public SearchDeviceResourcesProvider get() {
        return newInstance(this.a.get());
    }
}
