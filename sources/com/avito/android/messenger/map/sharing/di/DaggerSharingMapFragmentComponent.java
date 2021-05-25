package com.avito.android.messenger.map.sharing.di;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.geo.GeoStorage;
import com.avito.android.location.analytics.LocationAnalyticsInteractorImpl;
import com.avito.android.location.find.FindLocationPresenterImpl;
import com.avito.android.location.find.FusedLocationInteractorImpl;
import com.avito.android.location.find.GoogleServicesLocationProviderImpl;
import com.avito.android.messenger.channels.mvi.di.ViewModelFactory;
import com.avito.android.messenger.channels.mvi.di.ViewModelFactory_Factory;
import com.avito.android.messenger.map.sharing.SharingMapFragment;
import com.avito.android.messenger.map.sharing.SharingMapFragment_MembersInjector;
import com.avito.android.messenger.map.sharing.SharingMapInteractorImpl;
import com.avito.android.messenger.map.sharing.SharingMapInteractorImpl_Factory;
import com.avito.android.messenger.map.sharing.SharingMapPresenterImpl;
import com.avito.android.messenger.map.sharing.SharingMapPresenterImpl_Factory;
import com.avito.android.messenger.map.sharing.SharingMapView;
import com.avito.android.messenger.map.sharing.di.SharingMapFragmentComponent;
import com.avito.android.permissions.LocationPermissionProviderImpl;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.MapProviderFactory;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import java.util.Map;
import javax.inject.Provider;
import ru.avito.messenger.MessengerClient;
import ru.avito.messenger.api.AvitoMessengerApi;
public final class DaggerSharingMapFragmentComponent implements SharingMapFragmentComponent {
    public final SharingMapFragment a;
    public final SharingMapFragmentDependencies b;
    public final Fragment c;
    public Provider<SharingMapView.State> d;
    public Provider<SchedulersFactory> e;
    public Provider<SharingMapView.State> f;
    public Provider<MessengerClient<AvitoMessengerApi>> g;
    public Provider<SharingMapInteractorImpl> h;
    public Provider<String> i;
    public Provider<String> j;
    public Provider<String> k;
    public Provider<SharingMapPresenterImpl> l;
    public Provider<Map<Class<?>, Provider<ViewModel>>> m;
    public Provider<ViewModelFactory> n;

    public static final class b implements SharingMapFragmentComponent.Builder {
        public SharingMapFragment a;
        public Activity b;
        public Fragment c;
        public SharingMapView.State d;
        public SharingMapView.State e;
        public String f;
        public String g;
        public String h;
        public SharingMapFragmentDependencies i;

        public b(a aVar) {
        }

        @Override // com.avito.android.messenger.map.sharing.di.SharingMapFragmentComponent.Builder
        public SharingMapFragmentComponent.Builder activity(Activity activity) {
            this.b = (Activity) Preconditions.checkNotNull(activity);
            return this;
        }

        @Override // com.avito.android.messenger.map.sharing.di.SharingMapFragmentComponent.Builder
        public SharingMapFragmentComponent.Builder addressNotFoundErrorMessage(String str) {
            this.g = (String) Preconditions.checkNotNull(str);
            return this;
        }

        @Override // com.avito.android.messenger.map.sharing.di.SharingMapFragmentComponent.Builder
        public SharingMapFragmentComponent.Builder addressNotFoundTitle(String str) {
            this.f = (String) Preconditions.checkNotNull(str);
            return this;
        }

        @Override // com.avito.android.messenger.map.sharing.di.SharingMapFragmentComponent.Builder
        public SharingMapFragmentComponent build() {
            Preconditions.checkBuilderRequirement(this.a, SharingMapFragment.class);
            Preconditions.checkBuilderRequirement(this.b, Activity.class);
            Preconditions.checkBuilderRequirement(this.c, Fragment.class);
            Preconditions.checkBuilderRequirement(this.d, SharingMapView.State.class);
            Preconditions.checkBuilderRequirement(this.e, SharingMapView.State.class);
            Preconditions.checkBuilderRequirement(this.f, String.class);
            Preconditions.checkBuilderRequirement(this.g, String.class);
            Preconditions.checkBuilderRequirement(this.h, String.class);
            Preconditions.checkBuilderRequirement(this.i, SharingMapFragmentDependencies.class);
            return new DaggerSharingMapFragmentComponent(this.i, this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, null);
        }

        @Override // com.avito.android.messenger.map.sharing.di.SharingMapFragmentComponent.Builder
        public SharingMapFragmentComponent.Builder fragment(SharingMapFragment sharingMapFragment) {
            this.a = (SharingMapFragment) Preconditions.checkNotNull(sharingMapFragment);
            return this;
        }

        @Override // com.avito.android.messenger.map.sharing.di.SharingMapFragmentComponent.Builder
        public SharingMapFragmentComponent.Builder retryLabel(String str) {
            this.h = (String) Preconditions.checkNotNull(str);
            return this;
        }

        @Override // com.avito.android.messenger.map.sharing.di.SharingMapFragmentComponent.Builder
        public SharingMapFragmentComponent.Builder sharingMapDefaultViewState(SharingMapView.State state) {
            this.d = (SharingMapView.State) Preconditions.checkNotNull(state);
            return this;
        }

        @Override // com.avito.android.messenger.map.sharing.di.SharingMapFragmentComponent.Builder
        public SharingMapFragmentComponent.Builder sharingMapFragmentDependencies(SharingMapFragmentDependencies sharingMapFragmentDependencies) {
            this.i = (SharingMapFragmentDependencies) Preconditions.checkNotNull(sharingMapFragmentDependencies);
            return this;
        }

