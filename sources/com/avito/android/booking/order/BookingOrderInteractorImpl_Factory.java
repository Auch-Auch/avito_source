package com.avito.android.booking.order;

import com.avito.android.booking.remote.BookingApi;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class BookingOrderInteractorImpl_Factory implements Factory<BookingOrderInteractorImpl> {
    public final Provider<BookingApi> a;
    public final Provider<TypedErrorThrowableConverter> b;

    public BookingOrderInteractorImpl_Factory(Provider<BookingApi> provider, Provider<TypedErrorThrowableConverter> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static BookingOrderInteractorImpl_Factory create(Provider<BookingApi> provider, Provider<TypedErrorThrowableConverter> provider2) {
        return new BookingOrderInteractorImpl_Factory(provider, provider2);
    }

    public static BookingOrderInteractorImpl newInstance(BookingApi bookingApi, TypedErrorThrowableConverter typedErrorThrowableConverter) {
        return new BookingOrderInteractorImpl(bookingApi, typedErrorThrowableConverter);
    }

    @Override // javax.inject.Provider
    public BookingOrderInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
