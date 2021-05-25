package com.avito.android.deep_linking.di;

import android.content.Context;
import com.avito.android.Features;
import com.avito.android.TopLocationInteractor;
import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.AdjustReattributionInteractorImpl;
import com.avito.android.deep_linking.AdjustReattributionInteractorImpl_Factory;
import com.avito.android.deep_linking.AppLinkActivity;
import com.avito.android.deep_linking.AppLinkActivity_MembersInjector;
import com.avito.android.deep_linking.AppLinkInteractor;
import com.avito.android.deep_linking.AppLinkInteractorImpl;
import com.avito.android.deep_linking.AppLinkInteractorImpl_Factory;
import com.avito.android.deep_linking.AppLinkPresenter;
import com.avito.android.deep_linking.AppLinkPresenterImpl;
import com.avito.android.deep_linking.AppLinkPresenterImpl_Factory;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.di.AppLinkComponent;
import com.avito.android.deep_linking.remote.DeeplinkApi;
import com.avito.android.location.SavedLocationInteractor;
import com.avito.android.location.SavedLocationInteractorImpl;
import com.avito.android.location.SavedLocationInteractorImpl_Factory;
import com.avito.android.location.SavedLocationStorage;
import com.avito.android.location.analytics.LocationAnalyticsInteractor;
import com.avito.android.location.analytics.LocationAnalyticsInteractorImpl;
import com.avito.android.location.analytics.LocationAnalyticsInteractorImpl_Factory;
import com.avito.android.location.back_navigation.BackNavigationLocationInteractor;
import com.avito.android.location.di.LocationDependencies;
import com.avito.android.remote.LocationApi;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import javax.inject.Provider;
public final class DaggerAppLinkComponent implements AppLinkComponent {
    public final AppLinkDependencies a;
    public Provider<DeeplinkApi> b;
    public Provider<SchedulersFactory> c;
    public Provider<AppLinkInteractorImpl> d;
    public Provider<AppLinkInteractor> e;
    public Provider<SavedLocationStorage> f;
    public Provider<LocationApi> g;
    public Provider<TopLocationInteractor> h;
    public Provider<Features> i;
    public Provider<BackNavigationLocationInteractor> j;
    public Provider<SavedLocationInteractorImpl> k;
    public Provider<SavedLocationInteractor> l;
    public Provider<Analytics> m;
    public Provider<TimeSource> n;
    public Provider<LocationAnalyticsInteractorImpl> o;
    public Provider<LocationAnalyticsInteractor> p;
    public Provider<Context> q;
    public Provider<AdjustReattributionInteractorImpl> r;
    public Provider<AppLinkPresenterImpl> s;
    public Provider<AppLinkPresenter> t;

    public static final class b implements AppLinkComponent.Builder {
        public AppLinkDependencies a;
        public LocationDependencies b;

        public b(a aVar) {
        }

        @Override // com.avito.android.deep_linking.di.AppLinkComponent.Builder
        public AppLinkComponent build() {
            Preconditions.checkBuilderRequirement(this.a, AppLinkDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, LocationDependencies.class);
            return new DaggerAppLinkComponent(this.a, this.b, null);
        }

        @Override // com.avito.android.deep_linking.di.AppLinkComponent.Builder
        public AppLinkComponent.Builder dependencies(AppLinkDependencies appLinkDependencies) {
            this.a = (AppLinkDependencies) Preconditions.checkNotNull(appLinkDependencies);
            return this;
        }

        @Override // com.avito.android.deep_linking.di.AppLinkComponent.Builder
        public AppLinkComponent.Builder locationDependencies(LocationDependencies locationDependencies) {
            this.b = (LocationDependencies) Preconditions.checkNotNull(locationDependencies);
            return this;
        }
    }

    public static class c implements Provider<Analytics> {
        public final AppLinkDependencies a;

        public c(AppLinkDependencies appLinkDependencies) {
            this.a = appLinkDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Analytics get() {
            return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
        }
    }

    public static class d implements Provider<Context> {
        public final AppLinkDependencies a;

        public d(AppLinkDependencies appLinkDependencies) {
            this.a = appLinkDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Context get() {
            return (Context) Preconditions.checkNotNullFromComponent(this.a.context());
        }
    }

    public static class e implements Provider<DeeplinkApi> {
        public final AppLinkDependencies a;

        public e(AppLinkDependencies appLinkDependencies) {
            this.a = appLinkDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public DeeplinkApi get() {
            return (DeeplinkApi) Preconditions.checkNotNullFromComponent(this.a.deeplinkApi());
        }
    }

    public static class f implements Provider<Features> {
        public final AppLinkDependencies a;

