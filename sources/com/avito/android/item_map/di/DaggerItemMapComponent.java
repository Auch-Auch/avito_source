package com.avito.android.item_map.di;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.grafana.GraphitePrefix;
import com.avito.android.avito_map.AvitoMapAttachHelper;
import com.avito.android.avito_map.amenity.AmenityMarkerIconFactory;
import com.avito.android.avito_map.amenity.AmenityMarkerIconFactoryImpl;
import com.avito.android.avito_map.amenity.AmenityMarkerIconFactoryImpl_Factory;
import com.avito.android.geo.GeoStorage;
import com.avito.android.item_map.ItemMapFragment;
import com.avito.android.item_map.ItemMapFragment_MembersInjector;
import com.avito.android.item_map.amenity.AmenityButtonsInteractor;
import com.avito.android.item_map.amenity.AmenityButtonsInteractorImpl;
import com.avito.android.item_map.amenity.AmenityButtonsInteractorImpl_Factory;
import com.avito.android.item_map.amenity.AmenityButtonsPresenter;
import com.avito.android.item_map.amenity.AmenityButtonsPresenterImpl;
import com.avito.android.item_map.amenity.AmenityButtonsPresenterImpl_Factory;
import com.avito.android.item_map.di.ItemMapComponent;
import com.avito.android.item_map.remote.ItemMapApi;
import com.avito.android.item_map.view.ItemMapPresenter;
import com.avito.android.item_map.view.ItemMapPresenterImpl;
import com.avito.android.item_map.view.ItemMapPresenterImpl_Factory;
import com.avito.android.item_map.view.ItemMapResourceProvider;
import com.avito.android.item_map.view.ItemMapResourcesProviderImpl;
import com.avito.android.item_map.view.ItemMapResourcesProviderImpl_Factory;
import com.avito.android.item_map.view.ItemMapView;
import com.avito.android.item_map.view.ItemMapViewBottomSheetAdapter;
import com.avito.android.item_map.view.ItemMapViewBottomSheetAdapter_Factory;
import com.avito.android.location.analytics.LocationAnalyticsInteractor;
import com.avito.android.location.analytics.LocationAnalyticsInteractorImpl;
import com.avito.android.location.analytics.LocationAnalyticsInteractorImpl_Factory;
import com.avito.android.location.di.module.FindLocationModule_ProvideDefaultLocationInteractorFactory;
import com.avito.android.location.di.module.FindLocationModule_ProvideDefaultLocationProviderFactory;
import com.avito.android.location.find.DefaultLocationInteractor;
import com.avito.android.location.find.DefaultLocationProvider;
import com.avito.android.location.find.FindLocationPresenter;
import com.avito.android.location.find.FindLocationPresenterImpl;
import com.avito.android.location.find.FindLocationPresenterImpl_Factory;
import com.avito.android.location.find.FusedLocationInteractor;
import com.avito.android.location.find.FusedLocationInteractorImpl;
import com.avito.android.location.find.FusedLocationInteractorImpl_Factory;
import com.avito.android.location.find.GoogleServicesLocationProvider;
import com.avito.android.location.find.GoogleServicesLocationProviderImpl;
import com.avito.android.location.find.GoogleServicesLocationProviderImpl_Factory;
import com.avito.android.permissions.LocationPermissionDialogPresenter;
import com.avito.android.permissions.LocationPermissionProvider;
import com.avito.android.permissions.LocationPermissionProviderImpl;
import com.avito.android.permissions.LocationPermissionProviderImpl_Factory;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.server_time.TimeSource;
import com.avito.android.ui.ActivityInteractor;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class DaggerItemMapComponent implements ItemMapComponent {
    public Provider<TypedErrorThrowableConverter> A;
    public Provider<AmenityButtonsInteractorImpl> B;
    public Provider<AmenityButtonsInteractor> C;
    public Provider<Context> D;
    public Provider<AmenityMarkerIconFactoryImpl> E;
    public Provider<AmenityMarkerIconFactory> F;
    public Provider<Kundle> G;
    public Provider<AmenityButtonsPresenterImpl> H;
    public Provider<AmenityButtonsPresenter> I;
    public Provider<Features> J;
    public Provider<AvitoMapAttachHelper> K;
    public Provider<ItemMapViewBottomSheetAdapter> L;
    public Provider<RecyclerView.Adapter<RecyclerView.ViewHolder>> M;
    public final ItemMapDependencies a;
    public Provider<ItemMapView.ItemMapState> b;
    public Provider<Resources> c;
    public Provider<ItemMapResourcesProviderImpl> d;
    public Provider<ItemMapResourceProvider> e;
    public Provider<SchedulersFactory3> f;
    public Provider<Analytics> g;
    public Provider<Fragment> h;
    public Provider<LocationPermissionProviderImpl> i;
    public Provider<LocationPermissionProvider> j;
    public Provider<LocationPermissionDialogPresenter> k;
    public Provider<GeoStorage> l;
    public Provider<DefaultLocationInteractor> m;
    public Provider<DefaultLocationProvider> n;
    public Provider<FusedLocationInteractorImpl> o;
    public Provider<FusedLocationInteractor> p;
    public Provider<GoogleServicesLocationProviderImpl> q;
    public Provider<GoogleServicesLocationProvider> r;
    public Provider<FindLocationPresenterImpl> s;
    public Provider<FindLocationPresenter> t;
    public Provider<TimeSource> u;
    public Provider<LocationAnalyticsInteractorImpl> v;
    public Provider<LocationAnalyticsInteractor> w;
    public Provider<ItemMapPresenterImpl> x;
    public Provider<ItemMapPresenter> y;
    public Provider<ItemMapApi> z;

    public static final class b implements ItemMapComponent.Builder {
        public ItemMapDependencies a;
        public ItemMapView.ItemMapState b;
        public ActivityInteractor c;
        public Activity d;
        public Fragment e;
        public Kundle f;
        public Resources g;
        public Context h;

        public b(a aVar) {
        }

        @Override // com.avito.android.item_map.di.ItemMapComponent.Builder
        public ItemMapComponent build() {
            Preconditions.checkBuilderRequirement(this.a, ItemMapDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, ItemMapView.ItemMapState.class);
            Preconditions.checkBuilderRequirement(this.c, ActivityInteractor.class);
            Preconditions.checkBuilderRequirement(this.d, Activity.class);
            Preconditions.checkBuilderRequirement(this.e, Fragment.class);
            Preconditions.checkBuilderRequirement(this.g, Resources.class);
            Preconditions.checkBuilderRequirement(this.h, Context.class);
            return new DaggerItemMapComponent(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, null);
        }

        @Override // com.avito.android.item_map.di.ItemMapComponent.Builder
        public ItemMapComponent.Builder context(Context context) {
            this.h = (Context) Preconditions.checkNotNull(context);
            return this;
        }

        @Override // com.avito.android.item_map.di.ItemMapComponent.Builder
        public ItemMapComponent.Builder dependencies(ItemMapDependencies itemMapDependencies) {
            this.a = (ItemMapDependencies) Preconditions.checkNotNull(itemMapDependencies);
            return this;
        }

        @Override // com.avito.android.item_map.di.ItemMapComponent.Builder
        public ItemMapComponent.Builder resources(Resources resources) {
            this.g = (Resources) Preconditions.checkNotNull(resources);
            return this;
        }

        @Override // com.avito.android.item_map.di.ItemMapComponent.Builder
        public ItemMapComponent.Builder savedAmenityState(Kundle kundle) {
            this.f = kundle;
            return this;
        }

        @Override // com.avito.android.item_map.di.ItemMapComponent.Builder
        public ItemMapComponent.Builder savedState(ItemMapView.ItemMapState itemMapState) {
            this.b = (ItemMapView.ItemMapState) Preconditions.checkNotNull(itemMapState);
            return this;
        }

        @Override // com.avito.android.item_map.di.ItemMapComponent.Builder
        public ItemMapComponent.Builder withActivity(Activity activity) {
            this.d = (Activity) Preconditions.checkNotNull(activity);
            return this;
        }

        @Override // com.avito.android.item_map.di.ItemMapComponent.Builder
        public ItemMapComponent.Builder withActivityInteractor(ActivityInteractor activityInteractor) {
            this.c = (ActivityInteractor) Preconditions.checkNotNull(activityInteractor);
            return this;
        }

        @Override // com.avito.android.item_map.di.ItemMapComponent.Builder
        public ItemMapComponent.Builder withFragment(Fragment fragment) {
            this.e = (Fragment) Preconditions.checkNotNull(fragment);
            return this;
        }
    }

    public static class c implements Provider<Analytics> {
        public final ItemMapDependencies a;

        public c(ItemMapDependencies itemMapDependencies) {
            this.a = itemMapDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Analytics get() {
            return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
        }
    }

    public static class d implements Provider<Features> {
        public final ItemMapDependencies a;

        public d(ItemMapDependencies itemMapDependencies) {
            this.a = itemMapDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Features get() {
            return (Features) Preconditions.checkNotNullFromComponent(this.a.features());
        }
    }

    public static class e implements Provider<GeoStorage> {
        public final ItemMapDependencies a;

        public e(ItemMapDependencies itemMapDependencies) {
            this.a = itemMapDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public GeoStorage get() {
            return (GeoStorage) Preconditions.checkNotNullFromComponent(this.a.geoStorage());
        }
    }

    public static class f implements Provider<ItemMapApi> {
        public final ItemMapDependencies a;

        public f(ItemMapDependencies itemMapDependencies) {
            this.a = itemMapDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ItemMapApi get() {
            return (ItemMapApi) Preconditions.checkNotNullFromComponent(this.a.itemMapApi());
        }
    }

    public static class g implements Provider<SchedulersFactory3> {
        public final ItemMapDependencies a;

        public g(ItemMapDependencies itemMapDependencies) {
            this.a = itemMapDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory3 get() {
            return (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3());
        }
    }

    public static class h implements Provider<TimeSource> {
        public final ItemMapDependencies a;

        public h(ItemMapDependencies itemMapDependencies) {
            this.a = itemMapDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TimeSource get() {
            return (TimeSource) Preconditions.checkNotNullFromComponent(this.a.timeSource());
        }
    }

    public static class i implements Provider<TypedErrorThrowableConverter> {
        public final ItemMapDependencies a;

        public i(ItemMapDependencies itemMapDependencies) {
            this.a = itemMapDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TypedErrorThrowableConverter get() {
            return (TypedErrorThrowableConverter) Preconditions.checkNotNullFromComponent(this.a.typedErrorThrowableConverter());
        }
    }

    public DaggerItemMapComponent(ItemMapDependencies itemMapDependencies, ItemMapView.ItemMapState itemMapState, ActivityInteractor activityInteractor, Activity activity, Fragment fragment, Kundle kundle, Resources resources, Context context, a aVar) {
        this.a = itemMapDependencies;
        this.b = InstanceFactory.create(itemMapState);
        Factory create = InstanceFactory.create(resources);
        this.c = create;
        ItemMapResourcesProviderImpl_Factory create2 = ItemMapResourcesProviderImpl_Factory.create(create);
        this.d = create2;
        this.e = DoubleCheck.provider(create2);
        this.f = new g(itemMapDependencies);
        this.g = new c(itemMapDependencies);
        Factory create3 = InstanceFactory.create(fragment);
        this.h = create3;
        LocationPermissionProviderImpl_Factory create4 = LocationPermissionProviderImpl_Factory.create(create3);
        this.i = create4;
        Provider<LocationPermissionProvider> provider = DoubleCheck.provider(create4);
        this.j = provider;
        this.k = DoubleCheck.provider(ItemMapModule_ProvideLocationPermissionDialogPresenter$item_map_releaseFactory.create(provider));
        e eVar = new e(itemMapDependencies);
        this.l = eVar;
        Provider<DefaultLocationInteractor> provider2 = DoubleCheck.provider(FindLocationModule_ProvideDefaultLocationInteractorFactory.create(eVar));
        this.m = provider2;
        this.n = DoubleCheck.provider(FindLocationModule_ProvideDefaultLocationProviderFactory.create(provider2));
        FusedLocationInteractorImpl_Factory create5 = FusedLocationInteractorImpl_Factory.create(this.l);
        this.o = create5;
        Provider<FusedLocationInteractor> provider3 = DoubleCheck.provider(create5);
        this.p = provider3;
        GoogleServicesLocationProviderImpl_Factory create6 = GoogleServicesLocationProviderImpl_Factory.create(provider3);
        this.q = create6;
        Provider<GoogleServicesLocationProvider> provider4 = DoubleCheck.provider(create6);
        this.r = provider4;
        FindLocationPresenterImpl_Factory create7 = FindLocationPresenterImpl_Factory.create(this.n, provider4);
        this.s = create7;
        this.t = DoubleCheck.provider(create7);
        h hVar = new h(itemMapDependencies);
        this.u = hVar;
        LocationAnalyticsInteractorImpl_Factory create8 = LocationAnalyticsInteractorImpl_Factory.create(this.g, hVar);
        this.v = create8;
        Provider<LocationAnalyticsInteractor> provider5 = DoubleCheck.provider(create8);
        this.w = provider5;
        ItemMapPresenterImpl_Factory create9 = ItemMapPresenterImpl_Factory.create(this.b, this.e, this.f, this.g, this.k, this.t, provider5);
        this.x = create9;
        this.y = DoubleCheck.provider(create9);
        f fVar = new f(itemMapDependencies);
        this.z = fVar;
        i iVar = new i(itemMapDependencies);
        this.A = iVar;
        AmenityButtonsInteractorImpl_Factory create10 = AmenityButtonsInteractorImpl_Factory.create(fVar, iVar, this.f);
        this.B = create10;
        this.C = DoubleCheck.provider(create10);
        Factory create11 = InstanceFactory.create(context);
        this.D = create11;
        AmenityMarkerIconFactoryImpl_Factory create12 = AmenityMarkerIconFactoryImpl_Factory.create(create11);
        this.E = create12;
        this.F = DoubleCheck.provider(create12);
        Factory createNullable = InstanceFactory.createNullable(kundle);
        this.G = createNullable;
        AmenityButtonsPresenterImpl_Factory create13 = AmenityButtonsPresenterImpl_Factory.create(this.C, this.F, this.b, createNullable, this.f);
        this.H = create13;
        this.I = DoubleCheck.provider(create13);
        d dVar = new d(itemMapDependencies);
        this.J = dVar;
        this.K = DoubleCheck.provider(ItemMapModule_ProvideAvitoMapAttachHelperFactory.create(dVar));
        ItemMapViewBottomSheetAdapter_Factory create14 = ItemMapViewBottomSheetAdapter_Factory.create(this.I);
        this.L = create14;
        this.M = DoubleCheck.provider(create14);
    }

    public static ItemMapComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.item_map.di.ItemMapComponent
    public void inject(ItemMapFragment itemMapFragment) {
        ItemMapFragment_MembersInjector.injectPresenter(itemMapFragment, this.y.get());
        ItemMapFragment_MembersInjector.injectAmenityPresenter(itemMapFragment, this.I.get());
        ItemMapFragment_MembersInjector.injectMapAttachHelper(itemMapFragment, this.K.get());
        ItemMapFragment_MembersInjector.injectAnalytics(itemMapFragment, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
        ItemMapFragment_MembersInjector.injectGraphitePrefix(itemMapFragment, (GraphitePrefix) Preconditions.checkNotNullFromComponent(this.a.graphitePrefix()));
        ItemMapFragment_MembersInjector.injectItemAdapter(itemMapFragment, this.M.get());
        ItemMapFragment_MembersInjector.injectFeatures(itemMapFragment, (Features) Preconditions.checkNotNullFromComponent(this.a.features()));
        ItemMapFragment_MembersInjector.injectIntentFactory(itemMapFragment, (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.a.intentFactory()));
        ItemMapFragment_MembersInjector.injectFindLocationPresenter(itemMapFragment, this.t.get());
        ItemMapFragment_MembersInjector.injectLocationPermissionDialogPresenter(itemMapFragment, this.k.get());
        ItemMapFragment_MembersInjector.injectImplicitIntentFactory(itemMapFragment, (ImplicitIntentFactory) Preconditions.checkNotNullFromComponent(this.a.implicitIntentFactory()));
    }
}
