package com.avito.android.tariff.info.item.package_title;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class PackageTitleItemBlueprint_Factory implements Factory<PackageTitleItemBlueprint> {
    public final Provider<PackageTitleItemPresenter> a;

    public PackageTitleItemBlueprint_Factory(Provider<PackageTitleItemPresenter> provider) {
        this.a = provider;
    }

    public static PackageTitleItemBlueprint_Factory create(Provider<PackageTitleItemPresenter> provider) {
        return new PackageTitleItemBlueprint_Factory(provider);
    }

    public static PackageTitleItemBlueprint newInstance(PackageTitleItemPresenter packageTitleItemPresenter) {
        return new PackageTitleItemBlueprint(packageTitleItemPresenter);
    }

    @Override // javax.inject.Provider
    public PackageTitleItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
