package com.avito.android.vas_performance.di.applied_services;

import androidx.lifecycle.ViewModelProvider;
import com.avito.android.vas_performance.ui.applied_services.AppliedServicesViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class AppliedServicesModule_ProvideViewModelFactory implements Factory<AppliedServicesViewModel> {
    public final AppliedServicesModule a;
    public final Provider<ViewModelProvider.Factory> b;

    public AppliedServicesModule_ProvideViewModelFactory(AppliedServicesModule appliedServicesModule, Provider<ViewModelProvider.Factory> provider) {
        this.a = appliedServicesModule;
        this.b = provider;
    }

    public static AppliedServicesModule_ProvideViewModelFactory create(AppliedServicesModule appliedServicesModule, Provider<ViewModelProvider.Factory> provider) {
        return new AppliedServicesModule_ProvideViewModelFactory(appliedServicesModule, provider);
    }

    public static AppliedServicesViewModel provideViewModel(AppliedServicesModule appliedServicesModule, ViewModelProvider.Factory factory) {
        return (AppliedServicesViewModel) Preconditions.checkNotNullFromProvides(appliedServicesModule.provideViewModel(factory));
    }

    @Override // javax.inject.Provider
    public AppliedServicesViewModel get() {
        return provideViewModel(this.a, this.b.get());
    }
}
