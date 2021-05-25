package com.avito.android.payment.di.module;

import com.avito.android.payment.wallet.history.PaymentHistoryInteractor;
import com.avito.android.payment.wallet.history.PaymentHistoryViewModelFactory;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PaymentHistoryModule_ProvidePaymentHistoryViewModelFactoryFactory implements Factory<PaymentHistoryViewModelFactory> {
    public final PaymentHistoryModule a;
    public final Provider<SchedulersFactory> b;
    public final Provider<PaymentHistoryInteractor> c;

    public PaymentHistoryModule_ProvidePaymentHistoryViewModelFactoryFactory(PaymentHistoryModule paymentHistoryModule, Provider<SchedulersFactory> provider, Provider<PaymentHistoryInteractor> provider2) {
        this.a = paymentHistoryModule;
        this.b = provider;
        this.c = provider2;
    }

    public static PaymentHistoryModule_ProvidePaymentHistoryViewModelFactoryFactory create(PaymentHistoryModule paymentHistoryModule, Provider<SchedulersFactory> provider, Provider<PaymentHistoryInteractor> provider2) {
        return new PaymentHistoryModule_ProvidePaymentHistoryViewModelFactoryFactory(paymentHistoryModule, provider, provider2);
    }

    public static PaymentHistoryViewModelFactory providePaymentHistoryViewModelFactory(PaymentHistoryModule paymentHistoryModule, SchedulersFactory schedulersFactory, PaymentHistoryInteractor paymentHistoryInteractor) {
        return (PaymentHistoryViewModelFactory) Preconditions.checkNotNullFromProvides(paymentHistoryModule.providePaymentHistoryViewModelFactory(schedulersFactory, paymentHistoryInteractor));
    }

    @Override // javax.inject.Provider
    public PaymentHistoryViewModelFactory get() {
        return providePaymentHistoryViewModelFactory(this.a, this.b.get(), this.c.get());
    }
}
