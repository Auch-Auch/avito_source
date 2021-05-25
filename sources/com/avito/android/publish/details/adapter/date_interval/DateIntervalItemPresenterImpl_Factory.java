package com.avito.android.publish.details.adapter.date_interval;

import dagger.internal.Factory;
public final class DateIntervalItemPresenterImpl_Factory implements Factory<DateIntervalItemPresenterImpl> {

    public static final class a {
        public static final DateIntervalItemPresenterImpl_Factory a = new DateIntervalItemPresenterImpl_Factory();
    }

    public static DateIntervalItemPresenterImpl_Factory create() {
        return a.a;
    }

    public static DateIntervalItemPresenterImpl newInstance() {
        return new DateIntervalItemPresenterImpl();
    }

    @Override // javax.inject.Provider
    public DateIntervalItemPresenterImpl get() {
        return newInstance();
    }
}
