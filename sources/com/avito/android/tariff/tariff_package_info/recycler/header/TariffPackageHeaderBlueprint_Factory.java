package com.avito.android.tariff.tariff_package_info.recycler.header;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class TariffPackageHeaderBlueprint_Factory implements Factory<TariffPackageHeaderBlueprint> {
    public final Provider<TariffPackageHeaderPresenter> a;

    public TariffPackageHeaderBlueprint_Factory(Provider<TariffPackageHeaderPresenter> provider) {
        this.a = provider;
    }

    public static TariffPackageHeaderBlueprint_Factory create(Provider<TariffPackageHeaderPresenter> provider) {
        return new TariffPackageHeaderBlueprint_Factory(provider);
    }

    public static TariffPackageHeaderBlueprint newInstance(TariffPackageHeaderPresenter tariffPackageHeaderPresenter) {
        return new TariffPackageHeaderBlueprint(tariffPackageHeaderPresenter);
    }

    @Override // javax.inject.Provider
    public TariffPackageHeaderBlueprint get() {
        return newInstance(this.a.get());
    }
}
