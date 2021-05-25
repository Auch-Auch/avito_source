package com.avito.android.payment.di.component;

import android.app.Activity;
import com.avito.android.Features;
import com.avito.android.deep_linking.DeepLinkFactory;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.di.DialogRouterModule_ProvideDialogRouterFactory;
import com.avito.android.payment.di.component.PaymentProcessingComponent;
import com.avito.android.payment.di.module.PaymentProcessingModule_ProvidePaymentGenericFactory$payment_releaseFactory;
import com.avito.android.payment.di.module.PaymentProcessingModule_ProvidePaymentStatusFactory$payment_releaseFactory;
import com.avito.android.payment.processing.PaymentGenericFactory;
import com.avito.android.payment.processing.PaymentProcessingActivity;
import com.avito.android.payment.processing.PaymentProcessingActivity_MembersInjector;
import com.avito.android.payment.processing.PaymentStatusFactory;
import com.avito.android.payment.remote.PaymentApi;
import com.avito.android.payment.remote.PaymentSessionTypeMarker;
import com.avito.android.util.DialogRouter;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import javax.inject.Provider;
public final class DaggerPaymentProcessingComponent implements PaymentProcessingComponent {
    public final PaymentDependencies a;
    public Provider<PaymentApi> b;
    public Provider<SchedulersFactory> c;
    public Provider<DeepLinkFactory> d;
    public Provider<PaymentSessionTypeMarker> e;
    public Provider<Features> f;
    public Provider<PaymentGenericFactory> g;
    public Provider<PaymentStatusFactory> h = DoubleCheck.provider(PaymentProcessingModule_ProvidePaymentStatusFactory$payment_releaseFactory.create(this.b, this.c));
    public Provider<Activity> i;
    public Provider<DialogRouter> j;

    public static final class b implements PaymentProcessingComponent.Builder {
        public PaymentDependencies a;
        public Activity b;
        public PaymentSessionTypeMarker c;

        public b(a aVar) {
        }

        @Override // com.avito.android.payment.di.component.PaymentProcessingComponent.Builder
        public PaymentProcessingComponent build() {
            Preconditions.checkBuilderRequirement(this.a, PaymentDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, Activity.class);
            Preconditions.checkBuilderRequirement(this.c, PaymentSessionTypeMarker.class);
            return new DaggerPaymentProcessingComponent(this.a, this.b, this.c, null);
        }

        @Override // com.avito.android.payment.di.component.PaymentProcessingComponent.Builder
        public PaymentProcessingComponent.Builder paymentDependencies(PaymentDependencies paymentDependencies) {
            this.a = (PaymentDependencies) Preconditions.checkNotNull(paymentDependencies);
            return this;
        }

        @Override // com.avito.android.payment.di.component.PaymentProcessingComponent.Builder
        public PaymentProcessingComponent.Builder paymentSessionTypeMarker(PaymentSessionTypeMarker paymentSessionTypeMarker) {
            this.c = (PaymentSessionTypeMarker) Preconditions.checkNotNull(paymentSessionTypeMarker);
            return this;
        }

        @Override // com.avito.android.payment.di.component.PaymentProcessingComponent.Builder
        public PaymentProcessingComponent.Builder withActivity(Activity activity) {
            this.b = (Activity) Preconditions.checkNotNull(activity);
            return this;
        }
    }

    public static class c implements Provider<DeepLinkFactory> {
        public final PaymentDependencies a;

        public c(PaymentDependencies paymentDependencies) {
            this.a = paymentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public DeepLinkFactory get() {
            return (DeepLinkFactory) Preconditions.checkNotNullFromComponent(this.a.deeplinkFactory());
        }
    }

    public static class d implements Provider<Features> {
        public final PaymentDependencies a;

        public d(PaymentDependencies paymentDependencies) {
            this.a = paymentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Features get() {
            return (Features) Preconditions.checkNotNullFromComponent(this.a.features());
        }
    }

    public static class e implements Provider<PaymentApi> {
        public final PaymentDependencies a;

        public e(PaymentDependencies paymentDependencies) {
            this.a = paymentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public PaymentApi get() {
            return (PaymentApi) Preconditions.checkNotNullFromComponent(this.a.paymentApi());
        }
    }

    public static class f implements Provider<SchedulersFactory> {
        public final PaymentDependencies a;

        public f(PaymentDependencies paymentDependencies) {
            this.a = paymentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public DaggerPaymentProcessingComponent(PaymentDependencies paymentDependencies, Activity activity, PaymentSessionTypeMarker paymentSessionTypeMarker, a aVar) {
        this.a = paymentDependencies;
        this.b = new e(paymentDependencies);
        this.c = new f(paymentDependencies);
        this.d = new c(paymentDependencies);
        Factory create = InstanceFactory.create(paymentSessionTypeMarker);
        this.e = create;
        d dVar = new d(paymentDependencies);
        this.f = dVar;
        this.g = DoubleCheck.provider(PaymentProcessingModule_ProvidePaymentGenericFactory$payment_releaseFactory.create(this.b, this.c, this.d, create, dVar));
        Factory create2 = InstanceFactory.create(activity);
        this.i = create2;
        this.j = SingleCheck.provider(DialogRouterModule_ProvideDialogRouterFactory.create(create2));
    }

    public static PaymentProcessingComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.payment.di.component.PaymentProcessingComponent
    public void inject(PaymentProcessingActivity paymentProcessingActivity) {
        PaymentProcessingActivity_MembersInjector.injectPaymentPresenterFactory(paymentProcessingActivity, this.g.get());
        PaymentProcessingActivity_MembersInjector.injectStatusPresenterFactory(paymentProcessingActivity, this.h.get());
        PaymentProcessingActivity_MembersInjector.injectDialogRouter(paymentProcessingActivity, this.j.get());
        PaymentProcessingActivity_MembersInjector.injectDeepLinkFactory(paymentProcessingActivity, (DeepLinkFactory) Preconditions.checkNotNullFromComponent(this.a.deeplinkFactory()));
        PaymentProcessingActivity_MembersInjector.injectDeepLinkIntentFactory(paymentProcessingActivity, (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deeplinkIntentFactory()));
    }
}
