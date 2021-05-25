package com.avito.android.short_term_rent.hotels.dialogs.location;

import com.avito.android.remote.model.hotels.HotelsLocation;
import com.avito.android.short_term_rent.hotels.data.HotelsRepository;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import java.util.List;
import javax.inject.Provider;
public final class HotelsLocationViewModelFactory_Factory implements Factory<HotelsLocationViewModelFactory> {
    public final Provider<HotelsRepository> a;
    public final Provider<SchedulersFactory3> b;
    public final Provider<List<HotelsLocation>> c;

    public HotelsLocationViewModelFactory_Factory(Provider<HotelsRepository> provider, Provider<SchedulersFactory3> provider2, Provider<List<HotelsLocation>> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static HotelsLocationViewModelFactory_Factory create(Provider<HotelsRepository> provider, Provider<SchedulersFactory3> provider2, Provider<List<HotelsLocation>> provider3) {
        return new HotelsLocationViewModelFactory_Factory(provider, provider2, provider3);
    }

    public static HotelsLocationViewModelFactory newInstance(HotelsRepository hotelsRepository, SchedulersFactory3 schedulersFactory3, List<HotelsLocation> list) {
        return new HotelsLocationViewModelFactory(hotelsRepository, schedulersFactory3, list);
    }

    @Override // javax.inject.Provider
    public HotelsLocationViewModelFactory get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
