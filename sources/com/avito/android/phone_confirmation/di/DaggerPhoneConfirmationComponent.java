package com.avito.android.phone_confirmation.di;

import android.app.Activity;
import com.avito.android.phone_confirmation.PhoneConfirmationActivity;
import com.avito.android.phone_confirmation.PhoneConfirmationActivity_MembersInjector;
import com.avito.android.phone_confirmation.PhoneConfirmationInteractor;
import com.avito.android.phone_confirmation.PhoneConfirmationRouter;
import com.avito.android.phone_confirmation.PhoneConfirmationRouterImpl;
import com.avito.android.phone_confirmation.PhoneConfirmationRouterImpl_Factory;
import com.avito.android.phone_confirmation.di.PhoneConfirmationComponent;
import com.avito.android.phone_confirmation.state.PhoneConfirmationScreenState;
import com.avito.android.phone_confirmation.state.PhoneConfirmationTimeStorage;
import com.avito.android.phone_confirmation.state.PhoneConfirmationTimeStorageImpl;
import com.avito.android.phone_confirmation.state.PhoneConfirmationTimeStorageImpl_Factory;
import com.avito.android.remote.ProfileApi;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.PhoneNumberFormatterModule_ProvidePhoneNumberFormatterWithCountryCodeFactory;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.preferences.Preferences;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class DaggerPhoneConfirmationComponent implements PhoneConfirmationComponent {
    public final PhoneConfirmationDependencies a;
    public Provider<Boolean> b;
    public Provider<ProfileApi> c;
    public Provider<TimeSource> d;
    public Provider<Preferences> e;
    public Provider<PhoneConfirmationTimeStorageImpl> f;
    public Provider<PhoneConfirmationTimeStorage> g;
    public Provider<PhoneConfirmationScreenState> h;
    public Provider<PhoneConfirmationInteractor> i;
    public Provider<Activity> j;
    public Provider<PhoneConfirmationRouterImpl> k;
    public Provider<PhoneConfirmationRouter> l;

    public static final class b implements PhoneConfirmationComponent.Builder {
        public PhoneConfirmationDependencies a;
        public Activity b;
        public PhoneConfirmationScreenState c;
        public Boolean d;

        public b(a aVar) {
        }

        @Override // com.avito.android.phone_confirmation.di.PhoneConfirmationComponent.Builder
        public PhoneConfirmationComponent build() {
            Preconditions.checkBuilderRequirement(this.a, PhoneConfirmationDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, Activity.class);
            Preconditions.checkBuilderRequirement(this.c, PhoneConfirmationScreenState.class);
            Preconditions.checkBuilderRequirement(this.d, Boolean.class);
            return new DaggerPhoneConfirmationComponent(new PhoneConfirmationModule(), this.a, this.b, this.c, this.d, null);
        }

        @Override // com.avito.android.phone_confirmation.di.PhoneConfirmationComponent.Builder
        public PhoneConfirmationComponent.Builder dependentOn(PhoneConfirmationDependencies phoneConfirmationDependencies) {
            this.a = (PhoneConfirmationDependencies) Preconditions.checkNotNull(phoneConfirmationDependencies);
            return this;
        }

        @Override // com.avito.android.phone_confirmation.di.PhoneConfirmationComponent.Builder
        public PhoneConfirmationComponent.Builder withActivity(Activity activity) {
            this.b = (Activity) Preconditions.checkNotNull(activity);
            return this;
        }

        @Override // com.avito.android.phone_confirmation.di.PhoneConfirmationComponent.Builder
        public PhoneConfirmationComponent.Builder withConfirmationType(boolean z) {
            this.d = (Boolean) Preconditions.checkNotNull(Boolean.valueOf(z));
            return this;
        }

        @Override // com.avito.android.phone_confirmation.di.PhoneConfirmationComponent.Builder
        public PhoneConfirmationComponent.Builder withInitialState(PhoneConfirmationScreenState phoneConfirmationScreenState) {
            this.c = (PhoneConfirmationScreenState) Preconditions.checkNotNull(phoneConfirmationScreenState);
            return this;
        }
    }

    public static class c implements Provider<Preferences> {
        public final PhoneConfirmationDependencies a;

        public c(PhoneConfirmationDependencies phoneConfirmationDependencies) {
            this.a = phoneConfirmationDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Preferences get() {
            return (Preferences) Preconditions.checkNotNullFromComponent(this.a.preferences());
        }
    }

    public static class d implements Provider<ProfileApi> {
        public final PhoneConfirmationDependencies a;

        public d(PhoneConfirmationDependencies phoneConfirmationDependencies) {
            this.a = phoneConfirmationDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ProfileApi get() {
            return (ProfileApi) Preconditions.checkNotNullFromComponent(this.a.profileApi());
        }
    }

    public static class e implements Provider<TimeSource> {
        public final PhoneConfirmationDependencies a;

        public e(PhoneConfirmationDependencies phoneConfirmationDependencies) {
            this.a = phoneConfirmationDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TimeSource get() {
            return (TimeSource) Preconditions.checkNotNullFromComponent(this.a.timeSource());
        }
    }

    public DaggerPhoneConfirmationComponent(PhoneConfirmationModule phoneConfirmationModule, PhoneConfirmationDependencies phoneConfirmationDependencies, Activity activity, PhoneConfirmationScreenState phoneConfirmationScreenState, Boolean bool, a aVar) {
        this.a = phoneConfirmationDependencies;
        this.b = InstanceFactory.create(bool);
        this.c = new d(phoneConfirmationDependencies);
        this.d = new e(phoneConfirmationDependencies);
        c cVar = new c(phoneConfirmationDependencies);
        this.e = cVar;
        PhoneConfirmationTimeStorageImpl_Factory create = PhoneConfirmationTimeStorageImpl_Factory.create(cVar);
        this.f = create;
        this.g = DoubleCheck.provider(create);
        Factory create2 = InstanceFactory.create(phoneConfirmationScreenState);
        this.h = create2;
        this.i = DoubleCheck.provider(PhoneConfirmationModule_ProvidePhoneConfirmationInteractorFactory.create(phoneConfirmationModule, this.b, this.c, this.d, this.g, create2, PhoneNumberFormatterModule_ProvidePhoneNumberFormatterWithCountryCodeFactory.create()));
        Factory create3 = InstanceFactory.create(activity);
        this.j = create3;
        PhoneConfirmationRouterImpl_Factory create4 = PhoneConfirmationRouterImpl_Factory.create(create3);
        this.k = create4;
        this.l = DoubleCheck.provider(create4);
    }

    public static PhoneConfirmationComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.phone_confirmation.di.PhoneConfirmationComponent
    public void inject(PhoneConfirmationActivity phoneConfirmationActivity) {
        PhoneConfirmationActivity_MembersInjector.injectInteractor(phoneConfirmationActivity, this.i.get());
        PhoneConfirmationActivity_MembersInjector.injectRouter(phoneConfirmationActivity, this.l.get());
        PhoneConfirmationActivity_MembersInjector.injectSchedulers(phoneConfirmationActivity, (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory()));
        PhoneConfirmationActivity_MembersInjector.injectBuild(phoneConfirmationActivity, (BuildInfo) Preconditions.checkNotNullFromComponent(this.a.buildInfo()));
    }
}
