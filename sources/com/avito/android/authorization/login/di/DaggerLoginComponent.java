package com.avito.android.authorization.login.di;

import android.app.Activity;
import android.content.res.Resources;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.account.AccountInteractor;
import com.avito.android.account.LastLoggedEmailStorage;
import com.avito.android.analytics.Analytics;
import com.avito.android.authorization.login.LoginActivity;
import com.avito.android.authorization.login.LoginActivity_MembersInjector;
import com.avito.android.authorization.login.LoginInteractor;
import com.avito.android.authorization.login.LoginInteractorImpl;
import com.avito.android.authorization.login.LoginInteractorImpl_Factory;
import com.avito.android.authorization.login.LoginPresenter;
import com.avito.android.authorization.login.LoginPresenterImpl;
import com.avito.android.authorization.login.LoginPresenterImpl_Factory;
import com.avito.android.authorization.login.LoginResourceProvider;
import com.avito.android.authorization.login.LoginResourceProviderImpl;
import com.avito.android.authorization.login.LoginResourceProviderImpl_Factory;
import com.avito.android.authorization.login.di.LoginComponent;
import com.avito.android.authorization.reset_password.ResetPasswordInteractor;
import com.avito.android.authorization.reset_password.ResetPasswordInteractorImpl;
import com.avito.android.authorization.reset_password.ResetPasswordInteractorImpl_Factory;
import com.avito.android.authorization.smart_lock.SmartLockSaver;
import com.avito.android.authorization.smart_lock.di.SmartLockSaverModule_ProvideSmartLockSaverFactory;
import com.avito.android.code_confirmation.CodeConfirmationInteractor;
import com.avito.android.code_confirmation.CodeConfirmationResourceProvider;
import com.avito.android.code_confirmation.CodeConfirmationResourceProviderImpl;
import com.avito.android.code_confirmation.CodeConfirmationResourceProviderImpl_Factory;
import com.avito.android.code_confirmation.PhoneAntihackInteractor;
import com.avito.android.code_confirmation.PhoneAntihackInteractorImpl;
import com.avito.android.code_confirmation.PhoneAntihackInteractorImpl_Factory;
import com.avito.android.code_confirmation.di.CodeConfirmationModule_ProvideCodeConfirmationInteractor$code_confirmation_releaseFactory;
import com.avito.android.code_confirmation.di.CodeConfirmationModule_ProvideLoginCodeConfirmationInteractor$code_confirmation_releaseFactory;
import com.avito.android.code_confirmation.tfa.TfaInteractor;
import com.avito.android.code_confirmation.tfa.TfaInteractorImpl;
import com.avito.android.code_confirmation.tfa.TfaInteractorImpl_Factory;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.di.DialogRouterModule_ProvideDialogRouterFactory;
import com.avito.android.error_helper.ErrorHelper;
import com.avito.android.error_helper.ErrorHelperImpl;
import com.avito.android.error_helper.ErrorHelperImpl_Factory;
import com.avito.android.profile.ProfileInfoStorage;
import com.avito.android.remote.ProfileApi;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.remote.model.text.AttributedTextCreator;
import com.avito.android.remote.model.text.AttributedTextCreatorImpl_Factory;
import com.avito.android.shared_providers.SupportEmailResourceProvider;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.DialogRouter;
import com.avito.android.util.ErrorFormatter;
import com.avito.android.util.ErrorFormatterImpl;
import com.avito.android.util.ErrorFormatterImpl_Factory;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.android.util.text.AttributedTextFormatterModule_ProvideAttributedTextFormatterFactory;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import javax.inject.Provider;
public final class DaggerLoginComponent implements LoginComponent {
    public Provider<BuildInfo> A;
    public Provider<SupportEmailResourceProvider> B;
    public Provider<LastLoggedEmailStorage> C;
    public Provider<Activity> D;
    public Provider<Analytics> E;
    public Provider<Features> F;
    public Provider<Kundle> G;
    public Provider<SmartLockSaver> H;
    public Provider<ErrorFormatterImpl> I;
    public Provider<ErrorFormatter> J;
    public Provider<ErrorHelperImpl> K;
    public Provider<ErrorHelper> L;
    public Provider<Kundle> M;
    public Provider<String> N;
    public Provider<LoginPresenterImpl> O;
    public Provider<LoginPresenter> P;
    public Provider<DialogRouter> Q;
    public final LoginDependencies a;
    public Provider<AccountInteractor> b;
    public Provider<ProfileApi> c;
    public Provider<SchedulersFactory> d;
    public Provider<Resources> e;
    public Provider<CodeConfirmationResourceProviderImpl> f;
    public Provider<CodeConfirmationResourceProvider> g;
    public Provider<TypedErrorThrowableConverter> h;
    public Provider<String> i;
    public Provider<Boolean> j;
    public Provider<CodeConfirmationInteractor> k;
    public Provider<LoginInteractorImpl> l;
    public Provider<LoginInteractor> m;
    public Provider<CodeConfirmationInteractor> n = DoubleCheck.provider(CodeConfirmationModule_ProvideLoginCodeConfirmationInteractor$code_confirmation_releaseFactory.create(this.c, this.d, this.g));
    public Provider<LoginResourceProviderImpl> o;
    public Provider<LoginResourceProvider> p;
    public Provider<ResetPasswordInteractorImpl> q;
    public Provider<ResetPasswordInteractor> r;
    public Provider<PhoneAntihackInteractorImpl> s;
    public Provider<PhoneAntihackInteractor> t;
    public Provider<SchedulersFactory3> u;
    public Provider<TfaInteractorImpl> v;
    public Provider<TfaInteractor> w;
    public Provider<AttributedTextCreator> x;
    public Provider<AttributedTextFormatter> y;
    public Provider<ProfileInfoStorage> z;

