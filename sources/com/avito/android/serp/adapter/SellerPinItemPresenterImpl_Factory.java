package com.avito.android.serp.adapter;

import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SellerPinItemPresenterImpl_Factory implements Factory<SellerPinItemPresenterImpl> {
    public final Provider<SellerItemListener> a;

    public SellerPinItemPresenterImpl_Factory(Provider<SellerItemListener> provider) {
        this.a = provider;
    }

    public static SellerPinItemPresenterImpl_Factory create(Provider<SellerItemListener> provider) {
        return new SellerPinItemPresenterImpl_Factory(provider);
    }

    public static SellerPinItemPresenterImpl newInstance(Lazy<SellerItemListener> lazy) {
        return new SellerPinItemPresenterImpl(lazy);
    }

    @Override // javax.inject.Provider
    public SellerPinItemPresenterImpl get() {
        return newInstance(DoubleCheck.lazy(this.a));
    }
}
