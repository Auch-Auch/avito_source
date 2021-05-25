package com.avito.android.code_confirmation.di;

import android.app.Activity;
import android.content.IntentFilter;
import android.content.res.Resources;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.account.AccountInteractor;
import com.avito.android.analytics.Analytics;
import com.avito.android.code_confirmation.CodeConfirmationActivity;
import com.avito.android.code_confirmation.CodeConfirmationActivity_MembersInjector;
import com.avito.android.code_confirmation.CodeConfirmationInteractor;
import com.avito.android.code_confirmation.CodeConfirmationPresenter;
import com.avito.android.code_confirmation.CodeConfirmationPresenterImpl;
import com.avito.android.code_confirmation.CodeConfirmationPresenterImpl_Factory;
import com.avito.android.code_confirmation.CodeConfirmationResourceProvider;
import com.avito.android.code_confirmation.CodeConfirmationResourceProviderImpl;
import com.avito.android.code_confirmation.CodeConfirmationResourceProviderImpl_Factory;
import com.avito.android.code_confirmation.CodeReceiver;
import com.avito.android.code_confirmation.CodeReceiverImpl;
import com.avito.android.code_confirmation.CodeReceiverImpl_Factory;
import com.avito.android.code_confirmation.PhoneAntihackInteractor;
import com.avito.android.code_confirmation.PhoneAntihackInteractorImpl;
import com.avito.android.code_confirmation.PhoneAntihackInteractorImpl_Factory;
import com.avito.android.code_confirmation.di.CodeConfirmationComponent;
import com.avito.android.code_confirmation.tfa.TfaInteractor;
import com.avito.android.code_confirmation.tfa.TfaInteractorImpl;
import com.avito.android.code_confirmation.tfa.TfaInteractorImpl_Factory;
import com.avito.android.code_confirmation.timer.RxTimer;
import com.avito.android.code_confirmation.timer.RxTimerImpl;
import com.avito.android.code_confirmation.timer.RxTimerImpl_Factory;
import com.avito.android.code_confirmation.timer.TimerFormatter_Factory;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.di.DialogRouterModule_ProvideDialogRouterFactory;
import com.avito.android.remote.ProfileApi;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.util.DialogRouter;
import com.avito.android.util.ErrorFormatter;
import com.avito.android.util.ErrorFormatterImpl;
import com.avito.android.util.ErrorFormatterImpl_Factory;
import com.avito.android.util.Formatter;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.SchedulersFactory3;
import com.google.android.gms.auth.api.phone.SmsRetrieverClient;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import javax.inject.Provider;
public final class DaggerCodeConfirmationComponent implements CodeConfirmationComponent {
    public Provider<Kundle> A;
    public Provider<CodeConfirmationPresenterImpl> B;
    public Provider<CodeConfirmationPresenter> C;
    public Provider<DialogRouter> D;
    public final CodeConfirmationDependencies a;
    public Provider<ProfileApi> b;
    public Provider<SchedulersFactory> c;
    public Provider<Resources> d;
    public Provider<CodeConfirmationResourceProviderImpl> e;
    public Provider<CodeConfirmationResourceProvider> f;
    public Provider<TypedErrorThrowableConverter> g;
    public Provider<String> h;
    public Provider<Boolean> i;
    public Provider<CodeConfirmationInteractor> j;
    public Provider<PhoneAntihackInteractorImpl> k;
    public Provider<PhoneAntihackInteractor> l;
    public Provider<SchedulersFactory3> m;
    public Provider<AccountInteractor> n;
    public Provider<TfaInteractorImpl> o;
    public Provider<TfaInteractor> p;
    public Provider<ErrorFormatterImpl> q;
    public Provider<ErrorFormatter> r;
    public Provider<Formatter<Long>> s = DoubleCheck.provider(TimerFormatter_Factory.create());
    public Provider<RxTimerImpl> t;
    public Provider<RxTimer> u;
    public Provider<Activity> v;
    public Provider<IntentFilter> w;
    public Provider<SmsRetrieverClient> x;
    public Provider<CodeReceiverImpl> y;
    public Provider<CodeReceiver> z;

