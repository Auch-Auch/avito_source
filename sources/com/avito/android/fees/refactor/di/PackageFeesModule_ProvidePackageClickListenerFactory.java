package com.avito.android.fees.refactor.di;

import com.avito.android.fees.refactor.PackageClickListener;
import com.avito.android.fees.refactor.PackageFeeViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PackageFeesModule_ProvidePackageClickListenerFactory implements Factory<PackageClickListener> {
    public final PackageFeesModule a;
    public final Provider<PackageFeeViewModel> b;

    public PackageFeesModule_ProvidePackageClickListenerFactory(PackageFeesModule packageFeesModule, Provider<PackageFeeViewModel> provider) {
        this.a = packageFeesModule;
        this.b = provider;
    }

    public static PackageFeesModule_ProvidePackageClickListenerFactory create(PackageFeesModule packageFeesModule, Provider<PackageFeeViewModel> provider) {
        return new PackageFeesModule_ProvidePackageClickListenerFactory(packageFeesModule, provider);
    }

    public static PackageClickListener providePackageClickListener(PackageFeesModule packageFeesModule, PackageFeeViewModel packageFeeViewModel) {
        return (PackageClickListener) Preconditions.checkNotNullFromProvides(packageFeesModule.providePackageClickListener(packageFeeViewModel));
    }

    @Override // javax.inject.Provider
    public PackageClickListener get() {
        return providePackageClickListener(this.a, this.b.get());
    }
}
