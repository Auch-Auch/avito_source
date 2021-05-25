package com.avito.android.booking.order;

import android.content.res.Resources;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class BookingOrderResourceProviderImpl_Factory implements Factory<BookingOrderResourceProviderImpl> {
    public final Provider<Resources> a;

    public BookingOrderResourceProviderImpl_Factory(Provider<Resources> provider) {
        this.a = provider;
    }

    public static BookingOrderResourceProviderImpl_Factory create(Provider<Resources> provider) {
        return new BookingOrderResourceProviderImpl_Factory(provider);
    }

    public static BookingOrderResourceProviderImpl newInstance(Resources resources) {
        return new BookingOrderResourceProviderImpl(resources);
    }

    @Override // javax.inject.Provider
    public BookingOrderResourceProviderImpl get() {
        return newInstance(this.a.get());
    }
}
