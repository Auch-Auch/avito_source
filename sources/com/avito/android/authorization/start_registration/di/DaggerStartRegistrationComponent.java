package com.avito.android.authorization.start_registration.di;

import android.content.res.Resources;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.authorization.start_registration.StartRegistrationActivity;
import com.avito.android.authorization.start_registration.StartRegistrationActivity_MembersInjector;
import com.avito.android.authorization.start_registration.StartRegistrationInteractor;
import com.avito.android.authorization.start_registration.StartRegistrationInteractorImpl;
import com.avito.android.authorization.start_registration.StartRegistrationInteractorImpl_Factory;
import com.avito.android.authorization.start_registration.StartRegistrationPresenter;
import com.avito.android.authorization.start_registration.StartRegistrationPresenterImpl;
import com.avito.android.authorization.start_registration.StartRegistrationPresenterImpl_Factory;
import com.avito.android.authorization.start_registration.di.StartRegistrationComponent;
import com.avito.android.code_confirmation.CodeConfirmationInteractor;
import com.avito.android.code_confirmation.CodeConfirmationResourceProvider;
import com.avito.android.code_confirmation.CodeConfirmationResourceProviderImpl;
import com.avito.android.code_confirmation.CodeConfirmationResourceProviderImpl_Factory;
import com.avito.android.code_confirmation.di.CodeConfirmationModule_ProvideCodeConfirmationInteractor$code_confirmation_releaseFactory;
import com.avito.android.remote.ProfileApi;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class DaggerStartRegistrationComponent implements StartRegistrationComponent {
    public final StartRegistrationDependencies a;
    public Provider<ProfileApi> b;
    public Provider<SchedulersFactory> c;
    public Provider<Resources> d;
    public Provider<CodeConfirmationResourceProviderImpl> e;
    public Provider<CodeConfirmationResourceProvider> f;
    public Provider<TypedErrorThrowableConverter> g;
    public Provider<String> h;
    public Provider<Boolean> i;
    public Provider<CodeConfirmationInteractor> j;
    public Provider<StartRegistrationInteractorImpl> k;
    public Provider<StartRegistrationInteractor> l;
    public Provider<Kundle> m;
    public Provider<StartRegistrationPresenterImpl> n;
    public Provider<StartRegistrationPresenter> o;

    public static final class b implements StartRegistrationComponent.Builder {
        public StartRegistrationDependencies a;
        public Resources b;
        public Kundle c;
        public String d;
        public Boolean e;

        public b(a aVar) {
        }

        @Override // com.avito.android.authorization.start_registration.di.StartRegistrationComponent.Builder
        public StartRegistrationComponent build() {
            Preconditions.checkBuilderRequirement(this.a, StartRegistrationDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, Resources.class);
            Preconditions.checkBuilderRequirement(this.d, String.class);
            Preconditions.checkBuilderRequirement(this.e, Boolean.class);
            return new DaggerStartRegistrationComponent(this.a, this.b, this.c, this.d, this.e, null);
        }

        @Override // com.avito.android.authorization.start_registration.di.StartRegistrationComponent.Builder
        public StartRegistrationComponent.Builder dependentOn(StartRegistrationDependencies startRegistrationDependencies) {
            this.a = (StartRegistrationDependencies) Preconditions.checkNotNull(startRegistrationDependencies);
            return this;
        }

        @Override // com.avito.android.authorization.start_registration.di.StartRegistrationComponent.Builder
        public StartRegistrationComponent.Builder withPresenterState(Kundle kundle) {
            this.c = kundle;
            return this;
        }

        @Override // com.avito.android.authorization.start_registration.di.StartRegistrationComponent.Builder
        public StartRegistrationComponent.Builder withResources(Resources resources) {
            this.b = (Resources) Preconditions.checkNotNull(resources);
            return this;
        }

        @Override // com.avito.android.authorization.start_registration.di.StartRegistrationComponent.Builder
        public StartRegistrationComponent.Builder withRetry(boolean z) {
            this.e = (Boolean) Preconditions.checkNotNull(Boolean.valueOf(z));
            return this;
        }

        @Override // com.avito.android.authorization.start_registration.di.StartRegistrationComponent.Builder
        public StartRegistrationComponent.Builder withSrc(String str) {
            this.d = (String) Preconditions.checkNotNull(str);
            return this;
        }
    }

    public static class c implements Provider<ProfileApi> {
        public final StartRegistrationDependencies a;

        public c(StartRegistrationDependencies startRegistrationDependencies) {
            this.a = startRegistrationDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ProfileApi get() {
            return (ProfileApi) Preconditions.checkNotNullFromComponent(this.a.profileApi());
        }
    }

    public static class d implements Provider<SchedulersFactory> {
        public final StartRegistrationDependencies a;

        public d(StartRegistrationDependencies startRegistrationDependencies) {
            this.a = startRegistrationDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public static class e implements Provider<TypedErrorThrowableConverter> {
        public final StartRegistrationDependencies a;

        public e(StartRegistrationDependencies startRegistrationDependencies) {
            this.a = startRegistrationDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TypedErrorThrowableConverter get() {
            return (TypedErrorThrowableConverter) Preconditions.checkNotNullFromComponent(this.a.typedErrorThrowableConverter());
        }
    }

    public DaggerStartRegistrationComponent(StartRegistrationDependencies startRegistrationDependencies, Resources resources, Kundle kundle, String str, Boolean bool, a aVar) {
        this.a = startRegistrationDependencies;
        this.b = new c(startRegistrationDependencies);
        this.c = new d(startRegistrationDependencies);
        Factory create = InstanceFactory.create(resources);
        this.d = create;
        CodeConfirmationResourceProviderImpl_Factory create2 = CodeConfirmationResourceProviderImpl_Factory.create(create);
        this.e = create2;
        this.f = DoubleCheck.provider(create2);
        this.g = new e(startRegistrationDependencies);
        this.h = InstanceFactory.create(str);
        Factory create3 = InstanceFactory.create(bool);
        this.i = create3;
        Provider<CodeConfirmationInteractor> provider = DoubleCheck.provider(CodeConfirmationModule_ProvideCodeConfirmationInteractor$code_confirmation_releaseFactory.create(this.b, this.c, this.f, this.g, this.h, create3));
        this.j = provider;
        StartRegistrationInteractorImpl_Factory create4 = StartRegistrationInteractorImpl_Factory.create(provider);
        this.k = create4;
        this.l = DoubleCheck.provider(create4);
        Factory createNullable = InstanceFactory.createNullable(kundle);
        this.m = createNullable;
        StartRegistrationPresenterImpl_Factory create5 = StartRegistrationPresenterImpl_Factory.create(this.l, this.c, createNullable);
        this.n = create5;
        this.o = DoubleCheck.provider(create5);
    }

    public static StartRegistrationComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.authorization.start_registration.di.StartRegistrationComponent
    public void inject(StartRegistrationActivity startRegistrationActivity) {
        StartRegistrationActivity_MembersInjector.injectPresenter(startRegistrationActivity, this.o.get());
        StartRegistrationActivity_MembersInjector.injectIntentFactory(startRegistrationActivity, (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.a.activityIntentFactory()));
    }
}
