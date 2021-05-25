package com.avito.android.str_calendar.calendar.view.konveyor;

import dagger.internal.Factory;
public final class CalendarViewTypeProviderImpl_Factory implements Factory<CalendarViewTypeProviderImpl> {

    public static final class a {
        public static final CalendarViewTypeProviderImpl_Factory a = new CalendarViewTypeProviderImpl_Factory();
    }

    public static CalendarViewTypeProviderImpl_Factory create() {
        return a.a;
    }

    public static CalendarViewTypeProviderImpl newInstance() {
        return new CalendarViewTypeProviderImpl();
    }

    @Override // javax.inject.Provider
    public CalendarViewTypeProviderImpl get() {
        return newInstance();
    }
}
