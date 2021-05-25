package com.avito.android.short_term_rent.di.module;

import com.avito.android.short_term_rent.start_booking.utils.StrStartBookingContentsComparator;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class StrStartBookingModule_ProvideContentsComparator$short_term_rent_releaseFactory implements Factory<StrStartBookingContentsComparator> {

    public static final class a {
        public static final StrStartBookingModule_ProvideContentsComparator$short_term_rent_releaseFactory a = new StrStartBookingModule_ProvideContentsComparator$short_term_rent_releaseFactory();
    }

    public static StrStartBookingModule_ProvideContentsComparator$short_term_rent_releaseFactory create() {
        return a.a;
    }

    public static StrStartBookingContentsComparator provideContentsComparator$short_term_rent_release() {
        return (StrStartBookingContentsComparator) Preconditions.checkNotNullFromProvides(StrStartBookingModule.provideContentsComparator$short_term_rent_release());
    }

    @Override // javax.inject.Provider
    public StrStartBookingContentsComparator get() {
        return provideContentsComparator$short_term_rent_release();
    }
}
