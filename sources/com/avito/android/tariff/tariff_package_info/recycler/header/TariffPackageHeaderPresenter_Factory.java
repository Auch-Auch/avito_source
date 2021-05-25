package com.avito.android.tariff.tariff_package_info.recycler.header;

import dagger.internal.Factory;
public final class TariffPackageHeaderPresenter_Factory implements Factory<TariffPackageHeaderPresenter> {

    public static final class a {
        public static final TariffPackageHeaderPresenter_Factory a = new TariffPackageHeaderPresenter_Factory();
    }

    public static TariffPackageHeaderPresenter_Factory create() {
        return a.a;
    }

    public static TariffPackageHeaderPresenter newInstance() {
        return new TariffPackageHeaderPresenter();
    }

    @Override // javax.inject.Provider
    public TariffPackageHeaderPresenter get() {
        return newInstance();
    }
}
