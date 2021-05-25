package com.avito.android.tariff.edit_info.item.prolongation;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class TariffProlongationItemPresenterImpl_Factory implements Factory<TariffProlongationItemPresenterImpl> {
    public final Provider<ResourceProvider> a;

    public TariffProlongationItemPresenterImpl_Factory(Provider<ResourceProvider> provider) {
        this.a = provider;
    }

    public static TariffProlongationItemPresenterImpl_Factory create(Provider<ResourceProvider> provider) {
        return new TariffProlongationItemPresenterImpl_Factory(provider);
    }

    public static TariffProlongationItemPresenterImpl newInstance(ResourceProvider resourceProvider) {
        return new TariffProlongationItemPresenterImpl(resourceProvider);
    }

    @Override // javax.inject.Provider
    public TariffProlongationItemPresenterImpl get() {
        return newInstance(this.a.get());
    }
}
