package com.avito.android.payment.di.module;

import com.avito.android.validation.LocalPretendInteractor;
import com.avito.android.validation.ParametersValidator;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PaymentGenericFormModule_ProvideLocalPretendInteractorFactory implements Factory<LocalPretendInteractor> {
    public final PaymentGenericFormModule a;
    public final Provider<ParametersValidator> b;

    public PaymentGenericFormModule_ProvideLocalPretendInteractorFactory(PaymentGenericFormModule paymentGenericFormModule, Provider<ParametersValidator> provider) {
        this.a = paymentGenericFormModule;
        this.b = provider;
    }

    public static PaymentGenericFormModule_ProvideLocalPretendInteractorFactory create(PaymentGenericFormModule paymentGenericFormModule, Provider<ParametersValidator> provider) {
        return new PaymentGenericFormModule_ProvideLocalPretendInteractorFactory(paymentGenericFormModule, provider);
    }

    public static LocalPretendInteractor provideLocalPretendInteractor(PaymentGenericFormModule paymentGenericFormModule, ParametersValidator parametersValidator) {
        return (LocalPretendInteractor) Preconditions.checkNotNullFromProvides(paymentGenericFormModule.provideLocalPretendInteractor(parametersValidator));
    }

    @Override // javax.inject.Provider
    public LocalPretendInteractor get() {
        return provideLocalPretendInteractor(this.a, this.b.get());
    }
}
