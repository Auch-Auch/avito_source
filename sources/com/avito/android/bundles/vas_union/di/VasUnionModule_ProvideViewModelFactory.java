package com.avito.android.bundles.vas_union.di;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.bundles.vas_union.viewmodel.VasUnionViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class VasUnionModule_ProvideViewModelFactory implements Factory<VasUnionViewModel> {
    public final Provider<Fragment> a;
    public final Provider<ViewModelProvider.Factory> b;

    public VasUnionModule_ProvideViewModelFactory(Provider<Fragment> provider, Provider<ViewModelProvider.Factory> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static VasUnionModule_ProvideViewModelFactory create(Provider<Fragment> provider, Provider<ViewModelProvider.Factory> provider2) {
        return new VasUnionModule_ProvideViewModelFactory(provider, provider2);
    }

    public static VasUnionViewModel provideViewModel(Fragment fragment, ViewModelProvider.Factory factory) {
        return (VasUnionViewModel) Preconditions.checkNotNullFromProvides(VasUnionModule.provideViewModel(fragment, factory));
    }

    @Override // javax.inject.Provider
    public VasUnionViewModel get() {
        return provideViewModel(this.a.get(), this.b.get());
    }
}
