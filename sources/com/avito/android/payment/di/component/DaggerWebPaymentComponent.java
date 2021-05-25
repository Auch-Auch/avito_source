package com.avito.android.payment.di.component;

import android.app.Activity;
import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.DeepLinkFactory;
import com.avito.android.di.DialogRouterModule_ProvideDialogRouterFactory;
import com.avito.android.payment.di.component.WebPaymentComponent;
import com.avito.android.payment.di.module.WebPaymentModule;
import com.avito.android.payment.di.module.WebPaymentModule_ProvidePaymentWebViewStateWatcher$payment_releaseFactory;
import com.avito.android.payment.di.module.WebPaymentModule_ProvideWebPaymentPresenter$payment_releaseFactory;
import com.avito.android.payment.di.module.WebPaymentModule_ProvideWebPaymentStateMachine$payment_releaseFactory;
import com.avito.android.payment.di.module.WebPaymentModule_ProvideWebViewStatePresenter$payment_releaseFactory;
import com.avito.android.payment.webview.PaymentWebViewStateWatcher;
import com.avito.android.payment.webview.WebPaymentActivity;
import com.avito.android.payment.webview.WebPaymentActivity_MembersInjector;
import com.avito.android.payment.webview.WebPaymentPresenter;
import com.avito.android.payment.webview.WebPaymentStateMachine;
import com.avito.android.payment.webview.WebViewStatePresenter;
import com.avito.android.util.DialogRouter;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import javax.inject.Provider;
public final class DaggerWebPaymentComponent implements WebPaymentComponent {
    public final PaymentDependencies a;
    public Provider<DeepLinkFactory> b;
    public Provider<SchedulersFactory> c;
    public Provider<WebViewStatePresenter> d;
    public Provider<WebPaymentStateMachine> e;
    public Provider<Analytics> f;
    public Provider<PaymentWebViewStateWatcher> g;
    public Provider<WebPaymentPresenter> h;
    public Provider<Activity> i;
    public Provider<DialogRouter> j;

    public static final class b implements WebPaymentComponent.Builder {
        public PaymentDependencies a;
        public WebPaymentModule b;
        public Activity c;

        public b(a aVar) {
        }

        @Override // com.avito.android.payment.di.component.WebPaymentComponent.Builder
        public WebPaymentComponent build() {
            Preconditions.checkBuilderRequirement(this.a, PaymentDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, WebPaymentModule.class);
            Preconditions.checkBuilderRequirement(this.c, Activity.class);
            return new DaggerWebPaymentComponent(this.b, this.a, this.c, null);
        }

        @Override // com.avito.android.payment.di.component.WebPaymentComponent.Builder
        public WebPaymentComponent.Builder paymentDependencies(PaymentDependencies paymentDependencies) {
            this.a = (PaymentDependencies) Preconditions.checkNotNull(paymentDependencies);
            return this;
        }

        @Override // com.avito.android.payment.di.component.WebPaymentComponent.Builder
        public WebPaymentComponent.Builder webPaymentModule(WebPaymentModule webPaymentModule) {
            this.b = (WebPaymentModule) Preconditions.checkNotNull(webPaymentModule);
            return this;
        }

        @Override // com.avito.android.payment.di.component.WebPaymentComponent.Builder
        public WebPaymentComponent.Builder withActivity(Activity activity) {
            this.c = (Activity) Preconditions.checkNotNull(activity);
            return this;
        }
    }

    public static class c implements Provider<Analytics> {
        public final PaymentDependencies a;

        public c(PaymentDependencies paymentDependencies) {
            this.a = paymentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Analytics get() {
            return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
        }
    }

    public static class d implements Provider<DeepLinkFactory> {
        public final PaymentDependencies a;

        public d(PaymentDependencies paymentDependencies) {
            this.a = paymentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public DeepLinkFactory get() {
            return (DeepLinkFactory) Preconditions.checkNotNullFromComponent(this.a.deeplinkFactory());
        }
    }

    public static class e implements Provider<SchedulersFactory> {
        public final PaymentDependencies a;

        public e(PaymentDependencies paymentDependencies) {
            this.a = paymentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public DaggerWebPaymentComponent(WebPaymentModule webPaymentModule, PaymentDependencies paymentDependencies, Activity activity, a aVar) {
        this.a = paymentDependencies;
        d dVar = new d(paymentDependencies);
        this.b = dVar;
        e eVar = new e(paymentDependencies);
        this.c = eVar;
        this.d = DoubleCheck.provider(WebPaymentModule_ProvideWebViewStatePresenter$payment_releaseFactory.create(webPaymentModule, dVar, eVar));
        this.e = DoubleCheck.provider(WebPaymentModule_ProvideWebPaymentStateMachine$payment_releaseFactory.create(webPaymentModule));
        c cVar = new c(paymentDependencies);
        this.f = cVar;
        Provider<PaymentWebViewStateWatcher> provider = DoubleCheck.provider(WebPaymentModule_ProvidePaymentWebViewStateWatcher$payment_releaseFactory.create(webPaymentModule, cVar));
        this.g = provider;
        this.h = DoubleCheck.provider(WebPaymentModule_ProvideWebPaymentPresenter$payment_releaseFactory.create(webPaymentModule, this.d, this.e, this.b, this.c, provider));
        Factory create = InstanceFactory.create(activity);
        this.i = create;
        this.j = SingleCheck.provider(DialogRouterModule_ProvideDialogRouterFactory.create(create));
    }

    public static WebPaymentComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.payment.di.component.WebPaymentComponent
    public void inject(WebPaymentActivity webPaymentActivity) {
        WebPaymentActivity_MembersInjector.injectPresenter(webPaymentActivity, this.h.get());
        WebPaymentActivity_MembersInjector.injectWebViewPresenterState(webPaymentActivity, this.d.get());
        WebPaymentActivity_MembersInjector.injectDialogRouter(webPaymentActivity, this.j.get());
        WebPaymentActivity_MembersInjector.injectAnalytics(webPaymentActivity, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
    }
}
