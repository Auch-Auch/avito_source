package com.avito.android.vas_performance.di.perfomance;

import androidx.lifecycle.ViewModelProvider;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.vas_performance.PerformanceVasConverter;
import com.avito.android.vas_performance.repository.VasRepository;
import com.avito.android.vas_performance.tracker.PerformanceVasTracker;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PerformanceVasModuleNew_ProvideViewModelFactoryFactory implements Factory<ViewModelProvider.Factory> {
    public final PerformanceVasModuleNew a;
    public final Provider<VasRepository> b;
    public final Provider<SchedulersFactory> c;
    public final Provider<PerformanceVasConverter> d;
    public final Provider<PerformanceVasTracker> e;

    public PerformanceVasModuleNew_ProvideViewModelFactoryFactory(PerformanceVasModuleNew performanceVasModuleNew, Provider<VasRepository> provider, Provider<SchedulersFactory> provider2, Provider<PerformanceVasConverter> provider3, Provider<PerformanceVasTracker> provider4) {
        this.a = performanceVasModuleNew;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
        this.e = provider4;
    }

    public static PerformanceVasModuleNew_ProvideViewModelFactoryFactory create(PerformanceVasModuleNew performanceVasModuleNew, Provider<VasRepository> provider, Provider<SchedulersFactory> provider2, Provider<PerformanceVasConverter> provider3, Provider<PerformanceVasTracker> provider4) {
        return new PerformanceVasModuleNew_ProvideViewModelFactoryFactory(performanceVasModuleNew, provider, provider2, provider3, provider4);
    }

    public static ViewModelProvider.Factory provideViewModelFactory(PerformanceVasModuleNew performanceVasModuleNew, VasRepository vasRepository, SchedulersFactory schedulersFactory, PerformanceVasConverter performanceVasConverter, PerformanceVasTracker performanceVasTracker) {
        return (ViewModelProvider.Factory) Preconditions.checkNotNullFromProvides(performanceVasModuleNew.provideViewModelFactory(vasRepository, schedulersFactory, performanceVasConverter, performanceVasTracker));
    }

    @Override // javax.inject.Provider
    public ViewModelProvider.Factory get() {
        return provideViewModelFactory(this.a, this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
