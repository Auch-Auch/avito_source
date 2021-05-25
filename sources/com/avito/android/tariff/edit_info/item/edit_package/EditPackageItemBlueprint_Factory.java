package com.avito.android.tariff.edit_info.item.edit_package;

import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class EditPackageItemBlueprint_Factory implements Factory<EditPackageItemBlueprint> {
    public final Provider<EditPackageItemPresenter> a;
    public final Provider<AdapterPresenter> b;
    public final Provider<ItemBinder> c;

    public EditPackageItemBlueprint_Factory(Provider<EditPackageItemPresenter> provider, Provider<AdapterPresenter> provider2, Provider<ItemBinder> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static EditPackageItemBlueprint_Factory create(Provider<EditPackageItemPresenter> provider, Provider<AdapterPresenter> provider2, Provider<ItemBinder> provider3) {
        return new EditPackageItemBlueprint_Factory(provider, provider2, provider3);
    }

    public static EditPackageItemBlueprint newInstance(EditPackageItemPresenter editPackageItemPresenter, AdapterPresenter adapterPresenter, ItemBinder itemBinder) {
        return new EditPackageItemBlueprint(editPackageItemPresenter, adapterPresenter, itemBinder);
    }

    @Override // javax.inject.Provider
    public EditPackageItemBlueprint get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
