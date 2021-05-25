package com.avito.android.tariff.tariff_package_info.recycler;

import dagger.internal.Factory;
public final class TariffPackagePresenter_Factory implements Factory<TariffPackagePresenter> {

    public static final class a {
        public static final TariffPackagePresenter_Factory a = new TariffPackagePresenter_Factory();
    }

    public static TariffPackagePresenter_Factory create() {
        return a.a;
    }

    public static TariffPackagePresenter newInstance() {
        return new TariffPackagePresenter();
    }

    @Override // javax.inject.Provider
    public TariffPackagePresenter get() {
        return newInstance();
    }
}
