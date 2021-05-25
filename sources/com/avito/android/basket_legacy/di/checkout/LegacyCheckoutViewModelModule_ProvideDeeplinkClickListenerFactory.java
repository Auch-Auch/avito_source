package com.avito.android.basket_legacy.di.checkout;

import com.avito.android.basket_legacy.viewmodels.checkout.LegacyCheckoutViewModel;
import com.avito.android.deep_linking.links.OnDeepLinkClickListener;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class LegacyCheckoutViewModelModule_ProvideDeeplinkClickListenerFactory implements Factory<OnDeepLinkClickListener> {
    public final LegacyCheckoutViewModelModule a;
    public final Provider<LegacyCheckoutViewModel> b;

    public LegacyCheckoutViewModelModule_ProvideDeeplinkClickListenerFactory(LegacyCheckoutViewModelModule legacyCheckoutViewModelModule, Provider<LegacyCheckoutViewModel> provider) {
        this.a = legacyCheckoutViewModelModule;
        this.b = provider;
    }

    public static LegacyCheckoutViewModelModule_ProvideDeeplinkClickListenerFactory create(LegacyCheckoutViewModelModule legacyCheckoutViewModelModule, Provider<LegacyCheckoutViewModel> provider) {
        return new LegacyCheckoutViewModelModule_ProvideDeeplinkClickListenerFactory(legacyCheckoutViewModelModule, provider);
    }

    public static OnDeepLinkClickListener provideDeeplinkClickListener(LegacyCheckoutViewModelModule legacyCheckoutViewModelModule, LegacyCheckoutViewModel legacyCheckoutViewModel) {
        return (OnDeepLinkClickListener) Preconditions.checkNotNullFromProvides(legacyCheckoutViewModelModule.provideDeeplinkClickListener(legacyCheckoutViewModel));
    }

    @Override // javax.inject.Provider
    public OnDeepLinkClickListener get() {
        return provideDeeplinkClickListener(this.a, this.b.get());
    }
}
