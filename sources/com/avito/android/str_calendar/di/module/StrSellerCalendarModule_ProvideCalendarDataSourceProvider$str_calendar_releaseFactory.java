package com.avito.android.str_calendar.di.module;

import com.avito.android.str_calendar.calendar.view.data.CalendarDataSourceProvider;
import com.avito.android.str_calendar.seller.calendar.model.SellerCalendarInfo;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class StrSellerCalendarModule_ProvideCalendarDataSourceProvider$str_calendar_releaseFactory implements Factory<CalendarDataSourceProvider<SellerCalendarInfo>> {

    public static final class a {
        public static final StrSellerCalendarModule_ProvideCalendarDataSourceProvider$str_calendar_releaseFactory a = new StrSellerCalendarModule_ProvideCalendarDataSourceProvider$str_calendar_releaseFactory();
    }

    public static StrSellerCalendarModule_ProvideCalendarDataSourceProvider$str_calendar_releaseFactory create() {
        return a.a;
    }

    public static CalendarDataSourceProvider<SellerCalendarInfo> provideCalendarDataSourceProvider$str_calendar_release() {
        return (CalendarDataSourceProvider) Preconditions.checkNotNullFromProvides(StrSellerCalendarModule.provideCalendarDataSourceProvider$str_calendar_release());
    }

    @Override // javax.inject.Provider
    public CalendarDataSourceProvider<SellerCalendarInfo> get() {
        return provideCalendarDataSourceProvider$str_calendar_release();
    }
}
