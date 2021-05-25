package com.avito.android.payment.lib.di;

import com.avito.android.payment.lib.di.PaymentMethodsModule;
import com.avito.android.payment.processing.PaymentStatusPollingInteractor;
import com.avito.android.payment.remote.PaymentApi;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PaymentMethodsModule_Declarations_ProvidePaymentStatusInteractorFactory implements Factory<PaymentStatusPollingInteractor> {
    public final Provider<PaymentApi> a;

    public PaymentMethodsModule_Declarations_ProvidePaymentStatusInteractorFactory(Provider<PaymentApi> provider) {
        this.a = provider;
    }

    public static PaymentMethodsModule_Declarations_ProvidePaymentStatusInteractorFactory create(Provider<PaymentApi> provider) {
        return new PaymentMethodsModule_Declarations_ProvidePaymentStatusInteractorFactory(provider);
    }

    public static PaymentStatusPollingInteractor providePaymentStatusInteractor(PaymentApi paymentApi) {
        return (PaymentStatusPollingInteractor) Preconditions.checkNotNullFromProvides(PaymentMethodsModule.Declarations.providePaymentStatusInteractor(paymentApi));
    }

    @Override // javax.inject.Provider
    public PaymentStatusPollingInteractor get() {
        return providePaymentStatusInteractor(this.a.get());
    }
}
