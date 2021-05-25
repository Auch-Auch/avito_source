package com.avito.android.vas_performance.di.visual_legacy;

import com.avito.android.conveyor_shared_item.paid_services.PaidServiceHeaderItemPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class VasListModule_ProvideHeaderPresenterFactory implements Factory<PaidServiceHeaderItemPresenter> {
    public final VasListModule a;

    public VasListModule_ProvideHeaderPresenterFactory(VasListModule vasListModule) {
        this.a = vasListModule;
    }

    public static VasListModule_ProvideHeaderPresenterFactory create(VasListModule vasListModule) {
        return new VasListModule_ProvideHeaderPresenterFactory(vasListModule);
    }

    public static PaidServiceHeaderItemPresenter provideHeaderPresenter(VasListModule vasListModule) {
        return (PaidServiceHeaderItemPresenter) Preconditions.checkNotNullFromProvides(vasListModule.provideHeaderPresenter());
    }

    @Override // javax.inject.Provider
    public PaidServiceHeaderItemPresenter get() {
        return provideHeaderPresenter(this.a);
    }
}
