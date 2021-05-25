package com.avito.android.tariff.tariff_package_info.viewmodel;

import com.avito.android.tariff.view.TariffBarConverter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class TariffPackageInfoConverterImpl_Factory implements Factory<TariffPackageInfoConverterImpl> {
    public final Provider<TariffBarConverter> a;

    public TariffPackageInfoConverterImpl_Factory(Provider<TariffBarConverter> provider) {
        this.a = provider;
    }

    public static TariffPackageInfoConverterImpl_Factory create(Provider<TariffBarConverter> provider) {
        return new TariffPackageInfoConverterImpl_Factory(provider);
    }

    public static TariffPackageInfoConverterImpl newInstance(TariffBarConverter tariffBarConverter) {
        return new TariffPackageInfoConverterImpl(tariffBarConverter);
    }

    @Override // javax.inject.Provider
    public TariffPackageInfoConverterImpl get() {
        return newInstance(this.a.get());
    }
}
