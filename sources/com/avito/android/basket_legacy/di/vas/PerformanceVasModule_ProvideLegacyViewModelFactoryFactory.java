package com.avito.android.basket_legacy.di.vas;

import com.avito.android.analytics.Analytics;
import com.avito.android.basket_legacy.repositories.BasketRepository;
import com.avito.android.basket_legacy.viewmodels.vas.performance.LegacyPerformanceVasViewModelFactory;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.vas_performance.PerformanceVasConverter;
import com.avito.android.vas_performance.repository.VasRepository;
import com.avito.android.vas_performance.tracker.PerformanceVasTracker;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PerformanceVasModule_ProvideLegacyViewModelFactoryFactory implements Factory<LegacyPerformanceVasViewModelFactory> {
    public final PerformanceVasModule a;
    public final Provider<String> b;
    public final Provider<VasRepository> c;
    public final Provider<BasketRepository> d;
    public final Provider<PerformanceVasConverter> e;
    public final Provider<SchedulersFactory> f;
    public final Provider<PerformanceVasTracker> g;
    public final Provider<Analytics> h;

    public PerformanceVasModule_ProvideLegacyViewModelFactoryFactory(PerformanceVasModule performanceVasModule, Provider<String> provider, Provider<VasRepository> provider2, Provider<BasketRepository> provider3, Provider<PerformanceVasConverter> provider4, Provider<SchedulersFactory> provider5, Provider<PerformanceVasTracker> provider6, Provider<Analytics> provider7) {
        this.a = performanceVasModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
        this.e = provider4;
        this.f = provider5;
        this.g = provider6;
        this.h = provider7;
    }

    public static PerformanceVasModule_ProvideLegacyViewModelFactoryFactory create(PerformanceVasModule performanceVasModule, Provider<String> provider, Provider<VasRepository> provider2, Provider<BasketRepository> provider3, Provider<PerformanceVasConverter> provider4, Provider<SchedulersFactory> provider5, Provider<PerformanceVasTracker> provider6, Provider<Analytics> provider7) {
        return new PerformanceVasModule_ProvideLegacyViewModelFactoryFactory(performanceVasModule, provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static LegacyPerformanceVasViewModelFactory provideLegacyViewModelFactory(PerformanceVasModule performanceVasModule, String str, VasRepository vasRepository, BasketRepository basketRepository, PerformanceVasConverter performanceVasConverter, SchedulersFactory schedulersFactory, PerformanceVasTracker performanceVasTracker, Analytics analytics) {
        return (LegacyPerformanceVasViewModelFactory) Preconditions.checkNotNullFromProvides(performanceVasModule.provideLegacyViewModelFactory(str, vasRepository, basketRepository, performanceVasConverter, schedulersFactory, performanceVasTracker, analytics));
    }

    @Override // javax.inject.Provider
    public LegacyPerformanceVasViewModelFactory get() {
        return provideLegacyViewModelFactory(this.a, this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get());
    }
}
