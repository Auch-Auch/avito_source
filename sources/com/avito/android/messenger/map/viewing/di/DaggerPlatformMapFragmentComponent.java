package com.avito.android.messenger.map.viewing.di;

import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModel;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.geo.GeoStorage;
import com.avito.android.location.analytics.LocationAnalyticsInteractorImpl;
import com.avito.android.location.find.FindLocationPresenterImpl;
import com.avito.android.location.find.FusedLocationInteractorImpl;
import com.avito.android.location.find.GoogleServicesLocationProviderImpl;
import com.avito.android.messenger.channels.mvi.di.ViewModelFactory;
import com.avito.android.messenger.channels.mvi.di.ViewModelFactory_Factory;
import com.avito.android.messenger.map.viewing.PlatformMapFragment;
import com.avito.android.messenger.map.viewing.PlatformMapFragment_MembersInjector;
import com.avito.android.messenger.map.viewing.PlatformMapInteractorImpl;
import com.avito.android.messenger.map.viewing.PlatformMapInteractorImpl_Factory;
import com.avito.android.messenger.map.viewing.PlatformMapPresenterImpl;
import com.avito.android.messenger.map.viewing.di.PlatformMapFragmentComponent;
import com.avito.android.messenger.map.viewing.view.PlatformMapViewImpl;
import com.avito.android.permissions.LocationPermissionProviderImpl;
import com.avito.android.remote.model.messenger.geo.GeoMarker;
import com.avito.android.remote.model.messenger.geo.MarkersRequest;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.ErrorFormatterImpl;
import com.avito.android.util.ErrorFormatterImpl_Factory;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.android.util.text.AttributedTextFormatterModule_ProvideAttributedTextFormatterFactory;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.MapProviderFactory;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import java.util.Map;
import javax.inject.Provider;
import ru.avito.messenger.MessengerClient;
import ru.avito.messenger.api.AvitoMessengerApi;
public final class DaggerPlatformMapFragmentComponent implements PlatformMapFragmentComponent {
    public final View a;
    public final Boolean b;
    public final PlatformMapFragmentDependencies c;
    public final FragmentManager d;
    public final Fragment e;
    public Provider<SchedulersFactory> f;
    public Provider<GeoMarker[]> g;
    public Provider<MessengerClient<AvitoMessengerApi>> h;
    public Provider<MarkersRequest> i;
    public Provider<PlatformMapInteractorImpl> j;
    public Provider<AttributedTextFormatter> k = SingleCheck.provider(AttributedTextFormatterModule_ProvideAttributedTextFormatterFactory.create());
    public Provider<Resources> l;
    public Provider<ErrorFormatterImpl> m;
    public Provider<SchedulersFactory3> n;
    public Provider<ViewModel> o;
    public Provider<Map<Class<?>, Provider<ViewModel>>> p;
    public Provider<ViewModelFactory> q;

    public static final class b implements PlatformMapFragmentComponent.Builder {
        public PlatformMapFragmentDependencies a;
        public Resources b;
        public Fragment c;
        public Activity d;
        public FragmentManager e;
        public View f;
        public GeoMarker[] g;
        public MarkersRequest h;
        public Boolean i;

        public b(a aVar) {
        }

        @Override // com.avito.android.messenger.map.viewing.di.PlatformMapFragmentComponent.Builder
        public PlatformMapFragmentComponent build() {
            Preconditions.checkBuilderRequirement(this.a, PlatformMapFragmentDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, Resources.class);
            Preconditions.checkBuilderRequirement(this.c, Fragment.class);
            Preconditions.checkBuilderRequirement(this.d, Activity.class);
            Preconditions.checkBuilderRequirement(this.e, FragmentManager.class);
            Preconditions.checkBuilderRequirement(this.f, View.class);
            Preconditions.checkBuilderRequirement(this.g, GeoMarker[].class);
            Preconditions.checkBuilderRequirement(this.i, Boolean.class);
            return new DaggerPlatformMapFragmentComponent(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, null);
        }

