package com.avito.android.str_calendar.di.module;

import com.avito.android.str_calendar.calendar.view.konveyor.items.empty.EmptyItemPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class StrCalendarRecyclerCommon_ProvideEmptyItemPresenter$str_calendar_releaseFactory implements Factory<EmptyItemPresenter> {

    public static final class a {
        public static final StrCalendarRecyclerCommon_ProvideEmptyItemPresenter$str_calendar_releaseFactory a = new StrCalendarRecyclerCommon_ProvideEmptyItemPresenter$str_calendar_releaseFactory();
    }

    public static StrCalendarRecyclerCommon_ProvideEmptyItemPresenter$str_calendar_releaseFactory create() {
        return a.a;
    }

    public static EmptyItemPresenter provideEmptyItemPresenter$str_calendar_release() {
        return (EmptyItemPresenter) Preconditions.checkNotNullFromProvides(StrCalendarRecyclerCommon.provideEmptyItemPresenter$str_calendar_release());
    }

    @Override // javax.inject.Provider
    public EmptyItemPresenter get() {
        return provideEmptyItemPresenter$str_calendar_release();
    }
}
