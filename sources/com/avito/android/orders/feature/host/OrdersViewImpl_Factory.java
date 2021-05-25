package com.avito.android.orders.feature.host;

import android.view.View;
import androidx.viewpager.widget.PagerAdapter;
import com.avito.android.analytics.Analytics;
import com.avito.android.design.widget.tab.TabLayoutAdapter;
import com.avito.android.orders.feature.host.viewpager.OrdersTabItem;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class OrdersViewImpl_Factory implements Factory<OrdersViewImpl> {
    public final Provider<View> a;
    public final Provider<PagerAdapter> b;
    public final Provider<TabLayoutAdapter<OrdersTabItem>> c;
    public final Provider<Analytics> d;

    public OrdersViewImpl_Factory(Provider<View> provider, Provider<PagerAdapter> provider2, Provider<TabLayoutAdapter<OrdersTabItem>> provider3, Provider<Analytics> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static OrdersViewImpl_Factory create(Provider<View> provider, Provider<PagerAdapter> provider2, Provider<TabLayoutAdapter<OrdersTabItem>> provider3, Provider<Analytics> provider4) {
        return new OrdersViewImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static OrdersViewImpl newInstance(View view, PagerAdapter pagerAdapter, TabLayoutAdapter<OrdersTabItem> tabLayoutAdapter, Analytics analytics) {
        return new OrdersViewImpl(view, pagerAdapter, tabLayoutAdapter, analytics);
    }

    @Override // javax.inject.Provider
    public OrdersViewImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
