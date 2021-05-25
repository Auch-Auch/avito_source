package com.avito.android.payment.lib.di;

import com.avito.android.Features;
import com.avito.android.payment.lib.PaymentSessionInteractor;
import com.avito.android.payment.lib.di.PaymentMethodsModule;
import com.avito.android.payment.remote.PaymentApi;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PaymentMethodsModule_Declarations_ProvidePaymentMethodsInteractorFactory implements Factory<PaymentSessionInteractor> {
    public final Provider<PaymentApi> a;
    public final Provider<Features> b;

    public PaymentMethodsModule_Declarations_ProvidePaymentMethodsInteractorFactory(Provider<PaymentApi> provider, Provider<Features> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static PaymentMethodsModule_Declarations_ProvidePaymentMethodsInteractorFactory create(Provider<PaymentApi> provider, Provider<Features> provider2) {
        return new PaymentMethodsModule_Declarations_ProvidePaymentMethodsInteractorFactory(provider, provider2);
    }

    public static PaymentSessionInteractor providePaymentMethodsInteractor(PaymentApi paymentApi, Features features) {
        return (PaymentSessionInteractor) Preconditions.checkNotNullFromProvides(PaymentMethodsModule.Declarations.providePaymentMethodsInteractor(paymentApi, features));
    }

    @Override // javax.inject.Provider
    public PaymentSessionInteractor get() {
        return providePaymentMethodsInteractor(this.a.get(), this.b.get());
    }
}
