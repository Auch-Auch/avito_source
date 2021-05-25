package com.avito.android.advert_core.di.module;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.advert_core.short_term_rent.AdvertStrBlockViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class AdvertStrBlockModule_ProvideAdvertStrBlockViewModelFactory implements Factory<AdvertStrBlockViewModel> {
    public final Provider<ViewModelProvider.Factory> a;
    public final Provider<FragmentActivity> b;

    public AdvertStrBlockModule_ProvideAdvertStrBlockViewModelFactory(Provider<ViewModelProvider.Factory> provider, Provider<FragmentActivity> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static AdvertStrBlockModule_ProvideAdvertStrBlockViewModelFactory create(Provider<ViewModelProvider.Factory> provider, Provider<FragmentActivity> provider2) {
        return new AdvertStrBlockModule_ProvideAdvertStrBlockViewModelFactory(provider, provider2);
    }

    public static AdvertStrBlockViewModel provideAdvertStrBlockViewModel(ViewModelProvider.Factory factory, FragmentActivity fragmentActivity) {
        return (AdvertStrBlockViewModel) Preconditions.checkNotNullFromProvides(AdvertStrBlockModule.provideAdvertStrBlockViewModel(factory, fragmentActivity));
    }

    @Override // javax.inject.Provider
    public AdvertStrBlockViewModel get() {
        return provideAdvertStrBlockViewModel(this.a.get(), this.b.get());
    }
}
