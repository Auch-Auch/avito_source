package com.avito.android.str_calendar.di.module;

import com.avito.android.str_calendar.calendar.view.konveyor.items.month.MonthItemBlueprint;
import com.avito.android.str_calendar.calendar.view.konveyor.items.month.MonthItemPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class StrCalendarRecyclerCommon_ProvideMonthItemBlueprint$str_calendar_releaseFactory implements Factory<MonthItemBlueprint> {
    public final Provider<MonthItemPresenter> a;

    public StrCalendarRecyclerCommon_ProvideMonthItemBlueprint$str_calendar_releaseFactory(Provider<MonthItemPresenter> provider) {
        this.a = provider;
    }

    public static StrCalendarRecyclerCommon_ProvideMonthItemBlueprint$str_calendar_releaseFactory create(Provider<MonthItemPresenter> provider) {
        return new StrCalendarRecyclerCommon_ProvideMonthItemBlueprint$str_calendar_releaseFactory(provider);
    }

    public static MonthItemBlueprint provideMonthItemBlueprint$str_calendar_release(MonthItemPresenter monthItemPresenter) {
        return (MonthItemBlueprint) Preconditions.checkNotNullFromProvides(StrCalendarRecyclerCommon.provideMonthItemBlueprint$str_calendar_release(monthItemPresenter));
    }

    @Override // javax.inject.Provider
    public MonthItemBlueprint get() {
        return provideMonthItemBlueprint$str_calendar_release(this.a.get());
    }
}
