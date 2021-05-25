package com.avito.android.booking.info;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class BookingInfoIntentFactoryImpl_Factory implements Factory<BookingInfoIntentFactoryImpl> {
    public final Provider<Context> a;

    public BookingInfoIntentFactoryImpl_Factory(Provider<Context> provider) {
        this.a = provider;
    }

    public static BookingInfoIntentFactoryImpl_Factory create(Provider<Context> provider) {
        return new BookingInfoIntentFactoryImpl_Factory(provider);
    }

    public static BookingInfoIntentFactoryImpl newInstance(Context context) {
        return new BookingInfoIntentFactoryImpl(context);
    }

    @Override // javax.inject.Provider
    public BookingInfoIntentFactoryImpl get() {
        return newInstance(this.a.get());
    }
}
