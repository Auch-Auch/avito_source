package com.avito.android.location_picker.di;

import android.app.Activity;
import android.content.res.Resources;
import androidx.fragment.app.FragmentActivity;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.publish.PublishAnalyticsDataProvider;
import com.avito.android.avito_map.AvitoMapAttachHelper;
import com.avito.android.avito_map.AvitoMapTarget;
import com.avito.android.di.DialogRouterModule_ProvideDialogRouterFactory;
import com.avito.android.geo.GeoStorage;
import com.avito.android.location.analytics.LocationAnalyticsInteractor;
import com.avito.android.location.analytics.LocationAnalyticsInteractorImpl;
import com.avito.android.location.analytics.LocationAnalyticsInteractorImpl_Factory;
import com.avito.android.location.find.DefaultLocationInteractor;
import com.avito.android.location.find.FusedLocationInteractor;
import com.avito.android.location.find.FusedLocationInteractorImpl;
import com.avito.android.location.find.FusedLocationInteractorImpl_Factory;
import com.avito.android.location_picker.LocationPickerActivity;
import com.avito.android.location_picker.LocationPickerActivity_MembersInjector;
import com.avito.android.location_picker.LocationPickerBinder;
import com.avito.android.location_picker.LocationPickerBinderImpl;
import com.avito.android.location_picker.LocationPickerBinderImpl_Factory;
import com.avito.android.location_picker.MapTransformationsProvider;
import com.avito.android.location_picker.MapTransformationsProviderImpl_Factory;
import com.avito.android.location_picker.analytics.LocationPickerAnalyticsInteractor;
import com.avito.android.location_picker.analytics.LocationPickerAnalyticsInteractorImpl;
import com.avito.android.location_picker.analytics.LocationPickerAnalyticsInteractorImpl_Factory;
import com.avito.android.location_picker.di.LocationPickerComponent;
import com.avito.android.location_picker.entities.ActivityResult;
import com.avito.android.location_picker.entities.LocationPickerState;
import com.avito.android.location_picker.job.JobAssistantInteractor;
import com.avito.android.location_picker.job.JobAssistantInteractorImpl;
import com.avito.android.location_picker.job.JobAssistantInteractorImpl_Factory;
import com.avito.android.location_picker.job.SendLocationToJobAssistant;
import com.avito.android.location_picker.providers.AddressGeoCoder;
import com.avito.android.location_picker.providers.AddressValidationProvider;
import com.avito.android.location_picker.providers.AddressValidationProviderImpl;
import com.avito.android.location_picker.providers.AddressValidationProviderImpl_Factory;
import com.avito.android.location_picker.providers.AdvertsCountProvider;
import com.avito.android.location_picker.providers.AdvertsCountProviderImpl;
import com.avito.android.location_picker.providers.AdvertsCountProviderImpl_Factory;
import com.avito.android.location_picker.providers.AvitoAddressGeoCoder;
import com.avito.android.location_picker.providers.AvitoAddressGeoCoder_Factory;
import com.avito.android.location_picker.providers.LocationPickerAnalyticsProvider;
import com.avito.android.location_picker.providers.LocationPickerAnalyticsProviderImpl;
import com.avito.android.location_picker.providers.LocationPickerAnalyticsProviderImpl_Factory;
import com.avito.android.location_picker.providers.LocationPickerResourceProvider;
import com.avito.android.location_picker.providers.LocationPickerResourceProviderImpl;
import com.avito.android.location_picker.providers.LocationPickerResourceProviderImpl_Factory;
import com.avito.android.location_picker.providers.RadiusListProvider;
import com.avito.android.location_picker.providers.RadiusListProviderImpl;
import com.avito.android.location_picker.providers.RadiusListProviderImpl_Factory;
import com.avito.android.location_picker.view.LocationPickerChooseButtonLocation;
import com.avito.android.location_picker.view.LocationPickerViewImpl;
import com.avito.android.location_picker.view.LocationPickerViewImpl_Factory;
import com.avito.android.permissions.LocationPermissionProvider;
import com.avito.android.permissions.LocationPermissionProviderWithActivityImpl;
import com.avito.android.permissions.LocationPermissionProviderWithActivityImpl_Factory;
import com.avito.android.remote.LocationApi;
import com.avito.android.remote.SearchRadiusApi;
import com.avito.android.remote.model.SearchParamsConverter;
import com.avito.android.remote.model.SearchParamsConverterImpl_Factory;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.DialogRouter;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import io.reactivex.rxjava3.core.Observable;
import java.util.Locale;
import javax.inject.Provider;
public final class DaggerLocationPickerComponent implements LocationPickerComponent {
    public Provider<PublishAnalyticsDataProvider> A;
    public Provider<LocationPickerAnalyticsProviderImpl> B;
    public Provider<LocationPickerAnalyticsProvider> C;
    public Provider<TimeSource> D;
    public Provider<LocationAnalyticsInteractorImpl> E;
    public Provider<LocationAnalyticsInteractor> F;
    public Provider<Observable<ActivityResult>> G;
    public Provider<SearchRadiusApi> H;
    public Provider<RadiusListProviderImpl> I;
    public Provider<RadiusListProvider> J;
    public Provider<AdvertsCountProviderImpl> K;
    public Provider<AdvertsCountProvider> L;
    public Provider<AddressValidationProviderImpl> M;
    public Provider<AddressValidationProvider> N;
    public Provider<SearchParamsConverter> O = DoubleCheck.provider(SearchParamsConverterImpl_Factory.create());
    public Provider<MapTransformationsProvider> P = DoubleCheck.provider(MapTransformationsProviderImpl_Factory.create());
    public Provider<LocationPickerAnalyticsInteractorImpl> Q;
    public Provider<LocationPickerAnalyticsInteractor> R;
    public Provider<JobAssistantInteractorImpl> S;
    public Provider<JobAssistantInteractor> T;
    public Provider<BuildInfo> U;
    public Provider<LocationPickerBinderImpl> V;
    public Provider<LocationPickerBinder> W;
    public Provider<DefaultLocationInteractor> X;
    public Provider<LocationPickerState> a;
    public Provider<Activity> b;
    public Provider<DialogRouter> c;
    public Provider<Boolean> d;
    public Provider<Boolean> e;
    public Provider<SendLocationToJobAssistant> f;
    public Provider<LocationPickerChooseButtonLocation> g;
    public Provider<Features> h;
    public Provider<AvitoMapAttachHelper> i;
    public Provider<AvitoMapTarget> j;
    public Provider<Resources> k;
    public Provider<Locale> l;
    public Provider<LocationPickerResourceProviderImpl> m;
    public Provider<LocationPickerResourceProvider> n;
    public Provider<LocationPickerViewImpl> o;
    public Provider<LocationApi> p;
    public Provider<AvitoAddressGeoCoder> q;
    public Provider<AddressGeoCoder> r;
    public Provider<GeoStorage> s;
    public Provider<FusedLocationInteractorImpl> t;
    public Provider<FusedLocationInteractor> u;
    public Provider<SchedulersFactory3> v;
    public Provider<FragmentActivity> w;
    public Provider<LocationPermissionProviderWithActivityImpl> x;
    public Provider<LocationPermissionProvider> y;
    public Provider<Analytics> z;

