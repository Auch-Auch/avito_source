package com.avito.android.extended_profile.di;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.extended_profile.ExtendedProfileViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ExtendedProfileModule_ProvideViewModelFactory implements Factory<ExtendedProfileViewModel> {
    public final Provider<Fragment> a;
    public final Provider<ViewModelProvider.Factory> b;

    public ExtendedProfileModule_ProvideViewModelFactory(Provider<Fragment> provider, Provider<ViewModelProvider.Factory> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static ExtendedProfileModule_ProvideViewModelFactory create(Provider<Fragment> provider, Provider<ViewModelProvider.Factory> provider2) {
        return new ExtendedProfileModule_ProvideViewModelFactory(provider, provider2);
    }

    public static ExtendedProfileViewModel provideViewModel(Fragment fragment, ViewModelProvider.Factory factory) {
        return (ExtendedProfileViewModel) Preconditions.checkNotNullFromProvides(ExtendedProfileModule.provideViewModel(fragment, factory));
    }

    @Override // javax.inject.Provider
    public ExtendedProfileViewModel get() {
        return provideViewModel(this.a.get(), this.b.get());
    }
}
