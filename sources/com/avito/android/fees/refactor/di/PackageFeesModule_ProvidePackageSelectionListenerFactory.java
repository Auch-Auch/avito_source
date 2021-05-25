package com.avito.android.fees.refactor.di;

import com.avito.android.fees.refactor.PackageSelectionListener;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class PackageFeesModule_ProvidePackageSelectionListenerFactory implements Factory<PackageSelectionListener> {
    public final PackageFeesModule a;

    public PackageFeesModule_ProvidePackageSelectionListenerFactory(PackageFeesModule packageFeesModule) {
        this.a = packageFeesModule;
    }

    public static PackageFeesModule_ProvidePackageSelectionListenerFactory create(PackageFeesModule packageFeesModule) {
        return new PackageFeesModule_ProvidePackageSelectionListenerFactory(packageFeesModule);
    }

    public static PackageSelectionListener providePackageSelectionListener(PackageFeesModule packageFeesModule) {
        return (PackageSelectionListener) Preconditions.checkNotNullFromProvides(packageFeesModule.providePackageSelectionListener());
    }

    @Override // javax.inject.Provider
    public PackageSelectionListener get() {
        return providePackageSelectionListener(this.a);
    }
}