    public static final class b implements LocationPickerComponent.Builder {
        public Observable<ActivityResult> a;
        public LocationPickerState b;
        public Boolean c;
        public Boolean d;
        public AvitoMapTarget e;
        public Activity f;
        public FragmentActivity g;
        public Resources h;
        public LocationPickerChooseButtonLocation i;
        public SendLocationToJobAssistant j;
        public LocationPickerDependencies k;

        public b(a aVar) {
        }

        @Override // com.avito.android.location_picker.di.LocationPickerComponent.Builder
        public LocationPickerComponent build() {
            Preconditions.checkBuilderRequirement(this.a, Observable.class);
            Preconditions.checkBuilderRequirement(this.b, LocationPickerState.class);
            Preconditions.checkBuilderRequirement(this.c, Boolean.class);
            Preconditions.checkBuilderRequirement(this.d, Boolean.class);
            Preconditions.checkBuilderRequirement(this.f, Activity.class);
            Preconditions.checkBuilderRequirement(this.g, FragmentActivity.class);
            Preconditions.checkBuilderRequirement(this.h, Resources.class);
            Preconditions.checkBuilderRequirement(this.i, LocationPickerChooseButtonLocation.class);
            Preconditions.checkBuilderRequirement(this.j, SendLocationToJobAssistant.class);
            Preconditions.checkBuilderRequirement(this.k, LocationPickerDependencies.class);
            return new DaggerLocationPickerComponent(this.k, this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, null);
        }

