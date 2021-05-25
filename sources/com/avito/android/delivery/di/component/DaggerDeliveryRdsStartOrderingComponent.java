package com.avito.android.delivery.di.component;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import androidx.fragment.app.Fragment;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.screens.ScreenFlowTrackerProvider;
import com.avito.android.analytics.screens.TimerFactory_Factory;
import com.avito.android.analytics.screens.tracker.BaseScreenPerformanceTracker;
import com.avito.android.analytics.screens.tracker.BaseScreenPerformanceTrackerImpl;
import com.avito.android.analytics.screens.tracker.BaseScreenPerformanceTrackerImpl_Factory;
import com.avito.android.analytics.screens.tracker.ScreenDiInjectTracker;
import com.avito.android.analytics.screens.tracker.ScreenInitTracker;
import com.avito.android.analytics.screens.tracker.ScreenTrackerFactory;
import com.avito.android.avito_map.AvitoMapAttachHelper;
import com.avito.android.delivery.di.component.DeliveryRdsStartOrderingComponent;
import com.avito.android.delivery.di.module.DeliveryRdsMapModule_ProvideDeliveryMapViewModel$delivery_releaseFactory;
import com.avito.android.delivery.di.module.DeliveryRdsMapModule_ProvideIconFactory$delivery_releaseFactory;
import com.avito.android.delivery.di.module.DeliveryRdsPointInfoModule_ProvideAdapterPresenter$delivery_releaseFactory;
import com.avito.android.delivery.di.module.DeliveryRdsPointInfoModule_ProvideDeliveryRdsPointInfoViewModel$delivery_releaseFactory;
import com.avito.android.delivery.di.module.DeliveryRdsPointInfoModule_ProvideItemBinder$delivery_releaseFactory;
import com.avito.android.delivery.di.module.DeliveryRdsPointInfoModule_ProvideMultiServiceItemPresenter$delivery_releaseFactory;
import com.avito.android.delivery.di.module.DeliveryRdsStartOrderingModule_ProvideAvitoMapAttachHelper$delivery_releaseFactory;
import com.avito.android.delivery.di.module.DeliveryRdsStartOrderingModule_ProvideDeliveryRdsStartOrderingViewModel$delivery_releaseFactory;
import com.avito.android.delivery.di.module.DeliveryRdsStartOrderingTrackerModule_ProvidesScreenContentTypeFactory;
import com.avito.android.delivery.di.module.DeliveryRdsStartOrderingTrackerModule_ProvidesScreenDiInjectTracker$delivery_releaseFactory;
import com.avito.android.delivery.di.module.DeliveryRdsStartOrderingTrackerModule_ProvidesScreenFlowTrackerProviderFactory;
import com.avito.android.delivery.di.module.DeliveryRdsStartOrderingTrackerModule_ProvidesScreenInitTrackerFactory;
import com.avito.android.delivery.map.common.DeliveryLocationInteractor;
import com.avito.android.delivery.map.common.DeliveryLocationInteractorImpl;
import com.avito.android.delivery.map.common.DeliveryLocationInteractorImpl_Factory;
import com.avito.android.delivery.map.common.DeliveryMapResourceProvider;
import com.avito.android.delivery.map.common.DeliveryMapResourceProviderImpl;
import com.avito.android.delivery.map.common.DeliveryMapResourceProviderImpl_Factory;
import com.avito.android.delivery.map.common.DeliveryMapViewModel;
import com.avito.android.delivery.map.common.DeliveryMapViewPresenterFactory;
import com.avito.android.delivery.map.common.DeliveryMapViewPresenterFactory_Factory;
import com.avito.android.delivery.map.common.marker.ClusterMarkerManager;
import com.avito.android.delivery.map.common.marker.ClusterMarkerManagerImpl;
import com.avito.android.delivery.map.common.marker.ClusterMarkerManagerImpl_Factory;
import com.avito.android.delivery.map.common.marker.DeliveryMapMarkerIconFactory;
import com.avito.android.delivery.map.common.marker.DeliveryMapMarkerResourceProvider_Factory;
import com.avito.android.delivery.map.common.marker.MarkerLabelManagerImpl;
import com.avito.android.delivery.map.common.marker.MarkerLabelManagerImpl_Factory;
import com.avito.android.delivery.map.common.marker.calculator.ClusterRadiusCalculator;
import com.avito.android.delivery.map.common.marker.calculator.LowRarityClusterRadiusCalculator_Factory;
import com.avito.android.delivery.map.point_info.DeliveryRdsPointInfoInteractor;
import com.avito.android.delivery.map.point_info.DeliveryRdsPointInfoInteractorImpl;
import com.avito.android.delivery.map.point_info.DeliveryRdsPointInfoInteractorImpl_Factory;
import com.avito.android.delivery.map.point_info.DeliveryRdsPointInfoResourceProviderImpl;
import com.avito.android.delivery.map.point_info.DeliveryRdsPointInfoResourceProviderImpl_Factory;
import com.avito.android.delivery.map.point_info.DeliveryRdsPointInfoViewModel;
import com.avito.android.delivery.map.point_info.DeliveryRdsPointInfoViewModelFactory;
import com.avito.android.delivery.map.point_info.DeliveryRdsPointInfoViewModelFactory_Factory;
import com.avito.android.delivery.map.point_info.konveyor.service.multiple.MultiServiceItemBlueprint;
import com.avito.android.delivery.map.point_info.konveyor.service.multiple.MultiServiceItemBlueprint_Factory;
import com.avito.android.delivery.map.point_info.konveyor.service.multiple.MultiServiceItemPresenter;
import com.avito.android.delivery.map.point_info.konveyor.service.single.ServiceItemBlueprint;
import com.avito.android.delivery.map.point_info.konveyor.service.single.ServiceItemBlueprint_Factory;
import com.avito.android.delivery.map.point_info.konveyor.service.single.ServiceItemPresenter;
import com.avito.android.delivery.map.point_info.konveyor.service.single.ServiceItemPresenterImpl_Factory;
import com.avito.android.delivery.map.point_info.konveyor.title.TitleItemBlueprint;
import com.avito.android.delivery.map.point_info.konveyor.title.TitleItemBlueprint_Factory;
import com.avito.android.delivery.map.point_info.konveyor.title.TitleItemPresenter;
import com.avito.android.delivery.map.point_info.konveyor.title.TitleItemPresenterImpl_Factory;
import com.avito.android.delivery.map.start_ordering.DeliveryRdsStartOrderingFragment;
import com.avito.android.delivery.map.start_ordering.DeliveryRdsStartOrderingFragment_MembersInjector;
import com.avito.android.delivery.map.start_ordering.DeliveryRdsStartOrderingInteractor;
import com.avito.android.delivery.map.start_ordering.DeliveryRdsStartOrderingInteractorImpl;
import com.avito.android.delivery.map.start_ordering.DeliveryRdsStartOrderingInteractorImpl_Factory;
import com.avito.android.delivery.map.start_ordering.DeliveryRdsStartOrderingViewModel;
import com.avito.android.delivery.map.start_ordering.DeliveryRdsStartOrderingViewModelFactory;
import com.avito.android.delivery.map.start_ordering.DeliveryRdsStartOrderingViewModelFactory_Factory;
import com.avito.android.delivery.map.start_ordering.DeliveryStartOrderingResourceProvider;
import com.avito.android.delivery.map.start_ordering.DeliveryStartOrderingResourceProviderImpl;
import com.avito.android.delivery.map.start_ordering.DeliveryStartOrderingResourceProviderImpl_Factory;
import com.avito.android.delivery.utils.DrawableFactoryImpl;
import com.avito.android.delivery.utils.DrawableFactoryImpl_Factory;
import com.avito.android.geo.GeoStorage;
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
import com.avito.android.permissions.LocationPermissionDialogPresenterImpl;
import com.avito.android.permissions.LocationPermissionDialogPresenterImpl_Factory;
import com.avito.android.permissions.LocationPermissionProvider;
import com.avito.android.permissions.LocationPermissionProviderImpl;
import com.avito.android.permissions.LocationPermissionProviderImpl_Factory;
import com.avito.android.remote.DeliveryApi;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.remote.model.ParametrizedEvent;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.android.util.text.AttributedTextFormatterModule_ProvideAttributedTextFormatterFactory;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import javax.inject.Provider;
public final class DaggerDeliveryRdsStartOrderingComponent implements DeliveryRdsStartOrderingComponent {
    public Provider<DeliveryRdsStartOrderingViewModelFactory> A;
    public Provider<DeliveryRdsStartOrderingViewModel> B;
    public Provider<Context> C;
    public Provider<ClusterRadiusCalculator> D;
    public Provider<ClusterMarkerManagerImpl> E;
    public Provider<ClusterMarkerManager> F;
    public Provider<DeliveryLocationInteractorImpl> G;
    public Provider<DeliveryLocationInteractor> H;
    public Provider<DeliveryMapResourceProviderImpl> I;
    public Provider<DeliveryMapResourceProvider> J;
    public Provider<MarkerLabelManagerImpl> K;
    public Provider<DeliveryMapViewPresenterFactory> L;
    public Provider<DeliveryMapViewModel> M;
    public Provider<ServiceItemPresenter> N;
    public Provider<DrawableFactoryImpl> O;
    public Provider<AttributedTextFormatter> P;
    public Provider<ServiceItemBlueprint> Q;
    public Provider<DeliveryRdsPointInfoInteractorImpl> R;
    public Provider<DeliveryRdsPointInfoInteractor> S;
    public Provider<DeliveryRdsPointInfoResourceProviderImpl> T;
    public Provider<DeliveryRdsPointInfoViewModelFactory> U;
    public Provider<DeliveryRdsPointInfoViewModel> V;
    public Provider<MultiServiceItemPresenter> W;
    public Provider<MultiServiceItemBlueprint> X;
    public Provider<TitleItemPresenter> Y;
    public Provider<TitleItemBlueprint> Z;
    public final DeliveryRdsCommonDependencies a;
    public Provider<ItemBinder> a0;
    public Provider<Fragment> b;
    public Provider<AdapterPresenter> b0;
    public Provider<DeliveryApi> c;
    public Provider<LocationPermissionProviderImpl> c0;
    public Provider<TypedErrorThrowableConverter> d;
    public Provider<LocationPermissionProvider> d0;
    public Provider<SchedulersFactory3> e;
    public Provider<LocationPermissionDialogPresenterImpl> e0;
    public Provider<DeliveryRdsStartOrderingInteractorImpl> f;
    public Provider<LocationPermissionDialogPresenter> f0;
    public Provider<DeliveryRdsStartOrderingInteractor> g;
    public Provider<Features> g0;
    public Provider<String> h;
    public Provider<AvitoMapAttachHelper> h0;
    public Provider<String> i;
    public Provider<DeliveryMapMarkerIconFactory> i0;
    public Provider<String> j;
    public Provider<GeoStorage> j0;
    public Provider<Boolean> k;
    public Provider<DefaultLocationInteractor> k0;
    public Provider<Boolean> l;
    public Provider<DefaultLocationProvider> l0;
    public Provider<String> m;
    public Provider<FusedLocationInteractorImpl> m0;
    public Provider<Resources> n;
    public Provider<FusedLocationInteractor> n0;
    public Provider<DeliveryStartOrderingResourceProviderImpl> o;
    public Provider<GoogleServicesLocationProviderImpl> o0;
    public Provider<DeliveryStartOrderingResourceProvider> p;
    public Provider<GoogleServicesLocationProvider> p0;
    public Provider<Analytics> q;
    public Provider<FindLocationPresenterImpl> q0;
    public Provider<AccountStateProvider> r;
    public Provider<FindLocationPresenter> r0;
    public Provider<ScreenTrackerFactory> s;
    public Provider<TimeSource> s0;
    public Provider<String> t = DoubleCheck.provider(DeliveryRdsStartOrderingTrackerModule_ProvidesScreenContentTypeFactory.create());
    public Provider<LocationAnalyticsInteractorImpl> t0;
    public Provider<ScreenDiInjectTracker> u = DoubleCheck.provider(DeliveryRdsStartOrderingTrackerModule_ProvidesScreenDiInjectTracker$delivery_releaseFactory.create(this.s, TimerFactory_Factory.create(), this.t));
    public Provider<LocationAnalyticsInteractor> u0;
    public Provider<ScreenInitTracker> v = DoubleCheck.provider(DeliveryRdsStartOrderingTrackerModule_ProvidesScreenInitTrackerFactory.create(this.s, TimerFactory_Factory.create(), this.t));
    public Provider<ScreenFlowTrackerProvider> w;
    public Provider<BaseScreenPerformanceTrackerImpl> x;
    public Provider<BaseScreenPerformanceTracker> y;
    public Provider<ParametrizedEvent> z;

