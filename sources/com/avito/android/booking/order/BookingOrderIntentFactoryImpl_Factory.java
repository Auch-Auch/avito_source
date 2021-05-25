package com.avito.android.booking.order;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class BookingOrderIntentFactoryImpl_Factory implements Factory<BookingOrderIntentFactoryImpl> {
    public final Provider<Context> a;

    public BookingOrderIntentFactoryImpl_Factory(Provider<Context> provider) {
        this.a = provider;
    }

    public static BookingOrderIntentFactoryImpl_Factory create(Provider<Context> provider) {
        return new BookingOrderIntentFactoryImpl_Factory(provider);
    }

    public static BookingOrderIntentFactoryImpl newInstance(Context context) {
        return new BookingOrderIntentFactoryImpl(context);
    }

    @Override // javax.inject.Provider
    public BookingOrderIntentFactoryImpl get() {
        return newInstance(this.a.get());
    }
}