        @Override // com.avito.android.location_picker.di.LocationPickerComponent.Builder
        public LocationPickerComponent.Builder dependencies(LocationPickerDependencies locationPickerDependencies) {
            this.k = (LocationPickerDependencies) Preconditions.checkNotNull(locationPickerDependencies);
            return this;
        }

        @Override // com.avito.android.location_picker.di.LocationPickerComponent.Builder
        public LocationPickerComponent.Builder withActivity(Activity activity) {
            this.f = (Activity) Preconditions.checkNotNull(activity);
            return this;
        }

        @Override // com.avito.android.location_picker.di.LocationPickerComponent.Builder
        public LocationPickerComponent.Builder withActivityResultRelay(Observable observable) {
            this.a = (Observable) Preconditions.checkNotNull(observable);
            return this;
        }

        @Override // com.avito.android.location_picker.di.LocationPickerComponent.Builder
        public LocationPickerComponent.Builder withAddressKindsValidation(boolean z) {
            this.d = (Boolean) Preconditions.checkNotNull(Boolean.valueOf(z));
            return this;
        }

        @Override // com.avito.android.location_picker.di.LocationPickerComponent.Builder
        public LocationPickerComponent.Builder withChooseButtonLocation(LocationPickerChooseButtonLocation locationPickerChooseButtonLocation) {
            this.i = (LocationPickerChooseButtonLocation) Preconditions.checkNotNull(locationPickerChooseButtonLocation);
            return this;
        }

        @Override // com.avito.android.location_picker.di.LocationPickerComponent.Builder
        public LocationPickerComponent.Builder withFragmentActivity(FragmentActivity fragmentActivity) {
            this.g = (FragmentActivity) Preconditions.checkNotNull(fragmentActivity);
            return this;
        }

        @Override // com.avito.android.location_picker.di.LocationPickerComponent.Builder
        public LocationPickerComponent.Builder withInitialState(LocationPickerState locationPickerState) {
            this.b = (LocationPickerState) Preconditions.checkNotNull(locationPickerState);
            return this;
        }

        @Override // com.avito.android.location_picker.di.LocationPickerComponent.Builder
        public LocationPickerComponent.Builder withResources(Resources resources) {
            this.h = (Resources) Preconditions.checkNotNull(resources);
            return this;
        }

        @Override // com.avito.android.location_picker.di.LocationPickerComponent.Builder
        public LocationPickerComponent.Builder withSavedMapTarget(AvitoMapTarget avitoMapTarget) {
            this.e = avitoMapTarget;
            return this;
        }

        @Override // com.avito.android.location_picker.di.LocationPickerComponent.Builder
        public LocationPickerComponent.Builder withSearchRadius(boolean z) {
            this.c = (Boolean) Preconditions.checkNotNull(Boolean.valueOf(z));
            return this;
        }

        @Override // com.avito.android.location_picker.di.LocationPickerComponent.Builder
        public LocationPickerComponent.Builder withSendLocationToJobAssistant(SendLocationToJobAssistant sendLocationToJobAssistant) {
            this.j = (SendLocationToJobAssistant) Preconditions.checkNotNull(sendLocationToJobAssistant);
            return this;
        }
    }

    public static class c implements Provider<Analytics> {
        public final LocationPickerDependencies a;

        public c(LocationPickerDependencies locationPickerDependencies) {
            this.a = locationPickerDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Analytics get() {
            return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
        }
    }

    public static class d implements Provider<BuildInfo> {
        public final LocationPickerDependencies a;

        public d(LocationPickerDependencies locationPickerDependencies) {
            this.a = locationPickerDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public BuildInfo get() {
            return (BuildInfo) Preconditions.checkNotNullFromComponent(this.a.buildInfo());
        }
    }

