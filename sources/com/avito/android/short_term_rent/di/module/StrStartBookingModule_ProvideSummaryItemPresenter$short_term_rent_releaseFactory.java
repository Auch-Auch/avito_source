package com.avito.android.short_term_rent.di.module;

import com.avito.android.short_term_rent.start_booking.items.summary.SummaryItemPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class StrStartBookingModule_ProvideSummaryItemPresenter$short_term_rent_releaseFactory implements Factory<SummaryItemPresenter> {

    public static final class a {
        public static final StrStartBookingModule_ProvideSummaryItemPresenter$short_term_rent_releaseFactory a = new StrStartBookingModule_ProvideSummaryItemPresenter$short_term_rent_releaseFactory();
    }

    public static StrStartBookingModule_ProvideSummaryItemPresenter$short_term_rent_releaseFactory create() {
        return a.a;
    }

    public static SummaryItemPresenter provideSummaryItemPresenter$short_term_rent_release() {
        return (SummaryItemPresenter) Preconditions.checkNotNullFromProvides(StrStartBookingModule.provideSummaryItemPresenter$short_term_rent_release());
    }

    @Override // javax.inject.Provider
    public SummaryItemPresenter get() {
        return provideSummaryItemPresenter$short_term_rent_release();
    }
}
