package com.avito.android.str_calendar.di.module;

import com.avito.android.str_calendar.calendar.view.konveyor.items.month.MonthItemPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class StrCalendarRecyclerCommon_ProvideMonthItemPresenter$str_calendar_releaseFactory implements Factory<MonthItemPresenter> {

    public static final class a {
        public static final StrCalendarRecyclerCommon_ProvideMonthItemPresenter$str_calendar_releaseFactory a = new StrCalendarRecyclerCommon_ProvideMonthItemPresenter$str_calendar_releaseFactory();
    }

    public static StrCalendarRecyclerCommon_ProvideMonthItemPresenter$str_calendar_releaseFactory create() {
        return a.a;
    }

    public static MonthItemPresenter provideMonthItemPresenter$str_calendar_release() {
        return (MonthItemPresenter) Preconditions.checkNotNullFromProvides(StrCalendarRecyclerCommon.provideMonthItemPresenter$str_calendar_release());
    }

    @Override // javax.inject.Provider
    public MonthItemPresenter get() {
        return provideMonthItemPresenter$str_calendar_release();
    }
}
