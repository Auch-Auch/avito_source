package com.avito.android.vas_performance.di.applied_services;

import androidx.lifecycle.ViewModelProvider;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.vas_performance.AppliedServicesConverter;
import com.avito.android.vas_performance.repository.VasRepository;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class AppliedServicesModule_ProvideVmFactoryFactory implements Factory<ViewModelProvider.Factory> {
    public final AppliedServicesModule a;
    public final Provider<VasRepository> b;
    public final Provider<AppliedServicesConverter> c;
    public final Provider<DeepLinkIntentFactory> d;
    public final Provider<SchedulersFactory> e;

    public AppliedServicesModule_ProvideVmFactoryFactory(AppliedServicesModule appliedServicesModule, Provider<VasRepository> provider, Provider<AppliedServicesConverter> provider2, Provider<DeepLinkIntentFactory> provider3, Provider<SchedulersFactory> provider4) {
        this.a = appliedServicesModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
        this.e = provider4;
    }

    public static AppliedServicesModule_ProvideVmFactoryFactory create(AppliedServicesModule appliedServicesModule, Provider<VasRepository> provider, Provider<AppliedServicesConverter> provider2, Provider<DeepLinkIntentFactory> provider3, Provider<SchedulersFactory> provider4) {
        return new AppliedServicesModule_ProvideVmFactoryFactory(appliedServicesModule, provider, provider2, provider3, provider4);
    }

    public static ViewModelProvider.Factory provideVmFactory(AppliedServicesModule appliedServicesModule, VasRepository vasRepository, AppliedServicesConverter appliedServicesConverter, DeepLinkIntentFactory deepLinkIntentFactory, SchedulersFactory schedulersFactory) {
        return (ViewModelProvider.Factory) Preconditions.checkNotNullFromProvides(appliedServicesModule.provideVmFactory(vasRepository, appliedServicesConverter, deepLinkIntentFactory, schedulersFactory));
    }

    @Override // javax.inject.Provider
    public ViewModelProvider.Factory get() {
        return provideVmFactory(this.a, this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
