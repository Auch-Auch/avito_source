package com.avito.android.profile.sessions.info.di;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.analytics.Analytics;
import com.avito.android.di.CoreComponentDependencies;
import com.avito.android.profile.sessions.info.SessionsInfoFragment;
import com.avito.android.profile.sessions.info.SessionsInfoFragment_MembersInjector;
import com.avito.android.profile.sessions.info.SessionsInfoPresenter;
import com.avito.android.profile.sessions.info.SessionsInfoPresenterImpl;
import com.avito.android.profile.sessions.info.SessionsInfoPresenterImpl_Factory;
import com.avito.android.profile.sessions.info.di.SessionsInfoComponent;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class DaggerSessionsInfoComponent implements SessionsInfoComponent {
    public final CoreComponentDependencies a;
    public Provider<SessionsInfoPresenter.Mode> b;
    public Provider<Analytics> c;
    public Provider<SessionsInfoPresenterImpl> d;
    public Provider<SessionsInfoPresenter> e;

    public static final class b implements SessionsInfoComponent.Factory {
        public b(a aVar) {
        }

        @Override // com.avito.android.profile.sessions.info.di.SessionsInfoComponent.Factory
        public SessionsInfoComponent create(SessionsInfoPresenter.Mode mode, CoreComponentDependencies coreComponentDependencies) {
            Preconditions.checkNotNull(mode);
            Preconditions.checkNotNull(coreComponentDependencies);
            return new DaggerSessionsInfoComponent(coreComponentDependencies, mode, null);
        }
    }

    public static class c implements Provider<Analytics> {
        public final CoreComponentDependencies a;

        public c(CoreComponentDependencies coreComponentDependencies) {
            this.a = coreComponentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Analytics get() {
            return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
        }
    }

    public DaggerSessionsInfoComponent(CoreComponentDependencies coreComponentDependencies, SessionsInfoPresenter.Mode mode, a aVar) {
        this.a = coreComponentDependencies;
        Factory create = InstanceFactory.create(mode);
        this.b = create;
        c cVar = new c(coreComponentDependencies);
        this.c = cVar;
        SessionsInfoPresenterImpl_Factory create2 = SessionsInfoPresenterImpl_Factory.create(create, cVar);
        this.d = create2;
        this.e = DoubleCheck.provider(create2);
    }

    public static SessionsInfoComponent.Factory factory() {
        return new b(null);
    }

    @Override // com.avito.android.profile.sessions.info.di.SessionsInfoComponent
    public void inject(SessionsInfoFragment sessionsInfoFragment) {
        SessionsInfoFragment_MembersInjector.injectPresenter(sessionsInfoFragment, this.e.get());
        SessionsInfoFragment_MembersInjector.injectActivityIntentFactory(sessionsInfoFragment, (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.a.activityIntentFactory()));
        SessionsInfoFragment_MembersInjector.injectAnalytics(sessionsInfoFragment, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
    }
}
