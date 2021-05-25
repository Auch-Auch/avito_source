package com.avito.android.passport_verification.di;

import com.avito.android.analytics.Analytics;
import com.avito.android.passport_verification.PassportVerificationInteractor;
import com.avito.android.passport_verification.PassportVerificationInteractorImpl;
import com.avito.android.passport_verification.PassportVerificationInteractorImpl_Factory;
import com.avito.android.passport_verification.PassportVerificationModel;
import com.avito.android.passport_verification.PassportVerificationModelImpl;
import com.avito.android.passport_verification.PassportVerificationModelImpl_Factory;
import com.avito.android.passport_verification.SumsubVerificationActivity;
import com.avito.android.passport_verification.SumsubVerificationActivity_MembersInjector;
import com.avito.android.passport_verification.di.PassportVerificationComponent;
import com.avito.android.remote.VerificationApi;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class DaggerPassportVerificationComponent implements PassportVerificationComponent {
    public final PassportVerificationDependencies a;
    public Provider<String> b;
    public Provider<String> c;
    public Provider<VerificationApi> d;
    public Provider<PassportVerificationInteractorImpl> e;
    public Provider<PassportVerificationInteractor> f;
    public Provider<SchedulersFactory3> g;
    public Provider<Analytics> h;
    public Provider<Boolean> i;
    public Provider<PassportVerificationModelImpl> j;
    public Provider<PassportVerificationModel> k;

    public static final class b implements PassportVerificationComponent.Builder {
        public PassportVerificationDependencies a;
        public PassportVerificationModule b;

        public b(a aVar) {
        }

        @Override // com.avito.android.passport_verification.di.PassportVerificationComponent.Builder
        public PassportVerificationComponent build() {
            Preconditions.checkBuilderRequirement(this.a, PassportVerificationDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, PassportVerificationModule.class);
            return new DaggerPassportVerificationComponent(this.b, this.a, null);
        }

        @Override // com.avito.android.passport_verification.di.PassportVerificationComponent.Builder
        public PassportVerificationComponent.Builder passportVerificationDependencies(PassportVerificationDependencies passportVerificationDependencies) {
            this.a = (PassportVerificationDependencies) Preconditions.checkNotNull(passportVerificationDependencies);
            return this;
        }

        @Override // com.avito.android.passport_verification.di.PassportVerificationComponent.Builder
        public PassportVerificationComponent.Builder passportVerificationModule(PassportVerificationModule passportVerificationModule) {
            this.b = (PassportVerificationModule) Preconditions.checkNotNull(passportVerificationModule);
            return this;
        }
    }

    public static class c implements Provider<Analytics> {
        public final PassportVerificationDependencies a;

        public c(PassportVerificationDependencies passportVerificationDependencies) {
            this.a = passportVerificationDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Analytics get() {
            return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
        }
    }

    public static class d implements Provider<SchedulersFactory3> {
        public final PassportVerificationDependencies a;

        public d(PassportVerificationDependencies passportVerificationDependencies) {
            this.a = passportVerificationDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory3 get() {
            return (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3());
        }
    }

    public static class e implements Provider<VerificationApi> {
        public final PassportVerificationDependencies a;

        public e(PassportVerificationDependencies passportVerificationDependencies) {
            this.a = passportVerificationDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public VerificationApi get() {
            return (VerificationApi) Preconditions.checkNotNullFromComponent(this.a.verificationApi());
        }
    }

    public DaggerPassportVerificationComponent(PassportVerificationModule passportVerificationModule, PassportVerificationDependencies passportVerificationDependencies, a aVar) {
        this.a = passportVerificationDependencies;
        this.b = DoubleCheck.provider(PassportVerificationModule_ProvideUrl$passport_verification_releaseFactory.create(passportVerificationModule));
        this.c = DoubleCheck.provider(PassportVerificationModule_ProvideFlowName$passport_verification_releaseFactory.create(passportVerificationModule));
        e eVar = new e(passportVerificationDependencies);
        this.d = eVar;
        PassportVerificationInteractorImpl_Factory create = PassportVerificationInteractorImpl_Factory.create(eVar);
        this.e = create;
        this.f = DoubleCheck.provider(create);
        this.g = new d(passportVerificationDependencies);
        this.h = new c(passportVerificationDependencies);
        Provider<Boolean> provider = DoubleCheck.provider(PassportVerificationModule_ProvideIsFirstStart$passport_verification_releaseFactory.create(passportVerificationModule));
        this.i = provider;
        PassportVerificationModelImpl_Factory create2 = PassportVerificationModelImpl_Factory.create(this.b, this.c, this.f, this.g, this.h, provider);
        this.j = create2;
        this.k = DoubleCheck.provider(create2);
    }

    public static PassportVerificationComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.passport_verification.di.PassportVerificationComponent
    public void inject(SumsubVerificationActivity sumsubVerificationActivity) {
        SumsubVerificationActivity_MembersInjector.injectModel(sumsubVerificationActivity, this.k.get());
        SumsubVerificationActivity_MembersInjector.injectSchedulers(sumsubVerificationActivity, (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3()));
    }
}
