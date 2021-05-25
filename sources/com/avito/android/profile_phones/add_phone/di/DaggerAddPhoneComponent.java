package com.avito.android.profile_phones.add_phone.di;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.analytics.Analytics;
import com.avito.android.code_confirmation.phone_confirm.PhoneConfirmResourceProvider;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.profile_phones.add_phone.AddPhoneFragment;
import com.avito.android.profile_phones.add_phone.AddPhoneFragment_MembersInjector;
import com.avito.android.profile_phones.add_phone.AddPhoneInteractor;
import com.avito.android.profile_phones.add_phone.AddPhoneInteractorImpl;
import com.avito.android.profile_phones.add_phone.AddPhoneInteractorImpl_Factory;
import com.avito.android.profile_phones.add_phone.AddPhoneViewModelFactory;
import com.avito.android.profile_phones.add_phone.di.AddPhoneComponent;
import com.avito.android.remote.ProfileApi;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class DaggerAddPhoneComponent implements AddPhoneComponent {
    public final AddPhoneDependencies a;
    public Provider<ProfileApi> b;
    public Provider<SchedulersFactory3> c;
    public Provider<TypedErrorThrowableConverter> d;
    public Provider<PhoneConfirmResourceProvider> e;
    public Provider<AddPhoneInteractorImpl> f;
    public Provider<AddPhoneInteractor> g;

    public static final class b implements AddPhoneComponent.Builder {
        public AddPhoneDependencies a;
        public AddPhoneModule b;

        public b(a aVar) {
        }

        @Override // com.avito.android.profile_phones.add_phone.di.AddPhoneComponent.Builder
        public AddPhoneComponent.Builder addPhoneDependencies(AddPhoneDependencies addPhoneDependencies) {
            this.a = (AddPhoneDependencies) Preconditions.checkNotNull(addPhoneDependencies);
            return this;
        }

        @Override // com.avito.android.profile_phones.add_phone.di.AddPhoneComponent.Builder
        public AddPhoneComponent.Builder addPhoneModule(AddPhoneModule addPhoneModule) {
            this.b = (AddPhoneModule) Preconditions.checkNotNull(addPhoneModule);
            return this;
        }

        @Override // com.avito.android.profile_phones.add_phone.di.AddPhoneComponent.Builder
        public AddPhoneComponent build() {
            Preconditions.checkBuilderRequirement(this.a, AddPhoneDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, AddPhoneModule.class);
            return new DaggerAddPhoneComponent(this.b, this.a, null);
        }
    }

    public static class c implements Provider<ProfileApi> {
        public final AddPhoneDependencies a;

        public c(AddPhoneDependencies addPhoneDependencies) {
            this.a = addPhoneDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ProfileApi get() {
            return (ProfileApi) Preconditions.checkNotNullFromComponent(this.a.profileApi());
        }
    }

    public static class d implements Provider<SchedulersFactory3> {
        public final AddPhoneDependencies a;

        public d(AddPhoneDependencies addPhoneDependencies) {
            this.a = addPhoneDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory3 get() {
            return (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3());
        }
    }

    public static class e implements Provider<TypedErrorThrowableConverter> {
        public final AddPhoneDependencies a;

        public e(AddPhoneDependencies addPhoneDependencies) {
            this.a = addPhoneDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TypedErrorThrowableConverter get() {
            return (TypedErrorThrowableConverter) Preconditions.checkNotNullFromComponent(this.a.throwableConverter());
        }
    }

    public DaggerAddPhoneComponent(AddPhoneModule addPhoneModule, AddPhoneDependencies addPhoneDependencies, a aVar) {
        this.a = addPhoneDependencies;
        this.b = new c(addPhoneDependencies);
        this.c = new d(addPhoneDependencies);
        this.d = new e(addPhoneDependencies);
        Provider<PhoneConfirmResourceProvider> provider = DoubleCheck.provider(AddPhoneModule_ProvideUserProfileResourceProvider$profile_phones_releaseFactory.create(addPhoneModule));
        this.e = provider;
        AddPhoneInteractorImpl_Factory create = AddPhoneInteractorImpl_Factory.create(this.b, this.c, this.d, provider);
        this.f = create;
        this.g = DoubleCheck.provider(create);
    }

    public static AddPhoneComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.profile_phones.add_phone.di.AddPhoneComponent
    public void inject(AddPhoneFragment addPhoneFragment) {
        AddPhoneFragment_MembersInjector.injectViewModelFactory(addPhoneFragment, new AddPhoneViewModelFactory(this.g.get()));
        AddPhoneFragment_MembersInjector.injectActivityIntentFactory(addPhoneFragment, (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.a.intentFactory()));
        AddPhoneFragment_MembersInjector.injectDeepLinkIntentFactory(addPhoneFragment, (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deepLinkIntentFactory()));
        AddPhoneFragment_MembersInjector.injectAnalytics(addPhoneFragment, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
    }
}
