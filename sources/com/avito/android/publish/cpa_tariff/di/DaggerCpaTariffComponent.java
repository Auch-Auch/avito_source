package com.avito.android.publish.cpa_tariff.di;

import com.avito.android.publish.analytics.PublishEventTracker;
import com.avito.android.publish.cpa_tariff.CpaTariffActivity;
import com.avito.android.publish.cpa_tariff.CpaTariffActivity_MembersInjector;
import com.avito.android.publish.cpa_tariff.CpaTariffViewModelFactory;
import com.avito.android.publish.cpa_tariff.data.CpaTariffRepository;
import com.avito.android.publish.cpa_tariff.data.CpaTariffRepositoryImpl;
import com.avito.android.publish.cpa_tariff.data.CpaTariffRepositoryImpl_Factory;
import com.avito.android.publish.cpa_tariff.di.CpaTariffComponent;
import com.avito.android.remote.PublishApi;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class DaggerCpaTariffComponent implements CpaTariffComponent {
    public final CpaTariffDependencies a;
    public Provider<Integer> b;
    public Provider<PublishApi> c;
    public Provider<CpaTariffRepositoryImpl> d;
    public Provider<CpaTariffRepository> e;

    public static final class b implements CpaTariffComponent.Builder {
        public CpaTariffDependencies a;
        public Integer b;

        public b(a aVar) {
        }

        @Override // com.avito.android.publish.cpa_tariff.di.CpaTariffComponent.Builder
        public CpaTariffComponent build() {
            Preconditions.checkBuilderRequirement(this.a, CpaTariffDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, Integer.class);
            return new DaggerCpaTariffComponent(this.a, this.b, null);
        }

        @Override // com.avito.android.publish.cpa_tariff.di.CpaTariffComponent.Builder
        public CpaTariffComponent.Builder cpaTariffDependencies(CpaTariffDependencies cpaTariffDependencies) {
            this.a = (CpaTariffDependencies) Preconditions.checkNotNull(cpaTariffDependencies);
            return this;
        }

        @Override // com.avito.android.publish.cpa_tariff.di.CpaTariffComponent.Builder
        public CpaTariffComponent.Builder withCategoryId(int i) {
            this.b = (Integer) Preconditions.checkNotNull(Integer.valueOf(i));
            return this;
        }
    }

    public static class c implements Provider<PublishApi> {
        public final CpaTariffDependencies a;

        public c(CpaTariffDependencies cpaTariffDependencies) {
            this.a = cpaTariffDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public PublishApi get() {
            return (PublishApi) Preconditions.checkNotNullFromComponent(this.a.publishApi());
        }
    }

    public DaggerCpaTariffComponent(CpaTariffDependencies cpaTariffDependencies, Integer num, a aVar) {
        this.a = cpaTariffDependencies;
        Factory create = InstanceFactory.create(num);
        this.b = create;
        c cVar = new c(cpaTariffDependencies);
        this.c = cVar;
        CpaTariffRepositoryImpl_Factory create2 = CpaTariffRepositoryImpl_Factory.create(create, cVar);
        this.d = create2;
        this.e = DoubleCheck.provider(create2);
    }

    public static CpaTariffComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.publish.cpa_tariff.di.CpaTariffComponent
    public void inject(CpaTariffActivity cpaTariffActivity) {
        CpaTariffActivity_MembersInjector.injectViewModelFactory(cpaTariffActivity, new CpaTariffViewModelFactory(this.e.get(), (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3()), (PublishEventTracker) Preconditions.checkNotNullFromComponent(this.a.publishEventTracker())));
    }
}
