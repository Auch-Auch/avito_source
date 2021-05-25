package com.avito.android.orders.feature.host;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.orders.feature.host.viewpager.OrdersInitialDataProvider;
import com.avito.android.orders.feature.host.viewpager.OrdersTabItem;
import com.avito.android.ui.adapter.tab.TabsDataProvider;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class OrdersFragment_MembersInjector implements MembersInjector<OrdersFragment> {
    public final Provider<OrdersViewModel> a;
    public final Provider<OrdersView> b;
    public final Provider<TabsDataProvider<OrdersTabItem>> c;
    public final Provider<ActivityIntentFactory> d;
    public final Provider<OrdersInitialDataProvider> e;

    public OrdersFragment_MembersInjector(Provider<OrdersViewModel> provider, Provider<OrdersView> provider2, Provider<TabsDataProvider<OrdersTabItem>> provider3, Provider<ActivityIntentFactory> provider4, Provider<OrdersInitialDataProvider> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static MembersInjector<OrdersFragment> create(Provider<OrdersViewModel> provider, Provider<OrdersView> provider2, Provider<TabsDataProvider<OrdersTabItem>> provider3, Provider<ActivityIntentFactory> provider4, Provider<OrdersInitialDataProvider> provider5) {
        return new OrdersFragment_MembersInjector(provider, provider2, provider3, provider4, provider5);
    }

    @InjectedFieldSignature("com.avito.android.orders.feature.host.OrdersFragment.activityIntentFactory")
    public static void injectActivityIntentFactory(OrdersFragment ordersFragment, ActivityIntentFactory activityIntentFactory) {
        ordersFragment.activityIntentFactory = activityIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.orders.feature.host.OrdersFragment.initialDataProvider")
    public static void injectInitialDataProvider(OrdersFragment ordersFragment, OrdersInitialDataProvider ordersInitialDataProvider) {
        ordersFragment.initialDataProvider = ordersInitialDataProvider;
    }

    @InjectedFieldSignature("com.avito.android.orders.feature.host.OrdersFragment.ordersView")
    public static void injectOrdersView(OrdersFragment ordersFragment, OrdersView ordersView) {
        ordersFragment.ordersView = ordersView;
    }

    @InjectedFieldSignature("com.avito.android.orders.feature.host.OrdersFragment.ordersViewModel")
    public static void injectOrdersViewModel(OrdersFragment ordersFragment, OrdersViewModel ordersViewModel) {
        ordersFragment.ordersViewModel = ordersViewModel;
    }

    @InjectedFieldSignature("com.avito.android.orders.feature.host.OrdersFragment.tabsDataProvider")
    public static void injectTabsDataProvider(OrdersFragment ordersFragment, TabsDataProvider<OrdersTabItem> tabsDataProvider) {
        ordersFragment.tabsDataProvider = tabsDataProvider;
    }

    public void injectMembers(OrdersFragment ordersFragment) {
        injectOrdersViewModel(ordersFragment, this.a.get());
        injectOrdersView(ordersFragment, this.b.get());
        injectTabsDataProvider(ordersFragment, this.c.get());
        injectActivityIntentFactory(ordersFragment, this.d.get());
        injectInitialDataProvider(ordersFragment, this.e.get());
    }
}
