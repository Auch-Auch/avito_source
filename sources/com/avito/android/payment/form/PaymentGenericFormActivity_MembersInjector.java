package com.avito.android.payment.form;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class PaymentGenericFormActivity_MembersInjector implements MembersInjector<PaymentGenericFormActivity> {
    public final Provider<PaymentGenericFormPresenter> a;
    public final Provider<PaymentStatusProcessingPresenter> b;
    public final Provider<PaymentGenericFormInteractor> c;
    public final Provider<ItemBinder> d;
    public final Provider<SimpleRecyclerAdapter> e;
    public final Provider<DeepLinkIntentFactory> f;
    public final Provider<ActivityIntentFactory> g;
    public final Provider<Analytics> h;

    public PaymentGenericFormActivity_MembersInjector(Provider<PaymentGenericFormPresenter> provider, Provider<PaymentStatusProcessingPresenter> provider2, Provider<PaymentGenericFormInteractor> provider3, Provider<ItemBinder> provider4, Provider<SimpleRecyclerAdapter> provider5, Provider<DeepLinkIntentFactory> provider6, Provider<ActivityIntentFactory> provider7, Provider<Analytics> provider8) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
        this.h = provider8;
    }

    public static MembersInjector<PaymentGenericFormActivity> create(Provider<PaymentGenericFormPresenter> provider, Provider<PaymentStatusProcessingPresenter> provider2, Provider<PaymentGenericFormInteractor> provider3, Provider<ItemBinder> provider4, Provider<SimpleRecyclerAdapter> provider5, Provider<DeepLinkIntentFactory> provider6, Provider<ActivityIntentFactory> provider7, Provider<Analytics> provider8) {
        return new PaymentGenericFormActivity_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    @InjectedFieldSignature("com.avito.android.payment.form.PaymentGenericFormActivity.adapter")
    public static void injectAdapter(PaymentGenericFormActivity paymentGenericFormActivity, SimpleRecyclerAdapter simpleRecyclerAdapter) {
        paymentGenericFormActivity.adapter = simpleRecyclerAdapter;
    }

    @InjectedFieldSignature("com.avito.android.payment.form.PaymentGenericFormActivity.analytics")
    public static void injectAnalytics(PaymentGenericFormActivity paymentGenericFormActivity, Analytics analytics) {
        paymentGenericFormActivity.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.payment.form.PaymentGenericFormActivity.deepLinkIntentFactory")
    public static void injectDeepLinkIntentFactory(PaymentGenericFormActivity paymentGenericFormActivity, DeepLinkIntentFactory deepLinkIntentFactory) {
        paymentGenericFormActivity.deepLinkIntentFactory = deepLinkIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.payment.form.PaymentGenericFormActivity.intentFactory")
    public static void injectIntentFactory(PaymentGenericFormActivity paymentGenericFormActivity, ActivityIntentFactory activityIntentFactory) {
        paymentGenericFormActivity.intentFactory = activityIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.payment.form.PaymentGenericFormActivity.interactor")
    public static void injectInteractor(PaymentGenericFormActivity paymentGenericFormActivity, PaymentGenericFormInteractor paymentGenericFormInteractor) {
        paymentGenericFormActivity.interactor = paymentGenericFormInteractor;
    }

    @InjectedFieldSignature("com.avito.android.payment.form.PaymentGenericFormActivity.itemBinder")
    public static void injectItemBinder(PaymentGenericFormActivity paymentGenericFormActivity, ItemBinder itemBinder) {
        paymentGenericFormActivity.itemBinder = itemBinder;
    }

    @InjectedFieldSignature("com.avito.android.payment.form.PaymentGenericFormActivity.presenter")
    public static void injectPresenter(PaymentGenericFormActivity paymentGenericFormActivity, PaymentGenericFormPresenter paymentGenericFormPresenter) {
        paymentGenericFormActivity.presenter = paymentGenericFormPresenter;
    }

    @InjectedFieldSignature("com.avito.android.payment.form.PaymentGenericFormActivity.processingPresenter")
    public static void injectProcessingPresenter(PaymentGenericFormActivity paymentGenericFormActivity, PaymentStatusProcessingPresenter paymentStatusProcessingPresenter) {
        paymentGenericFormActivity.processingPresenter = paymentStatusProcessingPresenter;
    }

    public void injectMembers(PaymentGenericFormActivity paymentGenericFormActivity) {
        injectPresenter(paymentGenericFormActivity, this.a.get());
        injectProcessingPresenter(paymentGenericFormActivity, this.b.get());
        injectInteractor(paymentGenericFormActivity, this.c.get());
        injectItemBinder(paymentGenericFormActivity, this.d.get());
        injectAdapter(paymentGenericFormActivity, this.e.get());
        injectDeepLinkIntentFactory(paymentGenericFormActivity, this.f.get());
        injectIntentFactory(paymentGenericFormActivity, this.g.get());
        injectAnalytics(paymentGenericFormActivity, this.h.get());
    }
}
