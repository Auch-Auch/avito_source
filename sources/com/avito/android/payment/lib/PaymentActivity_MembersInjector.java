package com.avito.android.payment.lib;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.util.DialogRouter;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class PaymentActivity_MembersInjector implements MembersInjector<PaymentActivity> {
    public final Provider<PaymentMethodsViewModel> a;
    public final Provider<AdapterPresenter> b;
    public final Provider<SimpleRecyclerAdapter> c;
    public final Provider<ActivityIntentFactory> d;
    public final Provider<DeepLinkIntentFactory> e;
    public final Provider<DialogRouter> f;

    public PaymentActivity_MembersInjector(Provider<PaymentMethodsViewModel> provider, Provider<AdapterPresenter> provider2, Provider<SimpleRecyclerAdapter> provider3, Provider<ActivityIntentFactory> provider4, Provider<DeepLinkIntentFactory> provider5, Provider<DialogRouter> provider6) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
    }

    public static MembersInjector<PaymentActivity> create(Provider<PaymentMethodsViewModel> provider, Provider<AdapterPresenter> provider2, Provider<SimpleRecyclerAdapter> provider3, Provider<ActivityIntentFactory> provider4, Provider<DeepLinkIntentFactory> provider5, Provider<DialogRouter> provider6) {
        return new PaymentActivity_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6);
    }

    @InjectedFieldSignature("com.avito.android.payment.lib.PaymentActivity.adapterPresenter")
    public static void injectAdapterPresenter(PaymentActivity paymentActivity, AdapterPresenter adapterPresenter) {
        paymentActivity.adapterPresenter = adapterPresenter;
    }

    @InjectedFieldSignature("com.avito.android.payment.lib.PaymentActivity.deepLinkIntentFactory")
    public static void injectDeepLinkIntentFactory(PaymentActivity paymentActivity, DeepLinkIntentFactory deepLinkIntentFactory) {
        paymentActivity.deepLinkIntentFactory = deepLinkIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.payment.lib.PaymentActivity.dialogRouter")
    public static void injectDialogRouter(PaymentActivity paymentActivity, DialogRouter dialogRouter) {
        paymentActivity.dialogRouter = dialogRouter;
    }

    @InjectedFieldSignature("com.avito.android.payment.lib.PaymentActivity.intentFactory")
    public static void injectIntentFactory(PaymentActivity paymentActivity, ActivityIntentFactory activityIntentFactory) {
        paymentActivity.intentFactory = activityIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.payment.lib.PaymentActivity.paymentMethodsViewModel")
    public static void injectPaymentMethodsViewModel(PaymentActivity paymentActivity, PaymentMethodsViewModel paymentMethodsViewModel) {
        paymentActivity.paymentMethodsViewModel = paymentMethodsViewModel;
    }

    @InjectedFieldSignature("com.avito.android.payment.lib.PaymentActivity.simpleRecyclerViewAdapter")
    public static void injectSimpleRecyclerViewAdapter(PaymentActivity paymentActivity, SimpleRecyclerAdapter simpleRecyclerAdapter) {
        paymentActivity.simpleRecyclerViewAdapter = simpleRecyclerAdapter;
    }

    public void injectMembers(PaymentActivity paymentActivity) {
        injectPaymentMethodsViewModel(paymentActivity, this.a.get());
        injectAdapterPresenter(paymentActivity, this.b.get());
        injectSimpleRecyclerViewAdapter(paymentActivity, this.c.get());
        injectIntentFactory(paymentActivity, this.d.get());
        injectDeepLinkIntentFactory(paymentActivity, this.e.get());
        injectDialogRouter(paymentActivity, this.f.get());
    }
}
