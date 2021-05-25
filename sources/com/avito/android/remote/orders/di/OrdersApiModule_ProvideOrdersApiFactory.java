package com.avito.android.remote.orders.di;

import com.avito.android.remote.RetrofitFactory;
import com.avito.android.remote.orders.OrdersApi;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class OrdersApiModule_ProvideOrdersApiFactory implements Factory<OrdersApi> {
    public final Provider<RetrofitFactory> a;

    public OrdersApiModule_ProvideOrdersApiFactory(Provider<RetrofitFactory> provider) {
        this.a = provider;
    }

    public static OrdersApiModule_ProvideOrdersApiFactory create(Provider<RetrofitFactory> provider) {
        return new OrdersApiModule_ProvideOrdersApiFactory(provider);
    }

    public static OrdersApi provideOrdersApi(RetrofitFactory retrofitFactory) {
        return (OrdersApi) Preconditions.checkNotNullFromProvides(OrdersApiModule.INSTANCE.provideOrdersApi(retrofitFactory));
    }

    @Override // javax.inject.Provider
    public OrdersApi get() {
        return provideOrdersApi(this.a.get());
    }
}
