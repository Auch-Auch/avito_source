package com.avito.android.profile_phones.phone_management.di;

import android.app.Activity;
import android.content.res.Resources;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.code_confirmation.CodeConfirmationInteractor;
import com.avito.android.code_confirmation.CodeConfirmationResourceProvider;
import com.avito.android.code_confirmation.CodeConfirmationResourceProviderImpl;
import com.avito.android.code_confirmation.CodeConfirmationResourceProviderImpl_Factory;
import com.avito.android.code_confirmation.di.CodeConfirmationModule_ProvideCodeConfirmationInteractor$code_confirmation_releaseFactory;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.di.DialogRouterModule_ProvideDialogRouterFactory;
import com.avito.android.error_helper.ErrorHelper;
import com.avito.android.error_helper.ErrorHelperImpl;
import com.avito.android.error_helper.ErrorHelperImpl_Factory;
import com.avito.android.profile_phones.phone_management.PhoneManagementActivity;
import com.avito.android.profile_phones.phone_management.PhoneManagementActivity_MembersInjector;
import com.avito.android.profile_phones.phone_management.PhoneManagementInteractor;
import com.avito.android.profile_phones.phone_management.PhoneManagementInteractorImpl;
import com.avito.android.profile_phones.phone_management.PhoneManagementInteractorImpl_Factory;
import com.avito.android.profile_phones.phone_management.PhoneManagementPresenter;
import com.avito.android.profile_phones.phone_management.PhoneManagementPresenterImpl;
import com.avito.android.profile_phones.phone_management.PhoneManagementPresenterImpl_Factory;
import com.avito.android.profile_phones.phone_management.PhoneManagementResourceProvider;
import com.avito.android.profile_phones.phone_management.di.PhoneManagementComponent;
import com.avito.android.remote.ProfileApi;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.util.DialogRouter;
import com.avito.android.util.ErrorFormatter;
import com.avito.android.util.ErrorFormatterImpl;
import com.avito.android.util.ErrorFormatterImpl_Factory;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import javax.inject.Provider;
public final class DaggerPhoneManagementComponent implements PhoneManagementComponent {
    public final PhoneManagementDependencies a;
    public Provider<ProfileApi> b;
    public Provider<SchedulersFactory> c;
    public Provider<Resources> d;
    public Provider<CodeConfirmationResourceProviderImpl> e;
    public Provider<CodeConfirmationResourceProvider> f;
    public Provider<TypedErrorThrowableConverter> g;
    public Provider<String> h;
    public Provider<Boolean> i;
    public Provider<CodeConfirmationInteractor> j;
    public Provider<PhoneManagementInteractorImpl> k;
    public Provider<PhoneManagementInteractor> l;
    public Provider<Boolean> m;
    public Provider<PhoneManagementResourceProvider> n;
    public Provider<ErrorFormatterImpl> o;
    public Provider<ErrorFormatter> p;
    public Provider<ErrorHelperImpl> q;
    public Provider<ErrorHelper> r;
    public Provider<Kundle> s;
    public Provider<PhoneManagementPresenterImpl> t;
    public Provider<PhoneManagementPresenter> u;
    public Provider<Activity> v;
    public Provider<DialogRouter> w;

    public static final class b implements PhoneManagementComponent.Builder {
        public PhoneManagementDependencies a;
        public Resources b;
        public Activity c;
        public Kundle d;
        public Boolean e;
        public String f;
        public Boolean g;

        public b(a aVar) {
        }

        @Override // com.avito.android.profile_phones.phone_management.di.PhoneManagementComponent.Builder
        public PhoneManagementComponent build() {
            Preconditions.checkBuilderRequirement(this.a, PhoneManagementDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, Resources.class);
            Preconditions.checkBuilderRequirement(this.c, Activity.class);
            Preconditions.checkBuilderRequirement(this.e, Boolean.class);
            Preconditions.checkBuilderRequirement(this.f, String.class);
            Preconditions.checkBuilderRequirement(this.g, Boolean.class);
            return new DaggerPhoneManagementComponent(this.a, this.b, this.c, this.d, this.e, this.f, this.g, null);
        }

        @Override // com.avito.android.profile_phones.phone_management.di.PhoneManagementComponent.Builder
        public PhoneManagementComponent.Builder dependentOn(PhoneManagementDependencies phoneManagementDependencies) {
            this.a = (PhoneManagementDependencies) Preconditions.checkNotNull(phoneManagementDependencies);
            return this;
        }

        @Override // com.avito.android.profile_phones.phone_management.di.PhoneManagementComponent.Builder
        public PhoneManagementComponent.Builder withActivity(Activity activity) {
            this.c = (Activity) Preconditions.checkNotNull(activity);
            return this;
        }

        @Override // com.avito.android.profile_phones.phone_management.di.PhoneManagementComponent.Builder
        public PhoneManagementComponent.Builder withFromProfile(boolean z) {
            this.e = (Boolean) Preconditions.checkNotNull(Boolean.valueOf(z));
            return this;
        }

