package com.avito.android.booking.di.module;

import com.avito.android.booking.remote.BookingApi;
import com.avito.android.remote.RetrofitFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class BookingApiModule_ProvideBookingApiFactory implements Factory<BookingApi> {
    public final Provider<RetrofitFactory> a;

    public BookingApiModule_ProvideBookingApiFactory(Provider<RetrofitFactory> provider) {
        this.a = provider;
    }

    public static BookingApiModule_ProvideBookingApiFactory create(Provider<RetrofitFactory> provider) {
        return new BookingApiModule_ProvideBookingApiFactory(provider);
    }

    public static BookingApi provideBookingApi(RetrofitFactory retrofitFactory) {
        return (BookingApi) Preconditions.checkNotNullFromProvides(BookingApiModule.INSTANCE.provideBookingApi(retrofitFactory));
    }

    @Override // javax.inject.Provider
    public BookingApi get() {
        return provideBookingApi(this.a.get());
    }
}
