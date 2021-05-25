package com.avito.android.advert_stats.di;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.advert_stats.AdvertStatsRepository;
import com.avito.android.advert_stats.AdvertStatsViewModelFactory;
import com.avito.android.advert_stats.item.StatisticsToItemsConverter;
import com.avito.android.advert_stats.tracker.AdvertStatsTracker;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.bivrost.BivrostTutorialSessionStorage;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class AdvertStatsModule_ProviderViewModuleFactoryFactory implements Factory<AdvertStatsViewModelFactory> {
    public final AdvertStatsModule a;
    public final Provider<SchedulersFactory> b;
    public final Provider<AdvertStatsRepository> c;
    public final Provider<StatisticsToItemsConverter> d;
    public final Provider<DeepLinkIntentFactory> e;
    public final Provider<ActivityIntentFactory> f;
    public final Provider<Analytics> g;
    public final Provider<AdvertStatsTracker> h;
    public final Provider<BivrostTutorialSessionStorage> i;

    public AdvertStatsModule_ProviderViewModuleFactoryFactory(AdvertStatsModule advertStatsModule, Provider<SchedulersFactory> provider, Provider<AdvertStatsRepository> provider2, Provider<StatisticsToItemsConverter> provider3, Provider<DeepLinkIntentFactory> provider4, Provider<ActivityIntentFactory> provider5, Provider<Analytics> provider6, Provider<AdvertStatsTracker> provider7, Provider<BivrostTutorialSessionStorage> provider8) {
        this.a = advertStatsModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
        this.e = provider4;
        this.f = provider5;
        this.g = provider6;
        this.h = provider7;
        this.i = provider8;
    }

    public static AdvertStatsModule_ProviderViewModuleFactoryFactory create(AdvertStatsModule advertStatsModule, Provider<SchedulersFactory> provider, Provider<AdvertStatsRepository> provider2, Provider<StatisticsToItemsConverter> provider3, Provider<DeepLinkIntentFactory> provider4, Provider<ActivityIntentFactory> provider5, Provider<Analytics> provider6, Provider<AdvertStatsTracker> provider7, Provider<BivrostTutorialSessionStorage> provider8) {
        return new AdvertStatsModule_ProviderViewModuleFactoryFactory(advertStatsModule, provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    public static AdvertStatsViewModelFactory providerViewModuleFactory(AdvertStatsModule advertStatsModule, SchedulersFactory schedulersFactory, AdvertStatsRepository advertStatsRepository, StatisticsToItemsConverter statisticsToItemsConverter, DeepLinkIntentFactory deepLinkIntentFactory, ActivityIntentFactory activityIntentFactory, Analytics analytics, AdvertStatsTracker advertStatsTracker, BivrostTutorialSessionStorage bivrostTutorialSessionStorage) {
        return (AdvertStatsViewModelFactory) Preconditions.checkNotNullFromProvides(advertStatsModule.providerViewModuleFactory(schedulersFactory, advertStatsRepository, statisticsToItemsConverter, deepLinkIntentFactory, activityIntentFactory, analytics, advertStatsTracker, bivrostTutorialSessionStorage));
    }

    @Override // javax.inject.Provider
    public AdvertStatsViewModelFactory get() {
        return providerViewModuleFactory(this.a, this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get(), this.i.get());
    }
}
