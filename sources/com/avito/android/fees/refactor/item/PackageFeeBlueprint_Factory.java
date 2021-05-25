package com.avito.android.fees.refactor.item;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class PackageFeeBlueprint_Factory implements Factory<PackageFeeBlueprint> {
    public final Provider<PackageItemPresenter> a;

    public PackageFeeBlueprint_Factory(Provider<PackageItemPresenter> provider) {
        this.a = provider;
    }

    public static PackageFeeBlueprint_Factory create(Provider<PackageItemPresenter> provider) {
        return new PackageFeeBlueprint_Factory(provider);
    }

    public static PackageFeeBlueprint newInstance(PackageItemPresenter packageItemPresenter) {
        return new PackageFeeBlueprint(packageItemPresenter);
    }

    @Override // javax.inject.Provider
    public PackageFeeBlueprint get() {
        return newInstance(this.a.get());
    }
}
