package com.avito.android.location_picker.providers;

import com.avito.android.remote.SearchRadiusApi;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class RadiusListProviderImpl_Factory implements Factory<RadiusListProviderImpl> {
    public final Provider<SearchRadiusApi> a;

    public RadiusListProviderImpl_Factory(Provider<SearchRadiusApi> provider) {
        this.a = provider;
    }

    public static RadiusListProviderImpl_Factory create(Provider<SearchRadiusApi> provider) {
        return new RadiusListProviderImpl_Factory(provider);
    }

    public static RadiusListProviderImpl newInstance(SearchRadiusApi searchRadiusApi) {
        return new RadiusListProviderImpl(searchRadiusApi);
    }

    @Override // javax.inject.Provider
    public RadiusListProviderImpl get() {
        return newInstance(this.a.get());
    }
}
