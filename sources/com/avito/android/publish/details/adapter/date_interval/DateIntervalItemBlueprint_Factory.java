package com.avito.android.publish.details.adapter.date_interval;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class DateIntervalItemBlueprint_Factory implements Factory<DateIntervalItemBlueprint> {
    public final Provider<DateIntervalItemPresenter> a;

    public DateIntervalItemBlueprint_Factory(Provider<DateIntervalItemPresenter> provider) {
        this.a = provider;
    }

    public static DateIntervalItemBlueprint_Factory create(Provider<DateIntervalItemPresenter> provider) {
        return new DateIntervalItemBlueprint_Factory(provider);
    }

    public static DateIntervalItemBlueprint newInstance(DateIntervalItemPresenter dateIntervalItemPresenter) {
        return new DateIntervalItemBlueprint(dateIntervalItemPresenter);
    }

    @Override // javax.inject.Provider
    public DateIntervalItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
