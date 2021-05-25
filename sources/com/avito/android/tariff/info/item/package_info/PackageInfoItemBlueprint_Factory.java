package com.avito.android.tariff.info.item.package_info;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class PackageInfoItemBlueprint_Factory implements Factory<PackageInfoItemBlueprint> {
    public final Provider<PackageInfoItemPresenter> a;

    public PackageInfoItemBlueprint_Factory(Provider<PackageInfoItemPresenter> provider) {
        this.a = provider;
    }

    public static PackageInfoItemBlueprint_Factory create(Provider<PackageInfoItemPresenter> provider) {
        return new PackageInfoItemBlueprint_Factory(provider);
    }

    public static PackageInfoItemBlueprint newInstance(PackageInfoItemPresenter packageInfoItemPresenter) {
        return new PackageInfoItemBlueprint(packageInfoItemPresenter);
    }

    @Override // javax.inject.Provider
    public PackageInfoItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
