package com.avito.android.di.module;

import com.avito.android.remote.LocationApi;
import com.avito.android.remote.RetrofitFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class LocationApiModule_ProvideLocationApiFactory implements Factory<LocationApi> {
    public final Provider<RetrofitFactory> a;

    public LocationApiModule_ProvideLocationApiFactory(Provider<RetrofitFactory> provider) {
        this.a = provider;
    }

    public static LocationApiModule_ProvideLocationApiFactory create(Provider<RetrofitFactory> provider) {
        return new LocationApiModule_ProvideLocationApiFactory(provider);
    }

    public static LocationApi provideLocationApi(RetrofitFactory retrofitFactory) {
        return (LocationApi) Preconditions.checkNotNullFromProvides(LocationApiModule.INSTANCE.provideLocationApi(retrofitFactory));
    }

    @Override // javax.inject.Provider
    public LocationApi get() {
        return provideLocationApi(this.a.get());
    }
}
