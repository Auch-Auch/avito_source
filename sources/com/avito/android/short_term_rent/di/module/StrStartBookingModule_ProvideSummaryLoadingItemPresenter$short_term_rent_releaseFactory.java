package com.avito.android.short_term_rent.di.module;

import com.avito.android.short_term_rent.start_booking.items.summary.loading.SummaryLoadingItemPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class StrStartBookingModule_ProvideSummaryLoadingItemPresenter$short_term_rent_releaseFactory implements Factory<SummaryLoadingItemPresenter> {

    public static final class a {
        public static final StrStartBookingModule_ProvideSummaryLoadingItemPresenter$short_term_rent_releaseFactory a = new StrStartBookingModule_ProvideSummaryLoadingItemPresenter$short_term_rent_releaseFactory();
    }

    public static StrStartBookingModule_ProvideSummaryLoadingItemPresenter$short_term_rent_releaseFactory create() {
        return a.a;
    }

    public static SummaryLoadingItemPresenter provideSummaryLoadingItemPresenter$short_term_rent_release() {
        return (SummaryLoadingItemPresenter) Preconditions.checkNotNullFromProvides(StrStartBookingModule.provideSummaryLoadingItemPresenter$short_term_rent_release());
    }

    @Override // javax.inject.Provider
    public SummaryLoadingItemPresenter get() {
        return provideSummaryLoadingItemPresenter$short_term_rent_release();
    }
}
