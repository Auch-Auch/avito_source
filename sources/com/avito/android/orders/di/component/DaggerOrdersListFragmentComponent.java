package com.avito.android.orders.di.component;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ListUpdateCallback;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.orders.di.component.OrdersListFragmentComponent;
import com.avito.android.orders.di.module.OrdersListModule_ProvideAdapterPresenter$orders_releaseFactory;
import com.avito.android.orders.di.module.OrdersListModule_ProvideDataAwareAdapterPresenterImpl$orders_releaseFactory;
import com.avito.android.orders.di.module.OrdersListModule_ProvideDiffCalculator$orders_releaseFactory;
import com.avito.android.orders.di.module.OrdersListModule_ProvideItemBinder$orders_releaseFactory;
import com.avito.android.orders.di.module.OrdersListModule_ProvideListUpdateCallback$orders_releaseFactory;
import com.avito.android.orders.di.module.OrdersListModule_ProvideRecyclerAdapter$orders_releaseFactory;
import com.avito.android.orders.di.module.OrdersListModule_ProvideViewModel$orders_releaseFactory;
import com.avito.android.orders.feature.common.converter.OrdersItemConverter;
import com.avito.android.orders.feature.common.converter.OrdersItemConverterImpl_Factory;
import com.avito.android.orders.feature.common.viewmodel.OrderItem;
import com.avito.android.orders.feature.common.viewmodel.OrderPage;
import com.avito.android.orders.feature.list.OrdersListFragment;
import com.avito.android.orders.feature.list.OrdersListFragment_MembersInjector;
import com.avito.android.orders.feature.list.OrdersListRepository;
import com.avito.android.orders.feature.list.OrdersListRepositoryImpl;
import com.avito.android.orders.feature.list.OrdersListRepositoryImpl_Factory;
import com.avito.android.orders.feature.list.OrdersListView;
import com.avito.android.orders.feature.list.OrdersListViewImpl;
import com.avito.android.orders.feature.list.OrdersListViewImpl_Factory;
import com.avito.android.orders.feature.list.OrdersListViewModel;
import com.avito.android.orders.feature.list.OrdersListViewModelFactory;
import com.avito.android.orders.feature.list.OrdersListViewModelFactory_Factory;
import com.avito.android.orders.feature.list.adapter.OrdersContentsComparator_Factory;
import com.avito.android.orders.feature.list.adapter.loading.LoadingItemPresenter_Factory;
import com.avito.android.orders.feature.list.adapter.loading.OrderLoadingItemBlueprint;
import com.avito.android.orders.feature.list.adapter.loading.OrderLoadingItemBlueprint_Factory;
import com.avito.android.orders.feature.list.adapter.order.OrderItemBlueprint;
import com.avito.android.orders.feature.list.adapter.order.OrderItemBlueprint_Factory;
import com.avito.android.orders.feature.list.adapter.order.OrderItemPresenter;
import com.avito.android.orders.feature.list.adapter.order.OrderItemPresenter_Factory;
import com.avito.android.recycler.data_aware.DiffCalculator;
import com.avito.android.remote.orders.OrdersApi;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.android.util.text.AttributedTextFormatterModule_ProvideAttributedTextFormatterFactory;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleAdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.avito.konveyor.blueprint.ItemBlueprint;
import com.jakewharton.rxrelay3.PublishRelay;
import dagger.internal.DelegateFactory;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import dagger.internal.SetFactory;
import dagger.internal.SingleCheck;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.Set;
import javax.inject.Provider;
import kotlin.Unit;
public final class DaggerOrdersListFragmentComponent implements OrdersListFragmentComponent {
    public Provider<OrdersListRepositoryImpl> A;
    public Provider<OrdersListRepository> B;
    public Provider<Analytics> C;
    public Provider<OrdersItemConverter> D = DoubleCheck.provider(OrdersItemConverterImpl_Factory.create());
    public Provider<Observable<Unit>> E = DoubleCheck.provider(this.r);
    public Provider<OrderPage> F;
    public Provider<OrdersListViewModelFactory> G;
    public Provider<OrdersListViewModel> H;
    public final OrdersDependencies a;
    public Provider<View> b;
    public Provider<SimpleRecyclerAdapter> c;
    public Provider<ListUpdateCallback> d;
    public Provider<PublishRelay<OrderItem>> e;
    public Provider<Consumer<OrderItem>> f;
    public Provider<OrderItemPresenter> g;
    public Provider<AttributedTextFormatter> h;
    public Provider<OrderItemBlueprint> i;
    public Provider<ItemBlueprint<?, ?>> j;
    public Provider<OrderLoadingItemBlueprint> k;
    public Provider<ItemBlueprint<?, ?>> l;
    public Provider<Set<ItemBlueprint<?, ?>>> m;
    public Provider<ItemBinder> n;
    public Provider<SimpleAdapterPresenter> o;
    public Provider<DiffCalculator> p;
    public Provider<AdapterPresenter> q;
    public Provider<PublishRelay<Unit>> r;
    public Provider<Consumer<Unit>> s;
    public Provider<Observable<OrderItem>> t;
    public Provider<OrdersListViewImpl> u;
    public Provider<OrdersListView> v;
    public Provider<Fragment> w;
    public Provider<SchedulersFactory3> x;
    public Provider<OrdersApi> y;
    public Provider<Features> z;