    public static final class b implements DeliveryRdsStartOrderingComponent.Factory {
        public b(a aVar) {
        }

        @Override // com.avito.android.delivery.di.component.DeliveryRdsStartOrderingComponent.Factory
        public DeliveryRdsStartOrderingComponent create(Activity activity, Resources resources, Fragment fragment, Context context, String str, String str2, String str3, boolean z, boolean z2, String str4, ParametrizedEvent parametrizedEvent, DeliveryRdsCommonDependencies deliveryRdsCommonDependencies) {
            Preconditions.checkNotNull(activity);
            Preconditions.checkNotNull(resources);
            Preconditions.checkNotNull(fragment);
            Preconditions.checkNotNull(context);
            Preconditions.checkNotNull(Boolean.valueOf(z));
            Preconditions.checkNotNull(Boolean.valueOf(z2));
            Preconditions.checkNotNull(deliveryRdsCommonDependencies);
            return new DaggerDeliveryRdsStartOrderingComponent(deliveryRdsCommonDependencies, activity, resources, fragment, context, str, str2, str3, Boolean.valueOf(z), Boolean.valueOf(z2), str4, parametrizedEvent, null);
        }
    }

    public static class c implements Provider<AccountStateProvider> {
        public final DeliveryRdsCommonDependencies a;