    public static final class b implements LoginComponent.Builder {
        public LoginDependencies a;
        public Activity b;
        public Resources c;
        public Kundle d;
        public Kundle e;
        public String f;
        public String g;
        public Boolean h;

        public b(a aVar) {
        }

        @Override // com.avito.android.authorization.login.di.LoginComponent.Builder
        public LoginComponent build() {
            Preconditions.checkBuilderRequirement(this.a, LoginDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, Activity.class);
            Preconditions.checkBuilderRequirement(this.c, Resources.class);
            Preconditions.checkBuilderRequirement(this.f, String.class);
            Preconditions.checkBuilderRequirement(this.g, String.class);
            Preconditions.checkBuilderRequirement(this.h, Boolean.class);
            return new DaggerLoginComponent(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, null);
        }

        @Override // com.avito.android.authorization.login.di.LoginComponent.Builder
        public LoginComponent.Builder dependentOn(LoginDependencies loginDependencies) {
            this.a = (LoginDependencies) Preconditions.checkNotNull(loginDependencies);
            return this;
        }

        @Override // com.avito.android.authorization.login.di.LoginComponent.Builder
        public LoginComponent.Builder withActivity(Activity activity) {
            this.b = (Activity) Preconditions.checkNotNull(activity);
            return this;
        }

        @Override // com.avito.android.authorization.login.di.LoginComponent.Builder
        public LoginComponent.Builder withPresenterState(Kundle kundle) {
            this.d = kundle;
            return this;
        }

        @Override // com.avito.android.authorization.login.di.LoginComponent.Builder
        public LoginComponent.Builder withResources(Resources resources) {
            this.c = (Resources) Preconditions.checkNotNull(resources);
            return this;
        }

        @Override // com.avito.android.authorization.login.di.LoginComponent.Builder
        public LoginComponent.Builder withRetry(boolean z) {
            this.h = (Boolean) Preconditions.checkNotNull(Boolean.valueOf(z));
            return this;
        }

        @Override // com.avito.android.authorization.login.di.LoginComponent.Builder
        public LoginComponent.Builder withSmartLockSaverState(Kundle kundle) {
            this.e = kundle;
            return this;
        }

        @Override // com.avito.android.authorization.login.di.LoginComponent.Builder
        public LoginComponent.Builder withSrc(String str) {
            this.f = (String) Preconditions.checkNotNull(str);
            return this;
        }

