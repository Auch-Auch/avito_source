package com.avito.android.payment.di.component;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.payment.di.component.WalletPageComponent;
import com.avito.android.payment.di.module.WalletPageModule;
import com.avito.android.payment.di.module.WalletPageModule_ProvideWalletInfoInteractorFactory;
import com.avito.android.payment.di.module.WalletPageModule_ProvideWalletPageViewModelFactoryFactory;
import com.avito.android.payment.remote.PaymentApi;
import com.avito.android.payment.wallet.WalletInfoInteractor;
import com.avito.android.payment.wallet.WalletPageActivity;
import com.avito.android.payment.wallet.WalletPageActivity_MembersInjector;
import com.avito.android.payment.wallet.WalletPageViewModelFactory;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class DaggerWalletPageComponent implements WalletPageComponent {
    public final PaymentDependencies a;
    public Provider<SchedulersFactory> b;
    public Provider<PaymentApi> c;
    public Provider<WalletInfoInteractor> d;
    public Provider<WalletPageViewModelFactory> e;

    public static final class b implements WalletPageComponent.Builder {
        public PaymentDependencies a;
        public WalletPageModule b;

        public b(a aVar) {
        }

        @Override // com.avito.android.payment.di.component.WalletPageComponent.Builder
        public WalletPageComponent build() {
            Preconditions.checkBuilderRequirement(this.a, PaymentDependencies.class);
            if (this.b == null) {
                this.b = new WalletPageModule();
            }
            return new DaggerWalletPageComponent(this.b, this.a, null);
        }

        @Override // com.avito.android.payment.di.component.WalletPageComponent.Builder
        public WalletPageComponent.Builder paymentDependencies(PaymentDependencies paymentDependencies) {
            this.a = (PaymentDependencies) Preconditions.checkNotNull(paymentDependencies);
            return this;
        }

        @Override // com.avito.android.payment.di.component.WalletPageComponent.Builder
        public WalletPageComponent.Builder walletPageModule(WalletPageModule walletPageModule) {
            this.b = (WalletPageModule) Preconditions.checkNotNull(walletPageModule);
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

    public DaggerWalletPageComponent(WalletPageModule walletPageModule, PaymentDependencies paymentDependencies, a aVar) {
        this.a = paymentDependencies;
        this.b = new d(paymentDependencies);
        c cVar = new c(paymentDependencies);
        this.c = cVar;
        Provider<WalletInfoInteractor> provider = DoubleCheck.provider(WalletPageModule_ProvideWalletInfoInteractorFactory.create(walletPageModule, cVar));
        this.d = provider;
        this.e = DoubleCheck.provider(WalletPageModule_ProvideWalletPageViewModelFactoryFactory.create(walletPageModule, this.b, provider));
    }

    public static WalletPageComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.payment.di.component.WalletPageComponent
    public void inject(WalletPageActivity walletPageActivity) {
        WalletPageActivity_MembersInjector.injectWalletPageViewModelFactory(walletPageActivity, this.e.get());
        WalletPageActivity_MembersInjector.injectDeepLinkIntentFactory(walletPageActivity, (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deeplinkIntentFactory()));
        WalletPageActivity_MembersInjector.injectActivityIntentFactory(walletPageActivity, (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.a.activityIntentFactory()));
    }
}
