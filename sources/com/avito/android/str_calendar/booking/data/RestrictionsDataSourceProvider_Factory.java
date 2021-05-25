package com.avito.android.str_calendar.booking.data;

import dagger.internal.Factory;
import java.util.Date;
import javax.inject.Provider;
public final class RestrictionsDataSourceProvider_Factory implements Factory<RestrictionsDataSourceProvider> {
    public final Provider<Date> a;
    public final Provider<Date> b;

    public RestrictionsDataSourceProvider_Factory(Provider<Date> provider, Provider<Date> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static RestrictionsDataSourceProvider_Factory create(Provider<Date> provider, Provider<Date> provider2) {
        return new RestrictionsDataSourceProvider_Factory(provider, provider2);
    }

    public static RestrictionsDataSourceProvider newInstance(Date date, Date date2) {
        return new RestrictionsDataSourceProvider(date, date2);
    }

    @Override // javax.inject.Provider
    public RestrictionsDataSourceProvider get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