        @Override // com.avito.android.authorization.login.di.LoginComponent.Builder
        public LoginComponent.Builder withSuggestKey(String str) {
            this.g = (String) Preconditions.checkNotNull(str);
            return this;
        }
    }

    public static class c implements Provider<AccountInteractor> {
        public final LoginDependencies a;

        public c(LoginDependencies loginDependencies) {
            this.a = loginDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public AccountInteractor get() {
            return (AccountInteractor) Preconditions.checkNotNullFromComponent(this.a.accountInteractor());
        }
    }

    public static class d implements Provider<Analytics> {
        public final LoginDependencies a;

        public d(LoginDependencies loginDependencies) {
            this.a = loginDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Analytics get() {
            return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
        }
    }

    public static class e implements Provider<BuildInfo> {
        public final LoginDependencies a;

        public e(LoginDependencies loginDependencies) {
            this.a = loginDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public BuildInfo get() {
            return (BuildInfo) Preconditions.checkNotNullFromComponent(this.a.buildInfo());
        }
    }

    public static class f implements Provider<Features> {
        public final LoginDependencies a;

        public f(LoginDependencies loginDependencies) {
            this.a = loginDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Features get() {
            return (Features) Preconditions.checkNotNullFromComponent(this.a.features());
        }
    }

    public static class g implements Provider<LastLoggedEmailStorage> {
        public final LoginDependencies a;

        public g(LoginDependencies loginDependencies) {
            this.a = loginDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public LastLoggedEmailStorage get() {
            return (LastLoggedEmailStorage) Preconditions.checkNotNullFromComponent(this.a.lastLoggedEmailStorage());
        }
    }

    public static class h implements Provider<ProfileApi> {
        public final LoginDependencies a;

        public h(LoginDependencies loginDependencies) {
            this.a = loginDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ProfileApi get() {
            return (ProfileApi) Preconditions.checkNotNullFromComponent(this.a.profileApi());
        }
    }

    public static class i implements Provider<ProfileInfoStorage> {
        public final LoginDependencies a;

        public i(LoginDependencies loginDependencies) {
            this.a = loginDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ProfileInfoStorage get() {
            return (ProfileInfoStorage) Preconditions.checkNotNullFromComponent(this.a.profileInfoStorage());
        }
    }

    public static class j implements Provider<SchedulersFactory3> {
        public final LoginDependencies a;

        public j(LoginDependencies loginDependencies) {
            this.a = loginDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory3 get() {
            return (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3());
        }
    }

    public static class k implements Provider<SchedulersFactory> {
        public final LoginDependencies a;

