package com.avito.android.bundles.di;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.bundles.viewmodel.VasBundlesViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class VasBundlesModule_ProvideViewModelFactory implements Factory<VasBundlesViewModel> {
    public final Provider<Fragment> a;
    public final Provider<ViewModelProvider.Factory> b;

    public VasBundlesModule_ProvideViewModelFactory(Provider<Fragment> provider, Provider<ViewModelProvider.Factory> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static VasBundlesModule_ProvideViewModelFactory create(Provider<Fragment> provider, Provider<ViewModelProvider.Factory> provider2) {
        return new VasBundlesModule_ProvideViewModelFactory(provider, provider2);
    }

    public static VasBundlesViewModel provideViewModel(Fragment fragment, ViewModelProvider.Factory factory) {
        return (VasBundlesViewModel) Preconditions.checkNotNullFromProvides(VasBundlesModule.provideViewModel(fragment, factory));
    }

    @Override // javax.inject.Provider
    public VasBundlesViewModel get() {
        return provideViewModel(this.a.get(), this.b.get());
    }
}
