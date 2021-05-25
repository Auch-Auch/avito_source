package com.avito.android.tariff.tariff_package_info.recycler.microcategory;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class TariffPackageMicrcategoryBlueprint_Factory implements Factory<TariffPackageMicrcategoryBlueprint> {
    public final Provider<TariffPackageMicrocategoryPresenter> a;

    public TariffPackageMicrcategoryBlueprint_Factory(Provider<TariffPackageMicrocategoryPresenter> provider) {
        this.a = provider;
    }

    public static TariffPackageMicrcategoryBlueprint_Factory create(Provider<TariffPackageMicrocategoryPresenter> provider) {
        return new TariffPackageMicrcategoryBlueprint_Factory(provider);
    }

    public static TariffPackageMicrcategoryBlueprint newInstance(TariffPackageMicrocategoryPresenter tariffPackageMicrocategoryPresenter) {
        return new TariffPackageMicrcategoryBlueprint(tariffPackageMicrocategoryPresenter);
    }

    @Override // javax.inject.Provider
    public TariffPackageMicrcategoryBlueprint get() {
        return newInstance(this.a.get());
    }
}
