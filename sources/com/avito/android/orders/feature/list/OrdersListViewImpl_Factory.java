package com.avito.android.orders.feature.list;

import android.view.View;
import com.avito.android.orders.feature.common.viewmodel.OrderItem;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import dagger.internal.Factory;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Consumer;
import javax.inject.Provider;
import kotlin.Unit;
public final class OrdersListViewImpl_Factory implements Factory<OrdersListViewImpl> {
    public final Provider<View> a;
    public final Provider<SimpleRecyclerAdapter> b;
    public final Provider<AdapterPresenter> c;
    public final Provider<Consumer<Unit>> d;
    public final Provider<Observable<OrderItem>> e;

    public OrdersListViewImpl_Factory(Provider<View> provider, Provider<SimpleRecyclerAdapter> provider2, Provider<AdapterPresenter> provider3, Provider<Consumer<Unit>> provider4, Provider<Observable<OrderItem>> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static OrdersListViewImpl_Factory create(Provider<View> provider, Provider<SimpleRecyclerAdapter> provider2, Provider<AdapterPresenter> provider3, Provider<Consumer<Unit>> provider4, Provider<Observable<OrderItem>> provider5) {
        return new OrdersListViewImpl_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static OrdersListViewImpl newInstance(View view, SimpleRecyclerAdapter simpleRecyclerAdapter, AdapterPresenter adapterPresenter, Consumer<Unit> consumer, Observable<OrderItem> observable) {
        return new OrdersListViewImpl(view, simpleRecyclerAdapter, adapterPresenter, consumer, observable);
    }

    @Override // javax.inject.Provider
    public OrdersListViewImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
