package com.avito.android.short_term_rent.di.module;

import com.avito.android.short_term_rent.start_booking.items.disclaimer.DisclaimerItemPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class StrConfirmBookingBlueprintsModule_ProvideDisclaimerItemPresenter$short_term_rent_releaseFactory implements Factory<DisclaimerItemPresenter> {

    public static final class a {
        public static final StrConfirmBookingBlueprintsModule_ProvideDisclaimerItemPresenter$short_term_rent_releaseFactory a = new StrConfirmBookingBlueprintsModule_ProvideDisclaimerItemPresenter$short_term_rent_releaseFactory();
    }

    public static StrConfirmBookingBlueprintsModule_ProvideDisclaimerItemPresenter$short_term_rent_releaseFactory create() {
        return a.a;
    }

    public static DisclaimerItemPresenter provideDisclaimerItemPresenter$short_term_rent_release() {
        return (DisclaimerItemPresenter) Preconditions.checkNotNullFromProvides(StrConfirmBookingBlueprintsModule.provideDisclaimerItemPresenter$short_term_rent_release());
    }

    @Override // javax.inject.Provider
    public DisclaimerItemPresenter get() {
        return provideDisclaimerItemPresenter$short_term_rent_release();
    }
}
