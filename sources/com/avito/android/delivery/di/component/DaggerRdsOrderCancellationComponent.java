package com.avito.android.delivery.di.component;

import android.content.res.Resources;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ListUpdateCallback;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.screens.ScreenFlowTrackerProvider;
import com.avito.android.analytics.screens.TimerFactory_Factory;
import com.avito.android.analytics.screens.tracker.BaseScreenPerformanceTracker;
import com.avito.android.analytics.screens.tracker.BaseScreenPerformanceTrackerImpl;
import com.avito.android.analytics.screens.tracker.BaseScreenPerformanceTrackerImpl_Factory;
import com.avito.android.analytics.screens.tracker.ScreenDiInjectTracker;
import com.avito.android.analytics.screens.tracker.ScreenInitTracker;
import com.avito.android.analytics.screens.tracker.ScreenTrackerFactory;
import com.avito.android.delivery.di.component.RdsOrderCancellationComponent;
import com.avito.android.delivery.di.module.RdsOrderCancellationBlueprintsModule_ProvideAdapterPresenter$delivery_releaseFactory;
import com.avito.android.delivery.di.module.RdsOrderCancellationBlueprintsModule_ProvideDataAwareAdapterPresenter$delivery_releaseFactory;
import com.avito.android.delivery.di.module.RdsOrderCancellationBlueprintsModule_ProvideDiffCalculator$delivery_releaseFactory;
import com.avito.android.delivery.di.module.RdsOrderCancellationBlueprintsModule_ProvideItemBinderFactory;
import com.avito.android.delivery.di.module.RdsOrderCancellationBlueprintsModule_ProvideListUpdateCallback$delivery_releaseFactory;
import com.avito.android.delivery.di.module.RdsOrderCancellationBlueprintsModule_ProvideReasonItemPresenterFactory;
import com.avito.android.delivery.di.module.RdsOrderCancellationBlueprintsModule_ProvideRecyclerAdapterFactory;
import com.avito.android.delivery.di.module.RdsOrderCancellationReasonsModule_ProvideOrderCancellationViewModelFactory;
import com.avito.android.delivery.di.module.RdsOrderCancellationReasonsModule_ProvidesScreenContentTypeFactory;
import com.avito.android.delivery.di.module.RdsOrderCancellationReasonsModule_ProvidesScreenDiInjectTracker$delivery_releaseFactory;
import com.avito.android.delivery.di.module.RdsOrderCancellationReasonsModule_ProvidesScreenFlowTrackerProviderFactory;
import com.avito.android.delivery.di.module.RdsOrderCancellationReasonsModule_ProvidesScreenInitTrackerFactory;
import com.avito.android.delivery.order_cancellation.OrderCancellationResourceProviderImpl;
import com.avito.android.delivery.order_cancellation.OrderCancellationResourceProviderImpl_Factory;
import com.avito.android.delivery.order_cancellation.RdsOrderCancellationInteractorImpl;
import com.avito.android.delivery.order_cancellation.RdsOrderCancellationInteractorImpl_Factory;
import com.avito.android.delivery.order_cancellation.RdsOrderCancellationItemsConverterImpl_Factory;
import com.avito.android.delivery.order_cancellation.RdsOrderCancellationReasonsFragment;
import com.avito.android.delivery.order_cancellation.RdsOrderCancellationReasonsFragment_MembersInjector;
import com.avito.android.delivery.order_cancellation.RdsOrderCancellationReasonsViewModel;
import com.avito.android.delivery.order_cancellation.RdsOrderCancellationReasonsViewModelFactory;
import com.avito.android.delivery.order_cancellation.RdsOrderCancellationReasonsViewModelFactory_Factory;
import com.avito.android.delivery.order_cancellation.konveyor.ReasonItemBlueprint;
import com.avito.android.delivery.order_cancellation.konveyor.ReasonItemBlueprint_Factory;
import com.avito.android.delivery.order_cancellation.konveyor.ReasonItemPresenter;
import com.avito.android.recycler.data_aware.DataAwareAdapterPresenter;
import com.avito.android.recycler.data_aware.DiffCalculator;
import com.avito.android.remote.DeliveryApi;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.util.SchedulersFactory;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class DaggerRdsOrderCancellationComponent implements RdsOrderCancellationComponent {
    public Provider<DataAwareAdapterPresenter> A;
    public final DeliveryDependencies a;
    public final Resources b;
    public Provider<Fragment> c;
    public Provider<DeliveryApi> d;
    public Provider<SchedulersFactory> e;
    public Provider<TypedErrorThrowableConverter> f;
    public Provider<RdsOrderCancellationInteractorImpl> g;
    public Provider<Resources> h;
    public Provider<OrderCancellationResourceProviderImpl> i;
    public Provider<String> j;
    public Provider<ScreenTrackerFactory> k;
    public Provider<String> l = DoubleCheck.provider(RdsOrderCancellationReasonsModule_ProvidesScreenContentTypeFactory.create());
    public Provider<ScreenDiInjectTracker> m = DoubleCheck.provider(RdsOrderCancellationReasonsModule_ProvidesScreenDiInjectTracker$delivery_releaseFactory.create(this.k, TimerFactory_Factory.create(), this.l));
    public Provider<ScreenInitTracker> n = DoubleCheck.provider(RdsOrderCancellationReasonsModule_ProvidesScreenInitTrackerFactory.create(this.k, TimerFactory_Factory.create(), this.l));
    public Provider<ScreenFlowTrackerProvider> o;
    public Provider<BaseScreenPerformanceTrackerImpl> p;
    public Provider<BaseScreenPerformanceTracker> q;
    public Provider<RdsOrderCancellationReasonsViewModelFactory> r;
    public Provider<RdsOrderCancellationReasonsViewModel> s;
    public Provider<ReasonItemPresenter> t;
    public Provider<ReasonItemBlueprint> u;
    public Provider<ItemBinder> v;
    public Provider<AdapterPresenter> w;
    public Provider<SimpleRecyclerAdapter> x;
    public Provider<ListUpdateCallback> y;
    public Provider<DiffCalculator> z;

    public static final class b implements RdsOrderCancellationComponent.Factory {
        public b(a aVar) {
        }

        @Override // com.avito.android.delivery.di.component.RdsOrderCancellationComponent.Factory
        public RdsOrderCancellationComponent create(Resources resources, Fragment fragment, String str, DeliveryDependencies deliveryDependencies) {
            Preconditions.checkNotNull(resources);
            Preconditions.checkNotNull(fragment);
            Preconditions.checkNotNull(str);
            Preconditions.checkNotNull(deliveryDependencies);
            return new DaggerRdsOrderCancellationComponent(deliveryDependencies, resources, fragment, str, null);
        }
    }

    public static class c implements Provider<DeliveryApi> {
        public final DeliveryDependencies a;

        public c(DeliveryDependencies deliveryDependencies) {
            this.a = deliveryDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public DeliveryApi get() {
            return (DeliveryApi) Preconditions.checkNotNullFromComponent(this.a.deliveryApi());
        }
    }

    public static class d implements Provider<SchedulersFactory> {
        public final DeliveryDependencies a;

        public d(DeliveryDependencies deliveryDependencies) {
            this.a = deliveryDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public static class e implements Provider<ScreenTrackerFactory> {
        public final DeliveryDependencies a;

        public e(DeliveryDependencies deliveryDependencies) {
            this.a = deliveryDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ScreenTrackerFactory get() {
            return (ScreenTrackerFactory) Preconditions.checkNotNullFromComponent(this.a.screenTrackerFactory());
        }
    }

    public static class f implements Provider<TypedErrorThrowableConverter> {
        public final DeliveryDependencies a;

        public f(DeliveryDependencies deliveryDependencies) {
            this.a = deliveryDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TypedErrorThrowableConverter get() {
            return (TypedErrorThrowableConverter) Preconditions.checkNotNullFromComponent(this.a.typedErrorThrowableConverter());
        }
    }

    public DaggerRdsOrderCancellationComponent(DeliveryDependencies deliveryDependencies, Resources resources, Fragment fragment, String str, a aVar) {
        this.a = deliveryDependencies;
        this.b = resources;
        this.c = InstanceFactory.create(fragment);
        c cVar = new c(deliveryDependencies);
        this.d = cVar;
        d dVar = new d(deliveryDependencies);
        this.e = dVar;
        f fVar = new f(deliveryDependencies);
        this.f = fVar;
        this.g = RdsOrderCancellationInteractorImpl_Factory.create(cVar, dVar, fVar);
        Factory create = InstanceFactory.create(resources);
        this.h = create;
        this.i = OrderCancellationResourceProviderImpl_Factory.create(create);
        this.j = InstanceFactory.create(str);
        this.k = new e(deliveryDependencies);
        Provider<ScreenFlowTrackerProvider> provider = DoubleCheck.provider(RdsOrderCancellationReasonsModule_ProvidesScreenFlowTrackerProviderFactory.create(this.k, TimerFactory_Factory.create()));
        this.o = provider;
        BaseScreenPerformanceTrackerImpl_Factory create2 = BaseScreenPerformanceTrackerImpl_Factory.create(this.m, this.n, provider, this.l);
        this.p = create2;
        this.q = DoubleCheck.provider(create2);
        RdsOrderCancellationReasonsViewModelFactory_Factory create3 = RdsOrderCancellationReasonsViewModelFactory_Factory.create(this.g, this.i, RdsOrderCancellationItemsConverterImpl_Factory.create(), this.e, this.j, this.q);
        this.r = create3;
        Provider<RdsOrderCancellationReasonsViewModel> provider2 = DoubleCheck.provider(RdsOrderCancellationReasonsModule_ProvideOrderCancellationViewModelFactory.create(this.c, create3));
        this.s = provider2;
        Provider<ReasonItemPresenter> provider3 = DoubleCheck.provider(RdsOrderCancellationBlueprintsModule_ProvideReasonItemPresenterFactory.create(provider2));
        this.t = provider3;
        ReasonItemBlueprint_Factory create4 = ReasonItemBlueprint_Factory.create(provider3);
        this.u = create4;
        Provider<ItemBinder> provider4 = DoubleCheck.provider(RdsOrderCancellationBlueprintsModule_ProvideItemBinderFactory.create(create4));
        this.v = provider4;
        Provider<AdapterPresenter> provider5 = DoubleCheck.provider(RdsOrderCancellationBlueprintsModule_ProvideAdapterPresenter$delivery_releaseFactory.create(provider4));
        this.w = provider5;
        Provider<SimpleRecyclerAdapter> provider6 = DoubleCheck.provider(RdsOrderCancellationBlueprintsModule_ProvideRecyclerAdapterFactory.create(provider5, this.v));
        this.x = provider6;
        this.y = DoubleCheck.provider(RdsOrderCancellationBlueprintsModule_ProvideListUpdateCallback$delivery_releaseFactory.create(provider6));
        Provider<DiffCalculator> provider7 = DoubleCheck.provider(RdsOrderCancellationBlueprintsModule_ProvideDiffCalculator$delivery_releaseFactory.create());
        this.z = provider7;
        this.A = DoubleCheck.provider(RdsOrderCancellationBlueprintsModule_ProvideDataAwareAdapterPresenter$delivery_releaseFactory.create(this.y, this.w, provider7));
    }

    public static RdsOrderCancellationComponent.Factory factory() {
        return new b(null);
    }

    @Override // com.avito.android.delivery.di.component.RdsOrderCancellationComponent
    public void inject(RdsOrderCancellationReasonsFragment rdsOrderCancellationReasonsFragment) {
        RdsOrderCancellationReasonsFragment_MembersInjector.injectAnalytics(rdsOrderCancellationReasonsFragment, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
        RdsOrderCancellationReasonsFragment_MembersInjector.injectViewModel(rdsOrderCancellationReasonsFragment, this.s.get());
        RdsOrderCancellationReasonsFragment_MembersInjector.injectRecyclerAdapter(rdsOrderCancellationReasonsFragment, this.x.get());
        RdsOrderCancellationReasonsFragment_MembersInjector.injectAdapterPresenter(rdsOrderCancellationReasonsFragment, this.A.get());
        RdsOrderCancellationReasonsFragment_MembersInjector.injectResourceProvider(rdsOrderCancellationReasonsFragment, new OrderCancellationResourceProviderImpl(this.b));
        RdsOrderCancellationReasonsFragment_MembersInjector.injectTracker(rdsOrderCancellationReasonsFragment, this.q.get());
    }
}
