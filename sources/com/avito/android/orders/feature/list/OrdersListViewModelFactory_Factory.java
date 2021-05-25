package com.avito.android.orders.feature.list;

import com.avito.android.analytics.Analytics;
import com.avito.android.orders.feature.common.converter.OrdersItemConverter;
import com.avito.android.orders.feature.common.viewmodel.OrderPage;
import dagger.internal.Factory;
import io.reactivex.rxjava3.core.Observable;
import javax.inject.Provider;
import kotlin.Unit;
public final class OrdersListViewModelFactory_Factory implements Factory<OrdersListViewModelFactory> {
    public final Provider<OrdersListRepository> a;
    public final Provider<Analytics> b;
    public final Provider<OrdersItemConverter> c;
    public final Provider<Observable<Unit>> d;
    public final Provider<OrderPage> e;

    public OrdersListViewModelFactory_Factory(Provider<OrdersListRepository> provider, Provider<Analytics> provider2, Provider<OrdersItemConverter> provider3, Provider<Observable<Unit>> provider4, Provider<OrderPage> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static OrdersListViewModelFactory_Factory create(Provider<OrdersListRepository> provider, Provider<Analytics> provider2, Provider<OrdersItemConverter> provider3, Provider<Observable<Unit>> provider4, Provider<OrderPage> provider5) {
        return new OrdersListViewModelFactory_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static OrdersListViewModelFactory newInstance(OrdersListRepository ordersListRepository, Analytics analytics, OrdersItemConverter ordersItemConverter, Observable<Unit> observable, OrderPage orderPage) {
        return new OrdersListViewModelFactory(ordersListRepository, analytics, ordersItemConverter, observable, orderPage);
    }

    @Override // javax.inject.Provider
    public OrdersListViewModelFactory get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
