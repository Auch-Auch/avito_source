package com.avito.android.payment.di.module;

import com.avito.android.payment.remote.PaymentApi;
import com.avito.android.payment.wallet.history.PaymentHistoryInteractor;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PaymentHistoryModule_ProvidePaymentHistoryInteractorFactory implements Factory<PaymentHistoryInteractor> {
    public final PaymentHistoryModule a;
    public final Provider<PaymentApi> b;

    public PaymentHistoryModule_ProvidePaymentHistoryInteractorFactory(PaymentHistoryModule paymentHistoryModule, Provider<PaymentApi> provider) {
        this.a = paymentHistoryModule;
        this.b = provider;
    }

    public static PaymentHistoryModule_ProvidePaymentHistoryInteractorFactory create(PaymentHistoryModule paymentHistoryModule, Provider<PaymentApi> provider) {
        return new PaymentHistoryModule_ProvidePaymentHistoryInteractorFactory(paymentHistoryModule, provider);
    }

    public static PaymentHistoryInteractor providePaymentHistoryInteractor(PaymentHistoryModule paymentHistoryModule, PaymentApi paymentApi) {
        return (PaymentHistoryInteractor) Preconditions.checkNotNullFromProvides(paymentHistoryModule.providePaymentHistoryInteractor(paymentApi));
    }

    @Override // javax.inject.Provider
    public PaymentHistoryInteractor get() {
        return providePaymentHistoryInteractor(this.a, this.b.get());
    }
}
