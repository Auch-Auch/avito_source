package com.avito.android.delivery.di.component;

import android.app.Activity;
import android.content.res.Resources;
import androidx.fragment.app.Fragment;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.screens.ScreenFlowTrackerProvider;
import com.avito.android.analytics.screens.TimerFactory_Factory;
import com.avito.android.analytics.screens.tracker.BaseScreenPerformanceTracker;
import com.avito.android.analytics.screens.tracker.BaseScreenPerformanceTrackerImpl;
import com.avito.android.analytics.screens.tracker.BaseScreenPerformanceTrackerImpl_Factory;
import com.avito.android.analytics.screens.tracker.ScreenDiInjectTracker;
import com.avito.android.analytics.screens.tracker.ScreenInitTracker;
import com.avito.android.analytics.screens.tracker.ScreenTrackerFactory;
import com.avito.android.avito_map.AvitoMapBounds;
import com.avito.android.delivery.di.component.DeliveryLocationSuggestComponent;
import com.avito.android.delivery.di.module.DeliveryLocationSuggestModule_ProvideAdapterPresenter$delivery_releaseFactory;
import com.avito.android.delivery.di.module.DeliveryLocationSuggestModule_ProvideDeliveryCancelSuggestsViewModel$delivery_releaseFactory;
import com.avito.android.delivery.di.module.DeliveryLocationSuggestModule_ProvideSuggestItemBinder$delivery_releaseFactory;
import com.avito.android.delivery.di.module.DeliveryLocationSuggestModule_ProvideSuggestItemPresenter$delivery_releaseFactory;
import com.avito.android.delivery.di.module.DeliveryLocationSuggestModule_ProvidesScreenContentTypeFactory;
import com.avito.android.delivery.di.module.DeliveryLocationSuggestModule_ProvidesScreenDiInjectTracker$delivery_releaseFactory;
import com.avito.android.delivery.di.module.DeliveryLocationSuggestModule_ProvidesScreenFlowTrackerProviderFactory;
import com.avito.android.delivery.di.module.DeliveryLocationSuggestModule_ProvidesScreenInitTrackerFactory;
import com.avito.android.delivery.suggest.DeliveryLocationSuggestFragment;
import com.avito.android.delivery.suggest.DeliveryLocationSuggestFragment_MembersInjector;
import com.avito.android.delivery.suggest.DeliveryLocationSuggestInteractor;
import com.avito.android.delivery.suggest.DeliveryLocationSuggestInteractorImpl;
import com.avito.android.delivery.suggest.DeliveryLocationSuggestInteractorImpl_Factory;
import com.avito.android.delivery.suggest.DeliveryLocationSuggestViewModel;
import com.avito.android.delivery.suggest.DeliveryLocationSuggestViewModelFactory;
import com.avito.android.delivery.suggest.DeliveryLocationSuggestViewModelFactory_Factory;
import com.avito.android.delivery.suggest.konveyor.empty.EmptyBlueprint;
import com.avito.android.delivery.suggest.konveyor.empty.EmptyBlueprint_Factory;
import com.avito.android.delivery.suggest.konveyor.empty.EmptyItemPresenter;
import com.avito.android.delivery.suggest.konveyor.empty.EmptyItemPresenterImpl_Factory;
import com.avito.android.delivery.suggest.konveyor.suggest.SuggestBlueprint;
import com.avito.android.delivery.suggest.konveyor.suggest.SuggestBlueprint_Factory;
import com.avito.android.delivery.suggest.konveyor.suggest.SuggestItemPresenter;
import com.avito.android.location_picker.providers.AddressGeoCoder;
import com.avito.android.location_picker.providers.AvitoAddressGeoCoder;
import com.avito.android.location_picker.providers.AvitoAddressGeoCoder_Factory;
import com.avito.android.remote.LocationApi;
import com.avito.android.util.SchedulersFactory3;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class DaggerDeliveryLocationSuggestComponent implements DeliveryLocationSuggestComponent {
    public final DeliveryLocationSuggestDependencies a;
    public Provider<LocationApi> b;
    public Provider<AvitoAddressGeoCoder> c;
    public Provider<AddressGeoCoder> d;
    public Provider<SchedulersFactory3> e;
    public Provider<DeliveryLocationSuggestInteractorImpl> f;
    public Provider<DeliveryLocationSuggestInteractor> g;
    public Provider<AvitoMapBounds> h;
    public Provider<ScreenTrackerFactory> i;
    public Provider<String> j = DoubleCheck.provider(DeliveryLocationSuggestModule_ProvidesScreenContentTypeFactory.create());
    public Provider<ScreenDiInjectTracker> k = DoubleCheck.provider(DeliveryLocationSuggestModule_ProvidesScreenDiInjectTracker$delivery_releaseFactory.create(this.i, TimerFactory_Factory.create(), this.j));
    public Provider<ScreenInitTracker> l = DoubleCheck.provider(DeliveryLocationSuggestModule_ProvidesScreenInitTrackerFactory.create(this.i, TimerFactory_Factory.create(), this.j));
    public Provider<ScreenFlowTrackerProvider> m;
    public Provider<BaseScreenPerformanceTrackerImpl> n;
    public Provider<BaseScreenPerformanceTracker> o;
    public Provider<DeliveryLocationSuggestViewModelFactory> p;
    public Provider<Fragment> q;
    public Provider<DeliveryLocationSuggestViewModel> r;
    public Provider<SuggestItemPresenter> s;
    public Provider<SuggestBlueprint> t;
    public Provider<EmptyItemPresenter> u;
    public Provider<EmptyBlueprint> v;
    public Provider<ItemBinder> w;
    public Provider<AdapterPresenter> x;

    public static final class b implements DeliveryLocationSuggestComponent.Builder {
        public Activity a;
        public Resources b;
        public Fragment c;
        public AvitoMapBounds d;
        public DeliveryLocationSuggestDependencies e;

        public b(a aVar) {
        }

        @Override // com.avito.android.delivery.di.component.DeliveryLocationSuggestComponent.Builder
        public DeliveryLocationSuggestComponent.Builder activity(Activity activity) {
            this.a = (Activity) Preconditions.checkNotNull(activity);
            return this;
        }

        @Override // com.avito.android.delivery.di.component.DeliveryLocationSuggestComponent.Builder
        public DeliveryLocationSuggestComponent build() {
            Preconditions.checkBuilderRequirement(this.a, Activity.class);
            Preconditions.checkBuilderRequirement(this.b, Resources.class);
            Preconditions.checkBuilderRequirement(this.c, Fragment.class);
            Preconditions.checkBuilderRequirement(this.d, AvitoMapBounds.class);
            Preconditions.checkBuilderRequirement(this.e, DeliveryLocationSuggestDependencies.class);
            return new DaggerDeliveryLocationSuggestComponent(this.e, this.a, this.b, this.c, this.d, null);
        }

        @Override // com.avito.android.delivery.di.component.DeliveryLocationSuggestComponent.Builder
        public DeliveryLocationSuggestComponent.Builder deliveryLocationSuggestDependencies(DeliveryLocationSuggestDependencies deliveryLocationSuggestDependencies) {
            this.e = (DeliveryLocationSuggestDependencies) Preconditions.checkNotNull(deliveryLocationSuggestDependencies);
            return this;
        }

        @Override // com.avito.android.delivery.di.component.DeliveryLocationSuggestComponent.Builder
        public DeliveryLocationSuggestComponent.Builder resources(Resources resources) {
            this.b = (Resources) Preconditions.checkNotNull(resources);
            return this;
        }

        @Override // com.avito.android.delivery.di.component.DeliveryLocationSuggestComponent.Builder
        public DeliveryLocationSuggestComponent.Builder viewModelFragment(Fragment fragment) {
            this.c = (Fragment) Preconditions.checkNotNull(fragment);
            return this;
        }

        @Override // com.avito.android.delivery.di.component.DeliveryLocationSuggestComponent.Builder
        public DeliveryLocationSuggestComponent.Builder visibleRegion(AvitoMapBounds avitoMapBounds) {
            this.d = (AvitoMapBounds) Preconditions.checkNotNull(avitoMapBounds);
            return this;
        }
    }

    public static class c implements Provider<LocationApi> {
        public final DeliveryLocationSuggestDependencies a;

        public c(DeliveryLocationSuggestDependencies deliveryLocationSuggestDependencies) {
            this.a = deliveryLocationSuggestDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public LocationApi get() {
            return (LocationApi) Preconditions.checkNotNullFromComponent(this.a.locationApi());
        }
    }

    public static class d implements Provider<SchedulersFactory3> {
        public final DeliveryLocationSuggestDependencies a;

        public d(DeliveryLocationSuggestDependencies deliveryLocationSuggestDependencies) {
            this.a = deliveryLocationSuggestDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory3 get() {
            return (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3());
        }
    }

    public static class e implements Provider<ScreenTrackerFactory> {
        public final DeliveryLocationSuggestDependencies a;

        public e(DeliveryLocationSuggestDependencies deliveryLocationSuggestDependencies) {
            this.a = deliveryLocationSuggestDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ScreenTrackerFactory get() {
            return (ScreenTrackerFactory) Preconditions.checkNotNullFromComponent(this.a.screenTrackerFactory());
        }
    }

    public DaggerDeliveryLocationSuggestComponent(DeliveryLocationSuggestDependencies deliveryLocationSuggestDependencies, Activity activity, Resources resources, Fragment fragment, AvitoMapBounds avitoMapBounds, a aVar) {
        this.a = deliveryLocationSuggestDependencies;
        c cVar = new c(deliveryLocationSuggestDependencies);
        this.b = cVar;
        AvitoAddressGeoCoder_Factory create = AvitoAddressGeoCoder_Factory.create(cVar);
        this.c = create;
        Provider<AddressGeoCoder> provider = DoubleCheck.provider(create);
        this.d = provider;
        d dVar = new d(deliveryLocationSuggestDependencies);
        this.e = dVar;
        DeliveryLocationSuggestInteractorImpl_Factory create2 = DeliveryLocationSuggestInteractorImpl_Factory.create(provider, dVar);
        this.f = create2;
        this.g = DoubleCheck.provider(create2);
        this.h = InstanceFactory.create(avitoMapBounds);
        this.i = new e(deliveryLocationSuggestDependencies);
        Provider<ScreenFlowTrackerProvider> provider2 = DoubleCheck.provider(DeliveryLocationSuggestModule_ProvidesScreenFlowTrackerProviderFactory.create(this.i, TimerFactory_Factory.create()));
        this.m = provider2;
        BaseScreenPerformanceTrackerImpl_Factory create3 = BaseScreenPerformanceTrackerImpl_Factory.create(this.k, this.l, provider2, this.j);
        this.n = create3;
        Provider<BaseScreenPerformanceTracker> provider3 = DoubleCheck.provider(create3);
        this.o = provider3;
        this.p = DeliveryLocationSuggestViewModelFactory_Factory.create(this.g, this.e, this.h, provider3);
        Factory create4 = InstanceFactory.create(fragment);
        this.q = create4;
        Provider<DeliveryLocationSuggestViewModel> provider4 = DoubleCheck.provider(DeliveryLocationSuggestModule_ProvideDeliveryCancelSuggestsViewModel$delivery_releaseFactory.create(this.p, create4));
        this.r = provider4;
        Provider<SuggestItemPresenter> provider5 = DoubleCheck.provider(DeliveryLocationSuggestModule_ProvideSuggestItemPresenter$delivery_releaseFactory.create(provider4));
        this.s = provider5;
        this.t = SuggestBlueprint_Factory.create(provider5);
        Provider<EmptyItemPresenter> provider6 = DoubleCheck.provider(EmptyItemPresenterImpl_Factory.create());
        this.u = provider6;
        EmptyBlueprint_Factory create5 = EmptyBlueprint_Factory.create(provider6);
        this.v = create5;
        Provider<ItemBinder> provider7 = DoubleCheck.provider(DeliveryLocationSuggestModule_ProvideSuggestItemBinder$delivery_releaseFactory.create(this.t, create5));
        this.w = provider7;
        this.x = DoubleCheck.provider(DeliveryLocationSuggestModule_ProvideAdapterPresenter$delivery_releaseFactory.create(provider7));
    }

    public static DeliveryLocationSuggestComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.delivery.di.component.DeliveryLocationSuggestComponent
    public void inject(DeliveryLocationSuggestFragment deliveryLocationSuggestFragment) {
        DeliveryLocationSuggestFragment_MembersInjector.injectViewModel(deliveryLocationSuggestFragment, this.r.get());
        DeliveryLocationSuggestFragment_MembersInjector.injectAdapterPresenter(deliveryLocationSuggestFragment, this.x.get());
        DeliveryLocationSuggestFragment_MembersInjector.injectItemBinder(deliveryLocationSuggestFragment, this.w.get());
        DeliveryLocationSuggestFragment_MembersInjector.injectAnalytics(deliveryLocationSuggestFragment, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
        DeliveryLocationSuggestFragment_MembersInjector.injectFeatures(deliveryLocationSuggestFragment, (Features) Preconditions.checkNotNullFromComponent(this.a.features()));
        DeliveryLocationSuggestFragment_MembersInjector.injectSchedulers(deliveryLocationSuggestFragment, (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3()));
        DeliveryLocationSuggestFragment_MembersInjector.injectTracker(deliveryLocationSuggestFragment, this.o.get());
    }
}
