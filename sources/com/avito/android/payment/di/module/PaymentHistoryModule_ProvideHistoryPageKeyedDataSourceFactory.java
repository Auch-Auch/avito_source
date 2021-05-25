package com.avito.android.payment.di.module;

import com.avito.android.payment.wallet.history.HistoryPageKeyedDataSource;
import com.avito.android.payment.wallet.history.PaymentHistoryInteractor;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PaymentHistoryModule_ProvideHistoryPageKeyedDataSourceFactory implements Factory<HistoryPageKeyedDataSource> {
    public final PaymentHistoryModule a;
    public final Provider<SchedulersFactory> b;
    public final Provider<PaymentHistoryInteractor> c;

    public PaymentHistoryModule_ProvideHistoryPageKeyedDataSourceFactory(PaymentHistoryModule paymentHistoryModule, Provider<SchedulersFactory> provider, Provider<PaymentHistoryInteractor> provider2) {
        this.a = paymentHistoryModule;
        this.b = provider;
        this.c = provider2;
    }

    public static PaymentHistoryModule_ProvideHistoryPageKeyedDataSourceFactory create(PaymentHistoryModule paymentHistoryModule, Provider<SchedulersFactory> provider, Provider<PaymentHistoryInteractor> provider2) {
        return new PaymentHistoryModule_ProvideHistoryPageKeyedDataSourceFactory(paymentHistoryModule, provider, provider2);
    }

    public static HistoryPageKeyedDataSource provideHistoryPageKeyedDataSource(PaymentHistoryModule paymentHistoryModule, SchedulersFactory schedulersFactory, PaymentHistoryInteractor paymentHistoryInteractor) {
        return (HistoryPageKeyedDataSource) Preconditions.checkNotNullFromProvides(paymentHistoryModule.provideHistoryPageKeyedDataSource(schedulersFactory, paymentHistoryInteractor));
    }

    @Override // javax.inject.Provider
    public HistoryPageKeyedDataSource get() {
        return provideHistoryPageKeyedDataSource(this.a, this.b.get(), this.c.get());
    }
}
