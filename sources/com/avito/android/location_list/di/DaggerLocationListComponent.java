package com.avito.android.location_list.di;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import com.avito.android.analytics.Analytics;
import com.avito.android.geo.GeoStorage;
import com.avito.android.location.analytics.LocationAnalyticsInteractor;
import com.avito.android.location.analytics.LocationAnalyticsInteractorImpl;
import com.avito.android.location.analytics.LocationAnalyticsInteractorImpl_Factory;
import com.avito.android.location.di.module.FindDetectLocationModule_ProvideDefaultLocationInteractorFactory;
import com.avito.android.location.di.module.FindDetectLocationModule_ProvideDefaultLocationProviderFactory;
import com.avito.android.location.di.module.FindDetectLocationModule_ProvideDetectLocationHelper$user_location_releaseFactory;
import com.avito.android.location.di.module.FindDetectLocationModule_ProvideDetectLocationInteractor$user_location_releaseFactory;
import com.avito.android.location.di.module.FindDetectLocationModule_ProvideWeakHandler$user_location_releaseFactory;
import com.avito.android.location.find.DefaultLocationInteractor;
import com.avito.android.location.find.DefaultLocationProvider;
import com.avito.android.location.find.DetectLocationInteractor;
import com.avito.android.location.find.DetectLocationProvider;
import com.avito.android.location.find.DetectLocationProviderImpl;
import com.avito.android.location.find.DetectLocationProviderImpl_Factory;
import com.avito.android.location.find.FindDetectLocationPresenter;
import com.avito.android.location.find.FindDetectLocationPresenterImpl;
import com.avito.android.location.find.FindDetectLocationPresenterImpl_Factory;
import com.avito.android.location.find.util.DetectLocationHelper;
import com.avito.android.location_list.LocationItemSingleLinePresenterImpl;
import com.avito.android.location_list.LocationItemSingleLineRadioButtonBlueprint;
import com.avito.android.location_list.LocationItemTwoLinesPresenterImpl;
import com.avito.android.location_list.LocationItemTwoLinesRadioButtonBlueprint;
import com.avito.android.location_list.LocationListFragment;
import com.avito.android.location_list.LocationListFragment_MembersInjector;
import com.avito.android.location_list.LocationListInteractor;
import com.avito.android.location_list.LocationListPresenter;
import com.avito.android.location_list.analytics.LocationListAnalyticsInteractor;
import com.avito.android.location_list.di.LocationListComponent;
import com.avito.android.permissions.LocationPermissionDialogPresenter;
import com.avito.android.permissions.LocationPermissionProvider;
import com.avito.android.permissions.LocationPermissionProviderImpl;
import com.avito.android.permissions.LocationPermissionProviderImpl_Factory;
import com.avito.android.remote.LocationApi;
import com.avito.android.remote.error.LocationsNotFoundErrorCase;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.server_time.TimeSource;
import com.avito.android.ui.ActivityInteractor;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.WeakHandler;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.internal.DelegateFactory;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class DaggerLocationListComponent implements LocationListComponent {
    public Provider<ItemBinder> A;
    public Provider<AdapterPresenter> B;
    public Provider<Fragment> C;
    public Provider<LocationPermissionProviderImpl> D;
    public Provider<LocationPermissionProvider> E;
    public Provider<LocationPermissionDialogPresenter> F;
    public Provider<TimeSource> G;
    public Provider<LocationAnalyticsInteractorImpl> H;
    public Provider<LocationAnalyticsInteractor> I;
    public final LocationListDependencies a;
    public Provider<LocationApi> b;
    public Provider<SchedulersFactory> c;
    public Provider<TypedErrorThrowableConverter> d;
    public Provider<LocationsNotFoundErrorCase> e;
    public Provider<LocationListInteractor> f;
    public Provider<Analytics> g;
    public Provider<LocationListAnalyticsInteractor> h;
    public Provider<SchedulersFactory3> i;
    public Provider<GeoStorage> j;
    public Provider<DefaultLocationInteractor> k;
    public Provider<DefaultLocationProvider> l;
    public Provider<Activity> m;
    public Provider<ActivityInteractor> n;
    public Provider<WeakHandler> o;
    public Provider<DetectLocationHelper> p;
    public Provider<DetectLocationInteractor> q;
    public Provider<DetectLocationProviderImpl> r;
    public Provider<DetectLocationProvider> s;
    public Provider<FindDetectLocationPresenterImpl> t;
    public Provider<FindDetectLocationPresenter> u;
    public Provider<LocationListPresenter> v;
    public Provider<LocationItemTwoLinesPresenterImpl> w;
    public Provider<LocationItemTwoLinesRadioButtonBlueprint> x;
    public Provider<LocationItemSingleLinePresenterImpl> y;
    public Provider<LocationItemSingleLineRadioButtonBlueprint> z;

    public static final class b implements LocationListComponent.Builder {
        public LocationListDependencies a;
        public LocationListModule b;
        public Activity c;
        public Fragment d;
        public ActivityInteractor e;

        public b(a aVar) {
        }

        @Override // com.avito.android.location_list.di.LocationListComponent.Builder
        public LocationListComponent build() {
            Preconditions.checkBuilderRequirement(this.a, LocationListDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, LocationListModule.class);
            Preconditions.checkBuilderRequirement(this.c, Activity.class);
            Preconditions.checkBuilderRequirement(this.d, Fragment.class);
            Preconditions.checkBuilderRequirement(this.e, ActivityInteractor.class);
            return new DaggerLocationListComponent(this.b, this.a, this.c, this.d, this.e, null);
        }

        @Override // com.avito.android.location_list.di.LocationListComponent.Builder
        public LocationListComponent.Builder dependentOn(LocationListDependencies locationListDependencies) {
            this.a = (LocationListDependencies) Preconditions.checkNotNull(locationListDependencies);
            return this;
        }

        @Override // com.avito.android.location_list.di.LocationListComponent.Builder
        public LocationListComponent.Builder locationListModule(LocationListModule locationListModule) {
            this.b = (LocationListModule) Preconditions.checkNotNull(locationListModule);
            return this;
        }

        @Override // com.avito.android.location_list.di.LocationListComponent.Builder
        public LocationListComponent.Builder withActivity(Activity activity) {
            this.c = (Activity) Preconditions.checkNotNull(activity);
            return this;
        }

        @Override // com.avito.android.location_list.di.LocationListComponent.Builder
        public LocationListComponent.Builder withActivityInteractor(ActivityInteractor activityInteractor) {
            this.e = (ActivityInteractor) Preconditions.checkNotNull(activityInteractor);
            return this;
        }

        @Override // com.avito.android.location_list.di.LocationListComponent.Builder
        public LocationListComponent.Builder withFragment(Fragment fragment) {
            this.d = (Fragment) Preconditions.checkNotNull(fragment);
            return this;
        }
    }

    public static class c implements Provider<Analytics> {
        public final LocationListDependencies a;

        public c(LocationListDependencies locationListDependencies) {
            this.a = locationListDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Analytics get() {
            return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
        }
    }

    public static class d implements Provider<GeoStorage> {
        public final LocationListDependencies a;

        public d(LocationListDependencies locationListDependencies) {
            this.a = locationListDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public GeoStorage get() {
            return (GeoStorage) Preconditions.checkNotNullFromComponent(this.a.geoStorage());
        }
    }

    public static class e implements Provider<LocationApi> {
        public final LocationListDependencies a;

        public e(LocationListDependencies locationListDependencies) {
            this.a = locationListDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public LocationApi get() {
            return (LocationApi) Preconditions.checkNotNullFromComponent(this.a.locationApi());
        }
    }

    public static class f implements Provider<SchedulersFactory3> {
        public final LocationListDependencies a;

        public f(LocationListDependencies locationListDependencies) {
            this.a = locationListDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory3 get() {
            return (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3());
        }
    }

    public static class g implements Provider<SchedulersFactory> {
        public final LocationListDependencies a;

        public g(LocationListDependencies locationListDependencies) {
            this.a = locationListDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public static class h implements Provider<TimeSource> {
        public final LocationListDependencies a;

        public h(LocationListDependencies locationListDependencies) {
            this.a = locationListDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TimeSource get() {
            return (TimeSource) Preconditions.checkNotNullFromComponent(this.a.timeSource());
        }
    }

    public static class i implements Provider<TypedErrorThrowableConverter> {
        public final LocationListDependencies a;

        public i(LocationListDependencies locationListDependencies) {
            this.a = locationListDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TypedErrorThrowableConverter get() {
            return (TypedErrorThrowableConverter) Preconditions.checkNotNullFromComponent(this.a.typedErrorThrowableConverter());
        }
    }

    public DaggerLocationListComponent(LocationListModule locationListModule, LocationListDependencies locationListDependencies, Activity activity, Fragment fragment, ActivityInteractor activityInteractor, a aVar) {
        this.a = locationListDependencies;
        this.b = new e(locationListDependencies);
        this.c = new g(locationListDependencies);
        this.d = new i(locationListDependencies);
        Provider<LocationsNotFoundErrorCase> provider = DoubleCheck.provider(LocationListModule_ProvideLocationsNotFoundErrorCaseFactory.create(locationListModule));
        this.e = provider;
        this.f = DoubleCheck.provider(LocationListModule_ProvideInteractorFactory.create(locationListModule, this.b, this.c, this.d, provider));
        c cVar = new c(locationListDependencies);
        this.g = cVar;
        this.h = DoubleCheck.provider(LocationListModule_ProvideAnalyticsInteractor$location_list_releaseFactory.create(locationListModule, cVar));
        this.i = new f(locationListDependencies);
        d dVar = new d(locationListDependencies);
        this.j = dVar;
        Provider<DefaultLocationInteractor> provider2 = DoubleCheck.provider(FindDetectLocationModule_ProvideDefaultLocationInteractorFactory.create(dVar));
        this.k = provider2;
        this.l = DoubleCheck.provider(FindDetectLocationModule_ProvideDefaultLocationProviderFactory.create(provider2));
        this.m = InstanceFactory.create(activity);
        this.n = InstanceFactory.create(activityInteractor);
        Provider<WeakHandler> provider3 = DoubleCheck.provider(FindDetectLocationModule_ProvideWeakHandler$user_location_releaseFactory.create());
        this.o = provider3;
        Provider<DetectLocationHelper> provider4 = DoubleCheck.provider(FindDetectLocationModule_ProvideDetectLocationHelper$user_location_releaseFactory.create(this.m, this.n, provider3));
        this.p = provider4;
        Provider<DetectLocationInteractor> provider5 = DoubleCheck.provider(FindDetectLocationModule_ProvideDetectLocationInteractor$user_location_releaseFactory.create(provider4, this.c, this.j));
        this.q = provider5;
        DetectLocationProviderImpl_Factory create = DetectLocationProviderImpl_Factory.create(provider5);
        this.r = create;
        Provider<DetectLocationProvider> provider6 = DoubleCheck.provider(create);
        this.s = provider6;
        FindDetectLocationPresenterImpl_Factory create2 = FindDetectLocationPresenterImpl_Factory.create(this.l, provider6);
        this.t = create2;
        this.u = DoubleCheck.provider(create2);
        DelegateFactory delegateFactory = new DelegateFactory();
        this.v = delegateFactory;
        Provider<LocationItemTwoLinesPresenterImpl> provider7 = DoubleCheck.provider(LocationListModule_ProvideLocationItemTwoLinesPresenterFactory.create(locationListModule, delegateFactory));
        this.w = provider7;
        this.x = DoubleCheck.provider(LocationListModule_ProvideLocationItemTwoLinesBluePrintFactory.create(locationListModule, provider7));
        Provider<LocationItemSingleLinePresenterImpl> provider8 = DoubleCheck.provider(LocationListModule_ProvideLocationItemSingleLinePresenterFactory.create(locationListModule, this.v));
        this.y = provider8;
        Provider<LocationItemSingleLineRadioButtonBlueprint> provider9 = DoubleCheck.provider(LocationListModule_ProvideLocationItemSingleLineBluePrintFactory.create(locationListModule, provider8));
        this.z = provider9;
        Provider<ItemBinder> provider10 = DoubleCheck.provider(LocationListModule_ProvideLocationItemBinderFactory.create(locationListModule, this.x, provider9));
        this.A = provider10;
        this.B = DoubleCheck.provider(LocationListModule_ProvideAdapterPresenterFactory.create(locationListModule, provider10));
        Factory create3 = InstanceFactory.create(fragment);
        this.C = create3;
        LocationPermissionProviderImpl_Factory create4 = LocationPermissionProviderImpl_Factory.create(create3);
        this.D = create4;
        Provider<LocationPermissionProvider> provider11 = DoubleCheck.provider(create4);
        this.E = provider11;
        this.F = DoubleCheck.provider(LocationListModule_ProvideLocationPermissionDialogPresenterFactory.create(locationListModule, provider11));
        h hVar = new h(locationListDependencies);
        this.G = hVar;
        LocationAnalyticsInteractorImpl_Factory create5 = LocationAnalyticsInteractorImpl_Factory.create(this.g, hVar);
        this.H = create5;
        Provider<LocationAnalyticsInteractor> provider12 = DoubleCheck.provider(create5);
        this.I = provider12;
        DelegateFactory.setDelegate(this.v, DoubleCheck.provider(LocationListModule_ProvidePresenterFactory.create(locationListModule, this.f, this.h, this.i, this.u, this.B, this.F, provider12)));
    }

    public static LocationListComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.location_list.di.LocationListComponent
    public void inject(LocationListFragment locationListFragment) {
        LocationListFragment_MembersInjector.injectAnalytics(locationListFragment, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
        LocationListFragment_MembersInjector.injectInteractor(locationListFragment, this.f.get());
        LocationListFragment_MembersInjector.injectPresenter(locationListFragment, this.v.get());
        LocationListFragment_MembersInjector.injectAdapterPresenter(locationListFragment, this.B.get());
        LocationListFragment_MembersInjector.injectItemBinder(locationListFragment, this.A.get());
        LocationListFragment_MembersInjector.injectImplicitIntentFactory(locationListFragment, (ImplicitIntentFactory) Preconditions.checkNotNullFromComponent(this.a.implicitIntentFactory()));
        LocationListFragment_MembersInjector.injectLocationPermissionDialogPresenter(locationListFragment, this.F.get());
    }
}
