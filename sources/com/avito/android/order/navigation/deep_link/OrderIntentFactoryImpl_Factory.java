package com.avito.android.order.navigation.deep_link;

import com.avito.android.CoreActivityIntentFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class OrderIntentFactoryImpl_Factory implements Factory<OrderIntentFactoryImpl> {
    public final Provider<CoreActivityIntentFactory> a;

    public OrderIntentFactoryImpl_Factory(Provider<CoreActivityIntentFactory> provider) {
        this.a = provider;
    }

    public static OrderIntentFactoryImpl_Factory create(Provider<CoreActivityIntentFactory> provider) {
        return new OrderIntentFactoryImpl_Factory(provider);
    }

    public static OrderIntentFactoryImpl newInstance(CoreActivityIntentFactory coreActivityIntentFactory) {
        return new OrderIntentFactoryImpl(coreActivityIntentFactory);
    }

    @Override // javax.inject.Provider
    public OrderIntentFactoryImpl get() {
        return newInstance(this.a.get());
    }
}
