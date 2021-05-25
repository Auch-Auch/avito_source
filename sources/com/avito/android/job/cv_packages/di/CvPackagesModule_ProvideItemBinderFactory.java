package com.avito.android.job.cv_packages.di;

import com.avito.android.job.cv_packages.item.PackageBlueprint;
import com.avito.konveyor.ItemBinder;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class CvPackagesModule_ProvideItemBinderFactory implements Factory<ItemBinder> {
    public final Provider<PackageBlueprint> a;

    public CvPackagesModule_ProvideItemBinderFactory(Provider<PackageBlueprint> provider) {
        this.a = provider;
    }

    public static CvPackagesModule_ProvideItemBinderFactory create(Provider<PackageBlueprint> provider) {
        return new CvPackagesModule_ProvideItemBinderFactory(provider);
    }

    public static ItemBinder provideItemBinder(PackageBlueprint packageBlueprint) {
        return (ItemBinder) Preconditions.checkNotNullFromProvides(CvPackagesModule.provideItemBinder(packageBlueprint));
    }

    @Override // javax.inject.Provider
    public ItemBinder get() {
        return provideItemBinder(this.a.get());
    }
}
