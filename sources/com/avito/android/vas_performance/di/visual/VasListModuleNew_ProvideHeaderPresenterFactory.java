package com.avito.android.vas_performance.di.visual;

import com.avito.android.conveyor_shared_item.paid_services.PaidServiceHeaderItemPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class VasListModuleNew_ProvideHeaderPresenterFactory implements Factory<PaidServiceHeaderItemPresenter> {
    public final VasListModuleNew a;

    public VasListModuleNew_ProvideHeaderPresenterFactory(VasListModuleNew vasListModuleNew) {
        this.a = vasListModuleNew;
    }

    public static VasListModuleNew_ProvideHeaderPresenterFactory create(VasListModuleNew vasListModuleNew) {
        return new VasListModuleNew_ProvideHeaderPresenterFactory(vasListModuleNew);
    }

    public static PaidServiceHeaderItemPresenter provideHeaderPresenter(VasListModuleNew vasListModuleNew) {
        return (PaidServiceHeaderItemPresenter) Preconditions.checkNotNullFromProvides(vasListModuleNew.provideHeaderPresenter());
    }

    @Override // javax.inject.Provider
    public PaidServiceHeaderItemPresenter get() {
        return provideHeaderPresenter(this.a);
    }
}
