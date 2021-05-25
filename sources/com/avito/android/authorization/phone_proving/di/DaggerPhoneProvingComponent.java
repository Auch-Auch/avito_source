package com.avito.android.authorization.phone_proving.di;

import android.app.Activity;
import android.content.res.Resources;
import com.avito.android.analytics.Analytics;
import com.avito.android.authorization.phone_proving.PhoneProvingActivity;
import com.avito.android.authorization.phone_proving.PhoneProvingActivity_MembersInjector;
import com.avito.android.authorization.phone_proving.PhoneProvingInteractor;
import com.avito.android.authorization.phone_proving.PhoneProvingInteractorImpl;
import com.avito.android.authorization.phone_proving.PhoneProvingInteractorImpl_Factory;
import com.avito.android.authorization.phone_proving.PhoneProvingPresenter;
import com.avito.android.authorization.phone_proving.PhoneProvingPresenterImpl;
import com.avito.android.authorization.phone_proving.PhoneProvingPresenterImpl_Factory;
import com.avito.android.authorization.phone_proving.di.PhoneProvingComponent;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.di.DialogRouterModule_ProvideDialogRouterFactory;
import com.avito.android.dialog.DialogPresenter;
import com.avito.android.dialog.DialogPresenterImpl;
import com.avito.android.dialog.DialogPresenterImpl_Factory;
import com.avito.android.error_helper.ErrorHelper;
import com.avito.android.error_helper.ErrorHelperImpl;
import com.avito.android.error_helper.ErrorHelperImpl_Factory;
import com.avito.android.remote.ProfileApi;
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
public final class DaggerPhoneProvingComponent implements PhoneProvingComponent {
    public final PhoneProvingDependencies a;
    public Provider<String> b;
    public Provider<String> c;
    public Provider<String> d;
    public Provider<Boolean> e;
    public Provider<ProfileApi> f;
    public Provider<SchedulersFactory> g;
    public Provider<PhoneProvingInteractorImpl> h;
    public Provider<PhoneProvingInteractor> i;
    public Provider<Activity> j;
    public Provider<DialogRouter> k;
    public Provider<DialogPresenterImpl> l;
    public Provider<DialogPresenter> m;
    public Provider<Resources> n;
    public Provider<ErrorFormatterImpl> o;
    public Provider<ErrorFormatter> p;
    public Provider<ErrorHelperImpl> q;
    public Provider<ErrorHelper> r;
    public Provider<Analytics> s;
    public Provider<Kundle> t;
    public Provider<PhoneProvingPresenterImpl> u;
    public Provider<PhoneProvingPresenter> v;

    public static final class b implements PhoneProvingComponent.Builder {
        public PhoneProvingDependencies a;
        public Activity b;
        public Resources c;
        public Kundle d;
        public String e;
        public String f;
        public String g;
        public Boolean h;

        public b(a aVar) {
        }

        @Override // com.avito.android.authorization.phone_proving.di.PhoneProvingComponent.Builder
        public PhoneProvingComponent build() {
            Preconditions.checkBuilderRequirement(this.a, PhoneProvingDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, Activity.class);
            Preconditions.checkBuilderRequirement(this.c, Resources.class);
            Preconditions.checkBuilderRequirement(this.e, String.class);
            Preconditions.checkBuilderRequirement(this.f, String.class);
            Preconditions.checkBuilderRequirement(this.g, String.class);
            Preconditions.checkBuilderRequirement(this.h, Boolean.class);
            return new DaggerPhoneProvingComponent(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, null);
        }

        @Override // com.avito.android.authorization.phone_proving.di.PhoneProvingComponent.Builder
        public PhoneProvingComponent.Builder dependentOn(PhoneProvingDependencies phoneProvingDependencies) {
            this.a = (PhoneProvingDependencies) Preconditions.checkNotNull(phoneProvingDependencies);
            return this;
        }

        @Override // com.avito.android.authorization.phone_proving.di.PhoneProvingComponent.Builder
        public PhoneProvingComponent.Builder withActivity(Activity activity) {
            this.b = (Activity) Preconditions.checkNotNull(activity);
            return this;
        }

        @Override // com.avito.android.authorization.phone_proving.di.PhoneProvingComponent.Builder
        public PhoneProvingComponent.Builder withChallengeId(String str) {
            this.e = (String) Preconditions.checkNotNull(str);
            return this;
        }

        @Override // com.avito.android.authorization.phone_proving.di.PhoneProvingComponent.Builder
        public PhoneProvingComponent.Builder withInputHint(String str) {
            this.g = (String) Preconditions.checkNotNull(str);
            return this;
        }