    public static final class b implements CodeConfirmationComponent.Builder {
        public CodeConfirmationDependencies a;
        public Activity b;
        public Resources c;
        public Kundle d;
        public String e;
        public Boolean f;

        public b(a aVar) {
        }

        @Override // com.avito.android.code_confirmation.di.CodeConfirmationComponent.Builder
        public CodeConfirmationComponent build() {
            Preconditions.checkBuilderRequirement(this.a, CodeConfirmationDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, Activity.class);
            Preconditions.checkBuilderRequirement(this.c, Resources.class);
            Preconditions.checkBuilderRequirement(this.e, String.class);
            Preconditions.checkBuilderRequirement(this.f, Boolean.class);
            return new DaggerCodeConfirmationComponent(this.a, this.b, this.c, this.d, this.e, this.f, null);
        }

        @Override // com.avito.android.code_confirmation.di.CodeConfirmationComponent.Builder
        public CodeConfirmationComponent.Builder dependentOn(CodeConfirmationDependencies codeConfirmationDependencies) {
            this.a = (CodeConfirmationDependencies) Preconditions.checkNotNull(codeConfirmationDependencies);
            return this;
        }

        @Override // com.avito.android.code_confirmation.di.CodeConfirmationComponent.Builder
        public CodeConfirmationComponent.Builder withActivity(Activity activity) {
            this.b = (Activity) Preconditions.checkNotNull(activity);
            return this;
        }

        @Override // com.avito.android.code_confirmation.di.CodeConfirmationComponent.Builder
        public CodeConfirmationComponent.Builder withPresenterState(Kundle kundle) {
            this.d = kundle;
            return this;
        }

        @Override // com.avito.android.code_confirmation.di.CodeConfirmationComponent.Builder
        public CodeConfirmationComponent.Builder withResources(Resources resources) {
            this.c = (Resources) Preconditions.checkNotNull(resources);
            return this;
        }

        @Override // com.avito.android.code_confirmation.di.CodeConfirmationComponent.Builder
        public CodeConfirmationComponent.Builder withRetry(boolean z) {
            this.f = (Boolean) Preconditions.checkNotNull(Boolean.valueOf(z));
            return this;
        }

        @Override // com.avito.android.code_confirmation.di.CodeConfirmationComponent.Builder
        public CodeConfirmationComponent.Builder withSrc(String str) {
            this.e = (String) Preconditions.checkNotNull(str);
            return this;
        }
    }

    public static class c implements Provider<AccountInteractor> {
        public final CodeConfirmationDependencies a;

        public c(CodeConfirmationDependencies codeConfirmationDependencies) {
            this.a = codeConfirmationDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public AccountInteractor get() {
            return (AccountInteractor) Preconditions.checkNotNullFromComponent(this.a.accountInteractor());
        }
    }

    public static class d implements Provider<ProfileApi> {
        public final CodeConfirmationDependencies a;

        public d(CodeConfirmationDependencies codeConfirmationDependencies) {
            this.a = codeConfirmationDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ProfileApi get() {
            return (ProfileApi) Preconditions.checkNotNullFromComponent(this.a.profileApi());
        }
    }

    public static class e implements Provider<SchedulersFactory3> {
        public final CodeConfirmationDependencies a;

        public e(CodeConfirmationDependencies codeConfirmationDependencies) {
            this.a = codeConfirmationDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory3 get() {
            return (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3());
        }
    }

    public static class f implements Provider<SchedulersFactory> {
        public final CodeConfirmationDependencies a;