        @Override // com.avito.android.messenger.map.viewing.di.PlatformMapFragmentComponent.Builder
        public PlatformMapFragmentComponent.Builder platformMapFragmentDependencies(PlatformMapFragmentDependencies platformMapFragmentDependencies) {
            this.a = (PlatformMapFragmentDependencies) Preconditions.checkNotNull(platformMapFragmentDependencies);
            return this;
        }

        @Override // com.avito.android.messenger.map.viewing.di.PlatformMapFragmentComponent.Builder
        public PlatformMapFragmentComponent.Builder withActivity(Activity activity) {
            this.d = (Activity) Preconditions.checkNotNull(activity);
            return this;
        }

        @Override // com.avito.android.messenger.map.viewing.di.PlatformMapFragmentComponent.Builder
        public PlatformMapFragmentComponent.Builder withFragment(Fragment fragment) {
            this.c = (Fragment) Preconditions.checkNotNull(fragment);
            return this;
        }

        @Override // com.avito.android.messenger.map.viewing.di.PlatformMapFragmentComponent.Builder
        public PlatformMapFragmentComponent.Builder withFragmentManager(FragmentManager fragmentManager) {
            this.e = (FragmentManager) Preconditions.checkNotNull(fragmentManager);
            return this;
        }

        @Override // com.avito.android.messenger.map.viewing.di.PlatformMapFragmentComponent.Builder
        public PlatformMapFragmentComponent.Builder withFragmentRootView(View view) {
            this.f = (View) Preconditions.checkNotNull(view);
            return this;
        }

        @Override // com.avito.android.messenger.map.viewing.di.PlatformMapFragmentComponent.Builder
        public PlatformMapFragmentComponent.Builder withInitialGeoMarkers(GeoMarker[] geoMarkerArr) {
            this.g = (GeoMarker[]) Preconditions.checkNotNull(geoMarkerArr);
            return this;
        }

        @Override // com.avito.android.messenger.map.viewing.di.PlatformMapFragmentComponent.Builder
        public PlatformMapFragmentComponent.Builder withLockBottomSheet(boolean z) {
            this.i = (Boolean) Preconditions.checkNotNull(Boolean.valueOf(z));
            return this;
        }

        @Override // com.avito.android.messenger.map.viewing.di.PlatformMapFragmentComponent.Builder
        public PlatformMapFragmentComponent.Builder withMarkersRequest(MarkersRequest markersRequest) {
            this.h = markersRequest;
            return this;
        }

        @Override // com.avito.android.messenger.map.viewing.di.PlatformMapFragmentComponent.Builder
        public PlatformMapFragmentComponent.Builder withResources(Resources resources) {
            this.b = (Resources) Preconditions.checkNotNull(resources);
            return this;
        }
    }

    public static class c implements Provider<MessengerClient<AvitoMessengerApi>> {
        public final PlatformMapFragmentDependencies a;

        public c(PlatformMapFragmentDependencies platformMapFragmentDependencies) {
            this.a = platformMapFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public MessengerClient<AvitoMessengerApi> get() {
            return (MessengerClient) Preconditions.checkNotNullFromComponent(this.a.messengerClient());
        }
    }

    public static class d implements Provider<SchedulersFactory3> {
        public final PlatformMapFragmentDependencies a;

        public d(PlatformMapFragmentDependencies platformMapFragmentDependencies) {
            this.a = platformMapFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory3 get() {
            return (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3());
        }
    }

    public static class e implements Provider<SchedulersFactory> {
        public final PlatformMapFragmentDependencies a;

