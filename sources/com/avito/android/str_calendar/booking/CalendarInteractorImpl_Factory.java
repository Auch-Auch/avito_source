package com.avito.android.str_calendar.booking;

import com.avito.android.remote.ShortTermRentApi;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class CalendarInteractorImpl_Factory implements Factory<CalendarInteractorImpl> {
    public final Provider<ShortTermRentApi> a;
    public final Provider<SchedulersFactory> b;
    public final Provider<TypedErrorThrowableConverter> c;

    public CalendarInteractorImpl_Factory(Provider<ShortTermRentApi> provider, Provider<SchedulersFactory> provider2, Provider<TypedErrorThrowableConverter> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static CalendarInteractorImpl_Factory create(Provider<ShortTermRentApi> provider, Provider<SchedulersFactory> provider2, Provider<TypedErrorThrowableConverter> provider3) {
        return new CalendarInteractorImpl_Factory(provider, provider2, provider3);
    }

    public static CalendarInteractorImpl newInstance(ShortTermRentApi shortTermRentApi, SchedulersFactory schedulersFactory, TypedErrorThrowableConverter typedErrorThrowableConverter) {
        return new CalendarInteractorImpl(shortTermRentApi, schedulersFactory, typedErrorThrowableConverter);
    }

    @Override // javax.inject.Provider
    public CalendarInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
