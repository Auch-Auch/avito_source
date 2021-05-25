package com.avito.android.fees.di;

import com.avito.android.fees.refactor.PackageApplyInteractor;
import com.avito.android.fees.remote.FeesApi;
import com.avito.android.util.ErrorFormatter;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class FeesActivityModule_ProvidePackageApplyInteractorFactory implements Factory<PackageApplyInteractor> {
    public final FeesActivityModule a;
    public final Provider<FeesApi> b;
    public final Provider<SchedulersFactory> c;
    public final Provider<ErrorFormatter> d;

    public FeesActivityModule_ProvidePackageApplyInteractorFactory(FeesActivityModule feesActivityModule, Provider<FeesApi> provider, Provider<SchedulersFactory> provider2, Provider<ErrorFormatter> provider3) {
        this.a = feesActivityModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
    }

    public static FeesActivityModule_ProvidePackageApplyInteractorFactory create(FeesActivityModule feesActivityModule, Provider<FeesApi> provider, Provider<SchedulersFactory> provider2, Provider<ErrorFormatter> provider3) {
        return new FeesActivityModule_ProvidePackageApplyInteractorFactory(feesActivityModule, provider, provider2, provider3);
    }

    public static PackageApplyInteractor providePackageApplyInteractor(FeesActivityModule feesActivityModule, FeesApi feesApi, SchedulersFactory schedulersFactory, ErrorFormatter errorFormatter) {
        return (PackageApplyInteractor) Preconditions.checkNotNullFromProvides(feesActivityModule.providePackageApplyInteractor(feesApi, schedulersFactory, errorFormatter));
    }

    @Override // javax.inject.Provider
    public PackageApplyInteractor get() {
        return providePackageApplyInteractor(this.a, this.b.get(), this.c.get(), this.d.get());
    }
}
