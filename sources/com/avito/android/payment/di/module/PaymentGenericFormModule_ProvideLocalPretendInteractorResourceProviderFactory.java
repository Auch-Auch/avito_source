package com.avito.android.payment.di.module;

import com.avito.android.validation.ParametersValidatorResourceProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class PaymentGenericFormModule_ProvideLocalPretendInteractorResourceProviderFactory implements Factory<ParametersValidatorResourceProvider> {
    public final PaymentGenericFormModule a;

    public PaymentGenericFormModule_ProvideLocalPretendInteractorResourceProviderFactory(PaymentGenericFormModule paymentGenericFormModule) {
        this.a = paymentGenericFormModule;
    }

    public static PaymentGenericFormModule_ProvideLocalPretendInteractorResourceProviderFactory create(PaymentGenericFormModule paymentGenericFormModule) {
        return new PaymentGenericFormModule_ProvideLocalPretendInteractorResourceProviderFactory(paymentGenericFormModule);
    }

    public static ParametersValidatorResourceProvider provideLocalPretendInteractorResourceProvider(PaymentGenericFormModule paymentGenericFormModule) {
        return (ParametersValidatorResourceProvider) Preconditions.checkNotNullFromProvides(paymentGenericFormModule.provideLocalPretendInteractorResourceProvider());
    }

    @Override // javax.inject.Provider
    public ParametersValidatorResourceProvider get() {
        return provideLocalPretendInteractorResourceProvider(this.a);
    }
}
