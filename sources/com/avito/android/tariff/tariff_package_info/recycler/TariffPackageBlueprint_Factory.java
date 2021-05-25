package com.avito.android.tariff.tariff_package_info.recycler;

import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class TariffPackageBlueprint_Factory implements Factory<TariffPackageBlueprint> {
    public final Provider<TariffPackagePresenter> a;
    public final Provider<ItemBinder> b;
    public final Provider<AdapterPresenter> c;

    public TariffPackageBlueprint_Factory(Provider<TariffPackagePresenter> provider, Provider<ItemBinder> provider2, Provider<AdapterPresenter> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static TariffPackageBlueprint_Factory create(Provider<TariffPackagePresenter> provider, Provider<ItemBinder> provider2, Provider<AdapterPresenter> provider3) {
        return new TariffPackageBlueprint_Factory(provider, provider2, provider3);
    }

    public static TariffPackageBlueprint newInstance(TariffPackagePresenter tariffPackagePresenter, ItemBinder itemBinder, AdapterPresenter adapterPresenter) {
        return new TariffPackageBlueprint(tariffPackagePresenter, itemBinder, adapterPresenter);
    }

    @Override // javax.inject.Provider
    public TariffPackageBlueprint get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
