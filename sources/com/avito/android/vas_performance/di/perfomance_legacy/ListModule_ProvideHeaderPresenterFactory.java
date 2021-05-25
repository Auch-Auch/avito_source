package com.avito.android.vas_performance.di.perfomance_legacy;

import com.avito.android.conveyor_shared_item.paid_services.PaidServiceHeaderItemPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class ListModule_ProvideHeaderPresenterFactory implements Factory<PaidServiceHeaderItemPresenter> {
    public final ListModule a;

    public ListModule_ProvideHeaderPresenterFactory(ListModule listModule) {
        this.a = listModule;
    }

    public static ListModule_ProvideHeaderPresenterFactory create(ListModule listModule) {
        return new ListModule_ProvideHeaderPresenterFactory(listModule);
    }

    public static PaidServiceHeaderItemPresenter provideHeaderPresenter(ListModule listModule) {
        return (PaidServiceHeaderItemPresenter) Preconditions.checkNotNullFromProvides(listModule.provideHeaderPresenter());
    }

    @Override // javax.inject.Provider
    public PaidServiceHeaderItemPresenter get() {
        return provideHeaderPresenter(this.a);
    }
}