        public k(LoginDependencies loginDependencies) {
            this.a = loginDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public static class l implements Provider<TypedErrorThrowableConverter> {
        public final LoginDependencies a;

        public l(LoginDependencies loginDependencies) {
            this.a = loginDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TypedErrorThrowableConverter get() {
            return (TypedErrorThrowableConverter) Preconditions.checkNotNullFromComponent(this.a.typedErrorThrowableConverter());
        }
    }

    public DaggerLoginComponent(LoginDependencies loginDependencies, Activity activity, Resources resources, Kundle kundle, Kundle kundle2, String str, String str2, Boolean bool, a aVar) {
        this.a = loginDependencies;
        this.b = new c(loginDependencies);
        this.c = new h(loginDependencies);
        this.d = new k(loginDependencies);
        Factory create = InstanceFactory.create(resources);
        this.e = create;
        CodeConfirmationResourceProviderImpl_Factory create2 = CodeConfirmationResourceProviderImpl_Factory.create(create);
        this.f = create2;
        this.g = DoubleCheck.provider(create2);
        this.h = new l(loginDependencies);
        this.i = InstanceFactory.create(str);
        Factory create3 = InstanceFactory.create(bool);
        this.j = create3;
        Provider<CodeConfirmationInteractor> provider = DoubleCheck.provider(CodeConfirmationModule_ProvideCodeConfirmationInteractor$code_confirmation_releaseFactory.create(this.c, this.d, this.g, this.h, this.i, create3));
        this.k = provider;
        LoginInteractorImpl_Factory create4 = LoginInteractorImpl_Factory.create(this.b, provider);
        this.l = create4;
        this.m = DoubleCheck.provider(create4);
        LoginResourceProviderImpl_Factory create5 = LoginResourceProviderImpl_Factory.create(this.e, this.g);
        this.o = create5;
        Provider<LoginResourceProvider> provider2 = DoubleCheck.provider(create5);
        this.p = provider2;
        ResetPasswordInteractorImpl_Factory create6 = ResetPasswordInteractorImpl_Factory.create(this.c, this.k, this.n, provider2, this.h, this.d);
        this.q = create6;
        this.r = DoubleCheck.provider(create6);
        PhoneAntihackInteractorImpl_Factory create7 = PhoneAntihackInteractorImpl_Factory.create(this.c, this.d, this.h, this.g);
        this.s = create7;
        this.t = DoubleCheck.provider(create7);
        j jVar = new j(loginDependencies);
        this.u = jVar;
        TfaInteractorImpl_Factory create8 = TfaInteractorImpl_Factory.create(this.c, jVar, this.g, this.h, this.b);
        this.v = create8;
        this.w = DoubleCheck.provider(create8);
        this.x = DoubleCheck.provider(AttributedTextCreatorImpl_Factory.create());
        this.y = SingleCheck.provider(AttributedTextFormatterModule_ProvideAttributedTextFormatterFactory.create());
        i iVar = new i(loginDependencies);
        this.z = iVar;
        e eVar = new e(loginDependencies);
        this.A = eVar;
        this.B = DoubleCheck.provider(LoginModule_ProvidesSupportEmailResourceProviderFactory.create(this.e, iVar, eVar));
        this.C = new g(loginDependencies);
        this.D = InstanceFactory.create(activity);
        this.E = new d(loginDependencies);
        this.F = new f(loginDependencies);
        Factory createNullable = InstanceFactory.createNullable(kundle2);
        this.G = createNullable;
        this.H = DoubleCheck.provider(SmartLockSaverModule_ProvideSmartLockSaverFactory.create(this.D, this.E, this.u, this.F, createNullable));
        ErrorFormatterImpl_Factory create9 = ErrorFormatterImpl_Factory.create(this.e);
        this.I = create9;
        Provider<ErrorFormatter> provider3 = SingleCheck.provider(create9);
        this.J = provider3;
        ErrorHelperImpl_Factory create10 = ErrorHelperImpl_Factory.create(provider3);
        this.K = create10;
        this.L = SingleCheck.provider(create10);
        this.M = InstanceFactory.createNullable(kundle);
        Factory create11 = InstanceFactory.create(str2);
        this.N = create11;
        LoginPresenterImpl_Factory create12 = LoginPresenterImpl_Factory.create(this.m, this.r, this.t, this.w, this.x, this.y, this.p, this.B, this.C, this.H, this.F, this.d, this.L, this.M, create11);
        this.O = create12;
        this.P = DoubleCheck.provider(create12);
        this.Q = SingleCheck.provider(DialogRouterModule_ProvideDialogRouterFactory.create(this.D));
    }

    public static LoginComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.authorization.login.di.LoginComponent
    public void inject(LoginActivity loginActivity) {
        LoginActivity_MembersInjector.injectPresenter(loginActivity, this.P.get());
        LoginActivity_MembersInjector.injectInteractor(loginActivity, this.m.get());
        LoginActivity_MembersInjector.injectAnalytics(loginActivity, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
        LoginActivity_MembersInjector.injectFeatures(loginActivity, (Features) Preconditions.checkNotNullFromComponent(this.a.features()));
        LoginActivity_MembersInjector.injectActivityIntentFactory(loginActivity, (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.a.activityIntentFactory()));
        LoginActivity_MembersInjector.injectDeepLinkIntentFactory(loginActivity, (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deepLinkIntentFactory()));
        LoginActivity_MembersInjector.injectDialogRouter(loginActivity, this.Q.get());
        LoginActivity_MembersInjector.injectSmartLock(loginActivity, this.H.get());
    }
}
