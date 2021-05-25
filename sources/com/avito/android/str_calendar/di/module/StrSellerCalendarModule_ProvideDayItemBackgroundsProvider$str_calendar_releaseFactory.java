package com.avito.android.str_calendar.di.module;

import com.avito.android.str_calendar.calendar.view.konveyor.items.day.seller.SellerDayItemBackgroundsProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class StrSellerCalendarModule_ProvideDayItemBackgroundsProvider$str_calendar_releaseFactory implements Factory<SellerDayItemBackgroundsProvider> {

    public static final class a {
        public static final StrSellerCalendarModule_ProvideDayItemBackgroundsProvider$str_calendar_releaseFactory a = new StrSellerCalendarModule_ProvideDayItemBackgroundsProvider$str_calendar_releaseFactory();
    }

    public static StrSellerCalendarModule_ProvideDayItemBackgroundsProvider$str_calendar_releaseFactory create() {
        return a.a;
    }

    public static SellerDayItemBackgroundsProvider provideDayItemBackgroundsProvider$str_calendar_release() {
        return (SellerDayItemBackgroundsProvider) Preconditions.checkNotNullFromProvides(StrSellerCalendarModule.provideDayItemBackgroundsProvider$str_calendar_release());
    }

    @Override // javax.inject.Provider
    public SellerDayItemBackgroundsProvider get() {
        return provideDayItemBackgroundsProvider$str_calendar_release();
    }
}
