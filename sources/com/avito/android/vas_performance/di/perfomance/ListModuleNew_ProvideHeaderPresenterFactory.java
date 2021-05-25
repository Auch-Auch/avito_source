package com.avito.android.vas_performance.di.perfomance;

import com.avito.android.conveyor_shared_item.paid_services.PaidServiceHeaderItemPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class ListModuleNew_ProvideHeaderPresenterFactory implements Factory<PaidServiceHeaderItemPresenter> {
    public final ListModuleNew a;

    public ListModuleNew_ProvideHeaderPresenterFactory(ListModuleNew listModuleNew) {
        this.a = listModuleNew;
    }

    public static ListModuleNew_ProvideHeaderPresenterFactory create(ListModuleNew listModuleNew) {
        return new ListModuleNew_ProvideHeaderPresenterFactory(listModuleNew);
    }

    public static PaidServiceHeaderItemPresenter provideHeaderPresenter(ListModuleNew listModuleNew) {
        return (PaidServiceHeaderItemPresenter) Preconditions.checkNotNullFromProvides(listModuleNew.provideHeaderPresenter());
    }

    @Override // javax.inject.Provider
    public PaidServiceHeaderItemPresenter get() {
        return provideHeaderPresenter(this.a);
    }
}
