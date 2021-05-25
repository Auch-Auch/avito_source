package com.avito.android.str_calendar.booking;

import android.content.res.Resources;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class CalendarResourceProviderImpl_Factory implements Factory<CalendarResourceProviderImpl> {
    public final Provider<Resources> a;

    public CalendarResourceProviderImpl_Factory(Provider<Resources> provider) {
        this.a = provider;
    }

    public static CalendarResourceProviderImpl_Factory create(Provider<Resources> provider) {
        return new CalendarResourceProviderImpl_Factory(provider);
    }

    public static CalendarResourceProviderImpl newInstance(Resources resources) {
        return new CalendarResourceProviderImpl(resources);
    }

    @Override // javax.inject.Provider
    public CalendarResourceProviderImpl get() {
        return newInstance(this.a.get());
    }
}
