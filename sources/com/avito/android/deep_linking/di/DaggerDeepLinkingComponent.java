package com.avito.android.deep_linking.di;

import android.content.Context;
import com.avito.android.Features;
import com.avito.android.TopLocationInteractor;
import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.AdjustReattributionInteractorImpl;
import com.avito.android.deep_linking.AdjustReattributionInteractorImpl_Factory;
import com.avito.android.deep_linking.DeepLinkContainerIntentFactory;
import com.avito.android.deep_linking.DeepLinkFactory;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.DeepLinkingActivity;
import com.avito.android.deep_linking.DeepLinkingActivity_MembersInjector;
import com.avito.android.deep_linking.DeepLinkingPresenter;
import com.avito.android.deep_linking.DeepLinkingPresenterImpl;
import com.avito.android.deep_linking.DeepLinkingPresenterImpl_Factory;
import com.avito.android.deep_linking.DeepLinkingRouter;
import com.avito.android.deep_linking.di.DeepLinkingComponent;
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
import com.avito.android.util.SchedulersFactory;
import dagger.internal.DoubleCheck;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import javax.inject.Provider;
public final class DaggerDeepLinkingComponent implements DeepLinkingComponent {
    public final DeepLinkingDependencies a;
    public Provider<DeepLinkFactory> b;
    public Provider<SchedulersFactory> c;
    public Provider<DeepLinkingRouter> d;
    public Provider<Analytics> e;
    public Provider<TimeSource> f;
    public Provider<LocationAnalyticsInteractorImpl> g;
    public Provider<LocationAnalyticsInteractor> h;
    public Provider<SavedLocationStorage> i;
    public Provider<LocationApi> j;
    public Provider<TopLocationInteractor> k;
    public Provider<Features> l;
    public Provider<BackNavigationLocationInteractor> m;
    public Provider<SavedLocationInteractorImpl> n;
    public Provider<SavedLocationInteractor> o;
    public Provider<Context> p;
    public Provider<AdjustReattributionInteractorImpl> q;
    public Provider<DeepLinkingPresenterImpl> r;
    public Provider<DeepLinkingPresenter> s;

    public static final class b implements DeepLinkingComponent.Builder {
        public DeepLinkingDependencies a;
        public LocationDependencies b;
        public DeepLinkingRouter c;

        public b(a aVar) {
        }

        @Override // com.avito.android.deep_linking.di.DeepLinkingComponent.Builder
        public DeepLinkingComponent build() {
            Preconditions.checkBuilderRequirement(this.a, DeepLinkingDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, LocationDependencies.class);
            Preconditions.checkBuilderRequirement(this.c, DeepLinkingRouter.class);
            return new DaggerDeepLinkingComponent(this.a, this.b, this.c, null);
        }

        @Override // com.avito.android.deep_linking.di.DeepLinkingComponent.Builder
        public DeepLinkingComponent.Builder deepLinkDependencies(DeepLinkingDependencies deepLinkingDependencies) {
            this.a = (DeepLinkingDependencies) Preconditions.checkNotNull(deepLinkingDependencies);
            return this;
        }

        @Override // com.avito.android.deep_linking.di.DeepLinkingComponent.Builder
        public DeepLinkingComponent.Builder locationDependencies(LocationDependencies locationDependencies) {
            this.b = (LocationDependencies) Preconditions.checkNotNull(locationDependencies);
            return this;
        }

        @Override // com.avito.android.deep_linking.di.DeepLinkingComponent.Builder
        public DeepLinkingComponent.Builder withRouter(DeepLinkingRouter deepLinkingRouter) {
            this.c = (DeepLinkingRouter) Preconditions.checkNotNull(deepLinkingRouter);
            return this;
        }
    }

    public static class c implements Provider<Analytics> {
        public final DeepLinkingDependencies a;

        public c(DeepLinkingDependencies deepLinkingDependencies) {
            this.a = deepLinkingDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Analytics get() {
            return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
        }
    }

