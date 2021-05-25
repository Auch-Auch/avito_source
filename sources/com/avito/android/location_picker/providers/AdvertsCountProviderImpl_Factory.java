package com.avito.android.location_picker.providers;

import com.avito.android.remote.SearchRadiusApi;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertsCountProviderImpl_Factory implements Factory<AdvertsCountProviderImpl> {
    public final Provider<SearchRadiusApi> a;

    public AdvertsCountProviderImpl_Factory(Provider<SearchRadiusApi> provider) {
        this.a = provider;
    }

    public static AdvertsCountProviderImpl_Factory create(Provider<SearchRadiusApi> provider) {
        return new AdvertsCountProviderImpl_Factory(provider);
    }

    public static AdvertsCountProviderImpl newInstance(SearchRadiusApi searchRadiusApi) {
        return new AdvertsCountProviderImpl(searchRadiusApi);
    }

    @Override // javax.inject.Provider
    public AdvertsCountProviderImpl get() {
        return newInstance(this.a.get());
    }
}
