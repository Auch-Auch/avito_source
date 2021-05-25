package com.avito.android.profile.password_setting.di;

import android.app.Activity;
import android.content.res.Resources;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.account.AccountStorageInteractor;
import com.avito.android.account.SessionChangeTracker;
import com.avito.android.account.SessionChangeTrackerImpl;
import com.avito.android.account.SessionChangeTrackerImpl_Factory;
import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.di.DialogRouterModule_ProvideDialogRouterFactory;
import com.avito.android.dialog.DialogPresenter;
import com.avito.android.dialog.DialogPresenterImpl;
import com.avito.android.dialog.DialogPresenterImpl_Factory;
import com.avito.android.error_helper.ErrorHelper;
import com.avito.android.error_helper.ErrorHelperImpl;
import com.avito.android.error_helper.ErrorHelperImpl_Factory;
import com.avito.android.profile.password_setting.PasswordSettingFragment;
import com.avito.android.profile.password_setting.PasswordSettingFragment_MembersInjector;
import com.avito.android.profile.password_setting.PasswordSettingInteractorImpl;
import com.avito.android.profile.password_setting.PasswordSettingPresenterImpl;
import com.avito.android.profile.password_setting.di.PasswordSettingComponent;
import com.avito.android.remote.ProfileApi;
import com.avito.android.util.DialogRouter;
import com.avito.android.util.ErrorFormatter;
import com.avito.android.util.ErrorFormatterImpl;
import com.avito.android.util.ErrorFormatterImpl_Factory;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import javax.inject.Provider;
public final class DaggerPasswordSettingComponent implements PasswordSettingComponent {
    public final PasswordSettingDependencies a;
    public final Kundle b;
    public Provider<Features> c;
    public Provider<Analytics> d;
    public Provider<SessionChangeTrackerImpl> e;
    public Provider<SessionChangeTracker> f;
    public Provider<Activity> g;
    public Provider<DialogRouter> h;
    public Provider<DialogPresenterImpl> i;
    public Provider<DialogPresenter> j;
    public Provider<Resources> k;
    public Provider<ErrorFormatterImpl> l;
    public Provider<ErrorFormatter> m;
    public Provider<ErrorHelperImpl> n;
    public Provider<ErrorHelper> o;

    public static final class b implements PasswordSettingComponent.Factory {
        public b(a aVar) {
        }

        @Override // com.avito.android.profile.password_setting.di.PasswordSettingComponent.Factory
        public PasswordSettingComponent create(PasswordSettingDependencies passwordSettingDependencies, Activity activity, Resources resources, Kundle kundle) {
            Preconditions.checkNotNull(passwordSettingDependencies);
            Preconditions.checkNotNull(activity);
            Preconditions.checkNotNull(resources);
            return new DaggerPasswordSettingComponent(passwordSettingDependencies, activity, resources, kundle, null);
        }
    }

    public static class c implements Provider<Analytics> {
        public final PasswordSettingDependencies a;

        public c(PasswordSettingDependencies passwordSettingDependencies) {
            this.a = passwordSettingDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Analytics get() {
            return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
        }
    }

    public static class d implements Provider<Features> {
        public final PasswordSettingDependencies a;

        public d(PasswordSettingDependencies passwordSettingDependencies) {
            this.a = passwordSettingDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Features get() {
            return (Features) Preconditions.checkNotNullFromComponent(this.a.features());
        }
    }

    public DaggerPasswordSettingComponent(PasswordSettingDependencies passwordSettingDependencies, Activity activity, Resources resources, Kundle kundle, a aVar) {
        this.a = passwordSettingDependencies;
        this.b = kundle;
        d dVar = new d(passwordSettingDependencies);
        this.c = dVar;
        c cVar = new c(passwordSettingDependencies);
        this.d = cVar;
        SessionChangeTrackerImpl_Factory create = SessionChangeTrackerImpl_Factory.create(dVar, cVar);
        this.e = create;
        this.f = SingleCheck.provider(create);
        Factory create2 = InstanceFactory.create(activity);
        this.g = create2;
        Provider<DialogRouter> provider = SingleCheck.provider(DialogRouterModule_ProvideDialogRouterFactory.create(create2));
        this.h = provider;
        DialogPresenterImpl_Factory create3 = DialogPresenterImpl_Factory.create(this.g, provider);
        this.i = create3;
        this.j = SingleCheck.provider(create3);
        Factory create4 = InstanceFactory.create(resources);
        this.k = create4;
        ErrorFormatterImpl_Factory create5 = ErrorFormatterImpl_Factory.create(create4);
        this.l = create5;
        Provider<ErrorFormatter> provider2 = SingleCheck.provider(create5);
        this.m = provider2;
        ErrorHelperImpl_Factory create6 = ErrorHelperImpl_Factory.create(provider2);
        this.n = create6;
        this.o = SingleCheck.provider(create6);
    }

    public static PasswordSettingComponent.Factory factory() {
        return new b(null);
    }

    @Override // com.avito.android.profile.password_setting.di.PasswordSettingComponent
    public void inject(PasswordSettingFragment passwordSettingFragment) {
        PasswordSettingFragment_MembersInjector.injectPresenter(passwordSettingFragment, new PasswordSettingPresenterImpl(new PasswordSettingInteractorImpl((AccountStorageInteractor) Preconditions.checkNotNullFromComponent(this.a.accountStorageInteractor()), this.f.get(), (ProfileApi) Preconditions.checkNotNullFromComponent(this.a.profileApi()), (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory())), this.j.get(), (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory()), this.o.get(), this.b));
        PasswordSettingFragment_MembersInjector.injectActivityIntentFactory(passwordSettingFragment, (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.a.activityIntentFactory()));
        PasswordSettingFragment_MembersInjector.injectDeepLinkIntentFactory(passwordSettingFragment, (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deepLinkIntentFactory()));
    }
}
