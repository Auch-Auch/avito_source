package com.avito.android.payment.di.component;

import android.app.Activity;
import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.DeepLinkFactory;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.di.DialogRouterModule_ProvideDialogRouterFactory;
import com.avito.android.payment.SubmitButtonBlueprint;
import com.avito.android.payment.di.component.PaymentStatusFormComponent;
import com.avito.android.payment.di.module.PaymentStatusFormModule;
import com.avito.android.payment.di.module.PaymentStatusFormModule_ProvideAdapterPresenterFactory;
import com.avito.android.payment.di.module.PaymentStatusFormModule_ProvideDisclaimerTextBlueprint$payment_releaseFactory;
import com.avito.android.payment.di.module.PaymentStatusFormModule_ProvideItemBinder$payment_releaseFactory;
import com.avito.android.payment.di.module.PaymentStatusFormModule_ProvideItemConverter$payment_releaseFactory;
import com.avito.android.payment.di.module.PaymentStatusFormModule_ProvidePaymentInfoTextBlueprint$payment_releaseFactory;
import com.avito.android.payment.di.module.PaymentStatusFormModule_ProvidePaymentStatusFormInteractor$payment_releaseFactory;
import com.avito.android.payment.di.module.PaymentStatusFormModule_ProvidePaymentStatusFormPresenter$payment_releaseFactory;
import com.avito.android.payment.di.module.PaymentStatusFormModule_ProvidePaymentStatusProcessingPresenter$payment_releaseFactory;
import com.avito.android.payment.di.module.PaymentStatusFormModule_ProvideRaisedButtonItemPresenter$payment_releaseFactory;
import com.avito.android.payment.di.module.PaymentStatusFormModule_ProvideRecyclerAdapterFactory;
import com.avito.android.payment.di.module.PaymentStatusFormModule_ProvideStatusFormProcessingPresenter$payment_releaseFactory;
import com.avito.android.payment.di.module.PaymentStatusFormModule_ProvideSubmitButtonBlueprint$payment_releaseFactory;
import com.avito.android.payment.di.module.PaymentStatusFormModule_ProvideTextItemPresenter$payment_releaseFactory;
import com.avito.android.payment.form.PaymentStatusProcessingPresenter;
import com.avito.android.payment.form.status.PaymentStatusFormActivity;
import com.avito.android.payment.form.status.PaymentStatusFormActivity_MembersInjector;
import com.avito.android.payment.form.status.PaymentStatusFormInteractor;
import com.avito.android.payment.form.status.PaymentStatusFormItemConverter;
import com.avito.android.payment.form.status.PaymentStatusFormPresenter;
import com.avito.android.payment.form.status.StatusFormProcessingPresenter;
import com.avito.android.payment.items.DisclaimerTextBlueprint;
import com.avito.android.payment.items.PaymentInfoTextBlueprint;
import com.avito.android.payment.items.TextItemPresenter;
import com.avito.android.payment.remote.PaymentApi;
import com.avito.android.util.DialogRouter;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.android.util.text.AttributedTextFormatterModule_ProvideAttributedTextFormatterFactory;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import javax.inject.Provider;
import ru.avito.component.button.ButtonItemPresenter;
public final class DaggerPaymentStatusFormComponent implements PaymentStatusFormComponent {
    public final PaymentDependencies a;
    public Provider<PaymentApi> b;
    public Provider<SchedulersFactory> c;
    public Provider<PaymentStatusFormInteractor> d;
    public Provider<AttributedTextFormatter> e;
    public Provider<PaymentStatusFormItemConverter> f;
    public Provider<PaymentStatusFormPresenter> g;
    public Provider<PaymentStatusProcessingPresenter> h;
    public Provider<StatusFormProcessingPresenter> i;
    public Provider<ButtonItemPresenter> j;
    public Provider<SubmitButtonBlueprint> k;
    public Provider<TextItemPresenter> l;
    public Provider<PaymentInfoTextBlueprint> m;
    public Provider<DisclaimerTextBlueprint> n;
    public Provider<ItemBinder> o;
    public Provider<AdapterPresenter> p;
    public Provider<SimpleRecyclerAdapter> q;
    public Provider<Activity> r;
    public Provider<DialogRouter> s;

    public static final class b implements PaymentStatusFormComponent.Builder {
        public PaymentDependencies a;
        public PaymentStatusFormModule b;
        public Activity c;

        public b(a aVar) {
        }

        @Override // com.avito.android.payment.di.component.PaymentStatusFormComponent.Builder
        public PaymentStatusFormComponent build() {
            Preconditions.checkBuilderRequirement(this.a, PaymentDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, PaymentStatusFormModule.class);
            Preconditions.checkBuilderRequirement(this.c, Activity.class);
            return new DaggerPaymentStatusFormComponent(this.b, this.a, this.c, null);
        }

        @Override // com.avito.android.payment.di.component.PaymentStatusFormComponent.Builder
        public PaymentStatusFormComponent.Builder paymentDependencies(PaymentDependencies paymentDependencies) {
            this.a = (PaymentDependencies) Preconditions.checkNotNull(paymentDependencies);
            return this;
        }

        @Override // com.avito.android.payment.di.component.PaymentStatusFormComponent.Builder
        public PaymentStatusFormComponent.Builder paymentStatusFormModule(PaymentStatusFormModule paymentStatusFormModule) {
            this.b = (PaymentStatusFormModule) Preconditions.checkNotNull(paymentStatusFormModule);
            return this;
        }

