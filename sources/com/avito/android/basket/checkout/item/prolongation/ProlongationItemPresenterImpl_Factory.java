package com.avito.android.basket.checkout.item.prolongation;

import com.avito.android.basket.checkout.ResourceProvider;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ProlongationItemPresenterImpl_Factory implements Factory<ProlongationItemPresenterImpl> {
    public final Provider<ResourceProvider> a;

    public ProlongationItemPresenterImpl_Factory(Provider<ResourceProvider> provider) {
        this.a = provider;
    }

    public static ProlongationItemPresenterImpl_Factory create(Provider<ResourceProvider> provider) {
        return new ProlongationItemPresenterImpl_Factory(provider);
    }

    public static ProlongationItemPresenterImpl newInstance(ResourceProvider resourceProvider) {
        return new ProlongationItemPresenterImpl(resourceProvider);
    }

    @Override // javax.inject.Provider
    public ProlongationItemPresenterImpl get() {
        return newInstance(this.a.get());
    }
}
