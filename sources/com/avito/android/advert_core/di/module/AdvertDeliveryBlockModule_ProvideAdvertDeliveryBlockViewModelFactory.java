package com.avito.android.advert_core.di.module;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.advert_core.delivery.AdvertDeliveryBlockViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class AdvertDeliveryBlockModule_ProvideAdvertDeliveryBlockViewModelFactory implements Factory<AdvertDeliveryBlockViewModel> {
    public final Provider<ViewModelProvider.Factory> a;
    public final Provider<LifecycleOwner> b;

    public AdvertDeliveryBlockModule_ProvideAdvertDeliveryBlockViewModelFactory(Provider<ViewModelProvider.Factory> provider, Provider<LifecycleOwner> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static AdvertDeliveryBlockModule_ProvideAdvertDeliveryBlockViewModelFactory create(Provider<ViewModelProvider.Factory> provider, Provider<LifecycleOwner> provider2) {
        return new AdvertDeliveryBlockModule_ProvideAdvertDeliveryBlockViewModelFactory(provider, provider2);
    }

    public static AdvertDeliveryBlockViewModel provideAdvertDeliveryBlockViewModel(ViewModelProvider.Factory factory, LifecycleOwner lifecycleOwner) {
        return (AdvertDeliveryBlockViewModel) Preconditions.checkNotNullFromProvides(AdvertDeliveryBlockModule.provideAdvertDeliveryBlockViewModel(factory, lifecycleOwner));
    }

    @Override // javax.inject.Provider
    public AdvertDeliveryBlockViewModel get() {
        return provideAdvertDeliveryBlockViewModel(this.a.get(), this.b.get());
    }
}
