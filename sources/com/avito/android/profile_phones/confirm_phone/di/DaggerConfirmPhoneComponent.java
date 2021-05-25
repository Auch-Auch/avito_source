package com.avito.android.profile_phones.confirm_phone.di;

import com.avito.android.code_confirmation.phone_confirm.PhoneConfirmInteractor;
import com.avito.android.code_confirmation.phone_confirm.PhoneConfirmInteractorImpl;
import com.avito.android.code_confirmation.phone_confirm.PhoneConfirmInteractorImpl_Factory;
import com.avito.android.code_confirmation.phone_confirm.PhoneConfirmResourceProvider;
import com.avito.android.profile_phones.confirm_phone.ConfirmPhoneFragment;
import com.avito.android.profile_phones.confirm_phone.ConfirmPhoneFragment_MembersInjector;
import com.avito.android.profile_phones.confirm_phone.ConfirmPhoneViewModelFactory;
import com.avito.android.profile_phones.confirm_phone.di.ConfirmPhoneComponent;
import com.avito.android.remote.ProfileApi;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class DaggerConfirmPhoneComponent implements ConfirmPhoneComponent {
    public Provider<ProfileApi> a;
    public Provider<SchedulersFactory3> b;
    public Provider<TypedErrorThrowableConverter> c;
    public Provider<PhoneConfirmResourceProvider> d;
    public Provider<PhoneConfirmInteractorImpl> e;
    public Provider<PhoneConfirmInteractor> f;
    public Provider<ConfirmPhoneViewModelFactory> g;

    public static final class b implements ConfirmPhoneComponent.Builder {
        public ConfirmPhoneDependencies a;
        public ConfirmPhoneModule b;

        public b(a aVar) {
        }

        @Override // com.avito.android.profile_phones.confirm_phone.di.ConfirmPhoneComponent.Builder
        public ConfirmPhoneComponent build() {
            Preconditions.checkBuilderRequirement(this.a, ConfirmPhoneDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, ConfirmPhoneModule.class);
            return new DaggerConfirmPhoneComponent(this.b, this.a, null);
        }

        @Override // com.avito.android.profile_phones.confirm_phone.di.ConfirmPhoneComponent.Builder
        public ConfirmPhoneComponent.Builder confirmPhoneDependencies(ConfirmPhoneDependencies confirmPhoneDependencies) {
            this.a = (ConfirmPhoneDependencies) Preconditions.checkNotNull(confirmPhoneDependencies);
            return this;
        }

        @Override // com.avito.android.profile_phones.confirm_phone.di.ConfirmPhoneComponent.Builder
        public ConfirmPhoneComponent.Builder confirmPhoneModule(ConfirmPhoneModule confirmPhoneModule) {
            this.b = (ConfirmPhoneModule) Preconditions.checkNotNull(confirmPhoneModule);
            return this;
        }
    }

    public static class c implements Provider<ProfileApi> {
        public final ConfirmPhoneDependencies a;

        public c(ConfirmPhoneDependencies confirmPhoneDependencies) {
            this.a = confirmPhoneDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ProfileApi get() {
            return (ProfileApi) Preconditions.checkNotNullFromComponent(this.a.profileApi());
        }
    }

    public static class d implements Provider<SchedulersFactory3> {
        public final ConfirmPhoneDependencies a;

        public d(ConfirmPhoneDependencies confirmPhoneDependencies) {
            this.a = confirmPhoneDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory3 get() {
            return (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3());
        }
    }

    public static class e implements Provider<TypedErrorThrowableConverter> {
        public final ConfirmPhoneDependencies a;

        public e(ConfirmPhoneDependencies confirmPhoneDependencies) {
            this.a = confirmPhoneDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TypedErrorThrowableConverter get() {
            return (TypedErrorThrowableConverter) Preconditions.checkNotNullFromComponent(this.a.throwableConverter());
        }
    }

    public DaggerConfirmPhoneComponent(ConfirmPhoneModule confirmPhoneModule, ConfirmPhoneDependencies confirmPhoneDependencies, a aVar) {
        this.a = new c(confirmPhoneDependencies);
        this.b = new d(confirmPhoneDependencies);
        this.c = new e(confirmPhoneDependencies);
        Provider<PhoneConfirmResourceProvider> provider = DoubleCheck.provider(ConfirmPhoneModule_ProvideUserProfileResourceProvider$profile_phones_releaseFactory.create(confirmPhoneModule));
        this.d = provider;
        PhoneConfirmInteractorImpl_Factory create = PhoneConfirmInteractorImpl_Factory.create(this.a, this.b, this.c, provider);
        this.e = create;
        Provider<PhoneConfirmInteractor> provider2 = DoubleCheck.provider(create);
        this.f = provider2;
        this.g = DoubleCheck.provider(ConfirmPhoneModule_ProvideViewModelFactory$profile_phones_releaseFactory.create(confirmPhoneModule, provider2));
    }

    public static ConfirmPhoneComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.profile_phones.confirm_phone.di.ConfirmPhoneComponent
    public void inject(ConfirmPhoneFragment confirmPhoneFragment) {
        ConfirmPhoneFragment_MembersInjector.injectViewModelFactory(confirmPhoneFragment, this.g.get());
    }
}