        public e(PlatformMapFragmentDependencies platformMapFragmentDependencies) {
            this.a = platformMapFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public DaggerPlatformMapFragmentComponent(PlatformMapFragmentDependencies platformMapFragmentDependencies, Resources resources, Fragment fragment, Activity activity, FragmentManager fragmentManager, View view, GeoMarker[] geoMarkerArr, MarkersRequest markersRequest, Boolean bool, a aVar) {
        this.a = view;
        this.b = bool;
        this.c = platformMapFragmentDependencies;
        this.d = fragmentManager;
        this.e = fragment;
        this.f = new e(platformMapFragmentDependencies);
        this.g = InstanceFactory.create(geoMarkerArr);
        this.h = new c(platformMapFragmentDependencies);
        Factory createNullable = InstanceFactory.createNullable(markersRequest);
        this.i = createNullable;
        this.j = PlatformMapInteractorImpl_Factory.create(this.g, this.h, createNullable);
        Factory create = InstanceFactory.create(resources);
        this.l = create;
        ErrorFormatterImpl_Factory create2 = ErrorFormatterImpl_Factory.create(create);
        this.m = create2;
        d dVar = new d(platformMapFragmentDependencies);
        this.n = dVar;
        this.o = PlatformMapFragmentModule_ProvidePlatformMapPresenterViewModelFactory.create(this.f, this.j, this.k, create2, this.l, dVar);
        MapProviderFactory build = MapProviderFactory.builder(1).put((MapProviderFactory.Builder) PlatformMapPresenterImpl.class, (Provider) this.o).build();
        this.p = build;
        this.q = SingleCheck.provider(ViewModelFactory_Factory.create(build));
    }

    public static PlatformMapFragmentComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.messenger.map.viewing.di.PlatformMapFragmentComponent
    public void inject(PlatformMapFragment platformMapFragment) {
        PlatformMapFragment_MembersInjector.injectMapView(platformMapFragment, new PlatformMapViewImpl(this.a, this.b.booleanValue(), PlatformMapFragmentModule_ProvideMapAttachHelperFactory.provideMapAttachHelper((Features) Preconditions.checkNotNullFromComponent(this.c.features())), this.d));
        PlatformMapFragment_MembersInjector.injectViewModelFactory(platformMapFragment, this.q.get());
        PlatformMapFragment_MembersInjector.injectImplicitIntentFactory(platformMapFragment, (ImplicitIntentFactory) Preconditions.checkNotNullFromComponent(this.c.implicitIntentFactory()));
        PlatformMapFragment_MembersInjector.injectDeepLinkIntentFactory(platformMapFragment, (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.c.deepLinkIntentFactory()));
        PlatformMapFragment_MembersInjector.injectPresenter(platformMapFragment, PlatformMapFragmentModule_ProvidePlatformMapPresenterFactory.providePlatformMapPresenter(this.q.get(), this.e));
        PlatformMapFragment_MembersInjector.injectLocationPermissionDialogPresenter(platformMapFragment, PlatformMapFragmentModule_ProvideLocationPermissionDialogPresenter$messenger_releaseFactory.provideLocationPermissionDialogPresenter$messenger_release(new LocationPermissionProviderImpl(this.e)));
        PlatformMapFragment_MembersInjector.injectFindLocationPresenter(platformMapFragment, new FindLocationPresenterImpl(PlatformMapFragmentModule_ProvideDefaultLocationProviderFactory.provideDefaultLocationProvider(PlatformMapFragmentModule_ProvideDefaultLocationInteractorFactory.provideDefaultLocationInteractor((GeoStorage) Preconditions.checkNotNullFromComponent(this.c.geoStorage()))), new GoogleServicesLocationProviderImpl(new FusedLocationInteractorImpl((GeoStorage) Preconditions.checkNotNullFromComponent(this.c.geoStorage())))));
        PlatformMapFragment_MembersInjector.injectLocationAnalyticsInteractor(platformMapFragment, new LocationAnalyticsInteractorImpl((Analytics) Preconditions.checkNotNullFromComponent(this.c.analytics()), (TimeSource) Preconditions.checkNotNullFromComponent(this.c.timeSource())));
        PlatformMapFragment_MembersInjector.injectSchedulers(platformMapFragment, (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.c.schedulersFactory3()));
    }
}
