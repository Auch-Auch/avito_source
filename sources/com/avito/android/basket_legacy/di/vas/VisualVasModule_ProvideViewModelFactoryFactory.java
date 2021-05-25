package com.avito.android.basket_legacy.di.vas;

import com.avito.android.basket_legacy.repositories.BasketRepository;
import com.avito.android.basket_legacy.viewmodels.vas.visual.LegacyVisualVasViewModelFactory;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.vas_performance.StringProvider;
import com.avito.android.vas_performance.VisualVasConverter;
import com.avito.android.vas_performance.repository.VasRepository;
import com.avito.android.vas_performance.tracker.VisualVasTracker;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class VisualVasModule_ProvideViewModelFactoryFactory implements Factory<LegacyVisualVasViewModelFactory> {
    public final VisualVasModule a;
    public final Provider<String> b;
    public final Provider<VasRepository> c;
    public final Provider<BasketRepository> d;
    public final Provider<VisualVasConverter> e;
    public final Provider<SchedulersFactory> f;
    public final Provider<StringProvider> g;
    public final Provider<VisualVasTracker> h;

    public VisualVasModule_ProvideViewModelFactoryFactory(VisualVasModule visualVasModule, Provider<String> provider, Provider<VasRepository> provider2, Provider<BasketRepository> provider3, Provider<VisualVasConverter> provider4, Provider<SchedulersFactory> provider5, Provider<StringProvider> provider6, Provider<VisualVasTracker> provider7) {
        this.a = visualVasModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
        this.e = provider4;
        this.f = provider5;
        this.g = provider6;
        this.h = provider7;
    }

    public static VisualVasModule_ProvideViewModelFactoryFactory create(VisualVasModule visualVasModule, Provider<String> provider, Provider<VasRepository> provider2, Provider<BasketRepository> provider3, Provider<VisualVasConverter> provider4, Provider<SchedulersFactory> provider5, Provider<StringProvider> provider6, Provider<VisualVasTracker> provider7) {
        return new VisualVasModule_ProvideViewModelFactoryFactory(visualVasModule, provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static LegacyVisualVasViewModelFactory provideViewModelFactory(VisualVasModule visualVasModule, String str, VasRepository vasRepository, BasketRepository basketRepository, VisualVasConverter visualVasConverter, SchedulersFactory schedulersFactory, StringProvider stringProvider, VisualVasTracker visualVasTracker) {
        return (LegacyVisualVasViewModelFactory) Preconditions.checkNotNullFromProvides(visualVasModule.provideViewModelFactory(str, vasRepository, basketRepository, visualVasConverter, schedulersFactory, stringProvider, visualVasTracker));
    }

    @Override // javax.inject.Provider
    public LegacyVisualVasViewModelFactory get() {
        return provideViewModelFactory(this.a, this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get());
    }
}
