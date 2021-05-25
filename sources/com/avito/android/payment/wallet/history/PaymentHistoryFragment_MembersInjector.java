package com.avito.android.payment.wallet.history;

import com.avito.android.ActivityIntentFactory;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class PaymentHistoryFragment_MembersInjector implements MembersInjector<PaymentHistoryFragment> {
    public final Provider<ActivityIntentFactory> a;
    public final Provider<PaymentHistoryViewModelFactory> b;

    public PaymentHistoryFragment_MembersInjector(Provider<ActivityIntentFactory> provider, Provider<PaymentHistoryViewModelFactory> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static MembersInjector<PaymentHistoryFragment> create(Provider<ActivityIntentFactory> provider, Provider<PaymentHistoryViewModelFactory> provider2) {
        return new PaymentHistoryFragment_MembersInjector(provider, provider2);
    }

    @InjectedFieldSignature("com.avito.android.payment.wallet.history.PaymentHistoryFragment.intentFactory")
    public static void injectIntentFactory(PaymentHistoryFragment paymentHistoryFragment, ActivityIntentFactory activityIntentFactory) {
        paymentHistoryFragment.intentFactory = activityIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.payment.wallet.history.PaymentHistoryFragment.paymentHistoryViewModelFactory")
    public static void injectPaymentHistoryViewModelFactory(PaymentHistoryFragment paymentHistoryFragment, PaymentHistoryViewModelFactory paymentHistoryViewModelFactory) {
        paymentHistoryFragment.paymentHistoryViewModelFactory = paymentHistoryViewModelFactory;
    }

    public void injectMembers(PaymentHistoryFragment paymentHistoryFragment) {
        injectIntentFactory(paymentHistoryFragment, this.a.get());
        injectPaymentHistoryViewModelFactory(paymentHistoryFragment, this.b.get());
    }
}
