package com.avito.android.suggest_locations;

import com.avito.android.remote.LocationApi;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SuggestLocationsInteractorImpl_Factory implements Factory<SuggestLocationsInteractorImpl> {
    public final Provider<LocationApi> a;
    public final Provider<SchedulersFactory3> b;
    public final Provider<SuggestLocationsItemsConverter> c;

    public SuggestLocationsInteractorImpl_Factory(Provider<LocationApi> provider, Provider<SchedulersFactory3> provider2, Provider<SuggestLocationsItemsConverter> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static SuggestLocationsInteractorImpl_Factory create(Provider<LocationApi> provider, Provider<SchedulersFactory3> provider2, Provider<SuggestLocationsItemsConverter> provider3) {
        return new SuggestLocationsInteractorImpl_Factory(provider, provider2, provider3);
    }

    public static SuggestLocationsInteractorImpl newInstance(LocationApi locationApi, SchedulersFactory3 schedulersFactory3, SuggestLocationsItemsConverter suggestLocationsItemsConverter) {
        return new SuggestLocationsInteractorImpl(locationApi, schedulersFactory3, suggestLocationsItemsConverter);
    }

    @Override // javax.inject.Provider
    public SuggestLocationsInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
