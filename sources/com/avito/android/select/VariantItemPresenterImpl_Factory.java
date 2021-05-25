package com.avito.android.select;

import com.avito.android.select.VariantItemPresenter;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class VariantItemPresenterImpl_Factory implements Factory<VariantItemPresenterImpl> {
    public final Provider<VariantItemPresenter.Listener> a;

    public VariantItemPresenterImpl_Factory(Provider<VariantItemPresenter.Listener> provider) {
        this.a = provider;
    }

    public static VariantItemPresenterImpl_Factory create(Provider<VariantItemPresenter.Listener> provider) {
        return new VariantItemPresenterImpl_Factory(provider);
    }

    public static VariantItemPresenterImpl newInstance(Lazy<VariantItemPresenter.Listener> lazy) {
        return new VariantItemPresenterImpl(lazy);
    }

    @Override // javax.inject.Provider
    public VariantItemPresenterImpl get() {
        return newInstance(DoubleCheck.lazy(this.a));
    }
}