    public static final class b implements OrdersListFragmentComponent.Factory {
        public b(a aVar) {
        }

        @Override // com.avito.android.orders.di.component.OrdersListFragmentComponent.Factory
        public OrdersListFragmentComponent create(Fragment fragment, View view, OrderPage orderPage, PublishRelay<Unit> publishRelay, PublishRelay<OrderItem> publishRelay2, OrdersDependencies ordersDependencies) {
            Preconditions.checkNotNull(fragment);
            Preconditions.checkNotNull(view);
            Preconditions.checkNotNull(orderPage);
            Preconditions.checkNotNull(publishRelay);
            Preconditions.checkNotNull(publishRelay2);
            Preconditions.checkNotNull(ordersDependencies);
            return new DaggerOrdersListFragmentComponent(ordersDependencies, fragment, view, orderPage, publishRelay, publishRelay2, null);
        }
    }

    public static class c implements Provider<Analytics> {
        public final OrdersDependencies a;

        public c(OrdersDependencies ordersDependencies) {
            this.a = ordersDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Analytics get() {
            return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
        }
    }

    public static class d implements Provider<Features> {
        public final OrdersDependencies a;

        public d(OrdersDependencies ordersDependencies) {
            this.a = ordersDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Features get() {
            return (Features) Preconditions.checkNotNullFromComponent(this.a.features());
        }
    }

    public static class e implements Provider<OrdersApi> {
        public final OrdersDependencies a;

        public e(OrdersDependencies ordersDependencies) {
            this.a = ordersDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public OrdersApi get() {
            return (OrdersApi) Preconditions.checkNotNullFromComponent(this.a.ordersApi());
        }
    }

    public static class f implements Provider<SchedulersFactory3> {
        public final OrdersDependencies a;

        public f(OrdersDependencies ordersDependencies) {
            this.a = ordersDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory3 get() {
            return (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3());
        }
    }

