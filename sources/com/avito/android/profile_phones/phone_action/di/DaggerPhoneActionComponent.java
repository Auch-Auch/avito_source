package com.avito.android.profile_phones.phone_action.di;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.profile_phones.phone_action.PhoneActionFragment;
import com.avito.android.profile_phones.phone_action.PhoneActionFragment_MembersInjector;
import com.avito.android.profile_phones.phone_action.PhoneParcelableEntity;
import com.avito.android.profile_phones.phone_action.di.PhoneActionComponent;
import com.avito.android.profile_phones.phone_action.interactor.PhoneActionInteractor;
import com.avito.android.profile_phones.phone_action.resource_providers.PhoneActionResourceProvider;
import com.avito.android.profile_phones.phone_action.view_model.PhoneActionViewModelFactory;
import com.avito.android.profile_phones.phones_list.list_item.PhoneActionCode;
import com.avito.android.remote.ProfileApi;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import java.util.List;
import javax.inject.Provider;
public final class DaggerPhoneActionComponent implements PhoneActionComponent {
    public final PhoneActionDependencies a;
    public Provider<String> b;
    public Provider<Integer> c;
    public Provider<List<PhoneParcelableEntity>> d;
    public Provider<PhoneActionCode> e;
    public Provider<PhoneActionResourceProvider> f;
    public Provider<ProfileApi> g;
    public Provider<SchedulersFactory3> h;
    public Provider<PhoneActionInteractor> i;

    public static final class b implements PhoneActionComponent.Builder {
        public PhoneActionDependencies a;
        public PhoneActionModule b;

        public b(a aVar) {
        }

        @Override // com.avito.android.profile_phones.phone_action.di.PhoneActionComponent.Builder
        public PhoneActionComponent build() {
            Preconditions.checkBuilderRequirement(this.a, PhoneActionDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, PhoneActionModule.class);
            return new DaggerPhoneActionComponent(this.b, this.a, null);
        }

        @Override // com.avito.android.profile_phones.phone_action.di.PhoneActionComponent.Builder
        public PhoneActionComponent.Builder dependencies(PhoneActionDependencies phoneActionDependencies) {
            this.a = (PhoneActionDependencies) Preconditions.checkNotNull(phoneActionDependencies);
            return this;
        }

        @Override // com.avito.android.profile_phones.phone_action.di.PhoneActionComponent.Builder
        public PhoneActionComponent.Builder phoneActionModule(PhoneActionModule phoneActionModule) {
            this.b = (PhoneActionModule) Preconditions.checkNotNull(phoneActionModule);
            return this;
        }
    }

    public static class c implements Provider<ProfileApi> {
        public final PhoneActionDependencies a;

        public c(PhoneActionDependencies phoneActionDependencies) {
            this.a = phoneActionDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ProfileApi get() {
            return (ProfileApi) Preconditions.checkNotNullFromComponent(this.a.profileApi());
        }
    }

    public static class d implements Provider<SchedulersFactory3> {
        public final PhoneActionDependencies a;

        public d(PhoneActionDependencies phoneActionDependencies) {
            this.a = phoneActionDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory3 get() {
            return (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3());
        }
    }

    public DaggerPhoneActionComponent(PhoneActionModule phoneActionModule, PhoneActionDependencies phoneActionDependencies, a aVar) {
        this.a = phoneActionDependencies;
        this.b = DoubleCheck.provider(PhoneActionModule_ProvidePhone$profile_phones_releaseFactory.create(phoneActionModule));
        this.c = DoubleCheck.provider(PhoneActionModule_ProvidePhoneAdvertsCount$profile_phones_releaseFactory.create(phoneActionModule));
        this.d = DoubleCheck.provider(PhoneActionModule_ProvideReplacingPhones$profile_phones_releaseFactory.create(phoneActionModule));
        this.e = DoubleCheck.provider(PhoneActionModule_ProvidePhoneActionCode$profile_phones_releaseFactory.create(phoneActionModule));
        this.f = DoubleCheck.provider(PhoneActionModule_ProvideRemovingPhoneResourceProvider$profile_phones_releaseFactory.create(phoneActionModule));
        c cVar = new c(phoneActionDependencies);
        this.g = cVar;
        d dVar = new d(phoneActionDependencies);
        this.h = dVar;
        this.i = DoubleCheck.provider(PhoneActionModule_ProvideRemovePhoneInteractor$profile_phones_releaseFactory.create(phoneActionModule, cVar, dVar));
    }

    public static PhoneActionComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.profile_phones.phone_action.di.PhoneActionComponent
    public void inject(PhoneActionFragment phoneActionFragment) {
        PhoneActionFragment_MembersInjector.injectViewModelFactory(phoneActionFragment, new PhoneActionViewModelFactory(this.b.get(), this.c.get().intValue(), this.d.get(), this.e.get(), this.f.get(), this.i.get()));
        PhoneActionFragment_MembersInjector.injectActivityIntentFactory(phoneActionFragment, (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.a.intentFactory()));
    }
}
