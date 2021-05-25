package com.avito.android.short_term_rent.di.module;

import com.avito.android.blueprints.ButtonItemPresenter;
import com.avito.android.short_term_rent.confirm_booking.StrConfirmBookingViewModel;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class StrConfirmBookingBlueprintsModule_ProvideButtonItemPresenterFactory implements Factory<ButtonItemPresenter> {
    public final Provider<StrConfirmBookingViewModel> a;

    public StrConfirmBookingBlueprintsModule_ProvideButtonItemPresenterFactory(Provider<StrConfirmBookingViewModel> provider) {
        this.a = provider;
    }

    public static StrConfirmBookingBlueprintsModule_ProvideButtonItemPresenterFactory create(Provider<StrConfirmBookingViewModel> provider) {
        return new StrConfirmBookingBlueprintsModule_ProvideButtonItemPresenterFactory(provider);
    }

    public static ButtonItemPresenter provideButtonItemPresenter(Lazy<StrConfirmBookingViewModel> lazy) {
        return (ButtonItemPresenter) Preconditions.checkNotNullFromProvides(StrConfirmBookingBlueprintsModule.provideButtonItemPresenter(lazy));
    }

    @Override // javax.inject.Provider
    public ButtonItemPresenter get() {
        return provideButtonItemPresenter(DoubleCheck.lazy(this.a));
    }
}
