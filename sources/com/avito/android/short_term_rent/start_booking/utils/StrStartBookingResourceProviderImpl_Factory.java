package com.avito.android.short_term_rent.start_booking.utils;

import android.content.res.Resources;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class StrStartBookingResourceProviderImpl_Factory implements Factory<StrStartBookingResourceProviderImpl> {
    public final Provider<Resources> a;

    public StrStartBookingResourceProviderImpl_Factory(Provider<Resources> provider) {
        this.a = provider;
    }

    public static StrStartBookingResourceProviderImpl_Factory create(Provider<Resources> provider) {
        return new StrStartBookingResourceProviderImpl_Factory(provider);
    }

    public static StrStartBookingResourceProviderImpl newInstance(Resources resources) {
        return new StrStartBookingResourceProviderImpl(resources);
    }

    @Override // javax.inject.Provider
    public StrStartBookingResourceProviderImpl get() {
        return newInstance(this.a.get());
    }
}
