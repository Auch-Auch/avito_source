package com.avito.android.short_term_rent.start_booking;

import android.app.Application;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class StrBookingIntentFactoryImpl_Factory implements Factory<StrBookingIntentFactoryImpl> {
    public final Provider<Application> a;

    public StrBookingIntentFactoryImpl_Factory(Provider<Application> provider) {
        this.a = provider;
    }

    public static StrBookingIntentFactoryImpl_Factory create(Provider<Application> provider) {
        return new StrBookingIntentFactoryImpl_Factory(provider);
    }

    public static StrBookingIntentFactoryImpl newInstance(Application application) {
        return new StrBookingIntentFactoryImpl(application);
    }

    @Override // javax.inject.Provider
    public StrBookingIntentFactoryImpl get() {
        return newInstance(this.a.get());
    }
}
