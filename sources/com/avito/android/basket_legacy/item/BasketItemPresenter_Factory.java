package com.avito.android.basket_legacy.item;

import com.avito.android.basket_legacy.utils.CrossClickListener;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class BasketItemPresenter_Factory implements Factory<BasketItemPresenter> {
    public final Provider<CrossClickListener> a;

    public BasketItemPresenter_Factory(Provider<CrossClickListener> provider) {
        this.a = provider;
    }

    public static BasketItemPresenter_Factory create(Provider<CrossClickListener> provider) {
        return new BasketItemPresenter_Factory(provider);
    }

    public static BasketItemPresenter newInstance(CrossClickListener crossClickListener) {
        return new BasketItemPresenter(crossClickListener);
    }

    @Override // javax.inject.Provider
    public BasketItemPresenter get() {
        return newInstance(this.a.get());
    }
}