        public f(CodeConfirmationDependencies codeConfirmationDependencies) {
            this.a = codeConfirmationDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public static class g implements Provider<TypedErrorThrowableConverter> {
        public final CodeConfirmationDependencies a;

        public g(CodeConfirmationDependencies codeConfirmationDependencies) {
            this.a = codeConfirmationDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TypedErrorThrowableConverter get() {
            return (TypedErrorThrowableConverter) Preconditions.checkNotNullFromComponent(this.a.typedErrorThrowableConverter());
        }
    }

    public DaggerCodeConfirmationComponent(CodeConfirmationDependencies codeConfirmationDependencies, Activity activity, Resources resources, Kundle kundle, String str, Boolean bool, a aVar) {
        this.a = codeConfirmationDependencies;
        this.b = new d(codeConfirmationDependencies);
        this.c = new f(codeConfirmationDependencies);
        Factory create = InstanceFactory.create(resources);
        this.d = create;
        CodeConfirmationResourceProviderImpl_Factory create2 = CodeConfirmationResourceProviderImpl_Factory.create(create);
        this.e = create2;
        this.f = DoubleCheck.provider(create2);
        this.g = new g(codeConfirmationDependencies);
        this.h = InstanceFactory.create(str);
        Factory create3 = InstanceFactory.create(bool);
        this.i = create3;
        this.j = DoubleCheck.provider(CodeConfirmationModule_ProvideCodeConfirmationInteractor$code_confirmation_releaseFactory.create(this.b, this.c, this.f, this.g, this.h, create3));
        PhoneAntihackInteractorImpl_Factory create4 = PhoneAntihackInteractorImpl_Factory.create(this.b, this.c, this.g, this.f);
        this.k = create4;
        this.l = DoubleCheck.provider(create4);
        e eVar = new e(codeConfirmationDependencies);
        this.m = eVar;
        c cVar = new c(codeConfirmationDependencies);
        this.n = cVar;
        TfaInteractorImpl_Factory create5 = TfaInteractorImpl_Factory.create(this.b, eVar, this.f, this.g, cVar);
        this.o = create5;
        this.p = DoubleCheck.provider(create5);
        ErrorFormatterImpl_Factory create6 = ErrorFormatterImpl_Factory.create(this.d);
        this.q = create6;
        this.r = DoubleCheck.provider(create6);
        RxTimerImpl_Factory create7 = RxTimerImpl_Factory.create(this.c);
        this.t = create7;
        this.u = DoubleCheck.provider(create7);
        this.v = InstanceFactory.create(activity);
        this.w = DoubleCheck.provider(CodeConfirmationPresentationModule_ProvideCodeReceiverIntentFilter$code_confirmation_releaseFactory.create());
        Provider<SmsRetrieverClient> provider = DoubleCheck.provider(CodeConfirmationPresentationModule_ProvideSmsRetrieverClient$code_confirmation_releaseFactory.create(this.v));
        this.x = provider;
        CodeReceiverImpl_Factory create8 = CodeReceiverImpl_Factory.create(this.v, this.w, provider);
        this.y = create8;
        this.z = DoubleCheck.provider(create8);
        Factory createNullable = InstanceFactory.createNullable(kundle);
        this.A = createNullable;
        CodeConfirmationPresenterImpl_Factory create9 = CodeConfirmationPresenterImpl_Factory.create(this.j, this.l, this.p, this.c, this.r, this.f, this.s, this.u, this.z, createNullable);
        this.B = create9;
        this.C = DoubleCheck.provider(create9);
        this.D = SingleCheck.provider(DialogRouterModule_ProvideDialogRouterFactory.create(this.v));
    }

    public static CodeConfirmationComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.code_confirmation.di.CodeConfirmationComponent
    public void inject(CodeConfirmationActivity codeConfirmationActivity) {
        CodeConfirmationActivity_MembersInjector.injectPresenter(codeConfirmationActivity, this.C.get());
        CodeConfirmationActivity_MembersInjector.injectIntentFactory(codeConfirmationActivity, (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.a.activityIntentFactory()));
        CodeConfirmationActivity_MembersInjector.injectAnalytics(codeConfirmationActivity, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
        CodeConfirmationActivity_MembersInjector.injectDeepLinkIntentFactory(codeConfirmationActivity, (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deepLinkIntentFactory()));
        CodeConfirmationActivity_MembersInjector.injectDialogRouter(codeConfirmationActivity, this.D.get());
    }
}