    public DaggerOrdersListFragmentComponent(OrdersDependencies ordersDependencies, Fragment fragment, View view, OrderPage orderPage, PublishRelay publishRelay, PublishRelay publishRelay2, a aVar) {
        this.a = ordersDependencies;
        this.b = InstanceFactory.create(view);
        DelegateFactory delegateFactory = new DelegateFactory();
        this.c = delegateFactory;
        this.d = DoubleCheck.provider(OrdersListModule_ProvideListUpdateCallback$orders_releaseFactory.create(delegateFactory));
        Factory create = InstanceFactory.create(publishRelay2);
        this.e = create;
        Provider<Consumer<OrderItem>> provider = DoubleCheck.provider(create);
        this.f = provider;
        this.g = OrderItemPresenter_Factory.create(provider);
        Provider<AttributedTextFormatter> provider2 = SingleCheck.provider(AttributedTextFormatterModule_ProvideAttributedTextFormatterFactory.create());
        this.h = provider2;
        OrderItemBlueprint_Factory create2 = OrderItemBlueprint_Factory.create(this.g, provider2);
        this.i = create2;
        this.j = DoubleCheck.provider(create2);
        OrderLoadingItemBlueprint_Factory create3 = OrderLoadingItemBlueprint_Factory.create(LoadingItemPresenter_Factory.create());
        this.k = create3;
        this.l = DoubleCheck.provider(create3);
        SetFactory build = SetFactory.builder(2, 0).addProvider(this.j).addProvider(this.l).build();
        this.m = build;
        Provider<ItemBinder> provider3 = DoubleCheck.provider(OrdersListModule_ProvideItemBinder$orders_releaseFactory.create(build));
        this.n = provider3;
        this.o = DoubleCheck.provider(OrdersListModule_ProvideAdapterPresenter$orders_releaseFactory.create(provider3));
        Provider<DiffCalculator> provider4 = DoubleCheck.provider(OrdersListModule_ProvideDiffCalculator$orders_releaseFactory.create(OrdersContentsComparator_Factory.create()));
        this.p = provider4;
        Provider<AdapterPresenter> provider5 = DoubleCheck.provider(OrdersListModule_ProvideDataAwareAdapterPresenterImpl$orders_releaseFactory.create(this.d, this.o, provider4));
        this.q = provider5;
        DelegateFactory.setDelegate(this.c, DoubleCheck.provider(OrdersListModule_ProvideRecyclerAdapter$orders_releaseFactory.create(provider5, this.n)));
        Factory create4 = InstanceFactory.create(publishRelay);
        this.r = create4;
        this.s = DoubleCheck.provider(create4);
        Provider<Observable<OrderItem>> provider6 = DoubleCheck.provider(this.e);
        this.t = provider6;
        OrdersListViewImpl_Factory create5 = OrdersListViewImpl_Factory.create(this.b, this.c, this.q, this.s, provider6);
        this.u = create5;
        this.v = DoubleCheck.provider(create5);
        this.w = InstanceFactory.create(fragment);
        f fVar = new f(ordersDependencies);
        this.x = fVar;
        e eVar = new e(ordersDependencies);
        this.y = eVar;
        d dVar = new d(ordersDependencies);
        this.z = dVar;
        OrdersListRepositoryImpl_Factory create6 = OrdersListRepositoryImpl_Factory.create(fVar, eVar, dVar);
        this.A = create6;
        this.B = DoubleCheck.provider(create6);
        this.C = new c(ordersDependencies);
        Factory create7 = InstanceFactory.create(orderPage);
        this.F = create7;
        OrdersListViewModelFactory_Factory create8 = OrdersListViewModelFactory_Factory.create(this.B, this.C, this.D, this.E, create7);
        this.G = create8;
        this.H = DoubleCheck.provider(OrdersListModule_ProvideViewModel$orders_releaseFactory.create(this.w, create8));
    }

    public static OrdersListFragmentComponent.Factory factory() {
        return new b(null);
    }

    @Override // com.avito.android.orders.di.component.OrdersListFragmentComponent
    public void inject(OrdersListFragment ordersListFragment) {
        OrdersListFragment_MembersInjector.injectOrdersListView(ordersListFragment, this.v.get());
        OrdersListFragment_MembersInjector.injectOrdersListViewModel(ordersListFragment, this.H.get());
        OrdersListFragment_MembersInjector.injectDeepLinkIntentFactory(ordersListFragment, (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deepLinkIntentFactory()));
        OrdersListFragment_MembersInjector.injectActivityIntentFactory(ordersListFragment, (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.a.activityIntentFactory()));
    }
}
