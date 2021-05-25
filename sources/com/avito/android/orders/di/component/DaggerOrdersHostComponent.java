package com.avito.android.orders.di.component;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.design.widget.tab.TabLayoutAdapter;
import com.avito.android.orders.di.component.OrdersHostComponent;
import com.avito.android.orders.di.module.OrdersModule_ProvideTabLayoutAdapter$orders_releaseFactory;
import com.avito.android.orders.di.module.OrdersModule_ProvideTabsDataProviderFactory;
import com.avito.android.orders.di.module.OrdersModule_ProvideViewModel$orders_releaseFactory;
import com.avito.android.orders.feature.common.converter.OrdersItemConverter;
import com.avito.android.orders.feature.common.converter.OrdersItemConverterImpl_Factory;
import com.avito.android.orders.feature.common.converter.OrdersTabItemConverter;
import com.avito.android.orders.feature.common.converter.OrdersTabItemConverterImpl_Factory;
import com.avito.android.orders.feature.host.OrdersFragment;
import com.avito.android.orders.feature.host.OrdersFragment_MembersInjector;
import com.avito.android.orders.feature.host.OrdersRepository;
import com.avito.android.orders.feature.host.OrdersRepositoryImpl;
import com.avito.android.orders.feature.host.OrdersRepositoryImpl_Factory;
import com.avito.android.orders.feature.host.OrdersView;
import com.avito.android.orders.feature.host.OrdersViewImpl;
import com.avito.android.orders.feature.host.OrdersViewImpl_Factory;
import com.avito.android.orders.feature.host.OrdersViewModelFactory;
import com.avito.android.orders.feature.host.viewpager.OrdersInitialDataProvider;
import com.avito.android.orders.feature.host.viewpager.OrdersInitialDataProviderImpl_Factory;
import com.avito.android.orders.feature.host.viewpager.OrdersTabItem;
import com.avito.android.orders.feature.host.viewpager.OrdersTabPagerAdapter;
import com.avito.android.orders.feature.host.viewpager.OrdersTabPagerAdapter_Factory;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.remote.orders.OrdersApi;
import com.avito.android.ui.adapter.tab.TabsDataProvider;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class DaggerOrdersHostComponent implements OrdersHostComponent {
    public final Fragment a;
    public final OrdersDependencies b;
    public final String c;
    public Provider<SchedulersFactory3> d;
    public Provider<OrdersApi> e;
    public Provider<Features> f;
    public Provider<String> g;
    public Provider<OrdersRepositoryImpl> h;
    public Provider<OrdersRepository> i;
    public Provider<OrdersTabItemConverter> j = DoubleCheck.provider(OrdersTabItemConverterImpl_Factory.create());
    public Provider<OrdersItemConverter> k = DoubleCheck.provider(OrdersItemConverterImpl_Factory.create());
    public Provider<View> l;
    public Provider<Fragment> m;
    public Provider<TabsDataProvider<OrdersTabItem>> n;
    public Provider<OrdersInitialDataProvider> o;
    public Provider<OrdersTabPagerAdapter> p;
    public Provider<PagerAdapter> q;
    public Provider<TabLayoutAdapter<OrdersTabItem>> r;
    public Provider<Analytics> s;
    public Provider<OrdersViewImpl> t;
    public Provider<OrdersView> u;

    public static final class b implements OrdersHostComponent.Factory {
        public b(a aVar) {
        }

        @Override // com.avito.android.orders.di.component.OrdersHostComponent.Factory
        public OrdersHostComponent create(Fragment fragment, View view, String str, String str2, OrdersDependencies ordersDependencies) {
            Preconditions.checkNotNull(fragment);
            Preconditions.checkNotNull(view);
            Preconditions.checkNotNull(ordersDependencies);
            return new DaggerOrdersHostComponent(ordersDependencies, fragment, view, str, str2, null);
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

    public DaggerOrdersHostComponent(OrdersDependencies ordersDependencies, Fragment fragment, View view, String str, String str2, a aVar) {
        this.a = fragment;
        this.b = ordersDependencies;
        this.c = str;
        this.d = new f(ordersDependencies);
        this.e = new e(ordersDependencies);
        this.f = new d(ordersDependencies);
        Factory createNullable = InstanceFactory.createNullable(str2);
        this.g = createNullable;
        OrdersRepositoryImpl_Factory create = OrdersRepositoryImpl_Factory.create(this.d, this.e, this.f, createNullable);
        this.h = create;
        this.i = DoubleCheck.provider(create);
        this.l = InstanceFactory.create(view);
        this.m = InstanceFactory.create(fragment);
        this.n = DoubleCheck.provider(OrdersModule_ProvideTabsDataProviderFactory.create());
        Provider<OrdersInitialDataProvider> provider = DoubleCheck.provider(OrdersInitialDataProviderImpl_Factory.create());
        this.o = provider;
        OrdersTabPagerAdapter_Factory create2 = OrdersTabPagerAdapter_Factory.create(this.m, this.n, provider);
        this.p = create2;
        this.q = DoubleCheck.provider(create2);
        Provider<TabLayoutAdapter<OrdersTabItem>> provider2 = DoubleCheck.provider(OrdersModule_ProvideTabLayoutAdapter$orders_releaseFactory.create(this.m, this.n));
        this.r = provider2;
        c cVar = new c(ordersDependencies);
        this.s = cVar;
        OrdersViewImpl_Factory create3 = OrdersViewImpl_Factory.create(this.l, this.q, provider2, cVar);
        this.t = create3;
        this.u = DoubleCheck.provider(create3);
    }

    public static OrdersHostComponent.Factory factory() {
        return new b(null);
    }

    @Override // com.avito.android.orders.di.component.OrdersHostComponent
    public void inject(OrdersFragment ordersFragment) {
        OrdersFragment_MembersInjector.injectOrdersViewModel(ordersFragment, OrdersModule_ProvideViewModel$orders_releaseFactory.provideViewModel$orders_release(this.a, new OrdersViewModelFactory(this.i.get(), (TypedErrorThrowableConverter) Preconditions.checkNotNullFromComponent(this.b.typedErrorThrowableConverter()), this.j.get(), this.k.get(), this.c)));
        OrdersFragment_MembersInjector.injectOrdersView(ordersFragment, this.u.get());
        OrdersFragment_MembersInjector.injectTabsDataProvider(ordersFragment, this.n.get());
        OrdersFragment_MembersInjector.injectActivityIntentFactory(ordersFragment, (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.b.activityIntentFactory()));
        OrdersFragment_MembersInjector.injectInitialDataProvider(ordersFragment, this.o.get());
    }
}
