package com.avito.android.str_calendar.calendar.view.konveyor.items.day.booking;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class DayItemBlueprint_Factory implements Factory<DayItemBlueprint> {
    public final Provider<DayItemPresenter> a;

    public DayItemBlueprint_Factory(Provider<DayItemPresenter> provider) {
        this.a = provider;
    }

    public static DayItemBlueprint_Factory create(Provider<DayItemPresenter> provider) {
        return new DayItemBlueprint_Factory(provider);
    }

    public static DayItemBlueprint newInstance(DayItemPresenter dayItemPresenter) {
        return new DayItemBlueprint(dayItemPresenter);
    }

    @Override // javax.inject.Provider
    public DayItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
