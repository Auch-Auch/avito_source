package com.avito.android.fees.refactor.di;

import com.avito.android.fees.refactor.PackageFeeViewModel;
import com.avito.android.fees.refactor.PackageFeeViewModelFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PackageFeesModule_ProvidePackageFeeViewModelFactory implements Factory<PackageFeeViewModel> {
    public final PackageFeesModule a;
    public final Provider<PackageFeeViewModelFactory> b;

    public PackageFeesModule_ProvidePackageFeeViewModelFactory(PackageFeesModule packageFeesModule, Provider<PackageFeeViewModelFactory> provider) {
        this.a = packageFeesModule;
        this.b = provider;
    }

    public static PackageFeesModule_ProvidePackageFeeViewModelFactory create(PackageFeesModule packageFeesModule, Provider<PackageFeeViewModelFactory> provider) {
        return new PackageFeesModule_ProvidePackageFeeViewModelFactory(packageFeesModule, provider);
    }

    public static PackageFeeViewModel providePackageFeeViewModel(PackageFeesModule packageFeesModule, PackageFeeViewModelFactory packageFeeViewModelFactory) {
        return (PackageFeeViewModel) Preconditions.checkNotNullFromProvides(packageFeesModule.providePackageFeeViewModel(packageFeeViewModelFactory));
    }

    @Override // javax.inject.Provider
    public PackageFeeViewModel get() {
        return providePackageFeeViewModel(this.a, this.b.get());
    }
}
