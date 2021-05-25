package com.avito.android.fees.refactor.di;

import com.avito.android.fees.refactor.PackageItemConverter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class PackageFeesModule_ProvidePackageItemConverterFactory implements Factory<PackageItemConverter> {
    public final PackageFeesModule a;

    public PackageFeesModule_ProvidePackageItemConverterFactory(PackageFeesModule packageFeesModule) {
        this.a = packageFeesModule;
    }

    public static PackageFeesModule_ProvidePackageItemConverterFactory create(PackageFeesModule packageFeesModule) {
        return new PackageFeesModule_ProvidePackageItemConverterFactory(packageFeesModule);
    }

    public static PackageItemConverter providePackageItemConverter(PackageFeesModule packageFeesModule) {
        return (PackageItemConverter) Preconditions.checkNotNullFromProvides(packageFeesModule.providePackageItemConverter());
    }

    @Override // javax.inject.Provider
    public PackageItemConverter get() {
        return providePackageItemConverter(this.a);
    }
}
