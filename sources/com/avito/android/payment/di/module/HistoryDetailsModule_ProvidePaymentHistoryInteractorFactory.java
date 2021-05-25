package com.avito.android.payment.di.module;

import com.avito.android.payment.remote.PaymentApi;
import com.avito.android.payment.wallet.history.details.PaymentHistoryDetailsInteractor;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class HistoryDetailsModule_ProvidePaymentHistoryInteractorFactory implements Factory<PaymentHistoryDetailsInteractor> {
    public final HistoryDetailsModule a;
    public final Provider<PaymentApi> b;

    public HistoryDetailsModule_ProvidePaymentHistoryInteractorFactory(HistoryDetailsModule historyDetailsModule, Provider<PaymentApi> provider) {
        this.a = historyDetailsModule;
        this.b = provider;
    }

    public static HistoryDetailsModule_ProvidePaymentHistoryInteractorFactory create(HistoryDetailsModule historyDetailsModule, Provider<PaymentApi> provider) {
        return new HistoryDetailsModule_ProvidePaymentHistoryInteractorFactory(historyDetailsModule, provider);
    }

    public static PaymentHistoryDetailsInteractor providePaymentHistoryInteractor(HistoryDetailsModule historyDetailsModule, PaymentApi paymentApi) {
        return (PaymentHistoryDetailsInteractor) Preconditions.checkNotNullFromProvides(historyDetailsModule.providePaymentHistoryInteractor(paymentApi));
    }

    @Override // javax.inject.Provider
    public PaymentHistoryDetailsInteractor get() {
        return providePaymentHistoryInteractor(this.a, this.b.get());
    }
}