    public static class e implements Provider<Features> {
        public final LocationPickerDependencies a;

        public e(LocationPickerDependencies locationPickerDependencies) {
            this.a = locationPickerDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Features get() {
            return (Features) Preconditions.checkNotNullFromComponent(this.a.features());
        }
    }

    public static class f implements Provider<GeoStorage> {
        public final LocationPickerDependencies a;

        public f(LocationPickerDependencies locationPickerDependencies) {
            this.a = locationPickerDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public GeoStorage get() {
            return (GeoStorage) Preconditions.checkNotNullFromComponent(this.a.geoStorage());
        }
    }

    public static class g implements Provider<Locale> {
        public final LocationPickerDependencies a;

        public g(LocationPickerDependencies locationPickerDependencies) {
            this.a = locationPickerDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Locale get() {
            return (Locale) Preconditions.checkNotNullFromComponent(this.a.locale());
        }
    }

    public static class h implements Provider<LocationApi> {
        public final LocationPickerDependencies a;

        public h(LocationPickerDependencies locationPickerDependencies) {
            this.a = locationPickerDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public LocationApi get() {
            return (LocationApi) Preconditions.checkNotNullFromComponent(this.a.locationApi());
        }
    }

    public static class i implements Provider<PublishAnalyticsDataProvider> {
        public final LocationPickerDependencies a;

        public i(LocationPickerDependencies locationPickerDependencies) {
            this.a = locationPickerDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public PublishAnalyticsDataProvider get() {
            return (PublishAnalyticsDataProvider) Preconditions.checkNotNullFromComponent(this.a.publishAnalyticsDataProvider());
        }
    }

    public static class j implements Provider<SchedulersFactory3> {
        public final LocationPickerDependencies a;

        public j(LocationPickerDependencies locationPickerDependencies) {
            this.a = locationPickerDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory3 get() {
            return (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulers3());
        }
    }

    public static class k implements Provider<SearchRadiusApi> {
        public final LocationPickerDependencies a;

        public k(LocationPickerDependencies locationPickerDependencies) {
            this.a = locationPickerDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SearchRadiusApi get() {
            return (SearchRadiusApi) Preconditions.checkNotNullFromComponent(this.a.searchRadiusApi());
        }
    }

    public static class l implements Provider<TimeSource> {
        public final LocationPickerDependencies a;

        public l(LocationPickerDependencies locationPickerDependencies) {
            this.a = locationPickerDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TimeSource get() {
            return (TimeSource) Preconditions.checkNotNullFromComponent(this.a.timeSource());
        }
    }

