package com.avito.android.di.component;

import com.avito.android.analytics.Analytics;
import com.avito.android.di.AppUpdateServiceDependencies;
import com.avito.android.di.component.AppUpdateServiceComponent;
import com.avito.android.preferences.TokenStorage;
import com.avito.android.preferences.VersionStorage;
import com.avito.android.service.short_task.app_update.AppUpdateApi;
import com.avito.android.service.short_task.app_update.AppUpdateInteractor;
import com.avito.android.service.short_task.app_update.AppUpdateInteractorImpl;
import com.avito.android.service.short_task.app_update.AppUpdateInteractorImpl_Factory;
import com.avito.android.service.short_task.app_update.AppUpdateTask;
import com.avito.android.service.short_task.app_update.AppUpdateTask_MembersInjector;
import com.avito.android.util.BuildInfo;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class DaggerAppUpdateServiceComponent implements AppUpdateServiceComponent {
    public final AppUpdateServiceDependencies a;
    public Provider<AppUpdateApi> b;
    public Provider<TokenStorage> c;
    public Provider<BuildInfo> d;
    public Provider<Analytics> e;
    public Provider<AppUpdateInteractorImpl> f;
    public Provider<AppUpdateInteractor> g;

    public static final class b implements AppUpdateServiceComponent.Builder {
        public AppUpdateServiceDependencies a;

        public b(a aVar) {
        }

        @Override // com.avito.android.di.component.AppUpdateServiceComponent.Builder
        public AppUpdateServiceComponent build() {
            Preconditions.checkBuilderRequirement(this.a, AppUpdateServiceDependencies.class);
            return new DaggerAppUpdateServiceComponent(this.a, null);
        }

        @Override // com.avito.android.di.component.AppUpdateServiceComponent.Builder
        public AppUpdateServiceComponent.Builder dependencies(AppUpdateServiceDependencies appUpdateServiceDependencies) {
            this.a = (AppUpdateServiceDependencies) Preconditions.checkNotNull(appUpdateServiceDependencies);
            return this;
        }
    }

    public static class c implements Provider<Analytics> {
        public final AppUpdateServiceDependencies a;

        public c(AppUpdateServiceDependencies appUpdateServiceDependencies) {
            this.a = appUpdateServiceDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Analytics get() {
            return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
        }
    }

    public static class d implements Provider<AppUpdateApi> {
        public final AppUpdateServiceDependencies a;

        public d(AppUpdateServiceDependencies appUpdateServiceDependencies) {
            this.a = appUpdateServiceDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public AppUpdateApi get() {
            return (AppUpdateApi) Preconditions.checkNotNullFromComponent(this.a.appUpdateApi());
        }
    }

    public static class e implements Provider<BuildInfo> {
        public final AppUpdateServiceDependencies a;

        public e(AppUpdateServiceDependencies appUpdateServiceDependencies) {
            this.a = appUpdateServiceDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public BuildInfo get() {
            return (BuildInfo) Preconditions.checkNotNullFromComponent(this.a.buildInfo());
        }
    }

    public static class f implements Provider<TokenStorage> {
        public final AppUpdateServiceDependencies a;

        public f(AppUpdateServiceDependencies appUpdateServiceDependencies) {
            this.a = appUpdateServiceDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TokenStorage get() {
            return (TokenStorage) Preconditions.checkNotNullFromComponent(this.a.tokenStorage());
        }
    }

    public DaggerAppUpdateServiceComponent(AppUpdateServiceDependencies appUpdateServiceDependencies, a aVar) {
        this.a = appUpdateServiceDependencies;
        d dVar = new d(appUpdateServiceDependencies);
        this.b = dVar;
        f fVar = new f(appUpdateServiceDependencies);
        this.c = fVar;
        e eVar = new e(appUpdateServiceDependencies);
        this.d = eVar;
        c cVar = new c(appUpdateServiceDependencies);
        this.e = cVar;
        AppUpdateInteractorImpl_Factory create = AppUpdateInteractorImpl_Factory.create(dVar, fVar, eVar, cVar);
        this.f = create;
        this.g = DoubleCheck.provider(create);
    }

    public static AppUpdateServiceComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.di.component.AppUpdateServiceComponent
    public void inject(AppUpdateTask appUpdateTask) {
        AppUpdateTask_MembersInjector.injectVersionStorage(appUpdateTask, (VersionStorage) Preconditions.checkNotNullFromComponent(this.a.versionStorage()));
        AppUpdateTask_MembersInjector.injectAppUpdateInteractor(appUpdateTask, this.g.get());
        AppUpdateTask_MembersInjector.injectAnalytics(appUpdateTask, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
        AppUpdateTask_MembersInjector.injectBuildInfo(appUpdateTask, (BuildInfo) Preconditions.checkNotNullFromComponent(this.a.buildInfo()));
    }
}
