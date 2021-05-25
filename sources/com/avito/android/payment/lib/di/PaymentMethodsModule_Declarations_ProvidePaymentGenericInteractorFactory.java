package com.avito.android.payment.lib.di;

import com.avito.android.Features;
import com.avito.android.payment.lib.PaymentGenericInteractor;
import com.avito.android.payment.lib.di.PaymentMethodsModule;
import com.avito.android.payment.remote.PaymentApi;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PaymentMethodsModule_Declarations_ProvidePaymentGenericInteractorFactory implements Factory<PaymentGenericInteractor> {
    public final Provider<PaymentApi> a;
    public final Provider<Features> b;

    public PaymentMethodsModule_Declarations_ProvidePaymentGenericInteractorFactory(Provider<PaymentApi> provider, Provider<Features> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static PaymentMethodsModule_Declarations_ProvidePaymentGenericInteractorFactory create(Provider<PaymentApi> provider, Provider<Features> provider2) {
        return new PaymentMethodsModule_Declarations_ProvidePaymentGenericInteractorFactory(provider, provider2);
    }

    public static PaymentGenericInteractor providePaymentGenericInteractor(PaymentApi paymentApi, Features features) {
        return (PaymentGenericInteractor) Preconditions.checkNotNullFromProvides(PaymentMethodsModule.Declarations.providePaymentGenericInteractor(paymentApi, features));
    }

    @Override // javax.inject.Provider
    public PaymentGenericInteractor get() {
        return providePaymentGenericInteractor(this.a.get(), this.b.get());
    }
}
