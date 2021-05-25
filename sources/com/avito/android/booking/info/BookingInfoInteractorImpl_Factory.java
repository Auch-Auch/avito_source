package com.avito.android.booking.info;

import com.avito.android.booking.remote.BookingApi;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class BookingInfoInteractorImpl_Factory implements Factory<BookingInfoInteractorImpl> {
    public final Provider<BookingApi> a;

    public BookingInfoInteractorImpl_Factory(Provider<BookingApi> provider) {
        this.a = provider;
    }

    public static BookingInfoInteractorImpl_Factory create(Provider<BookingApi> provider) {
        return new BookingInfoInteractorImpl_Factory(provider);
    }

    public static BookingInfoInteractorImpl newInstance(BookingApi bookingApi) {
        return new BookingInfoInteractorImpl(bookingApi);
    }

    @Override // javax.inject.Provider
    public BookingInfoInteractorImpl get() {
        return newInstance(this.a.get());
    }
}
