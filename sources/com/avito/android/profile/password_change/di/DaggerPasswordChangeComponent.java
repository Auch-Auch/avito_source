package com.avito.android.profile.password_change.di;

import android.app.Activity;
import android.content.res.Resources;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.account.AccountStorageInteractor;
import com.avito.android.account.LoginSuggestStorage;
import com.avito.android.account.SessionChangeTracker;
import com.avito.android.account.SessionChangeTrackerImpl;
import com.avito.android.account.SessionChangeTrackerImpl_Factory;
import com.avito.android.analytics.Analytics;
import com.avito.android.authorization.smart_lock.SmartLockLoader;
import com.avito.android.authorization.smart_lock.SmartLockSaver;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.di.DialogRouterModule_ProvideDialogRouterFactory;
import com.avito.android.dialog.DialogPresenter;
import com.avito.android.dialog.DialogPresenterImpl;
import com.avito.android.dialog.DialogPresenterImpl_Factory;
import com.avito.android.error_helper.ErrorHelper;
import com.avito.android.error_helper.ErrorHelperImpl;
import com.avito.android.error_helper.ErrorHelperImpl_Factory;
import com.avito.android.profile.password_change.PasswordChangeFragment;
import com.avito.android.profile.password_change.PasswordChangeFragment_MembersInjector;
import com.avito.android.profile.password_change.PasswordChangePresenter;
import com.avito.android.profile.password_change.PasswordChangePresenterImpl;
import com.avito.android.profile.password_change.PasswordChangeResourceProviderImpl;
import com.avito.android.profile.password_change.business.PasswordChangeInteractorImpl;
import com.avito.android.profile.password_change.di.PasswordChangeComponent;
import com.avito.android.remote.ProfileApi;
import com.avito.android.util.DialogRouter;
import com.avito.android.util.ErrorFormatter;
import com.avito.android.util.ErrorFormatterImpl;
import com.avito.android.util.ErrorFormatterImpl_Factory;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import javax.inject.Provider;
public final class DaggerPasswordChangeComponent implements PasswordChangeComponent {
    public final PasswordChangeDependencies a;
    public final PasswordChangePresenter.Mode b;
    public final Resources c;
    public final Kundle d;
    public Provider<Features> e;
    public Provider<Analytics> f;
    public Provider<SessionChangeTrackerImpl> g;
    public Provider<SessionChangeTracker> h;
    public Provider<Activity> i;
    public Provider<DialogRouter> j;
    public Provider<DialogPresenterImpl> k;
    public Provider<DialogPresenter> l;
    public Provider<Resources> m;
    public Provider<ErrorFormatterImpl> n;
    public Provider<ErrorFormatter> o;
    public Provider<ErrorHelperImpl> p;
    public Provider<ErrorHelper> q;
    public Provider<SchedulersFactory3> r;
    public Provider<Kundle> s;
    public Provider<SmartLockLoader> t;
    public Provider<Kundle> u;
    public Provider<SmartLockSaver> v;

    public static final class b implements PasswordChangeComponent.Factory {
        public b(a aVar) {
        }

        @Override // com.avito.android.profile.password_change.di.PasswordChangeComponent.Factory
        public PasswordChangeComponent create(PasswordChangeDependencies passwordChangeDependencies, Activity activity, Resources resources, Kundle kundle, Kundle kundle2, Kundle kundle3, PasswordChangePresenter.Mode mode) {
            Preconditions.checkNotNull(passwordChangeDependencies);
            Preconditions.checkNotNull(activity);
            Preconditions.checkNotNull(resources);
            Preconditions.checkNotNull(mode);
            return new DaggerPasswordChangeComponent(passwordChangeDependencies, activity, resources, kundle, kundle2, kundle3, mode, null);
        }
    }

    public static class c implements Provider<Analytics> {
        public final PasswordChangeDependencies a;

        public c(PasswordChangeDependencies passwordChangeDependencies) {
            this.a = passwordChangeDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Analytics get() {
            return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
        }
    }

    public static class d implements Provider<Features> {
        public final PasswordChangeDependencies a;