        public c(DeliveryRdsCommonDependencies deliveryRdsCommonDependencies) {
            this.a = deliveryRdsCommonDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public AccountStateProvider get() {
            return (AccountStateProvider) Preconditions.checkNotNullFromComponent(this.a.accountStateProvider());
        }
    }

    public static class d implements Provider<Analytics> {
        public final DeliveryRdsCommonDependencies a;

        public d(DeliveryRdsCommonDependencies deliveryRdsCommonDependencies) {
            this.a = deliveryRdsCommonDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Analytics get() {
            return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
        }
    }

    public static class e implements Provider<DeliveryApi> {
        public final DeliveryRdsCommonDependencies a;

        public e(DeliveryRdsCommonDependencies deliveryRdsCommonDependencies) {
            this.a = deliveryRdsCommonDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public DeliveryApi get() {
            return (DeliveryApi) Preconditions.checkNotNullFromComponent(this.a.deliveryApi());
        }
    }

    public static class f implements Provider<Features> {
        public final DeliveryRdsCommonDependencies a;

        public f(DeliveryRdsCommonDependencies deliveryRdsCommonDependencies) {
            this.a = deliveryRdsCommonDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Features get() {
            return (Features) Preconditions.checkNotNullFromComponent(this.a.features());
        }
    }

