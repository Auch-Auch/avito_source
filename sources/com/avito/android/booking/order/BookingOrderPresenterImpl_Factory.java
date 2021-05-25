package com.avito.android.booking.order;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class BookingOrderPresenterImpl_Factory implements Factory<BookingOrderPresenterImpl> {
    public final Provider<BookingOrderResourceProvider> a;

    public BookingOrderPresenterImpl_Factory(Provider<BookingOrderResourceProvider> provider) {
        this.a = provider;
    }

    public static BookingOrderPresenterImpl_Factory create(Provider<BookingOrderResourceProvider> provider) {
        return new BookingOrderPresenterImpl_Factory(provider);
    }

    public static BookingOrderPresenterImpl newInstance(BookingOrderResourceProvider bookingOrderResourceProvider) {
        return new BookingOrderPresenterImpl(bookingOrderResourceProvider);
    }

    @Override // javax.inject.Provider
    public BookingOrderPresenterImpl get() {
        return newInstance(this.a.get());
    }
}