    public static class d implements Provider<Context> {
        public final DeepLinkingDependencies a;

        public d(DeepLinkingDependencies deepLinkingDependencies) {
            this.a = deepLinkingDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Context get() {
            return (Context) Preconditions.checkNotNullFromComponent(this.a.context());
        }
    }

    public static class e implements Provider<DeepLinkFactory> {
        public final DeepLinkingDependencies a;

        public e(DeepLinkingDependencies deepLinkingDependencies) {
            this.a = deepLinkingDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public DeepLinkFactory get() {
            return (DeepLinkFactory) Preconditions.checkNotNullFromComponent(this.a.deeplinkFactory());
        }
    }

    public static class f implements Provider<Features> {
        public final DeepLinkingDependencies a;

        public f(DeepLinkingDependencies deepLinkingDependencies) {
            this.a = deepLinkingDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Features get() {
            return (Features) Preconditions.checkNotNullFromComponent(this.a.features());
        }
    }

    public static class g implements Provider<SchedulersFactory> {
        public final DeepLinkingDependencies a;

        public g(DeepLinkingDependencies deepLinkingDependencies) {
            this.a = deepLinkingDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public static class h implements Provider<TimeSource> {
        public final DeepLinkingDependencies a;

        public h(DeepLinkingDependencies deepLinkingDependencies) {
            this.a = deepLinkingDependencies;
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

    public DaggerDeepLinkingComponent(DeepLinkingDependencies deepLinkingDependencies, LocationDependencies locationDependencies, DeepLinkingRouter deepLinkingRouter, a aVar) {
        this.a = deepLinkingDependencies;
        this.b = new e(deepLinkingDependencies);
        this.c = new g(deepLinkingDependencies);
        this.d = InstanceFactory.create(deepLinkingRouter);
        c cVar = new c(deepLinkingDependencies);
        this.e = cVar;
        h hVar = new h(deepLinkingDependencies);
        this.f = hVar;
        LocationAnalyticsInteractorImpl_Factory create = LocationAnalyticsInteractorImpl_Factory.create(cVar, hVar);
        this.g = create;
        this.h = SingleCheck.provider(create);
        k kVar = new k(locationDependencies);
        this.i = kVar;
        j jVar = new j(locationDependencies);
        this.j = jVar;
        l lVar = new l(locationDependencies);
        this.k = lVar;
        f fVar = new f(deepLinkingDependencies);
        this.l = fVar;
        i iVar = new i(locationDependencies);
        this.m = iVar;
        SavedLocationInteractorImpl_Factory create2 = SavedLocationInteractorImpl_Factory.create(kVar, jVar, lVar, fVar, iVar);
        this.n = create2;
        this.o = SingleCheck.provider(create2);
        d dVar = new d(deepLinkingDependencies);
        this.p = dVar;
        AdjustReattributionInteractorImpl_Factory create3 = AdjustReattributionInteractorImpl_Factory.create(dVar, this.l);
        this.q = create3;
        DeepLinkingPresenterImpl_Factory create4 = DeepLinkingPresenterImpl_Factory.create(this.b, this.c, this.d, this.h, this.o, create3);
        this.r = create4;
        this.s = DoubleCheck.provider(create4);
    }

    public static DeepLinkingComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.deep_linking.di.DeepLinkingComponent
    public void inject(DeepLinkingActivity deepLinkingActivity) {
        DeepLinkingActivity_MembersInjector.injectDeepLinkIntentFactory(deepLinkingActivity, (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deeplinkIntentFactory()));
        DeepLinkingActivity_MembersInjector.injectDeepLinkContainerIntentFactory(deepLinkingActivity, (DeepLinkContainerIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deepLinkContainerIntentFactory()));
        DeepLinkingActivity_MembersInjector.injectPresenter(deepLinkingActivity, this.s.get());
    }
}