    public static class g implements Provider<GeoStorage> {
        public final DeliveryRdsCommonDependencies a;

        public g(DeliveryRdsCommonDependencies deliveryRdsCommonDependencies) {
            this.a = deliveryRdsCommonDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public GeoStorage get() {
            return (GeoStorage) Preconditions.checkNotNullFromComponent(this.a.geoStorage());
        }
    }

    public static class h implements Provider<SchedulersFactory3> {
        public final DeliveryRdsCommonDependencies a;

        public h(DeliveryRdsCommonDependencies deliveryRdsCommonDependencies) {
            this.a = deliveryRdsCommonDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory3 get() {
            return (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3());
        }
    }

    public static class i implements Provider<ScreenTrackerFactory> {
        public final DeliveryRdsCommonDependencies a;

        public i(DeliveryRdsCommonDependencies deliveryRdsCommonDependencies) {
            this.a = deliveryRdsCommonDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ScreenTrackerFactory get() {
            return (ScreenTrackerFactory) Preconditions.checkNotNullFromComponent(this.a.screenTrackerFactory());
        }
    }

    public static class j implements Provider<TimeSource> {
        public final DeliveryRdsCommonDependencies a;

        public j(DeliveryRdsCommonDependencies deliveryRdsCommonDependencies) {
            this.a = deliveryRdsCommonDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TimeSource get() {
            return (TimeSource) Preconditions.checkNotNullFromComponent(this.a.timeSource());
        }
    }

    public static class k implements Provider<TypedErrorThrowableConverter> {
        public final DeliveryRdsCommonDependencies a;

