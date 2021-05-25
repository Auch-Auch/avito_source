package com.avito.android.booking.remote.converter;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class BookingInfoActionConverterImpl_Factory implements Factory<BookingInfoActionConverterImpl> {
    public final Provider<Context> a;

    public BookingInfoActionConverterImpl_Factory(Provider<Context> provider) {
        this.a = provider;
    }

    public static BookingInfoActionConverterImpl_Factory create(Provider<Context> provider) {
        return new BookingInfoActionConverterImpl_Factory(provider);
    }

    public static BookingInfoActionConverterImpl newInstance(Context context) {
        return new BookingInfoActionConverterImpl(context);
    }

    @Override // javax.inject.Provider
    public BookingInfoActionConverterImpl get() {
        return newInstance(this.a.get());
    }
}
