package com.avito.android.orders.feature.list;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class OrdersListFragment_MembersInjector implements MembersInjector<OrdersListFragment> {
    public final Provider<OrdersListView> a;
    public final Provider<OrdersListViewModel> b;
    public final Provider<DeepLinkIntentFactory> c;
    public final Provider<ActivityIntentFactory> d;

    public OrdersListFragment_MembersInjector(Provider<OrdersListView> provider, Provider<OrdersListViewModel> provider2, Provider<DeepLinkIntentFactory> provider3, Provider<ActivityIntentFactory> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static MembersInjector<OrdersListFragment> create(Provider<OrdersListView> provider, Provider<OrdersListViewModel> provider2, Provider<DeepLinkIntentFactory> provider3, Provider<ActivityIntentFactory> provider4) {
        return new OrdersListFragment_MembersInjector(provider, provider2, provider3, provider4);
    }

    @InjectedFieldSignature("com.avito.android.orders.feature.list.OrdersListFragment.activityIntentFactory")
    public static void injectActivityIntentFactory(OrdersListFragment ordersListFragment, ActivityIntentFactory activityIntentFactory) {
        ordersListFragment.activityIntentFactory = activityIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.orders.feature.list.OrdersListFragment.deepLinkIntentFactory")
    public static void injectDeepLinkIntentFactory(OrdersListFragment ordersListFragment, DeepLinkIntentFactory deepLinkIntentFactory) {
        ordersListFragment.deepLinkIntentFactory = deepLinkIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.orders.feature.list.OrdersListFragment.ordersListView")
    public static void injectOrdersListView(OrdersListFragment ordersListFragment, OrdersListView ordersListView) {
        ordersListFragment.ordersListView = ordersListView;
    }

    @InjectedFieldSignature("com.avito.android.orders.feature.list.OrdersListFragment.ordersListViewModel")
    public static void injectOrdersListViewModel(OrdersListFragment ordersListFragment, OrdersListViewModel ordersListViewModel) {
        ordersListFragment.ordersListViewModel = ordersListViewModel;
    }

    public void injectMembers(OrdersListFragment ordersListFragment) {
        injectOrdersListView(ordersListFragment, this.a.get());
        injectOrdersListViewModel(ordersListFragment, this.b.get());
        injectDeepLinkIntentFactory(ordersListFragment, this.c.get());
        injectActivityIntentFactory(ordersListFragment, this.d.get());
    }
}
