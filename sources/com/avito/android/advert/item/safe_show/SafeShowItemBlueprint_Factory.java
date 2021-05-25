package com.avito.android.advert.item.safe_show;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class SafeShowItemBlueprint_Factory implements Factory<SafeShowItemBlueprint> {
    public final Provider<SafeShowItemPresenter> a;
    public final Provider<SafeShowAdvertDetailsDialogFactory> b;

    public SafeShowItemBlueprint_Factory(Provider<SafeShowItemPresenter> provider, Provider<SafeShowAdvertDetailsDialogFactory> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static SafeShowItemBlueprint_Factory create(Provider<SafeShowItemPresenter> provider, Provider<SafeShowAdvertDetailsDialogFactory> provider2) {
        return new SafeShowItemBlueprint_Factory(provider, provider2);
    }

    public static SafeShowItemBlueprint newInstance(SafeShowItemPresenter safeShowItemPresenter, SafeShowAdvertDetailsDialogFactory safeShowAdvertDetailsDialogFactory) {
        return new SafeShowItemBlueprint(safeShowItemPresenter, safeShowAdvertDetailsDialogFactory);
    }

    @Override // javax.inject.Provider
    public SafeShowItemBlueprint get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