        public d(PasswordChangeDependencies passwordChangeDependencies) {
            this.a = passwordChangeDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Features get() {
            return (Features) Preconditions.checkNotNullFromComponent(this.a.features());
        }
    }

    public static class e implements Provider<SchedulersFactory3> {
        public final PasswordChangeDependencies a;

        public e(PasswordChangeDependencies passwordChangeDependencies) {
            this.a = passwordChangeDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory3 get() {
            return (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3());
        }
    }

    public DaggerPasswordChangeComponent(PasswordChangeDependencies passwordChangeDependencies, Activity activity, Resources resources, Kundle kundle, Kundle kundle2, Kundle kundle3, PasswordChangePresenter.Mode mode, a aVar) {
        this.a = passwordChangeDependencies;
        this.b = mode;
        this.c = resources;
        this.d = kundle;
        d dVar = new d(passwordChangeDependencies);
        this.e = dVar;
        c cVar = new c(passwordChangeDependencies);
        this.f = cVar;
        SessionChangeTrackerImpl_Factory create = SessionChangeTrackerImpl_Factory.create(dVar, cVar);
        this.g = create;
        this.h = SingleCheck.provider(create);
        Factory create2 = InstanceFactory.create(activity);
        this.i = create2;
        Provider<DialogRouter> provider = SingleCheck.provider(DialogRouterModule_ProvideDialogRouterFactory.create(create2));
        this.j = provider;
        DialogPresenterImpl_Factory create3 = DialogPresenterImpl_Factory.create(this.i, provider);
        this.k = create3;
        this.l = SingleCheck.provider(create3);
        Factory create4 = InstanceFactory.create(resources);
        this.m = create4;
        ErrorFormatterImpl_Factory create5 = ErrorFormatterImpl_Factory.create(create4);
        this.n = create5;
        Provider<ErrorFormatter> provider2 = SingleCheck.provider(create5);
        this.o = provider2;
        ErrorHelperImpl_Factory create6 = ErrorHelperImpl_Factory.create(provider2);
        this.p = create6;
        this.q = SingleCheck.provider(create6);
        this.r = new e(passwordChangeDependencies);
        Factory createNullable = InstanceFactory.createNullable(kundle3);
        this.s = createNullable;
        this.t = DoubleCheck.provider(SmartLockModule_ProvideSmartLockLoaderFactory.create(this.f, this.j, this.r, this.e, this.i, createNullable));
        Factory createNullable2 = InstanceFactory.createNullable(kundle2);
        this.u = createNullable2;
        this.v = DoubleCheck.provider(SmartLockModule_ProvideSmartLockSaverFactory.create(this.i, this.f, this.r, this.e, createNullable2));
    }

    public static PasswordChangeComponent.Factory factory() {
        return new b(null);
    }

    @Override // com.avito.android.profile.password_change.di.PasswordChangeComponent
    public void inject(PasswordChangeFragment passwordChangeFragment) {
        PasswordChangeFragment_MembersInjector.injectPresenter(passwordChangeFragment, new PasswordChangePresenterImpl(new PasswordChangeInteractorImpl((AccountStorageInteractor) Preconditions.checkNotNullFromComponent(this.a.accountStorageInteractor()), (ProfileApi) Preconditions.checkNotNullFromComponent(this.a.profileApi()), this.h.get(), (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory()), (LoginSuggestStorage) Preconditions.checkNotNullFromComponent(this.a.loginSuggestStorage())), this.l.get(), (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory()), this.q.get(), this.t.get(), this.v.get(), this.b, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()), new PasswordChangeResourceProviderImpl(this.c), this.d));
        PasswordChangeFragment_MembersInjector.injectActivityIntentFactory(passwordChangeFragment, (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.a.activityIntentFactory()));
        PasswordChangeFragment_MembersInjector.injectDeepLinkIntentFactory(passwordChangeFragment, (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deepLinkIntentFactory()));
        PasswordChangeFragment_MembersInjector.injectSmartLockLoader(passwordChangeFragment, this.t.get());
        PasswordChangeFragment_MembersInjector.injectSmartLockSaver(passwordChangeFragment, this.v.get());
        PasswordChangeFragment_MembersInjector.injectAnalytics(passwordChangeFragment, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
    }
}
