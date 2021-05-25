package com.avito.android.vas_performance.ui.applied_services;

import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.vas_performance.AppliedServicesConverter;
import com.avito.android.vas_performance.repository.VasRepository;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AppliedServicesViewModelFactory_Factory implements Factory<AppliedServicesViewModelFactory> {
    public final Provider<String> a;
    public final Provider<VasRepository> b;
    public final Provider<AppliedServicesConverter> c;
    public final Provider<DeepLinkIntentFactory> d;
    public final Provider<SchedulersFactory> e;

    public AppliedServicesViewModelFactory_Factory(Provider<String> provider, Provider<VasRepository> provider2, Provider<AppliedServicesConverter> provider3, Provider<DeepLinkIntentFactory> provider4, Provider<SchedulersFactory> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static AppliedServicesViewModelFactory_Factory create(Provider<String> provider, Provider<VasRepository> provider2, Provider<AppliedServicesConverter> provider3, Provider<DeepLinkIntentFactory> provider4, Provider<SchedulersFactory> provider5) {
        return new AppliedServicesViewModelFactory_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static AppliedServicesViewModelFactory newInstance(String str, VasRepository vasRepository, AppliedServicesConverter appliedServicesConverter, DeepLinkIntentFactory deepLinkIntentFactory, SchedulersFactory schedulersFactory) {
        return new AppliedServicesViewModelFactory(str, vasRepository, appliedServicesConverter, deepLinkIntentFactory, schedulersFactory);
    }

    @Override // javax.inject.Provider
    public AppliedServicesViewModelFactory get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
