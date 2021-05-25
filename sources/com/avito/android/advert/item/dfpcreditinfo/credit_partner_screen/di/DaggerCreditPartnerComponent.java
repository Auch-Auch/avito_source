package com.avito.android.advert.item.dfpcreditinfo.credit_partner_screen.di;

import com.avito.android.advert.item.dfpcreditinfo.credit_partner_screen.CreditPartnerFragment;
import com.avito.android.advert.item.dfpcreditinfo.credit_partner_screen.CreditPartnerFragment_MembersInjector;
import com.avito.android.advert.item.dfpcreditinfo.credit_partner_screen.SravniWebAnalyticsHandler;
import com.avito.android.advert.item.dfpcreditinfo.credit_partner_screen.di.CreditPartnerComponent;
import com.avito.android.advert_core.analytics.broker.CreditBrokerAnalyticsInteractorImpl;
import com.avito.android.advert_core.analytics.broker.CreditBrokerAnalyticsInteractorImpl_Factory;
import com.avito.android.advert_core.analytics.broker.CreditBrokerFlowEventLogger;
import com.avito.android.advert_core.analytics.broker.SravniWebAnalyticsEventLogger;
import com.avito.android.analytics.Analytics;
import com.avito.android.di.CoreComponentDependencies;
import com.avito.android.util.Kundle;
import com.avito.android.util.UUIDRandomKeyProvider_Factory;
import dagger.internal.DoubleCheck;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class DaggerCreditPartnerComponent implements CreditPartnerComponent {
    public Provider<String> a;
    public Provider<Analytics> b;
    public Provider<Kundle> c;
    public Provider<CreditBrokerAnalyticsInteractorImpl> d;
    public Provider<CreditBrokerFlowEventLogger> e;

    public static final class b implements CreditPartnerComponent.Builder {
        public CoreComponentDependencies a;
        public String b;
        public Kundle c;

        public b(a aVar) {
        }

        @Override // com.avito.android.advert.item.dfpcreditinfo.credit_partner_screen.di.CreditPartnerComponent.Builder
        public CreditPartnerComponent build() {
            Preconditions.checkBuilderRequirement(this.a, CoreComponentDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, String.class);
            Preconditions.checkBuilderRequirement(this.c, Kundle.class);
            return new DaggerCreditPartnerComponent(this.a, this.b, this.c, null);
        }

        @Override // com.avito.android.advert.item.dfpcreditinfo.credit_partner_screen.di.CreditPartnerComponent.Builder
        public CreditPartnerComponent.Builder dependencies(CoreComponentDependencies coreComponentDependencies) {
            this.a = (CoreComponentDependencies) Preconditions.checkNotNull(coreComponentDependencies);
            return this;
        }

        @Override // com.avito.android.advert.item.dfpcreditinfo.credit_partner_screen.di.CreditPartnerComponent.Builder
        public CreditPartnerComponent.Builder withAdvertId(String str) {
            this.b = (String) Preconditions.checkNotNull(str);
            return this;
        }

        @Override // com.avito.android.advert.item.dfpcreditinfo.credit_partner_screen.di.CreditPartnerComponent.Builder
        public CreditPartnerComponent.Builder withBrokerState(Kundle kundle) {
            this.c = (Kundle) Preconditions.checkNotNull(kundle);
            return this;
        }
    }

    public static class c implements Provider<Analytics> {
        public final CoreComponentDependencies a;

        public c(CoreComponentDependencies coreComponentDependencies) {
            this.a = coreComponentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Analytics get() {
            return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
        }
    }

    public DaggerCreditPartnerComponent(CoreComponentDependencies coreComponentDependencies, String str, Kundle kundle, a aVar) {
        this.a = InstanceFactory.create(str);
        this.b = new c(coreComponentDependencies);
        this.c = InstanceFactory.create(kundle);
        CreditBrokerAnalyticsInteractorImpl_Factory create = CreditBrokerAnalyticsInteractorImpl_Factory.create(this.a, this.b, UUIDRandomKeyProvider_Factory.create(), this.c);
        this.d = create;
        this.e = DoubleCheck.provider(create);
    }

    public static CreditPartnerComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.advert.item.dfpcreditinfo.credit_partner_screen.di.CreditPartnerComponent
    public void inject(CreditPartnerFragment creditPartnerFragment) {
        CreditPartnerFragment_MembersInjector.injectSravniWebAnalyticsHandler(creditPartnerFragment, new SravniWebAnalyticsHandler(new SravniWebAnalyticsEventLogger(this.e.get())));
    }
}