    public DaggerLocationPickerComponent(LocationPickerDependencies locationPickerDependencies, Observable observable, LocationPickerState locationPickerState, Boolean bool, Boolean bool2, AvitoMapTarget avitoMapTarget, Activity activity, FragmentActivity fragmentActivity, Resources resources, LocationPickerChooseButtonLocation locationPickerChooseButtonLocation, SendLocationToJobAssistant sendLocationToJobAssistant, a aVar) {
        this.a = InstanceFactory.create(locationPickerState);
        Factory create = InstanceFactory.create(activity);
        this.b = create;
        this.c = SingleCheck.provider(DialogRouterModule_ProvideDialogRouterFactory.create(create));
        this.d = InstanceFactory.create(bool);
        this.e = InstanceFactory.create(bool2);
        this.f = InstanceFactory.create(sendLocationToJobAssistant);
        this.g = InstanceFactory.create(locationPickerChooseButtonLocation);
        e eVar = new e(locationPickerDependencies);
        this.h = eVar;
        this.i = DoubleCheck.provider(LocationPickerModule_ProvideMapAttachHelperFactory.create(eVar));
        this.j = InstanceFactory.createNullable(avitoMapTarget);
        Factory create2 = InstanceFactory.create(resources);
        this.k = create2;
        g gVar = new g(locationPickerDependencies);
        this.l = gVar;
        LocationPickerResourceProviderImpl_Factory create3 = LocationPickerResourceProviderImpl_Factory.create(create2, gVar);
        this.m = create3;
        Provider<LocationPickerResourceProvider> provider = DoubleCheck.provider(create3);
        this.n = provider;
        this.o = DoubleCheck.provider(LocationPickerViewImpl_Factory.create(this.b, this.c, this.d, this.e, this.f, this.g, this.i, this.j, provider));
        h hVar = new h(locationPickerDependencies);
        this.p = hVar;
        AvitoAddressGeoCoder_Factory create4 = AvitoAddressGeoCoder_Factory.create(hVar);
        this.q = create4;
        this.r = DoubleCheck.provider(create4);
        f fVar = new f(locationPickerDependencies);
        this.s = fVar;
        FusedLocationInteractorImpl_Factory create5 = FusedLocationInteractorImpl_Factory.create(fVar);
        this.t = create5;
        this.u = DoubleCheck.provider(create5);
        this.v = new j(locationPickerDependencies);
        Factory create6 = InstanceFactory.create(fragmentActivity);
        this.w = create6;
        LocationPermissionProviderWithActivityImpl_Factory create7 = LocationPermissionProviderWithActivityImpl_Factory.create(create6);
        this.x = create7;
        this.y = DoubleCheck.provider(create7);
        c cVar = new c(locationPickerDependencies);
        this.z = cVar;
        i iVar = new i(locationPickerDependencies);
        this.A = iVar;
        LocationPickerAnalyticsProviderImpl_Factory create8 = LocationPickerAnalyticsProviderImpl_Factory.create(cVar, iVar);
        this.B = create8;
        this.C = DoubleCheck.provider(create8);
        l lVar = new l(locationPickerDependencies);
        this.D = lVar;
        LocationAnalyticsInteractorImpl_Factory create9 = LocationAnalyticsInteractorImpl_Factory.create(this.z, lVar);
        this.E = create9;
        this.F = DoubleCheck.provider(create9);
        this.G = InstanceFactory.create(observable);
        k kVar = new k(locationPickerDependencies);
        this.H = kVar;
        RadiusListProviderImpl_Factory create10 = RadiusListProviderImpl_Factory.create(kVar);
        this.I = create10;
        this.J = DoubleCheck.provider(create10);
        AdvertsCountProviderImpl_Factory create11 = AdvertsCountProviderImpl_Factory.create(this.H);
        this.K = create11;
        this.L = DoubleCheck.provider(create11);
        AddressValidationProviderImpl_Factory create12 = AddressValidationProviderImpl_Factory.create(this.p);
        this.M = create12;
        this.N = DoubleCheck.provider(create12);
        LocationPickerAnalyticsInteractorImpl_Factory create13 = LocationPickerAnalyticsInteractorImpl_Factory.create(this.z);
        this.Q = create13;
        this.R = DoubleCheck.provider(create13);
        JobAssistantInteractorImpl_Factory create14 = JobAssistantInteractorImpl_Factory.create(this.p);
        this.S = create14;
        Provider<JobAssistantInteractor> provider2 = DoubleCheck.provider(create14);
        this.T = provider2;
        d dVar = new d(locationPickerDependencies);
        this.U = dVar;
        Provider<LocationPickerState> provider3 = this.a;
        Provider<LocationPickerViewImpl> provider4 = this.o;
        LocationPickerBinderImpl_Factory create15 = LocationPickerBinderImpl_Factory.create(provider3, provider4, provider4, this.r, this.u, this.v, this.y, this.C, this.F, this.G, this.J, this.L, this.N, this.O, this.P, this.R, provider2, this.f, dVar, this.b);
        this.V = create15;
        this.W = DoubleCheck.provider(create15);
        this.X = DoubleCheck.provider(LocationPickerModule_ProvideDefaultLocationInteractorFactory.create(this.s));
    }

    public static LocationPickerComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.location_picker.di.LocationPickerComponent
    public void inject(LocationPickerActivity locationPickerActivity) {
        LocationPickerActivity_MembersInjector.injectBinder(locationPickerActivity, this.W.get());
        LocationPickerActivity_MembersInjector.injectAnalyticsInteractor(locationPickerActivity, this.R.get());
        LocationPickerActivity_MembersInjector.injectDefaultLocationInteractor(locationPickerActivity, this.X.get());
    }
}
