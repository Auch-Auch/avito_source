package com.avito.android.user_advert.advert.autobooking_block;

import com.avito.android.booking.remote.BookingApi;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AutoBookingChangeStateInteractor_Factory implements Factory<AutoBookingChangeStateInteractor> {
    public final Provider<BookingApi> a;

    public AutoBookingChangeStateInteractor_Factory(Provider<BookingApi> provider) {
        this.a = provider;
    }

    public static AutoBookingChangeStateInteractor_Factory create(Provider<BookingApi> provider) {
        return new AutoBookingChangeStateInteractor_Factory(provider);
    }

    public static AutoBookingChangeStateInteractor newInstance(BookingApi bookingApi) {
        return new AutoBookingChangeStateInteractor(bookingApi);
    }

    @Override // javax.inject.Provider
    public AutoBookingChangeStateInteractor get() {
        return newInstance(this.a.get());
    }
}
