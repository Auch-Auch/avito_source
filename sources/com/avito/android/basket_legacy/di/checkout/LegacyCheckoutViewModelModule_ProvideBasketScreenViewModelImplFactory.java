package com.avito.android.basket_legacy.di.checkout;

import com.avito.android.basket_legacy.viewmodels.checkout.LegacyCheckoutViewModel;
import com.avito.android.basket_legacy.viewmodels.checkout.LegacyCheckoutViewModelFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class LegacyCheckoutViewModelModule_ProvideBasketScreenViewModelImplFactory implements Factory<LegacyCheckoutViewModel> {
    public final LegacyCheckoutViewModelModule a;
    public final Provider<LegacyCheckoutViewModelFactory> b;

    public LegacyCheckoutViewModelModule_ProvideBasketScreenViewModelImplFactory(LegacyCheckoutViewModelModule legacyCheckoutViewModelModule, Provider<LegacyCheckoutViewModelFactory> provider) {
        this.a = legacyCheckoutViewModelModule;
        this.b = provider;
    }

    public static LegacyCheckoutViewModelModule_ProvideBasketScreenViewModelImplFactory create(LegacyCheckoutViewModelModule legacyCheckoutViewModelModule, Provider<LegacyCheckoutViewModelFactory> provider) {
        return new LegacyCheckoutViewModelModule_ProvideBasketScreenViewModelImplFactory(legacyCheckoutViewModelModule, provider);
    }

    public static LegacyCheckoutViewModel provideBasketScreenViewModelImpl(LegacyCheckoutViewModelModule legacyCheckoutViewModelModule, LegacyCheckoutViewModelFactory legacyCheckoutViewModelFactory) {
        return (LegacyCheckoutViewModel) Preconditions.checkNotNullFromProvides(legacyCheckoutViewModelModule.provideBasketScreenViewModelImpl(legacyCheckoutViewModelFactory));
    }

    @Override // javax.inject.Provider
    public LegacyCheckoutViewModel get() {
        return provideBasketScreenViewModelImpl(this.a, this.b.get());
    }
}
