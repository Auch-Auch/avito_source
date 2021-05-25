package com.avito.android.orders.di.module;

import com.avito.android.orders.feature.host.viewpager.OrdersTabItem;
import com.avito.android.ui.adapter.tab.TabsDataProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class OrdersModule_ProvideTabsDataProviderFactory implements Factory<TabsDataProvider<OrdersTabItem>> {

    public static final class a {
        public static final OrdersModule_ProvideTabsDataProviderFactory a = new OrdersModule_ProvideTabsDataProviderFactory();
    }

    public static OrdersModule_ProvideTabsDataProviderFactory create() {
        return a.a;
    }

    public static TabsDataProvider<OrdersTabItem> provideTabsDataProvider() {
        return (TabsDataProvider) Preconditions.checkNotNullFromProvides(OrdersModule.provideTabsDataProvider());
    }

    @Override // javax.inject.Provider
    public TabsDataProvider<OrdersTabItem> get() {
        return provideTabsDataProvider();
    }
}