        @Override // com.avito.android.profile_phones.phone_management.di.PhoneManagementComponent.Builder
        public PhoneManagementComponent.Builder withPresenterState(Kundle kundle) {
            this.d = kundle;
            return this;
        }

        @Override // com.avito.android.profile_phones.phone_management.di.PhoneManagementComponent.Builder
        public PhoneManagementComponent.Builder withResources(Resources resources) {
            this.b = (Resources) Preconditions.checkNotNull(resources);
            return this;
        }

        @Override // com.avito.android.profile_phones.phone_management.di.PhoneManagementComponent.Builder
        public PhoneManagementComponent.Builder withRetry(boolean z) {
            this.g = (Boolean) Preconditions.checkNotNull(Boolean.valueOf(z));
            return this;
        }

        @Override // com.avito.android.profile_phones.phone_management.di.PhoneManagementComponent.Builder
        public PhoneManagementComponent.Builder withSrc(String str) {
            this.f = (String) Preconditions.checkNotNull(str);
            return this;
        }
    }

    public static class c implements Provider<ProfileApi> {
        public final PhoneManagementDependencies a;

        public c(PhoneManagementDependencies phoneManagementDependencies) {
            this.a = phoneManagementDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ProfileApi get() {
            return (ProfileApi) Preconditions.checkNotNullFromComponent(this.a.profileApi());
        }
    }

    public static class d implements Provider<SchedulersFactory> {
        public final PhoneManagementDependencies a;

        public d(PhoneManagementDependencies phoneManagementDependencies) {
            this.a = phoneManagementDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public static class e implements Provider<TypedErrorThrowableConverter> {
        public final PhoneManagementDependencies a;

        public e(PhoneManagementDependencies phoneManagementDependencies) {
            this.a = phoneManagementDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TypedErrorThrowableConverter get() {
            return (TypedErrorThrowableConverter) Preconditions.checkNotNullFromComponent(this.a.typedErrorThrowableConverter());
        }
    }

    public DaggerPhoneManagementComponent(PhoneManagementDependencies phoneManagementDependencies, Resources resources, Activity activity, Kundle kundle, Boolean bool, String str, Boolean bool2, a aVar) {
        this.a = phoneManagementDependencies;
        this.b = new c(phoneManagementDependencies);
        this.c = new d(phoneManagementDependencies);
        Factory create = InstanceFactory.create(resources);
        this.d = create;
        CodeConfirmationResourceProviderImpl_Factory create2 = CodeConfirmationResourceProviderImpl_Factory.create(create);
        this.e = create2;
        this.f = DoubleCheck.provider(create2);
        this.g = new e(phoneManagementDependencies);
        this.h = InstanceFactory.create(str);
        Factory create3 = InstanceFactory.create(bool2);
        this.i = create3;
        Provider<CodeConfirmationInteractor> provider = DoubleCheck.provider(CodeConfirmationModule_ProvideCodeConfirmationInteractor$code_confirmation_releaseFactory.create(this.b, this.c, this.f, this.g, this.h, create3));
        this.j = provider;
        PhoneManagementInteractorImpl_Factory create4 = PhoneManagementInteractorImpl_Factory.create(this.b, provider, this.c);
        this.k = create4;
        this.l = DoubleCheck.provider(create4);
        Factory create5 = InstanceFactory.create(bool);
        this.m = create5;
        this.n = DoubleCheck.provider(PhoneManagementModule_ProvidePhoneManagementResourceProvider$profile_phones_releaseFactory.create(create5, this.d));
        ErrorFormatterImpl_Factory create6 = ErrorFormatterImpl_Factory.create(this.d);
        this.o = create6;
        Provider<ErrorFormatter> provider2 = SingleCheck.provider(create6);
        this.p = provider2;
        ErrorHelperImpl_Factory create7 = ErrorHelperImpl_Factory.create(provider2);
        this.q = create7;
        this.r = SingleCheck.provider(create7);
        Factory createNullable = InstanceFactory.createNullable(kundle);
        this.s = createNullable;
        PhoneManagementPresenterImpl_Factory create8 = PhoneManagementPresenterImpl_Factory.create(this.l, this.n, this.c, this.r, this.m, this.h, createNullable);
        this.t = create8;
        this.u = DoubleCheck.provider(create8);
        Factory create9 = InstanceFactory.create(activity);
        this.v = create9;
        this.w = SingleCheck.provider(DialogRouterModule_ProvideDialogRouterFactory.create(create9));
    }

    public static PhoneManagementComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.profile_phones.phone_management.di.PhoneManagementComponent
    public void inject(PhoneManagementActivity phoneManagementActivity) {
        PhoneManagementActivity_MembersInjector.injectIntentFactory(phoneManagementActivity, (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.a.activityIntentFactory()));
        PhoneManagementActivity_MembersInjector.injectDeepLinkIntentFactory(phoneManagementActivity, (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deepLinkIntentFactory()));
        PhoneManagementActivity_MembersInjector.injectPresenter(phoneManagementActivity, this.u.get());
        PhoneManagementActivity_MembersInjector.injectDialogRouter(phoneManagementActivity, this.w.get());
    }
}
