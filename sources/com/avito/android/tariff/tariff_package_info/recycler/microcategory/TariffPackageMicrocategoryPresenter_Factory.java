package com.avito.android.tariff.tariff_package_info.recycler.microcategory;

import dagger.internal.Factory;
public final class TariffPackageMicrocategoryPresenter_Factory implements Factory<TariffPackageMicrocategoryPresenter> {

    public static final class a {
        public static final TariffPackageMicrocategoryPresenter_Factory a = new TariffPackageMicrocategoryPresenter_Factory();
    }

    public static TariffPackageMicrocategoryPresenter_Factory create() {
        return a.a;
    }

    public static TariffPackageMicrocategoryPresenter newInstance() {
        return new TariffPackageMicrocategoryPresenter();
    }

    @Override // javax.inject.Provider
    public TariffPackageMicrocategoryPresenter get() {
        return newInstance();
    }
}
