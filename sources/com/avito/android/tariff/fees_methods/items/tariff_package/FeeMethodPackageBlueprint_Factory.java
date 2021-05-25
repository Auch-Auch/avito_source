package com.avito.android.tariff.fees_methods.items.tariff_package;

import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class FeeMethodPackageBlueprint_Factory implements Factory<FeeMethodPackageBlueprint> {
    public final Provider<FeeMethodPackagePresenter> a;
    public final Provider<AdapterPresenter> b;
    public final Provider<ItemBinder> c;

    public FeeMethodPackageBlueprint_Factory(Provider<FeeMethodPackagePresenter> provider, Provider<AdapterPresenter> provider2, Provider<ItemBinder> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static FeeMethodPackageBlueprint_Factory create(Provider<FeeMethodPackagePresenter> provider, Provider<AdapterPresenter> provider2, Provider<ItemBinder> provider3) {
        return new FeeMethodPackageBlueprint_Factory(provider, provider2, provider3);
    }

    public static FeeMethodPackageBlueprint newInstance(FeeMethodPackagePresenter feeMethodPackagePresenter, AdapterPresenter adapterPresenter, ItemBinder itemBinder) {
        return new FeeMethodPackageBlueprint(feeMethodPackagePresenter, adapterPresenter, itemBinder);
    }

    @Override // javax.inject.Provider
    public FeeMethodPackageBlueprint get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
