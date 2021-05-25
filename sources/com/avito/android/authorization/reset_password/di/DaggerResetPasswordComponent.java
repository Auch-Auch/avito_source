package com.avito.android.authorization.reset_password.di;

import android.app.Activity;
import android.content.res.Resources;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.analytics.Analytics;
import com.avito.android.authorization.reset_password.ResetPasswordActivity;
import com.avito.android.authorization.reset_password.ResetPasswordActivity_MembersInjector;
import com.avito.android.authorization.reset_password.ResetPasswordInteractor;
import com.avito.android.authorization.reset_password.ResetPasswordInteractorImpl;
import com.avito.android.authorization.reset_password.ResetPasswordInteractorImpl_Factory;
import com.avito.android.authorization.reset_password.ResetPasswordPresenter;
import com.avito.android.authorization.reset_password.ResetPasswordPresenterImpl;
import com.avito.android.authorization.reset_password.ResetPasswordPresenterImpl_Factory;
import com.avito.android.authorization.reset_password.ResetPasswordResourceProvider;
import com.avito.android.authorization.reset_password.ResetPasswordResourceProviderImpl;
import com.avito.android.authorization.reset_password.ResetPasswordResourceProviderImpl_Factory;
import com.avito.android.authorization.reset_password.di.ResetPasswordComponent;
import com.avito.android.code_confirmation.CodeConfirmationInteractor;
import com.avito.android.code_confirmation.CodeConfirmationResourceProvider;
import com.avito.android.code_confirmation.CodeConfirmationResourceProviderImpl;
import com.avito.android.code_confirmation.CodeConfirmationResourceProviderImpl_Factory;
import com.avito.android.code_confirmation.di.CodeConfirmationModule_ProvideCodeConfirmationInteractor$code_confirmation_releaseFactory;
import com.avito.android.code_confirmation.di.CodeConfirmationModule_ProvideLoginCodeConfirmationInteractor$code_confirmation_releaseFactory;
import com.avito.android.di.DialogRouterModule_ProvideDialogRouterFactory;
import com.avito.android.remote.ProfileApi;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.util.DialogRouter;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import javax.inject.Provider;
public final class DaggerResetPasswordComponent implements ResetPasswordComponent {
    public final ResetPasswordDependencies a;
    public Provider<ProfileApi> b;
    public Provider<SchedulersFactory> c;
    public Provider<Resources> d;
    public Provider<CodeConfirmationResourceProviderImpl> e;
    public Provider<CodeConfirmationResourceProvider> f;
    public Provider<TypedErrorThrowableConverter> g;
    public Provider<String> h;
    public Provider<Boolean> i;
    public Provider<CodeConfirmationInteractor> j;
    public Provider<CodeConfirmationInteractor> k = DoubleCheck.provider(CodeConfirmationModule_ProvideLoginCodeConfirmationInteractor$code_confirmation_releaseFactory.create(this.b, this.c, this.f));
    public Provider<ResetPasswordResourceProviderImpl> l;
    public Provider<ResetPasswordResourceProvider> m;
    public Provider<ResetPasswordInteractorImpl> n;
    public Provider<ResetPasswordInteractor> o;
    public Provider<Kundle> p;
    public Provider<ResetPasswordPresenterImpl> q;
    public Provider<ResetPasswordPresenter> r;
    public Provider<Activity> s;
    public Provider<DialogRouter> t;

    public static final class b implements ResetPasswordComponent.Builder {
        public ResetPasswordDependencies a;
        public Activity b;
        public Resources c;
        public Kundle d;
        public String e;
        public Boolean f;

        public b(a aVar) {
        }

        @Override // com.avito.android.authorization.reset_password.di.ResetPasswordComponent.Builder
        public ResetPasswordComponent build() {
            Preconditions.checkBuilderRequirement(this.a, ResetPasswordDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, Activity.class);
            Preconditions.checkBuilderRequirement(this.c, Resources.class);
            Preconditions.checkBuilderRequirement(this.e, String.class);
            Preconditions.checkBuilderRequirement(this.f, Boolean.class);
            return new DaggerResetPasswordComponent(this.a, this.b, this.c, this.d, this.e, this.f, null);
        }

        @Override // com.avito.android.authorization.reset_password.di.ResetPasswordComponent.Builder
        public ResetPasswordComponent.Builder dependentOn(ResetPasswordDependencies resetPasswordDependencies) {
            this.a = (ResetPasswordDependencies) Preconditions.checkNotNull(resetPasswordDependencies);
            return this;
        }

        @Override // com.avito.android.authorization.reset_password.di.ResetPasswordComponent.Builder
        public ResetPasswordComponent.Builder withActivity(Activity activity) {
            this.b = (Activity) Preconditions.checkNotNull(activity);
            return this;
        }

