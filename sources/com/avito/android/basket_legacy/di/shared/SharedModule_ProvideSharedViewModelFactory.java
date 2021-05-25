package com.avito.android.basket_legacy.di.shared;

import com.avito.android.basket_legacy.viewmodels.shared.SharedBasketViewModel;
import com.avito.android.basket_legacy.viewmodels.shared.SharedBasketViewModelFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class SharedModule_ProvideSharedViewModelFactory implements Factory<SharedBasketViewModel> {
    public final SharedModule a;
    public final Provider<SharedBasketViewModelFactory> b;

    public SharedModule_ProvideSharedViewModelFactory(SharedModule sharedModule, Provider<SharedBasketViewModelFactory> provider) {
        this.a = sharedModule;
        this.b = provider;
    }

    public static SharedModule_ProvideSharedViewModelFactory create(SharedModule sharedModule, Provider<SharedBasketViewModelFactory> provider) {
        return new SharedModule_ProvideSharedViewModelFactory(sharedModule, provider);
    }

    public static SharedBasketViewModel provideSharedViewModel(SharedModule sharedModule, SharedBasketViewModelFactory sharedBasketViewModelFactory) {
        return (SharedBasketViewModel) Preconditions.checkNotNullFromProvides(sharedModule.provideSharedViewModel(sharedBasketViewModelFactory));
    }

    @Override // javax.inject.Provider
    public SharedBasketViewModel get() {
        return provideSharedViewModel(this.a, this.b.get());
    }
}
