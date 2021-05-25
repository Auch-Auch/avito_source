package com.avito.android.basket_legacy.di.fees;

import com.avito.android.fees.refactor.PackageApplyInteractor;
import com.avito.android.fees.remote.FeesApi;
import com.avito.android.util.ErrorFormatter;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class FeesBasketModule_ProvidePackageApplyInteractorFactory implements Factory<PackageApplyInteractor> {
    public final FeesBasketModule a;
    public final Provider<String> b;
    public final Provider<FeesApi> c;
    public final Provider<SchedulersFactory> d;
    public final Provider<ErrorFormatter> e;

    public FeesBasketModule_ProvidePackageApplyInteractorFactory(FeesBasketModule feesBasketModule, Provider<String> provider, Provider<FeesApi> provider2, Provider<SchedulersFactory> provider3, Provider<ErrorFormatter> provider4) {
        this.a = feesBasketModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
        this.e = provider4;
    }

    public static FeesBasketModule_ProvidePackageApplyInteractorFactory create(FeesBasketModule feesBasketModule, Provider<String> provider, Provider<FeesApi> provider2, Provider<SchedulersFactory> provider3, Provider<ErrorFormatter> provider4) {
        return new FeesBasketModule_ProvidePackageApplyInteractorFactory(feesBasketModule, provider, provider2, provider3, provider4);
    }

    public static PackageApplyInteractor providePackageApplyInteractor(FeesBasketModule feesBasketModule, String str, FeesApi feesApi, SchedulersFactory schedulersFactory, ErrorFormatter errorFormatter) {
        return (PackageApplyInteractor) Preconditions.checkNotNullFromProvides(feesBasketModule.providePackageApplyInteractor(str, feesApi, schedulersFactory, errorFormatter));
    }

    @Override // javax.inject.Provider
    public PackageApplyInteractor get() {
        return providePackageApplyInteractor(this.a, this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
