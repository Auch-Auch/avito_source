package com.avito.android.di.module;

import com.avito.android.remote.PaymentsPlanHeaderProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class HeaderProvidersModule_ProvidePaymentsPlanHeaderProviderFactory implements Factory<PaymentsPlanHeaderProvider> {
    public final HeaderProvidersModule a;

    public HeaderProvidersModule_ProvidePaymentsPlanHeaderProviderFactory(HeaderProvidersModule headerProvidersModule) {
        this.a = headerProvidersModule;
    }

    public static HeaderProvidersModule_ProvidePaymentsPlanHeaderProviderFactory create(HeaderProvidersModule headerProvidersModule) {
        return new HeaderProvidersModule_ProvidePaymentsPlanHeaderProviderFactory(headerProvidersModule);
    }

    public static PaymentsPlanHeaderProvider providePaymentsPlanHeaderProvider(HeaderProvidersModule headerProvidersModule) {
        return (PaymentsPlanHeaderProvider) Preconditions.checkNotNullFromProvides(headerProvidersModule.providePaymentsPlanHeaderProvider());
    }

    @Override // javax.inject.Provider
    public PaymentsPlanHeaderProvider get() {
        return providePaymentsPlanHeaderProvider(this.a);
    }
}
