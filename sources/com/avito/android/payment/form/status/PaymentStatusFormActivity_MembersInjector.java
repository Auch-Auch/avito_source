package com.avito.android.payment.form.status;

import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.DeepLinkFactory;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.util.DialogRouter;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class PaymentStatusFormActivity_MembersInjector implements MembersInjector<PaymentStatusFormActivity> {
    public final Provider<PaymentStatusFormPresenter> a;
    public final Provider<StatusFormProcessingPresenter> b;
    public final Provider<PaymentStatusFormInteractor> c;
    public final Provider<SimpleRecyclerAdapter> d;
    public final Provider<AdapterPresenter> e;
    public final Provider<DeepLinkFactory> f;
    public final Provider<DeepLinkIntentFactory> g;
    public final Provider<Analytics> h;
    public final Provider<DialogRouter> i;

    public PaymentStatusFormActivity_MembersInjector(Provider<PaymentStatusFormPresenter> provider, Provider<StatusFormProcessingPresenter> provider2, Provider<PaymentStatusFormInteractor> provider3, Provider<SimpleRecyclerAdapter> provider4, Provider<AdapterPresenter> provider5, Provider<DeepLinkFactory> provider6, Provider<DeepLinkIntentFactory> provider7, Provider<Analytics> provider8, Provider<DialogRouter> provider9) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
        this.h = provider8;
        this.i = provider9;
    }

    public static MembersInjector<PaymentStatusFormActivity> create(Provider<PaymentStatusFormPresenter> provider, Provider<StatusFormProcessingPresenter> provider2, Provider<PaymentStatusFormInteractor> provider3, Provider<SimpleRecyclerAdapter> provider4, Provider<AdapterPresenter> provider5, Provider<DeepLinkFactory> provider6, Provider<DeepLinkIntentFactory> provider7, Provider<Analytics> provider8, Provider<DialogRouter> provider9) {
        return new PaymentStatusFormActivity_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9);
    }

    @InjectedFieldSignature("com.avito.android.payment.form.status.PaymentStatusFormActivity.adapter")
    public static void injectAdapter(PaymentStatusFormActivity paymentStatusFormActivity, SimpleRecyclerAdapter simpleRecyclerAdapter) {
        paymentStatusFormActivity.adapter = simpleRecyclerAdapter;
    }

    @InjectedFieldSignature("com.avito.android.payment.form.status.PaymentStatusFormActivity.adapterPresenter")
    public static void injectAdapterPresenter(PaymentStatusFormActivity paymentStatusFormActivity, AdapterPresenter adapterPresenter) {
        paymentStatusFormActivity.adapterPresenter = adapterPresenter;
    }

    @InjectedFieldSignature("com.avito.android.payment.form.status.PaymentStatusFormActivity.analytics")
    public static void injectAnalytics(PaymentStatusFormActivity paymentStatusFormActivity, Analytics analytics) {
        paymentStatusFormActivity.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.payment.form.status.PaymentStatusFormActivity.deepLinkFactory")
    public static void injectDeepLinkFactory(PaymentStatusFormActivity paymentStatusFormActivity, DeepLinkFactory deepLinkFactory) {
        paymentStatusFormActivity.deepLinkFactory = deepLinkFactory;
    }

    @InjectedFieldSignature("com.avito.android.payment.form.status.PaymentStatusFormActivity.deepLinkIntentFactory")
    public static void injectDeepLinkIntentFactory(PaymentStatusFormActivity paymentStatusFormActivity, DeepLinkIntentFactory deepLinkIntentFactory) {
        paymentStatusFormActivity.deepLinkIntentFactory = deepLinkIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.payment.form.status.PaymentStatusFormActivity.dialogRouter")
    public static void injectDialogRouter(PaymentStatusFormActivity paymentStatusFormActivity, DialogRouter dialogRouter) {
        paymentStatusFormActivity.dialogRouter = dialogRouter;
    }

    @InjectedFieldSignature("com.avito.android.payment.form.status.PaymentStatusFormActivity.interactor")
    public static void injectInteractor(PaymentStatusFormActivity paymentStatusFormActivity, PaymentStatusFormInteractor paymentStatusFormInteractor) {
        paymentStatusFormActivity.interactor = paymentStatusFormInteractor;
    }

    @InjectedFieldSignature("com.avito.android.payment.form.status.PaymentStatusFormActivity.presenter")
    public static void injectPresenter(PaymentStatusFormActivity paymentStatusFormActivity, PaymentStatusFormPresenter paymentStatusFormPresenter) {
        paymentStatusFormActivity.presenter = paymentStatusFormPresenter;
    }

    @InjectedFieldSignature("com.avito.android.payment.form.status.PaymentStatusFormActivity.processingPresenter")
    public static void injectProcessingPresenter(PaymentStatusFormActivity paymentStatusFormActivity, StatusFormProcessingPresenter statusFormProcessingPresenter) {
        paymentStatusFormActivity.processingPresenter = statusFormProcessingPresenter;
    }

    public void injectMembers(PaymentStatusFormActivity paymentStatusFormActivity) {
        injectPresenter(paymentStatusFormActivity, this.a.get());
        injectProcessingPresenter(paymentStatusFormActivity, this.b.get());
        injectInteractor(paymentStatusFormActivity, this.c.get());
        injectAdapter(paymentStatusFormActivity, this.d.get());
        injectAdapterPresenter(paymentStatusFormActivity, this.e.get());
        injectDeepLinkFactory(paymentStatusFormActivity, this.f.get());
        injectDeepLinkIntentFactory(paymentStatusFormActivity, this.g.get());
        injectAnalytics(paymentStatusFormActivity, this.h.get());
        injectDialogRouter(paymentStatusFormActivity, this.i.get());
    }
}
