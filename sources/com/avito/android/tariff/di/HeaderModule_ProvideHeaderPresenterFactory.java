package com.avito.android.tariff.di;

import com.avito.android.conveyor_shared_item.paid_services.PaidServiceHeaderItemPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class HeaderModule_ProvideHeaderPresenterFactory implements Factory<PaidServiceHeaderItemPresenter> {

    public static final class a {
        public static final HeaderModule_ProvideHeaderPresenterFactory a = new HeaderModule_ProvideHeaderPresenterFactory();
    }

    public static HeaderModule_ProvideHeaderPresenterFactory create() {
        return a.a;
    }

    public static PaidServiceHeaderItemPresenter provideHeaderPresenter() {
        return (PaidServiceHeaderItemPresenter) Preconditions.checkNotNullFromProvides(HeaderModule.provideHeaderPresenter());
    }

    @Override // javax.inject.Provider
    public PaidServiceHeaderItemPresenter get() {
        return provideHeaderPresenter();
    }
}
