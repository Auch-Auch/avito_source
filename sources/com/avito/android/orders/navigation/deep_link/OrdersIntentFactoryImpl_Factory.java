package com.avito.android.orders.navigation.deep_link;

import com.avito.android.CoreActivityIntentFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class OrdersIntentFactoryImpl_Factory implements Factory<OrdersIntentFactoryImpl> {
    public final Provider<CoreActivityIntentFactory> a;

    public OrdersIntentFactoryImpl_Factory(Provider<CoreActivityIntentFactory> provider) {
        this.a = provider;
    }

    public static OrdersIntentFactoryImpl_Factory create(Provider<CoreActivityIntentFactory> provider) {
        return new OrdersIntentFactoryImpl_Factory(provider);
    }

    public static OrdersIntentFactoryImpl newInstance(CoreActivityIntentFactory coreActivityIntentFactory) {
        return new OrdersIntentFactoryImpl(coreActivityIntentFactory);
    }

    @Override // javax.inject.Provider
    public OrdersIntentFactoryImpl get() {
        return newInstance(this.a.get());
    }
}