        public k(DeliveryRdsCommonDependencies deliveryRdsCommonDependencies) {
            this.a = deliveryRdsCommonDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TypedErrorThrowableConverter get() {
            return (TypedErrorThrowableConverter) Preconditions.checkNotNullFromComponent(this.a.typedErrorThrowableConverter());
        }
    }

    public DaggerDeliveryRdsStartOrderingComponent(DeliveryRdsCommonDependencies deliveryRdsCommonDependencies, Activity activity, Resources resources, Fragment fragment, Context context, String str, String str2, String str3, Boolean bool, Boolean bool2, String str4, ParametrizedEvent parametrizedEvent, a aVar) {
        this.a = deliveryRdsCommonDependencies;
        this.b = InstanceFactory.create(fragment);
        e eVar = new e(deliveryRdsCommonDependencies);
        this.c = eVar;
        k kVar = new k(deliveryRdsCommonDependencies);
        this.d = kVar;
        h hVar = new h(deliveryRdsCommonDependencies);
        this.e = hVar;
        DeliveryRdsStartOrderingInteractorImpl_Factory create = DeliveryRdsStartOrderingInteractorImpl_Factory.create(eVar, kVar, hVar);
        this.f = create;
        this.g = DoubleCheck.provider(create);
        this.h = InstanceFactory.createNullable(str);
        this.i = InstanceFactory.createNullable(str2);
        this.j = InstanceFactory.createNullable(str3);
        this.k = InstanceFactory.create(bool);
        this.l = InstanceFactory.create(bool2);
        this.m = InstanceFactory.createNullable(str4);
        Factory create2 = InstanceFactory.create(resources);
        this.n = create2;
        DeliveryStartOrderingResourceProviderImpl_Factory create3 = DeliveryStartOrderingResourceProviderImpl_Factory.create(create2);
        this.o = create3;
        this.p = DoubleCheck.provider(create3);
        this.q = new d(deliveryRdsCommonDependencies);
        this.r = new c(deliveryRdsCommonDependencies);
        this.s = new i(deliveryRdsCommonDependencies);
        Provider<ScreenFlowTrackerProvider> provider = DoubleCheck.provider(DeliveryRdsStartOrderingTrackerModule_ProvidesScreenFlowTrackerProviderFactory.create(this.s, TimerFactory_Factory.create()));
        this.w = provider;
        BaseScreenPerformanceTrackerImpl_Factory create4 = BaseScreenPerformanceTrackerImpl_Factory.create(this.u, this.v, provider, this.t);
        this.x = create4;
        this.y = DoubleCheck.provider(create4);
        Factory createNullable = InstanceFactory.createNullable(parametrizedEvent);
        this.z = createNullable;
        DeliveryRdsStartOrderingViewModelFactory_Factory create5 = DeliveryRdsStartOrderingViewModelFactory_Factory.create(this.g, this.e, this.h, this.i, this.j, this.k, this.l, this.m, this.p, this.q, this.r, this.y, createNullable);
        this.A = create5;
        this.B = DoubleCheck.provider(DeliveryRdsStartOrderingModule_ProvideDeliveryRdsStartOrderingViewModel$delivery_releaseFactory.create(this.b, create5));
        this.C = InstanceFactory.create(context);
        Provider<ClusterRadiusCalculator> provider2 = DoubleCheck.provider(LowRarityClusterRadiusCalculator_Factory.create());
        this.D = provider2;
        ClusterMarkerManagerImpl_Factory create6 = ClusterMarkerManagerImpl_Factory.create(this.C, provider2);
        this.E = create6;
        this.F = DoubleCheck.provider(create6);
        DeliveryLocationInteractorImpl_Factory create7 = DeliveryLocationInteractorImpl_Factory.create(this.c, this.d, this.e);
        this.G = create7;
        this.H = DoubleCheck.provider(create7);
        DeliveryMapResourceProviderImpl_Factory create8 = DeliveryMapResourceProviderImpl_Factory.create(this.n);
        this.I = create8;
        this.J = DoubleCheck.provider(create8);
        MarkerLabelManagerImpl_Factory create9 = MarkerLabelManagerImpl_Factory.create(this.C);
        this.K = create9;
        Provider<DeliveryMapViewPresenterFactory> provider3 = DoubleCheck.provider(DeliveryMapViewPresenterFactory_Factory.create(this.H, this.e, this.J, create9));
        this.L = provider3;
        this.M = DoubleCheck.provider(DeliveryRdsMapModule_ProvideDeliveryMapViewModel$delivery_releaseFactory.create(this.b, provider3));
        this.N = DoubleCheck.provider(ServiceItemPresenterImpl_Factory.create());
        this.O = DrawableFactoryImpl_Factory.create(this.C);
        Provider<AttributedTextFormatter> provider4 = SingleCheck.provider(AttributedTextFormatterModule_ProvideAttributedTextFormatterFactory.create());
        this.P = provider4;
        this.Q = DoubleCheck.provider(ServiceItemBlueprint_Factory.create(this.N, this.O, provider4));
        DeliveryRdsPointInfoInteractorImpl_Factory create10 = DeliveryRdsPointInfoInteractorImpl_Factory.create(this.c, this.d, this.e);
        this.R = create10;
        this.S = DoubleCheck.provider(create10);
        DeliveryRdsPointInfoResourceProviderImpl_Factory create11 = DeliveryRdsPointInfoResourceProviderImpl_Factory.create(this.n);
        this.T = create11;
        DeliveryRdsPointInfoViewModelFactory_Factory create12 = DeliveryRdsPointInfoViewModelFactory_Factory.create(this.S, this.e, this.h, this.i, this.l, this.m, create11, this.q);
        this.U = create12;
        Provider<DeliveryRdsPointInfoViewModel> provider5 = DoubleCheck.provider(DeliveryRdsPointInfoModule_ProvideDeliveryRdsPointInfoViewModel$delivery_releaseFactory.create(this.b, create12));
        this.V = provider5;
        Provider<MultiServiceItemPresenter> provider6 = DoubleCheck.provider(DeliveryRdsPointInfoModule_ProvideMultiServiceItemPresenter$delivery_releaseFactory.create(provider5));
        this.W = provider6;
        this.X = DoubleCheck.provider(MultiServiceItemBlueprint_Factory.create(provider6, this.O, this.P));
        Provider<TitleItemPresenter> provider7 = DoubleCheck.provider(TitleItemPresenterImpl_Factory.create());
        this.Y = provider7;
        Provider<TitleItemBlueprint> provider8 = DoubleCheck.provider(TitleItemBlueprint_Factory.create(provider7, this.P));
        this.Z = provider8;
        Provider<ItemBinder> provider9 = DoubleCheck.provider(DeliveryRdsPointInfoModule_ProvideItemBinder$delivery_releaseFactory.create(this.Q, this.X, provider8));
        this.a0 = provider9;
        this.b0 = DoubleCheck.provider(DeliveryRdsPointInfoModule_ProvideAdapterPresenter$delivery_releaseFactory.create(provider9));
        LocationPermissionProviderImpl_Factory create13 = LocationPermissionProviderImpl_Factory.create(this.b);
        this.c0 = create13;
        Provider<LocationPermissionProvider> provider10 = DoubleCheck.provider(create13);
        this.d0 = provider10;
        LocationPermissionDialogPresenterImpl_Factory create14 = LocationPermissionDialogPresenterImpl_Factory.create(provider10);
        this.e0 = create14;
        this.f0 = DoubleCheck.provider(create14);
        f fVar = new f(deliveryRdsCommonDependencies);
        this.g0 = fVar;
        this.h0 = DoubleCheck.provider(DeliveryRdsStartOrderingModule_ProvideAvitoMapAttachHelper$delivery_releaseFactory.create(fVar));
        this.i0 = DoubleCheck.provider(DeliveryRdsMapModule_ProvideIconFactory$delivery_releaseFactory.create(this.b, DeliveryMapMarkerResourceProvider_Factory.create()));
        g gVar = new g(deliveryRdsCommonDependencies);
        this.j0 = gVar;
        Provider<DefaultLocationInteractor> provider11 = DoubleCheck.provider(FindLocationModule_ProvideDefaultLocationInteractorFactory.create(gVar));
        this.k0 = provider11;
        this.l0 = DoubleCheck.provider(FindLocationModule_ProvideDefaultLocationProviderFactory.create(provider11));
        FusedLocationInteractorImpl_Factory create15 = FusedLocationInteractorImpl_Factory.create(this.j0);
        this.m0 = create15;
        Provider<FusedLocationInteractor> provider12 = DoubleCheck.provider(create15);
        this.n0 = provider12;
        GoogleServicesLocationProviderImpl_Factory create16 = GoogleServicesLocationProviderImpl_Factory.create(provider12);
        this.o0 = create16;
        Provider<GoogleServicesLocationProvider> provider13 = DoubleCheck.provider(create16);
        this.p0 = provider13;
        FindLocationPresenterImpl_Factory create17 = FindLocationPresenterImpl_Factory.create(this.l0, provider13);
        this.q0 = create17;
        this.r0 = DoubleCheck.provider(create17);
        j jVar = new j(deliveryRdsCommonDependencies);
        this.s0 = jVar;
        LocationAnalyticsInteractorImpl_Factory create18 = LocationAnalyticsInteractorImpl_Factory.create(this.q, jVar);
        this.t0 = create18;
        this.u0 = DoubleCheck.provider(create18);
    }

