package com.avito.android.authorization.account_manager.di;

import android.accounts.AccountManager;
import android.app.Service;
import com.avito.android.Features;
import com.avito.android.authorization.account_manager.AvitoAccountAuthenticator;
import com.avito.android.authorization.account_manager.AvitoAuthenticatorService;
import com.avito.android.authorization.account_manager.AvitoAuthenticatorService_MembersInjector;
import com.avito.android.authorization.account_manager.di.AvitoAuthenticatorComponent;
import com.avito.android.preferences.TokenStorage;
import com.avito.android.remote.ProfileApi;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class DaggerAvitoAuthenticatorComponent implements AvitoAuthenticatorComponent {
    public Provider<Service> a;
    public Provider<AccountManager> b;
    public Provider<ProfileApi> c;
    public Provider<Features> d;
    public Provider<TokenStorage> e;
    public Provider<AvitoAccountAuthenticator> f;

    public static final class b implements AvitoAuthenticatorComponent.Builder {
        public AvitoAuthenticatorDependencies a;
        public Service b;

        public b(a aVar) {
        }

        @Override // com.avito.android.authorization.account_manager.di.AvitoAuthenticatorComponent.Builder
        public AvitoAuthenticatorComponent build() {
            Preconditions.checkBuilderRequirement(this.a, AvitoAuthenticatorDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, Service.class);
            return new DaggerAvitoAuthenticatorComponent(this.a, this.b, null);
        }

        @Override // com.avito.android.authorization.account_manager.di.AvitoAuthenticatorComponent.Builder
        public AvitoAuthenticatorComponent.Builder dependentOn(AvitoAuthenticatorDependencies avitoAuthenticatorDependencies) {
            this.a = (AvitoAuthenticatorDependencies) Preconditions.checkNotNull(avitoAuthenticatorDependencies);
            return this;
        }

        @Override // com.avito.android.authorization.account_manager.di.AvitoAuthenticatorComponent.Builder
        public AvitoAuthenticatorComponent.Builder with(Service service) {
            this.b = (Service) Preconditions.checkNotNull(service);
            return this;
        }
    }

    public static class c implements Provider<AccountManager> {
        public final AvitoAuthenticatorDependencies a;

        public c(AvitoAuthenticatorDependencies avitoAuthenticatorDependencies) {
            this.a = avitoAuthenticatorDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public AccountManager get() {
            return (AccountManager) Preconditions.checkNotNullFromComponent(this.a.accountManager());
        }
    }

    public static class d implements Provider<Features> {
        public final AvitoAuthenticatorDependencies a;

        public d(AvitoAuthenticatorDependencies avitoAuthenticatorDependencies) {
            this.a = avitoAuthenticatorDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Features get() {
            return (Features) Preconditions.checkNotNullFromComponent(this.a.features());
        }
    }

    public static class e implements Provider<TokenStorage> {
        public final AvitoAuthenticatorDependencies a;

        public e(AvitoAuthenticatorDependencies avitoAuthenticatorDependencies) {
            this.a = avitoAuthenticatorDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TokenStorage get() {
            return (TokenStorage) Preconditions.checkNotNullFromComponent(this.a.gcmTokenStorage());
        }
    }

    public static class f implements Provider<ProfileApi> {
        public final AvitoAuthenticatorDependencies a;

        public f(AvitoAuthenticatorDependencies avitoAuthenticatorDependencies) {
            this.a = avitoAuthenticatorDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ProfileApi get() {
            return (ProfileApi) Preconditions.checkNotNullFromComponent(this.a.profileApi());
        }
    }

    public DaggerAvitoAuthenticatorComponent(AvitoAuthenticatorDependencies avitoAuthenticatorDependencies, Service service, a aVar) {
        Factory create = InstanceFactory.create(service);
        this.a = create;
        c cVar = new c(avitoAuthenticatorDependencies);
        this.b = cVar;
        f fVar = new f(avitoAuthenticatorDependencies);
        this.c = fVar;
        d dVar = new d(avitoAuthenticatorDependencies);
        this.d = dVar;
        e eVar = new e(avitoAuthenticatorDependencies);
        this.e = eVar;
        this.f = DoubleCheck.provider(AvitoAuthenticatorModule_ProvideAvitoAccountAuthenticator$authorization_releaseFactory.create(create, cVar, fVar, dVar, eVar));
    }

    public static AvitoAuthenticatorComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.authorization.account_manager.di.AvitoAuthenticatorComponent
    public void inject(AvitoAuthenticatorService avitoAuthenticatorService) {
        AvitoAuthenticatorService_MembersInjector.injectAuthenticator(avitoAuthenticatorService, this.f.get());
    }
}
