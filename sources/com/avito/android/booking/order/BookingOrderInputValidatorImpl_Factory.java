package com.avito.android.booking.order;

import dagger.internal.Factory;
public final class BookingOrderInputValidatorImpl_Factory implements Factory<BookingOrderInputValidatorImpl> {

    public static final class a {
        public static final BookingOrderInputValidatorImpl_Factory a = new BookingOrderInputValidatorImpl_Factory();
    }

    public static BookingOrderInputValidatorImpl_Factory create() {
        return a.a;
    }

    public static BookingOrderInputValidatorImpl newInstance() {
        return new BookingOrderInputValidatorImpl();
    }

    @Override // javax.inject.Provider
    public BookingOrderInputValidatorImpl get() {
        return newInstance();
    }
}
