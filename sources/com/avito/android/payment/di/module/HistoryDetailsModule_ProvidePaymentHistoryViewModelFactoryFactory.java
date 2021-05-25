package com.avito.android.payment.di.module;

import com.avito.android.payment.wallet.history.details.PaymentHistoryDetailsInteractor;
import com.avito.android.payment.wallet.history.details.PaymentHistoryDetailsViewModelFactory;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class HistoryDetailsModule_ProvidePaymentHistoryViewModelFactoryFactory implements Factory<PaymentHistoryDetailsViewModelFactory> {
    public final HistoryDetailsModule a;
    public final Provider<SchedulersFactory> b;
    public final Provider<PaymentHistoryDetailsInteractor> c;

    public HistoryDetailsModule_ProvidePaymentHistoryViewModelFactoryFactory(HistoryDetailsModule historyDetailsModule, Provider<SchedulersFactory> provider, Provider<PaymentHistoryDetailsInteractor> provider2) {
        this.a = historyDetailsModule;
        this.b = provider;
        this.c = provider2;
    }

    public static HistoryDetailsModule_ProvidePaymentHistoryViewModelFactoryFactory create(HistoryDetailsModule historyDetailsModule, Provider<SchedulersFactory> provider, Provider<PaymentHistoryDetailsInteractor> provider2) {
        return new HistoryDetailsModule_ProvidePaymentHistoryViewModelFactoryFactory(historyDetailsModule, provider, provider2);
    }

    public static PaymentHistoryDetailsViewModelFactory providePaymentHistoryViewModelFactory(HistoryDetailsModule historyDetailsModule, SchedulersFactory schedulersFactory, PaymentHistoryDetailsInteractor paymentHistoryDetailsInteractor) {
        return (PaymentHistoryDetailsViewModelFactory) Preconditions.checkNotNullFromProvides(historyDetailsModule.providePaymentHistoryViewModelFactory(schedulersFactory, paymentHistoryDetailsInteractor));
    }

    @Override // javax.inject.Provider
    public PaymentHistoryDetailsViewModelFactory get() {
        return providePaymentHistoryViewModelFactory(this.a, this.b.get(), this.c.get());
    }
}
