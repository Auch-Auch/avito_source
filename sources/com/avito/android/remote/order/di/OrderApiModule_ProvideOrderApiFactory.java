package com.avito.android.remote.order.di;

import com.avito.android.remote.RetrofitFactory;
import com.avito.android.remote.order.OrderApi;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class OrderApiModule_ProvideOrderApiFactory implements Factory<OrderApi> {
    public final Provider<RetrofitFactory> a;

    public OrderApiModule_ProvideOrderApiFactory(Provider<RetrofitFactory> provider) {
        this.a = provider;
    }

    public static OrderApiModule_ProvideOrderApiFactory create(Provider<RetrofitFactory> provider) {
        return new OrderApiModule_ProvideOrderApiFactory(provider);
    }

    public static OrderApi provideOrderApi(RetrofitFactory retrofitFactory) {
        return (OrderApi) Preconditions.checkNotNullFromProvides(OrderApiModule.INSTANCE.provideOrderApi(retrofitFactory));
    }

    @Override // javax.inject.Provider
    public OrderApi get() {
        return provideOrderApi(this.a.get());
    }
}
