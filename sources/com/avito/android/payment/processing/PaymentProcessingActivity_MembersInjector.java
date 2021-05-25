package com.avito.android.payment.processing;

import com.avito.android.deep_linking.DeepLinkFactory;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.util.DialogRouter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class PaymentProcessingActivity_MembersInjector implements MembersInjector<PaymentProcessingActivity> {
    public final Provider<PaymentGenericFactory> a;
    public final Provider<PaymentStatusFactory> b;
    public final Provider<DialogRouter> c;
    public final Provider<DeepLinkFactory> d;
    public final Provider<DeepLinkIntentFactory> e;

    public PaymentProcessingActivity_MembersInjector(Provider<PaymentGenericFactory> provider, Provider<PaymentStatusFactory> provider2, Provider<DialogRouter> provider3, Provider<DeepLinkFactory> provider4, Provider<DeepLinkIntentFactory> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static MembersInjector<PaymentProcessingActivity> create(Provider<PaymentGenericFactory> provider, Provider<PaymentStatusFactory> provider2, Provider<DialogRouter> provider3, Provider<DeepLinkFactory> provider4, Provider<DeepLinkIntentFactory> provider5) {
        return new PaymentProcessingActivity_MembersInjector(provider, provider2, provider3, provider4, provider5);
    }

    @InjectedFieldSignature("com.avito.android.payment.processing.PaymentProcessingActivity.deepLinkFactory")
    public static void injectDeepLinkFactory(PaymentProcessingActivity paymentProcessingActivity, DeepLinkFactory deepLinkFactory) {
        paymentProcessingActivity.deepLinkFactory = deepLinkFactory;
    }

    @InjectedFieldSignature("com.avito.android.payment.processing.PaymentProcessingActivity.deepLinkIntentFactory")
    public static void injectDeepLinkIntentFactory(PaymentProcessingActivity paymentProcessingActivity, DeepLinkIntentFactory deepLinkIntentFactory) {
        paymentProcessingActivity.deepLinkIntentFactory = deepLinkIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.payment.processing.PaymentProcessingActivity.dialogRouter")
    public static void injectDialogRouter(PaymentProcessingActivity paymentProcessingActivity, DialogRouter dialogRouter) {
        paymentProcessingActivity.dialogRouter = dialogRouter;
    }

    @InjectedFieldSignature("com.avito.android.payment.processing.PaymentProcessingActivity.paymentPresenterFactory")
    public static void injectPaymentPresenterFactory(PaymentProcessingActivity paymentProcessingActivity, PaymentGenericFactory paymentGenericFactory) {
        paymentProcessingActivity.paymentPresenterFactory = paymentGenericFactory;
    }

    @InjectedFieldSignature("com.avito.android.payment.processing.PaymentProcessingActivity.statusPresenterFactory")
    public static void injectStatusPresenterFactory(PaymentProcessingActivity paymentProcessingActivity, PaymentStatusFactory paymentStatusFactory) {
        paymentProcessingActivity.statusPresenterFactory = paymentStatusFactory;
    }

    public void injectMembers(PaymentProcessingActivity paymentProcessingActivity) {
        injectPaymentPresenterFactory(paymentProcessingActivity, this.a.get());
        injectStatusPresenterFactory(paymentProcessingActivity, this.b.get());
        injectDialogRouter(paymentProcessingActivity, this.c.get());
        injectDeepLinkFactory(paymentProcessingActivity, this.d.get());
        injectDeepLinkIntentFactory(paymentProcessingActivity, this.e.get());
    }
}
