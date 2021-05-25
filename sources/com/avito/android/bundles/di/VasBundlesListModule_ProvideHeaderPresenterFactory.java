package com.avito.android.bundles.di;

import com.avito.android.conveyor_shared_item.paid_services.PaidServiceHeaderItemPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class VasBundlesListModule_ProvideHeaderPresenterFactory implements Factory<PaidServiceHeaderItemPresenter> {

    public static final class a {
        public static final VasBundlesListModule_ProvideHeaderPresenterFactory a = new VasBundlesListModule_ProvideHeaderPresenterFactory();
    }

    public static VasBundlesListModule_ProvideHeaderPresenterFactory create() {
        return a.a;
    }

    public static PaidServiceHeaderItemPresenter provideHeaderPresenter() {
        return (PaidServiceHeaderItemPresenter) Preconditions.checkNotNullFromProvides(VasBundlesListModule.provideHeaderPresenter());
    }

    @Override // javax.inject.Provider
    public PaidServiceHeaderItemPresenter get() {
        return provideHeaderPresenter();
    }
}
