package com.avito.android.booking.remote.converter;

import dagger.internal.Factory;
public final class BookingInfoItemConverterImpl_Factory implements Factory<BookingInfoItemConverterImpl> {

    public static final class a {
        public static final BookingInfoItemConverterImpl_Factory a = new BookingInfoItemConverterImpl_Factory();
    }

    public static BookingInfoItemConverterImpl_Factory create() {
        return a.a;
    }

    public static BookingInfoItemConverterImpl newInstance() {
        return new BookingInfoItemConverterImpl();
    }

    @Override // javax.inject.Provider
    public BookingInfoItemConverterImpl get() {
        return newInstance();
    }
}
