package com.avito.android.fees.refactor.di;

import com.avito.android.fees.refactor.PackageApplyInteractor;
import com.avito.android.fees.refactor.PackageFeeViewModelFactory;
import com.avito.android.fees.refactor.PackageItemConverter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PackageFeesModule_ProvidePackageFeeViewModelFactoryFactory implements Factory<PackageFeeViewModelFactory> {
    public final PackageFeesModule a;
    public final Provider<PackageItemConverter> b;
    public final Provider<PackageApplyInteractor> c;

    public PackageFeesModule_ProvidePackageFeeViewModelFactoryFactory(PackageFeesModule packageFeesModule, Provider<PackageItemConverter> provider, Provider<PackageApplyInteractor> provider2) {
        this.a = packageFeesModule;
        this.b = provider;
        this.c = provider2;
    }

    public static PackageFeesModule_ProvidePackageFeeViewModelFactoryFactory create(PackageFeesModule packageFeesModule, Provider<PackageItemConverter> provider, Provider<PackageApplyInteractor> provider2) {
        return new PackageFeesModule_ProvidePackageFeeViewModelFactoryFactory(packageFeesModule, provider, provider2);
    }

    public static PackageFeeViewModelFactory providePackageFeeViewModelFactory(PackageFeesModule packageFeesModule, PackageItemConverter packageItemConverter, PackageApplyInteractor packageApplyInteractor) {
        return (PackageFeeViewModelFactory) Preconditions.checkNotNullFromProvides(packageFeesModule.providePackageFeeViewModelFactory(packageItemConverter, packageApplyInteractor));
    }

    @Override // javax.inject.Provider
    public PackageFeeViewModelFactory get() {
        return providePackageFeeViewModelFactory(this.a, this.b.get(), this.c.get());
    }
}
