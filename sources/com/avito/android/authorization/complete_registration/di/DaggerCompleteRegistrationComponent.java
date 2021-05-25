package com.avito.android.authorization.complete_registration.di;

import android.app.Activity;
import com.avito.android.Features;
import com.avito.android.account.AccountUpdateInteractor;
import com.avito.android.account.LoginSuggestStorage;
import com.avito.android.analytics.Analytics;
import com.avito.android.authorization.complete_registration.CompleteRegistrationActivity;
import com.avito.android.authorization.complete_registration.CompleteRegistrationActivity_MembersInjector;
import com.avito.android.authorization.complete_registration.CompleteRegistrationInteractor;
import com.avito.android.authorization.complete_registration.CompleteRegistrationInteractorImpl;
import com.avito.android.authorization.complete_registration.CompleteRegistrationInteractorImpl_Factory;
import com.avito.android.authorization.complete_registration.CompleteRegistrationPresenter;
import com.avito.android.authorization.complete_registration.CompleteRegistrationPresenterImpl;
import com.avito.android.authorization.complete_registration.CompleteRegistrationPresenterImpl_Factory;
import com.avito.android.authorization.complete_registration.di.CompleteRegistrationComponent;
import com.avito.android.authorization.smart_lock.SmartLockSaver;
import com.avito.android.authorization.smart_lock.di.SmartLockSaverModule_ProvideSmartLockSaverFactory;
import com.avito.android.preferences.TokenStorage;
import com.avito.android.remote.ProfileApi;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class DaggerCompleteRegistrationComponent implements CompleteRegistrationComponent {
    public final CompleteRegistrationDependencies a;
    public Provider<String> b;
    public Provider<String> c;
    public Provider<ProfileApi> d;
    public Provider<AccountUpdateInteractor> e;
    public Provider<TypedErrorThrowableConverter> f;
    public Provider<TokenStorage> g;
    public Provider<LoginSuggestStorage> h;
    public Provider<Analytics> i;
    public Provider<SchedulersFactory> j;
    public Provider<CompleteRegistrationInteractorImpl> k;
    public Provider<CompleteRegistrationInteractor> l;
    public Provider<Activity> m;
    public Provider<SchedulersFactory3> n;
    public Provider<Features> o;
    public Provider<Kundle> p;
    public Provider<SmartLockSaver> q;
    public Provider<Kundle> r;
    public Provider<CompleteRegistrationPresenterImpl> s;
    public Provider<CompleteRegistrationPresenter> t;

    public static final class b implements CompleteRegistrationComponent.Builder {
        public CompleteRegistrationDependencies a;
        public Activity b;
        public Kundle c;
        public Kundle d;
        public String e;
        public String f;

        public b(a aVar) {
        }

        @Override // com.avito.android.authorization.complete_registration.di.CompleteRegistrationComponent.Builder
        public CompleteRegistrationComponent build() {
            Preconditions.checkBuilderRequirement(this.a, CompleteRegistrationDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, Activity.class);
            Preconditions.checkBuilderRequirement(this.e, String.class);
            Preconditions.checkBuilderRequirement(this.f, String.class);
            return new DaggerCompleteRegistrationComponent(this.a, this.b, this.c, this.d, this.e, this.f, null);
        }

        @Override // com.avito.android.authorization.complete_registration.di.CompleteRegistrationComponent.Builder
        public CompleteRegistrationComponent.Builder dependentOn(CompleteRegistrationDependencies completeRegistrationDependencies) {
            this.a = (CompleteRegistrationDependencies) Preconditions.checkNotNull(completeRegistrationDependencies);
            return this;
        }

        @Override // com.avito.android.authorization.complete_registration.di.CompleteRegistrationComponent.Builder
        public CompleteRegistrationComponent.Builder withActivity(Activity activity) {
            this.b = (Activity) Preconditions.checkNotNull(activity);
            return this;
        }

        @Override // com.avito.android.authorization.complete_registration.di.CompleteRegistrationComponent.Builder
        public CompleteRegistrationComponent.Builder withHash(String str) {
            this.f = (String) Preconditions.checkNotNull(str);
            return this;
        }

        @Override // com.avito.android.authorization.complete_registration.di.CompleteRegistrationComponent.Builder
        public CompleteRegistrationComponent.Builder withLogin(String str) {
            this.e = (String) Preconditions.checkNotNull(str);
            return this;
        }

        @Override // com.avito.android.authorization.complete_registration.di.CompleteRegistrationComponent.Builder
        public CompleteRegistrationComponent.Builder withPresenterState(Kundle kundle) {
            this.c = kundle;
            return this;
        }

        @Override // com.avito.android.authorization.complete_registration.di.CompleteRegistrationComponent.Builder
        public CompleteRegistrationComponent.Builder withSmartLockSaverState(Kundle kundle) {
            this.d = kundle;
            return this;
        }
    }

    public static class c implements Provider<AccountUpdateInteractor> {
        public final CompleteRegistrationDependencies a;

        public c(CompleteRegistrationDependencies completeRegistrationDependencies) {
            this.a = completeRegistrationDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public AccountUpdateInteractor get() {
            return (AccountUpdateInteractor) Preconditions.checkNotNullFromComponent(this.a.accountUpdateInteractor());
        }
    }

    public static class d implements Provider<Analytics> {
        public final CompleteRegistrationDependencies a;

        public d(CompleteRegistrationDependencies completeRegistrationDependencies) {
            this.a = completeRegistrationDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Analytics get() {
            return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
        }
    }

    public static class e implements Provider<TypedErrorThrowableConverter> {
        public final CompleteRegistrationDependencies a;

        public e(CompleteRegistrationDependencies completeRegistrationDependencies) {
            this.a = completeRegistrationDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TypedErrorThrowableConverter get() {
            return (TypedErrorThrowableConverter) Preconditions.checkNotNullFromComponent(this.a.errorConverter());
        }
    }

    public static class f implements Provider<Features> {
        public final CompleteRegistrationDependencies a;

        public f(CompleteRegistrationDependencies completeRegistrationDependencies) {
            this.a = completeRegistrationDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Features get() {
            return (Features) Preconditions.checkNotNullFromComponent(this.a.features());
        }
    }

    public static class g implements Provider<TokenStorage> {
        public final CompleteRegistrationDependencies a;

        public g(CompleteRegistrationDependencies completeRegistrationDependencies) {
            this.a = completeRegistrationDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TokenStorage get() {
            return (TokenStorage) Preconditions.checkNotNullFromComponent(this.a.gcmTokenStorage());
        }
    }

    public static class h implements Provider<LoginSuggestStorage> {
        public final CompleteRegistrationDependencies a;

        public h(CompleteRegistrationDependencies completeRegistrationDependencies) {
            this.a = completeRegistrationDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public LoginSuggestStorage get() {
            return (LoginSuggestStorage) Preconditions.checkNotNullFromComponent(this.a.loginSuggestStorage());
        }
    }

    public static class i implements Provider<ProfileApi> {
        public final CompleteRegistrationDependencies a;

        public i(CompleteRegistrationDependencies completeRegistrationDependencies) {
            this.a = completeRegistrationDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ProfileApi get() {
            return (ProfileApi) Preconditions.checkNotNullFromComponent(this.a.profileApi());
        }
    }

    public static class j implements Provider<SchedulersFactory3> {
        public final CompleteRegistrationDependencies a;

        public j(CompleteRegistrationDependencies completeRegistrationDependencies) {
            this.a = completeRegistrationDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory3 get() {
            return (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3());
        }
    }

    public static class k implements Provider<SchedulersFactory> {
        public final CompleteRegistrationDependencies a;

        public k(CompleteRegistrationDependencies completeRegistrationDependencies) {
            this.a = completeRegistrationDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public DaggerCompleteRegistrationComponent(CompleteRegistrationDependencies completeRegistrationDependencies, Activity activity, Kundle kundle, Kundle kundle2, String str, String str2, a aVar) {
        this.a = completeRegistrationDependencies;
        this.b = InstanceFactory.create(str);
        this.c = InstanceFactory.create(str2);
        i iVar = new i(completeRegistrationDependencies);
        this.d = iVar;
        c cVar = new c(completeRegistrationDependencies);
        this.e = cVar;
        e eVar = new e(completeRegistrationDependencies);
        this.f = eVar;
        g gVar = new g(completeRegistrationDependencies);
        this.g = gVar;
        h hVar = new h(completeRegistrationDependencies);
        this.h = hVar;
        d dVar = new d(completeRegistrationDependencies);
        this.i = dVar;
        k kVar = new k(completeRegistrationDependencies);
        this.j = kVar;
        CompleteRegistrationInteractorImpl_Factory create = CompleteRegistrationInteractorImpl_Factory.create(this.b, iVar, cVar, eVar, gVar, hVar, dVar, kVar);
        this.k = create;
        this.l = DoubleCheck.provider(create);
        this.m = InstanceFactory.create(activity);
        this.n = new j(completeRegistrationDependencies);
        this.o = new f(completeRegistrationDependencies);
        Factory createNullable = InstanceFactory.createNullable(kundle2);
        this.p = createNullable;
        this.q = DoubleCheck.provider(SmartLockSaverModule_ProvideSmartLockSaverFactory.create(this.m, this.i, this.n, this.o, createNullable));
        Factory createNullable2 = InstanceFactory.createNullable(kundle);
        this.r = createNullable2;
        CompleteRegistrationPresenterImpl_Factory create2 = CompleteRegistrationPresenterImpl_Factory.create(this.b, this.c, this.l, this.q, this.j, this.o, createNullable2);
        this.s = create2;
        this.t = DoubleCheck.provider(create2);
    }

    public static CompleteRegistrationComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.authorization.complete_registration.di.CompleteRegistrationComponent
    public void inject(CompleteRegistrationActivity completeRegistrationActivity) {
        CompleteRegistrationActivity_MembersInjector.injectPresenter(completeRegistrationActivity, this.t.get());
        CompleteRegistrationActivity_MembersInjector.injectSmartLock(completeRegistrationActivity, this.q.get());
        CompleteRegistrationActivity_MembersInjector.injectAnalytics(completeRegistrationActivity, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
    }
}
