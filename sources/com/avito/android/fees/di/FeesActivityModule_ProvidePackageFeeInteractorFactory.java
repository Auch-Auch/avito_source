package com.avito.android.fees.di;

import com.avito.android.fees.PackageFeeInteractor;
import com.avito.android.fees.remote.FeesApi;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class FeesActivityModule_ProvidePackageFeeInteractorFactory implements Factory<PackageFeeInteractor> {
    public final FeesActivityModule a;
    public final Provider<FeesApi> b;

    public FeesActivityModule_ProvidePackageFeeInteractorFactory(FeesActivityModule feesActivityModule, Provider<FeesApi> provider) {
        this.a = feesActivityModule;
        this.b = provider;
    }

    public static FeesActivityModule_ProvidePackageFeeInteractorFactory create(FeesActivityModule feesActivityModule, Provider<FeesApi> provider) {
        return new FeesActivityModule_ProvidePackageFeeInteractorFactory(feesActivityModule, provider);
    }

    public static PackageFeeInteractor providePackageFeeInteractor(FeesActivityModule feesActivityModule, FeesApi feesApi) {
        return (PackageFeeInteractor) Preconditions.checkNotNullFromProvides(feesActivityModule.providePackageFeeInteractor(feesApi));
    }

    @Override // javax.inject.Provider
    public PackageFeeInteractor get() {
        return providePackageFeeInteractor(this.a, this.b.get());
    }
}
