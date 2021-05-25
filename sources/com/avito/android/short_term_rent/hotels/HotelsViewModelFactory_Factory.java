package com.avito.android.short_term_rent.hotels;

import com.avito.android.analytics.Analytics;
import com.avito.android.short_term_rent.hotels.data.HotelsRepository;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class HotelsViewModelFactory_Factory implements Factory<HotelsViewModelFactory> {
    public final Provider<String> a;
    public final Provider<HotelsRepository> b;
    public final Provider<SchedulersFactory3> c;
    public final Provider<Analytics> d;

    public HotelsViewModelFactory_Factory(Provider<String> provider, Provider<HotelsRepository> provider2, Provider<SchedulersFactory3> provider3, Provider<Analytics> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static HotelsViewModelFactory_Factory create(Provider<String> provider, Provider<HotelsRepository> provider2, Provider<SchedulersFactory3> provider3, Provider<Analytics> provider4) {
        return new HotelsViewModelFactory_Factory(provider, provider2, provider3, provider4);
    }

    public static HotelsViewModelFactory newInstance(String str, HotelsRepository hotelsRepository, SchedulersFactory3 schedulersFactory3, Analytics analytics) {
        return new HotelsViewModelFactory(str, hotelsRepository, schedulersFactory3, analytics);
    }

    @Override // javax.inject.Provider
    public HotelsViewModelFactory get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
