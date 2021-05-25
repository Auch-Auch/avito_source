package com.avito.android.str_calendar.di.module;

import com.avito.android.str_calendar.calendar.view.konveyor.items.empty.EmptyItemBlueprint;
import com.avito.android.str_calendar.calendar.view.konveyor.items.empty.EmptyItemPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class StrCalendarRecyclerCommon_ProvideEmptyItemBlueprint$str_calendar_releaseFactory implements Factory<EmptyItemBlueprint> {
    public final Provider<EmptyItemPresenter> a;

    public StrCalendarRecyclerCommon_ProvideEmptyItemBlueprint$str_calendar_releaseFactory(Provider<EmptyItemPresenter> provider) {
        this.a = provider;
    }

    public static StrCalendarRecyclerCommon_ProvideEmptyItemBlueprint$str_calendar_releaseFactory create(Provider<EmptyItemPresenter> provider) {
        return new StrCalendarRecyclerCommon_ProvideEmptyItemBlueprint$str_calendar_releaseFactory(provider);
    }

    public static EmptyItemBlueprint provideEmptyItemBlueprint$str_calendar_release(EmptyItemPresenter emptyItemPresenter) {
        return (EmptyItemBlueprint) Preconditions.checkNotNullFromProvides(StrCalendarRecyclerCommon.provideEmptyItemBlueprint$str_calendar_release(emptyItemPresenter));
    }

    @Override // javax.inject.Provider
    public EmptyItemBlueprint get() {
        return provideEmptyItemBlueprint$str_calendar_release(this.a.get());
    }
}
