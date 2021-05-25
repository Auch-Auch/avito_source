package com.avito.android.orders.feature.host.viewpager;

import androidx.fragment.app.Fragment;
import com.avito.android.ui.adapter.tab.TabsDataProvider;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class OrdersTabPagerAdapter_Factory implements Factory<OrdersTabPagerAdapter> {
    public final Provider<Fragment> a;
    public final Provider<TabsDataProvider<OrdersTabItem>> b;
    public final Provider<OrdersInitialDataProvider> c;

    public OrdersTabPagerAdapter_Factory(Provider<Fragment> provider, Provider<TabsDataProvider<OrdersTabItem>> provider2, Provider<OrdersInitialDataProvider> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static OrdersTabPagerAdapter_Factory create(Provider<Fragment> provider, Provider<TabsDataProvider<OrdersTabItem>> provider2, Provider<OrdersInitialDataProvider> provider3) {
        return new OrdersTabPagerAdapter_Factory(provider, provider2, provider3);
    }

    public static OrdersTabPagerAdapter newInstance(Fragment fragment, TabsDataProvider<OrdersTabItem> tabsDataProvider, OrdersInitialDataProvider ordersInitialDataProvider) {
        return new OrdersTabPagerAdapter(fragment, tabsDataProvider, ordersInitialDataProvider);
    }

    @Override // javax.inject.Provider
    public OrdersTabPagerAdapter get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
