package com.avito.android.advert.cpo_program.di;

import com.avito.android.advert.cpo_program.AutotekaCpoProgramActivity;
import com.avito.android.advert.cpo_program.AutotekaCpoProgramActivity_MembersInjector;
import com.avito.android.advert.cpo_program.AutotekaCpoProgramPresenter;
import com.avito.android.advert.cpo_program.AutotekaCpoProgramPresenterImpl;
import com.avito.android.advert.cpo_program.AutotekaCpoProgramPresenterImpl_Factory;
import com.avito.android.advert.cpo_program.di.AutotekaCpoProgramComponent;
import com.avito.android.remote.model.CpoDescription;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class DaggerAutotekaCpoProgramComponent implements AutotekaCpoProgramComponent {
    public Provider<CpoDescription> a;
    public Provider<SchedulersFactory3> b;
    public Provider<AutotekaCpoProgramPresenterImpl> c;
    public Provider<AutotekaCpoProgramPresenter> d;

    public static final class b implements AutotekaCpoProgramComponent.Builder {
        public AutotekaCpoProgramDependencies a;
        public CpoDescription b;

        public b(a aVar) {
        }

        @Override // com.avito.android.advert.cpo_program.di.AutotekaCpoProgramComponent.Builder
        public AutotekaCpoProgramComponent build() {
            Preconditions.checkBuilderRequirement(this.a, AutotekaCpoProgramDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, CpoDescription.class);
            return new DaggerAutotekaCpoProgramComponent(this.a, this.b, null);
        }

        @Override // com.avito.android.advert.cpo_program.di.AutotekaCpoProgramComponent.Builder
        public AutotekaCpoProgramComponent.Builder cpoProgramDependencies(AutotekaCpoProgramDependencies autotekaCpoProgramDependencies) {
            this.a = (AutotekaCpoProgramDependencies) Preconditions.checkNotNull(autotekaCpoProgramDependencies);
            return this;
        }

        @Override // com.avito.android.advert.cpo_program.di.AutotekaCpoProgramComponent.Builder
        public AutotekaCpoProgramComponent.Builder withDescription(CpoDescription cpoDescription) {
            this.b = (CpoDescription) Preconditions.checkNotNull(cpoDescription);
            return this;
        }
    }

    public static class c implements Provider<SchedulersFactory3> {
        public final AutotekaCpoProgramDependencies a;

        public c(AutotekaCpoProgramDependencies autotekaCpoProgramDependencies) {
            this.a = autotekaCpoProgramDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory3 get() {
            return (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3());
        }
    }

    public DaggerAutotekaCpoProgramComponent(AutotekaCpoProgramDependencies autotekaCpoProgramDependencies, CpoDescription cpoDescription, a aVar) {
        Factory create = InstanceFactory.create(cpoDescription);
        this.a = create;
        c cVar = new c(autotekaCpoProgramDependencies);
        this.b = cVar;
        AutotekaCpoProgramPresenterImpl_Factory create2 = AutotekaCpoProgramPresenterImpl_Factory.create(create, cVar);
        this.c = create2;
        this.d = DoubleCheck.provider(create2);
    }

    public static AutotekaCpoProgramComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.advert.cpo_program.di.AutotekaCpoProgramComponent
    public void inject(AutotekaCpoProgramActivity autotekaCpoProgramActivity) {
        AutotekaCpoProgramActivity_MembersInjector.injectPresenter(autotekaCpoProgramActivity, this.d.get());
    }
}