        public f(AppLinkDependencies appLinkDependencies) {
            this.a = appLinkDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Features get() {
            return (Features) Preconditions.checkNotNullFromComponent(this.a.features());
        }
    }

    public static class g implements Provider<SchedulersFactory> {
        public final AppLinkDependencies a;

        public g(AppLinkDependencies appLinkDependencies) {
            this.a = appLinkDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public static class h implements Provider<TimeSource> {
        public final AppLinkDependencies a;

        public h(AppLinkDependencies appLinkDependencies) {
            this.a = appLinkDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TimeSource get() {
            return (TimeSource) Preconditions.checkNotNullFromComponent(this.a.timeSource());
        }
    }

    public static class i implements Provider<BackNavigationLocationInteractor> {
        public final LocationDependencies a;

        public i(LocationDependencies locationDependencies) {
            this.a = locationDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public BackNavigationLocationInteractor get() {
            return (BackNavigationLocationInteractor) Preconditions.checkNotNullFromComponent(this.a.backNavigationLocationInteractor());
        }
    }

    public static class j implements Provider<LocationApi> {
        public final LocationDependencies a;

        public j(LocationDependencies locationDependencies) {
            this.a = locationDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public LocationApi get() {
            return (LocationApi) Preconditions.checkNotNullFromComponent(this.a.locationApi());
        }
    }

    public static class k implements Provider<SavedLocationStorage> {
        public final LocationDependencies a;

        public k(LocationDependencies locationDependencies) {
            this.a = locationDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SavedLocationStorage get() {
            return (SavedLocationStorage) Preconditions.checkNotNullFromComponent(this.a.savedLocationStorage());
        }
    }

    public static class l implements Provider<TopLocationInteractor> {
        public final LocationDependencies a;

        public l(LocationDependencies locationDependencies) {
            this.a = locationDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TopLocationInteractor get() {
            return (TopLocationInteractor) Preconditions.checkNotNullFromComponent(this.a.topLocationInteractor());
        }
    }

    public DaggerAppLinkComponent(AppLinkDependencies appLinkDependencies, LocationDependencies locationDependencies, a aVar) {
        this.a = appLinkDependencies;
        e eVar = new e(appLinkDependencies);
        this.b = eVar;
        g gVar = new g(appLinkDependencies);
        this.c = gVar;
        AppLinkInteractorImpl_Factory create = AppLinkInteractorImpl_Factory.create(eVar, gVar);
        this.d = create;
        this.e = DoubleCheck.provider(create);
        k kVar = new k(locationDependencies);
        this.f = kVar;
        j jVar = new j(locationDependencies);
        this.g = jVar;
        l lVar = new l(locationDependencies);
        this.h = lVar;
        f fVar = new f(appLinkDependencies);
        this.i = fVar;
        i iVar = new i(locationDependencies);
        this.j = iVar;
        SavedLocationInteractorImpl_Factory create2 = SavedLocationInteractorImpl_Factory.create(kVar, jVar, lVar, fVar, iVar);
        this.k = create2;
        this.l = SingleCheck.provider(create2);
        c cVar = new c(appLinkDependencies);
        this.m = cVar;
        h hVar = new h(appLinkDependencies);
        this.n = hVar;
        LocationAnalyticsInteractorImpl_Factory create3 = LocationAnalyticsInteractorImpl_Factory.create(cVar, hVar);
        this.o = create3;
        this.p = SingleCheck.provider(create3);
        d dVar = new d(appLinkDependencies);
        this.q = dVar;
        AdjustReattributionInteractorImpl_Factory create4 = AdjustReattributionInteractorImpl_Factory.create(dVar, this.i);
        this.r = create4;
        AppLinkPresenterImpl_Factory create5 = AppLinkPresenterImpl_Factory.create(this.e, this.c, this.l, this.p, create4);
        this.s = create5;
        this.t = DoubleCheck.provider(create5);
    }

    public static AppLinkComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.deep_linking.di.AppLinkComponent
    public void inject(AppLinkActivity appLinkActivity) {
        AppLinkActivity_MembersInjector.injectAnalytics(appLinkActivity, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
        AppLinkActivity_MembersInjector.injectDeepLinkIntentFactory(appLinkActivity, (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deeplinkIntentFactory()));
        AppLinkActivity_MembersInjector.injectImplicitIntentFactory(appLinkActivity, (ImplicitIntentFactory) Preconditions.checkNotNullFromComponent(this.a.implicitIntentFactory()));
        AppLinkActivity_MembersInjector.injectPresenter(appLinkActivity, this.t.get());
    }
}
