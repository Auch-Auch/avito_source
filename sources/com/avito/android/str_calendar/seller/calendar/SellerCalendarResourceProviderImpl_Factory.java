package com.avito.android.str_calendar.seller.calendar;

import android.content.res.Resources;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SellerCalendarResourceProviderImpl_Factory implements Factory<SellerCalendarResourceProviderImpl> {
    public final Provider<Resources> a;

    public SellerCalendarResourceProviderImpl_Factory(Provider<Resources> provider) {
        this.a = provider;
    }

    public static SellerCalendarResourceProviderImpl_Factory create(Provider<Resources> provider) {
        return new SellerCalendarResourceProviderImpl_Factory(provider);
    }

    public static SellerCalendarResourceProviderImpl newInstance(Resources resources) {
        return new SellerCalendarResourceProviderImpl(resources);
    }

    @Override // javax.inject.Provider
    public SellerCalendarResourceProviderImpl get() {
        return newInstance(this.a.get());
    }
}
