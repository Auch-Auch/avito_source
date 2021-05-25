package com.avito.android.basket_legacy.di.checkout;

import com.avito.android.basket_legacy.utils.CrossClickListener;
import com.avito.android.basket_legacy.viewmodels.checkout.LegacyCheckoutViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class LegacyCheckoutViewModelModule_ProvideCrossClickListenerFactory implements Factory<CrossClickListener> {
    public final LegacyCheckoutViewModelModule a;
    public final Provider<LegacyCheckoutViewModel> b;

    public LegacyCheckoutViewModelModule_ProvideCrossClickListenerFactory(LegacyCheckoutViewModelModule legacyCheckoutViewModelModule, Provider<LegacyCheckoutViewModel> provider) {
        this.a = legacyCheckoutViewModelModule;
        this.b = provider;
    }

    public static LegacyCheckoutViewModelModule_ProvideCrossClickListenerFactory create(LegacyCheckoutViewModelModule legacyCheckoutViewModelModule, Provider<LegacyCheckoutViewModel> provider) {
        return new LegacyCheckoutViewModelModule_ProvideCrossClickListenerFactory(legacyCheckoutViewModelModule, provider);
    }

    public static CrossClickListener provideCrossClickListener(LegacyCheckoutViewModelModule legacyCheckoutViewModelModule, LegacyCheckoutViewModel legacyCheckoutViewModel) {
        return (CrossClickListener) Preconditions.checkNotNullFromProvides(legacyCheckoutViewModelModule.provideCrossClickListener(legacyCheckoutViewModel));
    }

    @Override // javax.inject.Provider
    public CrossClickListener get() {
        return provideCrossClickListener(this.a, this.b.get());
    }
}
