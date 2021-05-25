package com.avito.android.authorization.change_password.di;

import android.app.Activity;
import android.content.res.Resources;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.analytics.Analytics;
import com.avito.android.authorization.change_password.ChangePasswordActivity;
import com.avito.android.authorization.change_password.ChangePasswordActivity_MembersInjector;
import com.avito.android.authorization.change_password.ChangePasswordInteractor;
import com.avito.android.authorization.change_password.ChangePasswordInteractorImpl;
import com.avito.android.authorization.change_password.ChangePasswordInteractorImpl_Factory;
import com.avito.android.authorization.change_password.ChangePasswordPresenter;
import com.avito.android.authorization.change_password.ChangePasswordPresenterImpl;
import com.avito.android.authorization.change_password.ChangePasswordPresenterImpl_Factory;
import com.avito.android.authorization.change_password.di.ChangePasswordComponent;
import com.avito.android.remote.ProfileApi;
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
public final class DaggerChangePasswordComponent implements ChangePasswordComponent {
    public final ChangePasswordDependencies a;
    public Provider<String> b;
    public Provider<String> c;
    public Provider<ProfileApi> d;
    public Provider<SchedulersFactory> e;
    public Provider<ChangePasswordInteractorImpl> f;
    public Provider<ChangePasswordInteractor> g;
    public Provider<Resources> h;
    public Provider<ErrorFormatterImpl> i;
    public Provider<ErrorFormatter> j;
    public Provider<Kundle> k;
    public Provider<ChangePasswordPresenterImpl> l;
    public Provider<ChangePasswordPresenter> m;

    public static final class b implements ChangePasswordComponent.Builder {
        public ChangePasswordDependencies a;
        public Activity b;
        public Resources c;
        public Kundle d;
        public String e;
        public String f;

        public b(a aVar) {
        }

        @Override // com.avito.android.authorization.change_password.di.ChangePasswordComponent.Builder
        public ChangePasswordComponent build() {
            Preconditions.checkBuilderRequirement(this.a, ChangePasswordDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, Activity.class);
            Preconditions.checkBuilderRequirement(this.c, Resources.class);
            Preconditions.checkBuilderRequirement(this.e, String.class);
            Preconditions.checkBuilderRequirement(this.f, String.class);
            return new DaggerChangePasswordComponent(this.a, this.b, this.c, this.d, this.e, this.f, null);
        }

        @Override // com.avito.android.authorization.change_password.di.ChangePasswordComponent.Builder
        public ChangePasswordComponent.Builder dependentOn(ChangePasswordDependencies changePasswordDependencies) {
            this.a = (ChangePasswordDependencies) Preconditions.checkNotNull(changePasswordDependencies);
            return this;
        }

        @Override // com.avito.android.authorization.change_password.di.ChangePasswordComponent.Builder
        public ChangePasswordComponent.Builder withActivity(Activity activity) {
            this.b = (Activity) Preconditions.checkNotNull(activity);
            return this;
        }

        @Override // com.avito.android.authorization.change_password.di.ChangePasswordComponent.Builder
        public ChangePasswordComponent.Builder withHash(String str) {
            this.f = (String) Preconditions.checkNotNull(str);
            return this;
        }

        @Override // com.avito.android.authorization.change_password.di.ChangePasswordComponent.Builder
        public ChangePasswordComponent.Builder withLogin(String str) {
            this.e = (String) Preconditions.checkNotNull(str);
            return this;
        }

        @Override // com.avito.android.authorization.change_password.di.ChangePasswordComponent.Builder
        public ChangePasswordComponent.Builder withPresenterState(Kundle kundle) {
            this.d = kundle;
            return this;
        }

        @Override // com.avito.android.authorization.change_password.di.ChangePasswordComponent.Builder
        public ChangePasswordComponent.Builder withResources(Resources resources) {
            this.c = (Resources) Preconditions.checkNotNull(resources);
            return this;
        }
    }

    public static class c implements Provider<ProfileApi> {
        public final ChangePasswordDependencies a;

        public c(ChangePasswordDependencies changePasswordDependencies) {
            this.a = changePasswordDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ProfileApi get() {
            return (ProfileApi) Preconditions.checkNotNullFromComponent(this.a.profileApi());
        }
    }

    public static class d implements Provider<SchedulersFactory> {
        public final ChangePasswordDependencies a;

        public d(ChangePasswordDependencies changePasswordDependencies) {
            this.a = changePasswordDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public DaggerChangePasswordComponent(ChangePasswordDependencies changePasswordDependencies, Activity activity, Resources resources, Kundle kundle, String str, String str2, a aVar) {
        this.a = changePasswordDependencies;
        this.b = InstanceFactory.create(str);
        Factory create = InstanceFactory.create(str2);
        this.c = create;
        c cVar = new c(changePasswordDependencies);
        this.d = cVar;
        d dVar = new d(changePasswordDependencies);
        this.e = dVar;
        ChangePasswordInteractorImpl_Factory create2 = ChangePasswordInteractorImpl_Factory.create(this.b, create, cVar, dVar);
        this.f = create2;
        this.g = DoubleCheck.provider(create2);
        Factory create3 = InstanceFactory.create(resources);
        this.h = create3;
        ErrorFormatterImpl_Factory create4 = ErrorFormatterImpl_Factory.create(create3);
        this.i = create4;
        this.j = SingleCheck.provider(create4);
        Factory createNullable = InstanceFactory.createNullable(kundle);
        this.k = createNullable;
        ChangePasswordPresenterImpl_Factory create5 = ChangePasswordPresenterImpl_Factory.create(this.g, this.e, this.j, createNullable);
        this.l = create5;
        this.m = DoubleCheck.provider(create5);
    }

    public static ChangePasswordComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.authorization.change_password.di.ChangePasswordComponent
    public void inject(ChangePasswordActivity changePasswordActivity) {
        ChangePasswordActivity_MembersInjector.injectPresenter(changePasswordActivity, this.m.get());
        ChangePasswordActivity_MembersInjector.injectIntentFactory(changePasswordActivity, (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.a.activityIntentFactory()));
        ChangePasswordActivity_MembersInjector.injectAnalytics(changePasswordActivity, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
    }
}
