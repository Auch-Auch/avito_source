package com.avito.android.short_term_rent.di.module;

import com.avito.android.short_term_rent.confirm_booking.utils.StrConfirmBookingContentsComparator;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class StrConfirmBookingModule_ProvideContentsComparator$short_term_rent_releaseFactory implements Factory<StrConfirmBookingContentsComparator> {

    public static final class a {
        public static final StrConfirmBookingModule_ProvideContentsComparator$short_term_rent_releaseFactory a = new StrConfirmBookingModule_ProvideContentsComparator$short_term_rent_releaseFactory();
    }

    public static StrConfirmBookingModule_ProvideContentsComparator$short_term_rent_releaseFactory create() {
        return a.a;
    }

    public static StrConfirmBookingContentsComparator provideContentsComparator$short_term_rent_release() {
        return (StrConfirmBookingContentsComparator) Preconditions.checkNotNullFromProvides(StrConfirmBookingModule.provideContentsComparator$short_term_rent_release());
    }

    @Override // javax.inject.Provider
    public StrConfirmBookingContentsComparator get() {
        return provideContentsComparator$short_term_rent_release();
    }
}
