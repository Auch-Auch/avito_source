package com.avito.android.basket.checkout.viewmodel;

import com.avito.android.tariff.view.TariffBarConverter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class CheckoutCommitConverterImpl_Factory implements Factory<CheckoutCommitConverterImpl> {
    public final Provider<TariffBarConverter> a;

    public CheckoutCommitConverterImpl_Factory(Provider<TariffBarConverter> provider) {
        this.a = provider;
    }

    public static CheckoutCommitConverterImpl_Factory create(Provider<TariffBarConverter> provider) {
        return new CheckoutCommitConverterImpl_Factory(provider);
    }

    public static CheckoutCommitConverterImpl newInstance(TariffBarConverter tariffBarConverter) {
        return new CheckoutCommitConverterImpl(tariffBarConverter);
    }

    @Override // javax.inject.Provider
    public CheckoutCommitConverterImpl get() {
        return newInstance(this.a.get());
    }
}