    public static DeliveryRdsStartOrderingComponent.Factory factory() {
        return new b(null);
    }

    @Override // com.avito.android.delivery.di.component.DeliveryRdsStartOrderingComponent
    public void inject(DeliveryRdsStartOrderingFragment deliveryRdsStartOrderingFragment) {
        DeliveryRdsStartOrderingFragment_MembersInjector.injectStartOrderingViewModel(deliveryRdsStartOrderingFragment, this.B.get());
        DeliveryRdsStartOrderingFragment_MembersInjector.injectAnalytics(deliveryRdsStartOrderingFragment, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
        DeliveryRdsStartOrderingFragment_MembersInjector.injectClusterMarkerManager(deliveryRdsStartOrderingFragment, this.F.get());
        DeliveryRdsStartOrderingFragment_MembersInjector.injectMapViewModel(deliveryRdsStartOrderingFragment, this.M.get());
        DeliveryRdsStartOrderingFragment_MembersInjector.injectAdapterPresenter(deliveryRdsStartOrderingFragment, this.b0.get());
        DeliveryRdsStartOrderingFragment_MembersInjector.injectItemBinder(deliveryRdsStartOrderingFragment, this.a0.get());
        DeliveryRdsStartOrderingFragment_MembersInjector.injectPointInfoViewModel(deliveryRdsStartOrderingFragment, this.V.get());
        DeliveryRdsStartOrderingFragment_MembersInjector.injectAttributedTextFormatter(deliveryRdsStartOrderingFragment, this.P.get());
        DeliveryRdsStartOrderingFragment_MembersInjector.injectIntentFactory(deliveryRdsStartOrderingFragment, (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.a.activityIntentFactory()));
        DeliveryRdsStartOrderingFragment_MembersInjector.injectSchedulers(deliveryRdsStartOrderingFragment, (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3()));
        DeliveryRdsStartOrderingFragment_MembersInjector.injectLocationPermissionPresenter(deliveryRdsStartOrderingFragment, this.f0.get());
        DeliveryRdsStartOrderingFragment_MembersInjector.injectAvitoMapAttachHelper(deliveryRdsStartOrderingFragment, this.h0.get());
        DeliveryRdsStartOrderingFragment_MembersInjector.injectAccountState(deliveryRdsStartOrderingFragment, (AccountStateProvider) Preconditions.checkNotNullFromComponent(this.a.accountStateProvider()));
        DeliveryRdsStartOrderingFragment_MembersInjector.injectIconFactory(deliveryRdsStartOrderingFragment, this.i0.get());
        DeliveryRdsStartOrderingFragment_MembersInjector.injectLocationPermissionDialogPresenter(deliveryRdsStartOrderingFragment, this.f0.get());
        DeliveryRdsStartOrderingFragment_MembersInjector.injectFindLocationPresenter(deliveryRdsStartOrderingFragment, this.r0.get());
        DeliveryRdsStartOrderingFragment_MembersInjector.injectLocationAnalyticsInteractor(deliveryRdsStartOrderingFragment, this.u0.get());
        DeliveryRdsStartOrderingFragment_MembersInjector.injectImplicitIntentFactory(deliveryRdsStartOrderingFragment, (ImplicitIntentFactory) Preconditions.checkNotNullFromComponent(this.a.implicitIntentFactory()));
        DeliveryRdsStartOrderingFragment_MembersInjector.injectTracker(deliveryRdsStartOrderingFragment, this.y.get());
    }
}
