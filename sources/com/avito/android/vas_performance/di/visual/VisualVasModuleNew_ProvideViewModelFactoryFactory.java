package com.avito.android.vas_performance.di.visual;

import androidx.lifecycle.ViewModelProvider;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.vas_performance.VisualVasConverter;
import com.avito.android.vas_performance.repository.VasRepository;
import com.avito.android.vas_performance.tracker.VisualVasTracker;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class VisualVasModuleNew_ProvideViewModelFactoryFactory implements Factory<ViewModelProvider.Factory> {
    public final VisualVasModuleNew a;
    public final Provider<VasRepository> b;
    public final Provider<VisualVasConverter> c;
    public final Provider<SchedulersFactory> d;
    public final Provider<VisualVasTracker> e;

    public VisualVasModuleNew_ProvideViewModelFactoryFactory(VisualVasModuleNew visualVasModuleNew, Provider<VasRepository> provider, Provider<VisualVasConverter> provider2, Provider<SchedulersFactory> provider3, Provider<VisualVasTracker> provider4) {
        this.a = visualVasModuleNew;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
        this.e = provider4;
    }

    public static VisualVasModuleNew_ProvideViewModelFactoryFactory create(VisualVasModuleNew visualVasModuleNew, Provider<VasRepository> provider, Provider<VisualVasConverter> provider2, Provider<SchedulersFactory> provider3, Provider<VisualVasTracker> provider4) {
        return new VisualVasModuleNew_ProvideViewModelFactoryFactory(visualVasModuleNew, provider, provider2, provider3, provider4);
    }

    public static ViewModelProvider.Factory provideViewModelFactory(VisualVasModuleNew visualVasModuleNew, VasRepository vasRepository, VisualVasConverter visualVasConverter, SchedulersFactory schedulersFactory, VisualVasTracker visualVasTracker) {
        return (ViewModelProvider.Factory) Preconditions.checkNotNullFromProvides(visualVasModuleNew.provideViewModelFactory(vasRepository, visualVasConverter, schedulersFactory, visualVasTracker));
    }

    @Override // javax.inject.Provider
    public ViewModelProvider.Factory get() {
        return provideViewModelFactory(this.a, this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