        @Override // com.avito.android.authorization.reset_password.di.ResetPasswordComponent.Builder
        public ResetPasswordComponent.Builder withPresenterState(Kundle kundle) {
            this.d = kundle;
            return this;
        }

        @Override // com.avito.android.authorization.reset_password.di.ResetPasswordComponent.Builder
        public ResetPasswordComponent.Builder withResources(Resources resources) {
            this.c = (Resources) Preconditions.checkNotNull(resources);
            return this;
        }

        @Override // com.avito.android.authorization.reset_password.di.ResetPasswordComponent.Builder
        public ResetPasswordComponent.Builder withRetry(boolean z) {
            this.f = (Boolean) Preconditions.checkNotNull(Boolean.valueOf(z));
            return this;
        }

        @Override // com.avito.android.authorization.reset_password.di.ResetPasswordComponent.Builder
        public ResetPasswordComponent.Builder withSrc(String str) {
            this.e = (String) Preconditions.checkNotNull(str);
            return this;
        }
    }

    public static class c implements Provider<ProfileApi> {
        public final ResetPasswordDependencies a;

        public c(ResetPasswordDependencies resetPasswordDependencies) {
            this.a = resetPasswordDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ProfileApi get() {
            return (ProfileApi) Preconditions.checkNotNullFromComponent(this.a.profileApi());
        }
    }

    public static class d implements Provider<SchedulersFactory> {
        public final ResetPasswordDependencies a;

        public d(ResetPasswordDependencies resetPasswordDependencies) {
            this.a = resetPasswordDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public static class e implements Provider<TypedErrorThrowableConverter> {
        public final ResetPasswordDependencies a;

        public e(ResetPasswordDependencies resetPasswordDependencies) {
            this.a = resetPasswordDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TypedErrorThrowableConverter get() {
            return (TypedErrorThrowableConverter) Preconditions.checkNotNullFromComponent(this.a.typedErrorThrowableConverter());
        }
    }

    public DaggerResetPasswordComponent(ResetPasswordDependencies resetPasswordDependencies, Activity activity, Resources resources, Kundle kundle, String str, Boolean bool, a aVar) {
        this.a = resetPasswordDependencies;
        this.b = new c(resetPasswordDependencies);
        this.c = new d(resetPasswordDependencies);
        Factory create = InstanceFactory.create(resources);
        this.d = create;
        CodeConfirmationResourceProviderImpl_Factory create2 = CodeConfirmationResourceProviderImpl_Factory.create(create);
        this.e = create2;
        this.f = DoubleCheck.provider(create2);
        this.g = new e(resetPasswordDependencies);
        this.h = InstanceFactory.create(str);
        Factory create3 = InstanceFactory.create(bool);
        this.i = create3;
        this.j = DoubleCheck.provider(CodeConfirmationModule_ProvideCodeConfirmationInteractor$code_confirmation_releaseFactory.create(this.b, this.c, this.f, this.g, this.h, create3));
        ResetPasswordResourceProviderImpl_Factory create4 = ResetPasswordResourceProviderImpl_Factory.create(this.d);
        this.l = create4;
        Provider<ResetPasswordResourceProvider> provider = DoubleCheck.provider(create4);
        this.m = provider;
        ResetPasswordInteractorImpl_Factory create5 = ResetPasswordInteractorImpl_Factory.create(this.b, this.j, this.k, provider, this.g, this.c);
        this.n = create5;
        this.o = DoubleCheck.provider(create5);
        Factory createNullable = InstanceFactory.createNullable(kundle);
        this.p = createNullable;
        ResetPasswordPresenterImpl_Factory create6 = ResetPasswordPresenterImpl_Factory.create(this.o, this.c, createNullable);
        this.q = create6;
        this.r = DoubleCheck.provider(create6);
        Factory create7 = InstanceFactory.create(activity);
        this.s = create7;
        this.t = SingleCheck.provider(DialogRouterModule_ProvideDialogRouterFactory.create(create7));
    }

    public static ResetPasswordComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.authorization.reset_password.di.ResetPasswordComponent
    public void inject(ResetPasswordActivity resetPasswordActivity) {
        ResetPasswordActivity_MembersInjector.injectPresenter(resetPasswordActivity, this.r.get());
        ResetPasswordActivity_MembersInjector.injectDialogRouter(resetPasswordActivity, this.t.get());
        ResetPasswordActivity_MembersInjector.injectIntentFactory(resetPasswordActivity, (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.a.activityIntentFactory()));
        ResetPasswordActivity_MembersInjector.injectAnalytics(resetPasswordActivity, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
    }
}
