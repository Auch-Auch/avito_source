package com.avito.android.short_term_rent.confirm_booking.utils;

import android.content.res.Resources;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class StrConfirmBookingResourceProviderImpl_Factory implements Factory<StrConfirmBookingResourceProviderImpl> {
    public final Provider<Resources> a;
    public final Provider<String> b;

    public StrConfirmBookingResourceProviderImpl_Factory(Provider<Resources> provider, Provider<String> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static StrConfirmBookingResourceProviderImpl_Factory create(Provider<Resources> provider, Provider<String> provider2) {
        return new StrConfirmBookingResourceProviderImpl_Factory(provider, provider2);
    }

    public static StrConfirmBookingResourceProviderImpl newInstance(Resources resources, String str) {
        return new StrConfirmBookingResourceProviderImpl(resources, str);
    }

    @Override // javax.inject.Provider
    public StrConfirmBookingResourceProviderImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
