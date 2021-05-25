package com.avito.android.payment.di.component;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.payment.di.component.PaymentHistoryComponent;
import com.avito.android.payment.di.module.PaymentHistoryModule;
import com.avito.android.payment.di.module.PaymentHistoryModule_ProvidePaymentHistoryInteractorFactory;
import com.avito.android.payment.di.module.PaymentHistoryModule_ProvidePaymentHistoryViewModelFactoryFactory;
import com.avito.android.payment.remote.PaymentApi;
import com.avito.android.payment.wallet.history.PaymentHistoryFragment;
import com.avito.android.payment.wallet.history.PaymentHistoryFragment_MembersInjector;
import com.avito.android.payment.wallet.history.PaymentHistoryInteractor;
import com.avito.android.payment.wallet.history.PaymentHistoryViewModelFactory;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class DaggerPaymentHistoryComponent implements PaymentHistoryComponent {
    public final PaymentDependencies a;
    public Provider<SchedulersFactory> b;
    public Provider<PaymentApi> c;
    public Provider<PaymentHistoryInteractor> d;
    public Provider<PaymentHistoryViewModelFactory> e;

    public static final class b implements PaymentHistoryComponent.Builder {
        public PaymentDependencies a;
        public PaymentHistoryModule b;

        public b(a aVar) {
        }

        @Override // com.avito.android.payment.di.component.PaymentHistoryComponent.Builder
        public PaymentHistoryComponent build() {
            Preconditions.checkBuilderRequirement(this.a, PaymentDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, PaymentHistoryModule.class);
            return new DaggerPaymentHistoryComponent(this.b, this.a, null);
        }

        @Override // com.avito.android.payment.di.component.PaymentHistoryComponent.Builder
        public PaymentHistoryComponent.Builder paymentDependencies(PaymentDependencies paymentDependencies) {
            this.a = (PaymentDependencies) Preconditions.checkNotNull(paymentDependencies);
            return this;
        }

        @Override // com.avito.android.payment.di.component.PaymentHistoryComponent.Builder
        public PaymentHistoryComponent.Builder paymentHistoryModule(PaymentHistoryModule paymentHistoryModule) {
            this.b = (PaymentHistoryModule) Preconditions.checkNotNull(paymentHistoryModule);
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

    public DaggerPaymentHistoryComponent(PaymentHistoryModule paymentHistoryModule, PaymentDependencies paymentDependencies, a aVar) {
        this.a = paymentDependencies;
        this.b = new d(paymentDependencies);
        c cVar = new c(paymentDependencies);
        this.c = cVar;
        Provider<PaymentHistoryInteractor> provider = DoubleCheck.provider(PaymentHistoryModule_ProvidePaymentHistoryInteractorFactory.create(paymentHistoryModule, cVar));
        this.d = provider;
        this.e = DoubleCheck.provider(PaymentHistoryModule_ProvidePaymentHistoryViewModelFactoryFactory.create(paymentHistoryModule, this.b, provider));
    }

    public static PaymentHistoryComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.payment.di.component.PaymentHistoryComponent
    public void inject(PaymentHistoryFragment paymentHistoryFragment) {
        PaymentHistoryFragment_MembersInjector.injectIntentFactory(paymentHistoryFragment, (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.a.activityIntentFactory()));
        PaymentHistoryFragment_MembersInjector.injectPaymentHistoryViewModelFactory(paymentHistoryFragment, this.e.get());
    }
}
