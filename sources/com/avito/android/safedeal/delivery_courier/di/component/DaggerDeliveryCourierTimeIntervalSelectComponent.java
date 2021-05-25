package com.avito.android.safedeal.delivery_courier.di.component;

import android.app.Activity;
import android.content.res.Resources;
import androidx.fragment.app.Fragment;
import com.avito.android.analytics.Analytics;
import com.avito.android.remote.DeliveryApi;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.remote.model.delivery_courier.TimeInterval;
import com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierTimeIntervalSelectComponent;
import com.avito.android.safedeal.delivery_courier.di.module.DeliveryCourierTimeIntervalSelectModule_ProvideDateRangeBluePrint$safedeal_releaseFactory;
import com.avito.android.safedeal.delivery_courier.di.module.DeliveryCourierTimeIntervalSelectModule_ProvideDateRangeItemPresenter$safedeal_releaseFactory;
import com.avito.android.safedeal.delivery_courier.di.module.DeliveryCourierTimeIntervalSelectModule_ProvideDeliveryCourierTimeIntervalSelectViewModel$safedeal_releaseFactory;
import com.avito.android.safedeal.delivery_courier.di.module.DeliveryCourierTimeIntervalSelectModule_ProvideDeliveryCourierTimeIntervalSelectViewModelFactoryFactory;
import com.avito.android.safedeal.delivery_courier.di.module.DeliveryCourierTimeIntervalSelectModule_ProvideSuggestItemBinder$safedeal_releaseFactory;
import com.avito.android.safedeal.delivery_courier.time_interval_select.DeliveryCourierTimeIntervalSelectAnalyticsTracker;
import com.avito.android.safedeal.delivery_courier.time_interval_select.DeliveryCourierTimeIntervalSelectAnalyticsTrackerImpl;
import com.avito.android.safedeal.delivery_courier.time_interval_select.DeliveryCourierTimeIntervalSelectAnalyticsTrackerImpl_Factory;
import com.avito.android.safedeal.delivery_courier.time_interval_select.DeliveryCourierTimeIntervalSelectFragment;
import com.avito.android.safedeal.delivery_courier.time_interval_select.DeliveryCourierTimeIntervalSelectFragment_MembersInjector;
import com.avito.android.safedeal.delivery_courier.time_interval_select.DeliveryCourierTimeIntervalSelectInteractor;
import com.avito.android.safedeal.delivery_courier.time_interval_select.DeliveryCourierTimeIntervalSelectInteractorImpl;
import com.avito.android.safedeal.delivery_courier.time_interval_select.DeliveryCourierTimeIntervalSelectInteractorImpl_Factory;
import com.avito.android.safedeal.delivery_courier.time_interval_select.DeliveryCourierTimeIntervalSelectResourceProvider;
import com.avito.android.safedeal.delivery_courier.time_interval_select.DeliveryCourierTimeIntervalSelectResourceProviderImpl;
import com.avito.android.safedeal.delivery_courier.time_interval_select.DeliveryCourierTimeIntervalSelectResourceProviderImpl_Factory;
import com.avito.android.safedeal.delivery_courier.time_interval_select.DeliveryCourierTimeIntervalSelectViewModel;
import com.avito.android.safedeal.delivery_courier.time_interval_select.DeliveryCourierTimeIntervalSelectViewModelFactory;
import com.avito.android.safedeal.delivery_courier.time_interval_select.konveyor.time_interval.TimeIntervalBlueprint;
import com.avito.android.safedeal.delivery_courier.time_interval_select.konveyor.time_interval.TimeIntervalItemPresenter;
import com.avito.android.util.SchedulersFactory;
import com.avito.konveyor.ItemBinder;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class DaggerDeliveryCourierTimeIntervalSelectComponent implements DeliveryCourierTimeIntervalSelectComponent {
    public Provider<String> a;
    public Provider<String> b;
    public Provider<TimeInterval> c;
    public Provider<DeliveryApi> d;
    public Provider<SchedulersFactory> e;
    public Provider<TypedErrorThrowableConverter> f;
    public Provider<DeliveryCourierTimeIntervalSelectInteractorImpl> g;
    public Provider<DeliveryCourierTimeIntervalSelectInteractor> h;
    public Provider<Resources> i;
    public Provider<DeliveryCourierTimeIntervalSelectResourceProviderImpl> j;
    public Provider<DeliveryCourierTimeIntervalSelectResourceProvider> k;
    public Provider<Analytics> l;
    public Provider<DeliveryCourierTimeIntervalSelectAnalyticsTrackerImpl> m;
    public Provider<DeliveryCourierTimeIntervalSelectAnalyticsTracker> n;
    public Provider<DeliveryCourierTimeIntervalSelectViewModelFactory> o;
    public Provider<Fragment> p;
    public Provider<DeliveryCourierTimeIntervalSelectViewModel> q;
    public Provider<TimeIntervalItemPresenter> r;
    public Provider<TimeIntervalBlueprint> s;
    public Provider<ItemBinder> t;

    public static final class b implements DeliveryCourierTimeIntervalSelectComponent.Builder {
        public Activity a;
        public Resources b;
        public Fragment c;
        public String d;
        public String e;
        public TimeInterval f;
        public DeliveryCourierCommonDependencies g;

        public b(a aVar) {
        }

        @Override // com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierTimeIntervalSelectComponent.Builder
        public DeliveryCourierTimeIntervalSelectComponent.Builder activity(Activity activity) {
            this.a = (Activity) Preconditions.checkNotNull(activity);
            return this;
        }

        @Override // com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierTimeIntervalSelectComponent.Builder
        public DeliveryCourierTimeIntervalSelectComponent build() {
            Preconditions.checkBuilderRequirement(this.a, Activity.class);
            Preconditions.checkBuilderRequirement(this.b, Resources.class);
            Preconditions.checkBuilderRequirement(this.c, Fragment.class);
            Preconditions.checkBuilderRequirement(this.d, String.class);
            Preconditions.checkBuilderRequirement(this.e, String.class);
            Preconditions.checkBuilderRequirement(this.g, DeliveryCourierCommonDependencies.class);
            return new DaggerDeliveryCourierTimeIntervalSelectComponent(this.g, this.a, this.b, this.c, this.d, this.e, this.f, null);
        }

        @Override // com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierTimeIntervalSelectComponent.Builder
        public DeliveryCourierTimeIntervalSelectComponent.Builder deliveryTimeIntervalSuggestDependencies(DeliveryCourierCommonDependencies deliveryCourierCommonDependencies) {
            this.g = (DeliveryCourierCommonDependencies) Preconditions.checkNotNull(deliveryCourierCommonDependencies);
            return this;
        }

        @Override // com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierTimeIntervalSelectComponent.Builder
        public DeliveryCourierTimeIntervalSelectComponent.Builder orderID(String str) {
            this.d = (String) Preconditions.checkNotNull(str);
            return this;
        }

        @Override // com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierTimeIntervalSelectComponent.Builder
        public DeliveryCourierTimeIntervalSelectComponent.Builder resources(Resources resources) {
            this.b = (Resources) Preconditions.checkNotNull(resources);
            return this;
        }

        @Override // com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierTimeIntervalSelectComponent.Builder
        public DeliveryCourierTimeIntervalSelectComponent.Builder selectedTimeInterval(TimeInterval timeInterval) {
            this.f = timeInterval;
            return this;
        }

        @Override // com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierTimeIntervalSelectComponent.Builder
        public DeliveryCourierTimeIntervalSelectComponent.Builder source(String str) {
            this.e = (String) Preconditions.checkNotNull(str);
            return this;
        }

        @Override // com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierTimeIntervalSelectComponent.Builder
        public DeliveryCourierTimeIntervalSelectComponent.Builder viewModelFragment(Fragment fragment) {
            this.c = (Fragment) Preconditions.checkNotNull(fragment);
            return this;
        }
    }

    public static class c implements Provider<Analytics> {
        public final DeliveryCourierCommonDependencies a;

        public c(DeliveryCourierCommonDependencies deliveryCourierCommonDependencies) {
            this.a = deliveryCourierCommonDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Analytics get() {
            return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
        }
    }

    public static class d implements Provider<DeliveryApi> {
        public final DeliveryCourierCommonDependencies a;

        public d(DeliveryCourierCommonDependencies deliveryCourierCommonDependencies) {
            this.a = deliveryCourierCommonDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public DeliveryApi get() {
            return (DeliveryApi) Preconditions.checkNotNullFromComponent(this.a.deliveryApi());
        }
    }

    public static class e implements Provider<SchedulersFactory> {
        public final DeliveryCourierCommonDependencies a;

        public e(DeliveryCourierCommonDependencies deliveryCourierCommonDependencies) {
            this.a = deliveryCourierCommonDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public static class f implements Provider<TypedErrorThrowableConverter> {
        public final DeliveryCourierCommonDependencies a;

        public f(DeliveryCourierCommonDependencies deliveryCourierCommonDependencies) {
            this.a = deliveryCourierCommonDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TypedErrorThrowableConverter get() {
            return (TypedErrorThrowableConverter) Preconditions.checkNotNullFromComponent(this.a.typedErrorThrowableConverter());
        }
    }

    public DaggerDeliveryCourierTimeIntervalSelectComponent(DeliveryCourierCommonDependencies deliveryCourierCommonDependencies, Activity activity, Resources resources, Fragment fragment, String str, String str2, TimeInterval timeInterval, a aVar) {
        this.a = InstanceFactory.create(str);
        this.b = InstanceFactory.create(str2);
        this.c = InstanceFactory.createNullable(timeInterval);
        d dVar = new d(deliveryCourierCommonDependencies);
        this.d = dVar;
        e eVar = new e(deliveryCourierCommonDependencies);
        this.e = eVar;
        f fVar = new f(deliveryCourierCommonDependencies);
        this.f = fVar;
        DeliveryCourierTimeIntervalSelectInteractorImpl_Factory create = DeliveryCourierTimeIntervalSelectInteractorImpl_Factory.create(dVar, eVar, fVar);
        this.g = create;
        this.h = DoubleCheck.provider(create);
        Factory create2 = InstanceFactory.create(resources);
        this.i = create2;
        DeliveryCourierTimeIntervalSelectResourceProviderImpl_Factory create3 = DeliveryCourierTimeIntervalSelectResourceProviderImpl_Factory.create(create2);
        this.j = create3;
        this.k = DoubleCheck.provider(create3);
        c cVar = new c(deliveryCourierCommonDependencies);
        this.l = cVar;
        DeliveryCourierTimeIntervalSelectAnalyticsTrackerImpl_Factory create4 = DeliveryCourierTimeIntervalSelectAnalyticsTrackerImpl_Factory.create(cVar);
        this.m = create4;
        Provider<DeliveryCourierTimeIntervalSelectAnalyticsTracker> provider = DoubleCheck.provider(create4);
        this.n = provider;
        this.o = DoubleCheck.provider(DeliveryCourierTimeIntervalSelectModule_ProvideDeliveryCourierTimeIntervalSelectViewModelFactoryFactory.create(this.a, this.b, this.c, this.h, this.e, this.k, provider));
        Factory create5 = InstanceFactory.create(fragment);
        this.p = create5;
        Provider<DeliveryCourierTimeIntervalSelectViewModel> provider2 = DoubleCheck.provider(DeliveryCourierTimeIntervalSelectModule_ProvideDeliveryCourierTimeIntervalSelectViewModel$safedeal_releaseFactory.create(this.o, create5));
        this.q = provider2;
        Provider<TimeIntervalItemPresenter> provider3 = DoubleCheck.provider(DeliveryCourierTimeIntervalSelectModule_ProvideDateRangeItemPresenter$safedeal_releaseFactory.create(provider2));
        this.r = provider3;
        Provider<TimeIntervalBlueprint> provider4 = DoubleCheck.provider(DeliveryCourierTimeIntervalSelectModule_ProvideDateRangeBluePrint$safedeal_releaseFactory.create(provider3));
        this.s = provider4;
        this.t = DoubleCheck.provider(DeliveryCourierTimeIntervalSelectModule_ProvideSuggestItemBinder$safedeal_releaseFactory.create(provider4));
    }

    public static DeliveryCourierTimeIntervalSelectComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierTimeIntervalSelectComponent
    public void inject(DeliveryCourierTimeIntervalSelectFragment deliveryCourierTimeIntervalSelectFragment) {
        DeliveryCourierTimeIntervalSelectFragment_MembersInjector.injectViewModel(deliveryCourierTimeIntervalSelectFragment, this.q.get());
        DeliveryCourierTimeIntervalSelectFragment_MembersInjector.injectItemBinder(deliveryCourierTimeIntervalSelectFragment, this.t.get());
    }
}
