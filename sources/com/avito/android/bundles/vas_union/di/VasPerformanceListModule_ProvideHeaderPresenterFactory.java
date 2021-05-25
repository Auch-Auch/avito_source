package com.avito.android.bundles.vas_union.di;

import com.avito.android.conveyor_shared_item.paid_services.PaidServiceHeaderItemPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class VasPerformanceListModule_ProvideHeaderPresenterFactory implements Factory<PaidServiceHeaderItemPresenter> {
    public final VasPerformanceListModule a;

    public VasPerformanceListModule_ProvideHeaderPresenterFactory(VasPerformanceListModule vasPerformanceListModule) {
        this.a = vasPerformanceListModule;
    }

    public static VasPerformanceListModule_ProvideHeaderPresenterFactory create(VasPerformanceListModule vasPerformanceListModule) {
        return new VasPerformanceListModule_ProvideHeaderPresenterFactory(vasPerformanceListModule);
    }

    public static PaidServiceHeaderItemPresenter provideHeaderPresenter(VasPerformanceListModule vasPerformanceListModule) {
        return (PaidServiceHeaderItemPresenter) Preconditions.checkNotNullFromProvides(vasPerformanceListModule.provideHeaderPresenter());
    }

    @Override // javax.inject.Provider
    public PaidServiceHeaderItemPresenter get() {
        return provideHeaderPresenter(this.a);
    }
}
