package com.avito.android.fees.di;

import com.avito.android.fees.PackageFeeInteractor;
import com.avito.android.fees.remote.FeesApi;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PackageFeeFragmentModule_ProvidePackageFeeInteractorFactory implements Factory<PackageFeeInteractor> {
    public final PackageFeeFragmentModule a;
    public final Provider<FeesApi> b;

    public PackageFeeFragmentModule_ProvidePackageFeeInteractorFactory(PackageFeeFragmentModule packageFeeFragmentModule, Provider<FeesApi> provider) {
        this.a = packageFeeFragmentModule;
        this.b = provider;
    }

    public static PackageFeeFragmentModule_ProvidePackageFeeInteractorFactory create(PackageFeeFragmentModule packageFeeFragmentModule, Provider<FeesApi> provider) {
        return new PackageFeeFragmentModule_ProvidePackageFeeInteractorFactory(packageFeeFragmentModule, provider);
    }

    public static PackageFeeInteractor providePackageFeeInteractor(PackageFeeFragmentModule packageFeeFragmentModule, FeesApi feesApi) {
        return (PackageFeeInteractor) Preconditions.checkNotNullFromProvides(packageFeeFragmentModule.providePackageFeeInteractor(feesApi));
    }

    @Override // javax.inject.Provider
    public PackageFeeInteractor get() {
        return providePackageFeeInteractor(this.a, this.b.get());
    }
}
