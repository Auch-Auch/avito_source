package com.avito.android.profile.sessions.social_logout.di;

import android.content.res.Resources;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.account.AccountStorageInteractor;
import com.avito.android.analytics.Analytics;
import com.avito.android.profile.sessions.social_logout.SessionsSocialLogoutFragment;
import com.avito.android.profile.sessions.social_logout.SessionsSocialLogoutFragment_MembersInjector;
import com.avito.android.profile.sessions.social_logout.SessionsSocialLogoutInteractor;
import com.avito.android.profile.sessions.social_logout.SessionsSocialLogoutInteractorImpl;
import com.avito.android.profile.sessions.social_logout.SessionsSocialLogoutInteractorImpl_Factory;
import com.avito.android.profile.sessions.social_logout.SessionsSocialLogoutPresenter;
import com.avito.android.profile.sessions.social_logout.SessionsSocialLogoutPresenterImpl;
import com.avito.android.profile.sessions.social_logout.SessionsSocialLogoutPresenterImpl_Factory;
import com.avito.android.profile.sessions.social_logout.SessionsSocialLogoutResourcesProvider;
import com.avito.android.profile.sessions.social_logout.SessionsSocialLogoutResourcesProviderImpl;
import com.avito.android.profile.sessions.social_logout.SessionsSocialLogoutResourcesProviderImpl_Factory;
import com.avito.android.profile.sessions.social_logout.di.SessionsSocialLogoutComponent;
import com.avito.android.remote.SessionsApi;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class DaggerSessionsSocialLogoutComponent implements SessionsSocialLogoutComponent {
    public final SessionsSocialLogoutDependencies a;
    public Provider<SessionsApi> b;
    public Provider<TypedErrorThrowableConverter> c;
    public Provider<SchedulersFactory3> d;
    public Provider<AccountStorageInteractor> e;
    public Provider<SessionsSocialLogoutInteractorImpl> f;
    public Provider<SessionsSocialLogoutInteractor> g;
    public Provider<SessionsSocialLogoutPresenter.SessionParams> h;
    public Provider<Resources> i;
    public Provider<SessionsSocialLogoutResourcesProviderImpl> j;
    public Provider<SessionsSocialLogoutResourcesProvider> k;
    public Provider<SessionsSocialLogoutPresenterImpl> l;
    public Provider<SessionsSocialLogoutPresenter> m;

    public static final class b implements SessionsSocialLogoutComponent.Factory {
        public b(a aVar) {
        }

        @Override // com.avito.android.profile.sessions.social_logout.di.SessionsSocialLogoutComponent.Factory
        public SessionsSocialLogoutComponent create(Resources resources, SessionsSocialLogoutPresenter.SessionParams sessionParams, SessionsSocialLogoutDependencies sessionsSocialLogoutDependencies) {
            Preconditions.checkNotNull(resources);
            Preconditions.checkNotNull(sessionParams);
            Preconditions.checkNotNull(sessionsSocialLogoutDependencies);
            return new DaggerSessionsSocialLogoutComponent(sessionsSocialLogoutDependencies, resources, sessionParams, null);
        }
    }

    public static class c implements Provider<AccountStorageInteractor> {
        public final SessionsSocialLogoutDependencies a;

        public c(SessionsSocialLogoutDependencies sessionsSocialLogoutDependencies) {
            this.a = sessionsSocialLogoutDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public AccountStorageInteractor get() {
            return (AccountStorageInteractor) Preconditions.checkNotNullFromComponent(this.a.accountStorageInteractor());
        }
    }

    public static class d implements Provider<SchedulersFactory3> {
        public final SessionsSocialLogoutDependencies a;

        public d(SessionsSocialLogoutDependencies sessionsSocialLogoutDependencies) {
            this.a = sessionsSocialLogoutDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory3 get() {
            return (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3());
        }
    }

    public static class e implements Provider<SessionsApi> {
        public final SessionsSocialLogoutDependencies a;

        public e(SessionsSocialLogoutDependencies sessionsSocialLogoutDependencies) {
            this.a = sessionsSocialLogoutDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SessionsApi get() {
            return (SessionsApi) Preconditions.checkNotNullFromComponent(this.a.sessionsApi());
        }
    }

    public static class f implements Provider<TypedErrorThrowableConverter> {
        public final SessionsSocialLogoutDependencies a;

        public f(SessionsSocialLogoutDependencies sessionsSocialLogoutDependencies) {
            this.a = sessionsSocialLogoutDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TypedErrorThrowableConverter get() {
            return (TypedErrorThrowableConverter) Preconditions.checkNotNullFromComponent(this.a.typedErrorThrowableConverter());
        }
    }

    public DaggerSessionsSocialLogoutComponent(SessionsSocialLogoutDependencies sessionsSocialLogoutDependencies, Resources resources, SessionsSocialLogoutPresenter.SessionParams sessionParams, a aVar) {
        this.a = sessionsSocialLogoutDependencies;
        e eVar = new e(sessionsSocialLogoutDependencies);
        this.b = eVar;
        f fVar = new f(sessionsSocialLogoutDependencies);
        this.c = fVar;
        d dVar = new d(sessionsSocialLogoutDependencies);
        this.d = dVar;
        c cVar = new c(sessionsSocialLogoutDependencies);
        this.e = cVar;
        SessionsSocialLogoutInteractorImpl_Factory create = SessionsSocialLogoutInteractorImpl_Factory.create(eVar, fVar, dVar, cVar);
        this.f = create;
        this.g = DoubleCheck.provider(create);
        this.h = InstanceFactory.create(sessionParams);
        Factory create2 = InstanceFactory.create(resources);
        this.i = create2;
        SessionsSocialLogoutResourcesProviderImpl_Factory create3 = SessionsSocialLogoutResourcesProviderImpl_Factory.create(create2);
        this.j = create3;
        Provider<SessionsSocialLogoutResourcesProvider> provider = DoubleCheck.provider(create3);
        this.k = provider;
        SessionsSocialLogoutPresenterImpl_Factory create4 = SessionsSocialLogoutPresenterImpl_Factory.create(this.g, this.h, this.d, provider);
        this.l = create4;
        this.m = DoubleCheck.provider(create4);
    }

    public static SessionsSocialLogoutComponent.Factory factory() {
        return new b(null);
    }

    @Override // com.avito.android.profile.sessions.social_logout.di.SessionsSocialLogoutComponent
    public void inject(SessionsSocialLogoutFragment sessionsSocialLogoutFragment) {
        SessionsSocialLogoutFragment_MembersInjector.injectPresenter(sessionsSocialLogoutFragment, this.m.get());
        SessionsSocialLogoutFragment_MembersInjector.injectAnalytics(sessionsSocialLogoutFragment, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
        SessionsSocialLogoutFragment_MembersInjector.injectActivityIntentFactory(sessionsSocialLogoutFragment, (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.a.activityIntentFactory()));
    }
}
