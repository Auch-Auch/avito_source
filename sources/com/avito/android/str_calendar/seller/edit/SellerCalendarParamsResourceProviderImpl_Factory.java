package com.avito.android.str_calendar.seller.edit;

import android.content.res.Resources;
import dagger.internal.Factory;
import java.util.Date;
import javax.inject.Provider;
public final class SellerCalendarParamsResourceProviderImpl_Factory implements Factory<SellerCalendarParamsResourceProviderImpl> {
    public final Provider<Date> a;
    public final Provider<Date> b;
    public final Provider<Resources> c;

    public SellerCalendarParamsResourceProviderImpl_Factory(Provider<Date> provider, Provider<Date> provider2, Provider<Resources> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static SellerCalendarParamsResourceProviderImpl_Factory create(Provider<Date> provider, Provider<Date> provider2, Provider<Resources> provider3) {
        return new SellerCalendarParamsResourceProviderImpl_Factory(provider, provider2, provider3);
    }

    public static SellerCalendarParamsResourceProviderImpl newInstance(Date date, Date date2, Resources resources) {
        return new SellerCalendarParamsResourceProviderImpl(date, date2, resources);
    }

    @Override // javax.inject.Provider
    public SellerCalendarParamsResourceProviderImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
