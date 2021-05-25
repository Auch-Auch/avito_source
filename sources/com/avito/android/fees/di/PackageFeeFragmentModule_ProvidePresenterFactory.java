package com.avito.android.fees.di;

import com.avito.android.fees.PackageFeeInteractor;
import com.avito.android.fees.PackageFeePresenter;
import com.avito.android.util.ErrorFormatter;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PackageFeeFragmentModule_ProvidePresenterFactory implements Factory<PackageFeePresenter> {
    public final PackageFeeFragmentModule a;
    public final Provider<PackageFeeInteractor> b;
    public final Provider<SchedulersFactory> c;
    public final Provider<ErrorFormatter> d;

    public PackageFeeFragmentModule_ProvidePresenterFactory(PackageFeeFragmentModule packageFeeFragmentModule, Provider<PackageFeeInteractor> provider, Provider<SchedulersFactory> provider2, Provider<ErrorFormatter> provider3) {
        this.a = packageFeeFragmentModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
    }

    public static PackageFeeFragmentModule_ProvidePresenterFactory create(PackageFeeFragmentModule packageFeeFragmentModule, Provider<PackageFeeInteractor> provider, Provider<SchedulersFactory> provider2, Provider<ErrorFormatter> provider3) {
        return new PackageFeeFragmentModule_ProvidePresenterFactory(packageFeeFragmentModule, provider, provider2, provider3);
    }

    public static PackageFeePresenter providePresenter(PackageFeeFragmentModule packageFeeFragmentModule, PackageFeeInteractor packageFeeInteractor, SchedulersFactory schedulersFactory, ErrorFormatter errorFormatter) {
        return (PackageFeePresenter) Preconditions.checkNotNullFromProvides(packageFeeFragmentModule.providePresenter(packageFeeInteractor, schedulersFactory, errorFormatter));
    }

    @Override // javax.inject.Provider
    public PackageFeePresenter get() {
        return providePresenter(this.a, this.b.get(), this.c.get(), this.d.get());
    }
}