        @Override // com.avito.android.authorization.phone_proving.di.PhoneProvingComponent.Builder
        public PhoneProvingComponent.Builder withIsOpenedFromPhoneListFlag(boolean z) {
            this.h = (Boolean) Preconditions.checkNotNull(Boolean.valueOf(z));
            return this;
        }

        @Override // com.avito.android.authorization.phone_proving.di.PhoneProvingComponent.Builder
        public PhoneProvingComponent.Builder withPhonePart(String str) {
            this.f = (String) Preconditions.checkNotNull(str);
            return this;
        }

        @Override // com.avito.android.authorization.phone_proving.di.PhoneProvingComponent.Builder
        public PhoneProvingComponent.Builder withPresenterState(Kundle kundle) {
            this.d = kundle;
            return this;
        }

        @Override // com.avito.android.authorization.phone_proving.di.PhoneProvingComponent.Builder
        public PhoneProvingComponent.Builder withResources(Resources resources) {
            this.c = (Resources) Preconditions.checkNotNull(resources);
            return this;
        }
    }

    public static class c implements Provider<Analytics> {
        public final PhoneProvingDependencies a;

        public c(PhoneProvingDependencies phoneProvingDependencies) {
            this.a = phoneProvingDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Analytics get() {
            return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
        }
    }

    public static class d implements Provider<ProfileApi> {
        public final PhoneProvingDependencies a;

        public d(PhoneProvingDependencies phoneProvingDependencies) {
            this.a = phoneProvingDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ProfileApi get() {
            return (ProfileApi) Preconditions.checkNotNullFromComponent(this.a.profileApi());
        }
    }

    public static class e implements Provider<SchedulersFactory> {
        public final PhoneProvingDependencies a;

        public e(PhoneProvingDependencies phoneProvingDependencies) {
            this.a = phoneProvingDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public DaggerPhoneProvingComponent(PhoneProvingDependencies phoneProvingDependencies, Activity activity, Resources resources, Kundle kundle, String str, String str2, String str3, Boolean bool, a aVar) {
        this.a = phoneProvingDependencies;
        this.b = InstanceFactory.create(str);
        this.c = InstanceFactory.create(str2);
        this.d = InstanceFactory.create(str3);
        this.e = InstanceFactory.create(bool);
        d dVar = new d(phoneProvingDependencies);
        this.f = dVar;
        e eVar = new e(phoneProvingDependencies);
        this.g = eVar;
        PhoneProvingInteractorImpl_Factory create = PhoneProvingInteractorImpl_Factory.create(dVar, eVar);
        this.h = create;
        this.i = DoubleCheck.provider(create);
        Factory create2 = InstanceFactory.create(activity);
        this.j = create2;
        Provider<DialogRouter> provider = SingleCheck.provider(DialogRouterModule_ProvideDialogRouterFactory.create(create2));
        this.k = provider;
        DialogPresenterImpl_Factory create3 = DialogPresenterImpl_Factory.create(this.j, provider);
        this.l = create3;
        this.m = SingleCheck.provider(create3);
        Factory create4 = InstanceFactory.create(resources);
        this.n = create4;
        ErrorFormatterImpl_Factory create5 = ErrorFormatterImpl_Factory.create(create4);
        this.o = create5;
        Provider<ErrorFormatter> provider2 = SingleCheck.provider(create5);
        this.p = provider2;
        ErrorHelperImpl_Factory create6 = ErrorHelperImpl_Factory.create(provider2);
        this.q = create6;
        this.r = SingleCheck.provider(create6);
        this.s = new c(phoneProvingDependencies);
        Factory createNullable = InstanceFactory.createNullable(kundle);
        this.t = createNullable;
        PhoneProvingPresenterImpl_Factory create7 = PhoneProvingPresenterImpl_Factory.create(this.b, this.c, this.d, this.e, this.i, this.m, this.r, this.g, this.s, createNullable);
        this.u = create7;
        this.v = DoubleCheck.provider(create7);
    }

    public static PhoneProvingComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.authorization.phone_proving.di.PhoneProvingComponent
    public void inject(PhoneProvingActivity phoneProvingActivity) {
        PhoneProvingActivity_MembersInjector.injectPresenter(phoneProvingActivity, this.v.get());
        PhoneProvingActivity_MembersInjector.injectDeepLinkIntentFactory(phoneProvingActivity, (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deepLinkIntentFactory()));
    }
}
