package com.avito.android.basket_legacy.di.shared;

import com.avito.android.basket_legacy.viewmodels.activity.BasketViewModel;
import com.avito.android.basket_legacy.viewmodels.activity.BasketViewModelFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class SharedModule_ProvideBasketViewModelFactory implements Factory<BasketViewModel> {
    public final SharedModule a;
    public final Provider<BasketViewModelFactory> b;

    public SharedModule_ProvideBasketViewModelFactory(SharedModule sharedModule, Provider<BasketViewModelFactory> provider) {
        this.a = sharedModule;
        this.b = provider;
    }

    public static SharedModule_ProvideBasketViewModelFactory create(SharedModule sharedModule, Provider<BasketViewModelFactory> provider) {
        return new SharedModule_ProvideBasketViewModelFactory(sharedModule, provider);
    }

    public static BasketViewModel provideBasketViewModel(SharedModule sharedModule, BasketViewModelFactory basketViewModelFactory) {
        return (BasketViewModel) Preconditions.checkNotNullFromProvides(sharedModule.provideBasketViewModel(basketViewModelFactory));
    }

    @Override // javax.inject.Provider
    public BasketViewModel get() {
        return provideBasketViewModel(this.a, this.b.get());
    }
}