        @Override // com.avito.android.messenger.map.sharing.di.SharingMapFragmentComponent.Builder
        @Deprecated
        public SharingMapFragmentComponent.Builder sharingMapFragmentModule(SharingMapFragmentModule sharingMapFragmentModule) {
            Preconditions.checkNotNull(sharingMapFragmentModule);
            return this;
        }

        @Override // com.avito.android.messenger.map.sharing.di.SharingMapFragmentComponent.Builder
        public SharingMapFragmentComponent.Builder sharingMapInitialViewState(SharingMapView.State state) {
            this.e = (SharingMapView.State) Preconditions.checkNotNull(state);
            return this;
        }

        @Override // com.avito.android.messenger.map.sharing.di.SharingMapFragmentComponent.Builder
        public SharingMapFragmentComponent.Builder withFragment(Fragment fragment) {
            this.c = (Fragment) Preconditions.checkNotNull(fragment);
            return this;
        }
    }

    public static class c implements Provider<MessengerClient<AvitoMessengerApi>> {
        public final SharingMapFragmentDependencies a;

        public c(SharingMapFragmentDependencies sharingMapFragmentDependencies) {
            this.a = sharingMapFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public MessengerClient<AvitoMessengerApi> get() {
            return (MessengerClient) Preconditions.checkNotNullFromComponent(this.a.messengerClient());
        }
    }

    public static class d implements Provider<SchedulersFactory> {
        public final SharingMapFragmentDependencies a;

        public d(SharingMapFragmentDependencies sharingMapFragmentDependencies) {
            this.a = sharingMapFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public DaggerSharingMapFragmentComponent(SharingMapFragmentDependencies sharingMapFragmentDependencies, SharingMapFragment sharingMapFragment, Activity activity, Fragment fragment, SharingMapView.State state, SharingMapView.State state2, String str, String str2, String str3, a aVar) {
        this.a = sharingMapFragment;
        this.b = sharingMapFragmentDependencies;
        this.c = fragment;
        this.d = InstanceFactory.create(state);
        this.e = new d(sharingMapFragmentDependencies);
        this.f = InstanceFactory.create(state2);
        c cVar = new c(sharingMapFragmentDependencies);
        this.g = cVar;
        this.h = SharingMapInteractorImpl_Factory.create(cVar);
        this.i = InstanceFactory.create(str);
        this.j = InstanceFactory.create(str2);
        Factory create = InstanceFactory.create(str3);
        this.k = create;
        this.l = SharingMapPresenterImpl_Factory.create(this.d, this.e, this.f, this.h, this.i, this.j, create);
        MapProviderFactory build = MapProviderFactory.builder(1).put((MapProviderFactory.Builder) SharingMapPresenterImpl.class, (Provider) this.l).build();
        this.m = build;
        this.n = SingleCheck.provider(ViewModelFactory_Factory.create(build));
    }

    public static SharingMapFragmentComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.messenger.map.sharing.di.SharingMapFragmentComponent
    public void inject(SharingMapFragment sharingMapFragment) {
        SharingMapFragment_MembersInjector.injectPresenter(sharingMapFragment, SharingMapFragmentModule_ProvideSharingMapPresenterFactory.provideSharingMapPresenter(this.a, this.n.get()));
        SharingMapFragment_MembersInjector.injectActivityIntentFactory(sharingMapFragment, (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.b.activityIntentFactory()));
        SharingMapFragment_MembersInjector.injectFeatures(sharingMapFragment, (Features) Preconditions.checkNotNullFromComponent(this.b.features()));
        SharingMapFragment_MembersInjector.injectAnalytics(sharingMapFragment, (Analytics) Preconditions.checkNotNullFromComponent(this.b.analytics()));
        SharingMapFragment_MembersInjector.injectFindLocationPresenter(sharingMapFragment, new FindLocationPresenterImpl(SharingMapFragmentModule_ProvideDefaultLocationProviderFactory.provideDefaultLocationProvider(SharingMapFragmentModule_ProvideDefaultLocationInteractorFactory.provideDefaultLocationInteractor((GeoStorage) Preconditions.checkNotNullFromComponent(this.b.geoStorage()))), new GoogleServicesLocationProviderImpl(new FusedLocationInteractorImpl((GeoStorage) Preconditions.checkNotNullFromComponent(this.b.geoStorage())))));
        SharingMapFragment_MembersInjector.injectLocationPermissionDialogPresenter(sharingMapFragment, SharingMapFragmentModule_ProvideLocationPermissionDialogPresenter$messenger_releaseFactory.provideLocationPermissionDialogPresenter$messenger_release(new LocationPermissionProviderImpl(this.c)));
        SharingMapFragment_MembersInjector.injectLocationAnalyticsInteractor(sharingMapFragment, new LocationAnalyticsInteractorImpl((Analytics) Preconditions.checkNotNullFromComponent(this.b.analytics()), (TimeSource) Preconditions.checkNotNullFromComponent(this.b.timeSource())));
        SharingMapFragment_MembersInjector.injectImplicitIntentFactory(sharingMapFragment, (ImplicitIntentFactory) Preconditions.checkNotNullFromComponent(this.b.implicitIntentFactory()));
        SharingMapFragment_MembersInjector.injectSchedulers(sharingMapFragment, (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.b.schedulersFactory3()));
    }
}
