package com.avito.android.advert_stats.di;

import com.avito.android.advert_stats.AdvertStatsViewModel;
import com.avito.android.advert_stats.AdvertStatsViewModelFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class AdvertStatsModule_ProvideViewodelFactory implements Factory<AdvertStatsViewModel> {
    public final AdvertStatsModule a;
    public final Provider<AdvertStatsViewModelFactory> b;

    public AdvertStatsModule_ProvideViewodelFactory(AdvertStatsModule advertStatsModule, Provider<AdvertStatsViewModelFactory> provider) {
        this.a = advertStatsModule;
        this.b = provider;
    }

    public static AdvertStatsModule_ProvideViewodelFactory create(AdvertStatsModule advertStatsModule, Provider<AdvertStatsViewModelFactory> provider) {
        return new AdvertStatsModule_ProvideViewodelFactory(advertStatsModule, provider);
    }

    public static AdvertStatsViewModel provideViewodel(AdvertStatsModule advertStatsModule, AdvertStatsViewModelFactory advertStatsViewModelFactory) {
        return (AdvertStatsViewModel) Preconditions.checkNotNullFromProvides(advertStatsModule.provideViewodel(advertStatsViewModelFactory));
    }

    @Override // javax.inject.Provider
    public AdvertStatsViewModel get() {
        return provideViewodel(this.a, this.b.get());
    }
}
