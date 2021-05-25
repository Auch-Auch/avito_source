package com.avito.android.safedeal.delivery_type.items.button;

import com.avito.android.safedeal.delivery_type.DeliveryTypePresenter;
import com.avito.android.util.text.AttributedTextFormatter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ButtonPresenterImpl_Factory implements Factory<ButtonPresenterImpl> {
    public final Provider<DeliveryTypePresenter> a;
    public final Provider<AttributedTextFormatter> b;

    public ButtonPresenterImpl_Factory(Provider<DeliveryTypePresenter> provider, Provider<AttributedTextFormatter> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static ButtonPresenterImpl_Factory create(Provider<DeliveryTypePresenter> provider, Provider<AttributedTextFormatter> provider2) {
        return new ButtonPresenterImpl_Factory(provider, provider2);
    }

    public static ButtonPresenterImpl newInstance(DeliveryTypePresenter deliveryTypePresenter, AttributedTextFormatter attributedTextFormatter) {
        return new ButtonPresenterImpl(deliveryTypePresenter, attributedTextFormatter);
    }

    @Override // javax.inject.Provider
    public ButtonPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