        @Override // com.avito.android.payment.di.component.PaymentStatusFormComponent.Builder
        public PaymentStatusFormComponent.Builder withActivity(Activity activity) {
            this.c = (Activity) Preconditions.checkNotNull(activity);
            return this;
        }
    }

    public static class c implements Provider<PaymentApi> {
        public final PaymentDependencies a;

        public c(PaymentDependencies paymentDependencies) {
            this.a = paymentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public PaymentApi get() {
            return (PaymentApi) Preconditions.checkNotNullFromComponent(this.a.paymentApi());
        }
    }

    public static class d implements Provider<SchedulersFactory> {
        public final PaymentDependencies a;

        public d(PaymentDependencies paymentDependencies) {
            this.a = paymentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public DaggerPaymentStatusFormComponent(PaymentStatusFormModule paymentStatusFormModule, PaymentDependencies paymentDependencies, Activity activity, a aVar) {
        this.a = paymentDependencies;
        c cVar = new c(paymentDependencies);
        this.b = cVar;
        d dVar = new d(paymentDependencies);
        this.c = dVar;
        this.d = DoubleCheck.provider(PaymentStatusFormModule_ProvidePaymentStatusFormInteractor$payment_releaseFactory.create(paymentStatusFormModule, cVar, dVar));
        Provider<AttributedTextFormatter> provider = SingleCheck.provider(AttributedTextFormatterModule_ProvideAttributedTextFormatterFactory.create());
        this.e = provider;
        Provider<PaymentStatusFormItemConverter> provider2 = DoubleCheck.provider(PaymentStatusFormModule_ProvideItemConverter$payment_releaseFactory.create(paymentStatusFormModule, provider));
        this.f = provider2;
        this.g = DoubleCheck.provider(PaymentStatusFormModule_ProvidePaymentStatusFormPresenter$payment_releaseFactory.create(paymentStatusFormModule, this.d, this.c, provider2));
        Provider<PaymentStatusProcessingPresenter> provider3 = DoubleCheck.provider(PaymentStatusFormModule_ProvidePaymentStatusProcessingPresenter$payment_releaseFactory.create(paymentStatusFormModule));
        this.h = provider3;
        this.i = DoubleCheck.provider(PaymentStatusFormModule_ProvideStatusFormProcessingPresenter$payment_releaseFactory.create(paymentStatusFormModule, provider3));
        Provider<ButtonItemPresenter> provider4 = DoubleCheck.provider(PaymentStatusFormModule_ProvideRaisedButtonItemPresenter$payment_releaseFactory.create(paymentStatusFormModule, this.g));
        this.j = provider4;
        this.k = DoubleCheck.provider(PaymentStatusFormModule_ProvideSubmitButtonBlueprint$payment_releaseFactory.create(paymentStatusFormModule, provider4));
        Provider<TextItemPresenter> provider5 = DoubleCheck.provider(PaymentStatusFormModule_ProvideTextItemPresenter$payment_releaseFactory.create(paymentStatusFormModule));
        this.l = provider5;
        this.m = DoubleCheck.provider(PaymentStatusFormModule_ProvidePaymentInfoTextBlueprint$payment_releaseFactory.create(paymentStatusFormModule, provider5));
        Provider<DisclaimerTextBlueprint> provider6 = DoubleCheck.provider(PaymentStatusFormModule_ProvideDisclaimerTextBlueprint$payment_releaseFactory.create(paymentStatusFormModule, this.l));
        this.n = provider6;
        Provider<ItemBinder> provider7 = DoubleCheck.provider(PaymentStatusFormModule_ProvideItemBinder$payment_releaseFactory.create(paymentStatusFormModule, this.k, this.m, provider6));
        this.o = provider7;
        Provider<AdapterPresenter> provider8 = DoubleCheck.provider(PaymentStatusFormModule_ProvideAdapterPresenterFactory.create(paymentStatusFormModule, provider7));
        this.p = provider8;
        this.q = DoubleCheck.provider(PaymentStatusFormModule_ProvideRecyclerAdapterFactory.create(paymentStatusFormModule, provider8, this.o));
        Factory create = InstanceFactory.create(activity);
        this.r = create;
        this.s = SingleCheck.provider(DialogRouterModule_ProvideDialogRouterFactory.create(create));
    }

    public static PaymentStatusFormComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.payment.di.component.PaymentStatusFormComponent
    public void inject(PaymentStatusFormActivity paymentStatusFormActivity) {
        PaymentStatusFormActivity_MembersInjector.injectPresenter(paymentStatusFormActivity, this.g.get());
        PaymentStatusFormActivity_MembersInjector.injectProcessingPresenter(paymentStatusFormActivity, this.i.get());
        PaymentStatusFormActivity_MembersInjector.injectInteractor(paymentStatusFormActivity, this.d.get());
        PaymentStatusFormActivity_MembersInjector.injectAdapter(paymentStatusFormActivity, this.q.get());
        PaymentStatusFormActivity_MembersInjector.injectAdapterPresenter(paymentStatusFormActivity, this.p.get());
        PaymentStatusFormActivity_MembersInjector.injectDeepLinkFactory(paymentStatusFormActivity, (DeepLinkFactory) Preconditions.checkNotNullFromComponent(this.a.deeplinkFactory()));
        PaymentStatusFormActivity_MembersInjector.injectDeepLinkIntentFactory(paymentStatusFormActivity, (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deeplinkIntentFactory()));
        PaymentStatusFormActivity_MembersInjector.injectAnalytics(paymentStatusFormActivity, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
        PaymentStatusFormActivity_MembersInjector.injectDialogRouter(paymentStatusFormActivity, this.s.get());
    }
}
