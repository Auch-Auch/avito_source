package com.avito.android.advert_stats.di;

import com.avito.android.Features;
import com.avito.android.advert_stats.AdvertStatsRepository;
import com.avito.android.advert_stats.remote.AdvertStatsApi;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class AdvertStatsModule_ProviderInteractorFactory implements Factory<AdvertStatsRepository> {
    public final AdvertStatsModule a;
    public final Provider<AdvertStatsApi> b;
    public final Provider<SchedulersFactory> c;
    public final Provider<Features> d;

    public AdvertStatsModule_ProviderInteractorFactory(AdvertStatsModule advertStatsModule, Provider<AdvertStatsApi> provider, Provider<SchedulersFactory> provider2, Provider<Features> provider3) {
        this.a = advertStatsModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
    }

    public static AdvertStatsModule_ProviderInteractorFactory create(AdvertStatsModule advertStatsModule, Provider<AdvertStatsApi> provider, Provider<SchedulersFactory> provider2, Provider<Features> provider3) {
        return new AdvertStatsModule_ProviderInteractorFactory(advertStatsModule, provider, provider2, provider3);
    }

    public static AdvertStatsRepository providerInteractor(AdvertStatsModule advertStatsModule, AdvertStatsApi advertStatsApi, SchedulersFactory schedulersFactory, Features features) {
        return (AdvertStatsRepository) Preconditions.checkNotNullFromProvides(advertStatsModule.providerInteractor(advertStatsApi, schedulersFactory, features));
    }

    @Override // javax.inject.Provider
    public AdvertStatsRepository get() {
        return providerInteractor(this.a, this.b.get(), this.c.get(), this.d.get());
    }
}
