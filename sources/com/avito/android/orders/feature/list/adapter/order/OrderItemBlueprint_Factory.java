package com.avito.android.orders.feature.list.adapter.order;

import com.avito.android.util.text.AttributedTextFormatter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class OrderItemBlueprint_Factory implements Factory<OrderItemBlueprint> {
    public final Provider<OrderItemPresenter> a;
    public final Provider<AttributedTextFormatter> b;

    public OrderItemBlueprint_Factory(Provider<OrderItemPresenter> provider, Provider<AttributedTextFormatter> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static OrderItemBlueprint_Factory create(Provider<OrderItemPresenter> provider, Provider<AttributedTextFormatter> provider2) {
        return new OrderItemBlueprint_Factory(provider, provider2);
    }

    public static OrderItemBlueprint newInstance(OrderItemPresenter orderItemPresenter, AttributedTextFormatter attributedTextFormatter) {
        return new OrderItemBlueprint(orderItemPresenter, attributedTextFormatter);
    }

    @Override // javax.inject.Provider
    public OrderItemBlueprint get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
