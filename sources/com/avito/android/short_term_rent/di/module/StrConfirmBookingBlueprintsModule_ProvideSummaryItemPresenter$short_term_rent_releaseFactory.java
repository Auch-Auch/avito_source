package com.avito.android.short_term_rent.di.module;

import com.avito.android.short_term_rent.start_booking.items.summary.SummaryItemPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class StrConfirmBookingBlueprintsModule_ProvideSummaryItemPresenter$short_term_rent_releaseFactory implements Factory<SummaryItemPresenter> {

    public static final class a {
        public static final StrConfirmBookingBlueprintsModule_ProvideSummaryItemPresenter$short_term_rent_releaseFactory a = new StrConfirmBookingBlueprintsModule_ProvideSummaryItemPresenter$short_term_rent_releaseFactory();
    }

    public static StrConfirmBookingBlueprintsModule_ProvideSummaryItemPresenter$short_term_rent_releaseFactory create() {
        return a.a;
    }

    public static SummaryItemPresenter provideSummaryItemPresenter$short_term_rent_release() {
        return (SummaryItemPresenter) Preconditions.checkNotNullFromProvides(StrConfirmBookingBlueprintsModule.provideSummaryItemPresenter$short_term_rent_release());
    }

    @Override // javax.inject.Provider
    public SummaryItemPresenter get() {
        return provideSummaryItemPresenter$short_term_rent_release();
    }
}
