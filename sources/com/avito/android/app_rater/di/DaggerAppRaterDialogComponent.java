package com.avito.android.app_rater.di;

import com.avito.android.analytics.Analytics;
import com.avito.android.app_rater.AppRaterInteractorImpl;
import com.avito.android.app_rater.AppRaterInteractorImpl_Factory;
import com.avito.android.app_rater.PrefAppRaterSessionStorage;
import com.avito.android.app_rater.PrefAppRaterSessionStorage_Factory;
import com.avito.android.app_rater.di.AppRaterDialogComponent;
import com.avito.android.app_rater.events.AppRaterEventSourcePage;
import com.avito.android.app_rater.fragment.AppRaterDialogFragment;
import com.avito.android.app_rater.fragment.AppRaterDialogFragmentViewModelFactory;
import com.avito.android.app_rater.fragment.AppRaterDialogFragment_MembersInjector;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.preferences.Preferences;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class DaggerAppRaterDialogComponent implements AppRaterDialogComponent {
    public final AppRaterDependencies a;
    public Provider<Preferences> b;
    public Provider<PrefAppRaterSessionStorage> c;
    public Provider<AppRaterInteractorImpl> d;
    public Provider<TimeSource> e;
    public Provider<SchedulersFactory> f;
    public Provider<Analytics> g;
    public Provider<AppRaterEventSourcePage> h;
    public Provider<AppRaterDialogFragmentViewModelFactory> i;

    public static final class b implements AppRaterDialogComponent.Builder {
        public AppRaterDependencies a;
        public AppRaterEventSourcePage b;

        public b(a aVar) {
        }

        @Override // com.avito.android.app_rater.di.AppRaterDialogComponent.Builder
        public AppRaterDialogComponent.Builder appRaterDependencies(AppRaterDependencies appRaterDependencies) {
            this.a = (AppRaterDependencies) Preconditions.checkNotNull(appRaterDependencies);
            return this;
        }

        @Override // com.avito.android.app_rater.di.AppRaterDialogComponent.Builder
        public AppRaterDialogComponent build() {
            Preconditions.checkBuilderRequirement(this.a, AppRaterDependencies.class);
            return new DaggerAppRaterDialogComponent(this.a, this.b, null);
        }

        @Override // com.avito.android.app_rater.di.AppRaterDialogComponent.Builder
        public AppRaterDialogComponent.Builder withSourcePage(AppRaterEventSourcePage appRaterEventSourcePage) {
            this.b = appRaterEventSourcePage;
            return this;
        }
    }

    public static class c implements Provider<Analytics> {
        public final AppRaterDependencies a;

        public c(AppRaterDependencies appRaterDependencies) {
            this.a = appRaterDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Analytics get() {
            return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
        }
    }

    public static class d implements Provider<Preferences> {
        public final AppRaterDependencies a;

        public d(AppRaterDependencies appRaterDependencies) {
            this.a = appRaterDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Preferences get() {
            return (Preferences) Preconditions.checkNotNullFromComponent(this.a.preferences());
        }
    }

    public static class e implements Provider<SchedulersFactory> {
        public final AppRaterDependencies a;

        public e(AppRaterDependencies appRaterDependencies) {
            this.a = appRaterDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public static class f implements Provider<TimeSource> {
        public final AppRaterDependencies a;

        public f(AppRaterDependencies appRaterDependencies) {
            this.a = appRaterDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TimeSource get() {
            return (TimeSource) Preconditions.checkNotNullFromComponent(this.a.timeSource());
        }
    }

    public DaggerAppRaterDialogComponent(AppRaterDependencies appRaterDependencies, AppRaterEventSourcePage appRaterEventSourcePage, a aVar) {
        this.a = appRaterDependencies;
        d dVar = new d(appRaterDependencies);
        this.b = dVar;
        PrefAppRaterSessionStorage_Factory create = PrefAppRaterSessionStorage_Factory.create(dVar);
        this.c = create;
        this.d = AppRaterInteractorImpl_Factory.create(create);
        this.e = new f(appRaterDependencies);
        this.f = new e(appRaterDependencies);
        this.g = new c(appRaterDependencies);
        Factory createNullable = InstanceFactory.createNullable(appRaterEventSourcePage);
        this.h = createNullable;
        this.i = DoubleCheck.provider(AppRaterDialogModule_ProvideViewModelFactoryFactory.create(this.d, this.e, this.f, this.g, createNullable));
    }

    public static AppRaterDialogComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.app_rater.di.AppRaterDialogComponent
    public void inject(AppRaterDialogFragment appRaterDialogFragment) {
        AppRaterDialogFragment_MembersInjector.injectViewModelFactory(appRaterDialogFragment, this.i.get());
        AppRaterDialogFragment_MembersInjector.injectSchedulersFactory(appRaterDialogFragment, (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory()));
    }
}
